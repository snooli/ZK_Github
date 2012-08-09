package dots.module.hlapi.base;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJBException;
import javax.persistence.EntityManager;

import dots.clb.common.api.base.LLCaseFileAPI;
import dots.clb.common.api.base.LLSeriesAPI;
import dots.clb.common.api.find.LLCaseFileFindAPI;
import dots.clb.common.api.find.LLSeriesFindAPI;
import dots.clb.common.constants.N5Status;
import dots.clb.common.entities.CaseFile;
import dots.clb.common.entities.Series;
import dots.module.base.beans.Result;
import dots.module.base.entitybeans.CaseFileBean;
import dots.module.base.entitybeans.ClassBean;
import dots.module.base.entitybeans.RegistryEntryBean;
import dots.module.base.entitybeans.SeriesBean;
import dots.module.base.helpers.EntityHelper;

public class CaseFileAPI {

	/** Create **/

	public static Result create(EntityManager em, String seriesSystemId,
			String parentFileSystemId, String title, String officialTitle,
			String description, String documentMedium, String createdBy) {

		// both series and parent file specified
		if (seriesSystemId != null && parentFileSystemId != null) {
			// cannot create case file
			throw new EJBException();
		}

		// create the new case file
		String caseFileSystemId = new LLCaseFileAPI().createCaseFile(em, null,
				title, officialTitle, description, documentMedium, createdBy,
				null, null, null, null, null, null,
				N5Status.CaseStatus.BEING_PROCESSED);

		// get the newly created case file
		CaseFile caseFile = LLCaseFileFindAPI.findBySystemId(em,
				caseFileSystemId);

		// series specified
		if (seriesSystemId != null) {

			// get the series
			Series series = LLSeriesFindAPI.findBySystemId(em, seriesSystemId);

			// specified series does not exist
			if (series == null) {
				throw new EJBException();
			}

			// add the case file to the series
			new LLSeriesAPI().addFile(series, caseFile);

			return new Result(true, caseFileSystemId);
		}

		// parent case file specified
		if (parentFileSystemId != null) {

			// get the parent file
			CaseFile parentFile = LLCaseFileFindAPI.findBySystemId(em,
					parentFileSystemId);

			// specified file does not exist or it contains records
			if (parentFile == null
					|| parentFile.getReferenceRecord().size() > 0) {
				throw new EJBException();
			}

			// add the newly created case file as a child to the specified
			// parent
			new LLCaseFileAPI().addChildFile(parentFile, caseFile);

			return new Result(true, caseFileSystemId);
		}

		// should not reach this point
		throw new EJBException();
	}

	/** Delete **/

	public static Result delete(EntityManager em, String systemId) {
		// TODO
		return null;
	}

	/** Get **/

	public static List<CaseFileBean> getChildCaseFiles(EntityManager em,
			String systemId) {

		CaseFile file = LLCaseFileFindAPI.findBySystemId(em, systemId);

		if (file != null) {

			return EntityHelper.entitiesToBeans(file.getReferenceChildFile(),
					CaseFileBean.class);
		} else {
			return new ArrayList<CaseFileBean>();
		}
	}

	public static ClassBean getClass(EntityManager em, String systemId) {
		// TODO
		return null;
	}

	public static CaseFileBean getParentCaseFile(EntityManager em,
			String systemId) {

		CaseFile file = LLCaseFileFindAPI.findBySystemId(em, systemId);

		if (file != null) {
			return EntityHelper.entityToBean(file.getReferenceParentFile(),
					CaseFileBean.class);
		} else {
			return null;
		}
	}

	public static List<RegistryEntryBean> getRegistryEntries(EntityManager em,
			String systemId) {

		CaseFile file = LLCaseFileFindAPI.findBySystemId(em, systemId);

		if (file != null) {
			return EntityHelper.entitiesToBeans(file.getReferenceRecord(),
					RegistryEntryBean.class);
		} else {
			return new ArrayList<RegistryEntryBean>();
		}
	}

	public static SeriesBean getSeries(EntityManager em, String systemId) {

		CaseFile file = LLCaseFileFindAPI.findBySystemId(em, systemId);

		if (file != null) {
			return EntityHelper.entityToBean(file.getReferenceSeries(),
					SeriesBean.class);
		} else {
			return null;
		}
	}

}
