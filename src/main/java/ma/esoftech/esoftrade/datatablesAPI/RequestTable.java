package ma.esoftech.esoftrade.datatablesAPI;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RequestTable {

	@NotNull
	private int draw;
	@NotNull
	private int start;
	@NotNull
	@Max(1000)
	private int length;
	@NotNull
	@Size(max=100)
	private Map<SearchCriterias, String> search;
	@NotNull
	@Size(max=100)
	private List<Map<ColumnCriterias, String>> columns;
	@NotNull
	@Size(max=100)
	private List<Map<OrderCriterias, String>> order;

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Map<SearchCriterias, String> getSearch() {
		return search;
	}

	public void setSearch(Map<SearchCriterias, String> search) {
		this.search = search;
	}

	public List<Map<ColumnCriterias, String>> getColumns() {
		return columns;
	}

	public void setColumns(List<Map<ColumnCriterias, String>> columns) {
		this.columns = columns;
	}

	public List<Map<OrderCriterias, String>> getOrder() {
		return order;
	}

	public void setOrder(List<Map<OrderCriterias, String>> order) {
		this.order = order;
	}

	public enum SearchCriterias {
		value, regex
	}

	public enum OrderCriterias {
		column, dir
	}

	public enum ColumnCriterias {
		data, name, searchable, orderable, searchValue, searchRegex
	}

}
