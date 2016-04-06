package org.sharapa.navko.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product extends Translatable {

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        if (this.category == null) {
            this.category = category;
            category.addProduct(this);
        } else {
            this.category.removeProduct(this);
            this.category = category;
            category.addProduct(this);
        }
    }
}
