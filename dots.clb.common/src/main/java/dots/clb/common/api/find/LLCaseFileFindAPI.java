package dots.clb.common.api.find;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import dots.clb.common.constants.Queries;
import dots.clb.common.entities.CaseFile;
import dots.clb.common.helpers.QueryHelper;


public class LLCaseFileFindAPI {

	@SuppressWarnings("unchecked")
	public static List<CaseFile> findAll(EntityManager em) {

		return (List<CaseFile>) QueryHelper.createAndPrepareQuery(em,
				Queries.caseFileFindAll, CaseFile.class).getResultList();
	}

	@SuppressWarnings("rawtypes")
	public static CaseFile findBySystemId(EntityManager em, String systemId) {

		List resultList = QueryHelper.createAndPrepareQuery(em,
				Queries.caseFileFindBySystemId, CaseFile.class, systemId)
				.getResultList();

		if (resultList.size() == 0) {
			return null;
		} else {
			return (CaseFile) resultList.get(0);
		}
	}

	@SuppressWarnings("rawtypes")
	public static CaseFile findByFileId(EntityManager em, String fileId) {

		List resultList = QueryHelper.createAndPrepareQuery(em,
				Queries.caseFileFindByFileId, CaseFile.class, fileId)
				.getResultList();

		if (resultList.size() == 0) {
			return null;
		} else {
			return (CaseFile) resultList.get(0);
		}
	}

	@SuppressWarnings("unchecked")
	public static List<CaseFile> findAllByTitle(EntityManager em, String title) {

		return (List<CaseFile>) QueryHelper.createAndPrepareQuery(em,
				Queries.caseFileFindAllByTitle, CaseFile.class,
				"%" + title + "%").getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<CaseFile> findAllByOfficialTitle(EntityManager em,
			String officialTitle) {

		return (List<CaseFile>) QueryHelper.createAndPrepareQuery(em,
				Queries.caseFileFindAllByOfficialTitle, CaseFile.class,
				"%" + officialTitle + "%").getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<CaseFile> findAllByDescription(EntityManager em,
			String description) {

		return (List<CaseFile>) QueryHelper.createAndPrepareQuery(em,
				Queries.caseFileFindAllByDescription, CaseFile.class,
				"%" + description + "%").getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<CaseFile> findAllByDocumentMedium(EntityManager em,
			String documentMedium) {

		return (List<CaseFile>) QueryHelper.createAndPrepareQuery(em,
				Queries.caseFileFindAllByDocumentMedium, CaseFile.class,
				documentMedium).getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<CaseFile> findAllByCreatedBy(EntityManager em,
			String createdBy) {

		return (List<CaseFile>) QueryHelper.createAndPrepareQuery(em,
				Queries.caseFileFindAllByCreatedBy, CaseFile.class,
				"%" + createdBy + "%").getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<CaseFile> findAllByFinalisedBy(EntityManager em,
			String finalisedBy) {

		return (List<CaseFile>) QueryHelper.createAndPrepareQuery(em,
				Queries.caseFileFindAllByFinalisedBy, CaseFile.class,
				"%" + finalisedBy + "%").getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<CaseFile> findAllByCaseYear(EntityManager em,
			Integer caseYear) {

		return (List<CaseFile>) QueryHelper.createAndPrepareQuery(em,
				Queries.caseFileFindAllByCaseYear, CaseFile.class, caseYear)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<CaseFile> findAllByCaseSequenceNumber(EntityManager em,
			Integer caseSequenceNumber) {

		return (List<CaseFile>) QueryHelper.createAndPrepareQuery(em,
				Queries.caseFileFindAllByCaseSequenceNumber, CaseFile.class,
				caseSequenceNumber).getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<CaseFile> findAllByCaseDate(EntityManager em,
			Date caseDate) {

		return (List<CaseFile>) QueryHelper.createAndPrepareQuery(em,
				Queries.caseFileFindAllByCaseDate, CaseFile.class, caseDate)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<CaseFile> findAllByAdministrativeUnit(EntityManager em,
			String administrativeUnit) {

		return (List<CaseFile>) QueryHelper.createAndPrepareQuery(em,
				Queries.caseFileFindAllByAdministrativeUnit, CaseFile.class,
				administrativeUnit).getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<CaseFile> findAllByCaseResponsible(EntityManager em,
			String caseResponsible) {

		return (List<CaseFile>) QueryHelper.createAndPrepareQuery(em,
				Queries.caseFileFindAllByCaseResponsible, CaseFile.class,
				"%" + caseResponsible + "%").getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<CaseFile> findAllByRecordsManagementUnit(
			EntityManager em, String recordsManagementUnit) {

		return (List<CaseFile>) QueryHelper.createAndPrepareQuery(em,
				Queries.caseFileFindAllByRecordsManagementUnit, CaseFile.class,
				recordsManagementUnit).getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<CaseFile> findAllByCaseStatus(EntityManager em,
			String caseStatus) {

		return (List<CaseFile>) QueryHelper
				.createAndPrepareQuery(em, Queries.caseFileFindAllByCaseStatus,
						CaseFile.class, caseStatus).getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<CaseFile> findAllByLoanedDate(EntityManager em,
			Date loanedDate) {

		return (List<CaseFile>) QueryHelper
				.createAndPrepareQuery(em, Queries.caseFileFindAllByLoanedDate,
						CaseFile.class, loanedDate).getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<CaseFile> findAllByLoanedTo(EntityManager em,
			String loanedTo) {

		return (List<CaseFile>) QueryHelper.createAndPrepareQuery(em,
				Queries.caseFileFindAllByLoanedTo, CaseFile.class,
				"%" + loanedTo + "%").getResultList();
	}

}
