/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.tramites.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.gob.mined.tramites.model.Estudiante;
import sv.gob.mined.tramites.model.Persona;

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
}
