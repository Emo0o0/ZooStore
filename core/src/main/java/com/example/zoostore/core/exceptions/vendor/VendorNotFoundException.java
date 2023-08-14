package com.example.zoostore.core.exceptions.vendor;

public class VendorNotFoundException extends RuntimeException{

    public VendorNotFoundException(String message){
        super(message);
    }
}
