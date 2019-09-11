/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sermed.modelDao;

import br.com.sermed.model.Produto;
import br.com.sermed.repositories.ProdutoRepository;
import br.com.sermed.tables.TableModel_Produtos;
import br.com.sermed.view.TelaEstoque;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author joão.furtado
 */
@Service
public class ProdutosService implements ActionListener {

    @Autowired
    private ProdutoRepository repository;
    private TableModel_Produtos model;
    private TelaEstoque form;
    
    public ProdutosService() {
        model = new TableModel_Produtos();
    }

    public void setForm(TelaEstoque form) {
        this.form = form;
        model = new TableModel_Produtos(listar());
        form.getTbTabelaEstoque().setModel(model);
    }

    public TableModel_Produtos getModel() {
        return model;
    }
    
    public boolean saveOrUpdate() {
        try {
            model.addProduto(repository.save(getProduto()));
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public Produto getProduto() {
        return new Produto(Integer.parseInt(form.getTxtCodigo().getText()),
                form.getTxtNome().getText(),
                Integer.parseInt(form.getTxtQuantidade().getText()),
                Double.parseDouble(form.getTxtPreco().getText()));
    }

    public Produto findByCodigo(int codigo) {
        return repository.findByCodigo(codigo);
    }

    public void deletar() {
        repository.delete(model.getProduto(form.getTbTabelaEstoque().getSelectedRow()));
        model.removerProduto(form.getTbTabelaEstoque().getSelectedRow());
    }
    public List<Produto> listar() {
        return repository.findAll();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "save":
            case "alterar":
                saveOrUpdate();
                break;
            case "delete":
                deletar();
                break;
            case "listar":
                listar();
                break;
        }
    }

}
