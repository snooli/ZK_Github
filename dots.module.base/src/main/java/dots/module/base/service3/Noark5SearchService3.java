package dots.module.base.service3;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.jboss.wsf.spi.annotation.WebContext;

import dots.module.base.entitybeans.CaseFileBean;
import dots.module.base.entitybeans.ChangeLogEntryBean;
import dots.module.base.entitybeans.DocumentDescriptionBean;
import dots.module.base.entitybeans.DocumentObjectBean;
import dots.module.base.entitybeans.FondsBean;
import dots.module.base.entitybeans.FondsCreatorBean;
import dots.module.base.entitybeans.RegistryEntryBean;
import dots.module.base.entitybeans.SeriesBean;
import dots.module.hlapi.find.CaseFileFindAPI;
import dots.module.hlapi.find.ChangeLogEntryFindAPI;
import dots.module.hlapi.find.DocumentDescriptionFindAPI;
import dots.module.hlapi.find.DocumentObjectFindAPI;
import dots.module.hlapi.find.FondsCreatorFindAPI;
import dots.module.hlapi.find.FondsFindAPI;
import dots.module.hlapi.find.RegistryEntryFindAPI;
import dots.module.hlapi.find.SeriesFindAPI;

@WebService
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@WebContext(contextRoot = "/n5", urlPattern = "/Noark5SearchService3")
@Stateless(mappedName = "Noark5SearchService3")
public class Noark5SearchService3 implements INoark5SearchService3 {

	@PersistenceContext
	EntityManager em;

	/** Fonds **/

	@Override
	@WebMethod(action = "fondsFindBySystem")
	public FondsBean fondsFindBySystemId(
			@WebParam(name = "systemId") String systemId) {
		
		return FondsFindAPI.findBySystemId(em, systemId);
	}

	@Override
	@WebMethod(action = "fondsFindAll")
	public List<FondsBean> fondsFindAll() {

		return FondsFindAPI.findAll(em);
	}

	@Override
	@WebMethod(action = "fondsFindTopLevel")
	public List<FondsBean> fondsFindTopLevel() {

		return FondsFindAPI.findTopLevel(em);
	}

	@Override
	@WebMethod(action = "fondsFindAllByTitle")
	public List<FondsBean> fondsFindAllByTitle(@WebParam(name = "title") String title) {

		return FondsFindAPI.findAllByTitle(em, title);
	}

	@Override
	@WebMethod(action = "fondsFindAllByDescription")
	public List<FondsBean> fondsFindAllByDescription(
			@WebParam(name = "description") String description) {

		return FondsFindAPI.findAllByDescription(em, description);
	}

	@Override
	@WebMethod(action = "fondsFindAllByCreatedBy")
	public List<FondsBean> fondsFindAllByCreatedBy(
			@WebParam(name = "createdBy") String createdBy) {

		return FondsFindAPI.findAllByCreatedBy(em, createdBy);
	}

	@Override
	@WebMethod(action = "fondsCreatorFindBySystemId")
	public FondsCreatorBean fondsCreatorFindBySystemId(
			@WebParam(name = "systemId") String systemId) {

		return FondsCreatorFindAPI.findBySystemId(em, systemId);
	}

	@Override
	@WebMethod(action = "fondsCreatorFindByFondsCreatorId")
	public FondsCreatorBean fondsCreatorFindByFondsCreatorId(
			@WebParam(name = "fondsCreatorId") String fondsCreatorId) {

		return FondsCreatorFindAPI.findByFondsCreatorId(em, fondsCreatorId);
	}

	@Override
	@WebMethod(action = "fondsCreatorFindAll")
	public List<FondsCreatorBean> fondsCreatorFindAll() {

		return FondsCreatorFindAPI.findAll(em);
	}

	@Override
	@WebMethod(action = "fondsCreatorFindAllByFondsCreatorName")
	public List<FondsCreatorBean> fondsCreatorFindAllByFondsCreatorName(
			@WebParam(name = "fondsCreatorName") String fondsCreatorName) {

		return FondsCreatorFindAPI.findAllByFondsCreatorName(em,
				fondsCreatorName);
	}

	@Override
	@WebMethod(action = "fondsCreatorFindAllByDescription")
	public List<FondsCreatorBean> fondsCreatorFindAllByDescription(
			@WebParam(name = "description") String description) {

		return FondsCreatorFindAPI.findAllByDescription(em, description);
	}

	/** Series **/

	@Override
	@WebMethod(action = "seriesFindBySystemId")
	public SeriesBean seriesFindBySystemId(
			@WebParam(name = "systemId") String systemId) {

		return SeriesFindAPI.findBySystemId(em, systemId);
	}

	@Override
	@WebMethod(action = "seriesFindAll")
	public List<SeriesBean> seriesFindAll() {

		return SeriesFindAPI.findAll(em);
	}

	@Override
	@WebMethod(action = "seriesFindAllByTitle")
	public List<SeriesBean> seriesFindAllByTitle(
			@WebParam(name = "title") String title) {

		return SeriesFindAPI.findAllByTitle(em, title);
	}

	@Override
	@WebMethod(action = "seriesFindAllByDescription")
	public List<SeriesBean> seriesFindAllByDescription(
			@WebParam(name = "description") String description) {

		return SeriesFindAPI.findAllByDescription(em, description);
	}

	@Override
	@WebMethod(action = "seriesFindAllByCreatedBy")
	public List<SeriesBean> seriesFindAllByCreatedBy(
			@WebParam(name = "createdBy") String createdBy) {

		return SeriesFindAPI.findAllByCreatedBy(em, createdBy);
	}

