/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.tramites.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import sv.gob.mined.tramites.model.dto.paquete.EntidadEducativaDto;
import sv.gob.mined.tramites.view.acreditacion.Solicitud01View;

/**
 *
 * @author DesarrolloPc
 */
@FacesConverter(value = "entidadEducativaConverter", forClass = EntidadEducativaDto.class)
public class EntidadEducativaConverter implements Converter {


    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0) {
            return new EntidadEducativaDto();
        }

        Solicitud01View controller = (Solicitud01View) facesContext.getApplication().getELResolver().
                getValue(facesContext.getELContext(), null, "solicitud01View");

        return controller.find(value);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof EntidadEducativaDto) {
            EntidadEducativaDto o = (EntidadEducativaDto) object;
            return o.getCodigoEntidad();
        } else {
            throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + EntidadEducativaDto.class.getName());
        }
    }
}
