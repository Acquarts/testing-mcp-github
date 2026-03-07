package cat.gencat.mat.pages;
import cat.gencat.mat.BaseTest;
import org.openqa.selenium.WebElement;
import cat.gencat.mat.Utils;
import org.openqa.selenium.By;

public final class LoginPage extends BaseTest {
  // Selectores del formulario de login
  private static final By campoUsuario = By.xpath("//input[@id='username']");
  private static final By campoUsuario_ALT = By.xpath("//input[@name='username']");
  
  private static final By campoPassword = By.xpath("//input[@id='password']");
  private static final By campoPassword_ALT = By.xpath("//input[@name='password']");
  
  private static final By botonEntrar = By.xpath("//button[normalize-space()='Entrar']");
  private static final By botonEntrar_ALT = By.xpath("//button[@type='submit']");
  
  private static final By mensajeErrorLogin = By.xpath("//div[@id='error-msg']");
  private static final By mensajeErrorLogin_ALT = By.xpath("//div[contains(@class, 'alert-danger') or contains(@class, 'error')]");

  /**
   * Rellena el campo de usuario
   * @param valor Nombre de usuario a ingresar
   */
  public static void fillCampoUsuario(String valor) {
    Utils.getElement(campoUsuario).sendKeys(valor);
    Utils.anotate(Utils.LogLevel.PASS, "Campo usuario rellenado: " + valor);
  }

  /**
   * Rellena el campo de contraseña
   * @param valor Contraseña a ingresar
   */
  public static void fillCampoPassword(String valor) {
    Utils.getElement(campoPassword).sendKeys(valor);
    Utils.anotate(Utils.LogLevel.PASS, "Campo password rellenado: ****");
  }

  /**
   * Hace clic en el botón Entrar
   */
  public static void clickBotonEntrar() {
    Utils.getElement(botonEntrar).click();
    Utils.anotate(Utils.LogLevel.PASS, "Botón Entrar clickeado");
  }

  /**
   * Obtiene el texto del mensaje de error de login
   * @return Texto del mensaje de error, o null si no está presente
   */
  public static String getMensajeErrorLogin() {
    try {
      String mensaje = Utils.getElement(mensajeErrorLogin).getText();
      Utils.anotate(Utils.LogLevel.INFO, "Mensaje de error obtenido: " + mensaje);
      return mensaje;
    } catch (Exception e) {
      Utils.anotate(Utils.LogLevel.INFO, "No se encontró mensaje de error");
      return null;
    }
  }

  /**
   * Verifica si el campo usuario está visible
   * @return true si está visible, false en caso contrario
   */
  public static boolean isCampoUsuarioVisible() {
    try {
      boolean visible = Utils.getElement(campoUsuario).isDisplayed();
      Utils.anotate(Utils.LogLevel.INFO, "Campo usuario visible: " + visible);
      return visible;
    } catch (Exception e) {
      Utils.anotate(Utils.LogLevel.INFO, "Campo usuario no visible");
      return false;
    }
  }

  /**
   * Verifica si el mensaje de error está visible
   * @return true si está visible, false en caso contrario
   */
  public static boolean isMensajeErrorVisible() {
    try {
      boolean visible = Utils.getElement(mensajeErrorLogin).isDisplayed();
      Utils.anotate(Utils.LogLevel.INFO, "Mensaje de error visible: " + visible);
      return visible;
    } catch (Exception e) {
      Utils.anotate(Utils.LogLevel.INFO, "Mensaje de error no visible");
      return false;
    }
  }

  /**
   * Limpia el campo de usuario
   */
  public static void clearCampoUsuario() {
    Utils.getElement(campoUsuario).clear();
    Utils.anotate(Utils.LogLevel.PASS, "Campo usuario limpiado");
  }

  /**
   * Limpia el campo de contraseña
   */
  public static void clearCampoPassword() {
    Utils.getElement(campoPassword).clear();
    Utils.anotate(Utils.LogLevel.PASS, "Campo password limpiado");
  }
}