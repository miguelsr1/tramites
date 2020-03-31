/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.tramites.view;

/**
 *
 * @author DesarrolloPc
 */
public class DlgEsperarView {

    private Boolean ocultarPanel = true;
    private Boolean showBotonAceptar = false;

    private String iconDlgEspera = "fa fa-refresh fa-spin fa-4x fa-fw";
    private String msjDlgEspera = "Espere por favor";

    public Boolean getOcultarPanel() {
        return ocultarPanel;
    }

    public void setOcultarPanel(Boolean ocultarPanel) {
        this.ocultarPanel = ocultarPanel;
    }

    public Boolean getShowBotonAceptar() {
        return showBotonAceptar;
    }

    public void setShowBotonAceptar(Boolean showBotonAceptar) {
        this.showBotonAceptar = showBotonAceptar;
    }

    public String getIconDlgEspera() {
        return iconDlgEspera;
    }

    public void setIconDlgEspera(String iconDlgEspera) {
        this.iconDlgEspera = iconDlgEspera;
    }

    public String getMsjDlgEspera() {
        return msjDlgEspera;
    }

    public void setMsjDlgEspera(String msjDlgEspera) {
        this.msjDlgEspera = msjDlgEspera;
    }

    public void actualizarDlgEspera() {
        setShowBotonAceptar(true);
        setIconDlgEspera("fa fa-envelope fa-4x fa-fw");
        setMsjDlgEspera("En su correo recibirá el código generado de esta solicitud");
    }

    public String retornar() {
        return "/app/registro?faces-redirect=true";
    }
}
