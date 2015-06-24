package ma.esoftech.esoftrade.exception;

public class CompanyNotFoundException  extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CompanyNotFoundException(long id){
		super("company who id:"+ id+ "notFound");
	}

}
