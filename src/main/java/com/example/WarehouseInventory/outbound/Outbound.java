package com.example.WarehouseInventory.outbound;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.thymeleaf.expression.Dates;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "outbound")
public class Outbound {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(length = 15, nullable = false, unique = true)
        private Integer id;

        @Column (length = 50)
        private String reference;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateShip;

        @Column(length = 50)
        private String productSKU;

        @Column(length = 50)
        private Integer quantity;

        @Column(length = 50)
        private String destination;

        @Column(length = 100)
        private String remarks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public LocalDate getDateShip() {
        return dateShip;
    }

    public void setDateShip(LocalDate dateShip) {
        this.dateShip = dateShip;
    }

    public String getProductSKU() {
        return productSKU;
    }

    public void setProductSKU(String productSKU) {
        this.productSKU = productSKU;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Outbound{" +
                "id=" + id +
                ", reference='" + reference + '\'' +
                ", dateShip=" + dateShip +
                ", productSKU='" + productSKU + '\'' +
                ", quantity=" + quantity +
                ", destination='" + destination + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}



