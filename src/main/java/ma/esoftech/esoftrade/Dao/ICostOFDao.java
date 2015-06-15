package ma.esoftech.esoftrade.Dao;

import ma.esoftech.esoftrade.model.OrderManufacturing;

public interface ICostOFDao {

	public float getCostGOF(OrderManufacturing order);
	public float getCostGammeOF(OrderManufacturing order);
}
