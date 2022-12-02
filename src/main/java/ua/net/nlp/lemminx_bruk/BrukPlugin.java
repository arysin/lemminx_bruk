package ua.net.nlp.lemminx_bruk;

import org.eclipse.lemminx.services.extensions.IXMLExtension;
import org.eclipse.lemminx.services.extensions.XMLExtensionsRegistry;
import org.eclipse.lemminx.services.extensions.completion.CompletionParticipantAdapter;
import org.eclipse.lemminx.services.extensions.save.ISaveContext;
import org.eclipse.lsp4j.InitializeParams;

public class BrukPlugin implements IXMLExtension {
//	private Logger logger = Logger.getLogger(getClass().getName());
	
	private CompletionParticipantAdapter completionParticipant;

	public BrukPlugin() {
		System.out.println("======= bruk extention created");
		
		completionParticipant = new CompletionParticipant();
	}
	
	@Override
	public void doSave(ISaveContext context) {
		// Called when settings or XML document are saved.
	}

	@Override
	public void start(InitializeParams params, XMLExtensionsRegistry registry) {
		// Register here completion, hover, etc participants

		System.out.println("======= bruk extention started");

		registry.registerCompletionParticipant(completionParticipant);
	}

	@Override
	public void stop(XMLExtensionsRegistry registry) {
		registry.unregisterCompletionParticipant(completionParticipant);
	}
}