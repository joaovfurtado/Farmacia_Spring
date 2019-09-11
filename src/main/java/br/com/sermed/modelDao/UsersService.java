/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sermed.modelDao;

import br.com.sermed.model.Users;
import br.com.sermed.propridedades.Propriedades;
import br.com.sermed.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author joão.furtado
 */
@Service
public class UsersService {

    @Autowired
    private UsersRepository repository;

    public boolean validaLogin(String login, String password) {
        Propriedades.setUser(repository.findByLogin(login));
        return Propriedades.getUser() != null;
    }

    public boolean save(Users user) {
        return repository.save(user).getId() != null;
    }

}
