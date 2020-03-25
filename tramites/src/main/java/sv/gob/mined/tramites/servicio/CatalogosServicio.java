/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.tramites.servicio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import sv.gob.mined.tramites.facade.CatalogosFacade;
import sv.gob.mined.tramites.facade.TramitesFacade;
import sv.gob.mined.tramites.facade.acreditacion.AcreditacionFacade;
import sv.gob.mined.tramites.facade.paquete.EntidadEducativaFacade;
import sv.gob.mined.tramites.model.Ciudad;
import sv.gob.mined.tramites.model.Estudiante;
import sv.gob.mined.tramites.model.Pais;
import sv.gob.mined.tramites.model.Persona;
import sv.gob.mined.tramites.model.TipoTramite;
import sv.gob.mined.tramites.model.dto.acreditacion.EstudianteDto;
import sv.gob.mined.tramites.model.dto.acreditacion.GradoDto;
import sv.gob.mined.tramites.model.dto.acreditacion.OpcionDto;
import sv.gob.mined.tramites.model.dto.paquete.EntidadEducativaDto;

/**
 *
 * @author misanchez
 */
@Named
@ApplicationScoped
public class CatalogosServicio implements Serializable {

    private List<EntidadEducativaDto> lstEntidadesEducativa;
    private List<TipoTramite> lstTipoTramite;
    private List<Pais> lstPais;
    private List<Ciudad> lstCiudad;

    @Inject
    private CatalogosFacade catalogosFacade;
    @Inject
    private EntidadEducativaFacade entidadEducativaFacade;
    @Inject
    private AcreditacionFacade acreditacionFacade;
    @Inject
    private TramitesFacade tramitesFacade;

    @PostConstruct
    public void init() {
    }

    public CatalogosFacade getCatalogosFacade() {
        return catalogosFacade;
    }

    public void setCatalogosFacade(CatalogosFacade catalogosFacade) {
        this.catalogosFacade = catalogosFacade;
    }

    public EntidadEducativaFacade getEntidadEducativaFacade() {
        return entidadEducativaFacade;
    }

    public void setEntidadEducativaFacade(EntidadEducativaFacade entidadEducativaFacade) {
        this.entidadEducativaFacade = entidadEducativaFacade;
    }

    public List<TipoTramite> getLstTipoTramite() {
        if (lstTipoTramite == null) {
            lstTipoTramite = catalogosFacade.getLstTipoTramites();
        }
        return lstTipoTramite;
    }

    public List<EntidadEducativaDto> getLstEntidadEducativa() {
        if (lstEntidadesEducativa == null) {
            lstEntidadesEducativa = entidadEducativaFacade.getLstEntidadEducativaDtos();
        }
        return lstEntidadesEducativa;
    }

    public List<GradoDto> getLstGradosByCodEntAndAnho(String codigoEntidad, Integer anho) {
        return acreditacionFacade.getGradosByCodEntAndAnho(codigoEntidad, anho);
    }

    public List<OpcionDto> getLstOpcion(String codigoEntidad, Integer anho, String grado) {
        return acreditacionFacade.getOpcion(codigoEntidad, anho, grado);
    }

    public Estudiante findEstudiante(String nie, String dui) {

        Estudiante estudiante;
        Persona persona = new Persona();

        estudiante = tramitesFacade.findEstudianteByNie(nie);
        if (estudiante != null) {
            return estudiante;
        } else {
            EstudianteDto estudianteDto = acreditacionFacade.getEstudianteByNieOrDui(nie, dui);
            if (estudianteDto != null) {
                estudiante.setNie(Long.parseLong(nie));

                persona.setApellidos(estudianteDto.getApellidos());
                persona.setCorreoElectronico(estudianteDto.getCorreoElectronico());
                persona.setDui(estudianteDto.getDui());
                persona.setGenero(estudianteDto.getGenero());
                persona.setNombres(estudianteDto.getNombres());
                persona.setTelefono(estudianteDto.getTelefono());
                persona.getEstudianteList().add(estudiante);
                persona.setFechaInsercion(new Date());
                persona.setMigracion("S");
                estudiante.setIdPersona(persona);

                tramitesFacade.guardarPersona(persona);

                return estudiante;
            } else {
                return null;
            }
        }
    }

    public List<Pais> getLstPais() {
        if (lstPais == null) {
            lstPais = catalogosFacade.getLstPais();
        }
        return lstPais;
    }

    public List<Ciudad> getLstCiudad() {
        if (lstCiudad == null) {
            lstCiudad = catalogosFacade.getLstCiudad();
        }
        return lstCiudad;
    }
    
    public List<Ciudad> getLstCiudad(String nombre, String codPais) {
        return catalogosFacade.getLstCiudad(nombre, codPais);
        
    }

}
