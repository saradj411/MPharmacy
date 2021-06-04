package com.isaProject.isa.Controllers;


import com.isaProject.isa.Model.DTO.*;
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


    @GetMapping(value = "/monthlyReportDrugs/{idAdmina}")
    public ResponseEntity<List<MonthlyReportForDrugsDTO>> monthlyReportForDrug(@PathVariable Integer idAdmina) {
        //log.info("dsds:"+id);
        List<MonthlyReportForDrugsDTO> pharm=reportService.monthlyReportForDrugs(idAdmina);
        return pharm == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(pharm);
    }


    @GetMapping(value = "/annualReportDrug/{idAdmina}")
    public ResponseEntity<AnnualReportForDrugs> AnnualDrugReport(@PathVariable Integer idAdmina) {
        //log.info("dsds:"+id);

        AnnualReportForDrugs pharm=reportService.annualReportForDrugs8(idAdmina, LocalDate.now().getYear());
        return pharm == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(pharm);
    }

    @GetMapping(value = "/drugQuarter/{idAdmina}")
    public ResponseEntity<DrugQuarterDTO> drugQuarter(@PathVariable Integer idAdmina) {
        //log.info("dsds:"+id);

        DrugQuarterDTO pharm=reportService.drugQuarter(idAdmina, LocalDate.now().getYear());
        return pharm == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(pharm);
    }


    //drugQuarter


}
