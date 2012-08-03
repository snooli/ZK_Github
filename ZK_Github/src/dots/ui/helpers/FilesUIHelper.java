package dots.ui.helpers;

import java.util.Collections;
import java.util.List;

import dots.ui.comparators.FileComparator;
import dots.ui.dotsClient.dotsClient;
import dots.module.base.entitybeans.CaseFileBean;
import dots.module.base.entitybeans.RegistryEntryBean;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.api.Treechildren;
import org.zkoss.zul.api.Treeitem;

public class FilesUIHelper {

	public static void populateFiles(String seriesSystemId) {

		populateFilesRecursive(seriesSystemId, null);

	}

	private static void populateFilesRecursive(String seriesSystemId,
			Treeitem parent) {

		// build the top level of the tree
		if (parent == null) {

			// get the top-level files in the series
			List<CaseFileBean> topFiles = dotsClient.get().getBaseService()
					.seriesGetCaseFiles(seriesSystemId);

			// sort the files by their creation dates
			Collections.sort(topFiles, new FileComparator());

			// go through each file
			for (CaseFileBean file : topFiles) {

				Treeitem item = addFileToTree(file.getTitle(),
						file.getSystemId(), null);

				// add its children to the tree
				populateFilesRecursive(seriesSystemId, item);
			}

		} else { // build the lower levels of the tree

			// get the ID of the parent
			String parentFileSystemId = parent.getId();

			// get its children
			List<CaseFileBean> childFiles = dotsClient.get().getBaseService()
					.caseFileGetChildCaseFiles(parentFileSystemId);

			// sort the files by their creation dates
			Collections.sort(childFiles, new FileComparator());

			// no children
			if (childFiles.size() == 0) {
				// end the recursion
				return;
			}

			parent.appendChild(new org.zkoss.zul.Treechildren());

			// go through each child file
			for (CaseFileBean child : childFiles) {

				// add it to the tree
				Treeitem item = addFileToTree(child.getOfficialTitle(),
						child.getSystemId(), parent);

				// add its children to the tree
				populateFilesRecursive(seriesSystemId, item);
			}
		}

	}

	public static void clearFiles() {

		// get the files tree
		Treechildren filesTree = getFilesTree();

		// remove all series from the tree
		filesTree.getChildren().clear();
	}

	public static Treeitem addFileToTree(String title, String systemId,
			Treeitem parent) {

		// no parent specified
		if (parent == null) {

			// get the fonds tree
			Treechildren filesTree = getFilesTree();

			Treeitem item = (Treeitem) new org.zkoss.zul.Treeitem(title);
			item.setId(systemId);
			filesTree.appendChild(item);

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

	public static Treechildren getFilesTree() {

		return (Treechildren) Executions.getCurrent().getDesktop()
				.getFirstPage().getFellow("wnd").getFellow("filesTree");
	}

	public static void closeAddFileWindow() {

		ModalWindowHelper.closeWindow("add_file_wnd");
	}

	public static void closeAddSubfileWindow() {

		ModalWindowHelper.closeWindow("add_subfile_wnd");
	}

	public static Treeitem getSelectedFile() {

		// get the Files tree
		Treechildren filesTree = getFilesTree();

		// get the selected file
		Treeitem selectedItem = (Treeitem) filesTree.getTreeApi()
				.getSelectedItems().iterator().next();

		return selectedItem;
	}

	public static boolean isFileSelected() {

		Treechildren filesTree = getFilesTree();

		if (filesTree.getTreeApi().getSelectedCount() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean hasSelectedFileChildren() {

		List<CaseFileBean> childFiles = dotsClient.get().getBaseService()
				.caseFileGetChildCaseFiles(getSelectedFile().getId());

		// file has subfiles
		if (childFiles.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean hasSelectedFileRecords() {

		String fileSystemId = getSelectedFile().getId();

		List<RegistryEntryBean> records = dotsClient.get().getBaseService()
				.caseFileGetRegistryEntries(fileSystemId);

		if (records.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

}
