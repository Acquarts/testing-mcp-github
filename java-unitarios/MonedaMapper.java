package CTTI;



public class MonedaMapper {

    public static TbMonedaResponse toDto(TbMoneda monedas) {
        TbMonedaResponse dto = new TbMonedaResponse();
         dto.setId_moneda(monedas.getId_moneda());
         dto.setDescripcion(monedas.getDescripcion());
         dto.setDescripcion_corta(monedas.getDescripcion_corta());
         dto.setId_moneda_gecat(monedas.getId_moneda_gecat());
         return dto;
     }
    }


 