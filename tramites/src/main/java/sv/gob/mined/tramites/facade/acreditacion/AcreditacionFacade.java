/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.tramites.facade.acreditacion;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.gob.mined.tramites.model.dto.acreditacion.GradoDto;

/**
 *
 * @author DesarrolloPc
 */
@Stateless
public class AcreditacionFacade {

    @PersistenceContext(unitName = "acreditacionPU")
    private EntityManager em;
    
    public List<GradoDto> getGradosByCodEntAndAnho(String codigoEntidad, Integer anho ){
        Query q = em.createNamedQuery("Acreditacion.GradosByCodEntAndAnho", GradoDto.class);
        q.setParameter(1, codigoEntidad);
        q.setParameter(2, anho);
        
        return q.getResultList();
    }
}
