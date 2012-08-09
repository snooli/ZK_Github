package dots.module.hlapi.base;

import java.util.List;

import javax.persistence.EntityManager;

import dots.module.base.beans.Result;
import dots.module.base.entitybeans.ClassBean;
import dots.module.base.entitybeans.SeriesBean;


public class ClassificationSystemAPI {

	/** Create **/

	public static Result create(EntityManager em, String title, String createdBy) {
		// TODO
		return null;
	}

	/** Delete **/

	public static Result delete(EntityManager em, String systemId) {
		// TODO
		return null;
	}

	/** Get **/

	public static List<ClassBean> getChildClasses(EntityManager em,
			String systemId) {
		// TODO
		return null;
	}

	public static List<SeriesBean> getSeries(EntityManager em, String systemId) {
		// TODO
		return null;
	}

}
