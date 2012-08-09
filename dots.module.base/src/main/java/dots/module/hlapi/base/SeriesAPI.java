package dots.module.hlapi.base;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJBException;
import javax.persistence.EntityManager;

import dots.clb.common.api.base.LLFondsAPI;
import dots.clb.common.api.base.LLSeriesAPI;
import dots.clb.common.api.find.LLFondsFindAPI;
import dots.clb.common.api.find.LLSeriesFindAPI;
import dots.clb.common.constants.N5Status;
import dots.clb.common.entities.Fonds;
import dots.clb.common.entities.Series;
import dots.module.base.beans.Result;
import dots.module.base.entitybeans.CaseFileBean;
import dots.module.base.entitybeans.ClassificationSystemBean;
import dots.module.base.entitybeans.RegistryEntryBean;
import dots.module.base.entitybeans.SeriesBean;
import dots.module.base.helpers.EntityHelper;

public class SeriesAPI {

	/** Create **/

	public static Result create(EntityManager em, String fondsSystemId,
			String precursorSystemId, String title, String description,
			String documentMedium, String createdBy) {

		// no fonds specified
		if (fondsSystemId == null) {
			throw new EJBException();
		}

		// get the fonds
		Fonds fonds = LLFondsFindAPI.findBySystemId(em, fondsSystemId);

		// specified fonds does not exist or has subfonds
		if (fonds == null || fonds.getReferenceChildFonds().size() > 0) {
			// cannot create series
			throw new EJBException();
		}

		// create the series
		String seriesSystemId = new LLSeriesAPI().create(em, title,
				description, N5Status.SeriesStatus.ACTIVE_PERIOD,
				documentMedium, createdBy);

		// get the newly created series
		Series series = LLSeriesFindAPI.findBySystemId(em, seriesSystemId);

		// add the series to the fonds
		new LLFondsAPI().addSeries(fonds, series);

		// a precursor is specified
		if (precursorSystemId != null) {

			// get the precursor
			Series precursor = LLSeriesFindAPI.findBySystemId(em,
					precursorSystemId);

			// specified series does not exist
			if (precursor == null) {
				throw new EJBException();
			}

			// set the series precursor
			new LLSeriesAPI().setPrecursorSeries(series, precursor);
		}

		return new Result(true, seriesSystemId);
	}

	public static Result create(EntityManager em, String fondsSystemId,
			String precursorSystemId, String csSystemId, String title,
			String description, String documentMedium, String createdBy) {
		// TODO
		return null;
	}

	/** Delete **/

	public static Result delete(EntityManager em, String systemId) {

		return null;
	}

	/** Get **/

	public static List<CaseFileBean> getCaseFiles(EntityManager em,
			String systemId) {

		Series series = LLSeriesFindAPI.findBySystemId(em, systemId);

		if (series != null) {
			return EntityHelper.entitiesToBeans(series.getReferenceFile(),
					CaseFileBean.class);
		} else {
			return new ArrayList<CaseFileBean>();
		}
	}

	public static ClassificationSystemBean getClassificationSystem(
			EntityManager em, String systemId) {
		// TODO
		return null;
	}

	public static SeriesBean getPrecursor(EntityManager em, String systemId) {

		Series series = LLSeriesFindAPI.findBySystemId(em, systemId);

		if (series != null) {
			return EntityHelper.entityToBean(series.getReferencePrecursor(),
					SeriesBean.class);
		} else {
			return null;
		}
	}

	public static List<RegistryEntryBean> getRegistryEntries(EntityManager em,
			String systemId) {

		Series series = LLSeriesFindAPI.findBySystemId(em, systemId);

		if (series != null) {
			return EntityHelper.entitiesToBeans(series.getReferenceRecord(),
					RegistryEntryBean.class);
		} else {
			return new ArrayList<RegistryEntryBean>();
		}
	}

	public static SeriesBean getSuccessor(EntityManager em, String systemId) {

		Series series = LLSeriesFindAPI.findBySystemId(em, systemId);

		if (series != null) {
			return EntityHelper.entityToBean(series.getReferenceSuccessor(),
					SeriesBean.class);
		} else {
			return null;
		}
	}

}
