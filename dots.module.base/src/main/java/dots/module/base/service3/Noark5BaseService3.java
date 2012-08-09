package dots.module.base.service3;

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
import dots.module.base.entitybeans.DocumentDescriptionBean;
import dots.module.base.entitybeans.DocumentObjectBean;
import dots.module.base.entitybeans.FondsBean;
import dots.module.base.entitybeans.FondsCreatorBean;
import dots.module.base.entitybeans.RegistryEntryBean;
import dots.module.base.entitybeans.SeriesBean;
import dots.module.hlapi.base.CaseFileAPI;
import dots.module.hlapi.base.DocumentAPI;
import dots.module.hlapi.base.FondsAPI;
import dots.module.hlapi.base.FondsCreatorAPI;
import dots.module.hlapi.base.RegistryEntryAPI;
import dots.module.hlapi.base.SeriesAPI;

@WebService
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@WebContext(contextRoot = "/n5", urlPattern = "/Noark5BaseService3")
@Stateless(mappedName = "Noark5BaseService3")
public class Noark5BaseService3 implements INoark5BaseService3 {

	@PersistenceContext
	EntityManager em;

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
		try {
			return FondsAPI.create(em, fondsCreatorId, parentFondsSystemId,
					title, description, documentMedium, createdBy);
		} catch (Exception ex) {
			ex.printStackTrace();
			ctx.setRollbackOnly();
			return new Result(false);
		}
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
		return FondsAPI.getParentFonds(em, systemId);
	}

	@Override
	@WebMethod(action = "fondsGetChildFonds")
	public List<FondsBean> fondsGetChildFonds(@WebParam(name = "systemId") String systemId) {
		return FondsAPI.getChildFonds(em, systemId);
	}

	@Override
	@WebMethod(action = "fondsGetSeries")
	public List<SeriesBean> fondsGetSeries(@WebParam(name = "systemId") String systemId) {
		return FondsAPI.getSeries(em, systemId);
	}

	@Override
	@WebMethod(action = "fondsGetFondsCreators")
	public List<FondsCreatorBean> fondsGetFondsCreators(@WebParam(name = "systemId") String systemId) {
		return FondsAPI.getFondsCreators(em, systemId);
	}
	
	@Override
	@WebMethod(action = "fondsCreatorCreate")
	public Result fondsCreatorCreate(
			@WebParam(name = "fondsCreatorId") String fondsCreatorId, 
			@WebParam(name = "fondsCreatorName") String fondsCreatorName,
			@WebParam(name = "description") String description) {
		try {
			return FondsCreatorAPI.create(em, fondsCreatorId, fondsCreatorName,
					description);
		} catch (Exception ex) {
			ex.printStackTrace();
			ctx.setRollbackOnly();
			return new Result(false);
		}
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
			@WebParam(name = "title") String title, 
			@WebParam(name = "description") String description, 
			@WebParam(name = "documentMedium") String documentMedium,
			@WebParam(name = "createdBy") String createdBy) {
		try {
			return SeriesAPI.create(em, fondsSystemId, precursorSystemId,
					title, description, documentMedium, createdBy);
		} catch (Exception ex) {
			ex.printStackTrace();
			ctx.setRollbackOnly();
			return new Result(false);
		}
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
		return SeriesAPI.getPrecursor(em, systemId);
	}

	@Override
	@WebMethod(action = "seriesGetSuccessor")
	public SeriesBean seriesGetSuccessor(@WebParam(name = "systemId") String systemId) {
		return SeriesAPI.getSuccessor(em, systemId);
	}

	@Override
	@WebMethod(action = "seriesGetCaseFiles")
	public List<CaseFileBean> seriesGetCaseFiles(@WebParam(name = "systemId") String systemId) {
		return SeriesAPI.getCaseFiles(em, systemId);
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
		try {
			return CaseFileAPI.create(em, seriesSystemId, parentFileSystemId,
					title, officialTitle, description, documentMedium,
					createdBy);
		} catch (Exception ex) {
			ex.printStackTrace();
			ctx.setRollbackOnly();
			return new Result(false);
		}
	}
	
	@Override
	@WebMethod(action = "caseFileDelete")
	public Result caseFileDelete(@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "caseFileGetParentCaseFile")
	public CaseFileBean caseFileGetParentCaseFile(@WebParam(name = "systemId") String systemId) {
		return CaseFileAPI.getParentCaseFile(em, systemId);
	}

	@Override
	@WebMethod(action = "caseFileGetChildCaseFiles")
	public List<CaseFileBean> caseFileGetChildCaseFiles(@WebParam(name = "systemId") String systemId) {
		return CaseFileAPI.getChildCaseFiles(em, systemId);
	}

	@Override
	@WebMethod(action = "caseFileGetSeries")
	public SeriesBean caseFileGetSeries(@WebParam(name = "systemId") String systemId) {
		return CaseFileAPI.getSeries(em, systemId);
	}

	@Override
	@WebMethod(action = "caseFileGetRegistryEntries")
	public List<RegistryEntryBean> caseFileGetRegistryEntries(@WebParam(name = "systemId") String systemId) {
		return CaseFileAPI.getRegistryEntries(em, systemId);
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
		try {
			return RegistryEntryAPI.create(em, caseFileSystemId, title,
					officialTitle, description, documentMedium, createdBy);
		} catch (Exception ex) {
			ex.printStackTrace();
			ctx.setRollbackOnly();
			return new Result(false);
		}
	}

	@Override
	@WebMethod(action = "registryEntryDelete")
	public Result registryEntryDelete(@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "registryEntryGetCaseFile")
	public CaseFileBean registryEntryGetCaseFile(@WebParam(name = "systemId") String systemId) {
		return RegistryEntryAPI.getCaseFile(em, systemId);
	}

	@Override
	@WebMethod(action = "registryEntryGetDocumentDescriptions")
	public List<DocumentDescriptionBean> registryEntryGetDocumentDescriptions(
		@WebParam(name = "systemId") String systemId) {
		return RegistryEntryAPI.getDocumentDescriptions(em, systemId);
	}

	/** DocumentDescription & DocumentObject **/

	@Override
	@WebMethod(action = "documentCreate")
	public Result documentCreate(
		@WebParam(name = "reSystemId") String reSystemId, 
		@WebParam(name = "documentType") String documentType,
		@WebParam(name = "title") String title,
		@WebParam(name = "description") String description,
		@WebParam(name = "createdBy") String createdBy,
		@WebParam(name = "documentMedium") String documentMedium,
		@WebParam(name = "base64Content") String base64Content,
		@WebParam(name = "extension") String extension,
		@WebParam(name = "format") String format) {
		try {
			return DocumentAPI.documentCreate(em, reSystemId, documentType,
					title, description, createdBy, documentMedium,
					base64Content, extension, format);
		} 
		catch (Exception ex) {
			ex.printStackTrace();
			ctx.setRollbackOnly();
			return new Result(false);
		}
	}

	@Override
	@WebMethod(action = "documentGet")
	public String documentGet(@WebParam(name = "ddSystemId") String ddSystemId) {
		return DocumentAPI.documentGet(em, ddSystemId);
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
		return DocumentAPI.documentDescriptionGetRegistryEntries(em, systemId);
	}

	@Override
	@WebMethod(action = "documentDescriptionGetDocumentObjects")
	public List<DocumentObjectBean> documentDescriptionGetDocumentObjects(
			@WebParam(name = "systemId") String systemId) {
		return DocumentAPI.documentDescriptionGetDocumentObjects(em, systemId);
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
		return DocumentAPI.documentObjectGetDocumentDescription(em, systemId);
	}
}
