/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.tramites.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

/**
 *
 * @author MISanchez
 */
@Entity
@SqlResultSetMapping(name = "defaultSolicitud02",
        entities = @EntityResult(entityClass = Solicitud02Dto.class))
public class Solicitud02Dto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private BigDecimal idSolicitud02;
    private String nombrePais;
    private String nombreCiudad;
    private String gradoObtenido;
    private String titulo;
    private String diploma;
    private String certificado;
    private String extendidoPor;

    public Solicitud02Dto() {
    }

    public BigDecimal getIdSolicitud02() {
        return idSolicitud02;
    }

    public void setIdSolicitud02(BigDecimal idSolicitud02) {
        this.idSolicitud02 = idSolicitud02;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public String getGradoObtenido() {
        return gradoObtenido;
    }

    public void setGradoObtenido(String gradoObtenido) {
        this.gradoObtenido = gradoObtenido;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDiploma() {
        return diploma;
    }

    public void setDiploma(String diploma) {
        this.diploma = diploma;
    }

    public String getCertificado() {
        return certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    public String getExtendidoPor() {
        return extendidoPor;
    }

    public void setExtendidoPor(String extendidoPor) {
        this.extendidoPor = extendidoPor;
    }

}
