package ma.esoftech.esoftrade.exception;

public class ContactNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ContactNotFoundException(long id){
		super("contact who id:"+ id+ "notFound");
	}
}
