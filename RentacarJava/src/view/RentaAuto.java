package view;

public class RentaAuto {
	private String marka;
	private String model;

	public RentaAuto(String marka, String model) {
		super();
		this.marka = marka;
		this.model = model;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
}
