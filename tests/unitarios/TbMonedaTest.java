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
    @DisplayName("Establecer y obtener ID de moneda correctamente")
    void test_setGetIdMoneda() {
        // Arrange
        Integer expectedId = 1;
        // Act
        moneda.setId_moneda(expectedId);
        // Assert
        assertEquals(expectedId, moneda.getId_moneda());
    }

    @Test
    @DisplayName("Establecer y obtener descripción correctamente")
    void test_setGetDescripcion() {
        // Arrange
        String expectedDescripcion = "Euro";
        // Act
        moneda.setDescripcion(expectedDescripcion);
        // Assert
        assertEquals(expectedDescripcion, moneda.getDescripcion());
    }

    @Test
    @DisplayName("Establecer y obtener descripción corta correctamente")
    void test_setGetDescripcionCorta() {
        // Arrange
        String expectedDescripcionCorta = "EUR";
        // Act
        moneda.setDescripcion_corta(expectedDescripcionCorta);
        // Assert
        assertEquals(expectedDescripcionCorta, moneda.getDescripcion_corta());
    }
}
