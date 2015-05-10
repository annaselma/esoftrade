package ma.esoftech.esoftrade.exception;

public class PCatNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 public PCatNotFoundException(long id){
	 super("Category with id"+id+"does not exist");
 }
 public PCatNotFoundException(String name){
	 super("cant have the same name"+name+" of category");
 }
 public PCatNotFoundException(){
	 super("product not found");
 }
}
