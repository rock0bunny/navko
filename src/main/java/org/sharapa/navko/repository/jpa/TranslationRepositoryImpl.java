package org.sharapa.navko.repository.jpa;

import org.sharapa.navko.model.Translation;
import org.sharapa.navko.repository.TranslationRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class TranslationRepositoryImpl implements TranslationRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Translation translation) throws DataAccessException {
        if (translation.getId() == null) {
            this.em.persist(translation);
        } else {
            this.em.merge(translation);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Translation> findByTranslatableId(Integer translatableId) {
        Query query = this.em.createQuery("SELECT t FROM Translation t where t.object.id= :id");
        query.setParameter("id", translatableId);
        return query.getResultList();
    }
}
