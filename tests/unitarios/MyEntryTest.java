package CTTI;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitarios para la clase MyEntry.
 */
public class MyEntryTest {

    private MyEntry entry;

    @BeforeEach
    void setUp() {
        entry = new MyEntry("key", "value");
    }

    @Test
    @DisplayName("Establecer y obtener clave correctamente")
    void test_setGetKey() {
        // Arrange
        String expectedKey = "newKey";
        // Act
        entry.setKey(expectedKey);
        // Assert
        assertEquals(expectedKey, entry.getKey());
    }

    @Test
    @DisplayName("Establecer y obtener valor correctamente")
    void test_setGetValue() {
        // Arrange
        String expectedValue = "newValue";
        // Act
        entry.setValue(expectedValue);
        // Assert
        assertEquals(expectedValue, entry.getValue());
    }

    @Test
    @DisplayName("Comparar dos MyEntry con claves iguales")
    void test_compareTo_sameKey() {
        // Arrange
        MyEntry other = new MyEntry("key", "anotherValue");
        // Act
        int result = entry.compareTo(other);
        // Assert
        assertTrue(result < 0);
    }

    @Test
    @DisplayName("Comparar dos MyEntry con claves diferentes")
    void test_compareTo_differentKey() {
        // Arrange
        MyEntry other = new MyEntry("anotherKey", "value");
        // Act
        int result = entry.compareTo(other);
        // Assert
        assertTrue(result > 0);
    }
}
