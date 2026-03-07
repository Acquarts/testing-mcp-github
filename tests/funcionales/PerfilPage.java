package cat.gencat.mat.pages;
import cat.gencat.mat.BaseTest;
import org.openqa.selenium.WebElement;
import cat.gencat.mat.Utils;
import org.openqa.selenium.By;
import java.util.List;

public final class PerfilPage extends BaseTest {
  // Selectores de información personal
  private static final By campoNombre = By.xpath("//input[@id='nombre']");
  private static final By campoNombre_ALT = By.xpath("//input[@name='nombre']");
  
  private static final By campoEmail = By.xpath("//input[@id='email']");
  private static final By campoEmail_ALT = By.xpath("//input[@name='email']");
  
  private static final By campoTelefono = By.xpath("//input[@id='telefono']");
  private static final By campoTelefono_ALT = By.xpath("//input[@name='telefono']");

  // Selectores de ubicación
  private static final By selectDepartamento = By.xpath("//select[@id='departamento']");
  private static final By selectDepartamento_ALT = By.xpath("//select[@name='departamento']");
  
  private static final By selectCiudad = By.xpath("//select[@id='ciudad']");
  private static final By selectCiudad_ALT = By.xpath("//select[@name='ciudad']");
  
  private static final By selectIdioma = By.xpath("//select[@id='idioma']");
  private static final By selectIdioma_ALT = By.xpath("//select[@name='idioma']");

  // Selectores de cambio de contraseña
  private static final By campoPassActual = By.xpath("//input[@id='pass_actual']");
  private static final By campoPassActual_ALT = By.xpath("//input[@name='pass_actual']");
  
  private static final By campoPassNueva = By.xpath("//input[@id='pass_nueva']");
  private static final By campoPassNueva_ALT = By.xpath("//input[@name='pass_nueva']");
  
  private static final By campoPassConfirmar = By.xpath("//input[@id='pass_confirmar']");
  private static final By campoPassConfirmar_ALT = By.xpath("//input[@name='pass_confirmar']");

  // Botones de acción
  private static final By botonGuardarCambios = By.xpath("//button[normalize-space()='Guardar Cambios']");
  private static final By botonGuardarCambios_ALT = By.xpath("//button[@type='submit' and contains(text(), 'Guardar')]");
  
  private static final By botonCancelarPerfil = By.xpath("//a[normalize-space()='Cancelar'] | //button[normalize-space()='Cancelar']");
  private static final By botonCancelarPerfil_ALT = By.xpath("//a[contains(text(), 'Cancelar')] | //button[contains(text(), 'Cancelar')]");

  /**
   * Rellena el campo de nombre
   * @param valor Nombre completo a ingresar
   */
  public static void fillCampoNombre(String valor) {
    Utils.getElement(campoNombre).clear();
    Utils.getElement(campoNombre).sendKeys(valor);
    Utils.anotate(Utils.LogLevel.PASS, "Campo nombre rellenado: " + valor);
  }

  /**
   * Rellena el campo de email
   * @param valor Email a ingresar
   */
  public static void fillCampoEmail(String valor) {
    Utils.getElement(campoEmail).clear();
    Utils.getElement(campoEmail).sendKeys(valor);
    Utils.anotate(Utils.LogLevel.PASS, "Campo email rellenado: " + valor);
  }

  /**
   * Rellena el campo de teléfono
   * @param valor Teléfono a ingresar
   */
  public static void fillCampoTelefono(String valor) {
    Utils.getElement(campoTelefono).clear();
    Utils.getElement(campoTelefono).sendKeys(valor);
    Utils.anotate(Utils.LogLevel.PASS, "Campo teléfono rellenado: " + valor);
  }

  /**
   * Selecciona un departamento del dropdown
   * @param departamento Departamento a seleccionar
   */
  public static void seleccionarDepartamento(String departamento) {
    List<WebElement> opciones = BaseTest.getDriver().findElements(By.xpath("//select[@id='departamento']/option"));
    for (WebElement opcion : opciones) {
      if (opcion.getText().equals(departamento)) {
        opcion.click();
        Utils.anotate(Utils.LogLevel.PASS, "Departamento seleccionado: " + departamento);
        return;
      }
    }
    Utils.anotate(Utils.LogLevel.WARNING, "No se encontró el departamento: " + departamento);
  }

  /**
   * Selecciona una ciudad del dropdown
   * @param ciudad Ciudad a seleccionar
   */
  public static void seleccionarCiudad(String ciudad) {
    List<WebElement> opciones = BaseTest.getDriver().findElements(By.xpath("//select[@id='ciudad']/option"));
    for (WebElement opcion : opciones) {
      if (opcion.getText().equals(ciudad)) {
        opcion.click();
        Utils.anotate(Utils.LogLevel.PASS, "Ciudad seleccionada: " + ciudad);
        return;
      }
    }
    Utils.anotate(Utils.LogLevel.WARNING, "No se encontró la ciudad: " + ciudad);
  }

  /**
   * Selecciona un idioma del dropdown
   * @param idioma Idioma a seleccionar
   */
  public static void seleccionarIdioma(String idioma) {
    List<WebElement> opciones = BaseTest.getDriver().findElements(By.xpath("//select[@id='idioma']/option"));
    for (WebElement opcion : opciones) {
      if (opcion.getText().equals(idioma)) {
        opcion.click();
        Utils.anotate(Utils.LogLevel.PASS, "Idioma seleccionado: " + idioma);
        return;
      }
    }
    Utils.anotate(Utils.LogLevel.WARNING, "No se encontró el idioma: " + idioma);
  }

