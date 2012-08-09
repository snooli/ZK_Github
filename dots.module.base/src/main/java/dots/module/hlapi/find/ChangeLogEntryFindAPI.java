package dots.module.hlapi.find;

import java.util.List;

import javax.persistence.EntityManager;

import dots.clb.common.api.find.LLChangeLogEntryFindAPI;
import dots.clb.common.entities.ChangeLogEntry;
import dots.module.base.entitybeans.ChangeLogEntryBean;
import dots.module.base.helpers.EntityHelper;

public class ChangeLogEntryFindAPI {

	public static List<ChangeLogEntryBean> findAll(EntityManager em) {

		List<ChangeLogEntry> entries = LLChangeLogEntryFindAPI.findAll(em);

		List<ChangeLogEntryBean> entryBeans = EntityHelper.entitiesToBeans(
				entries, ChangeLogEntryBean.class);

		return entryBeans;
	}

}
