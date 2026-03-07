package cat.gencat.mat.pages;
import cat.gencat.mat.BaseTest;
import org.openqa.selenium.WebElement;
import cat.gencat.mat.Utils;
import org.openqa.selenium.By;
import java.util.List;

public final class ConfiguracionPage extends BaseTest {
  // Selectores de notificaciones
  private static final By checkboxNotiEmail = By.xpath("//input[@id='noti_email']");
  private static final By checkboxNotiEmail_ALT = By.xpath("//input[@name='noti_email']");
  
  private static final By checkboxNotiSms = By.xpath("//input[@id='noti_sms']");
  private static final By checkboxNotiSms_ALT = By.xpath("//input[@name='noti_sms']");

  // Selectores de tema
  private static final By radioTemaClaro = By.xpath("//input[@name='tema' and @value='claro']");
  private static final By radioTemaClaro_ALT = By.xpath("//input[@type='radio' and @value='claro']");
  
  private static final By radioTemaOscuro = By.xpath("//input[@name='tema' and @value='oscuro']");
  private static final By radioTemaOscuro_ALT = By.xpath("//input[@type='radio' and @value='oscuro']");
  
  private static final By radioTemaAuto = By.xpath("//input[@name='tema' and @value='auto']");
  private static final By radioTemaAuto_ALT = By.xpath("//input[@type='radio' and @value='auto']");

  // Selector de idioma
  private static final By selectIdioma = By.xpath("//select[@id='idioma_cfg']");
  private static final By selectIdioma_ALT = By.xpath("//select[@name='idioma_cfg']");

  // Botones de acción
  private static final By botonGuardarPreferencias = By.xpath("//button[normalize-space()='Guardar Preferencias']");
  private static final By botonGuardarPreferencias_ALT = By.xpath("//button[@type='submit' and contains(text(), 'Guardar')]");
  
  private static final By botonCancelarConfiguracion = By.xpath("//button[normalize-space()='Cancelar'] | //a[normalize-space()='Cancelar']");
  private static final By botonCancelarConfiguracion_ALT = By.xpath("//button[contains(text(), 'Cancelar')] | //a[contains(text(), 'Cancelar')]");
  
  private static final By botonEliminarCuenta = By.xpath("//button[normalize-space()='Eliminar Cuenta']");
  private static final By botonEliminarCuenta_ALT = By.xpath("//button[contains(text(), 'Eliminar Cuenta')]");

  // Mensajes
  private static final By mensajeExitoConfiguracion = By.xpath("//div[contains(@class, 'alert-success')]");
  private static final By mensajeExitoConfiguracion_ALT = By.xpath("//div[@role='alert' and contains(@class, 'success')]");
  
  private static final By mensajeErrorConfiguracion = By.xpath("//div[contains(@class, 'alert-danger') or contains(@class, 'alert-error')]");
  private static final By mensajeErrorConfiguracion_ALT = By.xpath("//div[@role='alert' and (contains(@class, 'danger') or contains(@class, 'error'))]");
  
  private static final By mensajeErrorCampoTema = By.xpath("//input[@name='tema']/following-sibling::span[contains(@class, 'error')]");
  private static final By mensajeErrorCampoTema_ALT = By.xpath("//span[@role='alert' and contains(text(), 'tema')]");
  
  private static final By mensajeErrorCampoIdioma = By.xpath("//select[@id='idioma_cfg']/following-sibling::span[contains(@class, 'error')]");
  private static final By mensajeErrorCampoIdioma_ALT = By.xpath("//span[@role='alert' and contains(text(), 'idioma')]");

  /**
   * Marca o desmarca el checkbox de notificaciones por email
   * @param marcar true para marcar, false para desmarcar
   */
  public static void setCheckboxNotiEmail(boolean marcar) {
    WebElement checkbox = Utils.getElement(checkboxNotiEmail);
    if (checkbox.isSelected() != marcar) {
      checkbox.click();
      Utils.anotate(Utils.LogLevel.PASS, "Checkbox notificaciones email " + (marcar ? "marcado" : "desmarcado"));
    } else {
      Utils.anotate(Utils.LogLevel.INFO, "Checkbox notificaciones email ya estaba " + (marcar ? "marcado" : "desmarcado"));
    }
  }

  /**
   * Marca o desmarca el checkbox de notificaciones por SMS
   * @param marcar true para marcar, false para desmarcar
   */
  public static void setCheckboxNotiSms(boolean marcar) {
    WebElement checkbox = Utils.getElement(checkboxNotiSms);
    if (checkbox.isSelected() != marcar) {
      checkbox.click();
      Utils.anotate(Utils.LogLevel.PASS, "Checkbox notificaciones SMS " + (marcar ? "marcado" : "desmarcado"));
    } else {
      Utils.anotate(Utils.LogLevel.INFO, "Checkbox notificaciones SMS ya estaba " + (marcar ? "marcado" : "desmarcado"));
    }
  }

  /**
   * Selecciona el tema Claro
   */
  public static void clickRadioTemaClaro() {
    Utils.getElement(radioTemaClaro).click();
    Utils.anotate(Utils.LogLevel.PASS, "Tema Claro seleccionado");
  }

