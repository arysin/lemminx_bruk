package ua.net.nlp.lemminx_bruk;

import java.util.Arrays;

import org.eclipse.lemminx.services.extensions.completion.CompletionParticipantAdapter;
import org.eclipse.lemminx.services.extensions.completion.ICompletionRequest;
import org.eclipse.lemminx.services.extensions.completion.ICompletionResponse;
import org.eclipse.lsp4j.CompletionItem;
import org.eclipse.lsp4j.CompletionItemKind;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.TextEdit;
import org.eclipse.lsp4j.jsonrpc.CancelChecker;
import org.eclipse.lsp4j.jsonrpc.messages.Either;

final class CompletionParticipant extends CompletionParticipantAdapter {
	
		@Override
		public void onAttributeValue(String valuePrefix, ICompletionRequest request, ICompletionResponse response,
				CancelChecker cancelChecker) throws Exception {
//				super.onAttributeValue(valuePrefix, request, response, cancelChecker);
			
			int sortText = 1;
			for (String option : Arrays.asList("1x", "2x", "3x")) {
				String insertText = request.getInsertAttrValue(option);
				
				CompletionItem item = new CompletionItem();
				item.setLabel(option);
				item.setFilterText(insertText);
				item.setKind(CompletionItemKind.Text);
				Range editRange = request.getReplaceRange();
				item.setTextEdit(Either.forLeft(new TextEdit(editRange, insertText)));
//					item.setTextEditText(insertText);
				item.setSortText(Integer.toString(sortText));
				sortText++;
				response.addCompletionItem(item);
			}
		}
	}