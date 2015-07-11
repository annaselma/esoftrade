package ma.esoftech.esoftrade.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IDashboardService {
	
	 public long  getCountOFBlocked();
	 public long  getCountOFWaiting();
	 public long  getCountOFProcessing();
	 public long  getCountOFLate(Date currentDate);
	 public float [][] getOfStaticBubble();
	 public Object [][] getPostesStatic();
	 public Map<String,Float[]>getPieData();
	 public List<Map<String, Object>> getCalandarOrders();
}
