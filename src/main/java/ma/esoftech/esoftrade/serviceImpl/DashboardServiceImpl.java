package ma.esoftech.esoftrade.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
			System.out.println("test"+post.getPost().getNamePoste());
			names[i]=post.getPost().getNamePoste();
			times[i]= post.getTime();
			th[i]=post.getPost().getPrice();
			i++;
		}
		Object[][] res=new Object[3][posts.size()];
		res[0]=names;
		res[1]=times;
		res[2]=th;
		return res;
	}

	@Override
	@Transactional(readOnly=true)
	public Map<String, Float[]> getPieData() {
		Map<String, Float[]> res=new HashMap<String, Float[]>();
		long countCanceled=dashboardDao.getCountOFCanceled();
		long countEnd= dashboardDao.getCountOFEnd();
		long countBlocked= dashboardDao.getCountOFBlocked();
		Float[] percentTerminated=new Float[3];
		long countTotal=countBlocked+countEnd+countCanceled;
		if(countTotal>0){
		percentTerminated[0]=(float)((float)countEnd/(countBlocked+countEnd+countCanceled ))*100f;
		percentTerminated[1]=(float)((float)countBlocked/(countBlocked+countEnd+countCanceled))*100f;
		percentTerminated[2]=(float)((float)countCanceled/(countBlocked+countEnd+countCanceled))*100f;
		res.put("terminate", percentTerminated);
		}
		long countWaiting= dashboardDao.getCountOFWaiting();
		long countProcessing=dashboardDao.getCountOFProcessing();
		long countLate= dashboardDao.getCountOFLate(new Date());
	    Float[] percentProcess=new Float[3];
	    if(countProcessing>0){
	    percentProcess[0]=(float)((float)(countProcessing-(countLate+countWaiting))/countProcessing)*100;
	    percentProcess[1]=(float)((float)countLate/countProcessing)*100;
	    percentProcess[2]=(float)((float)countWaiting/countProcessing)*100;
	    res.put("process", percentProcess);}
		return res;
	}

	SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
	@Override
	
	@Transactional(readOnly=true)
	public List<Map<String,Object>> getCalandarOrders() {
		/*
		 * 
		 * title: 'QTINSTALLATION',
                              start: new Date(y, m, 1),
                              backgroundColor: "#f56954", //red 
                              borderColor: "#f56954" //red*/
		List<OrderManufacturing> orders=manufacturingDao.getAllOF(UTILS.START_LIST, UTILS.MAX_LENGHT_LIST, "","");
		List<Map<String,Object>>res=new ArrayList<Map<String,Object>>();
		Map<String,Object> map=null;
		for (OrderManufacturing order : orders) {
			map=new HashMap<String,Object>();
			map.put("title", order.getRef());
			map.put("start",sf.format(order.getStartDate()));
			map.put("end", sf.format(order.getEndDate()));
			map.put("URL", "/manufacturing/profile?id="+order.getId());
			switch(order.getStatus()){
			case blocked:
				map.put("backgroundColor","#0073b7");
				map.put("borderColor","#0073b7");
				break;
			case canceled:
				map.put("backgroundColor","#00c0ef");
				map.put("borderColor","#0073b7");
				
				break;
			case charged:
				map.put("backgroundColor","#0073b7");
				map.put("borderColor","#0073b7");
				break;
			case end:
				map.put("backgroundColor","#0073b7");
				map.put("borderColor","#0073b7");
				break;
			case inpreparation:
				map.put("backgroundColor","#0073b7");
				map.put("borderColor","#0073b7");
				break;
			case notcharged:
				map.put("backgroundColor","#0073b7");
				map.put("borderColor","#0073b7");
				break;
			case onProduction:
				map.put("backgroundColor","#0073b7");
				map.put("borderColor","#0073b7");
				break;
			case waiting:
				map.put("backgroundColor","#0073b7");
				map.put("borderColor","#0073b7");
				break;
			default:
				break;
			
			}
			res.add(map);
			}
		
		return res;
	}

}
