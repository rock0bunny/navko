package org.sharapa.navko.repository.jpa;

import org.sharapa.navko.model.Category;
import org.sharapa.navko.model.MenuItem;
import org.sharapa.navko.repository.CategoryRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Category findById(Integer id) throws DataAccessException {
        return this.em.find(Category.class, id);
    }

    @Override
    public List<Category> findAll() throws DataAccessException {
        Query query = this.em.createQuery("SELECT category FROM Category category left join fetch category.translations left join fetch category.products");
        return query.getResultList();
    }

    @Override
    public void save(Category category) throws DataAccessException {
        if (category.getId() == null) {
            this.em.persist(category);
        } else {
            this.em.merge(category);
        }
    }

}
