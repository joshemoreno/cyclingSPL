package jave.maestria.lineas.gestion.eventos.app.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

@Service
public class JwtService {

    public final SecretKey secretKey;

    public JwtService() {
        String fixedKey = "mySuperSecureAndLongEnoughKeyForHS512ThatIsAtLeast64CharactersLong";
        this.secretKey = Keys.hmacShaKeyFor(fixedKey.getBytes());
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