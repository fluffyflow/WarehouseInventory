package com.example.WarehouseInventory.inbound;

public class InboundNotFoundException extends Throwable{
    public  InboundNotFoundException(String message){
        super(message);
    }
}
