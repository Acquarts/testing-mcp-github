package CTTI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("MyEntry Unit Tests")
class MyEntryTest {

    private MyEntry myEntry;

    @BeforeEach
    void setUp() {
        myEntry = new MyEntry("testKey", "testValue");
    }

    @Test
    @DisplayName("Should return key when getKey is called")
    void shouldReturnKeyWhenGetKeyIsCalled() {
        // Given
        // myEntry initialized with "testKey"

        // When
        String result = myEntry.getKey();

        // Then
        assertEquals("testKey", result);
    }

    @Test
    @DisplayName("Should return null when key is null")
    void shouldReturnNullWhenKeyIsNull() {
        // Given
        myEntry.setKey(null);

        // When
        String result = myEntry.getKey();

        // Then
        assertNull(result);
    }

    @Test
    @DisplayName("Should set key when valid key is provided")
    void shouldSetKeyWhenValidKeyIsProvided() {
        // Given
        String newKey = "newKey";

        // When
        myEntry.setKey(newKey);

        // Then
        assertEquals("newKey", myEntry.getKey());
    }

    @Test
    @DisplayName("Should set key to null when null key is provided")
    void shouldSetKeyToNullWhenNullKeyIsProvided() {
        // Given
        // When
        myEntry.setKey(null);

        // Then
        assertNull(myEntry.getKey());
    }

    @Test
    @DisplayName("Should return value when getValue is called")
    void shouldReturnValueWhenGetValueIsCalled() {
        // Given
        // myEntry initialized with "testValue"

        // When
        String result = myEntry.getValue();

        // Then
        assertEquals("testValue", result);
    }

    @Test
    @DisplayName("Should return null when value is null")
    void shouldReturnNullWhenValueIsNull() {
        // Given
        myEntry.setValue(null);

        // When
        String result = myEntry.getValue();

        // Then
        assertNull(result);
    }

    @Test
    @DisplayName("Should set value when valid value is provided")
    void shouldSetValueWhenValidValueIsProvided() {
        // Given
        String newValue = "newValue";

        // When
        myEntry.setValue(newValue);

        // Then
        assertEquals("newValue", myEntry.getValue());
    }

    @Test
    @DisplayName("Should set value to null when null value is provided")
    void shouldSetValueToNullWhenNullValueIsProvided() {
        // Given
        // When
        myEntry.setValue(null);

        // Then
        assertNull(myEntry.getValue());
    }

    @Test
    @DisplayName("Should return valueBBDD when getValueBBDD is called")
    void shouldReturnValueBBDDWhenGetValueBBDDIsCalled() {
        // Given
        // myEntry initialized without valueBBDD

        // When
        String result = myEntry.getValueBBDD();

        // Then
        assertNull(result);
    }

    @Test
    @DisplayName("Should set valueBBDD when valid value is provided")
    void shouldSetValueBBDDWhenValidValueIsProvided() {
        // Given
        String testValueBBDD = "testValueBBDD";

        // When
        myEntry.setValueBBDD(testValueBBDD);

        // Then
        assertEquals("testValueBBDD", myEntry.getValueBBDD());
    }

    @Test
    @DisplayName("Should return false when system property is not set")
    void shouldReturnFalseWhenSystemPropertyIsNotSet() {
        // Given
        // myEntry initialized with systemProperty = false

        // When
        boolean result = myEntry.isSystemProperty();

        // Then
        assertFalse(result);
    }

    @Test
    @DisplayName("Should set system property when boolean value is provided")
    void shouldSetSystemPropertyWhenBooleanValueIsProvided() {
        // Given
        // When
        myEntry.setSystemProperty(true);

        // Then
        assertTrue(myEntry.isSystemProperty());
    }

    @Test
    @DisplayName("Should return new instance when getInstance is called")
    void shouldReturnNewInstanceWhenGetInstanceIsCalled() {
        // Given
        // When
        MyEntry result = MyEntry.getInstance();

        // Then
        assertNotNull(result);
        assertNull(result.getKey());
        assertNull(result.getValue());
    }

    @Test
    @DisplayName("Should return instance with parameters when getInstance is called with key and value")
    void shouldReturnInstanceWithParametersWhenGetInstanceIsCalledWithKeyAndValue() {
        // Given
        String factoryKey = "factoryKey";
        String factoryValue = "factoryValue";

        // When
        MyEntry result = MyEntry.getInstance(factoryKey, factoryValue);

        // Then
        assertNotNull(result);
        assertEquals("factoryKey", result.getKey());
        assertEquals("factoryValue", result.getValue());
    }

    @Test
    @DisplayName("Should return instance with null values when getInstance is called with null parameters")
    void shouldReturnInstanceWithNullValuesWhenGetInstanceIsCalledWithNullParameters() {
        // Given
        // When
        MyEntry result = MyEntry.getInstance(null, null);

        // Then
        assertNotNull(result);
        assertNull(result.getKey());
        assertNull(result.getValue());
    }

    @Test
    @DisplayName("Should return zero when comparing equal entries")
    void shouldReturnZeroWhenComparingEqualEntries() {
        // Given
        MyEntry equalEntry = new MyEntry("testKey", "testValue");

        // When
        int result = myEntry.compareTo(equalEntry);

        // Then
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Should return negative when this key is less than other key")
    void shouldReturnNegativeWhenThisKeyIsLessThanOtherKey() {
        // Given
        MyEntry greaterEntry = new MyEntry("zzzKey", "testValue");

        // When
        int result = myEntry.compareTo(greaterEntry);

        // Then
        assertTrue(result < 0);
    }

    @Test
    @DisplayName("Should return positive when this key is greater than other key")
    void shouldReturnPositiveWhenThisKeyIsGreaterThanOtherKey() {
        // Given
        MyEntry lesserEntry = new MyEntry("aaa", "testValue");

        // When
        int result = myEntry.compareTo(lesserEntry);

        // Then
        assertTrue(result > 0);
    }
}
