package dots.module.base.entitybeans;

import java.io.Serializable;

public class FondsCreatorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/** M001 - systemID */
	protected String systemId;

	/** M006 - arkivskaperID */
	protected String fondsCreatorId;

	/** M023 - arkivskaperNavn */
	protected String fondsCreatorName;

	/** M021 - beskrivelse */
	protected String description;

	/** M001 - systemID */
	public String getSystemId() {
		return systemId;
	}

	/** M001 - systemID */
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	/** M006 - arkivskaperID */
	public String getFondsCreatorId() {
		return fondsCreatorId;
	}

	/** M006 - arkivskaperID */
	public void setFondsCreatorId(String fondsCreatorId) {
		this.fondsCreatorId = fondsCreatorId;
	}

	/** M023 - arkivskaperNavn */
	public String getFondsCreatorName() {
		return fondsCreatorName;
	}

	/** M023 - arkivskaperNavn */
	public void setFondsCreatorName(String fondsCreatorName) {
		this.fondsCreatorName = fondsCreatorName;
	}

	/** M021 - beskrivelse */
	public String getDescription() {
		return description;
	}

	/** M021 - beskrivelse */
	public void setDescription(String description) {
		this.description = description;
	}

}
