package dots.ui.listeners.trees;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.Composer;

public class SelectFondsComposer implements Composer {

	@Override
	public void doAfterCompose(Component comp) throws Exception {

		comp.addEventListener("onSelect", new SelectFondsEventListener());

	}

}
