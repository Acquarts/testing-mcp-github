package CTTI;

import org.junit.jupiter.api.*;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MonedaMapperTest {
    
    @Test
    @DisplayName("Should return TbMonedaResponse when valid moneda provided")
    void shouldReturnTbMonedaResponseWhenValidMonedaProvided() {
        // Given
        TbMoneda testMoneda = new TbMoneda();
        testMoneda.setId_moneda(1);
        testMoneda.setId_moneda_gecat("EUR");
        testMoneda.setDescripcion("Euro");
        testMoneda.setDescripcion_corta("€");
        
        // When
        TbMonedaResponse result = MonedaMapper.toDto(testMoneda);
        
        // Then
        assertNotNull(result);
        assertEquals(testMoneda.getId_moneda(), result.getId_moneda());
        assertEquals(testMoneda.getId_moneda_gecat(), result.getId_moneda_gecat());
        assertEquals(testMoneda.getDescripcion(), result.getDescripcion());
        assertEquals(testMoneda.getDescripcion_corta(), result.getDescripcion_corta());
    }
    
    @Test
    @DisplayName("Should return null when moneda is null")
    void shouldReturnNullWhenMonedaIsNull() {
        // Given
        TbMoneda monedas = null;
        
        // When
        TbMonedaResponse result = MonedaMapper.toDto(monedas);
        
        // Then
        assertNull(result);
    }
    
    @Test
    @DisplayName("Should handle moneda with null fields")
    void shouldHandleMonedaWithNullFields() {
        // Given
        TbMoneda monedaWithNullFields = new TbMoneda();
        
        // When
        TbMonedaResponse result = MonedaMapper.toDto(monedaWithNullFields);
        
        // Then
        assertNotNull(result);
        assertNull(result.getId_moneda());
        assertNull(result.getId_moneda_gecat());
        assertNull(result.getDescripcion());
        assertNull(result.getDescripcion_corta());
    }
    
    @Test
    @DisplayName("Should handle moneda with partial null fields")
    void shouldHandleMonedaWithPartialNullFields() {
        // Given
        TbMoneda monedaWithPartialNullFields = new TbMoneda();
        monedaWithPartialNullFields.setId_moneda(1);
        monedaWithPartialNullFields.setDescripcion("Euro");
        
        // When
        TbMonedaResponse result = MonedaMapper.toDto(monedaWithPartialNullFields);
        
        // Then
        assertNotNull(result);
        assertEquals(1, result.getId_moneda());
        assertNull(result.getId_moneda_gecat());
        assertEquals("Euro", result.getDescripcion());
        assertNull(result.getDescripcion_corta());
    }
}
