import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By

BASE_URL = "http://localhost:5000"

@pytest.mark.regression
class TestRegresionLogout:
    """Tests de regresión para el módulo de logout."""

    def setup_method(self):
        self.driver = webdriver.Chrome()
        self.driver.implicitly_wait(10)

    def teardown_method(self):
        self.driver.quit()

    @pytest.mark.smoke
    def test_logout_sigue_funcionando(self):
        driver = self.driver
        driver.get(f"{BASE_URL}/login")
        driver.find_element(By.XPATH, "//input[@id='username']").send_keys("admin")
        driver.find_element(By.XPATH, "//input[@id='password']").send_keys("admin123")
        driver.find_element(By.XPATH, "//button[normalize-space()='Entrar']").click()
        driver.find_element(By.XPATH, "//a[normalize-space()='Logout']").click()
        assert "/login" in driver.current_url
