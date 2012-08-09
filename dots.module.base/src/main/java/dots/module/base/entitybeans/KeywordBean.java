package dots.module.base.entitybeans;

import java.io.Serializable;

public class KeywordBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/** M001 - systemID */
	protected String systemId;

	/** M022 - noekkelord */
	protected String keyword;

	/** M001 - systemID */
	public String getSystemId() {
		return systemId;
	}

	/** M001 - systemID */
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	/** M022 - noekkelord */
	public String getKeyword() {
		return keyword;
	}

	/** M022 - noekkelord */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
