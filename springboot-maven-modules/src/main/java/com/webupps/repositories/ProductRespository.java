package com.webupps.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.webupps.model.Product;

@Transactional
@Repository
public interface ProductRespository extends CrudRepository<Product,Integer> {

}
