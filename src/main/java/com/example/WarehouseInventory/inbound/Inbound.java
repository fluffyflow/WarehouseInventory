package com.example.WarehouseInventory.inbound;


import jakarta.persistence.*;
import org.attoparser.trace.MarkupTraceEvent;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="inbound")
public class Inbound {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String reference;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateReceived;

    @Column(length = 50)
    private String productSku;

    @Column(length = 50)
    private int quantity;

    @Column(length = 50)
    private String location;

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

    public LocalDate getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(LocalDate dateReceived) {
        this.dateReceived = dateReceived;
    }

    public String getProductSku() {
        return productSku;
    }

    public void setProductSku(String productSku) {
        this.productSku = productSku;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
//
//    public void generateRef(String latestRef) {
//        try {
//            if (latestRef != null && latestRef.startsWith("INBOUND")) {
//                int numericPart = Integer.parseInt(latestRef.substring(7)); // Assuming the numeric part starts from index 7
//                numericPart++;
//                this.reference = "INBOUND" + numericPart;
//            } else {
//                // If latestRef is null or not in the expected format, set a default reference
//                this.reference = "INBOUND1";
//            }
//        } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
//            System.err.println("Error generating reference: " + e.getMessage());
//            // If an error occurs, set a default reference
//            this.reference = "INBOUND1";
//        }
//        System.out.println("Generated reference: " + this.reference); // Log the generated reference
//    }


    @Override
    public String toString() {
        return "Inbound{" +
                "id=" + id +
                ", reference='" + reference + '\'' +
                ", dateReceived=" + dateReceived +
                ", productSku='" + productSku + '\'' +
                ", quantity=" + quantity +
                ", location='" + location + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
