package com.example.metaphorce.security;

import com.example.metaphorce.model.UserEntity;
import com.example.metaphorce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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
    } //close method
} //close class
