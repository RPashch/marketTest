package com.springapp.market.model;

import javax.persistence.*;

/**
 * Created on 22.05.2017
 *
 * Simple JavaBean object that represents products of {@link Company}.
 *
 * @author Roman Hayda
 */
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="company_id", nullable=false)
    private Company producer;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Company getProducer() {
        return producer;
    }

    public void setProducer(Company producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", producer=" + producer +
                '}';
    }
}