/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.tramites.facade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.gob.mined.tramites.model.TipoTramite;

/**
 *
 * @author misanchez
 */
@Stateless
public class CatalogosFacade {

    @PersistenceContext(unitName = "tramitePU")
    private EntityManager em;

    public List<TipoTramite> getLstTipoTramites() {
        Query q = em.createQuery("SELECT t FROM TipoTramite t", TipoTramite.class);
        return q.getResultList();
    }
}
