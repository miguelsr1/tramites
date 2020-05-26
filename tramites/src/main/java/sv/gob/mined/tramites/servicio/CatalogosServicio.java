/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.tramites.servicio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.mail.Session;
import sv.gob.mined.tramites.facade.CatalogosFacade;
import sv.gob.mined.tramites.facade.TramitesFacade;
import sv.gob.mined.tramites.facade.acreditacion.AcreditacionFacade;
import sv.gob.mined.tramites.facade.paquete.EntidadEducativaFacade;
import sv.gob.mined.tramites.model.Ciudad;
import sv.gob.mined.tramites.model.Pais;
import sv.gob.mined.tramites.model.TipoTramite;
import sv.gob.mined.tramites.model.Tramite;
import sv.gob.mined.tramites.model.dto.Solicitud02Dto;
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

    @Resource(mappedName = "java:/MailTramites")
    private Session mailSession;

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

    public Tramite getTramiteByPk(BigDecimal idTramite) {
        return tramitesFacade.getTramite(idTramite);
    }

    public Session getMailSession() {
        /*Properties configEmail = new Properties();

        configEmail.put("mail.smtp.auth", "true");
        configEmail.put("mail.smtp.starttls.enable", "true");

        configEmail.put("mail.smtp.host", "svr2k13mail01.mined.gob.sv");
        configEmail.put("mail.smtp.port", "2525");

        configEmail.put("mail.user", "solicitudes.enlinea@mined.gob.sv");
        configEmail.put("mail.user.pass", "solonline2020$.");
        configEmail.put("mail.from", "solicitudes.enlinea@mined.gob.sv");

        mailSession = Session.getInstance(configEmail, new Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("solicitudes.enlinea@mined.gob.sv", "solonline2020$.");
            }
        });*/

        return mailSession;
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

    public EntidadEducativaDto getEntidadEducativaByCodigo(String codigoEntidad) {
        return entidadEducativaFacade.getEntidadEducativaDtoByCodigo(codigoEntidad);
    }

    public List<GradoDto> getLstGradosByCodEntAndAnho(String codigoEntidad, Integer anho) {
        return acreditacionFacade.getGradosByCodEntAndAnho(codigoEntidad, anho);
    }

    public List<OpcionDto> getLstOpcion(String codigoEntidad, Integer anho, String grado) {
        return acreditacionFacade.getOpcion(codigoEntidad, anho, grado);
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

    public Solicitud02Dto getSolicitud02DtoByPk(BigDecimal pk){
        return tramitesFacade.getSolicitud02ByPk(pk);
    }
}
