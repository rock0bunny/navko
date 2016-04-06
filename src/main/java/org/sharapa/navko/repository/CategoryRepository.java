package org.sharapa.navko.repository;

import org.sharapa.navko.model.Category;
import org.sharapa.navko.model.MenuItem;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface CategoryRepository {

    Category findById(Integer id) throws DataAccessException;

    List<Category> findAll()  throws DataAccessException;

    void save(Category category) throws DataAccessException;
}
