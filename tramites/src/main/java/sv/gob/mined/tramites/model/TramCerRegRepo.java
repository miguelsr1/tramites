/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.tramites.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author DesarrolloPc
 */
@Entity
@Table(name = "TRAM_CER_REG_REPO")
@NamedQueries({
    @NamedQuery(name = "TramCerRegRepo.findAll", query = "SELECT t FROM TramCerRegRepo t")})
public class TramCerRegRepo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TRAM")
    private BigDecimal idTram;
    @Size(max = 1)
    @Column(name = "CERTIFICACION_NOTA")
    private String certificacionNota;
    @Size(max = 1)
    @Column(name = "REGISTRO_TITULO")
    private String registroTitulo;
    @Size(max = 1)
    @Column(name = "REPOSICION_TITULO")
    private String reposicionTitulo;
    @Size(max = 1)
    @Column(name = "TIPO_MODALIDAD")
    private String tipoModalidad;
    @Size(max = 1)
    @Column(name = "PERIODO_GRADUACION")
    private String periodoGraduacion;
    @Size(max = 1)
    @Column(name = "JORNADA_ESTUDIO")
    private String jornadaEstudio;
    @Size(max = 5)
    @Column(name = "CODIGO_ENTIDAD")
    private String codigoEntidad;
    @Column(name = "ANHO")
    private Short anho;
    @Size(max = 2)
    @Column(name = "GRADO")
    private String grado;
    @Size(max = 6)
    @Column(name = "OPCION_BACH")
    private String opcionBach;
    @JoinColumn(name = "ID_TRAMITE", referencedColumnName = "ID_TRAMITE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Tramite idTramite;

    public TramCerRegRepo() {
    }

    public TramCerRegRepo(BigDecimal idTram) {
        this.idTram = idTram;
    }

    public BigDecimal getIdTram() {
        return idTram;
    }

    public void setIdTram(BigDecimal idTram) {
        this.idTram = idTram;
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

    public String getTipoModalidad() {
        return tipoModalidad;
    }

    public void setTipoModalidad(String tipoModalidad) {
        this.tipoModalidad = tipoModalidad;
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

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getOpcionBach() {
        return opcionBach;
    }

    public void setOpcionBach(String opcionBach) {
        this.opcionBach = opcionBach;
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
        hash += (idTram != null ? idTram.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TramCerRegRepo)) {
            return false;
        }
        TramCerRegRepo other = (TramCerRegRepo) object;
        if ((this.idTram == null && other.idTram != null) || (this.idTram != null && !this.idTram.equals(other.idTram))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.gob.mined.tramites.model.TramCerRegRepo[ idTram=" + idTram + " ]";
    }
    
}
