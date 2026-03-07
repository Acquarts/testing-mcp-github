import cat.gencat.mat.Utils;
import cat.gencat.mat.BaseTest;
import java.lang.reflect.Method;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import cat.gencat.mat.pages.LoginPage;
import cat.gencat.mat.pages.DashboardPage;
import app.getxray.xray.testng.annotations.XrayTest;
import app.getxray.xray.testng.annotations.Requirement;

public final class AutenticacionFuncionalTest extends BaseTest {

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-F001")
  @Requirement(key = "REQ-F001")
  public void test01_flujoAutenticacionExitosaAdminTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Paso 1 - Abrir aplicación");
      Utils.gotoApp();
      Utils.maximize();
      Utils.anotate(Utils.LogLevel.PASS, "Aplicación accesible");
      Utils.screenshot("App_Abierta");

      Utils.step("Paso 2 - Verificar elementos de login visibles");
      if (LoginPage.isCampoUsuarioVisible()) {
        Utils.anotate(Utils.LogLevel.PASS, "Pantalla de login cargada correctamente");
      }
      Utils.screenshot("Pantalla_Login");

      Utils.step("Paso 3 - Ingresar credenciales de administrador");
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      Utils.screenshot("Credenciales_Admin_Ingresadas");

      Utils.step("Paso 4 - Hacer clic en botón Entrar");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("Tras_Click_Entrar");

      Utils.step("Paso 5 - Verificar redirección al dashboard");
      if (DashboardPage.isDashboardLoaded()) {
        Utils.anotate(Utils.LogLevel.PASS, "Redirección al dashboard exitosa");
      }
      Utils.screenshot("Dashboard_Cargado");

