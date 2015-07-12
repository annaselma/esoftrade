package ma.esoftech.esoftrade.exception;

public class OrderNotFoundException extends Exception{
	 public  OrderNotFoundException(long id){
		 super("order who id:"+ id+ " notFound");
	 }
	 public  OrderNotFoundException(){
		 super("order not found");
	 }
}
