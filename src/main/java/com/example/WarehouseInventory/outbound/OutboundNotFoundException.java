package com.example.WarehouseInventory.outbound;

public class OutboundNotFoundException extends Throwable {
    public OutboundNotFoundException(String message) {
        super(message);
    }
}
