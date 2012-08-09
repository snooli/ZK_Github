package dots.clb.common.api.base;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.ejb.EJBException;
import javax.persistence.EntityManager;

import dots.clb.common.entities.Fonds;
import dots.clb.common.entities.FondsCreator;
import dots.clb.common.entities.Series;
import dots.clb.common.entities.StorageLocation;


public class LLFondsAPI extends LLChangeLogAPI {

	/** Create **/

	public String create(EntityManager em, String title, String description,
			String fondsStatus, String documentMedium, String createdBy) {

		Fonds fonds = new Fonds();
		setSystemId(em, fonds, UUID.randomUUID().toString());

		if (createdBy == null || createdBy.isEmpty()) {
			throw new EJBException();
		}

		setCreatedBy(em, fonds, createdBy);
		setCreatedDate(em, fonds, Calendar.getInstance().getTime());
		setTitle(em, fonds, title);
		setDescription(em, fonds, description);
		setFondsStatus(em, fonds, fondsStatus);
		setDocumentMedium(em, fonds, documentMedium);

		em.persist(fonds);

		return fonds.getSystemId();
	}

	/** Delete **/

	public void delete(EntityManager em, Fonds fonds) {

		em.remove(fonds);
	}

	/** Add **/

	public Boolean addSeries(Fonds fonds, Series series) {

		if (fonds != null && series != null
				&& !fonds.getReferenceSeries().contains(series)
				&& series.getReferenceFonds() == null) {

			fonds.getReferenceSeries().add(series);
			series.setReferenceFonds(fonds);

			return true;
		} else {
			return false;
		}
	}

	public Boolean addStorageLocation(Fonds fonds, StorageLocation location) {

		if (location != null && fonds != null
				&& !fonds.getReferenceStorageLocation().contains(location)
				&& !location.getReferenceFonds().contains(fonds)) {

			location.getReferenceFonds().add(fonds);
			fonds.getReferenceStorageLocation().add(location);

			return true;
		} else {
			return false;
		}
	}

	public Boolean addChildFonds(Fonds parentFonds, Fonds childFonds) {

		if (parentFonds != null & childFonds != null
				&& !parentFonds.getReferenceChildFonds().contains(childFonds)
				&& childFonds.getReferenceParentFonds() == null) {

			childFonds.setReferenceParentFonds(parentFonds);
			parentFonds.getReferenceChildFonds().add(childFonds);

			return true;
		} else {
			return false;
		}
	}

	public Boolean addFondsCreator(Fonds fonds, FondsCreator fondsCreator) {

		if (fonds != null && fondsCreator != null
				&& !fonds.getReferenceFondsCreator().contains(fondsCreator)
				&& !fondsCreator.getReferenceFonds().contains(fonds)) {

			fonds.getReferenceFondsCreator().add(fondsCreator);
			fondsCreator.getReferenceFonds().add(fonds);

			return true;
		} else {
			return false;
		}
	}

	/** Set **/

	public void setSystemId(EntityManager em, Fonds fonds, String systemId) {
		if (fonds != null && systemId != null) {
			fonds.setSystemId(systemId);
		}
	}

	public void setTitle(EntityManager em, Fonds fonds, String title) {
		if (fonds != null && title != null) {
			changeLog(em, fonds.getSystemId(), "tittel", fonds.getTitle(),
					title);
			fonds.setTitle(title);
		}
	}

	public void setDescription(EntityManager em, Fonds fonds, String description) {
		if (fonds != null && description != null) {
			fonds.setDescription(description);
		}
	}

	public void setFondsStatus(EntityManager em, Fonds fonds, String fondsStatus) {
		if (fonds != null && fondsStatus != null) {
			changeLog(em, fonds.getSystemId(), "arkivstatus",
					fonds.getFondsStatus(), fondsStatus);
			fonds.setFondsStatus(fondsStatus);
		}
	}

	public void setDocumentMedium(EntityManager em, Fonds fonds,
			String documentMedium) {
		if (fonds != null && documentMedium != null) {
			fonds.setDocumentMedium(documentMedium);
		}
	}

	public void setCreatedDate(EntityManager em, Fonds fonds, Date createdDate) {
		if (fonds != null && createdDate != null) {
			fonds.setCreatedDate(createdDate);
		}
	}

	public void setCreatedBy(EntityManager em, Fonds fonds, String createdBy) {
		if (fonds != null && createdBy != null) {
			fonds.setCreatedBy(createdBy);
		}
	}

	public void setFinalisedDate(EntityManager em, Fonds fonds,
			Date finalisedDate) {
		if (fonds != null && finalisedDate != null) {
			fonds.setFinalisedDate(finalisedDate);
		}
	}

	public void setFinalisedBy(EntityManager em, Fonds fonds, String finalisedBy) {
		if (fonds != null && finalisedBy != null) {
			fonds.setFinalisedBy(finalisedBy);
		}
	}

}
