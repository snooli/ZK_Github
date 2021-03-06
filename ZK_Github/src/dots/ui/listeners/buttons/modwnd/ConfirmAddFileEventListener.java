package dots.ui.listeners.buttons.modwnd;

import dots.clb.common.constants.N5Status;
import dots.ui.helpers.FilesUIHelper;
import dots.ui.helpers.SeriesUIHelper;
import dots.ui.dotsClient.dotsClient;
import dots.module.base.beans.Result;
import dots.module.base.entitybeans.CaseFileBean;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

public class ConfirmAddFileEventListener implements EventListener {

	@Override
	public void onEvent(Event event) throws Exception {

		try {
			processEvent(event);

			// close the modal window
			FilesUIHelper.closeAddFileWindow();

		} catch (Exception ex) {

			ex.printStackTrace();

			// close the modal window
			FilesUIHelper.closeAddFileWindow();

			// show an error message
			Messagebox.show("Could not add file.", "Warning", Messagebox.OK,
					Messagebox.EXCLAMATION);
		}

	}

	private void processEvent(Event event) throws Exception {

		// get the ID of the selected series
		String seriesSystemId = SeriesUIHelper.getSelectedSeries().getId();

		// get the file title
		String title = ((Textbox) event.getTarget().getFellow("fileTitle"))
				.getText();

		// get the file public title
		String officialTitle = ((Textbox) event.getTarget().getFellow(
				"fileOfficialTitle")).getText();

		// get the file description
		String description = ((Textbox) event.getTarget().getFellow(
				"fileDescription")).getText();

		// get the file document medium
		String medium = (String) ((Combobox) event.getTarget().getFellow(
				"fileMedium")).getSelectedItem().getValue();
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
				.caseFileCreate(seriesSystemId, null, title, officialTitle,
						description, documentMedium, "system");

		// add the newly created file to the files tree
		CaseFileBean file = dotsClient.get().getSearchService()
				.caseFileFindBySystemId(result.getMessage());

		FilesUIHelper.addFileToTree(file.getOfficialTitle(),
				file.getSystemId(), null);
	}

}
