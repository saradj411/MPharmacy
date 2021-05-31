package com.isaProject.isa.Model.DTO;

import com.isaProject.isa.Model.Users.PharmacyAdmin;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class DrugOrderDTO {
    private Integer id;//pokusati vratiti id admina
    private LocalDate timeLimit;
    private Set<OrderItemDTO> orderItemDTO;
    private Boolean processed;

    public DrugOrderDTO() {
    }

    public DrugOrderDTO(Integer id, LocalDate timeLimit, Set<OrderItemDTO> orderItemDTO, Boolean processed) {
        this.id = id;
        this.timeLimit = timeLimit;
        this.orderItemDTO = orderItemDTO;
        this.processed = processed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
