package net.resto.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    private int id;

    private String name;
    private String description;

    @Column(nullable = true)
    private Double price; // Nullable price field

    @Lob
    @Column(name = "data", columnDefinition = "BLOB")
    private byte[] data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Order() {
    }

    public Order(int id, String name, String description, Double price, byte[] data) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.data = data;
    }
}
