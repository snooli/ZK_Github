package n5.ui.listeners.buttons.mainwnd;

import n5.ui.helpers.ModalWindowHelper;
import n5.ui.helpers.SeriesUIHelper;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Messagebox;

public class AddFileEventListener implements EventListener {

	@Override
	public void onEvent(Event event) throws Exception {

		// no selected series
		if (!SeriesUIHelper.isSeriesSelected()) {
			// show an error message
			Messagebox.show("Select a Series first.", "Warning", Messagebox.OK,
					Messagebox.EXCLAMATION);
		} else {
			ModalWindowHelper.openWindow("add_file.zul");
		}

	}

}
