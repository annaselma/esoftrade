package ma.esoftech.esoftrade.exception;

public class RoleNotFoundException  extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RoleNotFoundException(long id){
		super("role who id="+id+" not found");
	}
	public RoleNotFoundException(){
		super("role not found");
	}
}
