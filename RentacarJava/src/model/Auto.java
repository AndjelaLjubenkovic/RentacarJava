package model;

import java.util.Objects;

public class Auto {

	private int auto_id;
	private String marka;
	private String model;
	private int godiste;
	private boolean is_iznajmljen;

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

	public String getMarka() {
	    return marka;
	}

	/**
	 * 
	 * @param marka
	 */
	public void setMarka(String marka) {
	    this.marka = marka;
	}

	public String getModel() {
	    return model;
	}

	/**
	 * 
	 * @param model
	 */
	public void setModel(String model) {
	    this.model = model;
	}

	public int getGodiste() {
	    return godiste;
	}

	/**
	 * 
	 * @param godiste
	 */
	public void setGodiste(int godiste) {
	    this.godiste = godiste;
	}

	public boolean isIznajmljen() {
	    return is_iznajmljen;
	}

	/**
	 * 
	 * @param is_iznajmljen
	 */
	public void setIznajmljen(boolean is_iznajmljen) {
	    this.is_iznajmljen = is_iznajmljen;
	}

	

	public Auto(String marka, String model, int godiste, boolean is_iznajmljen) {
		super();
		this.marka = marka;
		this.model = model;
		this.godiste = godiste;
		this.is_iznajmljen = is_iznajmljen;
	}

	public Auto(int auto_id, String marka, String model, int godiste, boolean is_iznajmljen) {
		super();
		this.auto_id = auto_id;
		this.marka = marka;
		this.model = model;
		this.godiste = godiste;
		this.is_iznajmljen = is_iznajmljen;
	}

	public Auto() {
		super();
	}

	@Override
	public String toString() {
		return "Marka: " + marka + "Model: " + model + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(godiste, is_iznajmljen, marka, model);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Auto other = (Auto) obj;
		return godiste == other.godiste && is_iznajmljen == other.is_iznajmljen && Objects.equals(marka, other.marka)
				&& Objects.equals(model, other.model);
	}
		
}