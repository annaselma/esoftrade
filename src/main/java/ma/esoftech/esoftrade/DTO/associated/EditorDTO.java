package ma.esoftech.esoftrade.DTO.associated;

public class EditorDTO {
	private long id;
	private String firstName;
	private String lastName;
	private FileAssociatedDTO picture;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public FileAssociatedDTO getPicture() {
		return picture;
	}
	public void setPicture(FileAssociatedDTO picture) {
		this.picture = picture;
	}
	

}
