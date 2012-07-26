package n5.ui.helpers;

import java.util.Collections;
import java.util.List;

import n5.ui.comparators.DocumentComparator;
import n5.ui.comparators.RecordComparator;
import n5.ui.listeners.trees.DoubleClickDocumentEventListener;
import n5.ui.n5client.N5Client;
import dots.module.base.entitybeans.DocumentDescriptionBean;
import dots.module.base.entitybeans.RegistryEntryBean;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.api.Treechildren;
import org.zkoss.zul.api.Treeitem;

public class RecordsUIHelper {

	public static void populateRecords(String fileSystemId) {

		// get the records in the specified file
		List<RegistryEntryBean> records = N5Client.get().getBaseService()
				.caseFileGetRegistryEntries(fileSystemId);

		// sort the records by their creation dates
		Collections.sort(records, new RecordComparator());

		// add each record to the tree
		for (RegistryEntryBean record : records) {

			Treeitem recordItem = addRecordToTree(record.getTitle(),
					record.getSystemId());

			// get the documents in the current record
			List<DocumentDescriptionBean> dds = N5Client.get().getBaseService()
					.registryEntryGetDocumentDescriptions(record.getSystemId());

			// sort them by creation date
			Collections.sort(dds, new DocumentComparator());

			// add the documents to the record tree
			for (DocumentDescriptionBean dd : dds) {
				addDocumentToTree(dd.getTitle(), dd.getSystemId(), recordItem);
			}

		}

	}

	public static void clearRecords() {

		// get the records tree
		Treechildren recordsTree = getRecordsTree();

		// remove all records from the tree
		recordsTree.getChildren().clear();
	}

	public static Treeitem addDocumentToTree(String title, String systemId,
			Treeitem parentRecord) {

		if (parentRecord.getTreechildrenApi() == null) {
			parentRecord.appendChild(new org.zkoss.zul.Treechildren());
		}

		Treeitem item = (Treeitem) new org.zkoss.zul.Treeitem(title);
		item.setId(systemId);
		item.addEventListener("onDoubleClick",
				new DoubleClickDocumentEventListener());

		parentRecord.getTreechildrenApi().appendChild(item);

		return item;
	}

	public static Treeitem addRecordToTree(String title, String systemId) {

		Treechildren recordsTree = getRecordsTree();

		Treeitem item = (Treeitem) new org.zkoss.zul.Treeitem(title);
		item.setId(systemId);
		recordsTree.appendChild(item);

		return item;
	}

	public static Treechildren getRecordsTree() {

		return (Treechildren) Executions.getCurrent().getDesktop()
				.getFirstPage().getFellow("wnd").getFellow("recordsTree");
	}

	public static void closeAddRecordWindow() {

		ModalWindowHelper.closeWindow("add_record_wnd");
	}

	public static void closeAddDocumentWindow() {

		ModalWindowHelper.closeWindow("add_document_wnd");
	}

	public static void closeViewDocumentWindow() {

		ModalWindowHelper.closeWindow("view_document_wnd");
	}

	public static Treeitem getSelectedRecord() {

		// get the records tree
		Treechildren recordsTree = getRecordsTree();

		// get the selected record
		Treeitem selectedItem = (Treeitem) recordsTree.getTreeApi()
				.getSelectedItems().iterator().next();

		return selectedItem;

	}

	public static boolean isRecordSelected() {

		// get the records tree
		Treechildren recordsTree = getRecordsTree();

		// get the selected item if any
		Treeitem selectedItem = null;

		if (recordsTree.getTreeApi().getSelectedItems().iterator().hasNext()) {
			selectedItem = (Treeitem) recordsTree.getTreeApi()
					.getSelectedItems().iterator().next();
		}

		// no item is selected
		if (selectedItem == null) {

			return false;

		} else { // an item is selected

			// check if it is a record
			RegistryEntryBean record = N5Client.get().getSearchService()
					.registryEntryFindBySystemId(selectedItem.getId());

			if (record != null) {
				return true;
			} else {
				return false;
			}

		}

	}

}
