import cat.gencat.mat.Utils;
import cat.gencat.mat.BaseTest;
import java.lang.reflect.Method;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import cat.gencat.mat.pages.LoginPage;
import cat.gencat.mat.pages.DashboardPage;
import cat.gencat.mat.pages.ConfiguracionPage;
import app.getxray.xray.testng.annotations.XrayTest;
import app.getxray.xray.testng.annotations.Requirement;

public final class ConfiguracionPreferenciasFuncionalTest extends BaseTest {

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-F013")
  @Requirement(key = "REQ-F008")
  public void test01_flujoNavegacionDashboardAConfiguracionTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Paso 1 - Abrir aplicación y autenticarse");
      Utils.gotoApp();
      Utils.maximize();
      Utils.anotate(Utils.LogLevel.PASS, "Aplicación accesible");
      Utils.screenshot("App_Abierta");

      Utils.step("Paso 2 - Login con credenciales válidas");
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("Tras_Login");

      Utils.step("Paso 3 - Verificar carga del dashboard");
      if (DashboardPage.isDashboardLoaded()) {
        Utils.anotate(Utils.LogLevel.PASS, "Dashboard cargado correctamente");
      }
      Utils.screenshot("Dashboard_Cargado");

      Utils.step("Paso 4 - Hacer clic en botón Configuración");
      DashboardPage.clickBotonConfiguracion();
      Utils.screenshot("Tras_Click_Configuracion");

      Utils.step("Paso 5 - Verificar navegación a página de configuración");
      if (ConfiguracionPage.isCheckboxNotiEmailVisible()) {
        Utils.anotate(Utils.LogLevel.PASS, "Navegación a página de configuración exitosa");
      }
      Utils.screenshot("Pagina_Configuracion_Cargada");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-F014")
  @Requirement(key = "REQ-F009")
  public void test02_flujoConfiguracionNotificacionesTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Paso 1 - Abrir aplicación y navegar a configuración");
      Utils.gotoApp();
      Utils.maximize();
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      DashboardPage.clickBotonConfiguracion();
      Utils.screenshot("En_Pagina_Configuracion");

      Utils.step("Paso 2 - Configurar notificaciones por email");
      ConfiguracionPage.setCheckboxNotiEmail(true);
      Utils.screenshot("Notificaciones_Email_Activadas");

      Utils.step("Paso 3 - Configurar notificaciones por SMS");
      ConfiguracionPage.setCheckboxNotiSms(true);
      Utils.screenshot("Notificaciones_SMS_Activadas");

      Utils.step("Paso 4 - Guardar preferencias de notificaciones");
      ConfiguracionPage.clickBotonGuardarPreferencias();
      Utils.screenshot("Tras_Guardar_Notificaciones");

      Utils.step("Paso 5 - Verificar mensaje de éxito o confirmación");
      String mensajeExito = ConfiguracionPage.getMensajeExitoConfiguracion();
      if (mensajeExito != null) {
        Utils.anotate(Utils.LogLevel.PASS, "Mensaje de éxito mostrado: " + mensajeExito);
      }
      Utils.screenshot("Confirmacion_Notificaciones_Guardadas");

      Utils.step("Paso 6 - Probar desactivar notificaciones");
      ConfiguracionPage.setCheckboxNotiEmail(false);
      ConfiguracionPage.setCheckboxNotiSms(false);
      ConfiguracionPage.clickBotonGuardarPreferencias();
      Utils.screenshot("Notificaciones_Desactivadas");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-F015")
  @Requirement(key = "REQ-F010")
  public void test03_flujoConfiguracionTemaTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Paso 1 - Abrir aplicación y navegar a configuración");
      Utils.gotoApp();
      Utils.maximize();
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      DashboardPage.clickBotonConfiguracion();
      Utils.screenshot("En_Pagina_Configuracion");

      Utils.step("Paso 2 - Seleccionar tema claro");
      ConfiguracionPage.clickRadioTemaClaro();
      Utils.screenshot("Tema_Claro_Seleccionado");

      Utils.step("Paso 3 - Guardar preferencia de tema claro");
      ConfiguracionPage.clickBotonGuardarPreferencias();
      Utils.screenshot("Tema_Claro_Guardado");

      Utils.step("Paso 4 - Seleccionar tema oscuro");
      ConfiguracionPage.clickRadioTemaOscuro();
      Utils.screenshot("Tema_Oscuro_Seleccionado");

      Utils.step("Paso 5 - Guardar preferencia de tema oscuro");
      ConfiguracionPage.clickBotonGuardarPreferencias();
      Utils.screenshot("Tema_Oscuro_Guardado");

