package BusinessLogic;

import java.sql.SQLException;
import java.util.List;

import BusinessLogic.Entities.Coordenadas;
import DataAccess.CoordenadasDAC;

public class CoordenadasBL {
    private CoordenadasDAC coordenadasDAC;

    public CoordenadasBL(String dbPathConnection) {
        this.coordenadasDAC = new CoordenadasDAC(dbPathConnection);
    }

    public List<Coordenadas> getAllCoordenadas() {
        try {
            return coordenadasDAC.getAll();
        } catch (SQLException e) {
            System.out.println(">> (error) CoordenadasBL.getAllCoordenadas() " + e.getMessage());
            return null;
        }
    }

    public boolean existeCoordenada(String geoposicionamiento) {
        try {
            List<Coordenadas> coordenadas = coordenadasDAC.getAll();
            for (Coordenadas coordenada : coordenadas) {
                if (coordenada.getHj_geoposicionamiento().equals(geoposicionamiento)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println(">> (error) CoordenadasBL.existeCoordenada() " + e.getMessage());
        }

        return false;
    }
}
