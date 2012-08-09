package dots.module.base.service6;

import java.util.List;

import javax.ejb.Remote;

import dots.module.base.beans.Result;
import dots.module.base.entitybeans.DocumentObjectBean;
import dots.module.base.entitybeans.FondsBean;
import dots.module.base.entitybeans.FondsCreatorBean;
import dots.module.base.entitybeans.RegistryEntryBean;
import dots.module.base.entitybeans.SeriesBean;


// 1. fonds
// 2. series
// 3. registry entry
// 4. document object

@Remote
public interface INoark5BaseService6 {

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
			String title, String description, String documentMedium,
			String createdBy);

	public Result seriesDelete(String systemId);

	public SeriesBean seriesGetPrecursor(String systemId);

	public SeriesBean seriesGetSuccessor(String systemId);

	public List<RegistryEntryBean> seriesGetRegistryEntries(String systemId);

	/** RegistryEntry **/

	public Result registryEntryCreate(String seriesSystemId, String title,
			String officialTitle, String description, String documentMedium,
			String createdBy);

	public Result registryEntryDelete(String systemId);

	public SeriesBean registryEntryGetSeries(String systemId);

	public List<DocumentObjectBean> registryEntryGetDocumentObjects(
			String systemId);

	/** DocumentObject **/

	public Result documentCreate(String reSystemId, String createdBy,
			String base64Content, String extension, String format);

	public Result documentObjectDelete(String systemId);

	public RegistryEntryBean documentObjectGetRegistryEntry(String systemId);

}
