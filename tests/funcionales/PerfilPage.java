package cat.gencat.mat.pages;
import cat.gencat.mat.BaseTest;
import org.openqa.selenium.WebElement;
import cat.gencat.mat.Utils;
import org.openqa.selenium.By;

public final class PerfilPage extends BaseTest {
  // Selectores - usar los XPATHs de ui_elements.json
  private static final By campoNombre = By.xpath("//input[@id='nombre']");
  private static final By campoEmail = By.xpath("//input[@id='email']");
  private static final By campoTelefono = By.xpath("//input[@id='telefono']");
  private static final By selectDepartamento = By.xpath("//select[@id='departamento']");
  private static final By selectCiudad = By.xpath("//select[@id='ciudad']");
  private static final By selectIdioma = By.xpath("//select[@id='idioma']");
  private static final By botonGuardarCambios = By.xpath("//button[normalize-space()='Guardar Cambios']");
  private static final By botonCancelarPerfil = By.xpath("//a[normalize-space()='Cancelar'] | //button[normalize-space()='Cancelar']");

  /**
   * Rellena el campo de nombre completo
   * @param valor Nombre completo a ingresar
   */
  public static void fillCampoNombre(String valor) {
    Utils.getElement(campoNombre).sendKeys(valor);
    Utils.anotate(Utils.LogLevel.PASS, "Campo nombre rellenado: " + valor);
  }

  /**
   * Rellena el campo de email
   * @param valor Email a ingresar
   */
  public static void fillCampoEmail(String valor) {
    Utils.getElement(campoEmail).sendKeys(valor);
    Utils.anotate(Utils.LogLevel.PASS, "Campo email rellenado: " + valor);
  }

  /**
   * Rellena el campo de teléfono
   * @param valor Teléfono a ingresar
   */
  public static void fillCampoTelefono(String valor) {
    Utils.getElement(campoTelefono).sendKeys(valor);
    Utils.anotate(Utils.LogLevel.PASS, "Campo teléfono rellenado: " + valor);
  }

  /**
   * Selecciona un departamento del dropdown
   * @param departamento Departamento a seleccionar
   */
  public static void seleccionarDepartamento(String departamento) {
    Utils.seleccionarOpcion(selectDepartamento, departamento);
    Utils.anotate(Utils.LogLevel.PASS, "Departamento seleccionado: " + departamento);
  }

  /**
   * Selecciona una ciudad del dropdown
   * @param ciudad Ciudad a seleccionar
   */
  public static void seleccionarCiudad(String ciudad) {
    Utils.seleccionarOpcion(selectCiudad, ciudad);
    Utils.anotate(Utils.LogLevel.PASS, "Ciudad seleccionada: " + ciudad);
  }

  /**
   * Selecciona un idioma del dropdown
   * @param idioma Idioma a seleccionar
   */
  public static void seleccionarIdioma(String idioma) {
    Utils.seleccionarOpcion(selectIdioma, idioma);
    Utils.anotate(Utils.LogLevel.PASS, "Idioma seleccionado: " + idioma);
  }

  /**
   * Hace clic en el botón Guardar Cambios
   */
  public static void clickBotonGuardarCambios() {
    Utils.getElement(botonGuardarCambios).click();
    Utils.anotate(Utils.LogLevel.PASS, "Botón Guardar Cambios clickeado");
  }

  /**
   * Hace clic en el botón Cancelar
   */
  public static void clickBotonCancelarPerfil() {
    Utils.getElement(botonCancelarPerfil).click();
    Utils.anotate(Utils.LogLevel.PASS, "Botón Cancelar clickeado");
  }

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
