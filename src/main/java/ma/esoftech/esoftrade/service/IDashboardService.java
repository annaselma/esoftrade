package ma.esoftech.esoftrade.service;

import java.util.Date;

public interface IDashboardService {
	
	 public long  getCountOFBlocked();
	 public long  getCountOFWaiting();
	 public long  getCountOFProcessing();
	 public long  getCountOFLate(Date currentDate);
	 public float [][] getOfStaticBubble();
	 public Object [][] getPostesStatic();
}
