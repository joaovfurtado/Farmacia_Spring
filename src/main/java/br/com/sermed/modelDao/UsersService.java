/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sermed.modelDao;

import br.com.sermed.model.Users;
import br.com.sermed.propridedades.Propriedades;
import br.com.sermed.repositories.UsersRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author joão.furtado
 */
@Service
public class UsersService implements UserDetailsService, UserDetailsPasswordService {

    @Autowired
    private UsersRepository repository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private DaoAuthenticationProvider service;

    public boolean validaLogin(String login, String password) {
        Propriedades.setUser(repository.findByLogin(login));
        return Propriedades.getUser() != null;
    }

    public boolean save(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user).getId() != null;
    }

    @Override
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
        return repository.findByLogin(user);
    }

    @Override
    public UserDetails updatePassword(UserDetails ud, String string) {
        return null;
    }

    @Bean
    public BCryptPasswordEncoder getBCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public Authentication authentication(String login, String senha) {
        Authentication authentication = service.authenticate(new UsernamePasswordAuthenticationToken(login, senha, Arrays.asList(new SimpleGrantedAuthority("ADMIN"))));
        Propriedades.setUser((Users) authentication.getPrincipal());
        return authentication;
    }

    @Bean
    public DaoAuthenticationProvider getProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(this);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        return daoAuthenticationProvider;
    }
}
