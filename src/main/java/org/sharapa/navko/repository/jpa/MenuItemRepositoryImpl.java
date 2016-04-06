package org.sharapa.navko.repository.jpa;

import org.sharapa.navko.model.MenuItem;
import org.sharapa.navko.repository.MenuItemRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class MenuItemRepositoryImpl implements MenuItemRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public MenuItem findById(int id) throws DataAccessException {
        return this.em.find(MenuItem.class, id);
    }

    @Override
    public List<MenuItem> findAll() throws DataAccessException {
        Query query = this.em.createQuery("SELECT menuitem FROM MenuItem menuitem left join fetch menuitem.translations  " +
                "ORDER BY menuitem.position");
        return query.getResultList();
    }

    @Override
    public void save(MenuItem menuItem) throws DataAccessException {
        if (menuItem.getId() == null) {
            this.em.persist(menuItem);
        } else {
            this.em.merge(menuItem);
        }
    }
}
