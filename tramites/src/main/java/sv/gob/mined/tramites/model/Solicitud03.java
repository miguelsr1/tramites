/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.tramites.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author DesarrolloPc
 */
@Entity
@Table(name = "SOLICITUD03")
@NamedQueries({
    @NamedQuery(name = "Solicitud03.findAll", query = "SELECT s FROM Solicitud03 s")})
public class Solicitud03 implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SOLICITUD03")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SOLICITUD03")
    @SequenceGenerator(name = "SEQ_SOLICITUD03", sequenceName = "SEQ_SOLICITUD03", allocationSize = 1, initialValue = 1)
    private BigDecimal idSolicitud03;
    @Column(name = "ID_TIPO_DOCUMENTO")
    private Short idTipoDocumento;
    @Size(max = 5)
    @Column(name = "CODIGO_ENTIDAD")
    private String codigoEntidad;
    @Column(name = "FECHA_DOCUMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDocumento;
    @Size(max = 250)
    @Column(name = "OPCION_BACH")
    private String opcionBach;
    @Column(name = "CANTIDAD_DOC")
    private Integer cantidadDoc;
    @JoinColumn(name = "ID_TRAMITE", referencedColumnName = "ID_TRAMITE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Tramite idTramite;
    
    @Transient
    private String codigoEntidadMunDepa;

    public Solicitud03() {
    }

    public Solicitud03(BigDecimal idSolicitud03) {
        this.idSolicitud03 = idSolicitud03;
    }

    public BigDecimal getIdSolicitud03() {
        return idSolicitud03;
    }

    public void setIdSolicitud03(BigDecimal idSolicitud03) {
        this.idSolicitud03 = idSolicitud03;
    }

    public Short getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(Short idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getCodigoEntidad() {
        return codigoEntidad;
    }

    public void setCodigoEntidad(String codigoEntidad) {
        this.codigoEntidad = codigoEntidad;
    }

    public Date getFechaDocumento() {
        return fechaDocumento;
    }

    public void setFechaDocumento(Date fechaDocumento) {
        this.fechaDocumento = fechaDocumento;
    }

    public String getOpcionBach() {
        return opcionBach;
    }

    public void setOpcionBach(String opcionBach) {
        this.opcionBach = opcionBach;
    }

    public Integer getCantidadDoc() {
        return cantidadDoc;
    }

    public void setCantidadDoc(Integer cantidadDoc) {
        this.cantidadDoc = cantidadDoc;
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
        hash += (idSolicitud03 != null ? idSolicitud03.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitud03)) {
            return false;
        }
        Solicitud03 other = (Solicitud03) object;
        return !((this.idSolicitud03 == null && other.idSolicitud03 != null) || (this.idSolicitud03 != null && !this.idSolicitud03.equals(other.idSolicitud03)));
    }

    public String getCodigoEntidadMunDepa() {
        return codigoEntidadMunDepa;
    }

    public void setCodigoEntidadMunDepa(String codigoEntidadMunDepa) {
        this.codigoEntidadMunDepa = codigoEntidadMunDepa;
    }

    @Override
    public String toString() {
        return "sv.gob.mined.tramites.model.Solicitud03[ idSolicitud03=" + idSolicitud03 + " ]";
    }
    
}
