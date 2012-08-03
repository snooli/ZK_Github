package dots.ui.comparators;

import java.util.Comparator;

import dots.module.base.entitybeans.FondsBean;

public class FondsComparator implements Comparator<FondsBean> {

	@Override
	public int compare(FondsBean f1, FondsBean f2) {

		return f1.getCreatedDate().compareTo(f2.getCreatedDate());
	}

}
