package ma.esoftech.esoftrade.exeption;

public class UserNotFoundException extends Exception {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public UserNotFoundException() {
		super("user not found");		
	}
	public UserNotFoundException(String message) {
		super(message);
	}

}
