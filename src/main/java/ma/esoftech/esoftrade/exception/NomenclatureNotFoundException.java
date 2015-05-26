package ma.esoftech.esoftrade.exception;

public class NomenclatureNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public NomenclatureNotFoundException(long id){
		super("nomencalature not found :"+id);
	}

}
