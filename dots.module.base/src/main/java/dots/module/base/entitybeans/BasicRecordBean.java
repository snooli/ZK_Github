package dots.module.base.entitybeans;

import java.io.Serializable;
import java.util.Date;

public class BasicRecordBean implements Serializable {

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

	/** M004 - registreringsID */
	protected String recordId;

	/** M020 - tittel */
	protected String title;

	/** M025 - offentligTittel */
	protected String officialTitle;

	/** M021 - beskrivelse */
	protected String description;

	/** M300 - dokumentmedium */
	protected String documentMedium;

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

	/** M004 - registreringsID */
	public String getRecordId() {
		return recordId;
	}

	/** M004 - registreringsID */
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	/** M020 - tittel */
	public String getTitle() {
		return title;
	}

	/** M020 - tittel */
	public void setTitle(String title) {
		this.title = title;
	}

	/** M025 - offentligTittel */
	public String getOfficialTitle() {
		return officialTitle;
	}

	/** M025 - offentligTittel */
	public void setOfficialTitle(String officialTitle) {
		this.officialTitle = officialTitle;
	}

	/** M021 - beskrivelse */
	public String getDescription() {
		return description;
	}

	/** M021 - beskrivelse */
	public void setDescription(String description) {
		this.description = description;
	}

	/** M300 - dokumentmedium */
	public String getDocumentMedium() {
		return documentMedium;
	}

	/** M300 - dokumentmedium */
	public void setDocumentMedium(String documentMedium) {
		this.documentMedium = documentMedium;
	}

}
