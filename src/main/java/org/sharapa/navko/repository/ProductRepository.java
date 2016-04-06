package org.sharapa.navko.repository;

import org.sharapa.navko.model.Product;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface ProductRepository {

    Product findById(Integer id) throws DataAccessException;

    List<Product> findByCategoryId(Integer categoryId)  throws DataAccessException;

    void save(Product product) throws DataAccessException;
}
