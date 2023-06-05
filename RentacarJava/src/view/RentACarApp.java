package view;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;


public class RentACarApp extends JFrame {
	
    private static final long serialVersionUID = 1L;
	private JTable table;
    private RentaTableModel tableModel;

    public RentACarApp() {
        setTitle("Rent-A-Car");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        tableModel = new RentaTableModel();
        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);

        // Dodajte neke testne podatke
        tableModel.addCar(new RentaAuto("Marka1", "Model1"));
        tableModel.addCar(new RentaAuto("Marka2", "Model2"));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                RentACarApp app = new RentACarApp();
                app.setVisible(true);
            }
        });
    }
}

/*
class RentalTableModel extends AbstractTableModel {
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
*/
