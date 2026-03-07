package CTTI;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitarios para la clase TbMonedaResponse.
 */
public class TbMonedaResponseTest {

    private TbMonedaResponse monedaResponse;

    @BeforeEach
    void setUp() {
        monedaResponse = new TbMonedaResponse();
    }

    @Test
    @DisplayName("Debe crear instancia de TbMonedaResponse")
    void test_crearInstancia() {
        // Assert
        assertNotNull(monedaResponse);
        assertNull(monedaResponse.getId_moneda());
        assertNull(monedaResponse.getDescripcion());
        assertNull(monedaResponse.getDescripcion_corta());
        assertNull(monedaResponse.getId_moneda_gecat());
    }

    @Test
    @DisplayName("Debe establecer y obtener id_moneda correctamente")
    void test_setterYGetterId() {
        // Arrange
        Integer expectedId = 456;

        // Act
        monedaResponse.setId_moneda(expectedId);

        // Assert
        assertEquals(expectedId, monedaResponse.getId_moneda());
    }

    @Test
    @DisplayName("Debe establecer y obtener descripcion correctamente")
    void test_setterYGetterDescripcion() {
        // Arrange
        String expectedDescripcion = "Peso Mexicano";

        // Act
        monedaResponse.setDescripcion(expectedDescripcion);

        // Assert
        assertEquals(expectedDescripcion, monedaResponse.getDescripcion());
    }

    @Test
    @DisplayName("Debe establecer y obtener descripcion_corta correctamente")
    void test_setterYGetterDescripcionCorta() {
        // Arrange
        String expectedDescripcionCorta = "MXN";

        // Act
        monedaResponse.setDescripcion_corta(expectedDescripcionCorta);

        // Assert
        assertEquals(expectedDescripcionCorta, monedaResponse.getDescripcion_corta());
    }

    @Test
    @DisplayName("Debe establecer y obtener id_moneda_gecat correctamente")
    void test_setterYGetterIdMonedaGecat() {
        // Arrange
        String expectedIdGecat = "MXN_GECAT_001";

        // Act
        monedaResponse.setId_moneda_gecat(expectedIdGecat);

        // Assert
        assertEquals(expectedIdGecat, monedaResponse.getId_moneda_gecat());
    }

    @Test
    @DisplayName("Debe permitir id_moneda nulo")
    void test_idMonedaNulo() {
        // Act
        monedaResponse.setId_moneda(null);

        // Assert
        assertNull(monedaResponse.getId_moneda());
    }

    @Test
    @DisplayName("Debe permitir descripcion nula")
    void test_descripcionNula() {
        // Act
        monedaResponse.setDescripcion(null);

        // Assert
        assertNull(monedaResponse.getDescripcion());
    }

    @Test
    @DisplayName("Debe permitir descripcion_corta nula")
    void test_descripcionCortaNula() {
        // Act
        monedaResponse.setDescripcion_corta(null);

        // Assert
        assertNull(monedaResponse.getDescripcion_corta());
    }

    @Test
    @DisplayName("Debe permitir id_moneda_gecat nulo")
    void test_idMonedaGecatNulo() {
        // Act
        monedaResponse.setId_moneda_gecat(null);

        // Assert
        assertNull(monedaResponse.getId_moneda_gecat());
    }

    @Test
    @DisplayName("Debe manejar valores vacíos")
    void test_valoresVacios() {
        // Act
        monedaResponse.setDescripcion("");
        monedaResponse.setDescripcion_corta("");
        monedaResponse.setId_moneda_gecat("");

        // Assert
        assertEquals("", monedaResponse.getDescripcion());
        assertEquals("", monedaResponse.getDescripcion_corta());
        assertEquals("", monedaResponse.getId_moneda_gecat());
    }

    @Test
    @DisplayName("Debe manejar ID con valor cero")
    void test_idConValorCero() {
        // Act
        monedaResponse.setId_moneda(0);

        // Assert
        assertEquals(0, monedaResponse.getId_moneda());
    }

    @Test
    @DisplayName("Debe manejar ID con valor negativo")
    void test_idConValorNegativo() {
        // Act
        monedaResponse.setId_moneda(-999);

        // Assert
        assertEquals(-999, monedaResponse.getId_moneda());
    }

    @Test
    @DisplayName("Debe manejar descripciones largas")
    void test_descripcionesLargas() {
        // Arrange
        String descripcionLarga = "Esta es una descripción muy larga para una respuesta de moneda".repeat(5);
        String descripcionCortaLarga = "DESCRIPCION_CORTA_RESPONSE";

        // Act
        monedaResponse.setDescripcion(descripcionLarga);
        monedaResponse.setDescripcion_corta(descripcionCortaLarga);

        // Assert
        assertEquals(descripcionLarga, monedaResponse.getDescripcion());
        assertEquals(descripcionCortaLarga, monedaResponse.getDescripcion_corta());
    }

