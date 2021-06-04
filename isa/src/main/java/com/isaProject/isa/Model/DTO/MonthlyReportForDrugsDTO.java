package com.isaProject.isa.Model.DTO;

public class MonthlyReportForDrugsDTO {
    private String drug;

    private Integer number;

    public String getDrug() {
        return drug;
    }

    public void setDrug(String drug) {
        this.drug = drug;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public MonthlyReportForDrugsDTO(String drug, Integer number) {
        this.drug = drug;
        this.number = number;
    }

    public MonthlyReportForDrugsDTO() {
    }
}
