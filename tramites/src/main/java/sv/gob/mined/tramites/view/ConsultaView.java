/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.tramites.view;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import sv.gob.mined.tramites.facade.TramitesFacade;
import sv.gob.mined.tramites.model.Tramite;
import sv.gob.mined.tramites.view.util.JsfUtil;

/**
 *
 * @author DesarrolloPc
 */
@ManagedBean
@ViewScoped
public class ConsultaView implements Serializable {

    private Boolean showEstado = false;
    private String codigo;
    private Tramite tramite;

    @Inject
    private TramitesFacade tramitesFacade;

    public Boolean getShowEstado() {
        return showEstado;
    }

    public void setShowEstado(Boolean showEstado) {
        this.showEstado = showEstado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Tramite getTramite() {
        if (tramite == null) {
            tramite = new Tramite();
        }
        return tramite;
    }

    public void buscar() {
        tramite = tramitesFacade.findByCodigo(codigo);

        showEstado = tramite != null;

        if (!showEstado) {
            JsfUtil.mensajeInformacion("No se ha encontrado ninguna solicitud con ese código");
        }
    }
}
