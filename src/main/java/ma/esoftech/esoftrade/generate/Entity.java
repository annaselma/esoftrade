package ma.esoftech.esoftrade.generate;

import java.util.List;

public class Entity {

	private  String ent;
	private List<Child> childs;
	public String getEnt() {
		return ent;
	}
	public void setEnt(String ent) {
		this.ent = ent;
	}
	public List<Child> getChilds() {
		return childs;
	}
	public void setChilds(List<Child> childs) {
		this.childs = childs;
	}
	
}
