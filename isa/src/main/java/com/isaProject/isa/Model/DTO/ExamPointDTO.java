package com.isaProject.isa.Model.DTO;

public class ExamPointDTO {

    private Integer idExamination;
    private Integer points;

    public  ExamPointDTO(){}
    public ExamPointDTO(Integer idExamination, Integer points) {
        this.idExamination = idExamination;
        this.points = points;
    }

    public Integer getIdExamination() {
        return idExamination;
    }

    public void setIdExamination(Integer idExamination) {
        this.idExamination = idExamination;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
