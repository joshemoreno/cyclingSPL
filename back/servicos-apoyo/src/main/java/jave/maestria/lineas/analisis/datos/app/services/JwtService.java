package jave.maestria.lineas.analisis.datos.app.services;

import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

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
