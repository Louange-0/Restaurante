package net.resto.entity;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;

    @Column(nullable = true)
    private Double price; // Nullable price field

    @Lob
    @Column(name = "data", columnDefinition = "BLOB")
    private byte[] data;

    public Product() {
        // Default constructor is required by JPA
    }

    public Product(String name, String description, Double price, byte[] data) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.data = data;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public byte[] getData() {
        return data;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                // Don't print out data as it can be very large and not useful in logs
                ", data=" + (data != null ? data.length + " bytes" : "null") +
                '}';
    }
}
