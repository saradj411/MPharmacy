package com.isaProject.isa.Model.DTO;

import java.time.LocalDate;

public class DrugOrderFrontDTO {
    public Integer idOrder;
    private LocalDate timeLimit;

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public LocalDate getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(LocalDate timeLimit) {
        this.timeLimit = timeLimit;
    }

    public DrugOrderFrontDTO() {
    }

    public DrugOrderFrontDTO(Integer idOrder, LocalDate timeLimit) {
        this.idOrder = idOrder;
        this.timeLimit = timeLimit;
    }
}
