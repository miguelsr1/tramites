/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.tramites.facade;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.commons.codec.digest.DigestUtils;
import sv.gob.mined.tramites.model.Estudiante;
import sv.gob.mined.tramites.model.Persona;
import sv.gob.mined.tramites.model.Tramite;
import sv.gob.mined.tramites.model.Solicitud01;
import sv.gob.mined.tramites.model.Solicitud02;
import sv.gob.mined.tramites.model.Solicitud04;

/**
 *
 * @author misanchez
 */
@Stateless
public class TramitesFacade {

    @PersistenceContext(unitName = "tramitePU")
    private EntityManager em;

    public void guardarPersona(Persona persona) {
        if (persona.getIdPersona() == null) {
            em.persist(persona);
        }
    }
    
    public Tramite getTramite(BigDecimal idTramite){
        return em.find(Tramite.class, idTramite);
    }
    
    public void guardarTramite(Tramite tramite){
        if(tramite.getIdTramite() == null){
            tramite.setFechaCreacion(new Date());

            em.persist(tramite);
            
            String codTramite = codigoGeneradoTramite(tramite.getFechaCreacion(), tramite.getIdTramite(), tramite.getIdTipoTramite().getCodigoTramite());
            
            tramite.setCodigoTramite(codTramite);
            
            em.merge(tramite);
        }
    }

    /**
     * Este codigo generado se realizará en combinación de la fecha en la que se
     * registra el trámite, el id generado de la tabla tramite y el código de la solicitud a realizar
     *
     * @return
     */
    private String codigoGeneradoTramite(Date fecha, BigDecimal idTramite, String codigoTramite) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HHmmssSSS");
        String tmp = sdf.format(fecha) + "-" + idTramite.toString() + "-" + codigoTramite;

        return DigestUtils.md5Hex(tmp);

    }

    public Persona findPersonaByDui(String dui) {
        Query q = em.createQuery("SELECT p FROM Persona p WHERE p.dui = :dui", Persona.class);
        q.setParameter("dui", dui);
        if (q.getResultList().isEmpty()) {
            return null;
        } else {
            return (Persona) q.getResultList().get(0);
        }
    }

    public Estudiante findEstudianteByNie(String nie) {
        Query q = em.createQuery("SELECT e FROM Estudiante e WHERE e.nie = :nie", Estudiante.class);
        q.setParameter("nie", Long.parseLong(nie));
        if (q.getResultList().isEmpty()) {
            return null;
        } else {
            return (Estudiante) q.getResultList().get(0);
        }
    }
    
    
    public void guadarSolicitud01(Solicitud01 solicitud01){
        em.merge(solicitud01);
    }
    
    public void guadarSolicitud02(Solicitud02 solicitud02){
        em.merge(solicitud02);
    }
    
    public void guadarSolicitud04(Solicitud04 solicitud04){
        em.merge(solicitud04);
    }
}
