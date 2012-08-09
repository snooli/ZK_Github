package dots.clb.common.api.find;

import java.util.List;

import javax.persistence.EntityManager;

import dots.clb.common.constants.Queries;
import dots.clb.common.entities.File;
import dots.clb.common.helpers.QueryHelper;


public class LLFileFindAPI {

	@SuppressWarnings("unchecked")
	public static List<File> findAll(EntityManager em) {

		return (List<File>) QueryHelper.createAndPrepareQuery(em,
				Queries.fileFindAll, File.class).getResultList();
	}

	@SuppressWarnings("rawtypes")
	public static File findBySystemId(EntityManager em, String systemId) {

		List resultList = QueryHelper.createAndPrepareQuery(em,
				Queries.fileFindBySystemId, File.class, systemId)
				.getResultList();

		if (resultList.size() == 0) {
			return null;
		} else {
			return (File) resultList.get(0);
		}
	}

	@SuppressWarnings("rawtypes")
	public static File findByFileId(EntityManager em, String fileId) {

		List resultList = QueryHelper.createAndPrepareQuery(em,
				Queries.fileFindByFileId, File.class, fileId).getResultList();

		if (resultList.size() == 0) {
			return null;
		} else {
			return (File) resultList.get(0);
		}
	}

	@SuppressWarnings("unchecked")
	public static List<File> findAllByTitle(EntityManager em, String title) {

		return (List<File>) QueryHelper.createAndPrepareQuery(em,
				Queries.fileFindAllByTitle, File.class, "%" + title + "%")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<File> findAllByOfficialTitle(EntityManager em,
			String officialTitle) {

		return (List<File>) QueryHelper.createAndPrepareQuery(em,
				Queries.fileFindAllByOfficialTitle, File.class,
				"%" + officialTitle + "%").getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<File> findAllByDescription(EntityManager em,
			String description) {

		return (List<File>) QueryHelper.createAndPrepareQuery(em,
				Queries.fileFindAllByDescription, File.class,
				"%" + description + "%").getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<File> findAllByDocumentMedium(EntityManager em,
			String documentMedium) {

		return (List<File>) QueryHelper
				.createAndPrepareQuery(em, Queries.fileFindAllByDocumentMedium,
						File.class, documentMedium).getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<File> findAllByCreatedBy(EntityManager em,
			String createdBy) {

		return (List<File>) QueryHelper.createAndPrepareQuery(em,
				Queries.fileFindAllByCreatedBy, File.class,
				"%" + createdBy + "%").getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<File> findAllByFinalisedBy(EntityManager em,
			String finalisedBy) {

		return (List<File>) QueryHelper.createAndPrepareQuery(em,
				Queries.fileFindAllByFinalisedBy, File.class,
				"%" + finalisedBy + "%").getResultList();
	}

}
