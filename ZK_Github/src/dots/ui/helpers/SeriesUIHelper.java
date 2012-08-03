package dots.ui.helpers;

import java.util.Collections;
import java.util.List;

import dots.ui.comparators.SeriesComparator;
import dots.ui.dotsClient.dotsClient;
import dots.module.base.entitybeans.SeriesBean;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.api.Treechildren;
import org.zkoss.zul.api.Treeitem;

public class SeriesUIHelper {

	public static void populateSeries(String fondsSystemId) {

		// get the series in the specified fonds
		List<SeriesBean> series = dotsClient.get().getBaseService()
				.fondsGetSeries(fondsSystemId);

		// sort the series by their creation dates
		Collections.sort(series, new SeriesComparator());

		// add each series to the tree
		for (SeriesBean sb : series) {

			addSeriesToTree(sb.getTitle(), sb.getSystemId());
		}

	}

	public static void addSeriesToTree(String title, String systemId) {

		Treechildren seriesTree = (Treechildren) Executions.getCurrent()
				.getDesktop().getFirstPage().getFellow("wnd")
				.getFellow("seriesTree");

		Treeitem item = (Treeitem) new org.zkoss.zul.Treeitem(title);
		item.setId(systemId);
		seriesTree.appendChild(item);
	}

	public static Treechildren getSeriesTree() {

		return (Treechildren) Executions.getCurrent().getDesktop()
				.getFirstPage().getFellow("wnd").getFellow("seriesTree");
	}

	public static void clearSeries() {

		// get the series tree
		Treechildren seriesTree = getSeriesTree();

		// remove all series from the tree
		seriesTree.getChildren().clear();
	}

	public static void closeAddSeriesWindow() {

		ModalWindowHelper.closeWindow("add_series_wnd");
	}

	public static Treeitem getSelectedSeries() {

		// get the Series tree
		Treechildren fondsTree = getSeriesTree();

		// get the system ID of the selected Series
		Treeitem selectedItem = (Treeitem) fondsTree.getTreeApi()
				.getSelectedItems().iterator().next();

		return selectedItem;
	}

	public static boolean isSeriesSelected() {

		Treechildren seriesTree = getSeriesTree();

		if (seriesTree.getTreeApi().getSelectedCount() > 0) {
			return true;
		} else {
			return false;
		}
	}

}
