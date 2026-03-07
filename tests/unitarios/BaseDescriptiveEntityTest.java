package CTTI;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitarios para la clase BaseDescriptiveEntity.
 */
public class BaseDescriptiveEntityTest {

    private TestableBaseDescriptiveEntity entity;

    @BeforeEach
    void setUp() {
        entity = new TestableBaseDescriptiveEntity();
    }

    @Test
    @DisplayName("Debe establecer y obtener el ID correctamente")
    void test_setterYGetterIdCorrecto() {
        // Arrange
        Integer expectedId = 123;

        // Act
        entity.setId(expectedId);
        Integer actualId = entity.getId();

        // Assert
        assertEquals(expectedId, actualId);
    }

    @Test
    @DisplayName("Debe establecer y obtener la descripción correctamente")
    void test_setterYGetterDescripcionCorrecto() {
        // Arrange
        String expectedDescripcion = "Descripción de prueba";

        // Act
        entity.setDescripcion(expectedDescripcion);
        String actualDescripcion = entity.getDescripcion();

        // Assert
        assertEquals(expectedDescripcion, actualDescripcion);
    }

    @Test
    @DisplayName("Debe permitir descripción nula")
    void test_descripcionNula() {
        // Arrange & Act
        entity.setDescripcion(null);

        // Assert
        assertNull(entity.getDescripcion());
    }

    @Test
    @DisplayName("Debe permitir ID nulo")
    void test_idNulo() {
        // Arrange & Act
        entity.setId(null);

        // Assert
        assertNull(entity.getId());
    }

    @Test
    @DisplayName("Debe manejar descripción vacía")
    void test_descripcionVacia() {
        // Arrange
        String descripcionVacia = "";

        // Act
        entity.setDescripcion(descripcionVacia);

        // Assert
        assertEquals(descripcionVacia, entity.getDescripcion());
    }

    @Test
    @DisplayName("Debe ser serializable")
    void test_esSerializable() {
        // Assert
        assertTrue(entity instanceof java.io.Serializable);
    }

    /**
     * Clase concreta para testear BaseDescriptiveEntity
     */
    private static class TestableBaseDescriptiveEntity extends BaseDescriptiveEntity<Integer> {
        // Implementación concreta para testing
    }
}