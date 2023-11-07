package com.example.metaphorce.security;

import com.example.metaphorce.domain.AuthResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.*;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.NegatedRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfig {

    private final UserDetailsService userDetailsService;
    private final JWTAuthorizationFilter jwtAuthorizationFilter;

    @Autowired
    private CustomAccessDeniedHandler accessDeniedHandler;


    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity,
                                    AuthenticationManager authenticationManager) throws Exception {

        JWTAuthenticationFilter jwtAuthenticationFilter = new JWTAuthenticationFilter();
        jwtAuthenticationFilter.setAuthenticationManager(authenticationManager);
        jwtAuthenticationFilter.setFilterProcessesUrl("/login");

        return httpSecurity
                .csrf().disable()
                .authorizeRequests()
                .requestMatchers("/api/v1/producto/all").permitAll()
                .requestMatchers("api/v1/producto/getOne/**").permitAll()
                .requestMatchers("api/v1/user/create").permitAll()
                //.requestMatchers("/login").permitAll()
                .requestMatchers("api/v1/roles/accessAdmin").hasRole("Admin")
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(jwtAuthenticationFilter)
                .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
                // Agregar manejo de excepciones
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler)
                .authenticationEntryPoint((request, response, authException) -> {
                    AuthResponse authResponse = new AuthResponse("Autenticación fallida: NO TIENES AXCESO", HttpStatus.UNAUTHORIZED.value(), false);
                    response.setContentType("application/json");
                    response.setStatus(HttpStatus.UNAUTHORIZED.value());
                    response.getWriter().write(new ObjectMapper().writeValueAsString(authResponse));
                })
                .and()
                .build();

    } //close method

    /**
     * Metodo que hardcodea las credenciales de usuario
     * para el login de la api
     *
     * @return el manager con las credenciales
     */
/*    @Bean
    UserDetailsService userDetailsService() {
        //  Carga usuarios en memoria
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("admin")
                .password(passwordEncoder().encode("admin"))
                .roles()
                .build());
        return manager;
    } //close method*/

    /**
     *
     *
     * @param httpSecurity
     * @param passwordEncoder
     * @return httpSecurity
     * @throws Exception
     */
    @Bean
    AuthenticationManager authenticationManager(HttpSecurity httpSecurity,
                                                PasswordEncoder passwordEncoder) throws Exception {
        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder())
                .and()
                .build();
    } //close method

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    } //close method

    public static void main(String[] args) {
        System.out.println("pass: " + new BCryptPasswordEncoder().encode("contrasena1"));
    }
} //close class
