/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.tramites.view.acreditacion;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import sv.gob.mined.tramites.model.Solicitud01;
import sv.gob.mined.tramites.model.Tramite;
import sv.gob.mined.tramites.model.dto.acreditacion.GradoDto;
import sv.gob.mined.tramites.model.dto.acreditacion.OpcionDto;
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
public class Solicitud01View extends DlgEsperarView implements Serializable {

    private Integer anho;

    private String opcion;
    private String modalidad;
    private String periodo;
    private String jornada;
    private String grado;
    private String[] tramites;

    private EntidadEducativaDto entidadEducativaDto;
    private List<GradoDto> lstGrado;
    private List<OpcionDto> lstOpcion;

    private Solicitud01 solicitud01;
    private Tramite tramite;

    @Inject
    private CatalogosServicio catalogosServicio;
    @Inject
    private TramitesServicio tramitesServicio;

    @PostConstruct
    public void init() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        solicitud01 = new Solicitud01();
        modalidad = "0";
        periodo = "0";
        jornada = "0";

        if (params.containsKey("idTramite")) {
            tramite = catalogosServicio.getTramiteByPk(new BigDecimal(params.get("idTramite")));
            solicitud01 = new Solicitud01();
            solicitud01.setIdTramite(tramite);
            tramite.getSolicitud01List().add(solicitud01);
        }
    }

    public List<GradoDto> getLstGrado() {
        return lstGrado;
    }

    public void setLstGrado(List<GradoDto> lstGrado) {
        this.lstGrado = lstGrado;
    }

    public List<OpcionDto> getLstOpcion() {
        return lstOpcion;
    }

    public void setLstOpcion(List<OpcionDto> lstOpcion) {
        this.lstOpcion = lstOpcion;
    }

    public Solicitud01 getSolicitud01() {
        return solicitud01;
    }

    public void setSolicitud01(Solicitud01 solicitud01) {
        this.solicitud01 = solicitud01;
    }

    public Integer getAnho() {
        return anho;
    }

    public void setAnho(Integer anho) {
        this.anho = anho;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public String[] getTramites() {
        return tramites;
    }

    public void setTramites(String[] tramites) {
        this.tramites = tramites;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public EntidadEducativaDto getEntidadEducativaDto() {
        return entidadEducativaDto;
    }

    public void setEntidadEducativaDto(EntidadEducativaDto entidadEducativaDto) {
        this.entidadEducativaDto = entidadEducativaDto;
    }

    public CatalogosServicio getCatalogosServicio() {
        return catalogosServicio;
    }

    public void setCatalogosServicio(CatalogosServicio catalogosServicio) {
        this.catalogosServicio = catalogosServicio;
    }

    public List<EntidadEducativaDto> completeEntidadEducativa(String valor) {
        List<EntidadEducativaDto> lstEntidadEducativaDtos = catalogosServicio.getLstEntidadEducativa();

        return lstEntidadEducativaDtos.stream()
                .filter(e -> e.getCodigoEntidad().contains(valor) || e.getNombre().toUpperCase().contains(valor.toUpperCase()))
                .sorted(Comparator.comparing(EntidadEducativaDto::getNombre))
                .collect(Collectors.toList());
    }

    public EntidadEducativaDto find(String value) {

        List<EntidadEducativaDto> lst = catalogosServicio.getLstEntidadEducativa();

        return lst.stream().filter(e -> e.getCodigoEntidad().equals(value.split(" - ")[0])).collect(Collectors.toList()).get(0);
    }

    public void findLstGrados() {
        if (entidadEducativaDto != null && entidadEducativaDto.getCodigoEntidad() != null && anho != null) {
            lstGrado = catalogosServicio.getLstGradosByCodEntAndAnho(entidadEducativaDto.getCodigoEntidad(), anho);
        }
    }

    public void findLstOpcion() {
        if (entidadEducativaDto != null && entidadEducativaDto.getCodigoEntidad() != null && anho != null && grado != null) {
            lstOpcion = catalogosServicio.getLstOpcion(entidadEducativaDto.getCodigoEntidad(), anho, grado);
        }
    }

    public void guardar() {
        setOcultarPanel(false);

        solicitud01.setAnho(anho.shortValue());
        for (String strTramite : tramites) {
            switch (strTramite) {
                case "0":
                    solicitud01.setCertificacionNota("1");
                    break;
                case "1":
                    solicitud01.setRegistroTitulo("1");
                    break;
                case "2":
                    solicitud01.setReposicionTitulo("1");
                    break;
            }
        }

        solicitud01.setCodigoEntidad(entidadEducativaDto.getCodigoEntidad());
        solicitud01.setGrado(grado);
        solicitud01.setJornadaEstudio(jornada);
        solicitud01.setOpcionBach(opcion);
        solicitud01.setPeriodoGraduacion(periodo);
        solicitud01.setModalidadAtencion(modalidad);

        tramitesServicio.guardarSolicitud01(solicitud01, catalogosServicio.getMailSession());
        actualizarDlgEspera();
        
        setShowPanelDatos(true);
    }

}
