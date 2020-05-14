/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.tramites.view;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import sv.gob.mined.tramites.model.Estudiante;
import sv.gob.mined.tramites.model.Persona;
import sv.gob.mined.tramites.model.TipoTramite;
import sv.gob.mined.tramites.model.Tramite;
import sv.gob.mined.tramites.servicio.CatalogosServicio;
import sv.gob.mined.tramites.servicio.TramitesServicio;

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
    private Integer idTipoTramite = 0;
    private Persona persona;
    private Estudiante estudiante;
    private Tramite tramite;

    private Boolean showTipoPersona = true;
    private Boolean showDatosGenerales = false;
    private Boolean showTipoTramite = false;

    @Inject
    private CatalogosServicio catalogosServicio;
    @Inject
    private TramitesServicio tramitesServicio;

    @PostConstruct
    public void init() {
        persona = new Persona();
        tramite = new Tramite();
        tipoPersona = "";
    }

    public Tramite getTramite() {
        return tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

    public Integer getIdTipoTramite() {
        return idTipoTramite;
    }

    public void setIdTipoTramite(Integer idTipoTramite) {
        if (idTipoTramite != null) {
            this.idTipoTramite = idTipoTramite;
        }
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
        if(persona.getFechaInsercion()==null){
            persona.setFechaInsercion(new Date());
        }
        tramitesServicio.guardarPersona(persona);

        showDatosGenerales = false;
        showTipoTramite = true;
        //System.out.println("Siguiente");
    }

    public void findEstudiante() {
        estudiante = tramitesServicio.findEstudiante(nie, dui);
        if (estudiante != null) {
            persona = estudiante.getIdPersona();
            dui = persona.getDui();
            nie = estudiante.getNie().toString();
        }
    }

    public void findPersona() {
        estudiante = tramitesServicio.findEstudiante(nie, dui);

        if (estudiante == null) {
            persona = tramitesServicio.findPersonaByDui(dui);
            if (persona == null) {
                persona = new Persona();
                persona.setFechaInsercion(new Date());
                persona.setDui(dui);
            }
        }
    }

    public void ocultarTipoPersona() {
        showTipoPersona = false;
        showDatosGenerales = true;
    }
    
    public void guardarTramite(){
        tramite.setIdPersona(persona);
        tramite.setIdTipoTramite(new TipoTramite(idTipoTramite));
        tramite.setEstadoTramite("D");
        tramitesServicio.guardarTramite(tramite);
    }

    public String redireccionar() {
        String url;

        switch (idTipoTramite) {
            case 1:
                url = "app/tramites/area/acreditacion/solicitud01";
                break;
            case 2:
                url = "app/tramites/area/acreditacion/solicitud02";
                break;
            case 3:
                url = "app/tramites/area/acreditacion/solicitud03";
                break;
            case 4:
                url = "app/tramites/area/acreditacion/solicitud04";
                break;
            default:
                url = "";
                break;
        }
        return url;
    }
}
