USE app_membresias;

CREATE TABLE gestion_usuarios (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(50) NOT NULL,
    Email VARCHAR(100) NOT NULL,
    Password VARCHAR(255) NOT NULL,
    Plan ENUM('BASIC', 'PREMIUM', 'STANDARD') NOT NULL
);

INSERT INTO gestion_usuarios (Nombre, Email, Password, Plan) 
VALUES 
('Jose', 'jose@mail.com', '$2a$10$TcQKXzucNYFWjIRVRGsVceGPaFauyytX9rH0bYBjedZYyP/EYXbcS', 'PREMIUM'),
('Pedro', 'pedro@mail.com', '$2a$10$TcQKXzucNYFWjIRVRGsVceGPaFauyytX9rH0bYBjedZYyP/EYXbcS', 'BASIC'),
('juan', 'juan@mail.com', '$2a$10$TcQKXzucNYFWjIRVRGsVceGPaFauyytX9rH0bYBjedZYyP/EYXbcS', 'STANDARD');

