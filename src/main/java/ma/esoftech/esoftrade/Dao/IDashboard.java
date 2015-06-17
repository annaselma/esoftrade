package ma.esoftech.esoftrade.Dao;

import java.util.List;

import ma.esoftech.esoftrade.model.OrderManufacturing;

public interface IDashboard {

	 public long  getCountOFBlocked();
	 public long  getCountOFWaiting(OrderManufacturing order);
	 public long  getCountOFProcessing(OrderManufacturing order);
	 public long  getCountOFLate(OrderManufacturing order);
	 public List<Object[]> ListCriticalOF(OrderManufacturing order);
}
