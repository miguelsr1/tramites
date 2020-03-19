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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author misanchez
 */
@Entity
@Table(name = "PERSONA")
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERSONA")
    private BigDecimal idPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "NOMBRES")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Size(max = 10)
    @Column(name = "DUI")
    private String dui;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GENERO")
    private Character genero;
    @Size(max = 250)
    @Column(name = "CORREO_ELECTRONICO")
    private String correoElectronico;
    @Size(max = 9)
    @Column(name = "TELEFONO")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_INSERCION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInsercion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona", fetch = FetchType.LAZY)
    private List<Estudiante> estudianteList;

    public Persona() {
    }

    public Persona(BigDecimal idPersona) {
        this.idPersona = idPersona;
    }

    public Persona(BigDecimal idPersona, String nombres, String apellidos, Character genero, Date fechaInsercion) {
        this.idPersona = idPersona;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.genero = genero;
        this.fechaInsercion = fechaInsercion;
    }

    public BigDecimal getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(BigDecimal idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public Character getGenero() {
        return genero;
    }

    public void setGenero(Character genero) {
        this.genero = genero;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaInsercion() {
        return fechaInsercion;
    }

    public void setFechaInsercion(Date fechaInsercion) {
        this.fechaInsercion = fechaInsercion;
    }

    public List<Estudiante> getEstudianteList() {
        return estudianteList;
    }

    public void setEstudianteList(List<Estudiante> estudianteList) {
        this.estudianteList = estudianteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.gob.mined.tramites.model.Persona[ idPersona=" + idPersona + " ]";
    }
    
}
