package dots.module.base.entitybeans;

import java.io.Serializable;

public class StorageLocationBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/** M001 - systemID */
	protected String systemId;

	/** M301 - oppbevaringssted */
	protected String storageLocation;

	/** M001 - systemID */
	public String getSystemId() {
		return systemId;
	}

	/** M001 - systemID */
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	/** M301 - oppbevaringssted */
	public String getStorageLocation() {
		return storageLocation;
	}

	/** M301 - oppbevaringssted */
	public void setStorageLocation(String storageLocation) {
		this.storageLocation = storageLocation;
	}

}
