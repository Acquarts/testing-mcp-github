package CTTI;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitarios para la clase TbRolResponse.
 */
public class TbRolResponseTest {

    private TbRolResponse response;

    @BeforeEach
    void setUp() {
        response = new TbRolResponse();
    }

    @Test
    @DisplayName("Establecer y obtener ID correctamente")
    void test_setGetId() {
        // Arrange
        Integer expectedId = 1;
        // Act
        response.setId(expectedId);
        // Assert
        assertEquals(expectedId, response.getId());
    }

    @Test
    @DisplayName("Establecer y obtener descripción correctamente")
    void test_setGetDescripcion() {
        // Arrange
        String expectedDescripcion = "Administrador";
        // Act
        response.setDescripcion(expectedDescripcion);
        // Assert
        assertEquals(expectedDescripcion, response.getDescripcion());
    }
}
