package dots.ui.listeners.buttons.mainwnd;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.Composer;

public class AddRecordComposer implements Composer {

	@Override
	public void doAfterCompose(Component comp) throws Exception {

		comp.addEventListener("onClick", new AddRecordEventListener());

	}

}
