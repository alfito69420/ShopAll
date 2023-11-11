package com.example.metaphorce.security;

import com.example.metaphorce.domain.AuthResponse;
import com.example.metaphorce.service.VentaDetalleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.Collections;

/**
 *
 */
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private static final Logger logger = LoggerFactory.getLogger(JWTAuthenticationFilter.class);

    /**
     * Hace el intento de autenticacion
     *
     * @param request
     * @param response
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        AuthCredentials authCredentials = new AuthCredentials();

        try {
            //  Se instancia para leer la informacion desde un JSON
            authCredentials = new ObjectMapper().readValue(request.getReader(), AuthCredentials.class);
        } catch (IOException e) {

        }

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                authCredentials.getEmail(),
                authCredentials.getPassword(),
                // Puede que el error este aquiu??
                Collections.emptyList()
        );

        return getAuthenticationManager().authenticate(authenticationToken);
    } //close method

    /**
     * @param request
     * @param response
     * @param chain
     * @param authResult
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult)
            throws IOException, ServletException {

        UserDetailsImpl userDetails = (UserDetailsImpl) authResult.getPrincipal();

        //  Se crea un nuevo token para usarlo en autorizaciones al consultar endpoints
        //String token = TokenUtils.createToken(userDetails.getNombre(), userDetails.getUsername());
        String token = TokenUtils.createToken(userDetails.getNombre(), userDetails.getUsername(), userDetails.getAuthorities());

        AuthResponse authResponse = new AuthResponse("Autorizado, Con el token: " + token, HttpStatus.UNAUTHORIZED.value(), true);
        response.setContentType("application/json");
        response.addHeader("Authorization", "Bearer " + token);
        //response.getWriter().flush();


        response.setStatus(HttpStatus.OK.value());
        response.getWriter().write(new ObjectMapper().writeValueAsString(authResponse));


        //super.successfulAuthentication(request, response, chain, authResult);
    } //close method
} //close class
