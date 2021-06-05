package com.isaProject.isa.Controllers;


import com.isaProject.isa.Model.DTO.DermatologistGradeDTO;
import com.isaProject.isa.Model.DTO.PharmacistGradeDTO;
import com.isaProject.isa.Model.Grades.DermatolgoistGrade;
import com.isaProject.isa.Model.Grades.PharmacistGrade;
import com.isaProject.isa.Model.Users.Dermatologist;
import com.isaProject.isa.Model.Users.Pharmacist;
import com.isaProject.isa.Services.Implementations.DermatologistService;
import com.isaProject.isa.Services.Implementations.Grade.DeratologistGradeService;
import com.isaProject.isa.Services.Implementations.Grade.PharmacistGradeService;
import com.isaProject.isa.Services.Implementations.PatientService;
import com.isaProject.isa.Services.Implementations.PharmacistService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/grade")
public class GradeController {

    @Autowired
    PatientService patientService;

    @Autowired
    DeratologistGradeService deratologistGradeService;

    @Autowired
    DermatologistService dermatologistService;

    @Autowired
    PharmacistService pharmacistService;

    @Autowired
    PharmacistGradeService pharmacistGradeService;



    @GetMapping(value = "/findDermatologistForGrade/{id}")
    public ResponseEntity<List<DermatologistGradeDTO>> findDermatologistForGrade(@PathVariable Integer id) {

        Set<Integer> d= patientService.findDermatologistForGrade(id);

        List<DermatolgoistGrade> grades=deratologistGradeService.findAll();

        List<DermatolgoistGrade> gradesThisPatient=new ArrayList<>();

        List<DermatolgoistGrade> existingGrades=new ArrayList<>();

        List<DermatologistGradeDTO> returnGrades=new ArrayList<>();

        for(DermatolgoistGrade dG:grades){
            if(id.equals(dG.getIdPatient())){
                gradesThisPatient.add(dG);
            }
        }

        for(DermatolgoistGrade dG:gradesThisPatient){
            for(Integer i:d){
                if(i.equals(dG.getIdDermatologist())){
                    DermatolgoistGrade newGrade=new DermatolgoistGrade(id,i,dG.getGrade());
                    existingGrades.add(newGrade);
                }
            }
        }

        for(Integer i:d){
            Boolean postoji=false;

            for(DermatolgoistGrade dd:existingGrades){
                if(i.equals(dd.getIdDermatologist())){
                    postoji=true;
                }
            }

                if(!postoji){
                    DermatolgoistGrade newGrade=new DermatolgoistGrade(id,i,0);
                    existingGrades.add(newGrade);
                }
        }

        for(DermatolgoistGrade gr:existingGrades){
            Dermatologist dermatologist=dermatologistService.findById(gr.getIdDermatologist());
            DermatologistGradeDTO dto=new DermatologistGradeDTO(gr.getIdPatient(),gr.getIdDermatologist(),
                    dermatologist.getName(),dermatologist.getSurname(),gr.getGrade());

            returnGrades.add(dto);
        }
        return returnGrades== null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(returnGrades);
    }
    @GetMapping(value = "/findPharmacistForGrade/{id}")
    public ResponseEntity<List<PharmacistGradeDTO>> findPharmacistForGrade(@PathVariable Integer id) {

        Set<Integer> d= patientService.findPharmacistForGrade(id);

        List<PharmacistGrade> grades=pharmacistGradeService.findAll();

        List<PharmacistGrade> gradesThisPatient=new ArrayList<>();

        List<PharmacistGrade> existingGrades=new ArrayList<>();

        List<PharmacistGradeDTO> returnGrades=new ArrayList<>();

        for(PharmacistGrade dG:grades){
            if(id.equals(dG.getIdPatient())){
                gradesThisPatient.add(dG);
            }
        }

        for(PharmacistGrade dG:gradesThisPatient){
            for(Integer i:d){
                if(i.equals(dG.getIdPharmacist())){
                    PharmacistGrade newGrade=new PharmacistGrade(id,i,dG.getGrade());
                    existingGrades.add(newGrade);
                }
            }
        }

        for(Integer i:d){
            Boolean postoji=false;

            for(PharmacistGrade dd:existingGrades){
                if(i.equals(dd.getIdPharmacist())){
                    postoji=true;
                }
            }

            if(!postoji){
                PharmacistGrade newGrade=new PharmacistGrade(id,i,0);
                existingGrades.add(newGrade);
            }
        }

        for(PharmacistGrade gr:existingGrades){
            Pharmacist pharmacist=pharmacistService.findById(gr.getIdPharmacist());
            PharmacistGradeDTO dto=new PharmacistGradeDTO(gr.getIdPatient(),gr.getIdPharmacist(),
                    pharmacist.getName(),pharmacist.getSurname(),gr.getGrade());

            returnGrades.add(dto);
        }
        return returnGrades== null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(returnGrades);
    }

    @PostMapping(value = "/grade/{idPatient}/{grade}/{idDerm}")
    public ResponseEntity<DermatolgoistGrade> grade(@PathVariable Integer idPatient,
             @PathVariable Integer grade,@PathVariable Integer idDerm) {

        DermatolgoistGrade dd=deratologistGradeService.grade(idPatient,grade,idDerm);


        return dd== null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(dd);
    }
    @PostMapping(value = "/gradePharmacist/{idPatient}/{grade}/{idDerm}")
    public ResponseEntity<PharmacistGrade> gradePharmacist(@PathVariable Integer idPatient,
                                                    @PathVariable Integer grade,@PathVariable Integer idDerm) {

        PharmacistGrade dd=pharmacistGradeService.grade(idPatient,grade,idDerm);

        return dd== null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(dd);
    }


}
