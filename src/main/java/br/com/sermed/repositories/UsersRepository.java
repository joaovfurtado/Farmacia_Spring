/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sermed.repositories;

import br.com.sermed.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author joão.furtado
 */
public interface UsersRepository extends JpaRepository<Users, String>{
    public Users findByLogin(String login);
}
