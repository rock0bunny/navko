package org.sharapa.navko.repository;

import org.sharapa.navko.model.MenuItem;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface MenuItemRepository {

    MenuItem findById(int id) throws DataAccessException;

    List<MenuItem> findAll()  throws DataAccessException;

    void save(MenuItem menuItem) throws DataAccessException;
}
