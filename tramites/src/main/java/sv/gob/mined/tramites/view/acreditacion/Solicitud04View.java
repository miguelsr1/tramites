/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.tramites.view.acreditacion;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import sv.gob.mined.tramites.model.Tramite;
import sv.gob.mined.tramites.model.Solicitud04;
import sv.gob.mined.tramites.servicio.CatalogosServicio;
import sv.gob.mined.tramites.servicio.TramitesServicio;

/**
 *
 * @author DesarrolloPc
 */
@ManagedBean
@ViewScoped
public class Solicitud04View implements Serializable {

    private Tramite tramite;
    private Solicitud04 solicitud04;

    @Inject
    private CatalogosServicio catalogosServicio;
    @Inject
    private TramitesServicio tramitesServicio;

    @PostConstruct
    public void init() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        if (params.containsKey("idTramite")) {
            tramite = catalogosServicio.getTramiteByPk(new BigDecimal(params.get("idTramite")));
            solicitud04 = new Solicitud04();
            solicitud04.setIdTramite(tramite);
            tramite.getSolicitud04List().add(solicitud04);
        }
    }

    public Solicitud04 getSolicitud04() {
        return solicitud04;
    }

    public void setSolicitud04(Solicitud04 solicitud04) {
        this.solicitud04 = solicitud04;
    }

    public void guardar() {
        tramitesServicio.guardarSolicitud04(solicitud04, catalogosServicio.getMailSession());
    }
}
