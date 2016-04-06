package org.sharapa.navko.repository;

import org.sharapa.navko.model.Translation;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface TranslationRepository {

    void save(Translation translation) throws DataAccessException;

    List<Translation> findByTranslatableId(Integer translatableId);
}
