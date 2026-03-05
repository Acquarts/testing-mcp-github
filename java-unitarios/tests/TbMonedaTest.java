package CTTI;

import org.junit.jupiter.api.*;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TbMonedaTest {
    private TbMoneda tbMoneda;

    @BeforeEach
    void setUp() {
        tbMoneda = new TbMoneda();
    }

    @Test
    @DisplayName("Should return id_moneda when getId_moneda is called")
    void shouldReturnIdMonedaWhenGetIdMonedaIsCalled() {
        // Given
        Integer testIdMoneda = 1;
        tbMoneda.setId_moneda(testIdMoneda);

        // When
        Integer result = tbMoneda.getId_moneda();

        // Then
        assertEquals(testIdMoneda, result);
    }

    @Test
    @DisplayName("Should return null when id_moneda is null")
    void shouldReturnNullWhenIdMonedaIsNull() {
        // When
        Integer result = tbMoneda.getId_moneda();

        // Then
        assertNull(result);
    }

    @Test
    @DisplayName("Should set id_moneda successfully when valid value provided")
    void shouldSetIdMonedaSuccessfullyWhenValidValueProvided() {
        // When
        tbMoneda.setId_moneda(123);

        // Then
        assertEquals(123, tbMoneda.getId_moneda());
    }

    @Test
    @DisplayName("Should set id_moneda to null when null value provided")
    void shouldSetIdMonedaToNullWhenNullValueProvided() {
        // When
        tbMoneda.setId_moneda(null);

        // Then
        assertNull(tbMoneda.getId_moneda());
    }

    @Test
    @DisplayName("Should return id_moneda_gecat when getId_moneda_gecat is called")
    void shouldReturnIdMonedaGecatWhenGetIdMonedaGecatIsCalled() {
        // Given
        tbMoneda.setId_moneda_gecat("EUR");

        // When
        String result = tbMoneda.getId_moneda_gecat();

        // Then
        assertEquals("EUR", result);
    }

    @Test
    @DisplayName("Should return null when id_moneda_gecat is null")
    void shouldReturnNullWhenIdMonedaGecatIsNull() {
        // When
        String result = tbMoneda.getId_moneda_gecat();

        // Then
        assertNull(result);
    }

    @Test
    @DisplayName("Should set id_moneda_gecat successfully when valid value provided")
    void shouldSetIdMonedaGecatSuccessfullyWhenValidValueProvided() {
        // When
        tbMoneda.setId_moneda_gecat("USD");

        // Then
        assertEquals("USD", tbMoneda.getId_moneda_gecat());
    }

    @Test
    @DisplayName("Should set id_moneda_gecat to null when null value provided")
    void shouldSetIdMonedaGecatToNullWhenNullValueProvided() {
        // When
        tbMoneda.setId_moneda_gecat(null);

        // Then
        assertNull(tbMoneda.getId_moneda_gecat());
    }
}
