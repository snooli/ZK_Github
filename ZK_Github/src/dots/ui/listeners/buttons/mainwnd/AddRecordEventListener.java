package dots.ui.listeners.buttons.mainwnd;

import dots.ui.helpers.FilesUIHelper;
import dots.ui.helpers.ModalWindowHelper;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Messagebox;

public class AddRecordEventListener implements EventListener {

	@Override
	public void onEvent(Event event) throws Exception {

		// no selected file
		if (!FilesUIHelper.isFileSelected()) {
			// show an error message
			Messagebox.show("Select a File first.", "Warning", Messagebox.OK,
					Messagebox.EXCLAMATION);
		} else {

			// file has subfiles
			if (FilesUIHelper.hasSelectedFileChildren()) {
				// show an error message
				Messagebox.show("Cannot add a Record in this File", "Warning",
						Messagebox.OK, Messagebox.EXCLAMATION);
			} else {
				ModalWindowHelper.openWindow("add_record.zul");
			}

		}

	}

}
