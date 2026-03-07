package CTTI;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitarios para la clase BaseDescriptiveEntity.
 */
public class BaseDescriptiveEntityTest {

    private BaseDescriptiveEntity<Integer> entity;

    @BeforeEach
    void setUp() {
        entity = new BaseDescriptiveEntity<Integer>() {};
    }

    @Test
    @DisplayName("Establecer y obtener ID correctamente")
    void test_setGetId() {
        // Arrange
        Integer expectedId = 1;
        // Act
        entity.setId(expectedId);
        // Assert
        assertEquals(expectedId, entity.getId());
    }

    @Test
    @DisplayName("Establecer y obtener descripción correctamente")
    void test_setGetDescripcion() {
        // Arrange
        String expectedDescripcion = "Descripción de prueba";
        // Act
        entity.setDescripcion(expectedDescripcion);
        // Assert
        assertEquals(expectedDescripcion, entity.getDescripcion());
    }
}
