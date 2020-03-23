/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.tramites.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author misanchez
 */
@Entity
@Table(name = "INFORMACION_TRAMITE")
@NamedQueries({
    @NamedQuery(name = "InformacionTramite.findAll", query = "SELECT i FROM InformacionTramite i")})
public class InformacionTramite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_INFO")
    private Integer idInfo;
    @Size(max = 10)
    @Column(name = "CODIGO_FORMULARIO")
    private String codigoFormulario;
    @Size(max = 1000)
    @Column(name = "INFORMACION")
    private String informacion;

    public InformacionTramite() {
    }

    public InformacionTramite(Integer idInfo) {
        this.idInfo = idInfo;
    }

    public Integer getIdInfo() {
        return idInfo;
    }

    public void setIdInfo(Integer idInfo) {
        this.idInfo = idInfo;
    }

    public String getCodigoFormulario() {
        return codigoFormulario;
    }

    public void setCodigoFormulario(String codigoFormulario) {
        this.codigoFormulario = codigoFormulario;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInfo != null ? idInfo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InformacionTramite)) {
            return false;
        }
        InformacionTramite other = (InformacionTramite) object;
        if ((this.idInfo == null && other.idInfo != null) || (this.idInfo != null && !this.idInfo.equals(other.idInfo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.gob.mined.tramites.model.InformacionTramite[ idInfo=" + idInfo + " ]";
    }
    
}
