package dots.module.hlapi.base;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.ejb.EJBException;
import javax.persistence.EntityManager;


import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.io.FileUtils;

import dots.clb.common.api.base.LLDocumentDescriptionAPI;
import dots.clb.common.api.base.LLDocumentObjectAPI;
import dots.clb.common.api.base.LLRegistryEntryAPI;
import dots.clb.common.api.find.LLDocumentDescriptionFindAPI;
import dots.clb.common.api.find.LLDocumentObjectFindAPI;
import dots.clb.common.api.find.LLRegistryEntryFindAPI;
import dots.clb.common.constants.N5Status;
import dots.clb.common.entities.DocumentDescription;
import dots.clb.common.entities.DocumentObject;
import dots.clb.common.entities.RegistryEntry;
import dots.module.base.beans.Result;
import dots.module.base.entitybeans.DocumentDescriptionBean;
import dots.module.base.entitybeans.DocumentObjectBean;
import dots.module.base.entitybeans.RegistryEntryBean;
import dots.module.base.helpers.EntityHelper;

public class DocumentAPI {

	// directory where documents are stored
	private static File documentPath;

	private static void getConfig() {

		if (documentPath == null) {

			URL url = DocumentAPI.class.getClassLoader().getResource(
					"META-INF/config.xml");

			try {
				XMLConfiguration config = new XMLConfiguration(url);

				String path = config.getString("documentPath");

				documentPath = new File(path);

				// document directory does not exist
				if (!documentPath.exists()) {
					throw new EJBException();
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

	private static String storeDocument(byte[] content, String fileName) {

		getConfig();

		File targetFile = new File(documentPath.getAbsolutePath()
				+ File.separator + fileName);

		try {
			FileUtils.writeByteArrayToFile(targetFile, content);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return targetFile.getAbsolutePath();
	}

	public static String documentGet(EntityManager em, String ddSystemId) {

		getConfig();

		// no document description specified
		if (ddSystemId == null) {
			throw new EJBException();
		}

		// get the document description
		DocumentDescription dd = LLDocumentDescriptionFindAPI.findBySystemId(
				em, ddSystemId);

		// specified document description does not exist
		if (dd == null) {
			throw new EJBException();
		}

		// if no document object exists
		if (!dd.getReferenceDocumentObject().iterator().hasNext()) {
			throw new EJBException();
		}

		// get the document object and extract the file path
		DocumentObject dobj = dd.getReferenceDocumentObject().iterator().next();
		String filePath = dobj.getReferenceDocumentFile();

		try {
			// try to read the file
			byte[] fileContent = FileUtils.readFileToByteArray(new File(
					filePath));

			// encode the content using Base64
			String base64Content = Base64.encodeBase64String(fileContent);

			return base64Content;

		} catch (Exception ex) {
			throw new EJBException();
		}

	}

	/** Create **/

	/**
	 * Creates DocumentDescription and DocumentObjects.
	 */
	public static Result documentCreate(EntityManager em, String reSystemId,
			String documentType, String title, String description,
			String createdBy, String documentMedium, String base64Content,
			String extension, String format) {

		// no registry entry specified
		if (reSystemId == null) {
			// cannot create document
			throw new EJBException();
		}

		// get the specified registry entry
		RegistryEntry entry = LLRegistryEntryFindAPI.findBySystemId(em,
				reSystemId);

		// specified registry entry does not exist
		if (entry == null) {
			throw new EJBException();
		}

		// get the document content
		byte[] content = Base64.decodeBase64(base64Content);

		// calculate the document checksum
		String checksum = DigestUtils.sha256Hex(content);

		// get the document size
		long fileSize = content.length;

		// generate a file name
		String fileName = UUID.randomUUID().toString() + "." + extension;

		// store the document
		String filePath = storeDocument(content, fileName);

		// create a new document description
		String ddSystemId = new LLDocumentDescriptionAPI().create(em,
				documentType, N5Status.DocumentStatus.BEING_EDITED, title,
				description, createdBy, documentMedium);

		// get the newly created document description
		DocumentDescription dd = LLDocumentDescriptionFindAPI.findBySystemId(
				em, ddSystemId);

		// add the document description to the registry entry
		new LLRegistryEntryAPI().addDocumentDescription(entry, dd);

		// create a new document object
		String dobjSystemId = new LLDocumentObjectAPI()
				.create(em, 1, null, format, null, createdBy, filePath,
						checksum, "SHA256", fileSize);

		// get the newly created document object
		DocumentObject dobj = LLDocumentObjectFindAPI.findBySystemId(em,
				dobjSystemId);

		// add the document object to the document description
		new LLDocumentDescriptionAPI().addDocumentObject(dd, dobj);

		// add the document object to the registry entry
		new LLRegistryEntryAPI().addDocumentObject(entry, dobj);

		return new Result(true, ddSystemId);
	}

	/**
	 * Creates DocumentObjects.
	 */
	public static Result documentCreate(EntityManager em, String reSystemId,
			String createdBy, String base64Content, String extension,
			String format) {

		// no registry entry specified
		if (reSystemId == null) {
			// cannot create document
			throw new EJBException();
		}

		// get the specified registry entry
		RegistryEntry entry = LLRegistryEntryFindAPI.findBySystemId(em,
				reSystemId);

		// specified registry entry does not exist
		if (entry == null) {
			throw new EJBException();
		}

		// get the document content
		byte[] content = Base64.decodeBase64(base64Content);

		// calculate document checksum
		String checksum = DigestUtils.sha256Hex(content);

		// get the document size
		long fileSize = content.length;

		// generate a file name
		String fileName = UUID.randomUUID().toString() + "." + extension;

		// store the document
		String filePath = storeDocument(content, fileName);

		// create a new document object
		String dobjSystemId = new LLDocumentObjectAPI()
				.create(em, 1, null, format, null, createdBy, filePath,
						checksum, "SHA256", fileSize);

		// get the newly created document object
		DocumentObject dobj = LLDocumentObjectFindAPI.findBySystemId(em,
				dobjSystemId);

		// add the document object to the registry entry
		new LLRegistryEntryAPI().addDocumentObject(entry, dobj);

		return new Result(true, dobjSystemId);
	}

	/** Delete **/

	public static Result documentDescriptionDelete(EntityManager em,
			String systemId) {
		// TODO
		return null;
	}

	public static Result documentObjectDelete(EntityManager em, String systemId) {
		// TODO
		return null;
	}

	/** Get **/

	public static List<DocumentObjectBean> documentDescriptionGetDocumentObjects(
			EntityManager em, String systemId) {

		DocumentDescription dd = LLDocumentDescriptionFindAPI.findBySystemId(
				em, systemId);

		if (dd != null) {
			return EntityHelper.entitiesToBeans(
					dd.getReferenceDocumentObject(), DocumentObjectBean.class);
		} else {
			return new ArrayList<DocumentObjectBean>();
		}
	}

	public static List<RegistryEntryBean> documentDescriptionGetRegistryEntries(
			EntityManager em, String systemId) {

		DocumentDescription dd = LLDocumentDescriptionFindAPI.findBySystemId(
				em, systemId);

		if (dd != null) {
			return EntityHelper.entitiesToBeans(dd.getReferenceRecord(),
					RegistryEntryBean.class);
		} else {
			return new ArrayList<RegistryEntryBean>();
		}
	}

	public static DocumentDescriptionBean documentObjectGetDocumentDescription(
			EntityManager em, String systemId) {

		DocumentObject dobj = LLDocumentObjectFindAPI.findBySystemId(em,
				systemId);

		if (dobj != null) {
			return EntityHelper.entityToBean(
					dobj.getReferenceDocumentDescription(),
					DocumentDescriptionBean.class);
		} else {
			return null;
		}
	}

	public static RegistryEntryBean documentObjectGetRegistryEntry(
			EntityManager em, String systemId) {

		DocumentObject dobj = LLDocumentObjectFindAPI.findBySystemId(em,
				systemId);

		if (dobj != null) {
			return EntityHelper.entityToBean(dobj.getReferenceRecord(),
					RegistryEntryBean.class);
		} else {
			return null;
		}
	}

}
