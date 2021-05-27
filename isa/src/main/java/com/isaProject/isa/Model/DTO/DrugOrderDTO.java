package com.isaProject.isa.Model.DTO;

import com.isaProject.isa.Model.Users.PharmacyAdmin;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class DrugOrderDTO {
    private PharmacyAdmin pharmacyAdmin;//pokusati vratiti id admina
    private LocalDate timeLimit;
    private Set<OrderItemDTO> orderItemDTO;
    private Boolean processed;

    public DrugOrderDTO() {
    }

    public DrugOrderDTO(PharmacyAdmin pharmacyAdmin, LocalDate timeLimit, Set<OrderItemDTO> orderItemDTO, Boolean processed) {
        this.pharmacyAdmin = pharmacyAdmin;
        this.timeLimit = timeLimit;
        this.orderItemDTO = orderItemDTO;
        this.processed = processed;
    }

    public PharmacyAdmin getPharmacyAdmin() {
        return pharmacyAdmin;
    }

    public void setPharmacyAdmin(PharmacyAdmin pharmacyAdmin) {
        this.pharmacyAdmin = pharmacyAdmin;
    }

    public LocalDate getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(LocalDate timeLimit) {
        this.timeLimit = timeLimit;
    }

    public Set<OrderItemDTO> getOrderItemDTO() {
        return orderItemDTO;
    }

    public void setOrderItemDTO(Set<OrderItemDTO> orderItemDTO) {
        this.orderItemDTO = orderItemDTO;
    }

    public Boolean getProcessed() {
        return processed;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }
}
