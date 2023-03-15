package br.edu.ifsp.pep.tables.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "produto")
public class Produto implements Serializable{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "code", length = 20, nullable = false)
    private String code;
    
    @Column(name = "name", length = 40, nullable = false)
    private String name;
    
    @Column(name = "description", length = 100, nullable = false)
    private String description;
    
    @Column(name = "image", length = 100, nullable = false)
    private String image;
    
    @Column(name = "price", precision = 8, scale = 2, nullable = false)
    private double price;
    
    @Column(name = "category", length = 40, nullable = false)
    private String category;
    
    @Column(name = "quantity", nullable = false)
    private Integer quantity;
    
    @Column(name = "rating", nullable = false)
    private Integer rating;

    //
    public Produto() {
    }

    public Produto(int id, String code, String name, String description, String image, double price, String category, Integer quantity, Integer rating) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

}
