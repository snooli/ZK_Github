package dots.ui.listeners.buttons.mainwnd;

import dots.ui.helpers.FondsUIHelper;
import dots.ui.helpers.ModalWindowHelper;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Messagebox;

public class AddSubfondsEventListener implements EventListener {

	@Override
	public void onEvent(Event event) throws Exception {

		// no selected Fonds
		if (!FondsUIHelper.isFondsSelected()) {
			// show an error message
			Messagebox.show("Select a parent Fonds first.", "Warning",
					Messagebox.OK, Messagebox.EXCLAMATION);

		} else if (FondsUIHelper.hasSelectedFondsSeries()) {
			// show an error message
			Messagebox.show("Cannot add a subfonds.", "Warning", Messagebox.OK,
					Messagebox.EXCLAMATION);
		} else {
			ModalWindowHelper.openWindow("add_subfonds.zul");
		}

	}

}
