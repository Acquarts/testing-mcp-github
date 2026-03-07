# Documentación Funcional de la Aplicación Piloto

## Descripción General de la Aplicación
La aplicación piloto es un sistema web desarrollado con Flask que simula funcionalidades básicas de autenticación y gestión de usuario. Está diseñada como un placeholder para ser expandida en una aplicación completa.

## Arquitectura del Sistema
La aplicación está construida como un monolito utilizando el framework Flask. Los datos se almacenan en memoria y se reinician al detener el servidor.

## Requisitos Funcionales

### Autenticación de Usuario
- **Descripción**: Permitir a los usuarios iniciar sesión con un nombre de usuario y contraseña.
- **Criterios de Aceptación**:
  - El sistema debe validar las credenciales contra un conjunto de usuarios predefinidos.
  - Mostrar un mensaje de error si las credenciales son incorrectas.

### Gestión de Perfil
- **Descripción**: Los usuarios pueden ver y editar su información personal.
- **Criterios de Aceptación**:
  - Los cambios en el perfil deben reflejarse inmediatamente en el sistema.
  - Los campos obligatorios deben ser validados.

### Configuración de Preferencias
- **Descripción**: Los usuarios pueden ajustar sus preferencias de notificaciones y tema.
- **Criterios de Aceptación**:
  - Las preferencias deben guardarse y ser visibles en futuras sesiones.

## Flujos de Usuario
1. **Inicio de Sesión**: El usuario accede a la pantalla de login, ingresa sus credenciales y es redirigido al dashboard si son correctas.
2. **Navegación al Dashboard**: Desde el dashboard, el usuario puede acceder a su perfil o configuración.
3. **Edición de Perfil**: En la pantalla de perfil, el usuario puede actualizar su información personal.
4. **Configuración de Preferencias**: En la pantalla de configuración, el usuario ajusta sus preferencias de notificaciones y tema.

## Especificación de Pantallas

### Pantalla de Login
- **Elementos**:
  - Campo de usuario
  - Campo de contraseña
  - Botón de envío
- **Validaciones**:
  - Campos obligatorios
  - Mensaje de error para credenciales incorrectas

### Pantalla de Dashboard
- **Elementos**:
  - Resumen de usuario
  - Estadísticas
  - Acciones rápidas

### Pantalla de Perfil
- **Elementos**:
  - Campos de texto para nombre, email, teléfono
  - Selectores para departamento, ciudad, idioma
  - Botón de guardar cambios
- **Validaciones**:
  - Campos obligatorios

### Pantalla de Configuración
- **Elementos**:
  - Checkboxes para notificaciones
  - Radio buttons para tema
  - Dropdown para idioma
  - Botón de guardar preferencias

## Gestión de Datos
Los datos de usuario se almacenan en un diccionario en memoria. Los cambios se aplican directamente a este diccionario.

## Seguridad y Autenticación
La aplicación utiliza sesiones para mantener la autenticación del usuario. Se requiere inicio de sesión para acceder a las rutas protegidas.

## Casos de Uso
1. **Iniciar Sesión**: Usuario ingresa credenciales y accede al sistema.
2. **Editar Perfil**: Usuario actualiza su información personal.
3. **Configurar Preferencias**: Usuario ajusta sus preferencias de notificaciones y tema.

## Reglas de Negocio
- Los usuarios deben autenticarse para acceder a las funcionalidades.
- Las contraseñas deben coincidir con las almacenadas en el sistema.
- Los cambios en el perfil y configuración deben ser persistentes durante la sesión.
