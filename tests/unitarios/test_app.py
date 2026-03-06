import pytest
from flask import session
from app import app, current_user, login_required

class TestApp:
    """Tests para el módulo app."""

    @pytest.fixture
    def client(self):
        app.config['TESTING'] = True
        with app.test_client() as client:
            with app.app_context():
                yield client

    def test_current_user_no_session(self, client):
        """Debe devolver None si no hay usuario en sesión."""
        with client:
            assert current_user() is None

    def test_current_user_with_session(self, client):
        """Debe devolver el usuario actual si hay sesión activa."""
        with client.session_transaction() as sess:
            sess['username'] = 'admin'
        assert current_user() == {
            "password": "admin123",
            "nombre": "Ana García",
            "email": "ana.garcia@ejemplo.com",
            "departamento": "Tecnología",
            "rol": "Administrador",
            "telefono": "612 345 678",
            "ciudad": "Barcelona",
            "idioma": "Castellano",
            "notificaciones_email": True,
            "notificaciones_sms": False,
            "tema": "claro",
        }

    def test_login_required_decorator(self, client):
        """Debe redirigir al login si no hay sesión activa."""
        @login_required
        def protected_route():
            return "Protected"

        with client:
            response = client.get('/dashboard')
            assert response.status_code == 302
            assert '/login' in response.headers['Location']

    def test_login_success(self, client):
        """Debe iniciar sesión correctamente con credenciales válidas."""
        response = client.post('/login', data={'username': 'admin', 'password': 'admin123'})
        assert response.status_code == 302
        assert '/dashboard' in response.headers['Location']
        with client:
            client.get('/dashboard')
            assert session['username'] == 'admin'

    def test_login_failure(self, client):
        """Debe fallar el inicio de sesión con credenciales incorrectas."""
        response = client.post('/login', data={'username': 'admin', 'password': 'wrongpass'})
        assert response.status_code == 200
        assert b'Usuario o contraseña incorrectos.' in response.data

    def test_logout(self, client):
        """Debe cerrar la sesión correctamente."""
        with client.session_transaction() as sess:
            sess['username'] = 'admin'
        response = client.get('/logout')
        assert response.status_code == 302
        assert '/login' in response.headers['Location']
        with client:
            client.get('/login')
            assert 'username' not in session
