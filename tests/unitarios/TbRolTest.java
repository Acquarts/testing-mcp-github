package CTTI;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitarios para la clase TbRol.
 */
public class TbRolTest {

    private TbRol rol;

    @BeforeEach
    void setUp() {
        rol = new TbRol();
    }

    @Test
    @DisplayName("Establecer y obtener ID correctamente")
    void test_setGetId() {
        // Arrange
        Integer expectedId = 1;
        // Act
        rol.setId(expectedId);
        // Assert
        assertEquals(expectedId, rol.getId());
    }

    @Test
    @DisplayName("Establecer y obtener descripción correctamente")
    void test_setGetDescripcion() {
        // Arrange
        String expectedDescripcion = "Administrador";
        // Act
        rol.setDescripcion(expectedDescripcion);
        // Assert
        assertEquals(expectedDescripcion, rol.getDescripcion());
    }
}
