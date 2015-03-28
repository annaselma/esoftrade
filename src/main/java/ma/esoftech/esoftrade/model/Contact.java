package ma.esoftech.esoftrade.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="Contact")
public class Contact extends Person  {
	private static final long serialVersionUID = 1L;
	
	@Column(name="ETAT")
	private boolean etat;
	
	@Column(name="FOURNISSEUR")
 private boolean fournisseur;
	
	@Column(name="CLIENT")
	private boolean client;
	
	public boolean isFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(boolean fournisseur) {
		this.fournisseur = fournisseur;
	}

	public boolean isClient() {
		return client;
	}

	public void setClient(boolean client) {
		this.client = client;
	}

	public boolean isEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	
 public Contact(){}
}
