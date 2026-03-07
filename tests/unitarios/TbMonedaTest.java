package CTTI;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitarios para la clase TbMoneda.
 */
public class TbMonedaTest {

    private TbMoneda moneda;

    @BeforeEach
    void setUp() {
        moneda = new TbMoneda();
    }

    @Test
    @DisplayName("Debe crear instancia de TbMoneda")
    void test_crearInstancia() {
        // Assert
        assertNotNull(moneda);
        assertNull(moneda.getId_moneda());
        assertNull(moneda.getDescripcion());
        assertNull(moneda.getDescripcion_corta());
        assertNull(moneda.getId_moneda_gecat());
    }

    @Test
    @DisplayName("Debe establecer y obtener id_moneda correctamente")
    void test_setterYGetterId() {
        // Arrange
        Integer expectedId = 123;

        // Act
        moneda.setId_moneda(expectedId);

        // Assert
        assertEquals(expectedId, moneda.getId_moneda());
    }

    @Test
    @DisplayName("Debe establecer y obtener descripcion correctamente")
    void test_setterYGetterDescripcion() {
        // Arrange
        String expectedDescripcion = "Euro";

        // Act
        moneda.setDescripcion(expectedDescripcion);

        // Assert
        assertEquals(expectedDescripcion, moneda.getDescripcion());
    }

    @Test
    @DisplayName("Debe establecer y obtener descripcion_corta correctamente")
    void test_setterYGetterDescripcionCorta() {
        // Arrange
        String expectedDescripcionCorta = "EUR";

        // Act
        moneda.setDescripcion_corta(expectedDescripcionCorta);

        // Assert
        assertEquals(expectedDescripcionCorta, moneda.getDescripcion_corta());
    }

    @Test
    @DisplayName("Debe establecer y obtener id_moneda_gecat correctamente")
    void test_setterYGetterIdMonedaGecat() {
        // Arrange
        String expectedIdGecat = "EUR_GECAT";

        // Act
        moneda.setId_moneda_gecat(expectedIdGecat);

        // Assert
        assertEquals(expectedIdGecat, moneda.getId_moneda_gecat());
    }

    @Test
    @DisplayName("Debe permitir id_moneda nulo")
    void test_idMonedaNulo() {
        // Act
        moneda.setId_moneda(null);

        // Assert
        assertNull(moneda.getId_moneda());
    }

    @Test
    @DisplayName("Debe permitir descripcion nula")
    void test_descripcionNula() {
        // Act
        moneda.setDescripcion(null);

        // Assert
        assertNull(moneda.getDescripcion());
    }

    @Test
    @DisplayName("Debe permitir descripcion_corta nula")
    void test_descripcionCortaNula() {
        // Act
        moneda.setDescripcion_corta(null);

        // Assert
        assertNull(moneda.getDescripcion_corta());
    }

    @Test
    @DisplayName("Debe permitir id_moneda_gecat nulo")
    void test_idMonedaGecatNulo() {
        // Act
        moneda.setId_moneda_gecat(null);

        // Assert
        assertNull(moneda.getId_moneda_gecat());
    }

    @Test
    @DisplayName("Debe manejar valores vacíos")
    void test_valoresVacios() {
        // Act
        moneda.setDescripcion("");
        moneda.setDescripcion_corta("");
        moneda.setId_moneda_gecat("");

        // Assert
        assertEquals("", moneda.getDescripcion());
        assertEquals("", moneda.getDescripcion_corta());
        assertEquals("", moneda.getId_moneda_gecat());
    }

    @Test
    @DisplayName("Debe manejar ID con valor cero")
    void test_idConValorCero() {
        // Act
        moneda.setId_moneda(0);

        // Assert
        assertEquals(0, moneda.getId_moneda());
    }

    @Test
    @DisplayName("Debe manejar ID con valor negativo")
    void test_idConValorNegativo() {
        // Act
        moneda.setId_moneda(-1);

        // Assert
        assertEquals(-1, moneda.getId_moneda());
    }

