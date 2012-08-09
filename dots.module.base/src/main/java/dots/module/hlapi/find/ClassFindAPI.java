package dots.module.hlapi.find;

import java.util.List;

import javax.persistence.EntityManager;

import dots.clb.common.api.find.LLClassFindAPI;
import dots.clb.common.entities.Class;
import dots.module.base.entitybeans.ClassBean;
import dots.module.base.helpers.EntityHelper;

public class ClassFindAPI {

	public static ClassBean findBySystemId(EntityManager em, String systemId) {

		Class klass = LLClassFindAPI.findBySystemId(em, systemId);
		ClassBean klassBean = EntityHelper.entityToBean(klass, ClassBean.class);

		return klassBean;
	}

	public static ClassBean findByClassId(EntityManager em, String classId) {

		Class klass = LLClassFindAPI.findByClassId(em, classId);
		ClassBean klassBean = EntityHelper.entityToBean(klass, ClassBean.class);

		return klassBean;
	}

	public static List<ClassBean> findAll(EntityManager em) {

		List<Class> classes = LLClassFindAPI.findAll(em);

		List<ClassBean> classBeans = EntityHelper.entitiesToBeans(classes,
				ClassBean.class);

		return classBeans;
	}

	public static List<ClassBean> findAllByTitle(EntityManager em, String title) {

		List<Class> classes = LLClassFindAPI.findAllByTitle(em, title);

		List<ClassBean> classBeans = EntityHelper.entitiesToBeans(classes,
				ClassBean.class);

		return classBeans;
	}

	public static List<ClassBean> findAllByDescription(EntityManager em,
			String description) {

		List<Class> classes = LLClassFindAPI.findAllByDescription(em,
				description);

		List<ClassBean> classBeans = EntityHelper.entitiesToBeans(classes,
				ClassBean.class);

		return classBeans;
	}

	public static List<ClassBean> findAllByCreatedBy(EntityManager em,
			String createdBy) {

		List<Class> classes = LLClassFindAPI.findAllByCreatedBy(em, createdBy);

		List<ClassBean> classBeans = EntityHelper.entitiesToBeans(classes,
				ClassBean.class);

		return classBeans;
	}

}
