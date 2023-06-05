package view;

import javax.swing.table.AbstractTableModel;

import java.util.ArrayList;
import java.util.List;


public class RentaTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
    private static final String[] COLUMN_NAMES = { "Marka", "Model" };
    private static final Class<?>[] COLUMN_CLASSES = { String.class, String.class };

    private List<RentaAuto> cars = new ArrayList<>();
    public void addCar(RentaAuto car) {
        cars.add(car);
        fireTableRowsInserted(cars.size() - 1, cars.size() - 1);
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public int getRowCount() {
        return cars.size();
    }

    @Override
    public Object getValueAt(int row, int column) {
        RentaAuto car = cars.get(row);
        switch (column) {
            case 0:
                return car.getMarka();
            case 1:
                return car.getModel();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return COLUMN_CLASSES[columnIndex];
    }
}
	
	


