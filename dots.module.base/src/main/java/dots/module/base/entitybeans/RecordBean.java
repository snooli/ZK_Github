package dots.module.base.entitybeans;

import java.io.Serializable;
import java.util.Date;

public class RecordBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/** M001 - systemID */
	protected String systemId;

	/** M600 - opprettetDato */
	protected Date createdDate;

	/** M601 - opprettetAv */
	protected String createdBy;

	/** M604 - arkivertDato */
	protected Date archivedDate;

	/** M605 - arkivertAv */
	protected String archivedBy;

	/** M001 - systemID */
	public String getSystemId() {
		return systemId;
	}

	/** M001 - systemID */
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	/** M600 - opprettetDato */
	public Date getCreatedDate() {
		return createdDate;
	}

	/** M600 - opprettetDato */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/** M601 - opprettetAv */
	public String getCreatedBy() {
		return createdBy;
	}

	/** M601 - opprettetAv */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/** M604 - arkivertDato */
	public Date getArchivedDate() {
		return archivedDate;
	}

	/** M604 - arkivertDato */
	public void setArchivedDate(Date archivedDate) {
		this.archivedDate = archivedDate;
	}

	/** M605 - arkivertAv */
	public String getArchivedBy() {
		return archivedBy;
	}

	/** M605 - arkivertAv */
	public void setArchivedBy(String archivedBy) {
		this.archivedBy = archivedBy;
	}

}
