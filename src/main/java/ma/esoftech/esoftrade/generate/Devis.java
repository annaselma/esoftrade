package ma.esoftech.esoftrade.generate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
@Entity
@Table
public class Devis {
	@TableGenerator(name = "GEN", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "GEN")
	@Column
  private int id;
	@Column
  private String name;
	@OneToMany
	@JoinColumn(name="USERID")
  private List<LigneDevis>devis= new ArrayList<LigneDevis>();
	@ManyToOne
  private User user;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public List<LigneDevis> getDevis() {
	return devis;
}
public void setDevis(List<LigneDevis> devis) {
	this.devis = devis;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
}
