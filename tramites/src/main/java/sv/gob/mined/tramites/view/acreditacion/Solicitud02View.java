/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.tramites.view.acreditacion;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import sv.gob.mined.tramites.model.Ciudad;
import sv.gob.mined.tramites.model.Pais;
import sv.gob.mined.tramites.servicio.CatalogosServicio;

/**
 *
 * @author misanchez
 */
@ManagedBean
@ViewScoped
public class Solicitud02View implements Serializable {

    private String codigoPais;
    private Integer idCiudad;

    @Inject
    private CatalogosServicio catalogosServicio;

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

    public List<Ciudad> completeCity(String valor){
        return catalogosServicio.getLstCiudad(valor, codigoPais);
    }
    
    public List<Ciudad> completeCiudad(String valor) {
        List<Ciudad> lstCiudad = catalogosServicio.getLstCiudad();

        return lstCiudad.stream()
                .filter(e -> e.getNombreCiudad().toUpperCase().contains(valor.toUpperCase()))
                .collect(Collectors.toList());
    }
}
