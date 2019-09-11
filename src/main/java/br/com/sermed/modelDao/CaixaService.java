/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sermed.modelDao;

import br.com.sermed.model.Caixa;
import br.com.sermed.repositories.CaixaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author joão.furtado
 */
@Service
public class CaixaService {

    @Autowired
    private CaixaRepository repository;

    public boolean saveOrUpdate(Caixa caixa) {
        return repository.save(caixa).getNum_venda() != null;
    }

}
