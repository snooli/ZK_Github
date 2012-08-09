package dots.module.base.service6;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.jboss.wsf.spi.annotation.WebContext;

import dots.module.base.entitybeans.ChangeLogEntryBean;
import dots.module.base.entitybeans.DocumentObjectBean;
import dots.module.base.entitybeans.FondsBean;
import dots.module.base.entitybeans.FondsCreatorBean;
import dots.module.base.entitybeans.RegistryEntryBean;
import dots.module.base.entitybeans.SeriesBean;

@WebService
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@WebContext(contextRoot = "/n5", urlPattern = "/Noark5SearchService6")
@Stateless(mappedName = "Noark5SearchService6")
public class Noark5SearchService6 implements INoark5SearchService6 {

	@PersistenceContext
	EntityManager em;

	/** Fonds **/

	@Override
	@WebMethod(action = "fondsFindBySystem")
	public FondsBean fondsFindBySystemId(
			@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "fondsFindAll")
	public List<FondsBean> fondsFindAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "fondsFindTopLevel")
	public List<FondsBean> fondsFindTopLevel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "fondsFindAllByTitle")
	public List<FondsBean> fondsFindAllByTitle(@WebParam(name = "title") String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "fondsFindAllByDescription")
	public List<FondsBean> fondsFindAllByDescription(
			@WebParam(name = "description") String description) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "fondsFindAllByCreatedBy")
	public List<FondsBean> fondsFindAllByCreatedBy(
			@WebParam(name = "createdBy") String createdBy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "fondsCreatorFindBySystemId")
	public FondsCreatorBean fondsCreatorFindBySystemId(
			@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "fondsCreatorFindByFondsCreatorId")
	public FondsCreatorBean fondsCreatorFindByFondsCreatorId(
			@WebParam(name = "fondsCreatorId") String fondsCreatorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "fondsCreatorFindAll")
	public List<FondsCreatorBean> fondsCreatorFindAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "fondsCreatorFindAllByFondsCreatorName")
	public List<FondsCreatorBean> fondsCreatorFindAllByFondsCreatorName(
			@WebParam(name = "fondsCreatorName") String fondsCreatorName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "fondsCreatorFindAllByDescription")
	public List<FondsCreatorBean> fondsCreatorFindAllByDescription(
			@WebParam(name = "description") String description) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/** Series **/

	@Override
	@WebMethod(action = "seriesFindBySystemId")
	public SeriesBean seriesFindBySystemId(
			@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "seriesFindAll")
	public List<SeriesBean> seriesFindAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "seriesFindAllByTitle")
	public List<SeriesBean> seriesFindAllByTitle(
			@WebParam(name = "title") String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "seriesFindAllByDescription")
	public List<SeriesBean> seriesFindAllByDescription(
			@WebParam(name = "description") String description) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "seriesFindAllByCreatedBy")
	public List<SeriesBean> seriesFindAllByCreatedBy(
			@WebParam(name = "createdBy") String createdBy) {
		// TODO Auto-generated method stub
		return null;
	}

	/** RegistryEntry **/

	@Override
	@WebMethod(action = "registryEntryFindBySystemId")
	public RegistryEntryBean registryEntryFindBySystemId(
			@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "registryEntryFindByRecordId")
	public RegistryEntryBean registryEntryFindByRecordId(
			@WebParam(name = "recordId") String recordId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "registryEntryFindAll")
	public List<RegistryEntryBean> registryEntryFindAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "registryEntryFindAllByTitle")
	public List<RegistryEntryBean> registryEntryFindAllByTitle(
			@WebParam(name = "title") String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "registryEntryFindAllByDescription")
	public List<RegistryEntryBean> registryEntryFindAllByDescription(
			@WebParam(name = "description") String description) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "registryEntryFindAllByCreatedBy")
	public List<RegistryEntryBean> registryEntryFindAllByCreatedBy(
			@WebParam(name = "createdBy") String createdBy) {
		// TODO Auto-generated method stub
		return null;
	}

	/** DocumentObject **/

	@Override
	@WebMethod(action = "documentObjectFindBySystemId")
	public DocumentObjectBean documentObjectFindBySystemId(
			@WebParam(name = "systemId") String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "documentObjectFindAll")
	public List<DocumentObjectBean> documentObjectFindAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod(action = "documentObjectFindAllByCreatedBy")
	public List<DocumentObjectBean> documentObjectFindAllByCreatedBy(
			@WebParam(name = "createdBy") String createdBy) {
		// TODO Auto-generated method stub
		return null;
	}


	/** ChangeLogEntry **/

	@Override
	@WebMethod(action = "changeLogEntryFindAll")
	public List<ChangeLogEntryBean> changeLogEntryFindAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
