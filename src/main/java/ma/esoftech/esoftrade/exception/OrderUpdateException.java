package ma.esoftech.esoftrade.exception;

public class OrderUpdateException  extends Exception{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderUpdateException(){
		super("Deny to update Order because the order is not in draft state");
	}
}
