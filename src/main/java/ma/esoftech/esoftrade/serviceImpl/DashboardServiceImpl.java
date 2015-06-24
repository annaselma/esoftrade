package ma.esoftech.esoftrade.serviceImpl;

import java.util.Date;

import ma.esoftech.esoftrade.Dao.IDashboard;
import ma.esoftech.esoftrade.service.IDashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DashboardServiceImpl implements IDashboardService{

	@Autowired
	IDashboard dashboardDao;
	Date currentDate= new Date();
	@Override
	@Transactional(readOnly=true)
	public long getCountOFBlocked() {
		
		return dashboardDao.getCountOFBlocked();
	}

	@Override
	@Transactional(readOnly=true)
	public long getCountOFWaiting() {
		// TODO Auto-generated method stub
		return dashboardDao.getCountOFWaiting();
	}

	@Override
	@Transactional(readOnly=true)
	public long getCountOFProcessing() {
		// TODO Auto-generated method stub
		return dashboardDao.getCountOFProcessing();
	}

	@Override
	@Transactional(readOnly=true)
	public long getCountOFLate(Date currentDate) {
		// TODO Auto-generated method stub
		return dashboardDao.getCountOFLate(currentDate);
	}

}
