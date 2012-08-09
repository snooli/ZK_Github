package dots.module.base.service6;

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
import dots.module.base.entitybeans.DocumentDescriptionBean;
import dots.module.base.entitybeans.DocumentObjectBean;
import dots.module.base.entitybeans.FondsBean;
import dots.module.base.entitybeans.FondsCreatorBean;
import dots.module.base.entitybeans.RegistryEntryBean;
import dots.module.base.entitybeans.SeriesBean;

@WebService
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@WebContext(contextRoot = "/n5", urlPattern = "/Noark5BaseService6")
@Stateless(mappedName = "Noark5BaseService6")
public class Noark5BaseService6 implements INoark5BaseService6 {

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
	@WebMethod(action = "seriesGetRegistryEntries")
	public List<RegistryEntryBean> seriesGetRegistryEntries(
			@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	/** RegistryEntry **/

	@Override
	@WebMethod(action = "registryEntryCreate")
	public Result registryEntryCreate(
			@WebParam(name = "seriesSystemId") String seriesSystemId, 
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
	@WebMethod(action = "registryEntryGetSeries")
	public SeriesBean registryEntryGetSeries(
			@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "registryEntryGetDocumentObjects")
	public List<DocumentObjectBean> registryEntryGetDocumentObjects(
			@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	/** Document Object **/

	@Override
	@WebMethod(action = "documentCreate")
	public Result documentCreate(
			@WebParam(name = "reSystemId") String reSystemId, 
			@WebParam(name = "createdBy") String createdBy,
			@WebParam(name = "base64Content") String base64Content,
			@WebParam(name = "extension") String extension,
			@WebParam(name = "format") String format) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "documentObjectDelete")
	public Result documentObjectDelete(@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "documentObjectGetRegistryEntry")
	public RegistryEntryBean documentObjectGetRegistryEntry(
			@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

}
