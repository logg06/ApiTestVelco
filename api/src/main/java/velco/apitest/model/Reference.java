package velco.apitest.model;

import java.util.Locale;

import javax.persistence.Entity;

/**
 * Objet représentant une référence
 * 
 * @author rseisser
 *
 */
@Entity
public class Reference {

	/** Le numéro de la référence */
	private Integer numReference;

	/** La couleur de la référence (valeurs possibles : R, G ou B) */
	private String type;

	/** Le prix de la référence (valeurs en euros) */
	private float price;

	/** La taille de la référence */
	private Integer size;

	/**
	 * Constructeur
	 * 
	 * @param numReference Le numéro de la référence
	 * @param type         La couleur de la référence
	 * @param price        Le prix de la référence
	 * @param size         La taille de la référence
	 */
	public Reference(int numReference, String type, float price, int size) {
		this.numReference = numReference;
		this.type = type;
		this.price = price;
		this.size = size;
	}

	/**
	 * Obtient le numéro de la référence
	 * 
	 * @return Le numéro de la référence
	 */
	public int getNumeroReference() {
		return numReference;
	}

	/**
	 * Définit le numéro de la référence
	 * 
	 * @param numReference Le numéro de la référence
	 */
	public void setNumeroReference(int numReference) {
		this.numReference = numReference;
	}

	/**
	 * Obtient la couleur de la référence (valeurs possibles : R, G ou B)
	 * 
	 * @return La couleur de la référence (valeurs possibles : R, G ou B)
	 */
	public String getType() {
		return type;
	}

	/**
	 * Définit la couleur de la référence (valeurs possibles : R, G ou B)
	 * 
	 * @param type La couleur de la référence (valeurs possibles : R, G ou B)
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Obtient le prix de la référence (valeurs en euros)
	 * 
	 * @return Le prix de la référence (valeurs en euros)
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * Définit le prix de la référence (valeurs en euros)
	 * 
	 * @param price Le prix de la référence (valeurs en euros)
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * Obtient la taille de la référence
	 * 
	 * @return La taille de la référence
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Définit la taille de la référence
	 * 
	 * @param size La taille de la référence
	 */
	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return String.format(Locale.getDefault(), "reference : numReference:%s, type:%s, price:%s, size:%s",
				numReference, type, price, size);
	}

}