	/** CaseFile **/

	@Override
	@WebMethod(action = "caseFileFindBySystemId")
	public CaseFileBean caseFileFindBySystemId(
			@WebParam(name = "systemId") String systemId) {

		return CaseFileFindAPI.findBySystemId(em, systemId);
	}

	@Override
	@WebMethod(action = "caseFileFindAll")
	public List<CaseFileBean> caseFileFindAll() {

		return CaseFileFindAPI.findAll(em);
	}

	@Override
	@WebMethod(action = "caseFileFindAllByTitle")
	public List<CaseFileBean> caseFileFindAllByTitle(
			@WebParam(name = "title") String title) {

		return CaseFileFindAPI.findAllByTitle(em, title);
	}

	@Override
	@WebMethod(action = "caseFileFindAllByDescription")
	public List<CaseFileBean> caseFileFindAllByDescription(
			@WebParam(name = "description") String description) {

		return CaseFileFindAPI.findAllByDescription(em, description);
	}

	@Override
	@WebMethod(action = "caseFileFindAllByCreatedBy")
	public List<CaseFileBean> caseFileFindAllByCreatedBy(
			@WebParam(name = "createdBy") String createdBy) {

		return CaseFileFindAPI.findAllByCreatedBy(em, createdBy);
	}

	/** RegistryEntry **/

	@Override
	@WebMethod(action = "registryEntryFindBySystemId")
	public RegistryEntryBean registryEntryFindBySystemId(
			@WebParam(name = "systemId") String systemId) {

		return RegistryEntryFindAPI.findBySystemId(em, systemId);
	}

	@Override
	@WebMethod(action = "registryEntryFindByRecordId")
	public RegistryEntryBean registryEntryFindByRecordId(
			@WebParam(name = "recordId") String recordId) {

		return RegistryEntryFindAPI.findByRecordId(em, recordId);
	}

	@Override
	@WebMethod(action = "registryEntryFindAll")
	public List<RegistryEntryBean> registryEntryFindAll() {

		return RegistryEntryFindAPI.findAll(em);
	}

	@Override
	@WebMethod(action = "registryEntryFindAllByTitle")
	public List<RegistryEntryBean> registryEntryFindAllByTitle(
			@WebParam(name = "title") String title) {

		return RegistryEntryFindAPI.findAllByTitle(em, title);
	}

	@Override
	@WebMethod(action = "registryEntryFindAllByDescription")
	public List<RegistryEntryBean> registryEntryFindAllByDescription(
			@WebParam(name = "description") String description) {

		return RegistryEntryFindAPI.findAllByDescription(em, description);
	}

	@Override
	@WebMethod(action = "registryEntryFindAllByCreatedBy")
	public List<RegistryEntryBean> registryEntryFindAllByCreatedBy(
			@WebParam(name = "createdBy") String createdBy) {

		return RegistryEntryFindAPI.findAllByCreatedBy(em, createdBy);
	}

	/** DocumentDescription **/

	@Override
	@WebMethod(action = "documentDescriptionFindBySystemId")
	public DocumentDescriptionBean documentDescriptionFindBySystemId(
			@WebParam(name = "systemId") String systemId) {

		return DocumentDescriptionFindAPI.findBySystemId(em, systemId);
	}

	@Override
	@WebMethod(action = "documentDescriptionFindAll")
	public List<DocumentDescriptionBean> documentDescriptionFindAll() {

		return DocumentDescriptionFindAPI.findAll(em);
	}

	@Override
	@WebMethod(action = "documentDescriptionFindAllByTitle")
	public List<DocumentDescriptionBean> documentDescriptionFindAllByTitle(
			@WebParam(name = "title") String title) {

		return DocumentDescriptionFindAPI.findAllByTitle(em, title);
	}

	@Override
	@WebMethod(action = "documentDescriptionFindAllByDescription")
	public List<DocumentDescriptionBean> documentDescriptionFindAllByDescription(
			@WebParam(name = "description") String description) {

		return DocumentDescriptionFindAPI.findAllByDescription(em, description);
	}

	@Override
	@WebMethod(action = "documentDescriptionFindAllByCreatedBy")
	public List<DocumentDescriptionBean> documentDescriptionFindAllByCreatedBy(
			@WebParam(name = "createdBy") String createdBy) {

		return DocumentDescriptionFindAPI.findAllByCreatedBy(em, createdBy);
	}

	/** DocumentObject **/

	@Override
	@WebMethod(action = "documentObjectFindBySystemId")
	public DocumentObjectBean documentObjectFindBySystemId(
			@WebParam(name = "systemId") String systemId) {

		return DocumentObjectFindAPI.findBySystemId(em, systemId);
	}

	@Override
	@WebMethod(action = "documentObjectFindAll")
	public List<DocumentObjectBean> documentObjectFindAll() {

		return DocumentObjectFindAPI.findAll(em);
	}

	@Override
	@WebMethod(action = "documentObjectFindAllByCreatedBy")
	public List<DocumentObjectBean> documentObjectFindAllByCreatedBy(
			@WebParam(name = "createdBy") String createdBy) {

		return DocumentObjectFindAPI.findAllByCreatedBy(em, createdBy);
	}

	/** ChangeLogEntry **/

	@Override
	@WebMethod(action = "changeLogEntryFindAll")
	public List<ChangeLogEntryBean> changeLogEntryFindAll() {

		return ChangeLogEntryFindAPI.findAll(em);
	}

}
