package org.sharapa.navko.repository;

import org.sharapa.navko.model.News;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface NewsRepository {

    News findById(int id) throws DataAccessException;

    List<News> findAll()  throws DataAccessException;

    void save(News menuItem) throws DataAccessException;
}
