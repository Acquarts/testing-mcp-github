package CTTI;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * Utilidades de gestion de imagenes
 * 
 * @author Accenture
 * 
 */

public class ImageUtils {
	
	/**
	 * Obtiene una Imagen a partir de un InputStream de una imagen
	 * @param imageInputStream
	 * @return Image
	 * @throws IOException 
	 */
	public static Image getImageFromInputStream(InputStream imageInputStream) {
		Image result = null;
		
		if(imageInputStream != null) {
			BufferedImage bufImage = null;
			try {
				bufImage = ImageIO.read(imageInputStream);
				result = bufImage;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	/**
	 * Obtiene una imagen reescalada en altura y anchura en funcion de un
	 * porcentaje
	 * 
	 * @param url
	 * @param propResizeWidth
	 * @param propResizeHeight
	 * @return Image
	 */
	public static Image getResizedImage(URL url, double propResizeWidth,
			double propResizeHeight) {
		Image image = Toolkit.getDefaultToolkit().getImage(url);
		return getResizedImage(image, propResizeWidth, propResizeHeight);
	}

	/**
	 * Obtiene una imagen reescalada en altura y anchura en funcion de un
	 * porcentaje
	 * 
	 * @param imagen
	 * @param propResizeWidth
	 * @param propResizeHeight
	 * @return Image
	 */
	public static Image getResizedImage(Image image, double propResizeWidth,
			double propResizeHeight) {
		return getResizedImage(new ImageIcon(image), propResizeWidth,
				propResizeHeight);
	}

	/**
	 * Obtiene una imagen reescalada en altura y anchura en funcion de un
	 * porcentaje
	 * 
	 * @param imageIcon
	 * @param propResizeWidth
	 * @param propResizeHeight
	 * @return Image
	 */
	public static Image getResizedImage(ImageIcon imageIcon,
			double propResizeWidth, double propResizeHeight) {
		Image imageScaled = imageIcon.getImage();
		if (propResizeWidth != 100 || propResizeHeight != 100) {
			int width = imageIcon.getIconWidth();
			int height = imageIcon.getIconHeight();
			int hints = Image.SCALE_SMOOTH;
			int newWidth = (int) (width * propResizeWidth / 100);
			int newHeight = (int) (height * propResizeHeight / 100);
			imageScaled = imageScaled.getScaledInstance(newWidth, newHeight,
					hints);
		}
		return imageScaled;
	}

}
