package smartCardUniversity.LOGIN.exception;

public class UserAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 5861310537366287163L;

	public UserAlreadyExistException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserAlreadyExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UserAlreadyExistException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserAlreadyExistException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UserAlreadyExistException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
