package dots.module.hlapi.base;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJBException;
import javax.persistence.EntityManager;

import dots.clb.common.api.base.LLCaseFileAPI;
import dots.clb.common.api.base.LLRegistryEntryAPI;
import dots.clb.common.api.find.LLCaseFileFindAPI;
import dots.clb.common.api.find.LLRegistryEntryFindAPI;
import dots.clb.common.constants.N5Status;
import dots.clb.common.entities.CaseFile;
import dots.clb.common.entities.RegistryEntry;
import dots.module.base.beans.Result;
import dots.module.base.entitybeans.CaseFileBean;
import dots.module.base.entitybeans.ClassBean;
import dots.module.base.entitybeans.DocumentDescriptionBean;
import dots.module.base.entitybeans.DocumentObjectBean;
import dots.module.base.entitybeans.SeriesBean;
import dots.module.base.helpers.EntityHelper;

public class RegistryEntryAPI {

	/** Create **/

	public static Result create(EntityManager em, String caseFileSystemId,
			String title, String officialTitle, String description,
			String documentMedium, String createdBy) {

		// no case file specified
		if (caseFileSystemId == null) {
			// cannot create registry entry
			throw new EJBException();
		}

		// get the specified case file
		CaseFile file = LLCaseFileFindAPI.findBySystemId(em, caseFileSystemId);

		// specified file does not exists or has children
		if (file == null || file.getReferenceChildFile().size() > 0) {
			// cannot create registry entry
			throw new EJBException();
		}

		// create a new registry entry
		String reSystemId = new LLRegistryEntryAPI().createRegistryEntry(em,
				createdBy, null, title, officialTitle, description,
				documentMedium, null, N5Status.RecordStatus.REGISTERED, null);

		// get the newly created registry entry
		RegistryEntry entry = LLRegistryEntryFindAPI.findBySystemId(em,
				reSystemId);

		// add the registry entry to the case file
		new LLCaseFileAPI().addRecord(file, entry);

		return new Result(true, reSystemId);
	}

	/** Delete **/

	public static Result delete(EntityManager em, String systemId) {

		return null;
	}

	/** Get **/

	public static CaseFileBean getCaseFile(EntityManager em, String systemId) {

		RegistryEntry entry = LLRegistryEntryFindAPI.findBySystemId(em,
				systemId);

		if (entry != null) {
			return EntityHelper.entityToBean(entry.getReferenceFile(),
					CaseFileBean.class);
		} else {
			return null;
		}
	}

	public static ClassBean getClass(EntityManager em, String systemId) {
		// TODO
		return null;
	}

	public static List<DocumentDescriptionBean> getDocumentDescriptions(
			EntityManager em, String systemId) {

		RegistryEntry entry = LLRegistryEntryFindAPI.findBySystemId(em,
				systemId);

		if (entry != null) {
			return EntityHelper.entitiesToBeans(
					entry.getReferenceDocumentDescription(),
					DocumentDescriptionBean.class);
		} else {
			return new ArrayList<DocumentDescriptionBean>();
		}
	}

	public static List<DocumentObjectBean> getDocumentObjects(EntityManager em,
			String systemId) {

		RegistryEntry entry = LLRegistryEntryFindAPI.findBySystemId(em,
				systemId);

		if (entry != null) {
			return EntityHelper.entitiesToBeans(
					entry.getReferenceDocumentObject(),
					DocumentObjectBean.class);
		} else {
			return new ArrayList<DocumentObjectBean>();
		}
	}

	public static SeriesBean getSeries(EntityManager em, String systemId) {

		RegistryEntry entry = LLRegistryEntryFindAPI.findBySystemId(em,
				systemId);

		if (entry != null) {
			return EntityHelper.entityToBean(entry.getReferenceSeries(),
					SeriesBean.class);
		} else {
			return null;
		}
	}

}
