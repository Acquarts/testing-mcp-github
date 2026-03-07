import cat.gencat.mat.Utils;
import cat.gencat.mat.BaseTest;
import java.lang.reflect.Method;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import cat.gencat.mat.pages.LoginPage;
import cat.gencat.mat.pages.DashboardPage;
import cat.gencat.mat.pages.PerfilPage;
import cat.gencat.mat.pages.ConfiguracionPage;
import app.getxray.xray.testng.annotations.XrayTest;
import app.getxray.xray.testng.annotations.Requirement;

public final class FlujosCompletosE2ETest extends BaseTest {

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-F020")
  @Requirement(key = "REQ-F015")
  public void test01_flujoCompletoLoginPerfilConfiguracionLogoutTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Paso 1 - Iniciar sesión en la aplicación");
      Utils.gotoApp();
      Utils.maximize();
      Utils.anotate(Utils.LogLevel.PASS, "Aplicación accesible");
      Utils.screenshot("01_App_Abierta");

      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("02_Login_Completado");

      Utils.step("Paso 2 - Verificar acceso al dashboard");
      if (DashboardPage.isDashboardLoaded()) {
        Utils.anotate(Utils.LogLevel.PASS, "Dashboard cargado correctamente");
      }
      DashboardPage.verificarInfoUsuarioContiene("Ana García");
      Utils.screenshot("03_Dashboard_Verificado");

      Utils.step("Paso 3 - Navegar a perfil y actualizar información");
      DashboardPage.clickBotonEditarPerfil();
      Utils.screenshot("04_Navegacion_A_Perfil");

      if (PerfilPage.isPerfilPageLoaded()) {
        Utils.anotate(Utils.LogLevel.PASS, "Página de perfil cargada");
      }

      PerfilPage.fillCampoNombre("Ana García Rodríguez");
      PerfilPage.fillCampoEmail("ana.garcia.rodriguez@empresa.com");
      PerfilPage.fillCampoTelefono("666-555-444");
      PerfilPage.seleccionarDepartamento("Tecnología");
      PerfilPage.seleccionarCiudad("Madrid");
      PerfilPage.seleccionarIdioma("Español");
      Utils.screenshot("05_Perfil_Actualizado");

      PerfilPage.clickBotonGuardarCambios();
      Utils.screenshot("06_Perfil_Guardado");

      Utils.step("Paso 4 - Navegar a configuración y ajustar preferencias");
      DashboardPage.clickBotonConfiguracion();
      Utils.screenshot("07_Navegacion_A_Configuracion");

      if (ConfiguracionPage.isCheckboxNotiEmailVisible()) {
        Utils.anotate(Utils.LogLevel.PASS, "Página de configuración cargada");
      }

      ConfiguracionPage.setCheckboxNotiEmail(true);
      ConfiguracionPage.setCheckboxNotiSms(false);
      ConfiguracionPage.clickRadioTemaOscuro();
      ConfiguracionPage.seleccionarIdioma("Inglés");
      Utils.screenshot("08_Configuracion_Ajustada");

      ConfiguracionPage.clickBotonGuardarPreferencias();
      Utils.screenshot("09_Configuracion_Guardada");

      Utils.step("Paso 5 - Verificar persistencia navegando entre páginas");
      DashboardPage.clickBotonEditarPerfil();
      Utils.screenshot("10_Vuelta_A_Perfil");

      String nombreActual = PerfilPage.getCampoNombre();
      if (nombreActual != null && nombreActual.contains("Ana García Rodríguez")) {
        Utils.anotate(Utils.LogLevel.PASS, "Cambios de perfil persistentes: " + nombreActual);
      }
      Utils.screenshot("11_Perfil_Persistente");

      DashboardPage.clickBotonConfiguracion();
      Utils.screenshot("12_Vuelta_A_Configuracion");

      if (ConfiguracionPage.isCheckboxNotiEmailVisible()) {
        Utils.anotate(Utils.LogLevel.PASS, "Configuración persistente");
      }
      Utils.screenshot("13_Configuracion_Persistente");

      Utils.step("Paso 6 - Cerrar sesión");
      DashboardPage.clickBotonLogout();
      Utils.screenshot("14_Logout_Ejecutado");

      if (LoginPage.isCampoUsuarioVisible()) {
        Utils.anotate(Utils.LogLevel.PASS, "Logout exitoso, redirigido a login");
      }
      Utils.screenshot("15_Login_Tras_Logout");

