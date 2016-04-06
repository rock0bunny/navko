package org.sharapa.navko.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "category")
public class Category extends Translatable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<Product> products;

    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected List<Product> getProductsInternal() {
        if (this.products == null) {
            this.products = new ArrayList<>();
        }
        return this.products;
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(getProductsInternal());
    }

    public void addProduct(Product product) {
        getProductsInternal().add(product);
    }

    public void removeProduct(Product product) {
        getProductsInternal().remove(product);
    }
}
