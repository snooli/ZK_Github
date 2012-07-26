package n5.ui.listeners.buttons.modwnd;

import dots.clb.common.constants.N5Status;
import n5.ui.helpers.FilesUIHelper;
import n5.ui.helpers.RecordsUIHelper;
import n5.ui.n5client.N5Client;
import dots.module.base.beans.Result;
import dots.module.base.entitybeans.RegistryEntryBean;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

public class ConfirmAddRecordEventListener implements EventListener {

	@Override
	public void onEvent(Event event) throws Exception {

		try {
			processEvent(event);

			// close the modal window
			RecordsUIHelper.closeAddRecordWindow();

		} catch (Exception ex) {

			ex.printStackTrace();

			// close the modal window
			RecordsUIHelper.closeAddRecordWindow();

			// show an error message
			Messagebox.show("Could not add record.", "Warning", Messagebox.OK,
					Messagebox.EXCLAMATION);
		}

	}

	private void processEvent(Event event) throws Exception {

		String fileSystemId = FilesUIHelper.getSelectedFile().getId();

		// get the record title
		String title = ((Textbox) event.getTarget().getFellow("recordTitle"))
				.getText();

		// get the record public
		String officialTitle = ((Textbox) event.getTarget().getFellow(
				"recordOfficialTitle")).getText();

		// get the record description
		String description = ((Textbox) event.getTarget().getFellow(
				"recordDescription")).getText();

		// get the record document medium
		String medium = (String) ((Combobox) event.getTarget().getFellow(
				"recordMedium")).getSelectedItem().getValue();
		String documentMedium = null;

		if (medium.equalsIgnoreCase("electronic")) {
			documentMedium = N5Status.DocumentMedium.ELECTRONIC;
		} else if (medium.equalsIgnoreCase("physical")) {
			documentMedium = N5Status.DocumentMedium.PHYSICAL;
		} else if (medium.equalsIgnoreCase("mixed")) {
			documentMedium = N5Status.DocumentMedium.MIXED;
		}

		// create a new record
		Result result = N5Client
				.get()
				.getBaseService()
				.registryEntryCreate(fileSystemId, title, officialTitle,
						description, documentMedium, "system");

		// add the newly created record to the tree
		RegistryEntryBean record = N5Client.get().getSearchService()
				.registryEntryFindBySystemId(result.getMessage());

		RecordsUIHelper.addRecordToTree(record.getOfficialTitle(),
				record.getSystemId());
	}
}
