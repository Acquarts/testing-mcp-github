package CTTI;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitarios para la clase TbMonedaResponse.
 */
public class TbMonedaResponseTest {

    private TbMonedaResponse response;

    @BeforeEach
    void setUp() {
        response = new TbMonedaResponse();
    }

    @Test
    @DisplayName("Establecer y obtener ID de moneda correctamente")
    void test_setGetIdMoneda() {
        // Arrange
        Integer expectedId = 1;
        // Act
        response.setId_moneda(expectedId);
        // Assert
        assertEquals(expectedId, response.getId_moneda());
    }

    @Test
    @DisplayName("Establecer y obtener descripción correctamente")
    void test_setGetDescripcion() {
        // Arrange
        String expectedDescripcion = "Euro";
        // Act
        response.setDescripcion(expectedDescripcion);
        // Assert
        assertEquals(expectedDescripcion, response.getDescripcion());
    }

    @Test
    @DisplayName("Establecer y obtener descripción corta correctamente")
    void test_setGetDescripcionCorta() {
        // Arrange
        String expectedDescripcionCorta = "EUR";
        // Act
        response.setDescripcion_corta(expectedDescripcionCorta);
        // Assert
        assertEquals(expectedDescripcionCorta, response.getDescripcion_corta());
    }
}
