# Reto Técnico - Devsu

## Desarrollador: Julio Gerardo Isla

### 📌 Descripción
Se modificó la estructura del proyecto para implementar una arquitectura limpia basada en puertos y adaptadores. Se aplicaron diversos patrones de diseño para mejorar la mantenibilidad y escalabilidad del código.

### 🛠️ Tecnologías y Arquitectura
- **Arquitectura:** Clean Architecture (Puertos y Adaptadores)
- **Base de Datos:** MySQL (Desplegado en AWS para mayor estabilidad en pruebas)
- **Patrones Implementados:**
  - Repository Pattern
  - Mapper
  - Builder
  - Adapter
  - Control de Excepciones

### 🏗️ Cambios y Mejoras Implementadas
- Se configuró MySQL en AWS en lugar de H2 en runtime para un mejor control durante las pruebas.
- Se desarrollaron **pruebas unitarias** para el módulo `/client/`.
- Se implementaron **pruebas de integración** para el módulo `/account/`.
- Se resolvieron los ejercicios **F1 a F6**.
- Se identificaron problemas en la colección de Postman debido a su dependencia con Echo API.
- Se detectaron y documentaron errores en la plataforma relacionados con puertos existentes, lo que generó demoras en el desarrollo.

### 🚀 Ejecución del Proyecto
#### 1️⃣ Clonar el repositorio
```sh
 git clone <URL_DEL_REPOSITORIO>
 cd <NOMBRE_DEL_PROYECTO>
```
#### 2️⃣ Configuración de Base de Datos
Configurar en `application.properties` o `application-test.properties` las credenciales de MySQL en AWS.
```properties
spring.datasource.url=jdbc:mysql://<HOST>:<PUERTO>/<DB_NAME>
spring.datasource.username=<USER>
spring.datasource.password=<PASSWORD>
```

#### 3️⃣ Ejecutar Pruebas
Para ejecutar las pruebas unitarias y de integración:
```sh
mvn test
```

### 📌 Notas Finales
- Se recomienda revisar la configuración de Echo API en Postman debido a problemas en la colección.
- La demora en la entrega se debió a errores en la plataforma con puertos en uso.
- Se dejó documentada la estructura y se facilitaron las pruebas con una configuración en AWS.

📩 **Contacto:** Julio Gerardo Isla

