package dots.ui.app;

import java.util.Map;

import dots.ui.config.Config;
import dots.ui.helpers.FondsUIHelper;
import dots.ui.dotsClient.dotsClient;
import dots.module.base.entitybeans.FondsCreatorBean;

import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.util.Initiator;


public class InitGUI implements Initiator {

	//@Override
	public void doAfterCompose(Page page) throws Exception {

		// initialize the fonds creator
		initFondsCreator();

		// populate the fonds tree
		FondsUIHelper.populateFonds();

	}

	private void initFondsCreator() {

		// try to get the fonds creator for this application
		FondsCreatorBean fondsCreator = dotsClient
				.get()
				.getSearchService()
				.fondsCreatorFindByFondsCreatorId(
						Config.get().getFondsCreatorId());

		// if no fonds creator exists
		if (fondsCreator == null) {

			// create a new one
			dotsClient.get()
					.getBaseService()
					.fondsCreatorCreate(Config.get().getFondsCreatorId(),
							Config.get().getFondsCreatorName(),
							Config.get().getDescription());
		}

	}

	@Override
	public boolean doCatch(Throwable arg0) throws Exception {
		return false;
	}

	@Override
	public void doFinally() throws Exception {

	}

	@SuppressWarnings("rawtypes")
	@Override
	public void doInit(Page page, Map arg1) throws Exception {

	}

}
