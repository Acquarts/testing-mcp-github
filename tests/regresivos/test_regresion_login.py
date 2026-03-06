import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By

BASE_URL = "http://localhost:5000"

@pytest.mark.regression
class TestRegresionLogin:
    """Tests de regresión para el módulo de login."""

    def setup_method(self):
        self.driver = webdriver.Chrome()
        self.driver.implicitly_wait(10)

    def teardown_method(self):
        self.driver.quit()

    @pytest.mark.smoke
    def test_login_exitoso_sigue_funcionando(self):
        driver = self.driver
        driver.get(f"{BASE_URL}/login")
        driver.find_element(By.XPATH, "//input[@id='username']").send_keys("admin")
        driver.find_element(By.XPATH, "//input[@id='password']").send_keys("admin123")
        driver.find_element(By.XPATH, "//button[normalize-space()='Entrar']").click()
        assert "/dashboard" in driver.current_url

    def test_login_fallido_muestra_mensaje_error(self):
        driver = self.driver
        driver.get(f"{BASE_URL}/login")
        driver.find_element(By.XPATH, "//input[@id='username']").send_keys("wronguser")
        driver.find_element(By.XPATH, "//input[@id='password']").send_keys("wrongpass")
        driver.find_element(By.XPATH, "//button[normalize-space()='Entrar']").click()
        error_message = driver.find_element(By.XPATH, "//div[@id='error-msg']").text
        assert "Credenciales inválidas" in error_message
