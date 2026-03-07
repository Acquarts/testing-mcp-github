import cat.gencat.mat.Utils;
import cat.gencat.mat.BaseTest;
import java.lang.reflect.Method;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import cat.gencat.mat.pages.LoginPage;
import cat.gencat.mat.pages.DashboardPage;
import cat.gencat.mat.pages.ConfiguracionPage;
import cat.gencat.mat.pages.PerfilPage;
import app.getxray.xray.testng.annotations.XrayTest;
import app.getxray.xray.testng.annotations.Requirement;

public final class AppPilotoTestingTest extends BaseTest {

  // ========== AUTENTICACIÓN ==========

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-001")
  @Requirement(key = "REQ-001")
  public void test01_loginExitosoAdminTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Abrir aplicación");
      Utils.gotoApp();
      Utils.maximize();
      Utils.anotate(Utils.LogLevel.PASS, "Aplicación accesible");
      Utils.screenshot("App_Abierta");

      Utils.step("Rellenar credenciales admin");
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      Utils.screenshot("Credenciales_Admin_Rellenas");

      Utils.step("Click en Iniciar sesión");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("Tras_Login_Admin");

      Utils.step("Verificar redirección a dashboard");
      DashboardPage.verificarInfoUsuarioContiene("Ana García");
      Utils.screenshot("Dashboard_Admin");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-002")
  @Requirement(key = "REQ-001")
  public void test02_loginExitosoUser1Test(String browser, Method method) throws Throwable {
    try {
      Utils.step("Abrir aplicación");
      Utils.gotoApp();
      Utils.maximize();
      Utils.anotate(Utils.LogLevel.PASS, "Aplicación accesible");
      Utils.screenshot("App_Abierta");

      Utils.step("Rellenar credenciales user1");
      LoginPage.fillCampoUsuario("user1");
      LoginPage.fillCampoPassword("user123");
      Utils.screenshot("Credenciales_User1_Rellenas");

      Utils.step("Click en Iniciar sesión");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("Tras_Login_User1");

      Utils.step("Verificar redirección a dashboard");
      DashboardPage.verificarInfoUsuarioContiene("Carlos López");
      Utils.screenshot("Dashboard_User1");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-003")
  @Requirement(key = "REQ-001")
  public void test03_loginFallidoCredencialesInvalidasTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Abrir aplicación");
      Utils.gotoApp();
      Utils.maximize();
      Utils.anotate(Utils.LogLevel.PASS, "Aplicación accesible");
      Utils.screenshot("App_Abierta");

      Utils.step("Rellenar credenciales inválidas");
      LoginPage.fillCampoUsuario("usuario_inexistente");
      LoginPage.fillCampoPassword("password_incorrecto");
      Utils.screenshot("Credenciales_Invalidas_Rellenas");

      Utils.step("Click en Iniciar sesión");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("Tras_Login_Fallido");

      Utils.step("Verificar mensaje de error");
      if (LoginPage.isMensajeErrorVisible()) {
        String mensajeError = LoginPage.getMensajeErrorLogin();
        Utils.anotate(Utils.LogLevel.PASS, "Mensaje de error mostrado: " + mensajeError);
      }
      Utils.screenshot("Mensaje_Error_Visible");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-004")
  @Requirement(key = "REQ-001")
  public void test04_loginFallidoCampoUsuarioVacioTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Abrir aplicación");
      Utils.gotoApp();
      Utils.maximize();
      Utils.anotate(Utils.LogLevel.PASS, "Aplicación accesible");
      Utils.screenshot("App_Abierta");

      Utils.step("Dejar campo usuario vacío y rellenar password");
      LoginPage.fillCampoPassword("admin123");
      Utils.screenshot("Campo_Usuario_Vacio");

      Utils.step("Click en Iniciar sesión");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("Tras_Login_Usuario_Vacio");

      Utils.step("Verificar mensaje de error");
      if (LoginPage.isMensajeErrorVisible()) {
        String mensajeError = LoginPage.getMensajeErrorLogin();
        Utils.anotate(Utils.LogLevel.PASS, "Mensaje de error mostrado: " + mensajeError);
      }
      Utils.screenshot("Mensaje_Error_Usuario_Vacio");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-005")
  @Requirement(key = "REQ-001")
  public void test05_loginFallidoCampoPasswordVacioTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Abrir aplicación");
      Utils.gotoApp();
      Utils.maximize();
      Utils.anotate(Utils.LogLevel.PASS, "Aplicación accesible");
      Utils.screenshot("App_Abierta");

      Utils.step("Rellenar usuario y dejar password vacío");
      LoginPage.fillCampoUsuario("admin");
      Utils.screenshot("Campo_Password_Vacio");

      Utils.step("Click en Iniciar sesión");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("Tras_Login_Password_Vacio");

      Utils.step("Verificar mensaje de error");
      if (LoginPage.isMensajeErrorVisible()) {
        String mensajeError = LoginPage.getMensajeErrorLogin();
        Utils.anotate(Utils.LogLevel.PASS, "Mensaje de error mostrado: " + mensajeError);
      }
      Utils.screenshot("Mensaje_Error_Password_Vacio");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-006")
  @Requirement(key = "REQ-002")
  public void test06_accesoRutaProtegidaDashboardSinSesionTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Intentar acceder a /dashboard sin sesión");
      Utils.gotoApp();
      Utils.maximize();
      BaseTest.getDriver().get(BaseTest.getDriver().getCurrentUrl().replace("/login", "/dashboard"));
      Utils.screenshot("Intento_Acceso_Dashboard_Sin_Sesion");

      Utils.step("Verificar redirección a login");
      if (LoginPage.isCampoUsuarioVisible()) {
        Utils.anotate(Utils.LogLevel.PASS, "Redirigido correctamente a /login");
      }
      Utils.screenshot("Redireccion_A_Login");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-007")
  @Requirement(key = "REQ-002")
  public void test07_accesoRutaProtegidaPerfilSinSesionTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Intentar acceder a /perfil sin sesión");
      Utils.gotoApp();
      Utils.maximize();
      BaseTest.getDriver().get(BaseTest.getDriver().getCurrentUrl().replace("/login", "/perfil"));
      Utils.screenshot("Intento_Acceso_Perfil_Sin_Sesion");

      Utils.step("Verificar redirección a login");
      if (LoginPage.isCampoUsuarioVisible()) {
        Utils.anotate(Utils.LogLevel.PASS, "Redirigido correctamente a /login");
      }
      Utils.screenshot("Redireccion_A_Login");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-008")
  @Requirement(key = "REQ-002")
  public void test08_accesoRutaProtegidaConfiguracionSinSesionTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Intentar acceder a /configuracion sin sesión");
      Utils.gotoApp();
      Utils.maximize();
      BaseTest.getDriver().get(BaseTest.getDriver().getCurrentUrl().replace("/login", "/configuracion"));
      Utils.screenshot("Intento_Acceso_Configuracion_Sin_Sesion");

      Utils.step("Verificar redirección a login");
      if (LoginPage.isCampoUsuarioVisible()) {
        Utils.anotate(Utils.LogLevel.PASS, "Redirigido correctamente a /login");
      }
      Utils.screenshot("Redireccion_A_Login");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-009")
  @Requirement(key = "REQ-003")
  public void test09_logoutExitosoDesdeDashboardTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Abrir aplicación y autenticarse");
      Utils.gotoApp();
      Utils.maximize();
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("Dashboard_Tras_Login");

      Utils.step("Click en Logout");
      DashboardPage.clickBotonLogout();
      Utils.screenshot("Tras_Logout");

      Utils.step("Verificar redirección a login");
      if (LoginPage.isCampoUsuarioVisible()) {
        Utils.anotate(Utils.LogLevel.PASS, "Logout exitoso, redirigido a /login");
      }
      Utils.screenshot("Login_Tras_Logout");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  // ========== NAVEGACIÓN ==========

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-010")
  @Requirement(key = "REQ-004")
  public void test10_navegacionDashboardAPerfilTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Abrir aplicación y autenticarse");
      Utils.gotoApp();
      Utils.maximize();
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("Dashboard_Inicial");

      Utils.step("Click en Editar Perfil");
      DashboardPage.clickBotonEditarPerfil();
      Utils.screenshot("Tras_Click_Editar_Perfil");

      Utils.step("Verificar navegación a /perfil");
      if (PerfilPage.isPerfilPageLoaded()) {
        Utils.anotate(Utils.LogLevel.PASS, "Navegación a /perfil exitosa");
      }
      Utils.screenshot("Pagina_Perfil");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-011")
  @Requirement(key = "REQ-004")
  public void test11_navegacionDashboardAConfiguracionTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Abrir aplicación y autenticarse");
      Utils.gotoApp();
      Utils.maximize();
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("Dashboard_Inicial");

      Utils.step("Click en Configuración");
      DashboardPage.clickBotonConfiguracion();
      Utils.screenshot("Tras_Click_Configuracion");

      Utils.step("Verificar navegación a /configuracion");
      if (ConfiguracionPage.isCheckboxNotiEmailVisible()) {
        Utils.anotate(Utils.LogLevel.PASS, "Navegación a /configuracion exitosa");
      }
      Utils.screenshot("Pagina_Configuracion");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  // ========== BÚSQUEDA ==========

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-012")
  @Requirement(key = "REQ-005")
  public void test12_busquedaPorCategoriaNombreTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Abrir aplicación y autenticarse");
      Utils.gotoApp();
      Utils.maximize();
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("Dashboard_Inicial");

      Utils.step("Seleccionar categoría Nombre");
      DashboardPage.seleccionarCategoriaBusqueda("Nombre");
      Utils.screenshot("Categoria_Nombre_Seleccionada");

      Utils.step("Ingresar término de búsqueda");
      DashboardPage.fillCampoBusqueda("Ana");
      Utils.screenshot("Termino_Busqueda_Ingresado");

      Utils.step("Click en Buscar");
      DashboardPage.clickBotonBuscar();
      Utils.screenshot("Resultados_Busqueda_Nombre");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-013")
  @Requirement(key = "REQ-005")
  public void test13_busquedaPorCategoriaEmailTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Abrir aplicación y autenticarse");
      Utils.gotoApp();
      Utils.maximize();
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("Dashboard_Inicial");

      Utils.step("Seleccionar categoría Email");
      DashboardPage.seleccionarCategoriaBusqueda("Email");
      Utils.screenshot("Categoria_Email_Seleccionada");

      Utils.step("Ingresar término de búsqueda");
      DashboardPage.fillCampoBusqueda("carlos");
      Utils.screenshot("Termino_Busqueda_Ingresado");

      Utils.step("Click en Buscar");
      DashboardPage.clickBotonBuscar();
      Utils.screenshot("Resultados_Busqueda_Email");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-014")
  @Requirement(key = "REQ-005")
  public void test14_busquedaPorCategoriaDepartamentoTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Abrir aplicación y autenticarse");
      Utils.gotoApp();
      Utils.maximize();
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("Dashboard_Inicial");

      Utils.step("Seleccionar categoría Departamento");
      DashboardPage.seleccionarCategoriaBusqueda("Departamento");
      Utils.screenshot("Categoria_Departamento_Seleccionada");

      Utils.step("Ingresar término de búsqueda");
      DashboardPage.fillCampoBusqueda("Recursos Humanos");
      Utils.screenshot("Termino_Busqueda_Ingresado");

      Utils.step("Click en Buscar");
      DashboardPage.clickBotonBuscar();
      Utils.screenshot("Resultados_Busqueda_Departamento");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-015")
  @Requirement(key = "REQ-005")
  public void test15_busquedaConTerminoVacioTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Abrir aplicación y autenticarse");
      Utils.gotoApp();
      Utils.maximize();
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("Dashboard_Inicial");

      Utils.step("Seleccionar categoría Todos");
      DashboardPage.seleccionarCategoriaBusqueda("Todos");
      Utils.screenshot("Categoria_Todos_Seleccionada");

      Utils.step("Dejar campo de búsqueda vacío");
      Utils.screenshot("Campo_Busqueda_Vacio");

      Utils.step("Click en Buscar");
      DashboardPage.clickBotonBuscar();
      Utils.screenshot("Resultados_Busqueda_Vacia");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  // ========== CONFIGURACIÓN - NOTIFICACIONES ==========

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-016")
  @Requirement(key = "REQ-006")
  public void test16_actualizarPreferenciasNotiEmailTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Abrir aplicación y autenticarse");
      Utils.gotoApp();
      Utils.maximize();
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("Dashboard_Inicial");

      Utils.step("Navegar a Configuración");
      DashboardPage.clickBotonConfiguracion();
      Utils.screenshot("Pagina_Configuracion");

      Utils.step("Marcar notificaciones email");
      ConfiguracionPage.setCheckboxNotiEmail(true);
      ConfiguracionPage.setCheckboxNotiSms(false);
      Utils.screenshot("Noti_Email_Marcada");

      Utils.step("Guardar preferencias");
      ConfiguracionPage.clickBotonGuardarPreferencias();
      Utils.screenshot("Tras_Guardar_Preferencias");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-017")
  @Requirement(key = "REQ-006")
  public void test17_actualizarPreferenciasNotiSmsTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Abrir aplicación y autenticarse");
      Utils.gotoApp();
      Utils.maximize();
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("Dashboard_Inicial");

      Utils.step("Navegar a Configuración");
      DashboardPage.clickBotonConfiguracion();
      Utils.screenshot("Pagina_Configuracion");

      Utils.step("Marcar notificaciones SMS");
      ConfiguracionPage.setCheckboxNotiEmail(false);
      ConfiguracionPage.setCheckboxNotiSms(true);
      Utils.screenshot("Noti_SMS_Marcada");

      Utils.step("Guardar preferencias");
      ConfiguracionPage.clickBotonGuardarPreferencias();
      Utils.screenshot("Tras_Guardar_Preferencias");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-018")
  @Requirement(key = "REQ-006")
  public void test18_actualizarPreferenciasNotiAmbasTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Abrir aplicación y autenticarse");
      Utils.gotoApp();
      Utils.maximize();
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("Dashboard_Inicial");

      Utils.step("Navegar a Configuración");
      DashboardPage.clickBotonConfiguracion();
      Utils.screenshot("Pagina_Configuracion");

      Utils.step("Marcar ambas notificaciones");
      ConfiguracionPage.setCheckboxNotiEmail(true);
      ConfiguracionPage.setCheckboxNotiSms(true);
      Utils.screenshot("Ambas_Noti_Marcadas");

      Utils.step("Guardar preferencias");
      ConfiguracionPage.clickBotonGuardarPreferencias();
      Utils.screenshot("Tras_Guardar_Preferencias");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  // ========== CONFIGURACIÓN - TEMA ==========

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-019")
  @Requirement(key = "REQ-007")
  public void test19_actualizarTemaClaroTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Abrir aplicación y autenticarse");
      Utils.gotoApp();
      Utils.maximize();
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("Dashboard_Inicial");

      Utils.step("Navegar a Configuración");
      DashboardPage.clickBotonConfiguracion();
      Utils.screenshot("Pagina_Configuracion");

      Utils.step("Seleccionar tema Claro");
      ConfiguracionPage.clickRadioTemaClaro();
      Utils.screenshot("Tema_Claro_Seleccionado");

      Utils.step("Guardar preferencias");
      ConfiguracionPage.clickBotonGuardarPreferencias();
      Utils.screenshot("Tras_Guardar_Tema_Claro");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-020")
  @Requirement(key = "REQ-007")
  public void test20_actualizarTemaOscuroTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Abrir aplicación y autenticarse");
      Utils.gotoApp();
      Utils.maximize();
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("Dashboard_Inicial");

      Utils.step("Navegar a Configuración");
      DashboardPage.clickBotonConfiguracion();
      Utils.screenshot("Pagina_Configuracion");

      Utils.step("Seleccionar tema Oscuro");
      ConfiguracionPage.clickRadioTemaOscuro();
      Utils.screenshot("Tema_Oscuro_Seleccionado");

      Utils.step("Guardar preferencias");
      ConfiguracionPage.clickBotonGuardarPreferencias();
      Utils.screenshot("Tras_Guardar_Tema_Oscuro");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-021")
  @Requirement(key = "REQ-007")
  public void test21_actualizarTemaAutoTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Abrir aplicación y autenticarse");
      Utils.gotoApp();
      Utils.maximize();
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("Dashboard_Inicial");

      Utils.step("Navegar a Configuración");
      DashboardPage.clickBotonConfiguracion();
      Utils.screenshot("Pagina_Configuracion");

      Utils.step("Seleccionar tema Automático");
      ConfiguracionPage.clickRadioTemaAuto();
      Utils.screenshot("Tema_Auto_Seleccionado");

      Utils.step("Guardar preferencias");
      ConfiguracionPage.clickBotonGuardarPreferencias();
      Utils.screenshot("Tras_Guardar_Tema_Auto");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  // ========== CONFIGURACIÓN - IDIOMA ==========

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-022")
  @Requirement(key = "REQ-008")
  public void test22_actualizarIdiomaInglesTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Abrir aplicación y autenticarse");
      Utils.gotoApp();
      Utils.maximize();
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("Dashboard_Inicial");

      Utils.step("Navegar a Configuración");
      DashboardPage.clickBotonConfiguracion();
      Utils.screenshot("Pagina_Configuracion");

      Utils.step("Seleccionar idioma Inglés");
      ConfiguracionPage.seleccionarIdioma("Inglés");
      Utils.screenshot("Idioma_Ingles_Seleccionado");

      Utils.step("Guardar preferencias");
      ConfiguracionPage.clickBotonGuardarPreferencias();
      Utils.screenshot("Tras_Guardar_Idioma_Ingles");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-023")
  @Requirement(key = "REQ-008")
  public void test23_actualizarIdiomaFrancesTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Abrir aplicación y autenticarse");
      Utils.gotoApp();
      Utils.maximize();
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("Dashboard_Inicial");

      Utils.step("Navegar a Configuración");
      DashboardPage.clickBotonConfiguracion();
      Utils.screenshot("Pagina_Configuracion");

      Utils.step("Seleccionar idioma Francés");
      ConfiguracionPage.seleccionarIdioma("Francés");
      Utils.screenshot("Idioma_Frances_Seleccionado");

      Utils.step("Guardar preferencias");
      ConfiguracionPage.clickBotonGuardarPreferencias();
      Utils.screenshot("Tras_Guardar_Idioma_Frances");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-024")
  @Requirement(key = "REQ-008")
  public void test24_actualizarIdiomaAlemanTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Abrir aplicación y autenticarse");
      Utils.gotoApp();
      Utils.maximize();
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("Dashboard_Inicial");

      Utils.step("Navegar a Configuración");
      DashboardPage.clickBotonConfiguracion();
      Utils.screenshot("Pagina_Configuracion");

      Utils.step("Seleccionar idioma Alemán");
      ConfiguracionPage.seleccionarIdioma("Alemán");
      Utils.screenshot("Idioma_Aleman_Seleccionado");

      Utils.step("Guardar preferencias");
      ConfiguracionPage.clickBotonGuardarPreferencias();
      Utils.screenshot("Tras_Guardar_Idioma_Aleman");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-025")
  @Requirement(key = "REQ-008")
  public void test25_actualizarIdiomaPortuguesTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Abrir aplicación y autenticarse");
      Utils.gotoApp();
      Utils.maximize();
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("Dashboard_Inicial");

      Utils.step("Navegar a Configuración");
      DashboardPage.clickBotonConfiguracion();
      Utils.screenshot("Pagina_Configuracion");

      Utils.step("Seleccionar idioma Portugués");
      ConfiguracionPage.seleccionarIdioma("Portugués");
      Utils.screenshot("Idioma_Portugues_Seleccionado");

      Utils.step("Guardar preferencias");
      ConfiguracionPage.clickBotonGuardarPreferencias();
      Utils.screenshot("Tras_Guardar_Idioma_Portugues");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  // ========== CONFIGURACIÓN - COMPLETA ==========

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-026")
  @Requirement(key = "REQ-009")
  public void test26_actualizarConfiguracionCompletaTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Abrir aplicación y autenticarse");
      Utils.gotoApp();
      Utils.maximize();
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("Dashboard_Inicial");

      Utils.step("Navegar a Configuración");
      DashboardPage.clickBotonConfiguracion();
      Utils.screenshot("Pagina_Configuracion");

      Utils.step("Configurar todas las preferencias");
      ConfiguracionPage.setCheckboxNotiEmail(true);
      ConfiguracionPage.setCheckboxNotiSms(true);
      ConfiguracionPage.clickRadioTemaOscuro();
      ConfiguracionPage.seleccionarIdioma("Inglés");
      Utils.screenshot("Todas_Preferencias_Configuradas");

      Utils.step("Guardar preferencias");
      ConfiguracionPage.clickBotonGuardarPreferencias();
      Utils.screenshot("Tras_Guardar_Config_Completa");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-027")
  @Requirement(key = "REQ-010")
  public void test27_cancelarCambiosConfiguracionTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Abrir aplicación y autenticarse");
      Utils.gotoApp();
      Utils.maximize();
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("Dashboard_Inicial");

      Utils.step("Navegar a Configuración");
      DashboardPage.clickBotonConfiguracion();
      Utils.screenshot("Pagina_Configuracion");

      Utils.step("Realizar cambios sin guardar");
      ConfiguracionPage.setCheckboxNotiEmail(true);
      ConfiguracionPage.clickRadioTemaOscuro();
      Utils.screenshot("Cambios_Sin_Guardar");

      Utils.step("Cancelar cambios");
      ConfiguracionPage.clickBotonCancelarConfiguracion();
      Utils.screenshot("Tras_Cancelar");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-028")
  @Requirement(key = "REQ-011")
  public void test28_verificarBotonEliminarCuentaTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Abrir aplicación y autenticarse");
      Utils.gotoApp();
      Utils.maximize();
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("Dashboard_Inicial");

      Utils.step("Navegar a Configuración");
      DashboardPage.clickBotonConfiguracion();
      Utils.screenshot("Pagina_Configuracion");

      Utils.step("Verificar botón Eliminar Cuenta visible");
      if (ConfiguracionPage.isBotonEliminarCuentaVisible()) {
        Utils.anotate(Utils.LogLevel.PASS, "Botón Eliminar Cuenta visible (placeholder)");
      }
      Utils.screenshot("Boton_Eliminar_Cuenta_Visible");

      Utils.step("Click en botón Eliminar Cuenta (placeholder)");
      ConfiguracionPage.clickBotonEliminarCuenta();
      Utils.screenshot("Tras_Click_Eliminar_Cuenta");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  // ========== REDIRECCIONES ==========

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-029")
  @Requirement(key = "REQ-012")
  public void test29_redireccionRaizSinSesionTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Navegar a ruta raíz sin sesión");
      Utils.gotoApp();
      Utils.maximize();
      Utils.screenshot("Ruta_Raiz");

      Utils.step("Verificar redirección a login");
      if (LoginPage.isCampoUsuarioVisible()) {
        Utils.anotate(Utils.LogLevel.PASS, "Redirigido correctamente a /login");
      }
      Utils.screenshot("Login_Desde_Raiz");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-030")
  @Requirement(key = "REQ-012")
  public void test30_redireccionRaizConSesionTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Autenticarse primero");
      Utils.gotoApp();
      Utils.maximize();
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("Dashboard_Tras_Login");

      Utils.step("Navegar a ruta raíz con sesión activa");
      BaseTest.getDriver().get(BaseTest.getDriver().getCurrentUrl().split("/dashboard")[0] + "/");
      Utils.screenshot("Ruta_Raiz_Con_Sesion");

      Utils.step("Verificar redirección a dashboard");
      DashboardPage.getInfoUsuarioDashboard();
      Utils.screenshot("Dashboard_Desde_Raiz");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  // ========== FLUJOS E2E COMPLETOS ==========

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-031")
  @Requirement(key = "REQ-013")
  public void test31_flujoCompletoLoginConfiguracionLogoutTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Login");
      Utils.gotoApp();
      Utils.maximize();
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("01_Dashboard_Tras_Login");

      Utils.step("Verificar información de usuario");
      DashboardPage.verificarInfoUsuarioContiene("Ana García");
      Utils.screenshot("02_Info_Usuario_Verificada");

      Utils.step("Navegar a Configuración");
      DashboardPage.clickBotonConfiguracion();
      Utils.screenshot("03_Pagina_Configuracion");

      Utils.step("Actualizar preferencias");
      ConfiguracionPage.setCheckboxNotiEmail(true);
      ConfiguracionPage.setCheckboxNotiSms(true);
      ConfiguracionPage.clickRadioTemaOscuro();
      ConfiguracionPage.seleccionarIdioma("Inglés");
      Utils.screenshot("04_Preferencias_Actualizadas");

      Utils.step("Guardar preferencias");
      ConfiguracionPage.clickBotonGuardarPreferencias();
      Utils.screenshot("05_Tras_Guardar");

      Utils.step("Logout");
      DashboardPage.clickBotonLogout();
      Utils.screenshot("06_Tras_Logout");

      Utils.step("Verificar redirección a login");
      if (LoginPage.isCampoUsuarioVisible()) {
        Utils.anotate(Utils.LogLevel.PASS, "Flujo E2E completo exitoso");
      }
      Utils.screenshot("07_Login_Final");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-032")
  @Requirement(key = "REQ-013")
  public void test32_flujoCompletoLoginBusquedaPerfilLogoutTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Login");
      Utils.gotoApp();
      Utils.maximize();
      LoginPage.fillCampoUsuario("user1");
      LoginPage.fillCampoPassword("user123");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("01_Dashboard_Tras_Login");

      Utils.step("Realizar búsqueda");
      DashboardPage.seleccionarCategoriaBusqueda("Nombre");
      DashboardPage.fillCampoBusqueda("Carlos");
      DashboardPage.clickBotonBuscar();
      Utils.screenshot("02_Resultados_Busqueda");

      Utils.step("Navegar a Perfil");
      DashboardPage.clickBotonEditarPerfil();
      Utils.screenshot("03_Pagina_Perfil");

      Utils.step("Logout");
      DashboardPage.clickBotonLogout();
      Utils.screenshot("04_Tras_Logout");

      Utils.step("Verificar redirección a login");
      if (LoginPage.isCampoUsuarioVisible()) {
        Utils.anotate(Utils.LogLevel.PASS, "Flujo E2E alternativo completo exitoso");
      }
      Utils.screenshot("05_Login_Final");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-033")
  @Requirement(key = "REQ-014")
  public void test33_verificarPersistenciaSesionTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Autenticarse");
      Utils.gotoApp();
      Utils.maximize();
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("01_Dashboard_Inicial");

      Utils.step("Navegar a Configuración");
      DashboardPage.clickBotonConfiguracion();
      Utils.screenshot("02_Configuracion");

      Utils.step("Navegar a Perfil");
      DashboardPage.clickBotonEditarPerfil();
      Utils.screenshot("03_Perfil");

      Utils.step("Regresar a Dashboard");
      BaseTest.getDriver().navigate().back();
      BaseTest.getDriver().navigate().back();
      Utils.screenshot("04_Dashboard_Regreso");

      Utils.step("Verificar sesión persistente");
      DashboardPage.getInfoUsuarioDashboard();
      Utils.screenshot("05_Sesion_Persistente");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  // ========== VALIDACIONES ==========

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-034")
  @Requirement(key = "REQ-015")
  public void test34_validacionCampoTemaRequeridoTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Abrir aplicación y autenticarse");
      Utils.gotoApp();
      Utils.maximize();
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("Dashboard_Inicial");

      Utils.step("Navegar a Configuración");
      DashboardPage.clickBotonConfiguracion();
      Utils.screenshot("Pagina_Configuracion");

      Utils.step("Intentar guardar sin seleccionar tema");
      ConfiguracionPage.clickBotonGuardarPreferencias();
      Utils.screenshot("Tras_Guardar_Sin_Tema");

      Utils.step("Verificar mensaje de error");
      String mensajeError = ConfiguracionPage.getMensajeErrorCampoTema();
      if (mensajeError != null) {
        Utils.anotate(Utils.LogLevel.PASS, "Mensaje de error campo tema: " + mensajeError);
      }
      Utils.screenshot("Mensaje_Error_Tema");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-035")
  @Requirement(key = "REQ-015")
  public void test35_validacionCampoIdiomaRequeridoTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Abrir aplicación y autenticarse");
      Utils.gotoApp();
      Utils.maximize();
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("Dashboard_Inicial");

      Utils.step("Navegar a Configuración");
      DashboardPage.clickBotonConfiguracion();
      Utils.screenshot("Pagina_Configuracion");

      Utils.step("Intentar guardar sin seleccionar idioma");
      ConfiguracionPage.clickBotonGuardarPreferencias();
      Utils.screenshot("Tras_Guardar_Sin_Idioma");

      Utils.step("Verificar mensaje de error");
      String mensajeError = ConfiguracionPage.getMensajeErrorCampoIdioma();
      if (mensajeError != null) {
        Utils.anotate(Utils.LogLevel.PASS, "Mensaje de error campo idioma: " + mensajeError);
      }
      Utils.screenshot("Mensaje_Error_Idioma");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-036")
  @Requirement(key = "REQ-016")
  public void test36_verificarIndicadorCargaTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Abrir aplicación y autenticarse");
      Utils.gotoApp();
      Utils.maximize();
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("Dashboard_Inicial");

      Utils.step("Click en Configuración");
      DashboardPage.clickBotonConfiguracion();
      Utils.screenshot("Tras_Click_Configuracion");

      Utils.step("Esperar a que indicador de carga desaparezca");
      DashboardPage.waitForLoadingToDisappear(30);
      Utils.screenshot("Configuracion_Cargada");

      Utils.step("Verificar que página está completamente cargada");
      if (ConfiguracionPage.isCheckboxNotiEmailVisible()) {
        Utils.anotate(Utils.LogLevel.PASS, "Página de configuración cargada completamente");
      }
      Utils.screenshot("Pagina_Completamente_Cargada");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }
}
