package ma.esoftech.esoftrade.generate;

import javax.print.attribute.standard.SheetCollate;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;

public class Hibernate {

	public static void main(String [] args){
		Configuration cfg= new Configuration().configure("hibernate2.cfg.xml");
	SchemaUpdate sh= new SchemaUpdate(cfg);	
	sh.execute(true, true);
	}
}
/**/