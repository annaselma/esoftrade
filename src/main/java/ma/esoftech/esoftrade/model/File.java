package ma.esoftech.esoftrade.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Index;

@Entity
@Table(name = "ELMO_FILE")
public class File extends MetaObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Index(name="ELMO_NAME_INDEX")
	@Column(name="ELMO_NAME",nullable=false,length=255)
	private String name;
	@Column(name="ELMO_DESCRIPTION",length=1024)
	private String description;
	@Column(name="ELMO_PATH",nullable=false,length=255)	
	private String path;
	@Column(name="ELMO_SIZE",nullable=false)
	private float size;
	@Column(name="ELMO_MASK")
	private int mask;
	@Column(name="ELMO_TYPE")	
	private String type;
	
	public File(){
		super();
		initialize();
	}
	private void initialize(){
		this.mask=777;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public float getSize() {
		return size;
	}


	public void setSize(float size) {
		this.size = size;
	}


	public int getMask() {
		return mask;
	}


	public void setMask(int mask) {
		this.mask = mask;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void generatePath(String path){
		this.path=path+"/"+this.getId()+"_"+name;
	}
	
	

}
