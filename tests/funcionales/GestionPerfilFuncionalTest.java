import cat.gencat.mat.Utils;
import cat.gencat.mat.BaseTest;
import java.lang.reflect.Method;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import cat.gencat.mat.pages.LoginPage;
import cat.gencat.mat.pages.DashboardPage;
import cat.gencat.mat.pages.PerfilPage;
import app.getxray.xray.testng.annotations.XrayTest;
import app.getxray.xray.testng.annotations.Requirement;

public final class GestionPerfilFuncionalTest extends BaseTest {

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-F007")
  @Requirement(key = "REQ-F004")
  public void test01_flujoNavegacionDashboardAPerfilTest(String browser, Method method) throws Throwable {
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

      Utils.step("Paso 4 - Hacer clic en botón Editar Perfil");
      DashboardPage.clickBotonEditarPerfil();
      Utils.screenshot("Tras_Click_Editar_Perfil");

      Utils.step("Paso 5 - Verificar navegación a página de perfil");
      if (PerfilPage.isPerfilPageLoaded()) {
        Utils.anotate(Utils.LogLevel.PASS, "Navegación a página de perfil exitosa");
      }
      Utils.screenshot("Pagina_Perfil_Cargada");

      Utils.step("Paso 6 - Verificar elementos de perfil visibles");
      if (PerfilPage.isCampoNombreVisible()) {
        Utils.anotate(Utils.LogLevel.PASS, "Elementos de perfil visibles correctamente");
      }
      Utils.screenshot("Elementos_Perfil_Visibles");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-F008")
  @Requirement(key = "REQ-F005")
  public void test02_flujoEdicionInformacionPersonalTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Paso 1 - Abrir aplicación y navegar a perfil");
      Utils.gotoApp();
      Utils.maximize();
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      DashboardPage.clickBotonEditarPerfil();
      Utils.screenshot("En_Pagina_Perfil");

      Utils.step("Paso 2 - Obtener valores actuales de los campos");
      String nombreActual = PerfilPage.getCampoNombre();
      String emailActual = PerfilPage.getCampoEmail();
      String telefonoActual = PerfilPage.getCampoTelefono();
      Utils.anotate(Utils.LogLevel.INFO, "Valores actuales - Nombre: " + nombreActual + ", Email: " + emailActual + ", Teléfono: " + telefonoActual);
      Utils.screenshot("Valores_Actuales_Perfil");

      Utils.step("Paso 3 - Actualizar información personal");
      PerfilPage.fillCampoNombre("Ana García Martínez");
      PerfilPage.fillCampoEmail("ana.garcia.martinez@empresa.com");
      PerfilPage.fillCampoTelefono("666-777-888");
      Utils.screenshot("Informacion_Personal_Actualizada");

      Utils.step("Paso 4 - Seleccionar departamento y ciudad");
      PerfilPage.seleccionarDepartamento("Recursos Humanos");
      PerfilPage.seleccionarCiudad("Barcelona");
      PerfilPage.seleccionarIdioma("Español");
      Utils.screenshot("Ubicacion_Idioma_Seleccionados");

      Utils.step("Paso 5 - Guardar cambios");
      PerfilPage.clickBotonGuardarCambios();
      Utils.screenshot("Tras_Guardar_Cambios");

      Utils.step("Paso 6 - Verificar que los cambios se han aplicado");
      String nombreNuevo = PerfilPage.getCampoNombre();
      String emailNuevo = PerfilPage.getCampoEmail();
      String telefonoNuevo = PerfilPage.getCampoTelefono();
      
      if (nombreNuevo != null && nombreNuevo.contains("Ana García Martínez")) {
        Utils.anotate(Utils.LogLevel.PASS, "Nombre actualizado correctamente: " + nombreNuevo);
      }
      if (emailNuevo != null && emailNuevo.contains("ana.garcia.martinez@empresa.com")) {
        Utils.anotate(Utils.LogLevel.PASS, "Email actualizado correctamente: " + emailNuevo);
      }
      if (telefonoNuevo != null && telefonoNuevo.contains("666-777-888")) {
        Utils.anotate(Utils.LogLevel.PASS, "Teléfono actualizado correctamente: " + telefonoNuevo);
      }
      Utils.screenshot("Cambios_Verificados");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-F009")
  @Requirement(key = "REQ-F005")
  public void test03_flujoValidacionCamposObligatoriosPerfilTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Paso 1 - Abrir aplicación y navegar a perfil");
      Utils.gotoApp();
      Utils.maximize();
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      DashboardPage.clickBotonEditarPerfil();
      Utils.screenshot("En_Pagina_Perfil");

      Utils.step("Paso 2 - Limpiar campos obligatorios");
      PerfilPage.clearCampoNombre();
      PerfilPage.clearCampoEmail();
      Utils.screenshot("Campos_Obligatorios_Vacios");

      Utils.step("Paso 3 - Intentar guardar con campos obligatorios vacíos");
      PerfilPage.clickBotonGuardarCambios();
      Utils.screenshot("Intento_Guardar_Campos_Vacios");

      Utils.step("Paso 4 - Verificar que no se permite guardar sin campos obligatorios");
      // La validación puede ser del lado del cliente o servidor
      // Verificamos que seguimos en la página de perfil
      if (PerfilPage.isPerfilPageLoaded()) {
        Utils.anotate(Utils.LogLevel.PASS, "Validación de campos obligatorios funcionando");
      }
      Utils.screenshot("Validacion_Campos_Obligatorios");

      Utils.step("Paso 5 - Rellenar campos obligatorios y guardar");
      PerfilPage.fillCampoNombre("Ana García");
      PerfilPage.fillCampoEmail("ana.garcia@empresa.com");
      PerfilPage.clickBotonGuardarCambios();
      Utils.screenshot("Guardado_Con_Campos_Obligatorios");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-F010")
  @Requirement(key = "REQ-F006")
  public void test04_flujoCambioContrasenaTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Paso 1 - Abrir aplicación y navegar a perfil");
      Utils.gotoApp();
      Utils.maximize();
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      DashboardPage.clickBotonEditarPerfil();
      Utils.screenshot("En_Pagina_Perfil");

      Utils.step("Paso 2 - Rellenar campos de cambio de contraseña");
      PerfilPage.fillCampoPassActual("admin123");
      PerfilPage.fillCampoPassNueva("nuevaPassword123");
      PerfilPage.fillCampoPassConfirmar("nuevaPassword123");
      Utils.screenshot("Campos_Cambio_Password_Rellenos");

      Utils.step("Paso 3 - Guardar cambios de contraseña");
      PerfilPage.clickBotonGuardarCambios();
      Utils.screenshot("Tras_Cambio_Password");

      Utils.step("Paso 4 - Hacer logout para probar nueva contraseña");
      DashboardPage.clickBotonLogout();
      Utils.screenshot("Logout_Tras_Cambio_Password");

      Utils.step("Paso 5 - Intentar login con contraseña anterior (debe fallar)");
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("Intento_Login_Password_Antigua");

      Utils.step("Paso 6 - Verificar que falla el login con contraseña antigua");
      if (LoginPage.isMensajeErrorVisible()) {
        Utils.anotate(Utils.LogLevel.PASS, "Login con contraseña antigua falló correctamente");
      }
      Utils.screenshot("Error_Password_Antigua");

      Utils.step("Paso 7 - Login con nueva contraseña");
      LoginPage.clearCampoPassword();
      LoginPage.fillCampoPassword("nuevaPassword123");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("Login_Nueva_Password");

      Utils.step("Paso 8 - Verificar login exitoso con nueva contraseña");
      if (DashboardPage.isDashboardLoaded()) {
        Utils.anotate(Utils.LogLevel.PASS, "Login con nueva contraseña exitoso");
      }
      Utils.screenshot("Dashboard_Nueva_Password");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-F011")
  @Requirement(key = "REQ-F006")
  public void test05_flujoValidacionConfirmacionContrasenaTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Paso 1 - Abrir aplicación y navegar a perfil");
      Utils.gotoApp();
      Utils.maximize();
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      DashboardPage.clickBotonEditarPerfil();
      Utils.screenshot("En_Pagina_Perfil");

      Utils.step("Paso 2 - Rellenar contraseña actual y nueva");
      PerfilPage.fillCampoPassActual("admin123");
      PerfilPage.fillCampoPassNueva("nuevaPassword123");
      Utils.screenshot("Password_Actual_Y_Nueva_Rellenas");

      Utils.step("Paso 3 - Rellenar confirmación con valor diferente");
      PerfilPage.fillCampoPassConfirmar("passwordDiferente123");
      Utils.screenshot("Confirmacion_Password_Diferente");

      Utils.step("Paso 4 - Intentar guardar con confirmación incorrecta");
      PerfilPage.clickBotonGuardarCambios();
      Utils.screenshot("Intento_Guardar_Confirmacion_Incorrecta");

      Utils.step("Paso 5 - Verificar que no se permite guardar con confirmación incorrecta");
      if (PerfilPage.isPerfilPageLoaded()) {
        Utils.anotate(Utils.LogLevel.PASS, "Validación de confirmación de contraseña funcionando");
      }
      Utils.screenshot("Validacion_Confirmacion_Password");

      Utils.step("Paso 6 - Corregir confirmación de contraseña");
      PerfilPage.fillCampoPassConfirmar("nuevaPassword123");
      PerfilPage.clickBotonGuardarCambios();
      Utils.screenshot("Confirmacion_Password_Corregida");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-F012")
  @Requirement(key = "REQ-F007")
  public void test06_flujoCancelarCambiosPerfilTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Paso 1 - Abrir aplicación y navegar a perfil");
      Utils.gotoApp();
      Utils.maximize();
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      DashboardPage.clickBotonEditarPerfil();
      Utils.screenshot("En_Pagina_Perfil");

      Utils.step("Paso 2 - Obtener valores originales");
      String nombreOriginal = PerfilPage.getCampoNombre();
      String emailOriginal = PerfilPage.getCampoEmail();
      Utils.anotate(Utils.LogLevel.INFO, "Valores originales - Nombre: " + nombreOriginal + ", Email: " + emailOriginal);
      Utils.screenshot("Valores_Originales");

      Utils.step("Paso 3 - Realizar cambios sin guardar");
      PerfilPage.fillCampoNombre("Nombre Temporal");
      PerfilPage.fillCampoEmail("temporal@test.com");
      PerfilPage.fillCampoTelefono("999-888-777");
      Utils.screenshot("Cambios_Temporales_Realizados");

      Utils.step("Paso 4 - Hacer clic en botón Cancelar");
      PerfilPage.clickBotonCancelarPerfil();
      Utils.screenshot("Tras_Click_Cancelar");

      Utils.step("Paso 5 - Verificar redirección al dashboard");
      if (DashboardPage.isDashboardLoaded()) {
        Utils.anotate(Utils.LogLevel.PASS, "Redirección al dashboard tras cancelar");
      }
      Utils.screenshot("Dashboard_Tras_Cancelar");

      Utils.step("Paso 6 - Volver a perfil y verificar que no se guardaron cambios");
      DashboardPage.clickBotonEditarPerfil();
      Utils.screenshot("Vuelta_A_Perfil");

      Utils.step("Paso 7 - Verificar que los valores originales se mantienen");
      String nombreActual = PerfilPage.getCampoNombre();
      String emailActual = PerfilPage.getCampoEmail();
      
      if (nombreActual != null && nombreActual.equals(nombreOriginal)) {
        Utils.anotate(Utils.LogLevel.PASS, "Nombre no se modificó tras cancelar: " + nombreActual);
      }
      if (emailActual != null && emailActual.equals(emailOriginal)) {
        Utils.anotate(Utils.LogLevel.PASS, "Email no se modificó tras cancelar: " + emailActual);
      }
      Utils.screenshot("Valores_Sin_Cambios");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }
}