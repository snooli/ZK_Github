package dots.module.base.service1;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.jboss.wsf.spi.annotation.WebContext;

import dots.module.base.beans.Result;
import dots.module.base.entitybeans.CaseFileBean;
import dots.module.base.entitybeans.ClassBean;
import dots.module.base.entitybeans.ClassificationSystemBean;
import dots.module.base.entitybeans.DocumentDescriptionBean;
import dots.module.base.entitybeans.DocumentObjectBean;
import dots.module.base.entitybeans.FondsBean;
import dots.module.base.entitybeans.FondsCreatorBean;
import dots.module.base.entitybeans.RegistryEntryBean;
import dots.module.base.entitybeans.SeriesBean;

@WebService
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@WebContext(contextRoot = "/n5", urlPattern = "/Noark5BaseService1")
@Stateless(mappedName = "Noark5BaseService1")
public class Noark5BaseService1 implements INoark5BaseService1 {

	@PersistenceContext
	EntityManager em;

	@SuppressWarnings("unused")
	@Resource
	private SessionContext ctx;

	/** Fonds **/

	@Override
	@WebMethod(action = "fondsCreate")
	public Result fondsCreate(
			@WebParam(name = "fondsCreatorId") String fondsCreatorId, 
			@WebParam(name = "parentFondsSystemId") String parentFondsSystemId,
			@WebParam(name = "title") String title, 
			@WebParam(name = "description") String description, 
			@WebParam(name = "createdBy") String createdBy,
			@WebParam(name = "documentMedium") String documentMedium) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "fondsDelete")	
	public Result fondsDelete(@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "fondsGetParentFonds")	
	public FondsBean fondsGetParentFonds(@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "fondsGetChildFonds")
	public List<FondsBean> fondsGetChildFonds(@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "fondsGetSeries")
	public List<SeriesBean> fondsGetSeries(@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "fondsGetFondsCreators")
	public List<FondsCreatorBean> fondsGetFondsCreators(@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "fondsCreatorCreate")
	public Result fondsCreatorCreate(
			@WebParam(name = "fondsCreatorId") String fondsCreatorId, 
			@WebParam(name = "fondsCreatorName") String fondsCreatorName,
			@WebParam(name = "description") String description) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "fondsCreatorDelete")
	public Result fondsCreatorDelete(@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	/** Series **/

	@Override
	@WebMethod(action = "seriesCreate")
	public Result seriesCreate(
			@WebParam(name = "fondsSystemId") String fondsSystemId, 			
			@WebParam(name = "precursorSystemId") String precursorSystemId,
			@WebParam(name = "csSystemId") String csSystemId, 
			@WebParam(name = "title") String title, 
			@WebParam(name = "description") String description, 
			@WebParam(name = "documentMedium") String documentMedium,
			@WebParam(name = "createdBy") String createdBy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "seriesDelete")
	public Result seriesDelete(@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "seriesGetPrecursor")
	public SeriesBean seriesGetPrecursor(@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "seriesGetSuccessor")
	public SeriesBean seriesGetSuccessor(@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "seriesGetClassificationSystem")
	public ClassificationSystemBean seriesGetClassificationSystem(
			@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "seriesGetCaseFiles")
	public List<CaseFileBean> seriesGetCaseFiles(@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	/** ClassificationSystem **/

	@Override
	@WebMethod(action = "classificationSystemCreate")
	public Result classificationSystemCreate(
			@WebParam(name = "title") String title, 
			@WebParam(name = "createdBy") String createdBy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "classificationSystemDelete")
	public Result classificationSystemDelete(@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "classificationSystemGetSeries")
	public List<SeriesBean> classificationSystemGetSeries(
			@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "classificationSystemGetChildClasses")
	public List<ClassBean> classificationSystemGetChildClasses(
			@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	/** Class **/

	@Override
	@WebMethod(action = "classCreate")
	public Result classCreate(
			@WebParam(name = "csSystemId") String csSystemId, 
			@WebParam(name = "parentFileSystemId") String parentFileSystemId,
			@WebParam(name = "title") String title,
			@WebParam(name = "description") String description, 
			@WebParam(name = "createdBy") String createdBy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "classDelete")
	public Result classDelete(@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "classGetClassificationSystem")
	public ClassificationSystemBean classGetClassificationSystem(
			@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "classGetChildClasses")
	public List<ClassBean> classGetChildClasses(
			@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "classGetParentClass")
	public ClassBean classGetParentClass(
			@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "classGetCaseFiles")
	public List<CaseFileBean> classGetCaseFiles(
			@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "classGetRegistryEntries")
	public List<RegistryEntryBean> classGetRegistryEntries(
			@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "classAddCaseFile")
	public Result classAddCaseFile(
			@WebParam(name = "classSystemId") String classSystemId, 
			@WebParam(name = "caseFileSystemId") String caseFileSystemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "classAddRegistryEntry")
	public Result classAddRegistryEntry(
			@WebParam(name = "classSystemId") String classSystemId, 
			@WebParam(name = "entrySystemId") String entrySystemId) {
		// TODO Auto-generated method stub
		return null;
	}

	/** CaseFile **/

	@Override
	@WebMethod(action = "caseFileCreate")
	public Result caseFileCreate(
			@WebParam(name = "seriesSystemId") String seriesSystemId, 
			@WebParam(name = "parentFileSystemId") String parentFileSystemId,
			@WebParam(name = "title") String title,
			@WebParam(name = "officialTitle") String officialTitle,
			@WebParam(name = "description") String description, 
			@WebParam(name = "documentMedium") String documentMedium,
			@WebParam(name = "createdBy") String createdBy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "caseFileDelete")
	public Result caseFileDelete(
			@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "caseFileGetParentCaseFile")
	public CaseFileBean caseFileGetParentCaseFile(
			@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "caseFileGetChildCaseFiles")
	public List<CaseFileBean> caseFileGetChildCaseFiles(
			@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "caseFileGetSeries")
	public SeriesBean caseFileGetSeries(
			@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "caseFileGetClass")
	public ClassBean caseFileGetClass(
			@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "caseFileGetRegistryEntries")
	public List<RegistryEntryBean> caseFileGetRegistryEntries(
			@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	/** RegistryEntry **/

	@Override
	@WebMethod(action = "registryEntryCreate")
	public Result registryEntryCreate(
			@WebParam(name = "caseFileSystemId") String caseFileSystemId, 
			@WebParam(name = "title") String title,
			@WebParam(name = "officialTitle") String officialTitle,
			@WebParam(name = "description") String description, 
			@WebParam(name = "documentMedium") String documentMedium,
			@WebParam(name = "createdBy") String createdBy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "registryEntryDelete")
	public Result registryEntryDelete(
			@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "registryEntryGetCaseFile")
	public CaseFileBean registryEntryGetCaseFile(
			@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "registryEntryGetClass")
	public ClassBean registryEntryGetClass(
			@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "registryEntryGetDocumentDescriptions")
	public List<DocumentDescriptionBean> registryEntryGetDocumentDescriptions(
			@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	/** DocumentDescription & DocumentObject **/

	@Override
	@WebMethod(action = "documentCreate")
	public Result documentCreate(
			@WebParam(name = "reSystemId") String reSystemId, 
			@WebParam(name = "documentType") String documentType, 
			@WebParam(name = "title") String title,
			@WebParam(name = "description") String description, 
			@WebParam(name = "documentMedium") String documentMedium,
			@WebParam(name = "createdBy") String createdBy,
			@WebParam(name = "base64Content") String base64Content,
			@WebParam(name = "extension") String extension,
			@WebParam(name = "format") String format) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "documentGet")
	public String documentGet(@WebParam(name = "ddSystemId") String ddSystemId) {
		// TODO
		return null;
	}

	/** DocumentDescription **/

	@Override
	@WebMethod(action = "documentDescriptionDelete")
	public Result documentDescriptionDelete(@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "documentDescriptionGetRegistryEntries")
	public List<RegistryEntryBean> documentDescriptionGetRegistryEntries(
			@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "documentDescriptionGetDocumentObjects")
	public List<DocumentObjectBean> documentDescriptionGetDocumentObjects(
			@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	/** DocumentObject **/

	@Override
	@WebMethod(action = "documentObjectDelete")
	public Result documentObjectDelete(@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "documentObjectGetDocumentDescription")
	public DocumentDescriptionBean documentObjectGetDocumentDescription(
			@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

}