package com.ProvaFinal.service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;

import com.ProvaFinal.model;
import com.ProvaFinal.repository;
import com.ProvaFinal.model.Produto;
import com.ProvaFinal.shared.ProdutoDTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoserviceImpl implements ProdutoService {

    @Autowired
    RepositoryProduto repositoryProduto;

    @Override
    public List<ProdutoDTO> obterTodos() {
        List<Produto> Produto = repositoryProduto.findALL();

        ModelMapper mapper = new ModelMapper();

        return Produto.stream().map(jogo -> mapper.map(Produto, ProdutoDTO.class)).collet(colletors.toList());

    }

    @Override
    public ProdutoDTo adicionar(ProdutoDtO ProdutoDTO) {

        ModelMapper mapper = new MOdelMapper();

        Produto produto = mapper.map(ProdutoDTo, produto.class);

        Produto.setId(null);

        Produto = repositoryproduto.save(Produto);

        return mapper.map(Produto.ProdutoDTO.class);
    }

    @Override
    public Optional<ProdutoDTO> obterPorId(String idproduto) {

        Optional<Produto> Optionalproduto = RepositoryProduto.findById(idProduto);

        if (Optionalproduto.isEmpty()) {
            throw new InputMismatchException("Não foi encontrada o Produto com o id: " + idProduto);
        }
        ProdutoDTO produtoDto = new ModelMapper().map(optionalProduto.get(), ProdutoDTO.class);

        return Optional.of(ProdutoDto);
    }

    @Override
    public void delete(String idProduto) {

        repositoryproduto.deleteById(idProduto);
    }

    @Override
    public ProdutoDTO atualizar(String id, ProdutoDTO ProdutoDto) {

        ProdutoDto.setId(id);

        Produto produto = new ModelMapper().map(ProdutoDto, Produto.class);
        repositorioProduto.save(Produto);

        return ProdutoDto;
    }

}