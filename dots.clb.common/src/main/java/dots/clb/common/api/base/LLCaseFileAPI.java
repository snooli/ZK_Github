package dots.clb.common.api.base;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.ejb.EJBException;
import javax.persistence.EntityManager;

import dots.clb.common.entities.CaseFile;
import dots.clb.common.helpers.ElementHelper;


public class LLCaseFileAPI extends LLFileAPI {

	/** Create **/

	public String createCaseFile(EntityManager em, String fileId, String title,
			String officialTitle, String description, String documentMedium,
			String createdBy, Integer caseYear, Integer caseSequenceNumber,
			Date caseDate, String administrativeUnit, String caseResponsible,
			String recordsManagementUnit, String caseStatus) {

		CaseFile file = new CaseFile();
		setSystemId(em, file, UUID.randomUUID().toString());

		if (createdBy == null || createdBy.isEmpty()) {
			throw new EJBException();
		}

		setCreatedBy(em, file, createdBy);
		setCreatedDate(em, file, Calendar.getInstance().getTime());
		setFileId(em, file, fileId);
		setTitle(em, file, title);
		setOfficialTitle(em, file, officialTitle);
		setDescription(em, file, description);
		setDocumentMedium(em, file, documentMedium);
		setCaseYear(em, file, caseYear);
		setCaseSequenceNumber(em, file, caseSequenceNumber);
		setCaseDate(em, file, caseDate);
		setAdministrativeUnit(em, file, administrativeUnit);
		setCaseResponsible(em, file, caseResponsible);
		setRecordsManagementUnit(em, file, recordsManagementUnit);
		setCaseStatus(em, file, caseStatus);

		em.persist(file);

		return file.getSystemId();
	}

	/** Delete **/

	public void deleteCaseFile(EntityManager em, CaseFile file) {

		em.remove(file);
	}

	/** Set **/

	public void setCaseYear(EntityManager em, CaseFile file, Integer caseYear) {
		if (file != null && caseYear != null) {
			file.setCaseYear(caseYear);
		}
	}

	public void setCaseSequenceNumber(EntityManager em, CaseFile file,
			Integer caseSequenceNumber) {
		if (file != null && caseSequenceNumber != null) {
			file.setCaseSequenceNumber(caseSequenceNumber);
		}
	}

	public void setCaseDate(EntityManager em, CaseFile file, Date caseDate) {
		if (file != null && caseDate != null) {
			changeLog(em, file.getSystemId(), "saksdato",
					ElementHelper.dateTimeToString(file.getCaseDate()),
					ElementHelper.dateTimeToString(caseDate));
			file.setCaseDate(caseDate);
		}
	}

	public void setAdministrativeUnit(EntityManager em, CaseFile file,
			String administrativeUnit) {
		if (file != null && administrativeUnit != null) {
			changeLog(em, file.getSystemId(), "administrativEnhet",
					file.getAdministrativeUnit(), administrativeUnit);
			file.setAdministrativeUnit(administrativeUnit);
		}
	}

	public void setCaseResponsible(EntityManager em, CaseFile file,
			String caseResponsible) {
		if (file != null && caseResponsible != null) {
			changeLog(em, file.getSystemId(), "saksansvarlig",
					file.getCaseResponsible(), caseResponsible);
			file.setCaseResponsible(caseResponsible);
		}
	}

	public void setRecordsManagementUnit(EntityManager em, CaseFile file,
			String recordsManagementUnit) {
		if (file != null && recordsManagementUnit != null) {
			changeLog(em, file.getSystemId(), "journalenhet",
					file.getRecordsManagementUnit(), recordsManagementUnit);
			file.setRecordsManagementUnit(recordsManagementUnit);
		}
	}

	public void setCaseStatus(EntityManager em, CaseFile file, String caseStatus) {
		if (file != null && caseStatus != null) {
			changeLog(em, file.getSystemId(), "saksstatus",
					file.getCaseStatus(), caseStatus);
			file.setCaseStatus(caseStatus);
		}
	}

	public void setLoanedDate(EntityManager em, CaseFile file, Date loanedDate) {
		if (file != null && loanedDate != null) {
			file.setLoanedDate(loanedDate);
		}
	}

	public void setLoanedTo(EntityManager em, CaseFile file, String loanedTo) {
		if (file != null && loanedTo != null) {
			file.setLoanedTo(loanedTo);
		}
	}

}
