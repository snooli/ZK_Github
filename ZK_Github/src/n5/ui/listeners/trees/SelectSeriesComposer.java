package n5.ui.listeners.trees;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.Composer;

public class SelectSeriesComposer implements Composer {

	@Override
	public void doAfterCompose(Component comp) throws Exception {

		comp.addEventListener("onSelect", new SelectSeriesEventListener());

	}

}
