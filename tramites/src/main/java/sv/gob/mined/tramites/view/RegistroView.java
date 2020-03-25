/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.tramites.view;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import sv.gob.mined.tramites.facade.TramitesFacade;
import sv.gob.mined.tramites.model.Estudiante;
import sv.gob.mined.tramites.model.Persona;
import sv.gob.mined.tramites.model.TipoTramite;
import sv.gob.mined.tramites.servicio.CatalogosServicio;

/**
 *
 * @author misanchez
 */
@ManagedBean
@ViewScoped
public class RegistroView implements Serializable {

    private String dui;
    private String nie;
    private String tipoPersona;
    private Persona persona;
    private Estudiante estudiante;

    private Boolean showTipoPersona = true;
    private Boolean showDatosGenerales = false;
    private Boolean showTipoTramite = false;

    @Inject
    private CatalogosServicio catalogosServicio;
    @Inject
    private TramitesFacade tramitesFacade;

    @PostConstruct
    public void init() {
        persona = new Persona();
        tipoPersona = "";
    }

    public Boolean getShowTipoPersona() {
        return showTipoPersona;
    }

    public void setShowTipoPersona(Boolean showTipoPersona) {
        this.showTipoPersona = showTipoPersona;
    }

    public Boolean getShowTipoTramite() {
        return showTipoTramite;
    }

    public void setShowTipoTramite(Boolean showTipoTramite) {
        this.showTipoTramite = showTipoTramite;
    }

    public String getNie() {
        return nie;
    }

    public void setNie(String nie) {
        this.nie = nie;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public Boolean getShowDatosGenerales() {
        return showDatosGenerales;
    }

    public void setShowDatosGenerales(Boolean showDatosGenerales) {
        this.showDatosGenerales = showDatosGenerales;
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

    public List<TipoTramite> getLstTipoTramite() {
        return catalogosServicio.getLstTipoTramite();
    }

    public void siguiente() {
        tramitesFacade.guardarPersona(persona);

        showDatosGenerales = false;
        showTipoTramite = true;
    }

    public void findEstudiante() {
        estudiante = catalogosServicio.findEstudiante(nie, dui);
        if (estudiante != null) {
            persona = estudiante.getIdPersona();
            dui = persona.getDui();
            nie = estudiante.getNie().toString();
        }
    }

    public void findPersona() {
        estudiante = catalogosServicio.findEstudiante(nie, dui);

        if (estudiante == null) {
            persona = tramitesFacade.findPersonaByDui(dui);
            if (persona == null) {
                persona = new Persona();
                persona.setDui(dui);
            }
        }
    }

    public void ocultarTipoPersona() {
        showTipoPersona = false;
        showDatosGenerales = true;
    }
}
