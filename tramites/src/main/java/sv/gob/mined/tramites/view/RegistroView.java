/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.tramites.view;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import sv.gob.mined.tramites.facade.CatalogosFacade;
import sv.gob.mined.tramites.model.Persona;
import sv.gob.mined.tramites.model.TipoTramite;
import sv.gob.mined.tramites.model.dto.acreditacion.GradoDto;
import sv.gob.mined.tramites.model.dto.paquete.EntidadEducativaDto;
import sv.gob.mined.tramites.servicio.CatalogosServicio;

/**
 *
 * @author misanchez
 */
@ManagedBean
@ViewScoped
public class RegistroView {

    private Integer anho;
    private String tipoPersona;
    private Persona persona;
    private EntidadEducativaDto entidadEducativaDto;

    @ManagedProperty("#{catalogosServicio}")
    private CatalogosServicio catalogosServicio;

    @PostConstruct
    public void init() {
        persona = new Persona();
        entidadEducativaDto = new EntidadEducativaDto();
        tipoPersona = "";
    }

    public Integer getAnho() {
        return anho;
    }

    public void setAnho(Integer anho) {
        this.anho = anho;
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

    public EntidadEducativaDto getEntidadEducativaDto() {
        return entidadEducativaDto;
    }

    public void setEntidadEducativaDto(EntidadEducativaDto entidadEducativaDto) {
        this.entidadEducativaDto = entidadEducativaDto;
    }

    public List<TipoTramite> getLstTipoTramite() {
        return catalogosServicio.getLstTipoTramite();
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

    public List<GradoDto> getLstGrados() {
        if (entidadEducativaDto.getCodigoEntidad() != null && anho != null) {
            return catalogosServicio.getLstGradosByCodEntAndAnho(entidadEducativaDto.getCodigoEntidad(), anho);
        } else {
            return new ArrayList();
        }
    }
}
