package dots.clb.common.api.base;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.ejb.EJBException;
import javax.persistence.EntityManager;

import dots.clb.common.entities.RegistryEntry;
import dots.clb.common.helpers.ElementHelper;


public class LLRegistryEntryAPI extends LLBasicRecordAPI {

	/** Create **/

	public String createRegistryEntry(EntityManager em, String createdBy,
			String recordId, String title, String officialTitle,
			String description, String documentMedium,
			String registryEntryType, String recordStatus,
			String recordsManagementUnit) {

		RegistryEntry entry = new RegistryEntry();
		setSystemId(em, entry, UUID.randomUUID().toString());

		if (createdBy == null || createdBy.isEmpty()) {
			throw new EJBException();
		}

		setCreatedBy(em, entry, createdBy);
		setCreatedDate(em, entry, Calendar.getInstance().getTime());

		setRecordId(em, entry, recordId);
		setTitle(em, entry, title);
		setOfficialTitle(em, entry, officialTitle);
		setDescription(em, entry, description);
		setDocumentMedium(em, entry, documentMedium);
		setRegistryEntryType(em, entry, registryEntryType);
		setRecordStatus(em, entry, recordStatus);
		setRecordsManagementUnit(em, entry, recordsManagementUnit);

		em.persist(entry);

		return entry.getSystemId();
	}

	/** Delete **/

	public void deleteRegistryEntry(EntityManager em, RegistryEntry entry) {

		em.remove(entry);
	}

	/** Set **/

	public void setRecordYear(EntityManager em, RegistryEntry entry,
			Integer recordYear) {
		if (entry != null && recordYear != null) {
			entry.setRecordYear(recordYear);
		}
	}

	public void setRecordSequenceNumber(EntityManager em, RegistryEntry entry,
			Integer recordSequenceNumber) {
		if (entry != null && recordSequenceNumber != null) {
			entry.setRecordSequenceNumber(recordSequenceNumber);
		}
	}

	public void setRegistryEntryNumber(EntityManager em, RegistryEntry entry,
			Integer registryEntryNumber) {
		if (entry != null && registryEntryNumber != null) {
			entry.setRegistryEntryNumber(registryEntryNumber);
		}
	}

	public void setRegistryEntryType(EntityManager em, RegistryEntry entry,
			String registryEntryType) {
		if (entry != null && registryEntryType != null) {
			entry.setRegistryEntryType(registryEntryType);
		}
	}

	public void setRecordStatus(EntityManager em, RegistryEntry entry,
			String recordStatus) {
		if (entry != null && recordStatus != null) {
			changeLog(em, entry.getSystemId(), "journalstatus",
					entry.getRecordStatus(), recordStatus);
			entry.setRecordStatus(recordStatus);
		}
	}

	public void setRecordDate(EntityManager em, RegistryEntry entry,
			Date recordDate) {
		if (entry != null && recordDate != null) {
			changeLog(em, entry.getSystemId(), "journaldato",
					ElementHelper.dateToString(entry.getRecordDate()),
					ElementHelper.dateToString(recordDate));
			entry.setRecordDate(recordDate);
		}
	}

	public void setDocumentDate(EntityManager em, RegistryEntry entry,
			Date documentDate) {
		if (entry != null && documentDate != null) {
			changeLog(em, entry.getSystemId(), "dokumentetsDato",
					ElementHelper.dateToString(entry.getDocumentDate()),
					ElementHelper.dateToString(documentDate));
			entry.setDocumentDate(documentDate);
		}
	}

	public void setReceivedDate(EntityManager em, RegistryEntry entry,
			Date receivedDate) {
		if (entry != null && receivedDate != null) {
			changeLog(em, entry.getSystemId(), "mottattDato",
					ElementHelper.dateTimeToString(entry.getReceivedDate()),
					ElementHelper.dateTimeToString(receivedDate));
			entry.setReceivedDate(receivedDate);
		}
	}

	public void setSentDate(EntityManager em, RegistryEntry entry, Date sentDate) {
		if (entry != null && sentDate != null) {
			changeLog(em, entry.getSystemId(), "sendtDato",
					ElementHelper.dateTimeToString(entry.getSentDate()),
					ElementHelper.dateTimeToString(sentDate));
			entry.setSentDate(sentDate);
		}
	}

	public void setDueDate(EntityManager em, RegistryEntry entry, Date dueDate) {
		if (entry != null && dueDate != null) {
			entry.setDueDate(dueDate);
		}
	}

	public void setFreedomAssessmentDate(EntityManager em, RegistryEntry entry,
			Date freedomAssessmentDate) {
		if (entry != null && freedomAssessmentDate != null) {
			entry.setFreedomAssessmentDate(freedomAssessmentDate);
			changeLog(
					em,
					entry.getSystemId(),
					"offentlighetsvurdertDato",
					ElementHelper.dateToString(entry.getFreedomAssessmentDate()),
					ElementHelper.dateToString(freedomAssessmentDate));
		}
	}

	public void setNumberOfAttachments(EntityManager em, RegistryEntry entry,
			Integer numberOfAttachments) {
		if (entry != null && numberOfAttachments != null) {
			entry.setNumberOfAttachments(numberOfAttachments);
		}
	}

	public void setLoanedDate(EntityManager em, RegistryEntry entry,
			Date loanedDate) {
		if (entry != null && loanedDate != null) {
			entry.setLoanedDate(loanedDate);
		}
	}

	public void setLoanedTo(EntityManager em, RegistryEntry entry, Date loanedTo) {
		if (entry != null && loanedTo != null) {
			entry.setLoanedTo(loanedTo);
		}
	}

	public void setRecordsManagementUnit(EntityManager em, RegistryEntry entry,
			String recordsManagementUnit) {
		if (entry != null && recordsManagementUnit != null) {
			entry.setRecordsManagementUnit(recordsManagementUnit);
		}
	}

}
