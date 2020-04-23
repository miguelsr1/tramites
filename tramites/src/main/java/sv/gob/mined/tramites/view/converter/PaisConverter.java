/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.tramites.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import sv.gob.mined.tramites.model.Pais;
import sv.gob.mined.tramites.view.acreditacion.Solicitud02View;

/**
 *
 * @author DesarrolloPc
 */
@FacesConverter(value = "paisConverter", forClass = Pais.class)
public class PaisConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0) {
            return new Pais();
        }

        Solicitud02View controller = (Solicitud02View) facesContext.getApplication().getELResolver().
                getValue(facesContext.getELContext(), null, "solicitud02View");

        return controller.find(value);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof Pais) {
            Pais o = (Pais) object;
            return o.getNombrePais();
        } else {
            throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Pais.class.getName());
        }
    }
}
