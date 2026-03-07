package CTTI;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitarios para la clase MonedaMapper.
 */
public class MonedaMapperTest {

    private TbMoneda monedaEntity;

    @BeforeEach
    void setUp() {
        monedaEntity = new TbMoneda();
        monedaEntity.setId_moneda(1);
        monedaEntity.setDescripcion("Euro");
        monedaEntity.setDescripcion_corta("EUR");
        monedaEntity.setId_moneda_gecat("EUR_GECAT");
    }

    @Test
    @DisplayName("Debe mapear correctamente TbMoneda a TbMonedaResponse")
    void test_mapearMonedaCorrecta() {
        // Act
        TbMonedaResponse result = MonedaMapper.toDto(monedaEntity);

        // Assert
        assertNotNull(result);
        assertEquals(monedaEntity.getId_moneda(), result.getId_moneda());
        assertEquals(monedaEntity.getDescripcion(), result.getDescripcion());
        assertEquals(monedaEntity.getDescripcion_corta(), result.getDescripcion_corta());
        assertEquals(monedaEntity.getId_moneda_gecat(), result.getId_moneda_gecat());
    }

    @Test
    @DisplayName("Debe mapear correctamente cuando los campos son nulos")
    void test_mapearMonedaConCamposNulos() {
        // Arrange
        TbMoneda monedaNula = new TbMoneda();
        monedaNula.setId_moneda(null);
        monedaNula.setDescripcion(null);
        monedaNula.setDescripcion_corta(null);
        monedaNula.setId_moneda_gecat(null);

        // Act
        TbMonedaResponse result = MonedaMapper.toDto(monedaNula);

        // Assert
        assertNotNull(result);
        assertNull(result.getId_moneda());
        assertNull(result.getDescripcion());
        assertNull(result.getDescripcion_corta());
        assertNull(result.getId_moneda_gecat());
    }

    @Test
    @DisplayName("Debe mapear correctamente con valores vacíos")
    void test_mapearMonedaConValoresVacios() {
        // Arrange
        TbMoneda monedaVacia = new TbMoneda();
        monedaVacia.setId_moneda(0);
        monedaVacia.setDescripcion("");
        monedaVacia.setDescripcion_corta("");
        monedaVacia.setId_moneda_gecat("");

        // Act
        TbMonedaResponse result = MonedaMapper.toDto(monedaVacia);

        // Assert
        assertNotNull(result);
        assertEquals(0, result.getId_moneda());
        assertEquals("", result.getDescripcion());
        assertEquals("", result.getDescripcion_corta());
        assertEquals("", result.getId_moneda_gecat());
    }

    @Test
    @DisplayName("Debe mapear correctamente con ID negativo")
    void test_mapearMonedaConIdNegativo() {
        // Arrange
        monedaEntity.setId_moneda(-1);

        // Act
        TbMonedaResponse result = MonedaMapper.toDto(monedaEntity);

        // Assert
        assertNotNull(result);
        assertEquals(-1, result.getId_moneda());
    }

    @Test
    @DisplayName("Debe mapear correctamente con descripciones largas")
    void test_mapearMonedaConDescripcionesLargas() {
        // Arrange
        String descripcionLarga = "Esta es una descripción muy larga para probar el mapeo".repeat(10);
        String descripcionCortaLarga = "DESCRIPCION_CORTA_MUY_LARGA";
        
        monedaEntity.setDescripcion(descripcionLarga);
        monedaEntity.setDescripcion_corta(descripcionCortaLarga);

        // Act
        TbMonedaResponse result = MonedaMapper.toDto(monedaEntity);

        // Assert
        assertNotNull(result);
        assertEquals(descripcionLarga, result.getDescripcion());
        assertEquals(descripcionCortaLarga, result.getDescripcion_corta());
    }

    @Test
    @DisplayName("Debe crear nueva instancia de TbMonedaResponse")
    void test_crearNuevaInstanciaResponse() {
        // Act
        TbMonedaResponse result1 = MonedaMapper.toDto(monedaEntity);
        TbMonedaResponse result2 = MonedaMapper.toDto(monedaEntity);

        // Assert
        assertNotNull(result1);
        assertNotNull(result2);
        assertNotSame(result1, result2); // Diferentes instancias
        assertEquals(result1.getId_moneda(), result2.getId_moneda()); // Mismo contenido
    }

    @Test
    @DisplayName("Debe mapear correctamente con caracteres especiales")
    void test_mapearMonedaConCaracteresEspeciales() {
        // Arrange
        monedaEntity.setDescripcion("Moneda con áéíóú ñ €");
        monedaEntity.setDescripcion_corta("€UR");
        monedaEntity.setId_moneda_gecat("€UR_GECAT");

        // Act
        TbMonedaResponse result = MonedaMapper.toDto(monedaEntity);

        // Assert
        assertNotNull(result);
        assertEquals("Moneda con áéíóú ñ €", result.getDescripcion());
        assertEquals("€UR", result.getDescripcion_corta());
        assertEquals("€UR_GECAT", result.getId_moneda_gecat());
    }
}