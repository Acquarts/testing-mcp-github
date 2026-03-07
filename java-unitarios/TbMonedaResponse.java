package CTTI;

import lombok.Data;

@Data
public class TbMonedaResponse {

    private Integer id_moneda;
    private String id_moneda_gecat;
    private String descripcion;
    private String descripcion_corta;
    
    //Metodos creados nuevos. No pertenecen a CTTI
	public Integer getId_moneda() {
		return id_moneda;
	}
	public void setId_moneda(Integer id_moneda) {
		this.id_moneda = id_moneda;
	}
	public String getId_moneda_gecat() {
		return id_moneda_gecat;
	}
	public void setId_moneda_gecat(String id_moneda_gecat) {
		this.id_moneda_gecat = id_moneda_gecat;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDescripcion_corta() {
		return descripcion_corta;
	}
	public void setDescripcion_corta(String descripcion_corta) {
		this.descripcion_corta = descripcion_corta;
	}
}
