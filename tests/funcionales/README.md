# Tests Funcionales - Aplicación Piloto

## Descripción General

Este directorio contiene los tests funcionales generados para la aplicación piloto basados en la documentación funcional proporcionada. Los tests están implementados usando el framework MAT (cat.gencat.mat) y cubren todos los flujos de usuario principales.

## Estructura de Archivos

### Page Objects
- **LoginPage.java** - Página de autenticación con métodos para login/logout
- **DashboardPage.java** - Página principal con navegación y búsqueda
- **PerfilPage.java** - Página de gestión de perfil de usuario
- **ConfiguracionPage.java** - Página de configuración de preferencias

### Clases de Test
- **AutenticacionFuncionalTest.java** - Tests de autenticación y seguridad
- **GestionPerfilFuncionalTest.java** - Tests de gestión de perfil de usuario
- **ConfiguracionPreferenciasFuncionalTest.java** - Tests de configuración de preferencias
- **FlujosCompletosE2ETest.java** - Tests de flujos completos end-to-end

## Cobertura Funcional

### 1. Autenticación de Usuario (REQ-F001 a REQ-F003)
- ✅ Login exitoso con credenciales válidas (admin, user1)
- ✅ Login fallido con credenciales inválidas
- ✅ Validación de campos obligatorios
- ✅ Protección de rutas sin sesión
- ✅ Logout exitoso

### 2. Gestión de Perfil (REQ-F004 a REQ-F007)
- ✅ Navegación desde dashboard a perfil
- ✅ Edición de información personal (nombre, email, teléfono)
- ✅ Selección de departamento, ciudad e idioma
- ✅ Cambio de contraseña con validaciones
- ✅ Validación de campos obligatorios
- ✅ Cancelación de cambios

### 3. Configuración de Preferencias (REQ-F008 a REQ-F014)
- ✅ Navegación desde dashboard a configuración
- ✅ Configuración de notificaciones (email, SMS)
- ✅ Selección de tema (claro, oscuro, automático)
- ✅ Configuración de idioma
- ✅ Guardado de configuración completa
- ✅ Cancelación de cambios
- ✅ Validación de campos requeridos

### 4. Flujos Completos E2E (REQ-F015 a REQ-F019)
- ✅ Flujo completo login → perfil → configuración → logout
- ✅ Flujo multi-usuario con configuraciones independientes
- ✅ Flujo de búsqueda y navegación
- ✅ Flujo de validaciones y manejo de errores
- ✅ Flujo de persistencia de datos

## Casos de Test Implementados

| ID | Descripción | Requisito | Estado |
|----|-------------|-----------|--------|
| TC-F001 | Autenticación exitosa admin | REQ-F001 | ✅ |
| TC-F002 | Autenticación exitosa user1 | REQ-F001 | ✅ |
| TC-F003 | Autenticación fallida credenciales inválidas | REQ-F001 | ✅ |
| TC-F004 | Validación campos obligatorios login | REQ-F001 | ✅ |
| TC-F005 | Acceso rutas protegidas sin sesión | REQ-F002 | ✅ |
| TC-F006 | Logout exitoso | REQ-F003 | ✅ |
| TC-F007 | Navegación dashboard a perfil | REQ-F004 | ✅ |
| TC-F008 | Edición información personal | REQ-F005 | ✅ |
| TC-F009 | Validación campos obligatorios perfil | REQ-F005 | ✅ |
| TC-F010 | Cambio de contraseña | REQ-F006 | ✅ |
| TC-F011 | Validación confirmación contraseña | REQ-F006 | ✅ |
| TC-F012 | Cancelar cambios perfil | REQ-F007 | ✅ |
| TC-F013 | Navegación dashboard a configuración | REQ-F008 | ✅ |
| TC-F014 | Configuración notificaciones | REQ-F009 | ✅ |
| TC-F015 | Configuración tema | REQ-F010 | ✅ |
| TC-F016 | Configuración idioma | REQ-F011 | ✅ |
| TC-F017 | Configuración completa | REQ-F012 | ✅ |
| TC-F018 | Cancelar cambios configuración | REQ-F013 | ✅ |
| TC-F019 | Validación campos requeridos configuración | REQ-F014 | ✅ |
| TC-F020 | Flujo completo login-perfil-config-logout | REQ-F015 | ✅ |
| TC-F021 | Flujo multi-usuario | REQ-F016 | ✅ |
| TC-F022 | Flujo búsqueda y navegación | REQ-F017 | ✅ |
| TC-F023 | Flujo validaciones y errores | REQ-F018 | ✅ |
| TC-F024 | Flujo persistencia datos | REQ-F019 | ✅ |

## Características de los Tests

### Formato MAT Compliant
- Todos los tests extienden `BaseTest`
- Uso de `Utils.step()` para documentar pasos
- Uso de `Utils.screenshot()` para capturas
- Uso de `Utils.anotate()` para logging
- Manejo de excepciones con `Utils.endTestAsOK()` y `Utils.endTestAsKO()`

### Selectores XPath
- Todos los selectores provienen del archivo `ui_elements.json`
- Selectores principales y alternativos (_ALT) para mayor robustez
- No se inventan XPaths, solo se usan los proporcionados

### Anotaciones Xray
- Cada test tiene `@XrayTest(key = "TC-FXXX")`
- Cada test tiene `@Requirement(key = "REQ-FXXX")`
- Trazabilidad completa con requisitos funcionales

### Estructura de Page Objects
- Métodos `fill*()` para campos de texto
- Métodos `click*()` para botones
- Métodos `get*()` para obtener texto
- Métodos `is*Visible()` para verificaciones
- Métodos `seleccionar*()` para dropdowns
- Métodos `set*()` para checkboxes

## Ejecución de Tests

Los tests están diseñados para ejecutarse con el framework MAT y requieren:

1. **Configuración del entorno MAT**
2. **Aplicación piloto ejecutándose**
3. **Navegador configurado** (Chrome, Firefox, etc.)
4. **Parámetros de ejecución** (`browser`)

### Ejemplo de ejecución:
```bash
# Ejecutar todos los tests funcionales
mvn test -Dtest=*FuncionalTest

# Ejecutar tests específicos
mvn test -Dtest=AutenticacionFuncionalTest
mvn test -Dtest=GestionPerfilFuncionalTest
mvn test -Dtest=ConfiguracionPreferenciasFuncionalTest
mvn test -Dtest=FlujosCompletosE2ETest
```

## Datos de Test

### Usuarios de Prueba
- **admin** / **admin123** - Usuario administrador (Ana García)
- **user1** / **user123** - Usuario estándar (Carlos López)

### Datos de Configuración
- **Departamentos**: Recursos Humanos, Tecnología, Ventas, Marketing
- **Ciudades**: Madrid, Barcelona, Valencia, Sevilla
- **Idiomas**: Español, Inglés, Francés, Alemán, Portugués, Catalán
- **Temas**: Claro, Oscuro, Automático

## Mantenimiento

Para mantener estos tests:

1. **Actualizar selectores** si cambia la UI (modificar ui_elements.json)
2. **Añadir nuevos tests** siguiendo el formato MAT establecido
3. **Actualizar datos de prueba** si cambian los usuarios o configuraciones
4. **Revisar screenshots** periódicamente para verificar la UI

## Notas Técnicas

- Los tests están optimizados para ejecución en paralelo
- Cada test es independiente y no depende del estado de otros
- Se incluyen esperas implícitas y explícitas donde es necesario
- Los screenshots se toman en puntos clave para debugging
- El logging es detallado para facilitar el análisis de fallos