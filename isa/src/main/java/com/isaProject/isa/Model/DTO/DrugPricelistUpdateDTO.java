package com.isaProject.isa.Model.DTO;

import java.util.Date;

public class DrugPricelistUpdateDTO {


    private String name;


    private double price;


    private Date start;



    private Date end;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public DrugPricelistUpdateDTO(String name, double price, Date start, Date end) {
        this.name = name;
        this.price = price;
        this.start = start;
        this.end = end;
    }

    public DrugPricelistUpdateDTO(){

    }
}
