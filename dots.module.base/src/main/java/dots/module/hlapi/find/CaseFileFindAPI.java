package dots.module.hlapi.find;

import java.util.List;

import javax.persistence.EntityManager;

import dots.clb.common.api.find.LLCaseFileFindAPI;
import dots.clb.common.entities.CaseFile;
import dots.module.base.entitybeans.CaseFileBean;
import dots.module.base.helpers.EntityHelper;

public class CaseFileFindAPI {

	public static CaseFileBean findBySystemId(EntityManager em, String systemId) {

		CaseFile file = LLCaseFileFindAPI.findBySystemId(em, systemId);

		CaseFileBean fileBean = EntityHelper.entityToBean(file,
				CaseFileBean.class);

		return fileBean;
	}

	public static List<CaseFileBean> findAll(EntityManager em) {

		List<CaseFile> files = LLCaseFileFindAPI.findAll(em);

		List<CaseFileBean> fileBeans = EntityHelper.entitiesToBeans(files,
				CaseFileBean.class);

		return fileBeans;
	}

	public static List<CaseFileBean> findAllByTitle(EntityManager em,
			String title) {

		List<CaseFile> files = LLCaseFileFindAPI.findAllByTitle(em, title);

		List<CaseFileBean> fileBeans = EntityHelper.entitiesToBeans(files,
				CaseFileBean.class);

		return fileBeans;
	}

	public static List<CaseFileBean> findAllByDescription(EntityManager em,
			String description) {

		List<CaseFile> files = LLCaseFileFindAPI.findAllByDescription(em,
				description);

		List<CaseFileBean> fileBeans = EntityHelper.entitiesToBeans(files,
				CaseFileBean.class);

		return fileBeans;
	}

	public static List<CaseFileBean> findAllByCreatedBy(EntityManager em,
			String createdBy) {

		List<CaseFile> files = LLCaseFileFindAPI.findAllByCreatedBy(em,
				createdBy);

		List<CaseFileBean> fileBeans = EntityHelper.entitiesToBeans(files,
				CaseFileBean.class);

		return fileBeans;
	}

}
