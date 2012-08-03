package dots.ui.listeners.buttons.mainwnd;

import dots.ui.helpers.ModalWindowHelper;
import dots.ui.helpers.SeriesUIHelper;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Messagebox;

public class AddCasefileEventListener implements EventListener {

	@Override
	public void onEvent(Event event) throws Exception {

		// no selected series
		if (!SeriesUIHelper.isSeriesSelected()) {
			// show an error message
			Messagebox.show("Velg en sak f¿rst.", "Advarsel", Messagebox.OK,
					Messagebox.EXCLAMATION);
		} else {
			ModalWindowHelper.openWindow("add_casefile.zul");
		}
		// Husk: en kobling til base.service caseFileCreate() et sted.
	}

}