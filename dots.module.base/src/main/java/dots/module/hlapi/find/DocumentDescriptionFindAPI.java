package dots.module.hlapi.find;

import java.util.List;

import javax.persistence.EntityManager;

import dots.clb.common.api.find.LLDocumentDescriptionFindAPI;
import dots.clb.common.entities.DocumentDescription;
import dots.module.base.entitybeans.DocumentDescriptionBean;
import dots.module.base.helpers.EntityHelper;

public class DocumentDescriptionFindAPI {

	public static DocumentDescriptionBean findBySystemId(EntityManager em,
			String systemId) {

		DocumentDescription dd = LLDocumentDescriptionFindAPI.findBySystemId(
				em, systemId);
		DocumentDescriptionBean ddBean = EntityHelper.entityToBean(dd,
				DocumentDescriptionBean.class);

		return ddBean;
	}

	public static List<DocumentDescriptionBean> findAll(EntityManager em) {

		List<DocumentDescription> dds = LLDocumentDescriptionFindAPI
				.findAll(em);

		List<DocumentDescriptionBean> ddBeans = EntityHelper.entitiesToBeans(
				dds, DocumentDescriptionBean.class);

		return ddBeans;
	}

	public static List<DocumentDescriptionBean> findAllByTitle(
			EntityManager em, String title) {

		List<DocumentDescription> dds = LLDocumentDescriptionFindAPI
				.findAllByTitle(em, title);

		List<DocumentDescriptionBean> ddBeans = EntityHelper.entitiesToBeans(
				dds, DocumentDescriptionBean.class);

		return ddBeans;
	}

	public static List<DocumentDescriptionBean> findAllByDescription(
			EntityManager em, String description) {

		List<DocumentDescription> dds = LLDocumentDescriptionFindAPI
				.findAllByDescription(em, description);

		List<DocumentDescriptionBean> ddBeans = EntityHelper.entitiesToBeans(
				dds, DocumentDescriptionBean.class);

		return ddBeans;
	}

	public static List<DocumentDescriptionBean> findAllByCreatedBy(
			EntityManager em, String createdBy) {

		List<DocumentDescription> dds = LLDocumentDescriptionFindAPI
				.findAllByCreatedBy(em, createdBy);

		List<DocumentDescriptionBean> ddBeans = EntityHelper.entitiesToBeans(
				dds, DocumentDescriptionBean.class);

		return ddBeans;
	}

}
