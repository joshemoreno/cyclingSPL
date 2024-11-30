FROM mysql:8.0

ENV MYSQL_ROOT_PASSWORD=admin
ENV MYSQL_DATABASE=app_membresias
ENV MYSQL_USER=my_user
ENV MYSQL_PASSWORD=admin

COPY init_users.sql /docker-entrypoint-initdb.d/
