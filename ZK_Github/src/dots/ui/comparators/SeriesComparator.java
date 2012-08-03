package dots.ui.comparators;

import java.util.Comparator;

import dots.module.base.entitybeans.SeriesBean;

public class SeriesComparator implements Comparator<SeriesBean> {

	@Override
	public int compare(SeriesBean s1, SeriesBean s2) {

		return s1.getCreatedDate().compareTo(s2.getCreatedDate());
	}

}
