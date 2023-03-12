package BusinessLogic.Entities;

import java.util.Date;

public class Coordenadas {
    private Integer hj_capacidad_belica;
    private String hj_geoposicionamiento;
    private String hj_tipo_arsenal;
    private Date hj_fecha_de_hackeo; // Importar la clase Date
    
    // Constructor
    public Coordenadas(Integer hj_capacidad_belica, String hj_geoposicionamiento, String hj_tipo_arsenal, Date hj_fecha_de_hackeo) {
        this.hj_capacidad_belica = hj_capacidad_belica;
        this.hj_geoposicionamiento = hj_geoposicionamiento;
        this.hj_tipo_arsenal = hj_tipo_arsenal;
        this.hj_fecha_de_hackeo = hj_fecha_de_hackeo;
    }
    
    // Getters y Setters
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
    
    public Date getHj_fecha_de_hackeo() {
        return hj_fecha_de_hackeo;
    }
    
    public void setHj_fecha_de_hackeo(Date hj_fecha_de_hackeo) {
        this.hj_fecha_de_hackeo = hj_fecha_de_hackeo;
    }
}
