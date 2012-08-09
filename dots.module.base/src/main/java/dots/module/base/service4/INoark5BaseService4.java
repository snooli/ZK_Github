package dots.module.base.service4;

import java.util.List;

import javax.ejb.Remote;

import dots.module.base.beans.Result;
import dots.module.base.entitybeans.ClassBean;
import dots.module.base.entitybeans.ClassificationSystemBean;
import dots.module.base.entitybeans.DocumentDescriptionBean;
import dots.module.base.entitybeans.DocumentObjectBean;
import dots.module.base.entitybeans.FondsBean;
import dots.module.base.entitybeans.FondsCreatorBean;
import dots.module.base.entitybeans.RegistryEntryBean;
import dots.module.base.entitybeans.SeriesBean;


// 1. fonds
// 2. series
// 3. classification system
// 4. class
// 5. registry entry
// 6. document description
// 7. document object

@Remote
public interface INoark5BaseService4 {

	/** Fonds **/

	public Result fondsCreate(String fondsCreatorId,
			String parentFondsSystemId, String title, String description,
			String documentMedium, String createdBy);

	public Result fondsDelete(String systemId);

	public FondsBean fondsGetParentFonds(String systemId);

	public List<FondsBean> fondsGetChildFonds(String systemId);

	public List<SeriesBean> fondsGetSeries(String systemId);

	public List<FondsCreatorBean> fondsGetFondsCreators(String systemId);

	public Result fondsCreatorCreate(String fondsCreatorId,
			String fondsCreatorName, String description);

	public Result fondsCreatorDelete(String systemId);

	/** Series **/

	public Result seriesCreate(String fondsSystemId, String precursorSystemId,
			String csSystemId, String title, String description,
			String documentMedium, String createdBy);

	public Result seriesDelete(String systemId);

	public SeriesBean seriesGetPrecursor(String systemId);

	public SeriesBean seriesGetSuccessor(String systemId);

	public ClassificationSystemBean seriesGetClassificationSystem(
			String systemId);

	/** ClassificationSystem **/

	public Result classificationSystemCreate(String title, String createdBy);

	public Result classificationSystemDelete(String systemId);

	public List<SeriesBean> classificationSystemGetSeries(String systemId);

	public List<ClassBean> classificationSystemGetChildClasses(String systemId);

	/** Class **/

	public Result classCreate(String csSystemId, String parentClassSystemId,
			String title, String description, String createdBy);

	public Result classDelete(String systemId);

	public ClassificationSystemBean classGetClassificationSystem(String systemId);

	public List<ClassBean> classGetChildClasses(String systemId);

	public ClassBean classGetParentClass(String systemId);

	public List<RegistryEntryBean> classGetRegistryEntries(String systemId);

	public Result classAddRegistryEntry(String classSystemId,
			String entrySystemId);

	/** RegistryEntry **/

	public Result registryEntryCreate(String classSystemId, String title,
			String officialTitle, String description, String documentMedium,
			String createdBy);

	public Result registryEntryDelete(String systemId);

	public ClassBean registryEntryGetClass(String systemId);

	public List<DocumentDescriptionBean> registryEntryGetDocumentDescriptions(
			String systemId);

	/** DocumentDescription & DocumentObject **/

	public Result documentCreate(String reSystemId, String documentType,
			String title, String description, String createdBy,
			String documentMedium, String base64Content, String extension,
			String format);

	public String documentGet(String ddSystemId);

	/** DocumentDescription **/

	public Result documentDescriptionDelete(String systemId);

	public List<RegistryEntryBean> documentDescriptionGetRegistryEntries(
			String systemId);

	public List<DocumentObjectBean> documentDescriptionGetDocumentObjects(
			String systemId);

	/** DocumentObject **/

	public Result documentObjectDelete(String systemId);

	public DocumentDescriptionBean documentObjectGetDocumentDescription(
			String systemId);

}
