package view;

import java.util.ArrayList;
import model.Auto;
import javax.swing.table.AbstractTableModel;

import controller.AutoController;

public class AutoTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private String kolone[] = {"Marka", "Model", "Godiste", "Iznajmljen"};
	private ArrayList<Auto> listaAuto = new ArrayList<>();
	@Override
	public int getRowCount() {
		return listaAuto.size();
	}

	@Override
	public int getColumnCount() {
		return kolone.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return switch(columnIndex) {
		case 0 -> listaAuto.get(rowIndex).getAuto_id();
		case 1 -> listaAuto.get(rowIndex).getMarka();
		case 2 -> listaAuto.get(rowIndex).getModel();
		case 3 -> listaAuto.get(rowIndex).getGodiste();
		case 4 -> listaAuto.get(rowIndex).isIznajmljen();
		default -> "-";
		};
	}

	@Override
	public String getColumnName(int column) {
		return kolone[column];
	}
	
	public void osveziPodatke() {
	    AutoController autoController = new AutoController();
	    listaAuto = autoController.dobaviSveAute();
	    fireTableDataChanged();
	}
}
