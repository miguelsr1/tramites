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
import sv.gob.mined.tramites.model.Ciudad;
import sv.gob.mined.tramites.model.Pais;
import sv.gob.mined.tramites.model.Tramite;
import sv.gob.mined.tramites.servicio.CatalogosServicio;
import sv.gob.mined.tramites.servicio.TramitesServicio;
import sv.gob.mined.tramites.view.DlgEsperarView;

/**
 *
 * @author misanchez
 */
@ManagedBean
@ViewScoped
public class Solicitud02View extends DlgEsperarView implements Serializable {

    private String codigoPais;
    private Integer idCiudad;

    private String[] tramites;

    private Pais pais;
    private Tramite tramite;
    private Solicitud02 solicitud02;

    @Inject
    private CatalogosServicio catalogosServicio;
    @Inject
    private TramitesServicio tramitesServicio;

    @PostConstruct
    public void init() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        if (params.containsKey("idTramite")) {
            tramite = catalogosServicio.getTramiteByPk(new BigDecimal(params.get("idTramite")));
            solicitud02 = new Solicitud02();
            solicitud02.setIdTramite(tramite);
            tramite.getSolicitud02List().add(solicitud02);
        }
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public String[] getTramites() {
        return tramites;
    }

    public void setTramites(String[] tramites) {
        this.tramites = tramites;
    }

    public Solicitud02 getSolicitud02() {
        return solicitud02;
    }

    public void setSolicitud02(Solicitud02 solicitud02) {
        this.solicitud02 = solicitud02;
    }

    public Integer getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public List<Pais> completePais(String valor) {
        List<Pais> lstPais = catalogosServicio.getLstPais();

        return lstPais.stream()
                .filter(e -> e.getNombrePais().toUpperCase().contains(valor.toUpperCase()))
                .collect(Collectors.toList());
    }

    public List<Ciudad> completeCity(String valor) {
        return catalogosServicio.getLstCiudad(valor, pais.getCodigoPais());
    }

    public List<Ciudad> completeCiudad(String valor) {
        List<Ciudad> lstCiudad = catalogosServicio.getLstCiudad();

        return lstCiudad.stream()
                .filter(e -> e.getNombreCiudad().toUpperCase().contains(valor.toUpperCase()))
                .collect(Collectors.toList());
    }

    public void guardar() {
        solicitud02.setIdCiudad(idCiudad);

        for (String strTramite : tramites) {
            switch (strTramite) {
                case "0":
                    solicitud02.setTitulo("1");
                    break;
                case "1":
                    solicitud02.setDiploma("1");
                    break;
                case "2":
                    solicitud02.setCertificado("1");
                    break;
            }
        }

        tramitesServicio.guardarSolicitud02(solicitud02, catalogosServicio.getMailSession());
    }

}