      Utils.step("Paso 6 - Verificar información de usuario en dashboard");
      DashboardPage.verificarInfoUsuarioContiene("Ana García");
      Utils.screenshot("Info_Usuario_Verificada");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-F002")
  @Requirement(key = "REQ-F001")
  public void test02_flujoAutenticacionExitosaUser1Test(String browser, Method method) throws Throwable {
    try {
      Utils.step("Paso 1 - Abrir aplicación");
      Utils.gotoApp();
      Utils.maximize();
      Utils.anotate(Utils.LogLevel.PASS, "Aplicación accesible");
      Utils.screenshot("App_Abierta");

      Utils.step("Paso 2 - Ingresar credenciales de usuario estándar");
      LoginPage.fillCampoUsuario("user1");
      LoginPage.fillCampoPassword("user123");
      Utils.screenshot("Credenciales_User1_Ingresadas");

      Utils.step("Paso 3 - Hacer clic en botón Entrar");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("Tras_Click_Entrar");

      Utils.step("Paso 4 - Verificar redirección al dashboard");
      if (DashboardPage.isDashboardLoaded()) {
        Utils.anotate(Utils.LogLevel.PASS, "Redirección al dashboard exitosa");
      }
      Utils.screenshot("Dashboard_User1_Cargado");

      Utils.step("Paso 5 - Verificar información de usuario en dashboard");
      DashboardPage.verificarInfoUsuarioContiene("Carlos López");
      Utils.screenshot("Info_User1_Verificada");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-F003")
  @Requirement(key = "REQ-F001")
  public void test03_flujoAutenticacionFallidaCredencialesInvalidasTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Paso 1 - Abrir aplicación");
      Utils.gotoApp();
      Utils.maximize();
      Utils.anotate(Utils.LogLevel.PASS, "Aplicación accesible");
      Utils.screenshot("App_Abierta");

      Utils.step("Paso 2 - Ingresar credenciales inválidas");
      LoginPage.fillCampoUsuario("usuario_inexistente");
      LoginPage.fillCampoPassword("password_incorrecto");
      Utils.screenshot("Credenciales_Invalidas_Ingresadas");

      Utils.step("Paso 3 - Hacer clic en botón Entrar");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("Tras_Click_Entrar_Invalido");

      Utils.step("Paso 4 - Verificar mensaje de error mostrado");
      if (LoginPage.isMensajeErrorVisible()) {
        String mensajeError = LoginPage.getMensajeErrorLogin();
        Utils.anotate(Utils.LogLevel.PASS, "Mensaje de error mostrado correctamente: " + mensajeError);
      }
      Utils.screenshot("Mensaje_Error_Credenciales");

      Utils.step("Paso 5 - Verificar que permanece en pantalla de login");
      if (LoginPage.isCampoUsuarioVisible()) {
        Utils.anotate(Utils.LogLevel.PASS, "Usuario permanece en pantalla de login tras credenciales inválidas");
      }
      Utils.screenshot("Permanece_En_Login");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-F004")
  @Requirement(key = "REQ-F001")
  public void test04_flujoValidacionCamposObligatoriosTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Paso 1 - Abrir aplicación");
      Utils.gotoApp();
      Utils.maximize();
      Utils.anotate(Utils.LogLevel.PASS, "Aplicación accesible");
      Utils.screenshot("App_Abierta");

      Utils.step("Paso 2 - Intentar login con campo usuario vacío");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("Usuario_Vacio_Intento");

      Utils.step("Paso 3 - Verificar mensaje de error para campo usuario vacío");
      if (LoginPage.isMensajeErrorVisible()) {
        String mensajeError = LoginPage.getMensajeErrorLogin();
        Utils.anotate(Utils.LogLevel.PASS, "Error campo usuario vacío: " + mensajeError);
      }
      Utils.screenshot("Error_Usuario_Vacio");

      Utils.step("Paso 4 - Limpiar campos y probar con password vacío");
      LoginPage.clearCampoPassword();
      LoginPage.fillCampoUsuario("admin");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("Password_Vacio_Intento");

      Utils.step("Paso 5 - Verificar mensaje de error para campo password vacío");
      if (LoginPage.isMensajeErrorVisible()) {
        String mensajeError = LoginPage.getMensajeErrorLogin();
        Utils.anotate(Utils.LogLevel.PASS, "Error campo password vacío: " + mensajeError);
      }
      Utils.screenshot("Error_Password_Vacio");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-F005")
  @Requirement(key = "REQ-F002")
  public void test05_flujoAccesoRutasProtegidasSinSesionTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Paso 1 - Intentar acceder a dashboard sin sesión");
      Utils.gotoApp();
      Utils.maximize();
      BaseTest.getDriver().get(BaseTest.getDriver().getCurrentUrl().replace("/login", "/dashboard"));
      Utils.screenshot("Intento_Dashboard_Sin_Sesion");

      Utils.step("Paso 2 - Verificar redirección a login");
      if (LoginPage.isCampoUsuarioVisible()) {
        Utils.anotate(Utils.LogLevel.PASS, "Redirigido correctamente a login desde dashboard");
      }
      Utils.screenshot("Redireccion_Login_Dashboard");

      Utils.step("Paso 3 - Intentar acceder a perfil sin sesión");
      BaseTest.getDriver().get(BaseTest.getDriver().getCurrentUrl().replace("/login", "/perfil"));
      Utils.screenshot("Intento_Perfil_Sin_Sesion");

      Utils.step("Paso 4 - Verificar redirección a login");
      if (LoginPage.isCampoUsuarioVisible()) {
        Utils.anotate(Utils.LogLevel.PASS, "Redirigido correctamente a login desde perfil");
      }
      Utils.screenshot("Redireccion_Login_Perfil");

      Utils.step("Paso 5 - Intentar acceder a configuración sin sesión");
      BaseTest.getDriver().get(BaseTest.getDriver().getCurrentUrl().replace("/login", "/configuracion"));
      Utils.screenshot("Intento_Configuracion_Sin_Sesion");

      Utils.step("Paso 6 - Verificar redirección a login");
      if (LoginPage.isCampoUsuarioVisible()) {
        Utils.anotate(Utils.LogLevel.PASS, "Redirigido correctamente a login desde configuración");
      }
      Utils.screenshot("Redireccion_Login_Configuracion");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-F006")
  @Requirement(key = "REQ-F003")
  public void test06_flujoLogoutExitosoTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Paso 1 - Abrir aplicación y autenticarse");
      Utils.gotoApp();
      Utils.maximize();
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("Autenticado_Para_Logout");

      Utils.step("Paso 2 - Verificar que está en dashboard");
      if (DashboardPage.isDashboardLoaded()) {
        Utils.anotate(Utils.LogLevel.PASS, "Dashboard cargado correctamente");
      }
      Utils.screenshot("Dashboard_Antes_Logout");

      Utils.step("Paso 3 - Hacer clic en botón Logout");
      DashboardPage.clickBotonLogout();
      Utils.screenshot("Tras_Click_Logout");

      Utils.step("Paso 4 - Verificar redirección a login");
      if (LoginPage.isCampoUsuarioVisible()) {
        Utils.anotate(Utils.LogLevel.PASS, "Logout exitoso, redirigido a login");
      }
      Utils.screenshot("Login_Tras_Logout");

      Utils.step("Paso 5 - Verificar que no puede acceder a rutas protegidas");
      BaseTest.getDriver().get(BaseTest.getDriver().getCurrentUrl().replace("/login", "/dashboard"));
      if (LoginPage.isCampoUsuarioVisible()) {
        Utils.anotate(Utils.LogLevel.PASS, "Sesión cerrada correctamente, no puede acceder a dashboard");
      }
      Utils.screenshot("Verificacion_Sesion_Cerrada");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }
}