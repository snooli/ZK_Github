package dots.ui.helpers;

import java.util.Collections;
import java.util.List;

import dots.ui.comparators.FondsComparator;
import dots.ui.dotsClient.dotsClient;
import dots.module.base.entitybeans.FondsBean;
import dots.module.base.entitybeans.SeriesBean;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.api.Treechildren;
import org.zkoss.zul.api.Treeitem;

public class FondsUIHelper {

	public static void populateFonds() {

		populateFondsRecursive(null);

	}

	private static void populateFondsRecursive(Treeitem parent) {

		// build the top level of the tree
		if (parent == null) {

			// get all top-level fonds
			List<FondsBean> topFonds = dotsClient.get().getSearchService()
					.fondsFindTopLevel();

			// sort the fonds by their creation dates
			Collections.sort(topFonds, new FondsComparator());

			// go through each fonds
			for (FondsBean fonds : topFonds) {

				Treeitem item = addFondsToTree(fonds.getTitle(),
						fonds.getSystemId(), null);

				// add its children to the tree
				populateFondsRecursive(item);
			}

		} else { // build the lower levels of the tree

			// get the ID of the parent
			String parentFondsSystemId = parent.getId();

			// get its children
			List<FondsBean> childFonds = dotsClient.get().getBaseService()
					.fondsGetChildFonds(parentFondsSystemId);

			// sort the fonds by their creation dates
			Collections.sort(childFonds, new FondsComparator());

			// no children
			if (childFonds.size() == 0) {
				// end the recursion
				return;
			}

			parent.appendChild(new org.zkoss.zul.Treechildren());

			// go through each fonds
			for (FondsBean child : childFonds) {

				// add it to the tree
				Treeitem item = addFondsToTree(child.getTitle(),
						child.getSystemId(), parent);

				// add its children to the tree
				populateFondsRecursive(item);
			}
		}

	}

	public static Treeitem addFondsToTree(String title, String systemId,
			Treeitem parent) {

		// no parent specified
		if (parent == null) {

			// get the fonds tree
			Treechildren fondsTree = getFondsTree();

			Treeitem item = (Treeitem) new org.zkoss.zul.Treeitem(title);
			item.setId(systemId);
			fondsTree.appendChild(item);

			return item;

		} else { // parent specified

			if (parent.getTreechildrenApi() == null) {
				parent.appendChild(new org.zkoss.zul.Treechildren());
			}

			Treeitem item = (Treeitem) new org.zkoss.zul.Treeitem(title);
			item.setId(systemId);

			parent.getTreechildrenApi().appendChild(item);

			return item;
		}

	}

	public static Treechildren getFondsTree() {

		return (Treechildren) Executions.getCurrent().getDesktop()
				.getFirstPage().getFellow("wnd").getFellow("fondsTree");
	}

	public static Treeitem getSelectedFonds() {

		// get the Fonds tree
		Treechildren fondsTree = getFondsTree();

		// get the system ID of the selected Fonds
		Treeitem selectedItem = (Treeitem) fondsTree.getTreeApi()
				.getSelectedItems().iterator().next();

		return selectedItem;

	}

	public static void closeAddFondsWindow() {

		ModalWindowHelper.closeWindow("add_fonds_wnd");
	}

	public static void closeAddSubfondsWindow() {

		ModalWindowHelper.closeWindow("add_subfonds_wnd");
	}

	public static boolean isFondsSelected() {

		Treechildren fondsTree = getFondsTree();

		if (fondsTree.getTreeApi().getSelectedCount() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean hasSelectedFondsChildren() {

		List<FondsBean> childFonds = dotsClient.get().getBaseService()
				.fondsGetChildFonds(getSelectedFonds().getId());

		// fonds has subfonds
		if (childFonds.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean hasSelectedFondsSeries() {

		List<SeriesBean> fondsSeries = dotsClient.get().getBaseService()
				.fondsGetSeries(getSelectedFonds().getId());

		// fonds has series
		if (fondsSeries.size() > 0) {
			return true;
		} else {
			return false;
		}

	}

}
