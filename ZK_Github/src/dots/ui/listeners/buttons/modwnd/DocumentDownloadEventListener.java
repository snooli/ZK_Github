package dots.ui.listeners.buttons.modwnd;

import java.io.File;
import java.util.UUID;

import dots.ui.helpers.RecordsUIHelper;
import dots.ui.dotsClient.dotsClient;
import dots.module.base.entitybeans.DocumentDescriptionBean;
import dots.module.base.entitybeans.DocumentObjectBean;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.api.Label;

public class DocumentDownloadEventListener implements EventListener {

	@Override
	public void onEvent(Event event) throws Exception {

		try {
			processEvent(event);

			// close the modal window
			RecordsUIHelper.closeViewDocumentWindow();

		} catch (Exception ex) {

			ex.printStackTrace();

			// close the modal window
			RecordsUIHelper.closeViewDocumentWindow();

			// show an error message
			Messagebox.show("An error occurred while getting the attachment.",
					"Warning", Messagebox.OK, Messagebox.EXCLAMATION);
		}

	}

	private void processEvent(Event event) throws Exception {

		// get the document description system ID
		String ddSystemId = ((Label) event.getTarget().getFellow(
				"documentDescriptionSystemId")).getValue();

		// get the document description
		DocumentDescriptionBean dd = dotsClient.get().getSearchService()
				.documentDescriptionFindBySystemId(ddSystemId);

		// get the document object
		DocumentObjectBean dobj = dotsClient.get().getBaseService()
				.documentDescriptionGetDocumentObjects(ddSystemId).get(0);

		// get the document
		String base64Content = dotsClient.get().getBaseService()
				.documentGet(ddSystemId);

		// decode the document
		byte[] content = Base64.decodeBase64(base64Content);

		// create a temporary file and write the content to it
		File tempFile = File.createTempFile(UUID.randomUUID().toString(), "."
				+ dobj.getFormat());
		FileUtils.writeByteArrayToFile(tempFile, content);

		// allow users to download the file
		Filedownload.save(tempFile, dd.getDocumentType());
	}
}
