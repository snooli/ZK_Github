package n5.ui.listeners.buttons.mainwnd;

import n5.ui.helpers.FondsUIHelper;
import n5.ui.helpers.ModalWindowHelper;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Messagebox;

public class AddSeriesEventListener implements EventListener {

	@Override
	public void onEvent(Event event) throws Exception {

		// no selected fonds
		if (!FondsUIHelper.isFondsSelected()) {
			// show an error message
			Messagebox.show("Select a Fonds first.", "Warning", Messagebox.OK,
					Messagebox.EXCLAMATION);
		} else {

			// fonds has subfonds
			if (FondsUIHelper.hasSelectedFondsChildren()) {
				// show an error message
				Messagebox.show("Cannot add a Series to this Fonds", "Warning",
						Messagebox.OK, Messagebox.EXCLAMATION);
			} else {
				ModalWindowHelper.openWindow("add_series.zul");
			}

		}

	}

}
