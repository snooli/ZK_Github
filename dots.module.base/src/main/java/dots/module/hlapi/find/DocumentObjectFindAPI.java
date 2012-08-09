package dots.module.hlapi.find;

import java.util.List;

import javax.persistence.EntityManager;

import dots.clb.common.api.find.LLDocumentObjectFindAPI;
import dots.clb.common.entities.DocumentObject;
import dots.module.base.entitybeans.DocumentObjectBean;
import dots.module.base.helpers.EntityHelper;

public class DocumentObjectFindAPI {

	public static DocumentObjectBean findBySystemId(EntityManager em,
			String systemId) {

		DocumentObject dobj = LLDocumentObjectFindAPI.findBySystemId(em,
				systemId);
		DocumentObjectBean dobjBean = EntityHelper.entityToBean(dobj,
				DocumentObjectBean.class);

		return dobjBean;
	}

	public static List<DocumentObjectBean> findAll(EntityManager em) {

		List<DocumentObject> dobjs = LLDocumentObjectFindAPI.findAll(em);

		List<DocumentObjectBean> dobjBeans = EntityHelper.entitiesToBeans(
				dobjs, DocumentObjectBean.class);

		return dobjBeans;
	}

	public static List<DocumentObjectBean> findAllByCreatedBy(EntityManager em,
			String createdBy) {

		List<DocumentObject> dobjs = LLDocumentObjectFindAPI
				.findAllByCreatedBy(em, createdBy);

		List<DocumentObjectBean> dobjBeans = EntityHelper.entitiesToBeans(
				dobjs, DocumentObjectBean.class);

		return dobjBeans;
	}

}
