package n5.ui.comparators;

import java.util.Comparator;

import dots.module.base.entitybeans.RegistryEntryBean;

public class RecordComparator implements Comparator<RegistryEntryBean> {

	@Override
	public int compare(RegistryEntryBean r1, RegistryEntryBean r2) {

		return r1.getCreatedDate().compareTo(r2.getCreatedDate());
	}

}
