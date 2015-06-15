package ma.esoftech.esoftrade.exception;

public class PosteNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	public PosteNotFoundException(long id) {
	super("NotFoundPoste which id:"+id+"Error");
	}
	public PosteNotFoundException() {
		super("Error detected");

	}
}
