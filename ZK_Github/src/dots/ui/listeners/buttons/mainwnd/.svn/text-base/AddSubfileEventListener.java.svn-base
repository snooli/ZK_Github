package n5.ui.listeners.buttons.mainwnd;

import n5.ui.helpers.FilesUIHelper;
import n5.ui.helpers.ModalWindowHelper;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Messagebox;

public class AddSubfileEventListener implements EventListener {

	@Override
	public void onEvent(Event event) throws Exception {

		// no selected File
		if (!FilesUIHelper.isFileSelected()) {

			// show an error message
			Messagebox.show("Select a parent File first.", "Warning",
					Messagebox.OK, Messagebox.EXCLAMATION);
		} else {

			// file has records
			if (FilesUIHelper.hasSelectedFileRecords()) {
				// show an error message
				Messagebox.show("Cannot add a Subfile to this File", "Warning",
						Messagebox.OK, Messagebox.EXCLAMATION);
			} else {
				ModalWindowHelper.openWindow("add_subfile.zul");
			}

		}

	}

}
