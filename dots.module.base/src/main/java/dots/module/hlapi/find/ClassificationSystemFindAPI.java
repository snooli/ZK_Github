package dots.module.hlapi.find;

import java.util.List;

import javax.persistence.EntityManager;

import dots.clb.common.api.find.LLClassificationSystemFindAPI;
import dots.clb.common.entities.ClassificationSystem;
import dots.module.base.entitybeans.ClassificationSystemBean;
import dots.module.base.helpers.EntityHelper;

public class ClassificationSystemFindAPI {

	public static ClassificationSystemBean findBySystemId(EntityManager em,
			String systemId) {

		ClassificationSystem cs = LLClassificationSystemFindAPI.findBySystemId(
				em, systemId);

		ClassificationSystemBean csBean = EntityHelper.entityToBean(cs,
				ClassificationSystemBean.class);

		return csBean;
	}

	public static List<ClassificationSystemBean> findAll(EntityManager em) {

		List<ClassificationSystem> cs = LLClassificationSystemFindAPI
				.findAll(em);

		List<ClassificationSystemBean> csBeans = EntityHelper.entitiesToBeans(
				cs, ClassificationSystemBean.class);

		return csBeans;
	}

	public static List<ClassificationSystemBean> findAllByTitle(
			EntityManager em, String title) {

		List<ClassificationSystem> cs = LLClassificationSystemFindAPI
				.findAllByTitle(em, title);

		List<ClassificationSystemBean> csBeans = EntityHelper.entitiesToBeans(
				cs, ClassificationSystemBean.class);

		return csBeans;
	}

	public static List<ClassificationSystemBean> findAllByDescription(
			EntityManager em, String description) {

		List<ClassificationSystem> cs = LLClassificationSystemFindAPI
				.findAllByDescription(em, description);

		List<ClassificationSystemBean> csBeans = EntityHelper.entitiesToBeans(
				cs, ClassificationSystemBean.class);

		return csBeans;
	}

	public static List<ClassificationSystemBean> findAllByCreatedBy(
			EntityManager em, String createdBy) {

		List<ClassificationSystem> cs = LLClassificationSystemFindAPI
				.findAllByCreatedBy(em, createdBy);

		List<ClassificationSystemBean> csBeans = EntityHelper.entitiesToBeans(
				cs, ClassificationSystemBean.class);

		return csBeans;
	}

}
