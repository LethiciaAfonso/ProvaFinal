
package com.ProvaFinal.repository;

import com.ProvaFinal.model.Produto;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto>, String> {
    
}