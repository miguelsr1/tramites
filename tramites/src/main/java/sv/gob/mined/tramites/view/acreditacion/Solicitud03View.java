/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.tramites.view.acreditacion;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import sv.gob.mined.tramites.model.Solicitud02;
import sv.gob.mined.tramites.model.Solicitud03;
import sv.gob.mined.tramites.model.Tramite;
import sv.gob.mined.tramites.model.dto.paquete.EntidadEducativaDto;
import sv.gob.mined.tramites.servicio.CatalogosServicio;
import sv.gob.mined.tramites.servicio.TramitesServicio;
import sv.gob.mined.tramites.view.DlgEsperarView;

/**
 *
 * @author DesarrolloPc
 */
@ManagedBean
@ViewScoped
public class Solicitud03View extends DlgEsperarView implements Serializable {

    private String idTipoDocumento;
    private Tramite tramite;
    private Solicitud03 solicitud03;
    private EntidadEducativaDto entidadEducativaDto;

    @Inject
    private CatalogosServicio catalogosServicio;
    @Inject
    private TramitesServicio tramitesServicio;

    @PostConstruct
    public void init() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        if (params.containsKey("idTramite")) {
            tramite = catalogosServicio.getTramiteByPk(new BigDecimal(params.get("idTramite")));
            //solicitud03 = new Solicitud03();
            //solicitud03.setIdTramite(tramite);
            //tramite.getSolicitud03List().add(solicitud03);
        }
    }

    public String getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(String idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public Tramite getTramite() {
        return tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

    public Solicitud03 getSolicitud03() {
        if (solicitud03 == null) {
            solicitud03 = new Solicitud03();
        }
        return solicitud03;
    }

    public void setSolicitud03(Solicitud03 solicitud03) {
        this.solicitud03 = solicitud03;
    }

    public CatalogosServicio getCatalogosServicio() {
        return catalogosServicio;
    }

    public void setCatalogosServicio(CatalogosServicio catalogosServicio) {
        this.catalogosServicio = catalogosServicio;
    }

    public EntidadEducativaDto getEntidadEducativaDto() {
        return entidadEducativaDto;
    }

    public void setEntidadEducativaDto(EntidadEducativaDto entidadEducativaDto) {
        this.entidadEducativaDto = entidadEducativaDto;
    }

    public List<EntidadEducativaDto> completeEntidadEducativa(String valor) {
        List<EntidadEducativaDto> lstEntidadEducativaDtos = catalogosServicio.getLstEntidadEducativa();

        return lstEntidadEducativaDtos.stream()
                .filter(e -> e.getCodigoEntidad().contains(valor) || e.getNombre().contains(valor))
                .collect(Collectors.toList());
    }

    public EntidadEducativaDto find(String value) {

        List<EntidadEducativaDto> lst = catalogosServicio.getLstEntidadEducativa();

        return lst.stream().filter(e -> e.getCodigoEntidad().equals(value.split(" - ")[0])).collect(Collectors.toList()).get(0);
    }

    public void guardar() {
        setOcultarPanel(false);

        tramitesServicio.guardarSolicitud03(solicitud03, catalogosServicio.getMailSession());
    }

    public void agregar() {
        solicitud03.setIdTipoDocumento(new Short(idTipoDocumento));
        solicitud03.setCodigoEntidad(entidadEducativaDto.getCodigoEntidad());
        solicitud03.setCodigoEntidadMunDepa(entidadEducativaDto.getCodigoEntMuniDepa());
        solicitud03.setIdTramite(tramite);

        tramite.getSolicitud03List().add(solicitud03);

        tramitesServicio.guardarSolicitud03(solicitud03, catalogosServicio.getMailSession());
        actualizarDlgEspera();

        setShowPanelDatos(true);
    }
}
