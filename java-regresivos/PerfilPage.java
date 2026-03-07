package cat.gencat.mat.pages;
import cat.gencat.mat.BaseTest;
import org.openqa.selenium.WebElement;
import cat.gencat.mat.Utils;
import org.openqa.selenium.By;

public final class PerfilPage extends BaseTest {
  // Nota: Los selectores específicos de /perfil no están detallados en 02_ui_selectors.json
  // Esta clase se crea como placeholder para navegación desde dashboard
  // Los selectores deberán ser completados cuando se proporcione ui_elements.json para /perfil

  /**
   * Verifica si la página de perfil está cargada
   * @return true si está cargada, false en caso contrario
   */
  public static boolean isPerfilPageLoaded() {
    try {
      // Verificar URL contiene /perfil
      String currentUrl = BaseTest.getDriver().getCurrentUrl();
      boolean loaded = currentUrl.contains("/perfil");
      Utils.anotate(Utils.LogLevel.INFO, "Página de perfil cargada: " + loaded);
      return loaded;
    } catch (Exception e) {
      Utils.anotate(Utils.LogLevel.WARNING, "Error al verificar carga de página de perfil");
      return false;
    }
  }

  /**
   * Obtiene la URL actual
   * @return URL actual
   */
  public static String getCurrentUrl() {
    String url = BaseTest.getDriver().getCurrentUrl();
    Utils.anotate(Utils.LogLevel.INFO, "URL actual: " + url);
    return url;
  }
}
