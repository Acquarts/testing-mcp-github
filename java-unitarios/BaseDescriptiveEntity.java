package CTTI;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Base class for entities with id and descripcion fields
 * 
 * @author Accenture
 */
@MappedSuperclass
public abstract class BaseDescriptiveEntity<T> implements java.io.Serializable {
    
    private static final long serialVersionUID = 1L;
    
    protected T id;
    protected String descripcion;

    @Id
    @Column(name = "id", unique = true, nullable = false)
    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    @Column(name = "descripcion", nullable = true)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}