    @Test
    @DisplayName("Debe manejar descripciones largas")
    void test_descripcionesLargas() {
        // Arrange
        String descripcionLarga = "Esta es una descripción muy larga para una moneda".repeat(10);
        String descripcionCortaLarga = "DESCRIPCION_CORTA_LARGA";

        // Act
        moneda.setDescripcion(descripcionLarga);
        moneda.setDescripcion_corta(descripcionCortaLarga);

        // Assert
        assertEquals(descripcionLarga, moneda.getDescripcion());
        assertEquals(descripcionCortaLarga, moneda.getDescripcion_corta());
    }

    @Test
    @DisplayName("Debe manejar caracteres especiales")
    void test_caracteresEspeciales() {
        // Arrange
        String descripcionConEspeciales = "Moneda con áéíóú ñ € símbolos @#$%";
        String descripcionCortaEspeciales = "€UR";
        String idGecatEspeciales = "€UR_GECAT_123";

        // Act
        moneda.setDescripcion(descripcionConEspeciales);
        moneda.setDescripcion_corta(descripcionCortaEspeciales);
        moneda.setId_moneda_gecat(idGecatEspeciales);

        // Assert
        assertEquals(descripcionConEspeciales, moneda.getDescripcion());
        assertEquals(descripcionCortaEspeciales, moneda.getDescripcion_corta());
        assertEquals(idGecatEspeciales, moneda.getId_moneda_gecat());
    }

    @Test
    @DisplayName("Debe ser serializable")
    void test_esSerializable() {
        // Assert
        assertTrue(moneda instanceof java.io.Serializable);
    }

    @Test
    @DisplayName("Debe establecer todos los campos correctamente")
    void test_establecerTodosLosCampos() {
        // Arrange
        Integer expectedId = 1;
        String expectedDescripcion = "Dólar Estadounidense";
        String expectedDescripcionCorta = "USD";
        String expectedIdGecat = "USD_GECAT_001";

        // Act
        moneda.setId_moneda(expectedId);
        moneda.setDescripcion(expectedDescripcion);
        moneda.setDescripcion_corta(expectedDescripcionCorta);
        moneda.setId_moneda_gecat(expectedIdGecat);

        // Assert
        assertEquals(expectedId, moneda.getId_moneda());
        assertEquals(expectedDescripcion, moneda.getDescripcion());
        assertEquals(expectedDescripcionCorta, moneda.getDescripcion_corta());
        assertEquals(expectedIdGecat, moneda.getId_moneda_gecat());
    }

    @Test
    @DisplayName("Debe manejar espacios en blanco en las cadenas")
    void test_espaciosEnBlanco() {
        // Arrange
        String descripcionConEspacios = "  Euro con espacios  ";
        String descripcionCortaConEspacios = "  EUR  ";
        String idGecatConEspacios = "  EUR_GECAT  ";

        // Act
        moneda.setDescripcion(descripcionConEspacios);
        moneda.setDescripcion_corta(descripcionCortaConEspacios);
        moneda.setId_moneda_gecat(idGecatConEspacios);

        // Assert
        assertEquals(descripcionConEspacios, moneda.getDescripcion());
        assertEquals(descripcionCortaConEspacios, moneda.getDescripcion_corta());
        assertEquals(idGecatConEspacios, moneda.getId_moneda_gecat());
    }

    @Test
    @DisplayName("Debe manejar ID con valor máximo de Integer")
    void test_idConValorMaximo() {
        // Act
        moneda.setId_moneda(Integer.MAX_VALUE);

        // Assert
        assertEquals(Integer.MAX_VALUE, moneda.getId_moneda());
    }

    @Test
    @DisplayName("Debe manejar ID con valor mínimo de Integer")
    void test_idConValorMinimo() {
        // Act
        moneda.setId_moneda(Integer.MIN_VALUE);

        // Assert
        assertEquals(Integer.MIN_VALUE, moneda.getId_moneda());
    }
}