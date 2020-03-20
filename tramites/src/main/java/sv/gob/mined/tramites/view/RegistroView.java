/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.tramites.view;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import sv.gob.mined.tramites.model.Persona;
import sv.gob.mined.tramites.model.TipoTramite;
import sv.gob.mined.tramites.servicio.CatalogosServicio;

/**
 *
 * @author misanchez
 */
@ManagedBean
@ViewScoped
public class RegistroView {

    private String tipoPersona;
    private Persona persona;

    @ManagedProperty("#{catalogosServicio}")
    private CatalogosServicio catalogosServicio;

    @PostConstruct
    public void init() {
        persona = new Persona();
        tipoPersona = "";
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public CatalogosServicio getCatalogosServicio() {
        return catalogosServicio;
    }

    public void setCatalogosServicio(CatalogosServicio catalogosServicio) {
        this.catalogosServicio = catalogosServicio;
    }

    public List<TipoTramite> getLstTipoTramite() {
        return catalogosServicio.getLstTipoTramite();
    }
}