  /**
   * Rellena el campo de contraseña actual
   * @param valor Contraseña actual
   */
  public static void fillCampoPassActual(String valor) {
    Utils.getElement(campoPassActual).clear();
    Utils.getElement(campoPassActual).sendKeys(valor);
    Utils.anotate(Utils.LogLevel.PASS, "Campo contraseña actual rellenado: ****");
  }

  /**
   * Rellena el campo de contraseña nueva
   * @param valor Nueva contraseña
   */
  public static void fillCampoPassNueva(String valor) {
    Utils.getElement(campoPassNueva).clear();
    Utils.getElement(campoPassNueva).sendKeys(valor);
    Utils.anotate(Utils.LogLevel.PASS, "Campo contraseña nueva rellenado: ****");
  }

  /**
   * Rellena el campo de confirmación de contraseña
   * @param valor Confirmación de contraseña
   */
  public static void fillCampoPassConfirmar(String valor) {
    Utils.getElement(campoPassConfirmar).clear();
    Utils.getElement(campoPassConfirmar).sendKeys(valor);
    Utils.anotate(Utils.LogLevel.PASS, "Campo confirmación contraseña rellenado: ****");
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
   * Obtiene el valor del campo nombre
   * @return Valor actual del campo nombre
   */
  public static String getCampoNombre() {
    try {
      String valor = Utils.getElement(campoNombre).getAttribute("value");
      Utils.anotate(Utils.LogLevel.INFO, "Valor campo nombre: " + valor);
      return valor;
    } catch (Exception e) {
      Utils.anotate(Utils.LogLevel.WARNING, "No se pudo obtener valor del campo nombre");
      return null;
    }
  }

  /**
   * Obtiene el valor del campo email
   * @return Valor actual del campo email
   */
  public static String getCampoEmail() {
    try {
      String valor = Utils.getElement(campoEmail).getAttribute("value");
      Utils.anotate(Utils.LogLevel.INFO, "Valor campo email: " + valor);
      return valor;
    } catch (Exception e) {
      Utils.anotate(Utils.LogLevel.WARNING, "No se pudo obtener valor del campo email");
      return null;
    }
  }

  /**
   * Obtiene el valor del campo teléfono
   * @return Valor actual del campo teléfono
   */
  public static String getCampoTelefono() {
    try {
      String valor = Utils.getElement(campoTelefono).getAttribute("value");
      Utils.anotate(Utils.LogLevel.INFO, "Valor campo teléfono: " + valor);
      return valor;
    } catch (Exception e) {
      Utils.anotate(Utils.LogLevel.WARNING, "No se pudo obtener valor del campo teléfono");
      return null;
    }
  }

  /**
   * Verifica si el campo nombre está visible
   * @return true si está visible, false en caso contrario
   */
  public static boolean isCampoNombreVisible() {
    try {
      boolean visible = Utils.getElement(campoNombre).isDisplayed();
      Utils.anotate(Utils.LogLevel.INFO, "Campo nombre visible: " + visible);
      return visible;
    } catch (Exception e) {
      Utils.anotate(Utils.LogLevel.INFO, "Campo nombre no visible");
      return false;
    }
  }

  /**
   * Verifica si la página de perfil está cargada
   * @return true si está cargada, false en caso contrario
   */
  public static boolean isPerfilPageLoaded() {
    try {
      String currentUrl = BaseTest.getDriver().getCurrentUrl();
      boolean loaded = currentUrl.contains("/perfil") && isCampoNombreVisible();
      Utils.anotate(Utils.LogLevel.INFO, "Página de perfil cargada: " + loaded);
      return loaded;
    } catch (Exception e) {
      Utils.anotate(Utils.LogLevel.WARNING, "Error al verificar carga de página de perfil");
      return false;
    }
  }

  /**
   * Limpia el campo de nombre
   */
  public static void clearCampoNombre() {
    Utils.getElement(campoNombre).clear();
    Utils.anotate(Utils.LogLevel.PASS, "Campo nombre limpiado");
  }

  /**
   * Limpia el campo de email
   */
  public static void clearCampoEmail() {
    Utils.getElement(campoEmail).clear();
    Utils.anotate(Utils.LogLevel.PASS, "Campo email limpiado");
  }

  /**
   * Limpia el campo de teléfono
   */
  public static void clearCampoTelefono() {
    Utils.getElement(campoTelefono).clear();
    Utils.anotate(Utils.LogLevel.PASS, "Campo teléfono limpiado");
  }

  /**
   * Verifica si el botón Guardar Cambios está habilitado
   * @return true si está habilitado, false en caso contrario
   */
  public static boolean isBotonGuardarCambiosEnabled() {
    try {
      boolean enabled = Utils.getElement(botonGuardarCambios).isEnabled();
      Utils.anotate(Utils.LogLevel.INFO, "Botón Guardar Cambios habilitado: " + enabled);
      return enabled;
    } catch (Exception e) {
      Utils.anotate(Utils.LogLevel.INFO, "Botón Guardar Cambios no disponible");
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