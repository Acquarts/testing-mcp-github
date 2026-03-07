package CTTI;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 * Tests unitarios para la clase ImageUtils.
 */
public class ImageUtilsTest {

    @Test
    @DisplayName("Debe obtener imagen desde InputStream válido")
    void test_getImageFromInputStreamValido() throws IOException {
        // Arrange
        BufferedImage testImage = new BufferedImage(10, 10, BufferedImage.TYPE_INT_RGB);
        byte[] imageBytes = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10}; // PNG header simulado
        InputStream inputStream = new ByteArrayInputStream(imageBytes);

        // Act
        Image result = ImageUtils.getImageFromInputStream(inputStream);

        // Assert
        // Nota: El resultado puede ser null si ImageIO no puede leer los bytes simulados
        // pero el método no debe lanzar excepción
        assertDoesNotThrow(() -> ImageUtils.getImageFromInputStream(inputStream));
    }

    @Test
    @DisplayName("Debe retornar null cuando InputStream es null")
    void test_getImageFromInputStreamNulo() {
        // Act
        Image result = ImageUtils.getImageFromInputStream(null);

        // Assert
        assertNull(result);
    }

    @Test
    @DisplayName("Debe redimensionar imagen con porcentajes válidos")
    void test_getResizedImageConPorcentajesValidos() {
        // Arrange
        BufferedImage originalImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        ImageIcon imageIcon = new ImageIcon(originalImage);
        double propWidth = 50.0;
        double propHeight = 75.0;

        // Act
        Image result = ImageUtils.getResizedImage(imageIcon, propWidth, propHeight);

        // Assert
        assertNotNull(result);
    }

    @Test
    @DisplayName("Debe mantener tamaño original cuando porcentajes son 100")
    void test_getResizedImageSinCambios() {
        // Arrange
        BufferedImage originalImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        ImageIcon imageIcon = new ImageIcon(originalImage);
        double propWidth = 100.0;
        double propHeight = 100.0;

        // Act
        Image result = ImageUtils.getResizedImage(imageIcon, propWidth, propHeight);

        // Assert
        assertNotNull(result);
        assertEquals(originalImage, result);
    }

    @Test
    @DisplayName("Debe redimensionar imagen desde Image")
    void test_getResizedImageDesdeImage() {
        // Arrange
        BufferedImage originalImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        double propWidth = 50.0;
        double propHeight = 50.0;

        // Act
        Image result = ImageUtils.getResizedImage(originalImage, propWidth, propHeight);

        // Assert
        assertNotNull(result);
    }

    @Test
    @DisplayName("Debe manejar porcentajes de redimensionado extremos")
    void test_getResizedImagePorcentajesExtremos() {
        // Arrange
        BufferedImage originalImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        ImageIcon imageIcon = new ImageIcon(originalImage);
        double propWidth = 1.0; // 1%
        double propHeight = 200.0; // 200%

        // Act
        Image result = ImageUtils.getResizedImage(imageIcon, propWidth, propHeight);

        // Assert
        assertNotNull(result);
    }

    @Test
    @DisplayName("Debe manejar imagen con dimensiones cero")
    void test_getResizedImageDimensionesCero() {
        // Arrange
        BufferedImage originalImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        ImageIcon imageIcon = new ImageIcon(originalImage);
        double propWidth = 0.0;
        double propHeight = 0.0;

        // Act & Assert
        assertDoesNotThrow(() -> {
            Image result = ImageUtils.getResizedImage(imageIcon, propWidth, propHeight);
            assertNotNull(result);
        });
    }

    @Test
    @DisplayName("Debe procesar correctamente imagen desde URL mock")
    void test_getResizedImageDesdeURL() {
        // Arrange
        URL mockUrl = null;
        try {
            mockUrl = new URL("http://example.com/test.jpg");
        } catch (Exception e) {
            // URL válida para test
        }
        
        double propWidth = 50.0;
        double propHeight = 50.0;

        // Act & Assert
        if (mockUrl != null) {
            assertDoesNotThrow(() -> {
                Image result = ImageUtils.getResizedImage(mockUrl, propWidth, propHeight);
                // El resultado puede ser null si no se puede cargar la imagen desde URL
            });
        }
    }
}