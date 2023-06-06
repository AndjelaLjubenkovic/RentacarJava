package view;

/*
import java.util.ArrayList;
import model.Auto;
import javax.swing.table.AbstractTableModel;

import controller.AutoController;
import konekcija.DBConnection;

public class AutoTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private String kolone[] = {"Marka", "Model", "Godiste", "Iznajmljen"};
	private ArrayList<Auto> listaAuto = new ArrayList<>();
	
	public AutoController ac;
	
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
		case 0 -> listaAuto.get(rowIndex).getMarka();
		case 1 -> listaAuto.get(rowIndex).getModel();
		case 2 -> listaAuto.get(rowIndex).getGodiste();
		case 3 -> listaAuto.get(rowIndex).isIznajmljen();
		case 4 -> "Iznajmi";
		default -> "-";
		};
	}

	@Override
	public String getColumnName(int column) {
		return kolone[column];
	}
	
	public void osveziPodatke() {
	    ac = new AutoController();
	    listaAuto = ac.dobaviSveAute();
	    //DBConnection.getInstance().zatvoriKonekciju();
	    fireTableDataChanged();
	}
}
*/
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import controller.AutoController;
import model.Auto;

import java.util.*;

public class AutoTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private String kolone[] = { "Marka", "Model", "Godiste", "Iznajmljen" };
	private ArrayList<Auto> listaAuto = new ArrayList<>();

	public AutoController ac;

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
	public Class<?> getColumnClass(int columnIndex) {
		if (columnIndex == 4) {
			return JButton.class;
		} else {
			return super.getColumnClass(columnIndex);
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex == 4;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		if (columnIndex == 4) {
			// Ovdje možete implementirati logiku za iznajmljivanje
			// na temelju rowIndex-a
		}
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
		// DBConnection.getInstance().zatvoriKonekciju();
		fireTableDataChanged();
	}

}
