# Inicialización de Base de Datos MySQL con Usuarios

Este proyecto incluye un script Bash para configurar automáticamente un contenedor Docker con MySQL, inicializar la base de datos y registrar usuarios predefinidos.

## Requisitos previos

1. **Docker instalado**  
   Asegúrate de tener Docker instalado en tu máquina. Si no lo tienes, sigue las instrucciones de instalación en [la página oficial de Docker](https://www.docker.com/get-started).

2. **Acceso al directorio del proyecto**  
   Clona o descarga este repositorio en tu máquina local.

---

## Archivos incluidos

### 1. `mysql_automation.sh`

Script Bash para:
- Construir una imagen de Docker personalizada basada en MySQL.
- Inicializar un contenedor de Docker.
- Ejecutar un archivo SQL para insertar usuarios automáticamente.

### 2. `init_users.sql`

Archivo SQL para inicializar la base de datos con usuarios predefinidos. Incluye comandos para:
- Insertar usuarios en la tabla `gestion_usuarios`.

---

## Tabla de Base de Datos

La tabla utilizada en este proyecto se define como:

```sql
CREATE TABLE gestion_usuarios (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(50) NOT NULL,
    Email VARCHAR(100) NOT NULL,
    Password VARCHAR(255) NOT NULL,
    Plan ENUM('BASIC', 'PREMIUM', 'STANDARD') NOT NULL
);