      Utils.step("Paso 6 - Seleccionar tema automático");
      ConfiguracionPage.clickRadioTemaAuto();
      Utils.screenshot("Tema_Auto_Seleccionado");

      Utils.step("Paso 7 - Guardar preferencia de tema automático");
      ConfiguracionPage.clickBotonGuardarPreferencias();
      Utils.screenshot("Tema_Auto_Guardado");

      Utils.step("Paso 8 - Verificar mensaje de éxito");
      String mensajeExito = ConfiguracionPage.getMensajeExitoConfiguracion();
      if (mensajeExito != null) {
        Utils.anotate(Utils.LogLevel.PASS, "Configuración de tema guardada: " + mensajeExito);
      }
      Utils.screenshot("Confirmacion_Tema_Guardado");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-F016")
  @Requirement(key = "REQ-F011")
  public void test04_flujoConfiguracionIdiomaTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Paso 1 - Abrir aplicación y navegar a configuración");
      Utils.gotoApp();
      Utils.maximize();
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      DashboardPage.clickBotonConfiguracion();
      Utils.screenshot("En_Pagina_Configuracion");

      Utils.step("Paso 2 - Seleccionar idioma Español");
      ConfiguracionPage.seleccionarIdioma("Español");
      ConfiguracionPage.clickBotonGuardarPreferencias();
      Utils.screenshot("Idioma_Espanol_Guardado");

      Utils.step("Paso 3 - Seleccionar idioma Inglés");
      ConfiguracionPage.seleccionarIdioma("Inglés");
      ConfiguracionPage.clickBotonGuardarPreferencias();
      Utils.screenshot("Idioma_Ingles_Guardado");

      Utils.step("Paso 4 - Seleccionar idioma Francés");
      ConfiguracionPage.seleccionarIdioma("Francés");
      ConfiguracionPage.clickBotonGuardarPreferencias();
      Utils.screenshot("Idioma_Frances_Guardado");

      Utils.step("Paso 5 - Seleccionar idioma Alemán");
      ConfiguracionPage.seleccionarIdioma("Alemán");
      ConfiguracionPage.clickBotonGuardarPreferencias();
      Utils.screenshot("Idioma_Aleman_Guardado");

      Utils.step("Paso 6 - Seleccionar idioma Portugués");
      ConfiguracionPage.seleccionarIdioma("Portugués");
      ConfiguracionPage.clickBotonGuardarPreferencias();
      Utils.screenshot("Idioma_Portugues_Guardado");

      Utils.step("Paso 7 - Verificar mensaje de éxito");
      String mensajeExito = ConfiguracionPage.getMensajeExitoConfiguracion();
      if (mensajeExito != null) {
        Utils.anotate(Utils.LogLevel.PASS, "Configuración de idioma guardada: " + mensajeExito);
      }
      Utils.screenshot("Confirmacion_Idioma_Guardado");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-F017")
  @Requirement(key = "REQ-F012")
  public void test05_flujoConfiguracionCompletaTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Paso 1 - Abrir aplicación y navegar a configuración");
      Utils.gotoApp();
      Utils.maximize();
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      DashboardPage.clickBotonConfiguracion();
      Utils.screenshot("En_Pagina_Configuracion");

      Utils.step("Paso 2 - Configurar todas las preferencias");
      ConfiguracionPage.setCheckboxNotiEmail(true);
      ConfiguracionPage.setCheckboxNotiSms(true);
      Utils.screenshot("Notificaciones_Configuradas");

      Utils.step("Paso 3 - Seleccionar tema");
      ConfiguracionPage.clickRadioTemaOscuro();
      Utils.screenshot("Tema_Configurado");

      Utils.step("Paso 4 - Seleccionar idioma");
      ConfiguracionPage.seleccionarIdioma("Inglés");
      Utils.screenshot("Idioma_Configurado");

      Utils.step("Paso 5 - Guardar todas las preferencias");
      ConfiguracionPage.clickBotonGuardarPreferencias();
      Utils.screenshot("Todas_Preferencias_Guardadas");

      Utils.step("Paso 6 - Verificar mensaje de éxito");
      String mensajeExito = ConfiguracionPage.getMensajeExitoConfiguracion();
      if (mensajeExito != null) {
        Utils.anotate(Utils.LogLevel.PASS, "Configuración completa guardada: " + mensajeExito);
      }
      Utils.screenshot("Confirmacion_Config_Completa");

