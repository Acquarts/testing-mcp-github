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

public final class PerfilTest extends BaseTest {

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-037")
  @Requirement(key = "REQ-003")
  public void test01_editarPerfilExitosamenteTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Abrir aplicación y autenticarse");
      Utils.gotoApp();
      Utils.maximize();
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("Dashboard_Tras_Login");

      Utils.step("Navegar a Perfil");
      DashboardPage.clickBotonEditarPerfil();
      Utils.screenshot("Pagina_Perfil");

      Utils.step("Editar información de perfil");
      PerfilPage.fillCampoNombre("Ana García");
      PerfilPage.fillCampoEmail("ana.garcia@example.com");
      PerfilPage.fillCampoTelefono("123456789");
      PerfilPage.seleccionarDepartamento("Recursos Humanos");
      PerfilPage.seleccionarCiudad("Barcelona");
      PerfilPage.seleccionarIdioma("Español");
      Utils.screenshot("Perfil_Informacion_Actualizada");

      Utils.step("Guardar cambios de perfil");
      PerfilPage.clickBotonGuardarCambios();
      Utils.screenshot("Perfil_Guardado");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }

  @Test
  @Parameters(value = {"browser"})
  @XrayTest(key = "TC-038")
  @Requirement(key = "REQ-003")
  public void test02_cancelarEdicionPerfilTest(String browser, Method method) throws Throwable {
    try {
      Utils.step("Abrir aplicación y autenticarse");
      Utils.gotoApp();
      Utils.maximize();
      LoginPage.fillCampoUsuario("admin");
      LoginPage.fillCampoPassword("admin123");
      LoginPage.clickBotonEntrar();
      Utils.screenshot("Dashboard_Tras_Login");

      Utils.step("Navegar a Perfil");
      DashboardPage.clickBotonEditarPerfil();
      Utils.screenshot("Pagina_Perfil");

      Utils.step("Realizar cambios en el perfil sin guardar");
      PerfilPage.fillCampoNombre("Ana María García");
      Utils.screenshot("Cambios_Perfil_Sin_Guardar");

      Utils.step("Cancelar cambios de perfil");
      PerfilPage.clickBotonCancelarPerfil();
      Utils.screenshot("Perfil_Cancelado");

      Utils.endTestAsOK(browser, method);
    } catch (Exception | AssertionError e) {
      Utils.endTestAsKO(browser, method, e);
    }
  }
}
