package com.example.metaphorce.security;

import com.example.metaphorce.model.Rol;
import com.example.metaphorce.model.UserEntity;
import com.example.metaphorce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase que se encarga de cargar
 * usuarios hacia la base de datos
 * desde la informacion que se le
 * mande
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        UserEntity user = userRepository
                .findOneByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario con el email: "
                        + email + " no existe."));

        return new UserDetailsImpl(user);
        //return new User(user.getNombre(), user.getContrasena(), getAuthorities(user.getRoles()));
    } //close method

    private Collection<? extends GrantedAuthority> getAuthorities(List<Rol> roles) {
        return roles.stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getRol()))
                .collect(Collectors.toList());
    }
} //close class
