package com.example.model.entity.products;

import com.example.model.entity.categories.Category;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", length = 100, unique = true, nullable = false)
    private String productName;
    @Column(name = "price", nullable = false)
    private Double price;
    @Column(name = "image", length = 255)
    private String image;
    @Column(name = "status")
    @ColumnDefault("1")
    private Boolean status;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    public Product() {
    }

    public Product(int id, String productName, Double price, String image, Boolean status, Category category) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.image = image;
        this.status = status;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
