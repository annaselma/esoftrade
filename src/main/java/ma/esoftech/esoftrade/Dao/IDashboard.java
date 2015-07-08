package ma.esoftech.esoftrade.Dao;

import java.util.Date;
import java.util.List;

import ma.esoftech.esoftrade.model.OrderManufacturing;
import ma.esoftech.esoftrade.model.PostPerformance;

public interface IDashboard {
	 public long  getCountOFBlocked();
	 public long  getCountOFWaiting();
	 public long  getCountOFProcessing();
	 public long  getCountOFLate(Date currentDate);
	 public List<Object[]> ListCriticalOF();
	 public List<PostPerformance> getPostWithPerformance();
}
