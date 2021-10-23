package com.ProvaFinal.service;

import java.util.List;

import com.ProvaFinal.model.Produto;

public interface ProdutoService {

    List<Produto> obterTodos();

    Produto obterPorId(String idProduto);

    Produto adicionar(Produto produto);

    Produto atualizar(String idProduto, Produto produto);

    void deletar(String idProduto);

}
