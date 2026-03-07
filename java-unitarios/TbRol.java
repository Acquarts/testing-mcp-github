package CTTI;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * TbRol entity
 * 
 * @author Accenture
 */
@Entity
@Table(name = "ROL", schema = "sefac_adm")
@NamedQueries({
    @NamedQuery(name = "TbRol.findRolByDescripcion", query = "FROM TbRol t WHERE t.descripcion LIKE :descripcion")
})
public class TbRol extends BaseDescriptiveEntity<Integer> {
    
    private static final long serialVersionUID = 1L;
    
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nom_SEQ")
    @SequenceGenerator(name = "nom_SEQ", sequenceName = "sefac_adm.rol_sequence", allocationSize = 1)
    @Override
    public Integer getId() {
        return super.getId();
    }
}
