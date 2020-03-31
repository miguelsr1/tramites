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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author DesarrolloPc
 */
@Entity
@Table(name = "SOLICITUD04")
@NamedQueries({
    @NamedQuery(name = "Solicitud04.findAll", query = "SELECT s FROM Solicitud04 s")})
public class Solicitud04 implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Column(name = "ID_SOLICITUD04")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SOLICITUD04")
    @SequenceGenerator(name = "SEQ_SOLICITUD04", sequenceName = "SEQ_SOLICITUD04", allocationSize = 1, initialValue = 1)
    private BigDecimal idSolicitud04;
    @Column(name = "MOTIVO")
    private String motivo;
    @JoinColumn(name = "ID_TRAMITE", referencedColumnName = "ID_TRAMITE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Tramite idTramite;

    public Solicitud04() {
    }

    public Solicitud04(BigDecimal idSolicitud04) {
        this.idSolicitud04 = idSolicitud04;
    }

    public BigDecimal getIdSolicitud04() {
        return idSolicitud04;
    }

    public void setIdSolicitud04(BigDecimal idSolicitud04) {
        this.idSolicitud04 = idSolicitud04;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
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
        hash += (idSolicitud04 != null ? idSolicitud04.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitud04)) {
            return false;
        }
        Solicitud04 other = (Solicitud04) object;
        if ((this.idSolicitud04 == null && other.idSolicitud04 != null) || (this.idSolicitud04 != null && !this.idSolicitud04.equals(other.idSolicitud04))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.gob.mined.tramites.model.Solicitud04[ idSolicitud04=" + idSolicitud04 + " ]";
    }
    
}
