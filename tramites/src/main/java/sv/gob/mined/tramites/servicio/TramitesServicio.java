/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.tramites.servicio;

import java.text.MessageFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.mail.Session;
import sv.gob.mined.tramites.facade.CatalogosFacade;
import sv.gob.mined.tramites.facade.TramitesFacade;
import sv.gob.mined.tramites.facade.acreditacion.AcreditacionFacade;
import sv.gob.mined.tramites.facade.EMailFacade;
import sv.gob.mined.tramites.model.Estudiante;
import sv.gob.mined.tramites.model.Persona;
import sv.gob.mined.tramites.model.Solicitud01;
import sv.gob.mined.tramites.model.Solicitud02;
import sv.gob.mined.tramites.model.Solicitud04;
import sv.gob.mined.tramites.model.Tramite;
import sv.gob.mined.tramites.model.dto.acreditacion.EstudianteDto;

/**
 *
 * @author DesarrolloPc
 */
@Named
@RequestScoped
public class TramitesServicio {

    private static final ResourceBundle UTIL_CORREO = ResourceBundle.getBundle("formato_correo");

    @Inject
    private TramitesFacade tramitesFacade;

    @Inject
    private AcreditacionFacade acreditacionFacade;

    @Inject
    private EMailFacade eMailFacade;

    @Inject
    private CatalogosFacade catalogosFacade;

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

    public void guardarPersona(Persona persona) {
        tramitesFacade.guardarPersona(persona);
    }

    public Persona findPersonaByDui(String dui) {
        return tramitesFacade.findPersonaByDui(dui);
    }

    public void guardarTramite(Tramite tramite) {
        tramitesFacade.guardarTramite(tramite);
    }

    public void guardarSolicitud01(Solicitud01 solicitud01, Session session) {
        tramitesFacade.guadarSolicitud01(solicitud01);

        enviarCorreos(solicitud01.getIdTramite(), session);
    }

    public void guardarSolicitud02(Solicitud02 solicitud02, Session session) {
        tramitesFacade.guadarSolicitud02(solicitud02);

        enviarCorreos(solicitud02.getIdTramite(), session);
    }

    public void guardarSolicitud04(Solicitud04 solicitud04, Session session) {
        tramitesFacade.guadarSolicitud04(solicitud04);

        enviarCorreos(solicitud04.getIdTramite(), session);
    }

    private void enviarCorreos(Tramite tramite, Session session) {
        String correoUsuarioMensaje = MessageFormat.format(UTIL_CORREO.getString("email_usuario_mensaje"),
                tramite.getIdTipoTramite().getDescripcionTraminte(),
                tramite.getCodigoTramite());
        String correoAdminMensaje = MessageFormat.format(UTIL_CORREO.getString("email_admin_mensaje"),
                tramite.getIdTipoTramite().getDescripcionTraminte(),
                tramite.getCodigoTramite());
        //mensaje para usuario final
        eMailFacade.enviarMailDeConfirmacion(UTIL_CORREO.getString("email_usuario_titulo"),
                correoUsuarioMensaje,
                tramite.getIdPersona().getCorreoElectronico(),
                session);

        //mensaje para usuario administrativo MINED
        eMailFacade.enviarMailDeConfirmacion(UTIL_CORREO.getString("email_admin_titulo"),
                correoAdminMensaje,
                tramite.getIdTipoTramite().getCorreoNotificacion(),
                session);
    }
}
