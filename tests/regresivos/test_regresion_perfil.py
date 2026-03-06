import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By

BASE_URL = "http://localhost:5000"

@pytest.mark.regression
class TestRegresionPerfil:
    """Tests de regresión para el módulo de perfil."""

    def setup_method(self):
        self.driver = webdriver.Chrome()
        self.driver.implicitly_wait(10)

    def teardown_method(self):
        self.driver.quit()

    def test_editar_perfil_sigue_funcionando(self):
        driver = self.driver
        driver.get(f"{BASE_URL}/login")
        driver.find_element(By.XPATH, "//input[@id='username']").send_keys("admin")
        driver.find_element(By.XPATH, "//input[@id='password']").send_keys("admin123")
        driver.find_element(By.XPATH, "//button[normalize-space()='Entrar']").click()
        driver.find_element(By.XPATH, "//a[normalize-space()='Editar Perfil']").click()
        driver.find_element(By.XPATH, "//input[@id='nombre']").clear()
        driver.find_element(By.XPATH, "//input[@id='nombre']").send_keys("Nuevo Nombre")
        driver.find_element(By.XPATH, "//button[normalize-space()='Guardar Cambios']").click()
        assert "Cambios guardados" in driver.page_source
