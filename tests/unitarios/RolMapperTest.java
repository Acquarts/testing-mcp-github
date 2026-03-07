package CTTI;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Tests unitarios para la clase RolMapper.
 */
public class RolMapperTest {

    private RolMapper rolMapper;
    private TbRol rolEntity;

    @BeforeEach
    void setUp() {
        rolMapper = new RolMapper();
        rolEntity = new TbRol();
        rolEntity.setId(1);
        rolEntity.setDescripcion("Administrador");
    }

    @Test
    @DisplayName("Debe mapear correctamente TbRol a TbRolResponse")
    void test_mapearRolCorrecta() {
        // Act
        TbRolResponse result = rolMapper.toDto(rolEntity);

        // Assert
        assertNotNull(result);
        assertEquals(rolEntity.getId(), result.getId());
        assertEquals(rolEntity.getDescripcion(), result.getDescripcion());
    }

    @Test
    @DisplayName("Debe retornar null cuando la entidad es null")
    void test_mapearRolNula() {
        // Act
        TbRolResponse result = rolMapper.toDto(null);

        // Assert
        assertNull(result);
    }

    @Test
    @DisplayName("Debe mapear correctamente cuando los campos son nulos")
    void test_mapearRolConCamposNulos() {
        // Arrange
        TbRol rolNulo = new TbRol();
        rolNulo.setId(null);
        rolNulo.setDescripcion(null);

        // Act
        TbRolResponse result = rolMapper.toDto(rolNulo);

        // Assert
        assertNotNull(result);
        assertNull(result.getId());
        assertNull(result.getDescripcion());
    }

    @Test
    @DisplayName("Debe mapear correctamente con valores vacíos")
    void test_mapearRolConValoresVacios() {
        // Arrange
        TbRol rolVacio = new TbRol();
        rolVacio.setId(0);
        rolVacio.setDescripcion("");

        // Act
        TbRolResponse result = rolMapper.toDto(rolVacio);

        // Assert
        assertNotNull(result);
        assertEquals(0, result.getId());
        assertEquals("", result.getDescripcion());
    }

    @Test
    @DisplayName("Debe mapear lista de roles correctamente")
    void test_mapearListaRoles() {
        // Arrange
        TbRol rol1 = new TbRol();
        rol1.setId(1);
        rol1.setDescripcion("Administrador");

        TbRol rol2 = new TbRol();
        rol2.setId(2);
        rol2.setDescripcion("Usuario");

        List<TbRol> roles = Arrays.asList(rol1, rol2);

        // Act
        List<TbRolResponse> result = rolMapper.toDtoList(roles);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        
        assertEquals(rol1.getId(), result.get(0).getId());
        assertEquals(rol1.getDescripcion(), result.get(0).getDescripcion());
        
        assertEquals(rol2.getId(), result.get(1).getId());
        assertEquals(rol2.getDescripcion(), result.get(1).getDescripcion());
    }

    @Test
    @DisplayName("Debe retornar null cuando la lista de entidades es null")
    void test_mapearListaRolesNula() {
        // Act
        List<TbRolResponse> result = rolMapper.toDtoList(null);

        // Assert
        assertNull(result);
    }

    @Test
    @DisplayName("Debe mapear lista vacía correctamente")
    void test_mapearListaRolesVacia() {
        // Arrange
        List<TbRol> rolesVacios = Collections.emptyList();

        // Act
        List<TbRolResponse> result = rolMapper.toDtoList(rolesVacios);

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Debe mapear lista con elementos nulos")
    void test_mapearListaConElementosNulos() {
        // Arrange
        TbRol rolValido = new TbRol();
        rolValido.setId(1);
        rolValido.setDescripcion("Rol válido");

        List<TbRol> rolesConNulos = Arrays.asList(rolValido, null);

        // Act
        List<TbRolResponse> result = rolMapper.toDtoList(rolesConNulos);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        
        // Primer elemento mapeado correctamente
        assertNotNull(result.get(0));
        assertEquals(rolValido.getId(), result.get(0).getId());
        assertEquals(rolValido.getDescripcion(), result.get(0).getDescripcion());
        
        // Segundo elemento es null
        assertNull(result.get(1));
    }

    @Test
    @DisplayName("Debe crear nuevas instancias de TbRolResponse")
    void test_crearNuevasInstanciasResponse() {
        // Act
        TbRolResponse result1 = rolMapper.toDto(rolEntity);
        TbRolResponse result2 = rolMapper.toDto(rolEntity);

        // Assert
        assertNotNull(result1);
        assertNotNull(result2);
        assertNotSame(result1, result2); // Diferentes instancias
        assertEquals(result1.getId(), result2.getId()); // Mismo contenido
        assertEquals(result1.getDescripcion(), result2.getDescripcion());
    }

    @Test
    @DisplayName("Debe mapear correctamente con ID negativo")
    void test_mapearRolConIdNegativo() {
        // Arrange
        rolEntity.setId(-1);

        // Act
        TbRolResponse result = rolMapper.toDto(rolEntity);

        // Assert
        assertNotNull(result);
        assertEquals(-1, result.getId());
    }

    @Test
    @DisplayName("Debe mapear correctamente con descripción larga")
    void test_mapearRolConDescripcionLarga() {
        // Arrange
        String descripcionLarga = "Esta es una descripción muy larga para un rol de usuario".repeat(10);
        rolEntity.setDescripcion(descripcionLarga);

        // Act
        TbRolResponse result = rolMapper.toDto(rolEntity);

        // Assert
        assertNotNull(result);
        assertEquals(descripcionLarga, result.getDescripcion());
    }

    @Test
    @DisplayName("Debe mapear correctamente con caracteres especiales")
    void test_mapearRolConCaracteresEspeciales() {
        // Arrange
        rolEntity.setDescripcion("Administrador con áéíóú ñ & símbolos especiales @#$%");

        // Act
        TbRolResponse result = rolMapper.toDto(rolEntity);

        // Assert
        assertNotNull(result);
        assertEquals("Administrador con áéíóú ñ & símbolos especiales @#$%", result.getDescripcion());
    }

    @Test
    @DisplayName("Debe mapear lista grande de roles")
    void test_mapearListaGrandeRoles() {
        // Arrange
        List<TbRol> rolesGrandes = Arrays.asList(
            crearRol(1, "Rol 1"),
            crearRol(2, "Rol 2"),
            crearRol(3, "Rol 3"),
            crearRol(4, "Rol 4"),
            crearRol(5, "Rol 5")
        );

        // Act
        List<TbRolResponse> result = rolMapper.toDtoList(rolesGrandes);

        // Assert
        assertNotNull(result);
        assertEquals(5, result.size());
        
        for (int i = 0; i < 5; i++) {
            assertEquals(i + 1, result.get(i).getId());
            assertEquals("Rol " + (i + 1), result.get(i).getDescripcion());
        }
    }

    private TbRol crearRol(Integer id, String descripcion) {
        TbRol rol = new TbRol();
        rol.setId(id);
        rol.setDescripcion(descripcion);
        return rol;
    }
}