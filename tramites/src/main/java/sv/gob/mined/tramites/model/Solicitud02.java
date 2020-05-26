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
 * @author misanchez
 */
@Entity
@Table(name = "SOLICITUD02")
@NamedQueries({
    @NamedQuery(name = "Solicitud02.findAll", query = "SELECT s FROM Solicitud02 s")})
public class Solicitud02 implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Column(name = "ID_SOLICITUD01")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SOLICITUD02")
    @SequenceGenerator(name = "SEQ_SOLICITUD02", sequenceName = "SEQ_SOLICITUD02", allocationSize = 1, initialValue = 1)
    private BigDecimal idSolicitud02;
    @Column(name = "ID_CIUDAD")
    private Integer idCiudad;
    @Column(name = "GRADO_OBTENIDO")
    private String gradoObtenido;
    @Column(name = "TITULO")
    private String titulo;
    @Column(name = "DIPLOMA")
    private String diploma;
    @Column(name = "CERTIFICADO")
    private String certificado;
    @Column(name = "EXTENDIDO_POR")
    private String extendidoPor;
    @JoinColumn(name = "ID_TRAMITE", referencedColumnName = "ID_TRAMITE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Tramite idTramite;

    public Solicitud02() {
    }

    public Solicitud02(BigDecimal idSolicitud02) {
        this.idSolicitud02 = idSolicitud02;
    }

    public BigDecimal getIdSolicitud01() {
        return idSolicitud02;
    }

    public void setIdSolicitud01(BigDecimal idSolicitud01) {
        this.idSolicitud02 = idSolicitud01;
    }

    public Integer getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
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

    public Tramite getIdTramite() {
        return idTramite;
    }

    public void setIdTramite(Tramite idTramite) {
        this.idTramite = idTramite;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSolicitud02 != null ? idSolicitud02.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitud02)) {
            return false;
        }
        Solicitud02 other = (Solicitud02) object;
        if ((this.idSolicitud02 == null && other.idSolicitud02 != null) || (this.idSolicitud02 != null && !this.idSolicitud02.equals(other.idSolicitud02))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.gob.mined.tramites.model.Solicitud02[ idSolicitud01=" + idSolicitud02 + " ]";
    }
    
}
