package model;
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

	public Auto() {
	    // TODO - implement Auto.Auto
	    throw new UnsupportedOperationException();
	}

	public boolean isIs_iznajmljen() {
		return is_iznajmljen;
	}

	public void setIs_iznajmljen(boolean is_iznajmljen) {
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

	
	
	
	
	
}