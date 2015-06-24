package ma.esoftech.esoftrade.Dao;

import java.util.Date;
import java.util.List;

import ma.esoftech.esoftrade.model.OrderManufacturing;

public interface IDashboard {
Date currentDate= new Date();
	 public long  getCountOFBlocked();
	 public long  getCountOFWaiting();
	 public long  getCountOFProcessing();
	 public long  getCountOFLate(Date currentDate);
	 public List<Object[]> ListCriticalOF();
}
