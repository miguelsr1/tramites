/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.tramites.facade.paquete;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.gob.mined.tramites.model.dto.paquete.EntidadEducativaDto;

/**
 *
 * @author misanchez
 */
@Stateless
public class EntidadEducativaFacade {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "paquetePU")
    private EntityManager em;

    public List<EntidadEducativaDto> getLstEntidadEducativaDtos() {
        Query q = em.createNamedQuery("Paquete.EntidadEducativa", EntidadEducativaDto.class);

        return q.getResultList();
    }
}
