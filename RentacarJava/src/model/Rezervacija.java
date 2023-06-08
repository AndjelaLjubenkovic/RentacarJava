package model;

import java.util.Objects;

public class Rezervacija {

	private int rezervacija_id;
	private int klijent_id;
	private int auto_id;


	public int getRezervacija_id() {
	    return rezervacija_id;
	}

	/**
	 * 
	 * @param rezervacija_id
	 */
	public void setRezervacija_id(int rezervacija_id) {
	    this.rezervacija_id = rezervacija_id;
	}

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

	public int getAuto_id() {
	    return auto_id;
	}

	/**
	 * 
	 * @param auto_id
	 */
	public void setAuto_id(int auto_id) {
	    this.auto_id = auto_id;
	}

	public Rezervacija(int rezervacija_id, int klijent_id, int auto_id) {
		super();
		this.rezervacija_id = rezervacija_id;
		this.klijent_id = klijent_id;
		this.auto_id = auto_id;
	}

	public Rezervacija(int klijent_id, int auto_id) {
		super();
		this.klijent_id = klijent_id;
		this.auto_id = auto_id;
	}

	public Rezervacija() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(auto_id, klijent_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rezervacija other = (Rezervacija) obj;
		return auto_id == other.auto_id && klijent_id == other.klijent_id;
	}
	
	
}