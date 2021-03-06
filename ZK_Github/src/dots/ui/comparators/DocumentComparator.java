package dots.ui.comparators;

import java.util.Comparator;

import dots.module.base.entitybeans.DocumentDescriptionBean;

public class DocumentComparator implements
		Comparator<DocumentDescriptionBean> {

	@Override
	public int compare(DocumentDescriptionBean d1, DocumentDescriptionBean d2) {

		return d1.getCreatedDate().compareTo(d2.getCreatedDate());
	}

}