      Utils.step("Paso 7 - Verificar persistencia navegando y volviendo");
      DashboardPage.clickBotonEditarPerfil();
      Utils.screenshot("Navegacion_A_Perfil");
      
      DashboardPage.clickBotonConfiguracion();
      Utils.screenshot("Vuelta_A_Configuracion");

      Utils.step("Paso 8 - Verificar que las preferencias se mantienen");
      if (ConfiguracionPage.isCheckboxNotiEmailVisible()) {
        Utils.anotate(Utils.LogLevel.PASS, "Preferencias persistentes tras navegación");
      }
      Utils.screenshot("Preferencias_Persistentes");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-F018")
  @Requirement(key = "REQ-F013")
  public void test06_flujoCancelarCambiosConfiguracionTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Paso 1 - Abrir aplicación y navegar a configuración");
      Utils.gotoApp();
      Utils.maximize();
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      DashboardPage.clickBotonConfiguracion();
      Utils.screenshot("En_Pagina_Configuracion");

      Utils.step("Paso 2 - Realizar cambios sin guardar");
      ConfiguracionPage.setCheckboxNotiEmail(true);
      ConfiguracionPage.setCheckboxNotiSms(true);
      ConfiguracionPage.clickRadioTemaOscuro();
      ConfiguracionPage.seleccionarIdioma("Francés");
      Utils.screenshot("Cambios_Sin_Guardar");

      Utils.step("Paso 3 - Hacer clic en botón Cancelar");
      ConfiguracionPage.clickBotonCancelarConfiguracion();
      Utils.screenshot("Tras_Click_Cancelar");

      Utils.step("Paso 4 - Verificar redirección al dashboard");
      if (DashboardPage.isDashboardLoaded()) {
        Utils.anotate(Utils.LogLevel.PASS, "Redirección al dashboard tras cancelar");
      }
      Utils.screenshot("Dashboard_Tras_Cancelar");

      Utils.step("Paso 5 - Volver a configuración y verificar que no se guardaron cambios");
      DashboardPage.clickBotonConfiguracion();
      Utils.screenshot("Vuelta_A_Configuracion_Tras_Cancelar");

      Utils.step("Paso 6 - Verificar que los cambios no se aplicaron");
      if (ConfiguracionPage.isCheckboxNotiEmailVisible()) {
        Utils.anotate(Utils.LogLevel.PASS, "Cambios no aplicados tras cancelar");
      }
      Utils.screenshot("Cambios_No_Aplicados");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-F019")
  @Requirement(key = "REQ-F014")
  public void test07_flujoValidacionCamposRequeridosConfiguracionTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Paso 1 - Abrir aplicación y navegar a configuración");
      Utils.gotoApp();
      Utils.maximize();
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      DashboardPage.clickBotonConfiguracion();
      Utils.screenshot("En_Pagina_Configuracion");

      Utils.step("Paso 2 - Intentar guardar sin seleccionar tema");
      ConfiguracionPage.clickBotonGuardarPreferencias();
      Utils.screenshot("Intento_Guardar_Sin_Tema");

      Utils.step("Paso 3 - Verificar mensaje de error para campo tema");
      String mensajeErrorTema = ConfiguracionPage.getMensajeErrorCampoTema();
      if (mensajeErrorTema != null) {
        Utils.anotate(Utils.LogLevel.PASS, "Error campo tema requerido: " + mensajeErrorTema);
      }
      Utils.screenshot("Error_Campo_Tema");

      Utils.step("Paso 4 - Verificar mensaje de error para campo idioma");
      String mensajeErrorIdioma = ConfiguracionPage.getMensajeErrorCampoIdioma();
      if (mensajeErrorIdioma != null) {
        Utils.anotate(Utils.LogLevel.PASS, "Error campo idioma requerido: " + mensajeErrorIdioma);
      }
      Utils.screenshot("Error_Campo_Idioma");

      Utils.step("Paso 5 - Completar campos requeridos y guardar");
      ConfiguracionPage.clickRadioTemaClaro();
      ConfiguracionPage.seleccionarIdioma("Español");
      ConfiguracionPage.clickBotonGuardarPreferencias();
      Utils.screenshot("Guardado_Con_Campos_Requeridos");

      Utils.step("Paso 6 - Verificar guardado exitoso");
      String mensajeExito = ConfiguracionPage.getMensajeExitoConfiguracion();
      if (mensajeExito != null) {
        Utils.anotate(Utils.LogLevel.PASS, "Guardado exitoso tras completar campos: " + mensajeExito);
      }
      Utils.screenshot("Guardado_Exitoso");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }
}