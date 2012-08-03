package dots.ui.listeners.buttons.modwnd;

import java.io.File;

import dots.clb.common.constants.N5Status;
import dots.ui.helpers.RecordsUIHelper;
import dots.ui.dotsClient.dotsClient;
import dots.module.base.beans.Result;
import dots.module.base.entitybeans.DocumentDescriptionBean;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.api.Label;
import org.zkoss.zul.api.Treeitem;

public class ConfirmAddDocumentEventListener implements EventListener {

	@Override
	public void onEvent(Event event) throws Exception {

		try {
			processEvent(event);

			// close the modal window
			RecordsUIHelper.closeAddDocumentWindow();

		} catch (Exception ex) {

			ex.printStackTrace();

			// close the modal window
			RecordsUIHelper.closeAddDocumentWindow();

			// show an error message
			Messagebox.show("Could not add document.", "Warning",
					Messagebox.OK, Messagebox.EXCLAMATION);
		}

	}

	private void processEvent(Event event) throws Exception {

		String tempFilePath = ((Label) event.getTarget().getFellow("tempFile"))
				.getValue();

		String fileExtension = ((Label) event.getTarget()
				.getFellow("extension")).getValue();

		String contentType = ((Label) event.getTarget()
				.getFellow("contentType")).getValue();

		if (tempFilePath == null || tempFilePath.equalsIgnoreCase("")) {

			// show an error message
			Messagebox.show("Add an attachment first.", "Warning",
					Messagebox.OK, Messagebox.EXCLAMATION);

		} else {
			File tempFile = new File(tempFilePath);

			// get the selected record and its ID
			Treeitem selectedRecord = RecordsUIHelper.getSelectedRecord();
			String recordSystemId = selectedRecord.getId();

			// get the document title
			String title = ((Textbox) event.getTarget().getFellow(
					"documentTitle")).getText();

			// get the document description
			String description = ((Textbox) event.getTarget().getFellow(
					"documentDescription")).getText();

			// encode the file
			String base64Content = Base64.encodeBase64String(FileUtils
					.readFileToByteArray(tempFile));

			// create a new document
			Result result = dotsClient
					.get()
					.getBaseService()
					.documentCreate(recordSystemId, contentType, title,
							description, "system",
							N5Status.DocumentMedium.ELECTRONIC, base64Content,
							fileExtension, fileExtension);

			// add the newly created document description to the tree
			DocumentDescriptionBean dd = dotsClient.get().getSearchService()
					.documentDescriptionFindBySystemId(result.getMessage());

			RecordsUIHelper.addDocumentToTree(dd.getTitle(), dd.getSystemId(),
					selectedRecord);

			// delete the temporary file
			tempFile.delete();
		}

	}
}
