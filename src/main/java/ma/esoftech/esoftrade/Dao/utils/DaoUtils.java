package ma.esoftech.esoftrade.Dao.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.hibernate.Query;

import ma.esoftech.esoftrade.datatablesAPI.FilterCriterias;
import ma.esoftech.esoftrade.utils.UTILS;

public class DaoUtils {
	private static String prefix="PRE_";
	
	public static String createHqlSearch(FilterCriterias filters,String objectName){
		String hql=" where 1=1 ";
	 	Set<Entry<String, String>> setFilter=filters.entrySet();
	 	for (Entry<String, String> entry : setFilter) {
			if(entry.getValue()==null||entry.getKey()==null||
					entry.getValue().isEmpty()||entry.getKey().isEmpty()||
					entry.getValue().equals(FilterCriterias.GLOBAL_SEARCH)){
				continue;
			}
			hql=hql.concat(" and ");
			hql=hql.concat(objectName);
			hql=hql.concat(".");
			hql=hql.concat(entry.getKey());
			hql=hql.concat("=:");
			hql=hql.concat(entry.getKey());
		}
		return  hql;
	}
	public static Query setHQLParameterSearch(FilterCriterias filters,Query query,Map<String ,ParameterType> types){
		Set<Entry<String, String>> setFilter=filters.entrySet();
	 	for (Entry<String, String> entry : setFilter) {
			if(entry.getValue()==null||entry.getKey()==null||
			        entry.getValue().isEmpty()||entry.getKey().isEmpty()||
					entry.getValue().equals(FilterCriterias.GLOBAL_SEARCH)){
		     	continue;	
			}
			query.setParameter(entry.getKey(),getObjectValue(types, entry));
		}
		
		return query;
	}

	private static Object getObjectValue(Map<String, ParameterType> types,
			Entry<String, String> entry) {
		SimpleDateFormat simpFormat = new SimpleDateFormat(UTILS.FORMAT_DATE);
		switch (types.get(entry.getKey())) {

		case Date:
			try {
				Date date = simpFormat.parse(entry.getValue());
				return date;
			} catch (ParseException e) {
				return new Date();
			}
		case Double:
			Double dble = new Double(entry.getValue());
			return dble;

		case String:
			return entry.getValue();

		case Long:
			Long loong = new Long(entry.getValue());
			return loong;

		case Float:
			Float flt = new Float(entry.getValue());
			return flt;

		case Integer:

			Integer integer = new Integer(entry.getValue());
			return integer;

		default:

			return null;
		}
	}
	
public enum ParameterType{
	String,Integer,Long,Float,Double,Date
}
}

