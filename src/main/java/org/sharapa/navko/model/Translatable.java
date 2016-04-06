package org.sharapa.navko.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Translatable {


    @TableGenerator(name = "TRANSL_GEN", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TRANSL_GEN")
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "object")
    private Set<Translation> translations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    protected Set<Translation> getTranslationsInternal() {
        if (this.translations == null) {
            this.translations = new HashSet<>();
        }
        return this.translations;
    }

    public Set<Translation> getTranslations() {
        return Collections.unmodifiableSet(getTranslationsInternal());
    }

    public void setTranslations(Set<Translation> translations) {
        this.translations = translations;
        for (Translation translation: translations) {
            translation.setObject(this);
        }
    }

    public void addTranslation(Translation translation) {
        getTranslationsInternal().add(translation);
        translation.setObject(this);
    }

    public Translation getTranslationByLang(String lang) {
        Translation defaultTranslation = new Translation();
        for (Translation translation : getTranslationsInternal()) {
            if (translation.getLang().equals(lang)) {
                return translation;
            }
            if (translation.isDefaultLang()) {
                defaultTranslation = translation;
            }
        }
        return defaultTranslation;
    }
}