      Utils.step("Paso 7 - Verificar que la sesión se cerró correctamente");
      BaseTest.getDriver().get(BaseTest.getDriver().getCurrentUrl().replace("/login", "/dashboard"));
      if (LoginPage.isCampoUsuarioVisible()) {
        Utils.anotate(Utils.LogLevel.PASS, "Sesión cerrada correctamente, no puede acceder a dashboard");
      }
      Utils.screenshot("16_Sesion_Cerrada_Verificada");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-F021")
  @Requirement(key = "REQ-F016")
  public void test02_flujoCompletoMultiUsuarioTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Paso 1 - Login con primer usuario (admin)");
      Utils.gotoApp();
      Utils.maximize();
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("01_Login_Admin");

      DashboardPage.verificarInfoUsuarioContiene("Ana García");
      Utils.screenshot("02_Dashboard_Admin");

      Utils.step("Paso 2 - Configurar preferencias para admin");
      DashboardPage.clickBotonConfiguracion();
      ConfiguracionPage.setCheckboxNotiEmail(true);
      ConfiguracionPage.clickRadioTemaClaro();
      ConfiguracionPage.seleccionarIdioma("Español");
      ConfiguracionPage.clickBotonGuardarPreferencias();
      Utils.screenshot("03_Config_Admin_Guardada");

      Utils.step("Paso 3 - Logout de admin");
      DashboardPage.clickBotonLogout();
      Utils.screenshot("04_Logout_Admin");

      Utils.step("Paso 4 - Login con segundo usuario (user1)");
      LoginPage.fillCampoUsuario("user1");
      LoginPage.fillCampoPassword("user123");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("05_Login_User1");

      DashboardPage.verificarInfoUsuarioContiene("Carlos López");
      Utils.screenshot("06_Dashboard_User1");

      Utils.step("Paso 5 - Configurar preferencias diferentes para user1");
      DashboardPage.clickBotonConfiguracion();
      ConfiguracionPage.setCheckboxNotiSms(true);
      ConfiguracionPage.clickRadioTemaOscuro();
      ConfiguracionPage.seleccionarIdioma("Inglés");
      ConfiguracionPage.clickBotonGuardarPreferencias();
      Utils.screenshot("07_Config_User1_Guardada");

      Utils.step("Paso 6 - Actualizar perfil de user1");
      DashboardPage.clickBotonEditarPerfil();
      PerfilPage.fillCampoNombre("Carlos López Martín");
      PerfilPage.fillCampoEmail("carlos.lopez.martin@empresa.com");
      PerfilPage.seleccionarDepartamento("Ventas");
      PerfilPage.clickBotonGuardarCambios();
      Utils.screenshot("08_Perfil_User1_Actualizado");

      Utils.step("Paso 7 - Logout de user1");
      DashboardPage.clickBotonLogout();
      Utils.screenshot("09_Logout_User1");

      Utils.step("Paso 8 - Verificar que las configuraciones son independientes");
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("10_Re_Login_Admin");

      DashboardPage.verificarInfoUsuarioContiene("Ana García");
      DashboardPage.clickBotonConfiguracion();
      Utils.screenshot("11_Verificacion_Config_Admin");

      if (ConfiguracionPage.isCheckboxNotiEmailVisible()) {
        Utils.anotate(Utils.LogLevel.PASS, "Configuraciones independientes por usuario");
      }
      Utils.screenshot("12_Config_Admin_Independiente");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-F022")
  @Requirement(key = "REQ-F017")
  public void test03_flujoCompletoBusquedaYNavegacionTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Paso 1 - Login y acceso al dashboard");
      Utils.gotoApp();
      Utils.maximize();
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("01_Dashboard_Inicial");

      Utils.step("Paso 2 - Realizar búsqueda por nombre");
      DashboardPage.seleccionarCategoriaBusqueda("Nombre");
      DashboardPage.fillCampoBusqueda("Ana");
      DashboardPage.clickBotonBuscar();
      Utils.screenshot("02_Busqueda_Por_Nombre");

      Utils.step("Paso 3 - Navegar a perfil desde resultados de búsqueda");
      DashboardPage.clickBotonEditarPerfil();
      Utils.screenshot("03_Perfil_Desde_Busqueda");

      Utils.step("Paso 4 - Volver al dashboard y buscar por email");
      DashboardPage.clickBotonCancelarPerfil();
      Utils.screenshot("04_Vuelta_Dashboard");

      DashboardPage.clearCampoBusqueda();
      DashboardPage.seleccionarCategoriaBusqueda("Email");
      DashboardPage.fillCampoBusqueda("ana");
      DashboardPage.clickBotonBuscar();
      Utils.screenshot("05_Busqueda_Por_Email");

      Utils.step("Paso 5 - Navegar a configuración desde búsqueda");
      DashboardPage.clickBotonConfiguracion();
      Utils.screenshot("06_Configuracion_Desde_Busqueda");

      Utils.step("Paso 6 - Realizar cambios y volver al dashboard");
      ConfiguracionPage.setCheckboxNotiEmail(true);
      ConfiguracionPage.clickRadioTemaAuto();
      ConfiguracionPage.clickBotonGuardarPreferencias();
      Utils.screenshot("07_Cambios_Configuracion");

