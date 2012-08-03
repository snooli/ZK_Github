package n5.ui.helpers;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Window;

public class ModalWindowHelper {

	public static void openWindow(String zulFile) {

		try {
			Window wnd = (Window) Executions.createComponents(zulFile, null,
					null);
			wnd.doModal();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void closeWindow(String windowId) {

		Window wnd = (Window) Executions.getCurrent().getDesktop()
				.getFirstPage().getFellow(windowId);
		wnd.onClose();
	}

}
