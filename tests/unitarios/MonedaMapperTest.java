package CTTI;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitarios para la clase MonedaMapper.
 */
public class MonedaMapperTest {

    private TbMoneda moneda;

    @BeforeEach
    void setUp() {
        moneda = new TbMoneda();
        moneda.setId_moneda(1);
        moneda.setDescripcion("Euro");
        moneda.setDescripcion_corta("EUR");
        moneda.setId_moneda_gecat("E001");
    }

    @Test
    @DisplayName("Mapear entidad TbMoneda a DTO TbMonedaResponse correctamente")
    void test_toDto() {
        // Act
        TbMonedaResponse response = MonedaMapper.toDto(moneda);
        // Assert
        assertNotNull(response);
        assertEquals(moneda.getId_moneda(), response.getId_moneda());
        assertEquals(moneda.getDescripcion(), response.getDescripcion());
        assertEquals(moneda.getDescripcion_corta(), response.getDescripcion_corta());
        assertEquals(moneda.getId_moneda_gecat(), response.getId_moneda_gecat());
    }
}
