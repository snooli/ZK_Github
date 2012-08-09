package dots.clb.common.api.find;

import java.util.List;

import javax.persistence.EntityManager;

import dots.clb.common.constants.Queries;
import dots.clb.common.entities.DocumentObject;
import dots.clb.common.helpers.QueryHelper;


public class LLDocumentObjectFindAPI {

	@SuppressWarnings("unchecked")
	public static List<DocumentObject> findAll(EntityManager em) {

		return QueryHelper.createAndPrepareQuery(em,
				Queries.documentObjectFindAll, null).getResultList();
	}

	@SuppressWarnings("rawtypes")
	public static DocumentObject findBySystemId(EntityManager em,
			String systemId) {

		List resultList = QueryHelper.createAndPrepareQuery(em,
				Queries.documentObjectFindBySystemId, null, systemId)
				.getResultList();

		if (resultList.size() == 0) {
			return null;
		} else {
			return (DocumentObject) resultList.get(0);
		}
	}

	@SuppressWarnings("unchecked")
	public static List<DocumentObject> findAllByVersionNumber(EntityManager em,
			Integer versionNumber) {

		return (List<DocumentObject>) QueryHelper.createAndPrepareQuery(em,
				Queries.documentObjectFindAllByVersionNumber, null,
				versionNumber).getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<DocumentObject> findAllByVariantFormat(EntityManager em,
			String variantFormat) {

		return (List<DocumentObject>) QueryHelper.createAndPrepareQuery(em,
				Queries.documentObjectFindAllByVariantFormat, null,
				variantFormat).getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<DocumentObject> findAllByFormat(EntityManager em,
			String format) {

		return (List<DocumentObject>) QueryHelper.createAndPrepareQuery(em,
				Queries.documentObjectFindAllByFormat, null, format)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<DocumentObject> findAllByFormatDetails(EntityManager em,
			String formatDetails) {

		return (List<DocumentObject>) QueryHelper.createAndPrepareQuery(em,
				Queries.documentObjectFindAllByFormatDetails, null,
				formatDetails).getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<DocumentObject> findAllByCreatedBy(EntityManager em,
			String createdBy) {

		return (List<DocumentObject>) QueryHelper.createAndPrepareQuery(em,
				Queries.documentObjectFindAllByCreatedBy, null,
				"%" + createdBy + "%").getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<DocumentObject> findAllByChecksum(EntityManager em,
			String checksum) {

		return (List<DocumentObject>) QueryHelper.createAndPrepareQuery(em,
				Queries.documentObjectFindAllByChecksum, null, checksum)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<DocumentObject> findAllByChecksumAlgorithm(
			EntityManager em, String checksumAlgorithm) {

		return (List<DocumentObject>) QueryHelper.createAndPrepareQuery(em,
				Queries.documentObjectFindAllByChecksumAlgorithm, null,
				checksumAlgorithm).getResultList();
	}

}
