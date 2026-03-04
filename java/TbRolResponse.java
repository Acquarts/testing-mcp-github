package CTTI;

import lombok.Data;

@Data
public class TbRolResponse {
    private Integer id;
    private String descripcion;
    
    
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
