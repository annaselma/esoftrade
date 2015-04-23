package ma.esoftech.esoftrade.datatablesAPI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import ma.esoftech.esoftrade.datatablesAPI.RequestTable.ColumnCriterias;
import ma.esoftech.esoftrade.datatablesAPI.RequestTable.SearchCriterias;

public class FilterCriterias {

	private Map<String, String> filterCriterias;
	public static String GLOBAL_SEARCH="GlobalSearch";

	private FilterCriterias() {
		filterCriterias = new HashMap<String, String>();
	}

	private void addFilter(String key, String value) {
		filterCriterias.put(key, value);
	}

	public String getFilter(String key) {
		return filterCriterias.get(key);
	}

	@SuppressWarnings("unused")
	private String removeFilter(String key) {
		return filterCriterias.remove(key);
	}

	public Set<Entry<String, String>> entrySet() {
		return filterCriterias.entrySet();
	}

	public static FilterCriterias getFilterCriterias(RequestTable request) {
		FilterCriterias filterCriterias = new FilterCriterias();
		addDefaultFilter(filterCriterias, request);
		List<Map<ColumnCriterias, String>> columns = request.getColumns();

		for (Map<ColumnCriterias, String> column : columns) {
			if (columnIsSearchable(column)) {
				addLigneFilter(filterCriterias, column);
			}
		}

		return filterCriterias;
	}

	private static void addLigneFilter(FilterCriterias filterCriterias,
			Map<ColumnCriterias, String> column) {
		filterCriterias.addFilter(column.get(ColumnCriterias.name),
				column.get(ColumnCriterias.searchValue));
	}

	private static boolean columnIsSearchable(
			Map<ColumnCriterias, String> column) {
		return Boolean.getBoolean(column.get(ColumnCriterias.searchable));
	}

	private static void addDefaultFilter(FilterCriterias filterCriterias,
			RequestTable request) {
		filterCriterias.addFilter(GLOBAL_SEARCH,
				request.getSearch().get(SearchCriterias.value));
	}

}
