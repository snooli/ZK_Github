package n5.ui.listeners.buttons.modwnd;

import dots.clb.common.constants.N5Status;
import n5.ui.config.Config;
import n5.ui.helpers.FondsUIHelper;
import n5.ui.n5client.N5Client;
import dots.module.base.beans.Result;
import dots.module.base.entitybeans.FondsBean;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

public class ConfirmAddFondsEventListener implements EventListener {

	@Override
	public void onEvent(Event event) throws Exception {

		try {
			processEvent(event);

			// close the modal window
			FondsUIHelper.closeAddFondsWindow();

		} catch (Exception ex) {

			ex.printStackTrace();

			// close the modal window
			FondsUIHelper.closeAddFondsWindow();

			// show an error message
			Messagebox.show("Could not add fonds.", "Warning", Messagebox.OK,
					Messagebox.EXCLAMATION);
		}

	}

	private void processEvent(Event event) throws Exception {

		// get the fonds title
		String title = ((Textbox) event.getTarget().getFellow("fondsTitle"))
				.getText();

		// get the fonds description
		String description = ((Textbox) event.getTarget().getFellow(
				"fondsDescription")).getText();

		// get the fonds document medium
		String medium = (String) ((Combobox) event.getTarget().getFellow(
				"fondsMedium")).getSelectedItem().getValue();
		String documentMedium = null;

		if (medium.equalsIgnoreCase("electronic")) {
			documentMedium = N5Status.DocumentMedium.ELECTRONIC;
		} else if (medium.equalsIgnoreCase("physical")) {
			documentMedium = N5Status.DocumentMedium.PHYSICAL;
		} else if (medium.equalsIgnoreCase("mixed")) {
			documentMedium = N5Status.DocumentMedium.MIXED;
		}

		// create the fonds
		Result result = N5Client
				.get()
				.getBaseService()
				.fondsCreate(Config.get().getFondsCreatorId(), null, title,
						description, documentMedium, "system");

		// add the newly created fonds to the fonds tree
		FondsBean fonds = N5Client.get().getSearchService()
				.fondsFindBySystemId(result.getMessage());

		FondsUIHelper.addFondsToTree(fonds.getTitle(), fonds.getSystemId(),
				null);
	}

}
