package CTTI;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;

/**
 * Tests unitarios para la clase RolMapper.
 */
public class RolMapperTest {

    @InjectMocks
    private RolMapper rolMapper;

    @Mock
    private TbRol tbRol;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        tbRol = new TbRol();
        tbRol.setId(1);
        tbRol.setDescripcion("Admin");
    }

    @Test
    @DisplayName("Mapear entidad TbRol a DTO TbRolResponse correctamente")
    void test_toDto() {
        // Act
        TbRolResponse response = rolMapper.toDto(tbRol);
        // Assert
        assertNotNull(response);
        assertEquals(tbRol.getId(), response.getId());
        assertEquals(tbRol.getDescripcion(), response.getDescripcion());
    }

    @Test
    @DisplayName("Mapear lista de entidades TbRol a lista de DTOs TbRolResponse correctamente")
    void test_toDtoList() {
        // Arrange
        List<TbRol> roles = Arrays.asList(tbRol);
        // Act
        List<TbRolResponse> responses = rolMapper.toDtoList(roles);
        // Assert
        assertNotNull(responses);
        assertEquals(1, responses.size());
        assertEquals(tbRol.getId(), responses.get(0).getId());
    }
}
