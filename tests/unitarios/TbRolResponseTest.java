package CTTI;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitarios para la clase TbRolResponse.
 */
public class TbRolResponseTest {

    private TbRolResponse rolResponse;

    @BeforeEach
    void setUp() {
        rolResponse = new TbRolResponse();
    }

    @Test
    @DisplayName("Debe crear instancia de TbRolResponse")
    void test_crearInstancia() {
        // Assert
        assertNotNull(rolResponse);
        assertNull(rolResponse.getId());
        assertNull(rolResponse.getDescripcion());
    }

    @Test
    @DisplayName("Debe establecer y obtener ID correctamente")
    void test_setterYGetterId() {
        // Arrange
        Integer expectedId = 42;

        // Act
        rolResponse.setId(expectedId);

        // Assert
        assertEquals(expectedId, rolResponse.getId());
    }

    @Test
    @DisplayName("Debe establecer y obtener descripción correctamente")
    void test_setterYGetterDescripcion() {
        // Arrange
        String expectedDescripcion = "Supervisor de Operaciones";

        // Act
        rolResponse.setDescripcion(expectedDescripcion);

        // Assert
        assertEquals(expectedDescripcion, rolResponse.getDescripcion());
    }

    @Test
    @DisplayName("Debe permitir ID nulo")
    void test_idNulo() {
        // Act
        rolResponse.setId(null);

        // Assert
        assertNull(rolResponse.getId());
    }

    @Test
    @DisplayName("Debe permitir descripción nula")
    void test_descripcionNula() {
        // Act
        rolResponse.setDescripcion(null);

        // Assert
        assertNull(rolResponse.getDescripcion());
    }

    @Test
    @DisplayName("Debe manejar descripción vacía")
    void test_descripcionVacia() {
        // Act
        rolResponse.setDescripcion("");

        // Assert
        assertEquals("", rolResponse.getDescripcion());
    }

    @Test
    @DisplayName("Debe manejar ID con valor cero")
    void test_idConValorCero() {
        // Act
        rolResponse.setId(0);

        // Assert
        assertEquals(0, rolResponse.getId());
    }

    @Test
    @DisplayName("Debe manejar ID con valor negativo")
    void test_idConValorNegativo() {
        // Act
        rolResponse.setId(-100);

        // Assert
        assertEquals(-100, rolResponse.getId());
    }

    @Test
    @DisplayName("Debe manejar descripción larga")
    void test_descripcionLarga() {
        // Arrange
        String descripcionLarga = "Este es un rol response con una descripción extremadamente larga que contiene muchos caracteres para probar el comportamiento".repeat(3);

        // Act
        rolResponse.setDescripcion(descripcionLarga);

        // Assert
        assertEquals(descripcionLarga, rolResponse.getDescripcion());
    }

    @Test
    @DisplayName("Debe manejar caracteres especiales en descripción")
    void test_caracteresEspeciales() {
        // Arrange
        String descripcionConEspeciales = "Rol Response con áéíóú ñ & símbolos especiales @#$%^&*()_+-={}[]|\\:;\"'<>,.?/";

        // Act
        rolResponse.setDescripcion(descripcionConEspeciales);

        // Assert
        assertEquals(descripcionConEspeciales, rolResponse.getDescripcion());
    }

    @Test
    @DisplayName("Debe establecer ambos campos correctamente")
    void test_establecerAmbosCampos() {
        // Arrange
        Integer expectedId = 999;
        String expectedDescripcion = "Analista de Datos Senior";

        // Act
        rolResponse.setId(expectedId);
        rolResponse.setDescripcion(expectedDescripcion);

        // Assert
        assertEquals(expectedId, rolResponse.getId());
        assertEquals(expectedDescripcion, rolResponse.getDescripcion());
    }

    @Test
    @DisplayName("Debe manejar espacios en blanco en descripción")
    void test_espaciosEnBlanco() {
        // Arrange
        String descripcionConEspacios = "  Rol Response con espacios al inicio y final  ";

        // Act
        rolResponse.setDescripcion(descripcionConEspacios);

        // Assert
        assertEquals(descripcionConEspacios, rolResponse.getDescripcion());
    }

    @Test
    @DisplayName("Debe manejar ID con valor máximo de Integer")
    void test_idConValorMaximo() {
        // Act
        rolResponse.setId(Integer.MAX_VALUE);

        // Assert
        assertEquals(Integer.MAX_VALUE, rolResponse.getId());
    }

