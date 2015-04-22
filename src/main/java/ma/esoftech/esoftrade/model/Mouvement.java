package ma.esoftech.esoftrade.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ELMO_MOUVEMENT")
public class Mouvement extends MetaObject implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String motif;
	private String NumOF;
	private String NumCommande;
	
	@ManyToOne
	@JoinColumn(name="ELMO_PRODUCT_ID")
	private Product produit;

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public String getNumOF() {
		return NumOF;
	}

	public void setNumOF(String numOF) {
		NumOF = numOF;
	}

	public String getNumCommande() {
		return NumCommande;
	}

	public void setNumCommande(String numCommande) {
		NumCommande = numCommande;
	}
	
}


