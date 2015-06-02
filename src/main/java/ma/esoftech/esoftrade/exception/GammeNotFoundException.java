package ma.esoftech.esoftrade.exception;

public class GammeNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	public GammeNotFoundException(long id) {
  super("gamme who id:"+ id+ "notFound");
	}
	public GammeNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
}
