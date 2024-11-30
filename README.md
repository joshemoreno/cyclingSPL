# Sistema cyclingSPL

Este proyecto incluye:
1. Un script Bash para configurar automáticamente un contenedor Docker con MySQL y registrar usuarios predefinidos.
2. Un backend desarrollado en **Spring Boot** (Java 17) para gestionar las operaciones CRUD de usuarios.
3. Un frontend en **Angular** (18) para interactuar con el sistema.

---

## Requisitos previos

1. **Docker instalado**  
   Descárgalo de [Docker](https://www.docker.com/get-started).

2. **Node.js y npm instalados**  
   Descárgalo de [Node.js](https://nodejs.org/).

3. **Java 17 instalado**  
   Descárgalo de [AdoptOpenJDK](https://adoptium.net/) o la distribución de tu preferencia.

4. **Maven instalado**  
   Asegúrate de que `mvn` esté disponible en tu terminal.

5. **Acceso al directorio del proyecto**  
   Clona o descarga este repositorio en tu máquina local.

---

## Archivos incluidos

### 1. `mysql_automation.sh`

Script Bash para:
- Construir una imagen de Docker personalizada basada en MySQL.
- Inicializar un contenedor de Docker.
- Ejecutar un archivo SQL para insertar usuarios automáticamente.

### 2. `init_users.sql`

Archivo SQL para inicializar la base de datos con usuarios predefinidos.

### 3. Proyecto Spring Boot (`/back`)

El backend desarrollado en Spring Boot incluye:
- Controladores para las operaciones CRUD.
- Conexión con la base de datos MySQL.
- Configuración de seguridad básica (opcional).

### 4. Proyecto Angular (`/front`)

El frontend incluye:
- Componentes para mostrar y gestionar usuarios.
- Conexión con el backend para las operaciones CRUD.

---

## Tabla de Base de Datos

La tabla utilizada para MySQL se define como:

```sql
CREATE TABLE gestion_usuarios (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(50) NOT NULL,
    Email VARCHAR(100) NOT NULL,
    Password VARCHAR(255) NOT NULL,
    Plan ENUM('BASIC', 'PREMIUM', 'STANDARD') NOT NULL
);
