package org.sharapa.navko.repository.jpa;

import org.sharapa.navko.model.Product;
import org.sharapa.navko.repository.ProductRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Product findById(Integer id) throws DataAccessException {
        return this.em.find(Product.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Product> findByCategoryId(Integer categoryId) throws DataAccessException {
        Query query = this.em.createQuery("SELECT p FROM Product p left join fetch p.translations where p.category.id= :id");
        query.setParameter("id", categoryId);
        return query.getResultList();
    }

    @Override
    public void save(Product product) throws DataAccessException {
        if (product.getId() == null) {
            this.em.persist(product);
        } else {
            this.em.merge(product);
        }
    }

}
