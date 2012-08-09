package dots.clb.common.api.find;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import dots.clb.common.constants.Queries;
import dots.clb.common.entities.RegistryEntry;
import dots.clb.common.helpers.QueryHelper;


public class LLRegistryEntryFindAPI {

	@SuppressWarnings("unchecked")
	public static List<RegistryEntry> findAll(EntityManager em) {

		return (List<RegistryEntry>) QueryHelper.createAndPrepareQuery(em,
				Queries.registryEntryFindAll, RegistryEntry.class)
				.getResultList();
	}

	@SuppressWarnings("rawtypes")
	public static RegistryEntry findBySystemId(EntityManager em, String systemId) {

		List resultList = QueryHelper.createAndPrepareQuery(em,
				Queries.registryEntryFindBySystemId, RegistryEntry.class,
				systemId).getResultList();

		if (resultList.size() == 0) {
			return null;
		} else {
			return (RegistryEntry) resultList.get(0);
		}
	}

	@SuppressWarnings("unchecked")
	public static List<RegistryEntry> findAllByCreatedBy(EntityManager em,
			String createdBy) {

		return (List<RegistryEntry>) QueryHelper.createAndPrepareQuery(em,
				Queries.registryEntryFindAllByCreatedBy, RegistryEntry.class,
				"%" + createdBy + "%").getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<RegistryEntry> findAllByArchivedBy(EntityManager em,
			String archivedBy) {

		return (List<RegistryEntry>) QueryHelper.createAndPrepareQuery(em,
				Queries.registryEntryFindAllByArchivedBy, RegistryEntry.class,
				"%" + archivedBy + "%").getResultList();
	}

	@SuppressWarnings("rawtypes")
	public static RegistryEntry findByRecordId(EntityManager em, String recordId) {

		List resultList = QueryHelper.createAndPrepareQuery(em,
				Queries.registryEntryFindByRecordId, RegistryEntry.class,
				recordId).getResultList();

		if (resultList.size() == 0) {
			return null;
		} else {
			return (RegistryEntry) resultList.get(0);
		}
	}

	@SuppressWarnings("unchecked")
	public static List<RegistryEntry> findAllByTitle(EntityManager em,
			String title) {

		return (List<RegistryEntry>) QueryHelper.createAndPrepareQuery(em,
				Queries.registryEntryFindAllByTitle, RegistryEntry.class,
				"%" + title + "%").getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<RegistryEntry> findAllByOfficialTitle(EntityManager em,
			String officialTitle) {

		return (List<RegistryEntry>) QueryHelper.createAndPrepareQuery(em,
				Queries.registryEntryFindAllByOfficialTitle,
				RegistryEntry.class, "%" + officialTitle + "%").getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<RegistryEntry> findAllByDescription(EntityManager em,
			String description) {

		return (List<RegistryEntry>) QueryHelper.createAndPrepareQuery(em,
				Queries.registryEntryFindAllByDescription, RegistryEntry.class,
				"%" + description + "%").getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<RegistryEntry> findAllByDocumentMedium(EntityManager em,
			String documentMedium) {

		return (List<RegistryEntry>) QueryHelper.createAndPrepareQuery(em,
				Queries.registryEntryFindAllByDocumentMedium,
				RegistryEntry.class, documentMedium).getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<RegistryEntry> findAllByRecordYear(EntityManager em,
			Integer recordYear) {

		return (List<RegistryEntry>) QueryHelper.createAndPrepareQuery(em,
				Queries.registryEntryFindAllByRecordYear, RegistryEntry.class,
				recordYear).getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<RegistryEntry> findAllByRecordSequenceNumber(
			EntityManager em, Integer recordSequenceNumber) {

		return (List<RegistryEntry>) QueryHelper.createAndPrepareQuery(em,
				Queries.registryEntryFindAllByRecordSequenceNumber,
				RegistryEntry.class, recordSequenceNumber).getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<RegistryEntry> findAllByRegistryEntryNumber(
			EntityManager em, Integer registryEntryNumber) {

		return (List<RegistryEntry>) QueryHelper.createAndPrepareQuery(em,
				Queries.registryEntryFindAllByRegistryEntryNumber,
				RegistryEntry.class, registryEntryNumber).getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<RegistryEntry> findAllByRegistryEntryType(
			EntityManager em, String registryEntryType) {

		return (List<RegistryEntry>) QueryHelper.createAndPrepareQuery(em,
				Queries.registryEntryFindAllByRegistryEntryType,
				RegistryEntry.class, registryEntryType).getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<RegistryEntry> findAllByRecordStatus(EntityManager em,
			String recordStatus) {

		return (List<RegistryEntry>) QueryHelper.createAndPrepareQuery(em,
				Queries.registryEntryFindAllByRecordStatus,
				RegistryEntry.class, recordStatus).getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<RegistryEntry> findAllByRecordDate(EntityManager em,
			Date recordDate) {

		return (List<RegistryEntry>) QueryHelper.createAndPrepareQuery(em,
				Queries.registryEntryFindAllByRecordDate, RegistryEntry.class,
				recordDate).getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<RegistryEntry> findAllByDocumentDate(EntityManager em,
			Date documentDate) {

		return (List<RegistryEntry>) QueryHelper.createAndPrepareQuery(em,
				Queries.registryEntryFindAllByDocumentDate,
				RegistryEntry.class, documentDate).getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<RegistryEntry> findAllByDueDate(EntityManager em,
			Date dueDate) {

		return (List<RegistryEntry>) QueryHelper.createAndPrepareQuery(em,
				Queries.registryEntryFindAllByDueDate, RegistryEntry.class,
				dueDate).getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<RegistryEntry> findAllByFreedomAssessmentDate(
			EntityManager em, Date freedomAssessmentDate) {

		return (List<RegistryEntry>) QueryHelper.createAndPrepareQuery(em,
				Queries.registryEntryFindAllByFreedomAssessmentDate,
				RegistryEntry.class, freedomAssessmentDate).getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<RegistryEntry> findAllByNumberOfAttachments(
			EntityManager em, Integer numberOfAttachments) {

		return (List<RegistryEntry>) QueryHelper.createAndPrepareQuery(em,
				Queries.registryEntryFindAllByNumberOfAttachments,
				RegistryEntry.class, numberOfAttachments).getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<RegistryEntry> findAllByLoanedDate(EntityManager em,
			Date loanedDate) {

		return (List<RegistryEntry>) QueryHelper.createAndPrepareQuery(em,
				Queries.registryEntryFindAllByLoanedDate, RegistryEntry.class,
				loanedDate).getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<RegistryEntry> findAllByLoanedTo(EntityManager em,
			String loanedTo) {

		return (List<RegistryEntry>) QueryHelper.createAndPrepareQuery(em,
				Queries.registryEntryFindAllByLoanedTo, RegistryEntry.class,
				"%" + loanedTo + "%").getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<RegistryEntry> findAllByRecordsManagementUnit(
			EntityManager em, String recordsManagementUnit) {

		return (List<RegistryEntry>) QueryHelper.createAndPrepareQuery(em,
				Queries.registryEntryFindAllByRecordsManagementUnit,
				RegistryEntry.class, recordsManagementUnit).getResultList();
	}

}
