package CTTI;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;

/**
 * Tests unitarios para la clase ImageUtils.
 */
public class ImageUtilsTest {

    @Test
    @DisplayName("Obtener imagen desde InputStream válido")
    void test_getImageFromInputStream_valido() throws Exception {
        // Arrange
        byte[] imageData = new byte[]{(byte)0xFF, (byte)0xD8, (byte)0xFF}; // JPEG header
        InputStream inputStream = new ByteArrayInputStream(imageData);
        // Act
        Image result = ImageUtils.getImageFromInputStream(inputStream);
        // Assert
        assertNotNull(result);
    }

    @Test
    @DisplayName("Obtener imagen desde InputStream nulo")
    void test_getImageFromInputStream_nulo() {
        // Act
        Image result = ImageUtils.getImageFromInputStream(null);
        // Assert
        assertNull(result);
    }

    @Test
    @DisplayName("Redimensionar imagen desde URL")
    void test_getResizedImage_URL() throws Exception {
        // Arrange
        URL url = new URL("http://example.com/image.jpg");
        // Act
        Image result = ImageUtils.getResizedImage(url, 50, 50);
        // Assert
        assertNotNull(result);
    }
}
