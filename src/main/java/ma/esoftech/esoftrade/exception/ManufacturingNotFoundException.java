package ma.esoftech.esoftrade.exception;

public class ManufacturingNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	public ManufacturingNotFoundException(long id) {
		super("OF not found who id:"+id);
	}
	public ManufacturingNotFoundException() {
		super("Manufacturing Order Not Found");
	}
}
