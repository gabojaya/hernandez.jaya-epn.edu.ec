package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import BusinessLogic.Entities.Coordenadas;

public class CoordenadasDAC extends SQLiteDataHelper {

    public CoordenadasDAC(String dbPathConnection) {
        super(dbPathConnection);
    }

    public List<Coordenadas> getAll() throws SQLException {
        List<Coordenadas> result = new ArrayList<>();
        String sql = "SELECT hj_capacidad_belica, hj_geoposicionamiento, hj_tipo_arsenal, hj_fecha_de_hackeo FROM Coordenadas";
        ResultSet rs = null;

       
            rs = getResultSet(sql);
            while (rs.next()) {
                Integer hj_capacidad_belica = rs.getInt("hj_capacidad_belica");
                String hj_geoposicionamiento = rs.getString("hj_geoposicionamiento");
                String hj_tipo_arsenal = rs.getString("hj_tipo_arsenal");
                Date hj_fecha_de_hackeo = new Date(rs.getLong("hj_fecha_de_hackeo"));

                Coordenadas coordenadas = new Coordenadas(hj_capacidad_belica, hj_geoposicionamiento, hj_tipo_arsenal,
                        hj_fecha_de_hackeo);
                result.add(coordenadas);
            }
        

        return result;
    }
}