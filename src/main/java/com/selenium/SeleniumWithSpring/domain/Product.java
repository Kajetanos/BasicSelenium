package com.selenium.SeleniumWithSpring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;
    private String description ;
    private String price ;
    private String condition ;
    private String deliveryToPoland;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getDeliveryToPoland() {
        return deliveryToPoland;
    }

    public void setDeliveryToPoland(String deliveryToPoland) {
        this.deliveryToPoland = deliveryToPoland;
    }

    public Product(String description , String price, String condition ){
        this.description = description;
        this.price = price;
        this.condition = condition;
    }
    public Product(){

    }
}
