package org.sharapa.navko.service;

import org.sharapa.navko.model.Category;
import org.sharapa.navko.model.MenuItem;
import org.sharapa.navko.model.News;
import org.sharapa.navko.model.Product;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface NavkoService {

    void saveMenuItem(MenuItem menuItem) throws DataAccessException;

    MenuItem findMenuItemById(Integer id) throws DataAccessException;

    List<MenuItem> getMenuItems() throws DataAccessException;

    List<Product> getProductsByCategory(Category category) throws DataAccessException;

    List<News> getNews() throws DataAccessException;

    void saveNews(News news) throws DataAccessException;

    void saveCategory(Category category) throws DataAccessException;

    List<Category> getCategories() throws DataAccessException;

    void saveProduct(Product product) throws DataAccessException;
}
