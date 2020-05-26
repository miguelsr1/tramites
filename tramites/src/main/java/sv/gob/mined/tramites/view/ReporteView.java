/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.tramites.view;

import java.io.Serializable;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import sv.gob.mined.tramites.facade.TramitesFacade;
import sv.gob.mined.tramites.model.Solicitud01;
import sv.gob.mined.tramites.model.Solicitud04;
import sv.gob.mined.tramites.model.Tramite;
import sv.gob.mined.tramites.model.dto.Solicitud02Dto;
import sv.gob.mined.tramites.model.dto.paquete.EntidadEducativaDto;
import sv.gob.mined.tramites.servicio.CatalogosServicio;

/**
 *
 * @author MISanchez
 */
@ManagedBean
@ViewScoped
public class ReporteView implements Serializable {

    private String nie;
    private Tramite tramite;

    private Solicitud02Dto solicitud02Dto;
    private Solicitud04 solicitud04;

    @Inject
    private TramitesFacade tramitesFacade;
    @Inject
    private CatalogosServicio catalogosServicio;

    @PostConstruct
    public void init() {

        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        if (params.containsKey("codigo")) {
            tramite = tramitesFacade.findByCodigo(params.get("codigo"));
            if (tramite.getIdPersona().getEstudianteList() != null && !tramite.getIdPersona().getEstudianteList().isEmpty()) {
                nie = tramite.getIdPersona().getEstudianteList().get(0).getNie().toString();
            }

            tramite.setEstadoTramite("E");

            tramitesFacade.guardarTramite(tramite);

            switch (tramite.getIdTipoTramite().getIdTipoTramite()) {
                case 1:
                    break;
                case 2:
                    solicitud02Dto = catalogosServicio.getSolicitud02DtoByPk(tramite.getIdTramite());
                    break;
                case 3:
                    break;
                case 4:
                    solicitud04 = tramite.getSolicitud04List().get(0);
                    break;
            }
        }
    }

    public Solicitud04 getSolicitud04() {
        return solicitud04;
    }

    public Tramite getTramite() {
        if (tramite == null) {
            tramite = new Tramite();
        }
        return tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

    public String getNie() {
        return nie;
    }

    public void setNie(String nie) {
        this.nie = nie;
    }

    public Solicitud01 getSolicitud01() {
        return tramite.getSolicitud01List().get(0);
    }

    public EntidadEducativaDto getCodigoEntidad() {
        return catalogosServicio.getEntidadEducativaByCodigo(tramite.getSolicitud01List().get(0).getCodigoEntidad());
    }

    public EntidadEducativaDto getCodigoEntidadSolicitud03() {
        return catalogosServicio.getEntidadEducativaByCodigo(tramite.getSolicitud03List().get(0).getCodigoEntidad());
    }

    public String codEntSol03(String codigo) {
        if (codigo != null && !codigo.trim().isEmpty()) {
            return catalogosServicio.getEntidadEducativaByCodigo(codigo).getCodigoEntMuniDepa();
        } else {
            return "";
        }
    }

    public Solicitud02Dto getSolicitud02Dto() {
        return solicitud02Dto;
    }
}
