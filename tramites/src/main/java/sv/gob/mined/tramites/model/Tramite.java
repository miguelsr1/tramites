/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.tramites.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author DesarrolloPc
 */
@Entity
@Table(name = "TRAMITE")
@NamedQueries({
    @NamedQuery(name = "Tramite.findAll", query = "SELECT t FROM Tramite t")})
public class Tramite implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TRAMITE")
    private BigDecimal idTramite;
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "ID_CONTACTO")
    private Integer idContacto;
    @Column(name = "FECHA_PREVISTA_RESPUESTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPrevistaRespuesta;
    @JoinColumn(name = "ID_TIPO_TRAMITE", referencedColumnName = "ID_TIPO_TRAMITE")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoTramite idTipoTramite;
    @OneToMany(mappedBy = "idTramite", fetch = FetchType.LAZY)
    private List<TramCerRegRepo> tramCerRegRepoList;

    public Tramite() {
    }

    public Tramite(BigDecimal idTramite) {
        this.idTramite = idTramite;
    }

    public BigDecimal getIdTramite() {
        return idTramite;
    }

    public void setIdTramite(BigDecimal idTramite) {
        this.idTramite = idTramite;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(Integer idContacto) {
        this.idContacto = idContacto;
    }

    public Date getFechaPrevistaRespuesta() {
        return fechaPrevistaRespuesta;
    }

    public void setFechaPrevistaRespuesta(Date fechaPrevistaRespuesta) {
        this.fechaPrevistaRespuesta = fechaPrevistaRespuesta;
    }

    public TipoTramite getIdTipoTramite() {
        return idTipoTramite;
    }

    public void setIdTipoTramite(TipoTramite idTipoTramite) {
        this.idTipoTramite = idTipoTramite;
    }

    public List<TramCerRegRepo> getTramCerRegRepoList() {
        return tramCerRegRepoList;
    }

    public void setTramCerRegRepoList(List<TramCerRegRepo> tramCerRegRepoList) {
        this.tramCerRegRepoList = tramCerRegRepoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTramite != null ? idTramite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tramite)) {
            return false;
        }
        Tramite other = (Tramite) object;
        if ((this.idTramite == null && other.idTramite != null) || (this.idTramite != null && !this.idTramite.equals(other.idTramite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.gob.mined.tramites.model.Tramite[ idTramite=" + idTramite + " ]";
    }
    
}
