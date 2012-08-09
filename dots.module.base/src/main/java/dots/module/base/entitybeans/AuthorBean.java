package dots.module.base.entitybeans;

import java.io.Serializable;

public class AuthorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/** M001 - systemID */
	protected String systemId;

	/** M024 - forfatter */
	protected String author;

	/** M001 - systemID */
	public String getSystemId() {
		return systemId;
	}

	/** M001 - systemID */
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	/** M024 - forfatter */
	public String getAuthor() {
		return author;
	}

	/** M024 - forfatter */
	public void setAuthor(String author) {
		this.author = author;
	}

}
