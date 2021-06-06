package com.isaProject.isa.Model.DTO;

import java.util.PrimitiveIterator;

public class MonthlyReportForExaminationDTO {

    private String day;

    private Integer numberOfExamination;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Integer getNumberOfExamination() {
        return numberOfExamination;
    }

    public void setNumberOfExamination(Integer numberOfExamination) {
        this.numberOfExamination = numberOfExamination;
    }

    public MonthlyReportForExaminationDTO(String day, Integer numberOfExamination) {
        this.day = day;
        this.numberOfExamination = numberOfExamination;
    }

    public MonthlyReportForExaminationDTO() {
    }
}
