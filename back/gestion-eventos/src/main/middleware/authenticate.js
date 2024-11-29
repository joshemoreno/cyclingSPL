const jwt = require('jsonwebtoken');

function authenticate(req, res, next) {
    const token = req.headers.authorization?.split(' ')[1];
    if (!token) {
        return res.status(401).json({ message: 'Token no proporcionado' });
    }

    try {
        const decoded = jwt.verify(token, 'clave_secreta'); // Cambia 'clave_secreta' por tu clave real
        req.user = decoded; // Decodifica el token y almacena los datos del usuario
        next();
    } catch (error) {
        return res.status(403).json({ message: 'Token no válido' });
    }
}

module.exports = authenticate;