    @Test
    @DisplayName("Debe manejar ID con valor mínimo de Integer")
    void test_idConValorMinimo() {
        // Act
        rolResponse.setId(Integer.MIN_VALUE);

        // Assert
        assertEquals(Integer.MIN_VALUE, rolResponse.getId());
    }

    @Test
    @DisplayName("Debe crear múltiples instancias independientes")
    void test_instanciasIndependientes() {
        // Arrange
        TbRolResponse response1 = new TbRolResponse();
        TbRolResponse response2 = new TbRolResponse();

        // Act
        response1.setId(1);
        response1.setDescripcion("Response 1");
        
        response2.setId(2);
        response2.setDescripcion("Response 2");

        // Assert
        assertNotSame(response1, response2);
        assertNotEquals(response1.getId(), response2.getId());
        assertNotEquals(response1.getDescripcion(), response2.getDescripcion());
    }

    @Test
    @DisplayName("Debe manejar descripciones con saltos de línea")
    void test_descripcionConSaltosDeLinea() {
        // Arrange
        String descripcionConSaltos = "Rol Response\ncon múltiples\nlíneas de descripción\npara testing";

        // Act
        rolResponse.setDescripcion(descripcionConSaltos);

        // Assert
        assertEquals(descripcionConSaltos, rolResponse.getDescripcion());
    }

    @Test
    @DisplayName("Debe manejar descripciones con tabulaciones")
    void test_descripcionConTabulaciones() {
        // Arrange
        String descripcionConTabs = "Rol\tResponse\tcon\ttabulaciones";

        // Act
        rolResponse.setDescripcion(descripcionConTabs);

        // Assert
        assertEquals(descripcionConTabs, rolResponse.getDescripcion());
    }

    @Test
    @DisplayName("Debe funcionar correctamente con anotación @Data de Lombok")
    void test_funcionamientoConLombok() {
        // Arrange
        Integer id = 777;
        String descripcion = "Coordinador de Proyectos";

        // Act
        rolResponse.setId(id);
        rolResponse.setDescripcion(descripcion);

        // Assert - Verificar que los getters funcionan correctamente
        assertEquals(id, rolResponse.getId());
        assertEquals(descripcion, rolResponse.getDescripcion());
    }

    @Test
    @DisplayName("Debe mantener consistencia entre setters y getters")
    void test_consistenciaSettersGetters() {
        // Arrange
        Integer id1 = 50;
        String desc1 = "Primera descripción response";
        Integer id2 = 60;
        String desc2 = "Segunda descripción response";

        // Act & Assert - Primera asignación
        rolResponse.setId(id1);
        rolResponse.setDescripcion(desc1);
        assertEquals(id1, rolResponse.getId());
        assertEquals(desc1, rolResponse.getDescripcion());

        // Act & Assert - Segunda asignación (sobrescribir)
        rolResponse.setId(id2);
        rolResponse.setDescripcion(desc2);
        assertEquals(id2, rolResponse.getId());
        assertEquals(desc2, rolResponse.getDescripcion());
        
        // Verificar que los valores anteriores fueron reemplazados
        assertNotEquals(id1, rolResponse.getId());
        assertNotEquals(desc1, rolResponse.getDescripcion());
    }

    @Test
    @DisplayName("Debe manejar caracteres Unicode")
    void test_caracteresUnicode() {
        // Arrange
        String descripcionUnicode = "Rol 管理者 with 中文 characters and émojis 🚀✨";

        // Act
        rolResponse.setDescripcion(descripcionUnicode);

        // Assert
        assertEquals(descripcionUnicode, rolResponse.getDescripcion());
    }

    @Test
    @DisplayName("Debe permitir reasignación de valores múltiples veces")
    void test_reasignacionMultiple() {
        // Act & Assert - Múltiples asignaciones
        for (int i = 0; i < 5; i++) {
            Integer expectedId = i * 10;
            String expectedDesc = "Descripción " + i;
            
            rolResponse.setId(expectedId);
            rolResponse.setDescripcion(expectedDesc);
            
            assertEquals(expectedId, rolResponse.getId());
            assertEquals(expectedDesc, rolResponse.getDescripcion());
        }
    }

    @Test
    @DisplayName("Debe manejar descripciones con comillas")
    void test_descripcionConComillas() {
        // Arrange
        String descripcionConComillas = "Rol \"Administrador\" con 'comillas simples' y \"dobles\"";

        // Act
        rolResponse.setDescripcion(descripcionConComillas);

        // Assert
        assertEquals(descripcionConComillas, rolResponse.getDescripcion());
    }
}