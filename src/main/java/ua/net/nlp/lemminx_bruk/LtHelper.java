package ua.net.nlp.lemminx_bruk;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.eclipse.lemminx.dom.DOMNode;

public class LtHelper {
//	private JLanguageTool lt = new JLanguageTool(Languages.getLanguageForShortCode("uk"), new ArrayList<>(), null, null, null, null);
//	private Ukrainian ukrainian = (Ukrainian) lt.getLanguage();
//    private UkrainianTagger ukTagger = (UkrainianTagger) ukrainian.getTagger();
//
//	public List<String> getSuggestions(DOMNode node, String attr, String value) throws IOException {
//		AnalyzedTokenReadings tagged = ukTagger.tag(Arrays.asList(value)).get(0);
//
//		if( "tags".equals(attr) ) { 
//			String lemma = node.getAttribute("lemma");
//
//			return tagged.getReadings().stream()
//					.filter(r -> StringUtils.isBlank(lemma) || lemma.equals(r.getLemma()))
//					.map(r -> escape(r.getPOSTag()))
//					.distinct()
//					.toList();
//		}
//
//		if( "lemma".equals(attr) ) 
//			return tagged.getReadings().stream()
//					.map(r -> r.getLemma())
//					.distinct()
//					.toList();
//		
//		return new ArrayList<>();
//	}
//
//	private String escape(String posTag) {
//		return posTag.replace("&", "&amp;");
//	}

	public List<String> getSuggestions(DOMNode node, String attr, String value) throws IOException {
		return Arrays.asList("x1", "x2", "x3");
	}	
}
