package dots.clb.common.api.base;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.ejb.EJBException;
import javax.persistence.EntityManager;

import dots.clb.common.entities.ClassificationSystem;
import dots.clb.common.entities.File;
import dots.clb.common.entities.Record;
import dots.clb.common.entities.Series;
import dots.clb.common.entities.StorageLocation;


public class LLSeriesAPI extends LLChangeLogAPI {

	/** Create **/

	public String create(EntityManager em, String title, String description,
			String seriesStatus, String documentMedium, String createdBy) {

		Series series = new Series();
		setSystemId(em, series, UUID.randomUUID().toString());

		if (createdBy == null || createdBy.isEmpty()) {
			throw new EJBException();
		}

		setCreatedBy(em, series, createdBy);
		setCreatedDate(em, series, Calendar.getInstance().getTime());
		setTitle(em, series, title);
		setDescription(em, series, description);
		setSeriesStatus(em, series, seriesStatus);
		setDocumentMedium(em, series, documentMedium);

		em.persist(series);

		return series.getSystemId();
	}

	/** Delete **/

	public void delete(EntityManager em, Series series) {

		em.remove(series);
	}

	/** Set **/

	public Boolean setPrecursorSeries(Series series, Series precursor) {

		if (series != null && precursor != null
				&& series.getReferencePrecursor() == null
				&& precursor.getReferenceSuccessor() == null) {

			series.setReferencePrecursor(precursor);
			precursor.setReferenceSuccessor(series);

			return true;
		} else {
			return false;
		}
	}

	public Boolean setClassificationSystem(Series series,
			ClassificationSystem cs) {

		if (series != null && cs != null
				&& series.getReferenceClassificationSystem() == null) {

			series.setReferenceClassificationSystem(cs);
			cs.getReferenceSeries().add(series);

			return true;
		} else {
			return false;
		}
	}

	/** Add **/

	public Boolean addStorageLocation(Series series, StorageLocation location) {

		if (series != null & location != null
				&& !series.getReferenceStorageLocation().contains(location)
				&& !location.getReferenceSeries().contains(series)) {

			series.getReferenceStorageLocation().add(location);
			location.getReferenceSeries().add(series);

			return true;
		} else {
			return false;
		}

	}

	public Boolean addFile(Series series, File file) {

		if (series != null && file != null
				&& !series.getReferenceFile().contains(file)
				&& file.getReferenceSeries() == null) {

			series.getReferenceFile().add(file);
			file.setReferenceSeries(series);

			return true;
		} else {
			return false;
		}

	}

	public Boolean addRecord(Series series, Record record) {

		if (series != null && record != null
				&& !series.getReferenceRecord().contains(record)
				&& record.getReferenceSeries() == null) {

			series.getReferenceRecord().add(record);
			record.setReferenceSeries(series);

			return true;
		} else {
			return false;
		}
	}

	/** Set **/

	public void setSystemId(EntityManager em, Series series, String systemId) {
		if (series != null && systemId != null) {
			series.setSystemId(systemId);
		}
	}

	public void setTitle(EntityManager em, Series series, String title) {
		if (series != null && title != null) {
			changeLog(em, series.getSystemId(), "tittel", series.getTitle(),
					title);
			series.setTitle(title);
		}
	}

	public void setDescription(EntityManager em, Series series,
			String description) {
		if (series != null && description != null) {
			series.setDescription(description);
		}
	}

	public void setSeriesStatus(EntityManager em, Series series,
			String seriesStatus) {
		if (series != null && seriesStatus != null) {
			changeLog(em, series.getSystemId(), "arkivdelstatus",
					series.getSeriesStatus(), seriesStatus);
			series.setSeriesStatus(seriesStatus);
		}
	}

	public void setDocumentMedium(EntityManager em, Series series,
			String documentMedium) {
		if (series != null && documentMedium != null) {
			series.setDocumentMedium(documentMedium);
		}
	}

	public void setCreatedDate(EntityManager em, Series series, Date createdDate) {
		if (series != null && createdDate != null) {
			series.setCreatedDate(createdDate);
		}
	}

	public void setCreatedBy(EntityManager em, Series series, String createdBy) {
		if (series != null && createdBy != null) {
			series.setCreatedBy(createdBy);
		}
	}

	public void setFinalisedDate(EntityManager em, Series series,
			Date finalisedDate) {
		if (series != null && finalisedDate != null) {
			series.setFinalisedDate(finalisedDate);
		}
	}

	public void setFinalisedBy(EntityManager em, Series series,
			String finalisedBy) {
		if (series != null && finalisedBy != null) {
			series.setFinalisedBy(finalisedBy);
		}
	}

	public void setSeriesStartDate(EntityManager em, Series series,
			Date seriesStartDate) {
		if (series != null && seriesStartDate != null) {
			series.setSeriesStartDate(seriesStartDate);
		}
	}

	public void setSeriesEndDate(EntityManager em, Series series,
			Date seriesEndDate) {
		if (series != null && seriesEndDate != null) {
			series.setSeriesEndDate(seriesEndDate);
		}
	}

}
