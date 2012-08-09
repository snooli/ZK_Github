package dots.module.hlapi.find;

import java.util.List;

import javax.persistence.EntityManager;

import dots.clb.common.api.find.LLRegistryEntryFindAPI;
import dots.clb.common.entities.RegistryEntry;
import dots.module.base.entitybeans.RegistryEntryBean;
import dots.module.base.helpers.EntityHelper;

public class RegistryEntryFindAPI {

	public static RegistryEntryBean findBySystemId(EntityManager em,
			String systemId) {

		RegistryEntry entry = LLRegistryEntryFindAPI.findBySystemId(em,
				systemId);
		RegistryEntryBean entryBean = EntityHelper.entityToBean(entry,
				RegistryEntryBean.class);

		return entryBean;
	}

	public static List<RegistryEntryBean> findAll(EntityManager em) {

		List<RegistryEntry> entries = LLRegistryEntryFindAPI.findAll(em);

		List<RegistryEntryBean> entryBeans = EntityHelper.entitiesToBeans(
				entries, RegistryEntryBean.class);

		return entryBeans;
	}

	public static RegistryEntryBean findByRecordId(EntityManager em,
			String recordId) {

		RegistryEntry entry = LLRegistryEntryFindAPI.findByRecordId(em,
				recordId);
		RegistryEntryBean entryBean = EntityHelper.entityToBean(entry,
				RegistryEntryBean.class);

		return entryBean;
	}

	public static List<RegistryEntryBean> findAllByTitle(EntityManager em,
			String title) {

		List<RegistryEntry> entries = LLRegistryEntryFindAPI.findAllByTitle(em,
				title);

		List<RegistryEntryBean> entryBeans = EntityHelper.entitiesToBeans(
				entries, RegistryEntryBean.class);

		return entryBeans;
	}

	public static List<RegistryEntryBean> findAllByDescription(
			EntityManager em, String description) {

		List<RegistryEntry> entries = LLRegistryEntryFindAPI
				.findAllByDescription(em, description);

		List<RegistryEntryBean> entryBeans = EntityHelper.entitiesToBeans(
				entries, RegistryEntryBean.class);

		return entryBeans;
	}

	public static List<RegistryEntryBean> findAllByCreatedBy(EntityManager em,
			String createdBy) {

		List<RegistryEntry> entries = LLRegistryEntryFindAPI
				.findAllByCreatedBy(em, createdBy);

		List<RegistryEntryBean> entryBeans = EntityHelper.entitiesToBeans(
				entries, RegistryEntryBean.class);

		return entryBeans;
	}

}
