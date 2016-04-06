package org.sharapa.navko.repository.jpa;

import org.sharapa.navko.model.News;
import org.sharapa.navko.repository.NewsRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class NewsRepositoryImpl implements NewsRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public News findById(int id) throws DataAccessException {
        return this.em.find(News.class, id);
    }

    @Override
    public List<News> findAll() throws DataAccessException {
        Query query = this.em.createQuery("SELECT news FROM News news left join fetch news.translations " +
                "order by news.date");
        return query.getResultList();
    }

    @Override
    public void save(News news) throws DataAccessException {
        if (news.getId() == null) {
            this.em.persist(news);
        } else {
            this.em.merge(news);
        }
    }
}
