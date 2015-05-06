package ma.esoftech.esoftrade.DTO;

import java.util.Date;

public class FileDTO {
	private long id;
	private String name;
	private Date createDate;
	private Date lastEditDate;
	private EditorDTO creator;
	private EditorDTO modifier;
	private String path;
	private float size;
	private int mask;
	private String type;

}
