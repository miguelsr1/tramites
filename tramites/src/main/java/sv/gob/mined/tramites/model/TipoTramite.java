/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.tramites.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author DesarrolloPc
 */
@Entity
@Table(name = "TIPO_TRAMITE")
@NamedQueries({
    @NamedQuery(name = "TipoTramite.findAll", query = "SELECT t FROM TipoTramite t")})
public class TipoTramite implements Serializable {

    @Column(name = "CORREO_NOTIFICACION")
    private String correoNotificacion;

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID_TIPO_TRAMITE")
    private Integer idTipoTramite;
    @Column(name = "DESCRIPCION_TRAMINTE")
    private String descripcionTraminte;
    @Column(name = "CODIGO_TRAMITE")
    private String codigoTramite;
    @Column(name = "ORDEN")
    private Short orden;
    @OneToMany(mappedBy = "idTipoTramite", fetch = FetchType.LAZY)
    private List<Tramite> tramiteList;

    public TipoTramite() {
    }

    public String getCodigoTramite() {
        return codigoTramite;
    }

    public void setCodigoTramite(String codigoTramite) {
        this.codigoTramite = codigoTramite;
    }

    public TipoTramite(Integer idTipoTramite) {
        this.idTipoTramite = idTipoTramite;
    }

    public Integer getIdTipoTramite() {
        return idTipoTramite;
    }

    public void setIdTipoTramite(Integer idTipoTramite) {
        this.idTipoTramite = idTipoTramite;
    }

    public String getDescripcionTraminte() {
        return descripcionTraminte;
    }

    public void setDescripcionTraminte(String descripcionTraminte) {
        this.descripcionTraminte = descripcionTraminte;
    }

    public Short getOrden() {
        return orden;
    }

    public void setOrden(Short orden) {
        this.orden = orden;
    }

    public List<Tramite> getTramiteList() {
        return tramiteList;
    }

    public void setTramiteList(List<Tramite> tramiteList) {
        this.tramiteList = tramiteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoTramite != null ? idTipoTramite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoTramite)) {
            return false;
        }
        TipoTramite other = (TipoTramite) object;
        if ((this.idTipoTramite == null && other.idTipoTramite != null) || (this.idTipoTramite != null && !this.idTipoTramite.equals(other.idTipoTramite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.gob.mined.tramites.model.TipoTramite[ idTipoTramite=" + idTipoTramite + " ]";
    }

    public String getCorreoNotificacion() {
        return correoNotificacion;
    }

    public void setCorreoNotificacion(String correoNotificacion) {
        this.correoNotificacion = correoNotificacion;
    }
    
}
