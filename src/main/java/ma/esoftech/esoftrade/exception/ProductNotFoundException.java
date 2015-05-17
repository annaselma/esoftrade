package ma.esoftech.esoftrade.exception;

public class ProductNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ProductNotFoundException(long id){
		super("product id: "+id+" not found");
	}
	public ProductNotFoundException(){
		super("product  not found");
	}

}
