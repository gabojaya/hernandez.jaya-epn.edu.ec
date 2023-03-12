package BusinessLogic.Entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Coordenadas {
    private Integer hj_capacidad_belica;
    private String hj_geoposicionamiento;
    private String hj_tipo_arsenal;

    public Coordenadas(int hj_capacidad_belica, String hj_geoposicionamiento, String hj_tipo_arsenal){
        this.hj_capacidad_belica = hj_capacidad_belica;
        this.hj_geoposicionamiento = hj_geoposicionamiento;
        this.hj_tipo_arsenal = hj_tipo_arsenal;
    }

    public Integer getHj_capacidad_belica() {
        return hj_capacidad_belica;
    }

    public void setHj_capacidad_belica(Integer hj_capacidad_belica) {
        this.hj_capacidad_belica = hj_capacidad_belica;
    }

    public String getHj_geoposicionamiento() {
        return hj_geoposicionamiento;
    }

    public void setHj_geoposicionamiento(String hj_geoposicionamiento) {
        this.hj_geoposicionamiento = hj_geoposicionamiento;
    }

    public String getHj_tipo_arsenal() {
        return hj_tipo_arsenal;
    }

    public void setHj_tipo_arsenal(String hj_tipo_arsenal) {
        this.hj_tipo_arsenal = hj_tipo_arsenal;
    }

    public class hj_capacidad_belica {
    
    public List<Coordenadas>getAllhj_capacidad_belica() throws AppException{
        try {
            CoordenadasDAC    CoordenadasDAC    = new CoordenadasDAC();
            List<Coordenadas> lstCoordenadas    = new ArrayList<Coordenadas>();

            ResultSet rs =  CoordenadasDAC.getAllhj_capacidad_belica();
            while(rs.next())    {
                Coordenadas s = new Coordenadas(rs.getInt("ID_Coordenadas"), rs.getInt("ID_Coordenadas_PADRE"), 
                rs.getInt("ID_Coordenadas_TIPO"),  rs.getString("NOMBRE"),  rs.getString("ESTADO")); 
                lstCoordenadas.add(s);
            }
            return lstCoordenadas; 
        } catch (SQLException e) {
            throw new AppException(e, getClass(),"getAllhj_capacidad_belica");
        }
    }
}
    
}
