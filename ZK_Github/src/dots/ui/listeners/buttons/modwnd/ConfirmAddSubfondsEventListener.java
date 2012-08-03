package dots.ui.listeners.buttons.modwnd;

import dots.clb.common.constants.N5Status;
import dots.ui.config.Config;
import dots.ui.helpers.FondsUIHelper;
import dots.ui.dotsClient.dotsClient;
import dots.module.base.beans.Result;
import dots.module.base.entitybeans.FondsBean;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.api.Treeitem;

public class ConfirmAddSubfondsEventListener implements EventListener {

	@Override
	public void onEvent(Event event) throws Exception {

		try {
			processEvent(event);

			// close the modal window
			FondsUIHelper.closeAddSubfondsWindow();

		} catch (Exception ex) {

			ex.printStackTrace();

			// close the modal window
			FondsUIHelper.closeAddSubfondsWindow();

			// show an error message
			Messagebox.show("Could not add subfonds.", "Warning",
					Messagebox.OK, Messagebox.EXCLAMATION);
		}

	}

	private void processEvent(Event event) throws Exception {

		// get the system ID of the selected Fonds
		Treeitem selectedFonds = FondsUIHelper.getSelectedFonds();
		String parentFondsSystemId = selectedFonds.getId();

		// get the subfonds title
		String title = ((Textbox) event.getTarget().getFellow("subfondsTitle"))
				.getText();

		// get the subfonds description
		String description = ((Textbox) event.getTarget().getFellow(
				"subfondsDescription")).getText();

		// get the subfonds document medium
		String medium = (String) ((Combobox) event.getTarget().getFellow(
				"subfondsMedium")).getSelectedItem().getValue();
		String documentMedium = null;

		if (medium.equalsIgnoreCase("electronic")) {
			documentMedium = N5Status.DocumentMedium.ELECTRONIC;
		} else if (medium.equalsIgnoreCase("physical")) {
			documentMedium = N5Status.DocumentMedium.PHYSICAL;
		} else if (medium.equalsIgnoreCase("mixed")) {
			documentMedium = N5Status.DocumentMedium.MIXED;
		}

		// create the subfonds
		Result result = dotsClient
				.get()
				.getBaseService()
				.fondsCreate(Config.get().getFondsCreatorId(),
						parentFondsSystemId, title, description,
						documentMedium, "system");

		// add the newly created fonds to the tree
		FondsBean fonds = dotsClient.get().getSearchService()
				.fondsFindBySystemId(result.getMessage());

		FondsUIHelper.addFondsToTree(fonds.getTitle(), fonds.getSystemId(),
				selectedFonds);
	}

}
