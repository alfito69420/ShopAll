package com.example.metaphorce.security;

import com.example.metaphorce.model.Rol;
import com.example.metaphorce.model.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.sql.Date;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Representa el manejo de token
 * desde su creacion hasta su
 * descomposicion para fines de
 * autenticacion
 *
 */
public class TokenUtils {

    //  Constantes
    private final static String ACCESS_TOKEN_SECRET = "4qhq8LrEBfYcaRHxhdb9zURb2rf8e7Ud";
    private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 2_592_000L;   //  Valido por 30 dias

    /**
     * Metodo para la generacion de tokens
     * con fecha de expiracion
     *
     * @param nombre
     * @param email
     * @param authorities
     * @return
     */
    public static String createToken(String nombre, String email, Collection<? extends GrantedAuthority> authorities) {
        long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1_000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);


        UserEntity userEntity = null;
        //List<Rol> rol = userEntity.getRoles().stream().collect(Collectors.toList());

        //String rol = authorities.toString();

        Map<String, Object> extra = new HashMap<>();
        extra.put("nombre", nombre);
        extra.put("roles", authorities);


        return Jwts.builder()
                .setSubject(email)
                //.setSubject(String.valueOf(rol))
                .setExpiration(expirationDate)
                .addClaims(extra)
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
                .compact();
    } //close method

    /**
     * Metodo para que spring security reconozca
     * y de autorizacion a un usuario que intenta acceder
     * a un endpoint por medio de un token
     *
     * @param token
     * @return
     */
    public static UsernamePasswordAuthenticationToken getAuth(String token) {
        try {
            //  Se hace el proceso inverso; se descompone el token
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String email = claims.getSubject();

            //List<? extends GrantedAuthority> tokenList = claims.getSubject();

            return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
            //return new UsernamePasswordAuthenticationToken(email, null, tokenList);
        } catch (JwtException e) {
            return null;
        }
    } //close method
} //close class
