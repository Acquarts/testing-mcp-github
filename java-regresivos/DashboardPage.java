package cat.gencat.mat.pages;
import cat.gencat.mat.BaseTest;
import org.openqa.selenium.WebElement;
import cat.gencat.mat.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public final class DashboardPage extends BaseTest {
  // Selectores de navegación
  private static final By botonEditarPerfil = By.xpath("//a[normalize-space()='Perfil'] | //button[normalize-space()='Perfil']");
  private static final By botonEditarPerfil_ALT = By.xpath("//a[contains(text(), 'Perfil')] | //button[contains(text(), 'Perfil')]");
  
  private static final By botonConfiguracion = By.xpath("//a[normalize-space()='Configuración'] | //button[normalize-space()='Configuración']");
  private static final By botonConfiguracion_ALT = By.xpath("//a[contains(text(), 'Configuración')] | //button[contains(text(), 'Configuración')]");
  
  private static final By botonLogout = By.xpath("//a[normalize-space()='Logout'] | //button[normalize-space()='Logout']");
  private static final By botonLogout_ALT = By.xpath("//a[contains(text(), 'Logout')] | //button[contains(text(), 'Logout')]");

  // Selectores de búsqueda
  private static final By selectCategoriaBusqueda = By.xpath("//select[@id='cat']");
  private static final By selectCategoriaBusqueda_ALT = By.xpath("//select[@name='cat']");
  
  private static final By campoBusqueda = By.xpath("//input[@id='q']");
  private static final By campoBusqueda_ALT = By.xpath("//input[@name='q']");
  
  private static final By botonBuscar = By.xpath("//button[normalize-space()='Buscar']");
  private static final By botonBuscar_ALT = By.xpath("//button[contains(text(), 'Buscar')]");

  // Selectores de información de usuario
  private static final By infoUsuarioDashboard = By.xpath("//div[contains(@class, 'user-info') or contains(@class, 'usuario-info')]");
  private static final By infoUsuarioDashboard_ALT = By.xpath("//div[contains(text(), 'Nombre:') or contains(text(), 'Email:')]");

  // Selectores de indicador de carga
  private static final By indicadorCargaGlobal = By.xpath("//div[contains(@class, 'spinner') or contains(@class, 'loading')]");
  private static final By indicadorCargaGlobal_ALT = By.xpath("//div[@aria-busy='true']");

  /**
   * Hace clic en el botón Editar Perfil
   */
  public static void clickBotonEditarPerfil() {
    Utils.getElement(botonEditarPerfil).click();
    Utils.anotate(Utils.LogLevel.PASS, "Botón Editar Perfil clickeado");
  }

  /**
   * Hace clic en el botón Configuración
   */
  public static void clickBotonConfiguracion() {
    Utils.getElement(botonConfiguracion).click();
    Utils.anotate(Utils.LogLevel.PASS, "Botón Configuración clickeado");
  }

  /**
   * Hace clic en el botón Logout
   */
  public static void clickBotonLogout() {
    Utils.getElement(botonLogout).click();
    Utils.anotate(Utils.LogLevel.PASS, "Botón Logout clickeado");
  }

  /**
   * Selecciona una categoría de búsqueda
   * @param categoria Categoría a seleccionar (Todos, Nombre, Email, Departamento)
   */
  public static void seleccionarCategoriaBusqueda(String categoria) {
    List<WebElement> opciones = BaseTest.getDriver().findElements(By.xpath("//select[@id='cat']/option"));
    for (WebElement opcion : opciones) {
      if (opcion.getText().equals(categoria)) {
        opcion.click();
        Utils.anotate(Utils.LogLevel.PASS, "Categoría seleccionada: " + categoria);
        return;
      }
    }
    Utils.anotate(Utils.LogLevel.WARNING, "No se encontró la categoría: " + categoria);
  }

  /**
   * Ingresa un término de búsqueda
   * @param termino Término a buscar
   */
  public static void fillCampoBusqueda(String termino) {
    Utils.getElement(campoBusqueda).sendKeys(termino);
    Utils.anotate(Utils.LogLevel.PASS, "Término de búsqueda ingresado: " + termino);
  }

  /**
   * Hace clic en el botón Buscar
   */
  public static void clickBotonBuscar() {
    Utils.getElement(botonBuscar).click();
    Utils.anotate(Utils.LogLevel.PASS, "Botón Buscar clickeado");
  }

  /**
   * Obtiene el texto de la información del usuario en el dashboard
   * @return Texto con la información del usuario
   */
  public static String getInfoUsuarioDashboard() {
    try {
      String info = Utils.getElement(infoUsuarioDashboard).getText();
      Utils.anotate(Utils.LogLevel.INFO, "Información de usuario obtenida: " + info);
      return info;
    } catch (Exception e) {
      Utils.anotate(Utils.LogLevel.WARNING, "No se pudo obtener información de usuario");
      return null;
    }
  }

  /**
   * Verifica si la información del usuario contiene un texto específico
   * @param textoEsperado Texto a verificar
   * @return true si contiene el texto, false en caso contrario
   */
  public static boolean verificarInfoUsuarioContiene(String textoEsperado) {
    String info = getInfoUsuarioDashboard();
    if (info != null && info.contains(textoEsperado)) {
      Utils.anotate(Utils.LogLevel.PASS, "Información de usuario contiene: " + textoEsperado);
      return true;
    } else {
      Utils.anotate(Utils.LogLevel.WARNING, "Información de usuario NO contiene: " + textoEsperado);
      return false;
    }
  }

  /**
   * Verifica si el indicador de carga está visible
   * @return true si está visible, false en caso contrario
   */
  public static boolean isIndicadorCargaVisible() {
    try {
      boolean visible = Utils.getElement(indicadorCargaGlobal).isDisplayed();
      Utils.anotate(Utils.LogLevel.INFO, "Indicador de carga visible: " + visible);
      return visible;
    } catch (Exception e) {
      Utils.anotate(Utils.LogLevel.INFO, "Indicador de carga no visible");
      return false;
    }
  }

  /**
   * Espera a que el indicador de carga desaparezca
   * @param timeoutSeconds Tiempo máximo de espera en segundos
   */
  public static void waitForLoadingToDisappear(int timeoutSeconds) {
    try {
      WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(timeoutSeconds));
      wait.until(ExpectedConditions.invisibilityOfElementLocated(indicadorCargaGlobal));
      Utils.anotate(Utils.LogLevel.PASS, "Indicador de carga desapareció");
    } catch (Exception e) {
      Utils.anotate(Utils.LogLevel.INFO, "Indicador de carga no apareció o ya desapareció");
    }
  }

  /**
   * Limpia el campo de búsqueda
   */
  public static void clearCampoBusqueda() {
    Utils.getElement(campoBusqueda).clear();
    Utils.anotate(Utils.LogLevel.PASS, "Campo de búsqueda limpiado");
  }
}
