package gestion.ventas.auto.security;

import gestion.ventas.auto.models.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.Map;

@Component
public class AuthProvider {

    @Value("${config.security.keySecret}")
    private String keySecret;

    @Value("${config.security.jwt.expirationTime}")
    private long expirationTime;

    public String createToken(Usuario authUser) {
        Map<String, Object> claims = Jwts.claims().setSubject(authUser.getUsername());
        claims.put("id", authUser.getIdUsuario());
        final String fullName = String.format("%s %s", authUser.getNombre(), authUser.getApellido());
        claims.put("fullName", fullName);
        claims.put("username", authUser.getUsername());
        Date now = new Date();
        Date exp = new Date(now.getTime() + (expirationTime));

        Key key = Keys.hmacShaKeyFor(keySecret.getBytes());

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(authUser.getIdUsuario().toString())
                .setIssuedAt(now)
                .setExpiration(exp)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validate(String token) {
        try {
            Jwts.parser().setSigningKey(keySecret.getBytes()).parseClaimsJwt(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
