package ma.esoftech.esoftrade.DTO;

import javax.validation.constraints.Size;

public class PasswordDTO {

	
	@Size(max=50,min=5)
	private String password1;
	@Size(max=50,min=5)
    private String password2;
    private long id;
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
    
}
