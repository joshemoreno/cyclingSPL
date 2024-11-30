package jave.maestria.lineas.gestion.usuarios.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Service
public class JwtService {

    public final SecretKey secretKey;

    public JwtService() {
        String fixedKey = "mySuperSecureAndLongEnoughKeyForHS512ThatIsAtLeast64CharactersLong";
        this.secretKey = Keys.hmacShaKeyFor(fixedKey.getBytes());
    }

    private final long jwtExpirationMs = 86400000;

    // Genera un token JWT
    public String generateToken(String username, Collection<? extends GrantedAuthority> authorities) {

        String roles = authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .claim("plan", roles)
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public SecretKey getSecretKey() {
        return secretKey;
    }

    public Collection<? extends GrantedAuthority> getAuthoritiesFromRoles(String roles) {
        return Arrays.stream(roles.split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
