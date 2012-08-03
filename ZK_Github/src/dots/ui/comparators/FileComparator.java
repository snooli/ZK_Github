package dots.ui.comparators;

import java.util.Comparator;

import dots.module.base.entitybeans.CaseFileBean;

public class FileComparator implements Comparator<CaseFileBean> {

	@Override
	public int compare(CaseFileBean f1, CaseFileBean f2) {

		return f1.getCreatedDate().compareTo(f2.getCreatedDate());
	}

}
