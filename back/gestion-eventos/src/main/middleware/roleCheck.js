function roleCheck(allowedRoles) {
    return (req, res, next) => {
        const user = req.user; // Se asume que req.user ya contiene el usuario autenticado.

        if (!user) {
            return res.status(401).json({ message: 'Usuario no autenticado' });
        }

        if (allowedRoles.includes(user.role)) {
            return next(); // El usuario tiene un rol permitido
        }

        return res.status(403).json({ message: 'Acceso denegado' });
    };
}

module.exports = roleCheck;