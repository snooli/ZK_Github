package dots.module.base.beans;

import java.io.Serializable;

public class Result implements Serializable {

	private static final long serialVersionUID = 1L;

	private String message;
	private Boolean success;

	public Result() {

	}

	public Result(Boolean success) {
		this.success = success;
	}

	public Result(Boolean success, String message) {
		this.success = success;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

}
