package org.acme.kafka.model;

public class Quote {
    
    public String id;
    public int price;

    public Quote() {  }

    public Quote(String id, int price) {
        this.id = id;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Quote { " + "id=" + id + "price=" + price + " }";
    }
}