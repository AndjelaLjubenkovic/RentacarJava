 package model;
public class Klijent {

	private int klijent_id;
	private String ime;
	private String prezime;
	private String broj_telefona;
	private String broj_vozacke;

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

	public Klijent(int klijent_id, String ime, String prezime, String broj_telefona, String broj_vozacke) {
		super();
		this.klijent_id = klijent_id;
		this.ime = ime;
		this.prezime = prezime;
		this.broj_telefona = broj_telefona;
		this.broj_vozacke = broj_vozacke;
	}

	public Klijent(String ime, String prezime, String broj_telefona, String broj_vozacke) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.broj_telefona = broj_telefona;
		this.broj_vozacke = broj_vozacke;
	}

	public Klijent() {
		super();
	}

	@Override
	public String toString() {
		return "Klijent [ime=" + ime + ", prezime=" + prezime + ", broj_telefona=" + broj_telefona + ", broj_vozacke="
				+ broj_vozacke + "]";
	}
	
	

	
}