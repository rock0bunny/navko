package org.sharapa.navko.service;

import org.sharapa.navko.model.Category;
import org.sharapa.navko.model.MenuItem;
import org.sharapa.navko.model.News;
import org.sharapa.navko.model.Product;
import org.sharapa.navko.repository.CategoryRepository;
import org.sharapa.navko.repository.MenuItemRepository;
import org.sharapa.navko.repository.NewsRepository;
import org.sharapa.navko.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NavkoServiceImpl implements NavkoService {

    private MenuItemRepository menuItemRepository;
    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;
    private NewsRepository newsRepository;

    @Autowired
    public NavkoServiceImpl(MenuItemRepository menuItemRepository, CategoryRepository categoryRepository,
                            ProductRepository productRepository, NewsRepository newsRepository) {
        this.menuItemRepository = menuItemRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.newsRepository = newsRepository;
    }

    @Override
    @Transactional
    public void saveMenuItem(MenuItem menuItem) throws DataAccessException {
        menuItemRepository.save(menuItem);
    }

    @Override
    @Transactional(readOnly = true)
    public MenuItem findMenuItemById(Integer id) throws DataAccessException {
        return menuItemRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MenuItem> getMenuItems() throws DataAccessException {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getProductsByCategory(Category category) throws DataAccessException {
        return productRepository.findByCategoryId(category.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public List<News> getNews() throws DataAccessException {
        return newsRepository.findAll();
    }

    @Override
    @Transactional
    public void saveNews(News news) throws DataAccessException {
        newsRepository.save(news);
    }

    @Override
    @Transactional
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    @Transactional
    public void saveProduct(Product product) {
        productRepository.save(product);
    }
}
