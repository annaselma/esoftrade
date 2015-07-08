package ma.esoftech.esoftrade.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Set;

import ma.esoftech.esoftrade.Dao.IDashboard;
import ma.esoftech.esoftrade.Dao.IManufacturinOrder;
import ma.esoftech.esoftrade.model.Gamme;
import ma.esoftech.esoftrade.model.OrderManufacturing;
import ma.esoftech.esoftrade.model.PostPerformance;
import ma.esoftech.esoftrade.service.IDashboardService;
import ma.esoftech.esoftrade.service.IManufacturingOrderService;
import ma.esoftech.esoftrade.utils.UTILS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DashboardServiceImpl implements IDashboardService{

	@Autowired
	IDashboard dashboardDao;
	@Autowired
	IManufacturinOrder manufacturingDao;
	
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

	@Override
	@Transactional(readOnly=true)
	public float[][] getOfStaticBubble() {
		List<OrderManufacturing> manufacturings=manufacturingDao.getTerminateOF();
		float[][] res=new float[manufacturings.size()][3];
		int i=0;
		for (OrderManufacturing manufacturing : manufacturings) {
			Float[] costGamme=calculTauxHoraire(manufacturing);
			float costProducts=ManufacturingOrderServiceImp.calculeCostProductReal(
					manufacturing.getNomenclatures());
			long time=calculDays(manufacturing);
			res[i][0]=costGamme[1];
			res[i][1]=time;
			res[i][2]=costGamme[0]+costProducts;
			i++;
		}
		return res;
	}
	private long calculDays(OrderManufacturing manufacturing){
		Date start=manufacturing.getStartDate();
		Date end=manufacturing.getEndDate();
		long days=1000*3600*24L;
		return (end.getTime()-start.getTime())/days;
	}
      private Float[] calculTauxHoraire(OrderManufacturing manufacturing){
    		float cost=0;
    		float average=0;
    		long coeff=0;
    		Set<Gamme> gammes=manufacturing.getGammes();
    		for (Gamme gamme :gammes) {
    			cost+=gamme.getNbposte()*gamme.getPoste().getPrice()*gamme.getTime();
    			coeff+=gamme.getNbposte()*gamme.getTime();
    		}
    		if(coeff!=0)
    		     average=cost/coeff;
    		Float[] res =new Float[]{cost,average};
    	  return res;
      }

	@Override
	@Transactional(readOnly=true)
	public Object[][] getPostesStatic() {
		List<PostPerformance> posts=dashboardDao.getPostWithPerformance();
		String[] names=new String[posts.size()];
		Long[] times=new Long[posts.size()];
		Float[] th=new Float[posts.size()];
		int i=0;
		for (PostPerformance post : posts) {
			names[i]=post.getPost().getNamePoste();
			times[i]= post.getTime();
			th[i]=post.getPost().getPrice();
		}
		Object[][] res=new Object[3][posts.size()];
		res[0]=names;
		res[1]=times;
		res[2]=th;
		return res;
	}

}
