package com.ProvaFinal.controller;

import java.util.List;

import com.ProvaFinal.model.Venda;
import com.ProvaFinal.service.VendaServiceImpl;

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
@RequestMapping("/api/vendas")
public class VendaController {

    @Autowired
    VendaServiceImpl servicoVenda;

    @GetMapping
    public List<Venda> obterTodos() {
        return servicoVenda.obterTodos();
    }

    @GetMapping("/{id}")
    public Venda obterPorId(@PathVariable String id) {

        return servicoVenda.obterPorId(id);
    }

    @PostMapping
    public Venda adicionar(@RequestBody Venda fornecedor) {
        return servicoVenda.adicionar(fornecedor);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id) {
        servicoVenda.deletar(id);
    }

    @PutMapping("/{id}")
    public Venda atualizar(
        @PathVariable String id, 
        @RequestBody Venda fornecedor){
            
        return servicoVenda.atualizar(id, fornecedor);
    }
