/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.tramites.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author misanchez
 */
@Entity
@Table(name = "SOLICITUD01")
@NamedQueries({
    @NamedQuery(name = "Solicitud01.findAll", query = "SELECT s FROM Solicitud01 s")})
public class Solicitud01 implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Column(name = "ID_SOLICITUD01")
    private BigDecimal idSolicitud01;
    @Column(name = "CODIGO_ENTIDAD")
    private String codigoEntidad;
    @Column(name = "ANHO")
    private Short anho;
    @Column(name = "OPCION_BACH")
    private String opcionBach;
    @Column(name = "MODALIDAD_ATENCION")
    private String modalidadAtencion;
    @Column(name = "PERIODO_GRADUACION")
    private String periodoGraduacion;
    @Column(name = "JORNADA_ESTUDIO")
    private String jornadaEstudio;
    @Column(name = "CERTIFICACION_NOTA")
    private String certificacionNota;
    @Column(name = "REGISTRO_TITULO")
    private String registroTitulo;
    @Column(name = "REPOSICION_TITULO")
    private String reposicionTitulo;
    @Column(name = "GRADO")
    private String grado;
    @JoinColumn(name = "ID_TRAMITE", referencedColumnName = "ID_TRAMITE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Tramite idTramite;

    public Solicitud01() {
    }

    public Solicitud01(BigDecimal idSolicitud01) {
        this.idSolicitud01 = idSolicitud01;
    }

    public BigDecimal getIdSolicitud01() {
        return idSolicitud01;
    }

    public void setIdSolicitud01(BigDecimal idSolicitud01) {
        this.idSolicitud01 = idSolicitud01;
    }

    public String getCodigoEntidad() {
        return codigoEntidad;
    }

    public void setCodigoEntidad(String codigoEntidad) {
        this.codigoEntidad = codigoEntidad;
    }

    public Short getAnho() {
        return anho;
    }

    public void setAnho(Short anho) {
        this.anho = anho;
    }

    public String getOpcionBach() {
        return opcionBach;
    }

    public void setOpcionBach(String opcionBach) {
        this.opcionBach = opcionBach;
    }

    public String getModalidadAtencion() {
        return modalidadAtencion;
    }

    public void setModalidadAtencion(String modalidadAtencion) {
        this.modalidadAtencion = modalidadAtencion;
    }

    public String getPeriodoGraduacion() {
        return periodoGraduacion;
    }

    public void setPeriodoGraduacion(String periodoGraduacion) {
        this.periodoGraduacion = periodoGraduacion;
    }

    public String getJornadaEstudio() {
        return jornadaEstudio;
    }

    public void setJornadaEstudio(String jornadaEstudio) {
        this.jornadaEstudio = jornadaEstudio;
    }

    public String getCertificacionNota() {
        return certificacionNota;
    }

    public void setCertificacionNota(String certificacionNota) {
        this.certificacionNota = certificacionNota;
    }

    public String getRegistroTitulo() {
        return registroTitulo;
    }

    public void setRegistroTitulo(String registroTitulo) {
        this.registroTitulo = registroTitulo;
    }

    public String getReposicionTitulo() {
        return reposicionTitulo;
    }

    public void setReposicionTitulo(String reposicionTitulo) {
        this.reposicionTitulo = reposicionTitulo;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public Tramite getIdTramite() {
        return idTramite;
    }

    public void setIdTramite(Tramite idTramite) {
        this.idTramite = idTramite;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSolicitud01 != null ? idSolicitud01.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitud01)) {
            return false;
        }
        Solicitud01 other = (Solicitud01) object;
        if ((this.idSolicitud01 == null && other.idSolicitud01 != null) || (this.idSolicitud01 != null && !this.idSolicitud01.equals(other.idSolicitud01))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.gob.mined.tramites.model.Solicitud01[ idSolicitud01=" + idSolicitud01 + " ]";
    }
    
}