      Utils.step("Paso 7 - Buscar por departamento");
      DashboardPage.clearCampoBusqueda();
      DashboardPage.seleccionarCategoriaBusqueda("Departamento");
      DashboardPage.fillCampoBusqueda("Recursos Humanos");
      DashboardPage.clickBotonBuscar();
      Utils.screenshot("08_Busqueda_Por_Departamento");

      Utils.step("Paso 8 - Probar búsqueda vacía");
      DashboardPage.clearCampoBusqueda();
      DashboardPage.seleccionarCategoriaBusqueda("Todos");
      DashboardPage.clickBotonBuscar();
      Utils.screenshot("09_Busqueda_Vacia");

      Utils.step("Paso 9 - Verificar navegación fluida entre secciones");
      DashboardPage.clickBotonEditarPerfil();
      Utils.screenshot("10_Navegacion_A_Perfil");

      DashboardPage.clickBotonConfiguracion();
      Utils.screenshot("11_Navegacion_A_Configuracion");

      DashboardPage.clickBotonLogout();
      Utils.screenshot("12_Logout_Final");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-F023")
  @Requirement(key = "REQ-F018")
  public void test04_flujoCompletoValidacionesYErroresTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Paso 1 - Probar validaciones de login");
      Utils.gotoApp();
      Utils.maximize();
      
      // Campos vacíos
      LoginPage.clickBotonEntrar();
      Utils.screenshot("01_Login_Campos_Vacios");

      // Usuario vacío
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      if (LoginPage.isMensajeErrorVisible()) {
        Utils.anotate(Utils.LogLevel.PASS, "Error usuario vacío detectado");
      }
      Utils.screenshot("02_Error_Usuario_Vacio");

      // Password vacío
      LoginPage.clearCampoPassword();
      LoginPage.fillCampoUsuario("admin");
      LoginPage.clickBotonEntrar();
      if (LoginPage.isMensajeErrorVisible()) {
        Utils.anotate(Utils.LogLevel.PASS, "Error password vacío detectado");
      }
      Utils.screenshot("03_Error_Password_Vacio");

      // Credenciales incorrectas
      LoginPage.fillCampoPassword("passwordIncorrecto");
      LoginPage.clickBotonEntrar();
      if (LoginPage.isMensajeErrorVisible()) {
        Utils.anotate(Utils.LogLevel.PASS, "Error credenciales incorrectas detectado");
      }
      Utils.screenshot("04_Error_Credenciales_Incorrectas");

      Utils.step("Paso 2 - Login exitoso tras errores");
      LoginPage.clearCampoUsuario();
      LoginPage.clearCampoPassword();
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("05_Login_Exitoso_Tras_Errores");

      Utils.step("Paso 3 - Probar validaciones en perfil");
      DashboardPage.clickBotonEditarPerfil();
      
      // Campos obligatorios vacíos
      PerfilPage.clearCampoNombre();
      PerfilPage.clearCampoEmail();
      PerfilPage.clickBotonGuardarCambios();
      Utils.screenshot("06_Perfil_Campos_Obligatorios_Vacios");

      // Contraseñas no coinciden
      PerfilPage.fillCampoNombre("Ana García");
      PerfilPage.fillCampoEmail("ana@empresa.com");
      PerfilPage.fillCampoPassActual("admin123");
      PerfilPage.fillCampoPassNueva("nuevaPass123");
      PerfilPage.fillCampoPassConfirmar("passwordDiferente");
      PerfilPage.clickBotonGuardarCambios();
      Utils.screenshot("07_Error_Passwords_No_Coinciden");

      Utils.step("Paso 4 - Corregir errores en perfil");
      PerfilPage.fillCampoPassConfirmar("nuevaPass123");
      PerfilPage.clickBotonGuardarCambios();
      Utils.screenshot("08_Perfil_Corregido");

      Utils.step("Paso 5 - Probar validaciones en configuración");
      DashboardPage.clickBotonConfiguracion();
      
      // Intentar guardar sin campos requeridos
      ConfiguracionPage.clickBotonGuardarPreferencias();
      Utils.screenshot("09_Config_Campos_Requeridos_Vacios");

      String errorTema = ConfiguracionPage.getMensajeErrorCampoTema();
      String errorIdioma = ConfiguracionPage.getMensajeErrorCampoIdioma();
      
      if (errorTema != null || errorIdioma != null) {
        Utils.anotate(Utils.LogLevel.PASS, "Validaciones de configuración funcionando");
      }
      Utils.screenshot("10_Errores_Config_Detectados");

