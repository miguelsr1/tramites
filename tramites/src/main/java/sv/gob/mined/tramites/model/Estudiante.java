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
@Table(name = "ESTUDIANTE")
@NamedQueries({
    @NamedQuery(name = "Estudiante.findAll", query = "SELECT e FROM Estudiante e")})
public class Estudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Column(name = "ID_ESTUDIANTE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqEstudiante")
    @SequenceGenerator(name = "seqEstudiante", sequenceName = "SEQ_ESTUDIANTE", allocationSize = 1, initialValue = 1)
    private BigDecimal idEstudiante;
    @Column(name = "NIE")
    private Long nie;
    @JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID_PERSONA")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Persona idPersona;

    public Estudiante() {
    }

    public Estudiante(BigDecimal idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public BigDecimal getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(BigDecimal idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Long getNie() {
        return nie;
    }

    public void setNie(Long nie) {
        this.nie = nie;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstudiante != null ? idEstudiante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiante)) {
            return false;
        }
        Estudiante other = (Estudiante) object;
        if ((this.idEstudiante == null && other.idEstudiante != null) || (this.idEstudiante != null && !this.idEstudiante.equals(other.idEstudiante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.gob.mined.tramites.model.Estudiante[ idEstudiante=" + idEstudiante + " ]";
    }
    
}
