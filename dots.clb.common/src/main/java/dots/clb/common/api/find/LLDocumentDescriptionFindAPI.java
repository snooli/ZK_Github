package dots.clb.common.api.find;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import dots.clb.common.constants.Queries;
import dots.clb.common.entities.DocumentDescription;
import dots.clb.common.helpers.QueryHelper;


public class LLDocumentDescriptionFindAPI {

	@SuppressWarnings("unchecked")
	public static List<DocumentDescription> findAll(EntityManager em) {

		return (List<DocumentDescription>) QueryHelper.createAndPrepareQuery(
				em, Queries.documentDescriptionFindAll, null).getResultList();
	}

	@SuppressWarnings("rawtypes")
	public static DocumentDescription findBySystemId(EntityManager em,
			String systemId) {

		List resultList = QueryHelper.createAndPrepareQuery(em,
				Queries.documentDescriptionFindBySystemId, null, systemId)
				.getResultList();

		if (resultList.size() == 0) {
			return null;
		} else {
			return (DocumentDescription) resultList.get(0);
		}
	}

	@SuppressWarnings("unchecked")
	public static List<DocumentDescription> findAllByDocumentType(
			EntityManager em, String documentType) {

		return (List<DocumentDescription>) QueryHelper.createAndPrepareQuery(
				em, Queries.documentDescriptionFindAllByDocumentType, null,
				documentType).getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<DocumentDescription> findAllByDocumentStatus(
			EntityManager em, String documentStatus) {

		return (List<DocumentDescription>) QueryHelper.createAndPrepareQuery(
				em, Queries.documentDescriptionFindAllByDocumentStatus, null,
				documentStatus).getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<DocumentDescription> findAllByTitle(EntityManager em,
			String title) {

		return (List<DocumentDescription>) QueryHelper.createAndPrepareQuery(
				em, Queries.documentDescriptionFindAllByTitle, null,
				"%" + title + "%").getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<DocumentDescription> findAllByDescription(
			EntityManager em, String description) {

		return (List<DocumentDescription>) QueryHelper.createAndPrepareQuery(
				em, Queries.documentDescriptionFindAllByDescription, null,
				"%" + description + "%").getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<DocumentDescription> findAllByCreatedBy(
			EntityManager em, String createdBy) {

		return (List<DocumentDescription>) QueryHelper.createAndPrepareQuery(
				em, Queries.documentDescriptionFindAllByCreatedBy, null,
				"%" + createdBy + "%").getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<DocumentDescription> findAllByDocumentMedium(
			EntityManager em, String documentMedium) {

		return (List<DocumentDescription>) QueryHelper.createAndPrepareQuery(
				em, Queries.documentDescriptionFindAllByDocumentMedium, null,
				documentMedium).getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<DocumentDescription> findAllByAssociatedWithRecordAs(
			EntityManager em, String associatedWithRecordAs) {

		return (List<DocumentDescription>) QueryHelper.createAndPrepareQuery(
				em, Queries.documentDescriptionFindAllByAssociatedWithRecordAs,
				null, associatedWithRecordAs).getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<DocumentDescription> findAllByDocumentNumber(
			EntityManager em, Integer documentNumber) {

		return (List<DocumentDescription>) QueryHelper.createAndPrepareQuery(
				em, Queries.documentDescriptionFindAllByDocumentNumber, null,
				documentNumber).getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<DocumentDescription> findAllByAssociationDate(
			EntityManager em, Date associationDate) {

		return (List<DocumentDescription>) QueryHelper.createAndPrepareQuery(
				em, Queries.documentDescriptionFindAllByAssociationDate, null,
				associationDate).getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<DocumentDescription> findAllByAssociatedBy(
			EntityManager em, String associatedBy) {

		return (List<DocumentDescription>) QueryHelper.createAndPrepareQuery(
				em, Queries.documentDescriptionFindAllByAssociatedBy, null,
				"%" + associatedBy + "%").getResultList();
	}

}
