package dots.ui.listeners.buttons.modwnd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import dots.clb.common.constants.N5Status;
import dots.ui.comparators.SeriesComparator;
import dots.ui.helpers.FondsUIHelper;
import dots.ui.helpers.SeriesUIHelper;
import dots.ui.dotsClient.dotsClient;
import dots.module.base.beans.Result;
import dots.module.base.entitybeans.SeriesBean;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.api.Treechildren;
import org.zkoss.zul.api.Treeitem;

public class ConfirmAddSeriesEventListener implements EventListener {

	@Override
	public void onEvent(Event event) throws Exception {

		try {
			processEvent(event);

			// close the modal window
			SeriesUIHelper.closeAddSeriesWindow();

		} catch (Exception ex) {

			ex.printStackTrace();

			// close the modal window
			SeriesUIHelper.closeAddSeriesWindow();

			// show an error message
			Messagebox.show("Could not add series.", "Warning", Messagebox.OK,
					Messagebox.EXCLAMATION);
		}

	}

	@SuppressWarnings("rawtypes")
	private void processEvent(Event event) throws Exception {

		String fondsSystemId = FondsUIHelper.getSelectedFonds().getId();

		// get the series title
		String title = ((Textbox) event.getTarget().getFellow("seriesTitle"))
				.getText();

		// get the series description
		String description = ((Textbox) event.getTarget().getFellow(
				"seriesDescription")).getText();

		// get the series document medium
		String medium = (String) ((Combobox) event.getTarget().getFellow(
				"seriesMedium")).getSelectedItem().getValue();
		String documentMedium = null;

		if (medium.equalsIgnoreCase("electronic")) {
			documentMedium = N5Status.DocumentMedium.ELECTRONIC;
		} else if (medium.equalsIgnoreCase("physical")) {
			documentMedium = N5Status.DocumentMedium.PHYSICAL;
		} else if (medium.equalsIgnoreCase("mixed")) {
			documentMedium = N5Status.DocumentMedium.MIXED;
		}

		// get the series tree
		Treechildren seriesTree = SeriesUIHelper.getSeriesTree();

		// if there are no series in the fonds
		if (seriesTree.getTreeApi().getItems().size() == 0) {

			// create a series with no precursor
			Result result = dotsClient
					.get()
					.getBaseService()
					.seriesCreate(fondsSystemId, null, title, description,
							documentMedium, "system");

			// add the newly created series to the series tree
			SeriesBean newSeries = dotsClient.get().getSearchService()
					.seriesFindBySystemId(result.getMessage());

			SeriesUIHelper.addSeriesToTree(newSeries.getTitle(),
					newSeries.getSystemId());

		} else { // create a series with a precursor

			List<SeriesBean> seriesList = new ArrayList<SeriesBean>();

			// get the series in the selected fonds
			Iterator iter = seriesTree.getTreeApi().getItems().iterator();
			while (iter.hasNext()) {

				Treeitem item = (Treeitem) iter.next();

				SeriesBean series = dotsClient.get().getSearchService()
						.seriesFindBySystemId(item.getId());

				seriesList.add(series);
			}

			// sort the series by creation date
			Collections.sort(seriesList, new SeriesComparator());

			// get the newest series
			SeriesBean latestSeries = seriesList.get(seriesList.size() - 1);

			// create the new series
			Result result = dotsClient
					.get()
					.getBaseService()
					.seriesCreate(fondsSystemId, latestSeries.getSystemId(),
							title, description, documentMedium, "system");

			// add the newly created series to the series tree
			SeriesBean newSeries = dotsClient.get().getSearchService()
					.seriesFindBySystemId(result.getMessage());

			SeriesUIHelper.addSeriesToTree(newSeries.getTitle(),
					newSeries.getSystemId());
		}
	}

}
