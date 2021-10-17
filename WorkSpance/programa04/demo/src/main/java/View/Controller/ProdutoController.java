package View.Controller;

public class ProdutoController {

}
package com.ProvaFinal.controller;

import java.util.List;

import com.ProvaFinal.model.Produto;
import com.ProvaFinal.service.ProdutoServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    ProdutoServiceImpl servicoProduto;

    @GetMapping
    public List<Produto> obterTodos() {
        return servicoProduto.obterTodos();
    }

    @GetMapping("/{id}")
    public Produto obterPorId(@PathVariable String id) {
        return servicoProduto.obterPorId(id);
    }

    @PostMapping
    public Produto adicionar(@RequestBody Produto produto) {
        return servicoProduto.adicionar(produto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id) {
        servicoProduto.deletar(id);
    }

    @PutMapping("/{id}")
    public Produto atualizar(
        @PathVariable String id, 
        @RequestBody Produto produto){
            
        return servicoProduto.atualizar(id, produto);
    }