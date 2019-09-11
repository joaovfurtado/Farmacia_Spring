/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sermed.repositories;

import br.com.sermed.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author joão.furtado
 */
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    public Produto findByCodigo(Integer codigo);
}
