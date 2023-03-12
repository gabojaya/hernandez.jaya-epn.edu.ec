package DataAccess;

import BusinessLogic.Entities.Coordenadas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CoordenadasDAC {

    private final Connection conn;

    public CoordenadasDAC(Connection conn) {
        this.conn = conn;
    }

    public CoordenadasDAC(String databaseName) {
        try {
            String url = "jdbc:sqlite:" + databaseName;
            conn = DriverManager.getConnection(url);
            System.out.println("La Conexión a la base de Datos ha sido establecida.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertCoordenadas(Coordenadas Coordenadas) throws SQLException {
        String query = "INSERT INTO HJ_CoordenadasS(hj_Coordenadasname,hj_password) VALUES(?,?)";

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, Coordenadas.getCoordenadasname());
            statement.setString(2, Coordenadas.getPassword());
            statement.executeUpdate();
        }
    }

}
