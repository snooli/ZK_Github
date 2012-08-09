package dots.module.hlapi.base;

import java.util.List;

import javax.persistence.EntityManager;

import dots.module.base.beans.Result;
import dots.module.base.entitybeans.CaseFileBean;
import dots.module.base.entitybeans.ClassBean;
import dots.module.base.entitybeans.ClassificationSystemBean;
import dots.module.base.entitybeans.RegistryEntryBean;


public class ClassAPI {

	/** Create **/

	public static Result create(EntityManager em, String csSystemId,
			String parentClassSystemId, String title, String description,
			String createdBy) {
		// TODO
		return null;
	}

	/** Delete **/

	public static Result delete(EntityManager em, String systemId) {
		// TODO
		return null;
	}

	/** Get **/

	public static List<CaseFileBean> getCaseFiles(EntityManager em,
			String systemId) {
		// TODO
		return null;
	}

	public static List<ClassBean> getChildClasses(EntityManager em,
			String systemId) {
		// TODO
		return null;
	}

	public static ClassificationSystemBean getClassificationSystem(
			EntityManager em, String systemId) {
		// TODO
		return null;
	}

	public static ClassBean getParentClass(EntityManager em, String systemId) {
		// TODO
		return null;
	}

	public static List<RegistryEntryBean> getRegistryEntries(EntityManager em,
			String systemId) {
		// TODO
		return null;
	}

	/** Add **/

	public static Result addCaseFile(EntityManager em, String classSystemId,
			String caseFileSystemId) {
		// TODO
		return null;
	}

	public static Result addRegistryEntry(EntityManager em,
			String classSystemId, String entrySystemId) {
		// TODO
		return null;
	}

}
