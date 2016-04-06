package org.sharapa.navko.model;

import javax.persistence.*;

@Entity
@Table(name = "translation")
public class Translation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @ManyToOne
    @JoinColumn(name = "object_id")
    private Translatable object;

    @Column(name = "lang")
    private String lang;

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

    @Column(name = "is_default_lang")
    private Boolean isDefaultLang;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Translatable getObject() {
        return object;
    }

    public void setObject(Translatable object) {
        this.object = object;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean isDefaultLang() {
        return isDefaultLang;
    }

    public void setDefaultLang(Boolean defaultLang) {
        isDefaultLang = defaultLang;
    }
}
