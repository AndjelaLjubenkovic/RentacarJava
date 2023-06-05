package view;

import javax.swing.table.AbstractTableModel;


public class ModelTabeleAuto extends AbstractTableModel{
	
	

	private static final long serialVersionUID = 1L;
	private String[]kolone = {"Marka","Model","Godiste","Iznajmljen"};

	@Override
	public int getRowCount() {
		return 4;
	}

	@Override
	public int getColumnCount() {
		
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return null;
	}

	public String[] getKolone() {
		return kolone;
	}

	public void setKolone(String[] kolone) {
		this.kolone = kolone;
	}
	
	
	
	
	
	
}