    @Test
    @DisplayName("Debe manejar caracteres especiales")
    void test_caracteresEspeciales() {
        // Arrange
        String descripcionConEspeciales = "Moneda Response con áéíóú ñ € símbolos @#$%";
        String descripcionCortaEspeciales = "¥EN";
        String idGecatEspeciales = "¥EN_GECAT_特殊";

        // Act
        monedaResponse.setDescripcion(descripcionConEspeciales);
        monedaResponse.setDescripcion_corta(descripcionCortaEspeciales);
        monedaResponse.setId_moneda_gecat(idGecatEspeciales);

        // Assert
        assertEquals(descripcionConEspeciales, monedaResponse.getDescripcion());
        assertEquals(descripcionCortaEspeciales, monedaResponse.getDescripcion_corta());
        assertEquals(idGecatEspeciales, monedaResponse.getId_moneda_gecat());
    }

    @Test
    @DisplayName("Debe establecer todos los campos correctamente")
    void test_establecerTodosLosCampos() {
        // Arrange
        Integer expectedId = 789;
        String expectedDescripcion = "Libra Esterlina";
        String expectedDescripcionCorta = "GBP";
        String expectedIdGecat = "GBP_GECAT_UK";

        // Act
        monedaResponse.setId_moneda(expectedId);
        monedaResponse.setDescripcion(expectedDescripcion);
        monedaResponse.setDescripcion_corta(expectedDescripcionCorta);
        monedaResponse.setId_moneda_gecat(expectedIdGecat);

        // Assert
        assertEquals(expectedId, monedaResponse.getId_moneda());
        assertEquals(expectedDescripcion, monedaResponse.getDescripcion());
        assertEquals(expectedDescripcionCorta, monedaResponse.getDescripcion_corta());
        assertEquals(expectedIdGecat, monedaResponse.getId_moneda_gecat());
    }

    @Test
    @DisplayName("Debe manejar espacios en blanco en las cadenas")
    void test_espaciosEnBlanco() {
        // Arrange
        String descripcionConEspacios = "  Yen Japonés con espacios  ";
        String descripcionCortaConEspacios = "  JPY  ";
        String idGecatConEspacios = "  JPY_GECAT_JP  ";

        // Act
        monedaResponse.setDescripcion(descripcionConEspacios);
        monedaResponse.setDescripcion_corta(descripcionCortaConEspacios);
        monedaResponse.setId_moneda_gecat(idGecatConEspacios);

        // Assert
        assertEquals(descripcionConEspacios, monedaResponse.getDescripcion());
        assertEquals(descripcionCortaConEspacios, monedaResponse.getDescripcion_corta());
        assertEquals(idGecatConEspacios, monedaResponse.getId_moneda_gecat());
    }

    @Test
    @DisplayName("Debe manejar ID con valor máximo de Integer")
    void test_idConValorMaximo() {
        // Act
        monedaResponse.setId_moneda(Integer.MAX_VALUE);

        // Assert
        assertEquals(Integer.MAX_VALUE, monedaResponse.getId_moneda());
    }

    @Test
    @DisplayName("Debe manejar ID con valor mínimo de Integer")
    void test_idConValorMinimo() {
        // Act
        monedaResponse.setId_moneda(Integer.MIN_VALUE);

        // Assert
        assertEquals(Integer.MIN_VALUE, monedaResponse.getId_moneda());
    }

    @Test
    @DisplayName("Debe funcionar correctamente con anotación @Data de Lombok")
    void test_funcionamientoConLombok() {
        // Arrange
        Integer id = 100;
        String descripcion = "Franco Suizo";
        String descripcionCorta = "CHF";
        String idGecat = "CHF_GECAT";

        // Act
        monedaResponse.setId_moneda(id);
        monedaResponse.setDescripcion(descripcion);
        monedaResponse.setDescripcion_corta(descripcionCorta);
        monedaResponse.setId_moneda_gecat(idGecat);

        // Assert - Verificar que los getters funcionan correctamente
        assertEquals(id, monedaResponse.getId_moneda());
        assertEquals(descripcion, monedaResponse.getDescripcion());
        assertEquals(descripcionCorta, monedaResponse.getDescripcion_corta());
        assertEquals(idGecat, monedaResponse.getId_moneda_gecat());
    }

    @Test
    @DisplayName("Debe crear múltiples instancias independientes")
    void test_instanciasIndependientes() {
        // Arrange
        TbMonedaResponse response1 = new TbMonedaResponse();
        TbMonedaResponse response2 = new TbMonedaResponse();

        // Act
        response1.setId_moneda(1);
        response1.setDescripcion("Moneda 1");
        
        response2.setId_moneda(2);
        response2.setDescripcion("Moneda 2");

        // Assert
        assertNotSame(response1, response2);
        assertNotEquals(response1.getId_moneda(), response2.getId_moneda());
        assertNotEquals(response1.getDescripcion(), response2.getDescripcion());
    }
}