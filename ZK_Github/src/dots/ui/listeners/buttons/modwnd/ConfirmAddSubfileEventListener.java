package dots.ui.listeners.buttons.modwnd;

import dots.clb.common.constants.N5Status;
import dots.ui.helpers.FilesUIHelper;
import dots.ui.dotsClient.dotsClient;
import dots.module.base.beans.Result;
import dots.module.base.entitybeans.CaseFileBean;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

public class ConfirmAddSubfileEventListener implements EventListener {

	@Override
	public void onEvent(Event event) throws Exception {

		try {
			processEvent(event);

			// close the modal window
			FilesUIHelper.closeAddSubfileWindow();

		} catch (Exception ex) {

			ex.printStackTrace();

			// close the modal window
			FilesUIHelper.closeAddSubfileWindow();

			// show an error message
			Messagebox.show("Could not add subfile.", "Warning", Messagebox.OK,
					Messagebox.EXCLAMATION);
		}

	}

	private void processEvent(Event event) throws Exception {

		// get the ID of the selected file
		String parentSystemId = FilesUIHelper.getSelectedFile().getId();

		// get the file title
		String title = ((Textbox) event.getTarget().getFellow("subfileTitle"))
				.getText();

		// get the file public title
		String officialTitle = ((Textbox) event.getTarget().getFellow(
				"subfileOfficialTitle")).getText();

		// get the file description
		String description = ((Textbox) event.getTarget().getFellow(
				"subfileDescription")).getText();

		// get the file document medium
		String medium = (String) ((Combobox) event.getTarget().getFellow(
				"subfileMedium")).getSelectedItem().getValue();
		String documentMedium = null;

		if (medium.equalsIgnoreCase("electronic")) {
			documentMedium = N5Status.DocumentMedium.ELECTRONIC;
		} else if (medium.equalsIgnoreCase("physical")) {
			documentMedium = N5Status.DocumentMedium.PHYSICAL;
		} else if (medium.equalsIgnoreCase("mixed")) {
			documentMedium = N5Status.DocumentMedium.MIXED;
		}

		// create the file
		Result result = dotsClient
				.get()
				.getBaseService()
				.caseFileCreate(null, parentSystemId, title, officialTitle,
						description, documentMedium, "system");

		// add the newly created file to the files tree
		CaseFileBean file = dotsClient.get().getSearchService()
				.caseFileFindBySystemId(result.getMessage());

		FilesUIHelper.addFileToTree(file.getOfficialTitle(),
				file.getSystemId(), FilesUIHelper.getSelectedFile());
	}

}
