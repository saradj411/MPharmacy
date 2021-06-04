package com.isaProject.isa.Controllers;


import com.isaProject.isa.Model.DTO.AnnualReportDTO;
import com.isaProject.isa.Model.DTO.ExaminationQuarterDTO;
import com.isaProject.isa.Model.DTO.FrontCreatedExaminationDTO;
import com.isaProject.isa.Model.DTO.MonthlyReportForExaminationDTO;
import com.isaProject.isa.Services.Implementations.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value="/reports")
@Slf4j

public class ReportsController {


    @Autowired
    ReportService reportService;


    @GetMapping(value = "/monthlyReport/{idAdmina}/{month}")
    public ResponseEntity<List<MonthlyReportForExaminationDTO>> findCreatedPharmacistExamination(@PathVariable Integer idAdmina, @PathVariable Integer month) {
        //log.info("dsds:"+id);
        List<MonthlyReportForExaminationDTO> pharm=reportService.monthlyReport(idAdmina,month);
        return pharm == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(pharm);
    }


    @GetMapping(value = "/annualReport/{idAdmina}")
    public ResponseEntity<AnnualReportDTO> findCreatedPharmacistExamination(@PathVariable Integer idAdmina) {
        //log.info("dsds:"+id);

        AnnualReportDTO pharm=reportService.annualReportDTO(idAdmina, LocalDate.now().getYear());
        return pharm == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(pharm);
    }

    @GetMapping(value = "/examinationQuarter/{idAdmina}")
    public ResponseEntity<ExaminationQuarterDTO> examinationQuarter(@PathVariable Integer idAdmina) {
        //log.info("dsds:"+id);

        ExaminationQuarterDTO pharm=reportService.examinationQuarter(idAdmina, LocalDate.now().getYear());
        return pharm == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(pharm);
    }

}
