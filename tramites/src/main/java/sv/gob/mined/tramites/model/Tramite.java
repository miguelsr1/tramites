/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.tramites.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author DesarrolloPc
 */
@Entity
@Table(name = "TRAMITE")
@NamedQueries({
    @NamedQuery(name = "Tramite.findAll", query = "SELECT t FROM Tramite t")})
public class Tramite implements Serializable {

    @JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID_PERSONA")
    @ManyToOne(fetch = FetchType.LAZY)
    private Persona idPersona;

    @OneToMany(mappedBy = "idTramite", fetch = FetchType.LAZY)
    private List<Solicitud04> solicitud04List;

    @OneToMany(mappedBy = "idTramite", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Solicitud02> solicitud02List;

    @OneToMany(mappedBy = "idTramite", fetch = FetchType.LAZY)
    private List<Solicitud01> solicitud01List;

    @Column(name = "CODIGO_TRAMITE")
    private String codigoTramite;
    @Column(name = "ESTADO_TRAMITE")
    private String estadoTramite;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Column(name = "ID_TRAMITE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TRAMITE")
    @SequenceGenerator(name = "SEQ_TRAMITE", sequenceName = "SEQ_TRAMITE", allocationSize = 1, initialValue = 1)
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

    public Tramite() {
    }

    public String getEstadoTramite() {
        return estadoTramite;
    }

    public void setEstadoTramite(String estadoTramite) {
        this.estadoTramite = estadoTramite;
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

    public String getCodigoTramite() {
        return codigoTramite;
    }

    public void setCodigoTramite(String codigoTramite) {
        this.codigoTramite = codigoTramite;
    }

    public List<Solicitud01> getSolicitud01List() {
        if(solicitud01List == null){
            solicitud01List = new ArrayList();
        }
        return solicitud01List;
    }

    public void setSolicitud01List(List<Solicitud01> solicitud01List) {
        this.solicitud01List = solicitud01List;
    }

    public List<Solicitud02> getSolicitud02List() {
        if(solicitud02List == null){
            solicitud02List = new ArrayList();
        }
        return solicitud02List;
    }

    public void setSolicitud02List(List<Solicitud02> solicitud02List) {
        this.solicitud02List = solicitud02List;
    }

    public List<Solicitud04> getSolicitud04List() {
        return solicitud04List;
    }

    public void setSolicitud04List(List<Solicitud04> solicitud04List) {
        this.solicitud04List = solicitud04List;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

}
