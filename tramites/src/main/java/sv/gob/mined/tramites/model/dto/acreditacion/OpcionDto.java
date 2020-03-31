/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.tramites.model.dto.acreditacion;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;


/**
 *
 * @author DesarrolloPc
 */
@Entity

@SqlResultSetMapping(name = "defaultOpcion",
        entities = @EntityResult(entityClass = OpcionDto.class))
public class OpcionDto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private BigDecimal idRow;
    private String codigoModBach;
    private String codigoEspecBach;
    private String codigoOpcionBach;
    private String opcionBach;

    public BigDecimal getIdRow() {
        return idRow;
    }

    public void setIdRow(BigDecimal idRow) {
        this.idRow = idRow;
    }

    public String getCodigoModBach() {
        return codigoModBach;
    }

    public void setCodigoModBach(String codigoModBach) {
        this.codigoModBach = codigoModBach;
    }

    public String getCodigoEspecBach() {
        return codigoEspecBach;
    }

    public void setCodigoEspecBach(String codigoEspecBach) {
        this.codigoEspecBach = codigoEspecBach;
    }

    public String getCodigoOpcionBach() {
        return codigoOpcionBach;
    }

    public void setCodigoOpcionBach(String codigoOpcionBach) {
        this.codigoOpcionBach = codigoOpcionBach;
    }

    public String getOpcionBach() {
        return opcionBach;
    }

    public void setOpcionBach(String opcionBach) {
        this.opcionBach = opcionBach;
    }

    public String getCodigoOpcion() {
        return codigoEspecBach + "" + codigoModBach + "" + codigoOpcionBach;
    }
}
