package CTTI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("TbMoneda Entity Unit Tests")
class TbMonedaTest {

    private TbMoneda tbMoneda;

    @BeforeEach
    void setUp() {
        tbMoneda = new TbMoneda();
    }

    @Test
    @DisplayName("Should return id moneda when getId_moneda is called")
    void shouldReturnIdMonedaWhenGetIdMonedaIsCalled() {
        // Given
        // tbMoneda initialized with default constructor

        // When
        Integer result = tbMoneda.getId_moneda();

        // Then
        assertNull(result);
    }

    @Test
    @DisplayName("Should set id moneda when valid id is provided")
    void shouldSetIdMonedaWhenValidIdIsProvided() {
        // Given
        Integer testId = 123;

        // When
        tbMoneda.setId_moneda(testId);

        // Then
        assertEquals(Integer.valueOf(123), tbMoneda.getId_moneda());
    }

    @Test
    @DisplayName("Should return id moneda gecat when getId_moneda_gecat is called")
    void shouldReturnIdMonedaGecatWhenGetIdMonedaGecatIsCalled() {
        // Given
        // tbMoneda initialized with default constructor

        // When
        String result = tbMoneda.getId_moneda_gecat();

        // Then
        assertNull(result);
    }

    @Test
    @DisplayName("Should set id moneda gecat when valid id is provided")
    void shouldSetIdMonedaGecatWhenValidIdIsProvided() {
        // Given
        String testId = "EUR";

        // When
        tbMoneda.setId_moneda_gecat(testId);

        // Then
        assertEquals("EUR", tbMoneda.getId_moneda_gecat());
    }

    @Test
    @DisplayName("Should return descripcion when getDescripcion is called")
    void shouldReturnDescripcionWhenGetDescripcionIsCalled() {
        // Given
        // tbMoneda initialized with default constructor

        // When
        String result = tbMoneda.getDescripcion();

        // Then
        assertNull(result);
    }

    @Test
    @DisplayName("Should set descripcion when valid descripcion is provided")
    void shouldSetDescripcionWhenValidDescripcionIsProvided() {
        // Given
        String testDescripcion = "Euro";

        // When
        tbMoneda.setDescripcion(testDescripcion);

        // Then
        assertEquals("Euro", tbMoneda.getDescripcion());
    }

    @Test
    @DisplayName("Should return descripcion corta when getDescripcion_corta is called")
    void shouldReturnDescripcionCortaWhenGetDescripcionCortaIsCalled() {
        // Given
        // tbMoneda initialized with default constructor

        // When
        String result = tbMoneda.getDescripcion_corta();

        // Then
        assertNull(result);
    }

    @Test
    @DisplayName("Should set descripcion corta when valid descripcion is provided")
    void shouldSetDescripcionCortaWhenValidDescripcionIsProvided() {
        // Given
        String testDescripcionCorta = "EUR";

        // When
        tbMoneda.setDescripcion_corta(testDescripcionCorta);

        // Then
        assertEquals("EUR", tbMoneda.getDescripcion_corta());
    }
}
