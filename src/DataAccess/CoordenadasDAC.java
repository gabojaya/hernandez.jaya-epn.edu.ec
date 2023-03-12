package DataAccess;

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

    public List<Coordenadas> getAllCoordenadas() throws SQLException {
        String sql = "SELECT * FROM HJ_ARSENAL;";
        ResultSet rs = getResultSet(sql);
        List<Coordenadas> coordenadas = new ArrayList<>();

        while (rs.next()) {
            Integer hj_capacidad_belica = rs.getInt("hj_capacidad_belica");
            String hj_geoposicionamiento = rs.getString("hj_geoposicionamiento");
            String hj_tipo_arsenal = rs.getString("hj_tipo_arsenal");
            Date hj_fecha_de_hackeo = rs.getDate("hj_fecha_de_hackeo");
            Coordenadas coordenadas2 = new Coordenadas(hj_capacidad_belica, hj_geoposicionamiento, hj_tipo_arsenal, hj_fecha_de_hackeo);
            coordenadas.add(coordenadas2);
        }

        return coordenadas;
    }
}