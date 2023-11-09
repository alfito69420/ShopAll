package com.example.metaphorce.security;

import com.example.metaphorce.model.Rol;
import com.example.metaphorce.model.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 *
 */
@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private final UserEntity user;
    //private List<Rol> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Rol> roles = user.getRoles().stream().toList();

        /*return roles.stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getRol()))
                .collect(Collectors.toList());*/

        return roles.stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getRol()))
                .collect(Collectors.toList());

        //return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return user.getContrasena();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getNombre() {
        return user.getNombre();
    }
} //close class
