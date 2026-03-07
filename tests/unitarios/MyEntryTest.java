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
        entry = new MyEntry();
    }

    @Test
    @DisplayName("Debe crear instancia con constructor por defecto")
    void test_constructorPorDefecto() {
        // Act
        MyEntry newEntry = new MyEntry();

        // Assert
        assertNotNull(newEntry);
        assertNull(newEntry.getKey());
        assertNull(newEntry.getValue());
        assertNull(newEntry.getValueBBDD());
        assertFalse(newEntry.isSystemProperty());
    }

    @Test
    @DisplayName("Debe crear instancia con constructor parametrizado")
    void test_constructorParametrizado() {
        // Arrange
        String key = "testKey";
        String value = "testValue";

        // Act
        MyEntry newEntry = new MyEntry(key, value);

        // Assert
        assertNotNull(newEntry);
        assertEquals(key, newEntry.getKey());
        assertEquals(value, newEntry.getValue());
        assertNull(newEntry.getValueBBDD());
        assertFalse(newEntry.isSystemProperty());
    }

    @Test
    @DisplayName("Debe establecer y obtener key correctamente")
    void test_setterYGetterKey() {
        // Arrange
        String expectedKey = "miClave";

        // Act
        entry.setKey(expectedKey);

        // Assert
        assertEquals(expectedKey, entry.getKey());
    }

    @Test
    @DisplayName("Debe establecer y obtener value correctamente")
    void test_setterYGetterValue() {
        // Arrange
        String expectedValue = "miValor";

        // Act
        entry.setValue(expectedValue);

        // Assert
        assertEquals(expectedValue, entry.getValue());
    }

    @Test
    @DisplayName("Debe establecer y obtener valueBBDD correctamente")
    void test_setterYGetterValueBBDD() {
        // Arrange
        String expectedValueBBDD = "valorBaseDatos";

        // Act
        entry.setValueBBDD(expectedValueBBDD);

        // Assert
        assertEquals(expectedValueBBDD, entry.getValueBBDD());
    }

    @Test
    @DisplayName("Debe establecer y obtener systemProperty correctamente")
    void test_setterYGetterSystemProperty() {
        // Act
        entry.setSystemProperty(true);

        // Assert
        assertTrue(entry.isSystemProperty());

        // Act
        entry.setSystemProperty(false);

        // Assert
        assertFalse(entry.isSystemProperty());
    }

    @Test
    @DisplayName("Debe crear instancia usando getInstance()")
    void test_getInstance() {
        // Act
        MyEntry newEntry = MyEntry.getInstance();

        // Assert
        assertNotNull(newEntry);
        assertNull(newEntry.getKey());
        assertNull(newEntry.getValue());
    }

    @Test
    @DisplayName("Debe crear instancia usando getInstance(key, value)")
    void test_getInstanceConParametros() {
        // Arrange
        String key = "clave";
        String value = "valor";

        // Act
        MyEntry newEntry = MyEntry.getInstance(key, value);

        // Assert
        assertNotNull(newEntry);
        assertEquals(key, newEntry.getKey());
        assertEquals(value, newEntry.getValue());
    }

    @Test
    @DisplayName("Debe comparar correctamente cuando ambos objetos son iguales")
    void test_compareToIguales() {
        // Arrange
        MyEntry entry1 = new MyEntry("key1", "value1");
        MyEntry entry2 = new MyEntry("key1", "value1");

        // Act
        int result = entry1.compareTo(entry2);

        // Assert
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Debe comparar correctamente cuando el otro objeto es null")
    void test_compareToConNull() {
        // Arrange
        MyEntry entry1 = new MyEntry("key1", "value1");

        // Act
        int result = entry1.compareTo(null);

        // Assert
        assertEquals(1, result);
    }

    @Test
    @DisplayName("Debe comparar correctamente cuando mi key es null y la otra no")
    void test_compareToMiKeyNulaOtraNo() {
        // Arrange
        MyEntry entry1 = new MyEntry(null, "value1");
        MyEntry entry2 = new MyEntry("key2", "value2");

        // Act
        int result = entry1.compareTo(entry2);

        // Assert
        assertEquals(-1, result);
    }

    @Test
    @DisplayName("Debe comparar correctamente cuando mi key no es null y la otra sí")
    void test_compareToMiKeyNoNulaOtraSi() {
        // Arrange
        MyEntry entry1 = new MyEntry("key1", "value1");
        MyEntry entry2 = new MyEntry(null, "value2");

        // Act
        int result = entry1.compareTo(entry2);

        // Assert
        assertEquals(1, result);
    }

    @Test
    @DisplayName("Debe comparar correctamente cuando ambas keys son null")
    void test_compareToAmbasKeysNull() {
        // Arrange
        MyEntry entry1 = new MyEntry(null, "value1");
        MyEntry entry2 = new MyEntry(null, "value2");

        // Act
        int result = entry1.compareTo(entry2);

        // Assert
        assertEquals(0, result); // Keys iguales (null), no compara values en este caso
    }

    @Test
    @DisplayName("Debe comparar correctamente por key cuando son diferentes")
    void test_compareToKeysDiferentes() {
        // Arrange
        MyEntry entry1 = new MyEntry("keyA", "value1");
        MyEntry entry2 = new MyEntry("keyB", "value2");

        // Act
        int result = entry1.compareTo(entry2);

        // Assert
        assertTrue(result < 0); // "keyA" < "keyB"
    }

    @Test
    @DisplayName("Debe comparar por value cuando keys son iguales")
    void test_compareToKeysIgualesValuesDiferentes() {
        // Arrange
        MyEntry entry1 = new MyEntry("key", "valueA");
        MyEntry entry2 = new MyEntry("key", "valueB");

        // Act
        int result = entry1.compareTo(entry2);

        // Assert
        assertTrue(result < 0); // "valueA" < "valueB"
    }

    @Test
    @DisplayName("Debe comparar correctamente cuando mi value es null y el otro no")
    void test_compareToMiValueNuloOtroNo() {
        // Arrange
        MyEntry entry1 = new MyEntry("key", null);
        MyEntry entry2 = new MyEntry("key", "value");

        // Act
        int result = entry1.compareTo(entry2);

        // Assert
        assertEquals(-1, result);
    }

    @Test
    @DisplayName("Debe comparar correctamente cuando mi value no es null y el otro sí")
    void test_compareToMiValueNoNuloOtroSi() {
        // Arrange
        MyEntry entry1 = new MyEntry("key", "value");
        MyEntry entry2 = new MyEntry("key", null);

        // Act
        int result = entry1.compareTo(entry2);

        // Assert
        assertEquals(1, result);
    }

    @Test
    @DisplayName("Debe comparar correctamente cuando ambos values son null")
    void test_compareToAmbosValuesNull() {
        // Arrange
        MyEntry entry1 = new MyEntry("key", null);
        MyEntry entry2 = new MyEntry("key", null);

        // Act
        int result = entry1.compareTo(entry2);

        // Assert
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Debe manejar valores con espacios en blanco")
    void test_valoresConEspacios() {
        // Arrange
        String keyConEspacios = " key with spaces ";
        String valueConEspacios = " value with spaces ";

        // Act
        entry.setKey(keyConEspacios);
        entry.setValue(valueConEspacios);

        // Assert
        assertEquals(keyConEspacios, entry.getKey());
        assertEquals(valueConEspacios, entry.getValue());
    }
}