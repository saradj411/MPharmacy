package com.isaProject.isa.Model.DTO;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.Date;

public class DrugPricelistDTO {
    private String name;

    private double price;

    private LocalDate start;

    private LocalDate end;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public DrugPricelistDTO() {
    }

    public DrugPricelistDTO(String name, double price, LocalDate start, LocalDate end) {
        this.name = name;
        this.price = price;
        this.start = start;
        this.end = end;
    }
}
