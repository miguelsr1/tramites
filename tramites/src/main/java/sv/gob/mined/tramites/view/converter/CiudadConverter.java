/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.tramites.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import sv.gob.mined.tramites.model.Ciudad;
import sv.gob.mined.tramites.view.acreditacion.Solicitud02View;

/**
 *
 * @author DesarrolloPc
 */
@FacesConverter(value = "ciudadConverter", forClass = Ciudad.class)
public class CiudadConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0) {
            return new Ciudad();
        }

        Solicitud02View controller = (Solicitud02View) facesContext.getApplication().getELResolver().
                getValue(facesContext.getELContext(), null, "solicitud02View");

        return controller.findCiudad(value);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof Ciudad) {
            Ciudad o = (Ciudad) object;
            return o.getNombreCiudad();
        } else {
            throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Ciudad.class.getName());
        }
    }
}
