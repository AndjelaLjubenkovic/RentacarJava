package model;
public class Klijent {

	private int klijent_id;
	private String ime;
	private String prezime;
	private String broj_telefona;
	private String broj_vozacke;
	private int user_id;

	public int getKlijent_id() {
	    return klijent_id;
	}

	/**
	 * 
	 * @param klijent_id
	 */
	public void setKlijent_id(int klijent_id) {
	    this.klijent_id = klijent_id;
	}

	public String getIme() {
	    return ime;
	}

	/**
	 * 
	 * @param ime
	 */
	public void setIme(String ime) {
	    this.ime = ime;
	}

	public String getPrezime() {
	    return prezime;
	}

	/**
	 * 
	 * @param prezime
	 */
	public void setPrezime(String prezime) {
	    this.prezime = prezime;
	}

	public String getBroj_telefona() {
	    return broj_telefona;
	}

	/**
	 * 
	 * @param broj_telefona
	 */
	public void setBroj_telefona(String broj_telefona) {
	    this.broj_telefona = broj_telefona;
	}

	public String getBroj_vozacke() {
	    return broj_vozacke;
	}

	/**
	 * 
	 * @param broj_vozacke
	 */
	public void setBroj_vozacke(String broj_vozacke) {
	    this.broj_vozacke = broj_vozacke;
	}

	public int getUser_id() {
	    return user_id;
	}

	/**
	 * 
	 * @param user_id
	 */
	public void setUser_id(int user_id) {
	    this.user_id = user_id;
	}

	public Klijent() {
	    // TODO - implement Klijent.Klijent
	    throw new UnsupportedOperationException();
	}
}