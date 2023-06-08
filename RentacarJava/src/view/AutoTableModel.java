package view;

import javax.swing.table.AbstractTableModel;

import controller.AutoController;
import model.Auto;

import java.util.*;

public class AutoTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private String kolone[] = { "Marka", "Model", "Godiste", "Iznajmljen" };
	public AutoController ac = new AutoController();
	private ArrayList<Auto> listaAuto = new ArrayList<>();

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		return switch (columnIndex) {
		case 0 -> listaAuto.get(rowIndex).getMarka();
		case 1 -> listaAuto.get(rowIndex).getModel();
		case 2 -> listaAuto.get(rowIndex).getGodiste();
		case 3 -> listaAuto.get(rowIndex).isIznajmljen();
		default -> "-";
		};
	}

	@Override
	public String getColumnName(int column) {
		return kolone[column];
	}

	@Override
	public int getColumnCount() {
		return kolone.length;
	}

	@Override
	public int getRowCount() {
		return listaAuto.size();
	}

	public void osveziPodatke() {
		ac = new AutoController();
		listaAuto = ac.dobaviSveAute();
		fireTableDataChanged();
	}

	/**
	 * Metoda koja vraca sve dostupne automobile za iznajmljivanje
	 * @return ArrayList
	 */
	public ArrayList<Auto> getDostupniAutomobili() {

		ArrayList<Auto> dostupniAutomobili = new ArrayList<>();
		
		listaAuto = ac.dobaviSveAute();
		
		for (Auto auto : listaAuto) {
			if (!auto.isIznajmljen()) {
				dostupniAutomobili.add(auto);
			}
		}
		return dostupniAutomobili;
	}

}
