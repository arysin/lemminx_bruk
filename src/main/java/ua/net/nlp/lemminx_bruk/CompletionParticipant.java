package ua.net.nlp.lemminx_bruk;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.lemminx.dom.DOMNode;
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
		private LtHelper ltHelper = new LtHelper();
	
		@Override
		public void onAttributeValue(String valuePrefix, ICompletionRequest request, ICompletionResponse response,
				CancelChecker cancelChecker) throws Exception {

			DOMNode node = request.getNode();
			String attr = request.getCurrentAttributeName();
			
			List<String> list = getCompletions(request, node, attr);
			
			if( StringUtils.isNotBlank(valuePrefix) ) {
				list = list.stream().filter(s -> s.startsWith(valuePrefix) ).toList();
			}
			
			System.err.println("==" + list);
			
			for(String option: list) {
				int sortText = 1;

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
		
		private List<String> getCompletions(ICompletionRequest request, DOMNode node, String attr) throws IOException {
			String value = node.getAttribute("value");

			if( ! "tags".equals(attr) && ! "lemma".equals(attr) )
				return new ArrayList<>();
			
			if( StringUtils.isBlank(value) || ! value.matches("[а-яіїєґА-ЯІЇЄҐ].*") )
				return new ArrayList<>();

			return ltHelper.getSuggestions(node, attr, value);
		}
}
