/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.tramites.servicio;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import sv.gob.mined.tramites.facade.CatalogosFacade;
import sv.gob.mined.tramites.facade.paquete.EntidadEducativaFacade;
import sv.gob.mined.tramites.model.TipoTramite;
import sv.gob.mined.tramites.model.dto.paquete.EntidadEducativaDto;

/**
 *
 * @author misanchez
 */
@ManagedBean(name = "catalogosServicio")
@ApplicationScoped
public class CatalogosServicio implements Serializable {

    private List<EntidadEducativaDto> lstEntidadesEducativa;
    private List<TipoTramite> lstTipoTramite;

    @EJB
    public CatalogosFacade catalogosFacade;
    @EJB
    public EntidadEducativaFacade entidadEducativaFacade;

    @PostConstruct
    public void init() {
        lstEntidadesEducativa = entidadEducativaFacade.getLstEntidadEducativaDtos();
        lstTipoTramite = catalogosFacade.getLstTipoTramites();
    }

    public List<TipoTramite> getLstTipoTramite() {
        return lstTipoTramite;
    }

    public List<EntidadEducativaDto> getLstEntidadEducativa() {
        return lstEntidadesEducativa;
    }
}
