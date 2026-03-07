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
    @DisplayName("Debe crear instancia de TbRol")
    void test_crearInstancia() {
        // Assert
        assertNotNull(rol);
        assertNull(rol.getId());
        assertNull(rol.getDescripcion());
    }

    @Test
    @DisplayName("Debe establecer y obtener ID correctamente")
    void test_setterYGetterId() {
        // Arrange
        Integer expectedId = 1;

        // Act
        rol.setId(expectedId);

        // Assert
        assertEquals(expectedId, rol.getId());
    }

    @Test
    @DisplayName("Debe establecer y obtener descripción correctamente")
    void test_setterYGetterDescripcion() {
        // Arrange
        String expectedDescripcion = "Administrador del Sistema";

        // Act
        rol.setDescripcion(expectedDescripcion);

        // Assert
        assertEquals(expectedDescripcion, rol.getDescripcion());
    }

    @Test
    @DisplayName("Debe permitir ID nulo")
    void test_idNulo() {
        // Act
        rol.setId(null);

        // Assert
        assertNull(rol.getId());
    }

    @Test
    @DisplayName("Debe permitir descripción nula")
    void test_descripcionNula() {
        // Act
        rol.setDescripcion(null);

        // Assert
        assertNull(rol.getDescripcion());
    }

    @Test
    @DisplayName("Debe manejar descripción vacía")
    void test_descripcionVacia() {
        // Act
        rol.setDescripcion("");

        // Assert
        assertEquals("", rol.getDescripcion());
    }

    @Test
    @DisplayName("Debe manejar ID con valor cero")
    void test_idConValorCero() {
        // Act
        rol.setId(0);

        // Assert
        assertEquals(0, rol.getId());
    }

    @Test
    @DisplayName("Debe manejar ID con valor negativo")
    void test_idConValorNegativo() {
        // Act
        rol.setId(-1);

        // Assert
        assertEquals(-1, rol.getId());
    }

    @Test
    @DisplayName("Debe manejar descripción larga")
    void test_descripcionLarga() {
        // Arrange
        String descripcionLarga = "Este es un rol con una descripción muy larga que puede contener muchos caracteres".repeat(5);

        // Act
        rol.setDescripcion(descripcionLarga);

        // Assert
        assertEquals(descripcionLarga, rol.getDescripcion());
    }

    @Test
    @DisplayName("Debe manejar caracteres especiales en descripción")
    void test_caracteresEspeciales() {
        // Arrange
        String descripcionConEspeciales = "Rol con áéíóú ñ & símbolos especiales @#$%^&*()";

        // Act
        rol.setDescripcion(descripcionConEspeciales);

        // Assert
        assertEquals(descripcionConEspeciales, rol.getDescripcion());
    }

    @Test
    @DisplayName("Debe ser serializable")
    void test_esSerializable() {
        // Assert
        assertTrue(rol instanceof java.io.Serializable);
    }

    @Test
    @DisplayName("Debe heredar de BaseDescriptiveEntity")
    void test_heredaDeBaseDescriptiveEntity() {
        // Assert
        assertTrue(rol instanceof BaseDescriptiveEntity);
    }

    @Test
    @DisplayName("Debe establecer ambos campos correctamente")
    void test_establecerAmbosCampos() {
        // Arrange
        Integer expectedId = 5;
        String expectedDescripcion = "Usuario Estándar";

        // Act
        rol.setId(expectedId);
        rol.setDescripcion(expectedDescripcion);

        // Assert
        assertEquals(expectedId, rol.getId());
        assertEquals(expectedDescripcion, rol.getDescripcion());
    }

    @Test
    @DisplayName("Debe manejar espacios en blanco en descripción")
    void test_espaciosEnBlanco() {
        // Arrange
        String descripcionConEspacios = "  Rol con espacios al inicio y final  ";

        // Act
        rol.setDescripcion(descripcionConEspacios);

        // Assert
        assertEquals(descripcionConEspacios, rol.getDescripcion());
    }

    @Test
    @DisplayName("Debe manejar ID con valor máximo de Integer")
    void test_idConValorMaximo() {
        // Act
        rol.setId(Integer.MAX_VALUE);

        // Assert
        assertEquals(Integer.MAX_VALUE, rol.getId());
    }

    @Test
    @DisplayName("Debe manejar ID con valor mínimo de Integer")
    void test_idConValorMinimo() {
        // Act
        rol.setId(Integer.MIN_VALUE);

        // Assert
        assertEquals(Integer.MIN_VALUE, rol.getId());
    }

    @Test
    @DisplayName("Debe crear múltiples instancias independientes")
    void test_instanciasIndependientes() {
        // Arrange
        TbRol rol1 = new TbRol();
        TbRol rol2 = new TbRol();

        // Act
        rol1.setId(1);
        rol1.setDescripcion("Rol 1");
        
        rol2.setId(2);
        rol2.setDescripcion("Rol 2");

        // Assert
        assertNotSame(rol1, rol2);
        assertNotEquals(rol1.getId(), rol2.getId());
        assertNotEquals(rol1.getDescripcion(), rol2.getDescripcion());
    }

    @Test
    @DisplayName("Debe manejar descripciones con saltos de línea")
    void test_descripcionConSaltosDeLinea() {
        // Arrange
        String descripcionConSaltos = "Rol de usuario\ncon múltiples\nlíneas de descripción";

        // Act
        rol.setDescripcion(descripcionConSaltos);

        // Assert
        assertEquals(descripcionConSaltos, rol.getDescripcion());
    }

    @Test
    @DisplayName("Debe manejar descripciones con tabulaciones")
    void test_descripcionConTabulaciones() {
        // Arrange
        String descripcionConTabs = "Rol\tcon\ttabulaciones";

        // Act
        rol.setDescripcion(descripcionConTabs);

        // Assert
        assertEquals(descripcionConTabs, rol.getDescripcion());
    }

    @Test
    @DisplayName("Debe funcionar correctamente el override del método getId")
    void test_overrideGetId() {
        // Arrange
        Integer expectedId = 100;

        // Act
        rol.setId(expectedId);
        Integer actualId = rol.getId();

        // Assert
        assertEquals(expectedId, actualId);
        // Verificar que es el mismo método que el de la clase base
        assertTrue(rol instanceof BaseDescriptiveEntity);
    }

    @Test
    @DisplayName("Debe mantener consistencia entre setters y getters")
    void test_consistenciaSettersGetters() {
        // Arrange
        Integer id1 = 10;
        String desc1 = "Primera descripción";
        Integer id2 = 20;
        String desc2 = "Segunda descripción";

        // Act & Assert - Primera asignación
        rol.setId(id1);
        rol.setDescripcion(desc1);
        assertEquals(id1, rol.getId());
        assertEquals(desc1, rol.getDescripcion());

        // Act & Assert - Segunda asignación (sobrescribir)
        rol.setId(id2);
        rol.setDescripcion(desc2);
        assertEquals(id2, rol.getId());
        assertEquals(desc2, rol.getDescripcion());
        
        // Verificar que los valores anteriores fueron reemplazados
        assertNotEquals(id1, rol.getId());
        assertNotEquals(desc1, rol.getDescripcion());
    }
}