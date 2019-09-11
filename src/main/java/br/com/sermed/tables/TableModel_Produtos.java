/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sermed.tables;

import br.com.sermed.model.Produto;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author joão.furtado
 */
public class TableModel_Produtos extends AbstractTableModel {

    private static final long serialVersionUID = 8864124562452416125L;

    private final List<Produto> lista;
    private final String[] columnsname = {"Código", "Nome", "Quantidade", "Preço"};

    public TableModel_Produtos() {
        lista = new ArrayList();
    }

    public TableModel_Produtos(List<Produto> lista) {
        this.lista = lista;
        sortList();
    }

    public Double getValorTotal() {
        return lista.stream().map(Produto::getPreco).reduce(0d, (a, b) -> a + b);
    }
    public void sortList(){
        setList(lista.stream().sorted(Comparator.comparing(Produto::getCodigo,Integer::compareTo))
                .collect(Collectors.toList()));
    }

    public void limparLista() {
        lista.clear();
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return columnsname.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Produto p = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getCodigo();
            case 1:
                return p.getNome();
            case 2:
                return p.getQuantidade();
            case 3:
                return p.getPreco();
            default:
                return null;
        }
    }

    public void setList(List<Produto> p) {
        this.lista.clear();
        this.lista.addAll(p);
        fireTableDataChanged();
    }

    public List<Produto> getList() {
        return lista;
    }

    public void addProduto(Produto p) {
        Optional<Produto> op = lista.stream().filter(pd-> pd.getCodigo().equals(p.getCodigo())).findFirst();
        if (op.isPresent()) {
            lista.set(lista.indexOf(op.get()), p);
        } else {
            lista.add(p);
        }
        sortList();
        fireTableDataChanged();
    }

    public Produto getProduto(int index) {
        return lista.get(index);
    }

    public void removerProduto(Produto p) {
        removerProduto(lista.lastIndexOf(p));
    }

    public void removerProduto(int index) {
        lista.remove(index);
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return columnsname[column];
    }

}