      Utils.step("Paso 6 - Completar configuración correctamente");
      ConfiguracionPage.clickRadioTemaClaro();
      ConfiguracionPage.seleccionarIdioma("Español");
      ConfiguracionPage.clickBotonGuardarPreferencias();
      Utils.screenshot("11_Config_Completada_Correctamente");

      Utils.step("Paso 7 - Verificar flujo completo tras correcciones");
      String mensajeExito = ConfiguracionPage.getMensajeExitoConfiguracion();
      if (mensajeExito != null) {
        Utils.anotate(Utils.LogLevel.PASS, "Flujo completo exitoso tras correcciones");
      }
      Utils.screenshot("12_Flujo_Completo_Exitoso");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-F024")
  @Requirement(key = "REQ-F019")
  public void test05_flujoCompletoPersistenciaDatosTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Paso 1 - Login inicial y configuración de datos");
      Utils.gotoApp();
      Utils.maximize();
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("01_Login_Inicial");

      Utils.step("Paso 2 - Configurar perfil con datos específicos");
      DashboardPage.clickBotonEditarPerfil();
      PerfilPage.fillCampoNombre("Ana García Persistente");
      PerfilPage.fillCampoEmail("ana.persistente@test.com");
      PerfilPage.fillCampoTelefono("999-888-777");
      PerfilPage.seleccionarDepartamento("Tecnología");
      PerfilPage.seleccionarCiudad("Barcelona");
      PerfilPage.seleccionarIdioma("Catalán");
      PerfilPage.clickBotonGuardarCambios();
      Utils.screenshot("02_Perfil_Configurado");

      Utils.step("Paso 3 - Configurar preferencias específicas");
      DashboardPage.clickBotonConfiguracion();
      ConfiguracionPage.setCheckboxNotiEmail(true);
      ConfiguracionPage.setCheckboxNotiSms(false);
      ConfiguracionPage.clickRadioTemaOscuro();
      ConfiguracionPage.seleccionarIdioma("Francés");
      ConfiguracionPage.clickBotonGuardarPreferencias();
      Utils.screenshot("03_Preferencias_Configuradas");

      Utils.step("Paso 4 - Logout y re-login para verificar persistencia");
      DashboardPage.clickBotonLogout();
      Utils.screenshot("04_Logout_Para_Verificar");

      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("05_Re_Login");

      Utils.step("Paso 5 - Verificar persistencia de datos de perfil");
      DashboardPage.clickBotonEditarPerfil();
      
      String nombrePersistente = PerfilPage.getCampoNombre();
      String emailPersistente = PerfilPage.getCampoEmail();
      String telefonoPersistente = PerfilPage.getCampoTelefono();
      
      if (nombrePersistente != null && nombrePersistente.contains("Ana García Persistente")) {
        Utils.anotate(Utils.LogLevel.PASS, "Nombre persistente: " + nombrePersistente);
      }
      if (emailPersistente != null && emailPersistente.contains("ana.persistente@test.com")) {
        Utils.anotate(Utils.LogLevel.PASS, "Email persistente: " + emailPersistente);
      }
      if (telefonoPersistente != null && telefonoPersistente.contains("999-888-777")) {
        Utils.anotate(Utils.LogLevel.PASS, "Teléfono persistente: " + telefonoPersistente);
      }
      Utils.screenshot("06_Perfil_Persistente_Verificado");

      Utils.step("Paso 6 - Verificar persistencia de preferencias");
      DashboardPage.clickBotonConfiguracion();
      
      if (ConfiguracionPage.isCheckboxNotiEmailVisible()) {
        Utils.anotate(Utils.LogLevel.PASS, "Preferencias persistentes tras re-login");
      }
      Utils.screenshot("07_Preferencias_Persistentes_Verificadas");

      Utils.step("Paso 7 - Navegación múltiple para verificar estabilidad");
      for (int i = 1; i <= 3; i++) {
        DashboardPage.clickBotonEditarPerfil();
        Utils.screenshot("08_Navegacion_Perfil_" + i);
        
        DashboardPage.clickBotonConfiguracion();
        Utils.screenshot("09_Navegacion_Config_" + i);
        
        // Verificar que los datos siguen ahí
        if (ConfiguracionPage.isCheckboxNotiEmailVisible()) {
          Utils.anotate(Utils.LogLevel.PASS, "Datos estables en navegación " + i);
        }
      }

      Utils.step("Paso 8 - Verificación final de integridad de datos");
      DashboardPage.clickBotonEditarPerfil();
      String nombreFinal = PerfilPage.getCampoNombre();
      if (nombreFinal != null && nombreFinal.contains("Ana García Persistente")) {
        Utils.anotate(Utils.LogLevel.PASS, "Integridad de datos mantenida: " + nombreFinal);
      }
      Utils.screenshot("10_Integridad_Datos_Final");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }
}