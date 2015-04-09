package ma.esoftech.esoftrade.generate;

import java.util.List;

public class EntityDTO {

	private  String ent;
	private List<String> childs;
	public String getEnt() {
		return ent;
	}
	public void setEnt(String ent) {
		this.ent = ent;
	}
	public List<String> getChilds() {
		return childs;
	}
	public void setChilds(List<String> childs) {
		this.childs = childs;
	}
	
}