  /**
   * Selecciona el tema Oscuro
   */
  public static void clickRadioTemaOscuro() {
    Utils.getElement(radioTemaOscuro).click();
    Utils.anotate(Utils.LogLevel.PASS, "Tema Oscuro seleccionado");
  }

  /**
   * Selecciona el tema Automático
   */
  public static void clickRadioTemaAuto() {
    Utils.getElement(radioTemaAuto).click();
    Utils.anotate(Utils.LogLevel.PASS, "Tema Automático seleccionado");
  }

  /**
   * Selecciona un idioma del dropdown
   * @param idioma Idioma a seleccionar (Español, Inglés, Francés, Alemán, Portugués)
   */
  public static void seleccionarIdioma(String idioma) {
    List<WebElement> opciones = BaseTest.getDriver().findElements(By.xpath("//select[@id='idioma_cfg']/option"));
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
   * Hace clic en el botón Guardar Preferencias
   */
  public static void clickBotonGuardarPreferencias() {
    Utils.getElement(botonGuardarPreferencias).click();
    Utils.anotate(Utils.LogLevel.PASS, "Botón Guardar Preferencias clickeado");
  }

  /**
   * Hace clic en el botón Cancelar
   */
  public static void clickBotonCancelarConfiguracion() {
    Utils.getElement(botonCancelarConfiguracion).click();
    Utils.anotate(Utils.LogLevel.PASS, "Botón Cancelar clickeado");
  }

  /**
   * Hace clic en el botón Eliminar Cuenta (placeholder)
   */
  public static void clickBotonEliminarCuenta() {
    Utils.getElement(botonEliminarCuenta).click();
    Utils.anotate(Utils.LogLevel.PASS, "Botón Eliminar Cuenta clickeado (placeholder)");
  }

  /**
   * Verifica si el checkbox de notificaciones email está visible
   * @return true si está visible, false en caso contrario
   */
  public static boolean isCheckboxNotiEmailVisible() {
    try {
      boolean visible = Utils.getElement(checkboxNotiEmail).isDisplayed();
      Utils.anotate(Utils.LogLevel.INFO, "Checkbox notificaciones email visible: " + visible);
      return visible;
    } catch (Exception e) {
      Utils.anotate(Utils.LogLevel.INFO, "Checkbox notificaciones email no visible");
      return false;
    }
  }

  /**
   * Obtiene el texto del mensaje de éxito
   * @return Texto del mensaje de éxito, o null si no está presente
   */
  public static String getMensajeExitoConfiguracion() {
    try {
      String mensaje = Utils.getElement(mensajeExitoConfiguracion).getText();
      Utils.anotate(Utils.LogLevel.INFO, "Mensaje de éxito obtenido: " + mensaje);
      return mensaje;
    } catch (Exception e) {
      Utils.anotate(Utils.LogLevel.INFO, "No se encontró mensaje de éxito");
      return null;
    }
  }

  /**
   * Obtiene el texto del mensaje de error general
   * @return Texto del mensaje de error, o null si no está presente
   */
  public static String getMensajeErrorConfiguracion() {
    try {
      String mensaje = Utils.getElement(mensajeErrorConfiguracion).getText();
      Utils.anotate(Utils.LogLevel.INFO, "Mensaje de error obtenido: " + mensaje);
      return mensaje;
    } catch (Exception e) {
      Utils.anotate(Utils.LogLevel.INFO, "No se encontró mensaje de error");
      return null;
    }
  }

  /**
   * Obtiene el texto del mensaje de error del campo tema
   * @return Texto del mensaje de error, o null si no está presente
   */
  public static String getMensajeErrorCampoTema() {
    try {
      String mensaje = Utils.getElement(mensajeErrorCampoTema).getText();
      Utils.anotate(Utils.LogLevel.INFO, "Mensaje de error campo tema obtenido: " + mensaje);
      return mensaje;
    } catch (Exception e) {
      Utils.anotate(Utils.LogLevel.INFO, "No se encontró mensaje de error campo tema");
      return null;
    }
  }

  /**
   * Obtiene el texto del mensaje de error del campo idioma
   * @return Texto del mensaje de error, o null si no está presente
   */
  public static String getMensajeErrorCampoIdioma() {
    try {
      String mensaje = Utils.getElement(mensajeErrorCampoIdioma).getText();
      Utils.anotate(Utils.LogLevel.INFO, "Mensaje de error campo idioma obtenido: " + mensaje);
      return mensaje;
    } catch (Exception e) {
      Utils.anotate(Utils.LogLevel.INFO, "No se encontró mensaje de error campo idioma");
      return null;
    }
  }

  /**
   * Verifica si el botón Eliminar Cuenta está visible
   * @return true si está visible, false en caso contrario
   */
  public static boolean isBotonEliminarCuentaVisible() {
    try {
      boolean visible = Utils.getElement(botonEliminarCuenta).isDisplayed();
      Utils.anotate(Utils.LogLevel.INFO, "Botón Eliminar Cuenta visible: " + visible);
      return visible;
    } catch (Exception e) {
      Utils.anotate(Utils.LogLevel.INFO, "Botón Eliminar Cuenta no visible");
      return false;
    }
  }
}