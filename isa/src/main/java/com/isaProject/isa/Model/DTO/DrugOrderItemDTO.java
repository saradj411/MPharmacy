package com.isaProject.isa.Model.DTO;

public class DrugOrderItemDTO {

    private Integer idItemOrder;
    private Integer idDrug;
    private String nameDrug;
    private Integer quantity;
    private String manufacturuer;

    public DrugOrderItemDTO(){}

    public DrugOrderItemDTO(Integer idItemOrder, Integer idDrug, String nameDrug, Integer quantity, String manufacturuer) {
        this.idItemOrder = idItemOrder;
        this.idDrug = idDrug;
        this.nameDrug = nameDrug;
        this.quantity = quantity;
        this.manufacturuer = manufacturuer;
    }

    public Integer getIdItemOrder() {
        return idItemOrder;
    }

    public void setIdItemOrder(Integer idItemOrder) {
        this.idItemOrder = idItemOrder;
    }

    public Integer getIdDrug() {
        return idDrug;
    }

    public void setIdDrug(Integer idDrug) {
        this.idDrug = idDrug;
    }

    public String getNameDrug() {
        return nameDrug;
    }

    public void setNameDrug(String nameDrug) {
        this.nameDrug = nameDrug;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getManufacturuer() {
        return manufacturuer;
    }

    public void setManufacturuer(String manufacturuer) {
        this.manufacturuer = manufacturuer;
    }
}
