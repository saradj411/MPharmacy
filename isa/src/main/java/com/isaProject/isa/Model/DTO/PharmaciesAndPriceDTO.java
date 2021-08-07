package com.isaProject.isa.Model.DTO;

public class PharmaciesAndPriceDTO {

    private String name;
    private String address;
    private String city;

    private double price;

    public PharmaciesAndPriceDTO(){};

    public PharmaciesAndPriceDTO(String name, String address, String city, double price) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PharmaciesAndPriceDTO{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", price=" + price +
                '}';
    }
}
