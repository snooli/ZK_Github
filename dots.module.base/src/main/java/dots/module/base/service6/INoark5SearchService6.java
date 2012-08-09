package dots.module.base.service6;

import java.util.List;

import javax.ejb.Remote;

import dots.module.base.entitybeans.ChangeLogEntryBean;
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
public interface INoark5SearchService6 {

	/** Fonds **/

	public FondsBean fondsFindBySystemId(String systemId);

	public List<FondsBean> fondsFindAll();

	public List<FondsBean> fondsFindTopLevel();

	public List<FondsBean> fondsFindAllByTitle(String title);

	public List<FondsBean> fondsFindAllByDescription(String description);

	public List<FondsBean> fondsFindAllByCreatedBy(String createdBy);

	public FondsCreatorBean fondsCreatorFindBySystemId(String systemId);

	public FondsCreatorBean fondsCreatorFindByFondsCreatorId(
			String fondsCreatorId);

	public List<FondsCreatorBean> fondsCreatorFindAll();

	public List<FondsCreatorBean> fondsCreatorFindAllByFondsCreatorName(
			String fondsCreatorName);

	public List<FondsCreatorBean> fondsCreatorFindAllByDescription(
			String description);

	/** Series **/

	public SeriesBean seriesFindBySystemId(String systemId);

	public List<SeriesBean> seriesFindAll();

	public List<SeriesBean> seriesFindAllByTitle(String title);

	public List<SeriesBean> seriesFindAllByDescription(String description);

	public List<SeriesBean> seriesFindAllByCreatedBy(String createdBy);

	/** RegistryEntry **/

	public RegistryEntryBean registryEntryFindBySystemId(String systemId);

	public RegistryEntryBean registryEntryFindByRecordId(String recordId);

	public List<RegistryEntryBean> registryEntryFindAll();

	public List<RegistryEntryBean> registryEntryFindAllByTitle(String title);

	public List<RegistryEntryBean> registryEntryFindAllByDescription(
			String description);

	public List<RegistryEntryBean> registryEntryFindAllByCreatedBy(
			String createdBy);

	/** DocumentObject **/

	public DocumentObjectBean documentObjectFindBySystemId(String systemId);

	public List<DocumentObjectBean> documentObjectFindAll();

	public List<DocumentObjectBean> documentObjectFindAllByCreatedBy(
			String createdBy);

	/** ChangeLogEntry **/

	public List<ChangeLogEntryBean> changeLogEntryFindAll();

}
