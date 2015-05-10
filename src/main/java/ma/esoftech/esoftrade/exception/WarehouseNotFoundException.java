package ma.esoftech.esoftrade.exception;

public class WarehouseNotFoundException  extends Exception{
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public WarehouseNotFoundException(long id){
	 super("Not found Warehouse who id"+id);
 }
public WarehouseNotFoundException(String name){
	super("Warehouse whith name:"+name+ "does not exist");}
public WarehouseNotFoundException(){
	super("Warehouse not found");
}
}
