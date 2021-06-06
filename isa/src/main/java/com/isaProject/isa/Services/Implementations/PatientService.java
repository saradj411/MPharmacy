package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Model.DTO.ChangePasswordDTO;
import com.isaProject.isa.Model.DTO.DrugDTO;
import com.isaProject.isa.Model.DTO.FrontCreatedExaminationDTO;

import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Drugs.DrugReservation;
import com.isaProject.isa.Model.Drugs.ERecipe;
import com.isaProject.isa.Model.Drugs.ERecipeDrug;
import com.isaProject.isa.Model.Examination.Examination;
import com.isaProject.isa.Model.Examination.ExaminationStatus;
import com.isaProject.isa.Model.Examination.ExaminationType;
import com.isaProject.isa.Model.Examination.Therapy;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Dermatologist;
import com.isaProject.isa.Model.Users.Patient;
import com.isaProject.isa.Model.Users.Pharmacist;
import com.isaProject.isa.Model.Users.User;
import com.isaProject.isa.Repositories.*;
import com.isaProject.isa.Services.IServices.IPatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class PatientService implements IPatientService {

    @Autowired
    PatientRepository patientRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    DrugRepository drugRepository;

    @Autowired
    ERecipeRepository eRecipeRepository;

    @Override
    public Patient findById(Integer id){
        //System.out.println("ovdje uslo sada aaaaa:"+id);
        User user=userRepository.getOne(id);
        //System.out.println("ovdje uslo sada aaaaa:"+user.getName());
        return patientRepository.getOne(id);

    }

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public void saveAllergy(Integer idDrug,Integer idPatient) {
        Patient patient = patientRepository.findById(idPatient).get();
        Set<Drug> allergies=patient.getAllergies();
        Drug dr=drugRepository.getOne(idDrug);
        allergies.add(dr);
        patient.setAllergies(allergies);
        patientRepository.save(patient);
    }
    @Override
    public String findAllergy(Integer idPatient,String name) {
        String answer="The patient isn't allergic to the drug";
        Patient patient = patientRepository.findById(idPatient).get();
        Set<Drug> allergies=patient.getAllergies();
        for (Drug d:allergies){
            if(d.getName().equals(name)){
                answer="The patient is allergic to the drug";

            }
        }
        return answer;
    }

    @Override
    public Set<Integer> findDermatologistForGrade(Integer id) {
        Patient patient=patientRepository.findById(id).get();
        Set<Examination> examinations=new HashSet<>();
        Set<Integer> list=new HashSet<>();
        examinations=patient.getExaminations();
        for (Examination e:examinations){

            if((e.getStatus().compareTo(ExaminationStatus.FINISHED))==0){

                if((e.getType().compareTo(ExaminationType.DERMATOLOGIST_EXAMINATION))==0){

                    list.add(e.getStaff().getId());
                }
            }
        }
        return list;
    }
    @Override
    public Set<Integer> findDrugsForGrade(Integer id) {
        Patient patient=patientRepository.findById(id).get();

        List<ERecipe> eRecipes=eRecipeRepository.findAll();

        Set<DrugReservation> reservations=patient.getDrugReservation();
        Set<Integer> list=new HashSet<>();

        for(DrugReservation dR:reservations){
            if(dR.getPickedUp()){
                list.add(dR.getDrug().getIdDrug());
            }
        }

        for(ERecipe er:eRecipes){
            if(er.getPatient().getId().equals(id)){
                Set<ERecipeDrug> eRecipes1=er.geteRecipeDrug();
                for(ERecipeDrug erd:eRecipes1){
                    Drug drug=drugRepository.findOneByNameDrug(erd.getName());
                    list.add(drug.getIdDrug());
                }

            }
        }
        return list;
    }
    @Override
    public Set<Integer> findPharmaciesForGrade(Integer id) {
        Patient patient=patientRepository.findById(id).get();

        Set<Examination> examinations=new HashSet<>();
        List<ERecipe> eRecipes=eRecipeRepository.findAll();
        Set<DrugReservation> reservations=patient.getDrugReservation();
        Set<Integer> list=new HashSet<>();
        examinations=patient.getExaminations();

        for (Examination e:examinations){

            if((e.getStatus().compareTo(ExaminationStatus.FINISHED))==0){
                     list.add(e.getPharmacy().getIdPharm());

            }
        }
        for(DrugReservation dR:reservations){
            if(dR.getPickedUp()){
                list.add(dR.getPharmacy().getIdPharm());
            }
        }

        for(ERecipe er:eRecipes){
            if(er.getPatient().getId().equals(id)){
                list.add(er.getPharmacy().getIdPharm());
            }
        }
        return list;
    }
    @Override
    public Set<Integer> findPharmacistForGrade(Integer id) {
        Patient patient=patientRepository.findById(id).get();
        Set<Examination> examinations=new HashSet<>();
        Set<Integer> list=new HashSet<>();
        examinations=patient.getExaminations();
        for (Examination e:examinations){

            if((e.getStatus().compareTo(ExaminationStatus.FINISHED))==0){

                if((e.getType().compareTo(ExaminationType.PHARMACIST_EXAMINATION))==0){

                    list.add(e.getStaff().getId());
                }
            }
        }
        return list;
    }

    @Override
    public Set<Drug> getAllergy(Integer idPatient, String name) {
        Patient patient = patientRepository.findById(idPatient).get();
        Set<Drug> allergies=patient.getAllergies();

        return allergies;
    }



    @Override
    public void update(Patient patient) {
        Patient pat = patientRepository.getOne(patient.getId());
        Integer ids=pat.getId();
        pat.setName(patient.getName());
        pat.setSurname(patient.getSurname());
        pat.setAddress(patient.getAddress());
        pat.setCity(patient.getCity());
        pat.setCountry(patient.getCountry());
        pat.setPhoneNumber(patient.getPhoneNumber());
        pat.setPassword(patient.getPassword());
        pat.setPenalty(patient.getPenalty());
        patientRepository.save(pat);
    }

    @Override
    public Set<FrontCreatedExaminationDTO> findSheduledDermatologistExamination(Integer id) {
       Patient patient=patientRepository.findById(id).get();
        Set<Examination> examinations=new HashSet<>();
        Set<FrontCreatedExaminationDTO> dermExaminations=new HashSet<>();
        examinations=patient.getExaminations();
        for (Examination e:examinations){

            if((e.getStatus().compareTo(ExaminationStatus.SCHEDULED))==0){

                if((e.getType().compareTo(ExaminationType.DERMATOLOGIST_EXAMINATION))==0){
                    FrontCreatedExaminationDTO exDTO=new FrontCreatedExaminationDTO(
                            e.getIdExamination(),e.getDate(),
                            e.getStartTime(),e.getEndTime(),e.getPrice(),
                            e.getStaff().getName(),e.getStaff().getSurname(),e.getPharmacy().getName());
                   dermExaminations.add(exDTO);
                }
            }
        }
        return dermExaminations;
    }
    @Override
    public Set<FrontCreatedExaminationDTO> findSheduledPharmacistExamination(Integer id) {
        Patient patient=patientRepository.findById(id).get();
        Set<Examination> examinations=new HashSet<>();
        Set<FrontCreatedExaminationDTO> dermExaminations=new HashSet<>();
        examinations=patient.getExaminations();
        for (Examination e:examinations){

            if((e.getStatus().compareTo(ExaminationStatus.SCHEDULED))==0){

                if((e.getType().compareTo(ExaminationType.PHARMACIST_EXAMINATION))==0){
                    FrontCreatedExaminationDTO exDTO=new FrontCreatedExaminationDTO(e.getIdExamination(),e.getDate(),
                            e.getStartTime(),e.getEndTime(),e.getPrice(),
                            e.getStaff().getName(),e.getStaff().getSurname(),e.getPharmacy().getName());
                    dermExaminations.add(exDTO);
                }
            }
        }
        return dermExaminations;
    }

    @Override
    public List<ERecipe> findERecipe(Integer id) {
        return null;
    }

    @Override
    public Set<FrontCreatedExaminationDTO> findFinishedDermatologistExamination(Integer id) {
        Patient patient=patientRepository.findById(id).get();
        Set<Examination> examinations=new HashSet<>();
        Set<FrontCreatedExaminationDTO> dermExaminations=new HashSet<>();
        examinations=patient.getExaminations();
        for (Examination e:examinations){

            if((e.getStatus().compareTo(ExaminationStatus.FINISHED))==0){

                if((e.getType().compareTo(ExaminationType.DERMATOLOGIST_EXAMINATION))==0){
                    FrontCreatedExaminationDTO exDTO=new FrontCreatedExaminationDTO(e.getIdExamination(),e.getDate(),
                            e.getStartTime(),e.getEndTime(),e.getPrice(),
                            e.getStaff().getName(),e.getStaff().getSurname(),e.getPharmacy().getName(),
                    e.getReport(),e.getTherapy());

                    dermExaminations.add(exDTO);
                }
            }
        }
        return dermExaminations;
    }

    @Override
    public Set<FrontCreatedExaminationDTO> findFinishedPharmacistExamination(Integer id) {
        Patient patient=patientRepository.findById(id).get();
        Set<Examination> examinations=new HashSet<>();
        Set<FrontCreatedExaminationDTO> dermExaminations=new HashSet<>();
        examinations=patient.getExaminations();
        for (Examination e:examinations){

            if((e.getStatus().compareTo(ExaminationStatus.FINISHED))==0){

                if((e.getType().compareTo(ExaminationType.PHARMACIST_EXAMINATION))==0){
                   /* Therapy therapy=new Therapy();
                    if(!e.getTherapy().equals(null)){
                        therapy=e.getTherapy();
                    }*/
                    FrontCreatedExaminationDTO exDTO=new FrontCreatedExaminationDTO(e.getIdExamination(),e.getDate(),
                            e.getStartTime(),e.getEndTime(),e.getPrice(),
                            e.getStaff().getName(),e.getStaff().getSurname(),e.getPharmacy().getName(),
                            e.getReport(),e.getTherapy());
                    dermExaminations.add(exDTO);
                }
            }
        }
        return dermExaminations;
    }

    /*@Override
    public List<ERecipe> findERecipe(Integer id) {
        Patient patient=patientRepository.findById(id).get();
        Set<ERecipe> recepies=new HashSet<>();
        recepies=patient.getErecipes();
        List<ERecipe> dermExaminations=new ArrayList<>();
        for(ERecipe er:recepies){
            dermExaminations.add(er);
        }

        return dermExaminations;
    }*/

}

