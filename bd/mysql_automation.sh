#!/bin/bash

# Variables configurables
IMAGE_NAME="mysql"
CONTAINER_NAME="mysql-container"
DB_PORT="3306"
MYSQL_ROOT_PASSWORD="admin"
MYSQL_DATABASE="app_membresias"
MYSQL_PASSWORD="admin"

# Función para mostrar mensajes con colores
log() {
    echo -e "\033[1;34m$1\033[0m"
}

error() {
    echo -e "\033[1;31m$1\033[0m"
}

# Verifica si Docker está instalado
if ! command -v docker &> /dev/null; then
    error "Docker no está instalado. Por favor, instálalo antes de continuar."
    exit 1
fi

# Construcción de la imagen Docker
log "Construyendo la imagen Docker..."
docker build -t $IMAGE_NAME . || { error "Error al construir la imagen."; exit 1; }

# Detener y eliminar el contenedor si ya existe
if [ "$(docker ps -aq -f name=$CONTAINER_NAME)" ]; then
    log "Deteniendo y eliminando el contenedor existente..."
    docker rm -f $CONTAINER_NAME || { error "Error al eliminar el contenedor existente."; exit 1; }
fi

# Iniciar el contenedor con MySQL
log "Iniciando el contenedor de MySQL..."
docker run -d \
    --name $CONTAINER_NAME \
    -e MYSQL_ROOT_PASSWORD=$MYSQL_ROOT_PASSWORD \
    -e MYSQL_DATABASE=$MYSQL_DATABASE \
    -e MYSQL_PASSWORD=$MYSQL_PASSWORD \
    -p $DB_PORT:3306 \
    $IMAGE_NAME || { error "Error al iniciar el contenedor."; exit 1; }

log "¡El contenedor se ha iniciado exitosamente!"
log "Puedes conectarte a MySQL en el puerto $DB_PORT con el usuario root y la base de datos '$MYSQL_DATABASE'."
