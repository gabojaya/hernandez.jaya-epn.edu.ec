package UserInterface;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BusinessLogic.Entities.Coordenadas;
import DataAccess.CoordenadasDAC;

public class CoordenadasGUI extends JFrame {

    private JPanel contentPane;
    private JTable table;

    public CoordenadasGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 400);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 11, 464, 339);
        contentPane.add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {"Cargando","Capacidad bélica", "Geoposicionamiento", "Tipo de arsenal", "Fecha de hackeo"}
        ));
        scrollPane.setViewportView(table);

        CoordenadasDAC coordenadasDAC = new CoordenadasDAC("data/database.db");
        try {
            for (Coordenadas coordenadas : coordenadasDAC.getAll()) {
                Object[] row = {
                    coordenadas.getHj_capacidad_belica(),
                    coordenadas.getHj_geoposicionamiento(),
                    coordenadas.getHj_tipo_arsenal(),
                    coordenadas.getHj_fecha_de_hackeo()
                };
                ((DefaultTableModel)table.getModel()).addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        CoordenadasGUI frame = new CoordenadasGUI();
        frame.setVisible(true);
    }
}
