package com.isaProject.isa.Controllers;

import com.isaProject.isa.Model.DTO.*;
import com.isaProject.isa.Model.Examination.Examination;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.*;
import com.isaProject.isa.Repositories.DermatologistRepository;
import com.isaProject.isa.Repositories.ExaminationRepository;
import com.isaProject.isa.Repositories.StaffRepository;
import com.isaProject.isa.Repositories.UserRepository;
import com.isaProject.isa.Services.Implementations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE
@RestController
@CrossOrigin
@RequestMapping(value="/dermatologist", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class DermatologistController {



    @Autowired
    private WorkTimeService workTimeService;

    @Autowired
    private PharmacyAdminService pharmacyAdminService;

    @Autowired
    private PharmacistService pharmacistService;

    @Autowired
    private UserService userService;

    @Autowired
    private PharmacyService pharmacyService;

    Set<WorkTime> tajm = new HashSet<WorkTime>();

    Set<Pharmacy> pharmOfDerm = new HashSet<Pharmacy>();
    @Autowired
    ExaminationRepository examinationRepository;
    @Autowired
    DermatologistService dermatologistService;

    @Autowired
    ExaminationService examinationService;

    @Autowired
    DermatologistRepository dermatologistRepository;



    @PostMapping("/updateDermatologist")
    ResponseEntity<String> update(@RequestBody Dermatologist dermatologist)
    {
        dermatologistService.update(dermatologist);
        return new ResponseEntity<>("ajdeee", HttpStatus.CREATED);

    }


    @PostMapping("/searchDermatologistName/{id}")
    public ResponseEntity<List<Dermatologist>> findAllP(@PathVariable Integer id, @RequestBody SearchDermatologistDTO dto) {
        List<Dermatologist> dermatologists = dermatologistService.findAll();
        System.out.println("ime sa fronta je " + dto.getName());
        System.out.println("prezime sa fronta je " + dto.getSurame());

        ArrayList<Dermatologist> newP = new ArrayList<>();

        for (Dermatologist d : dermatologists) {
            for (Pharmacy p : d.getPharmacies()) {
                if (p.getIdPharm().equals(id)) {
                    if (d.getSurname().toLowerCase().contains(dto.getSurame().toLowerCase()) && d.getName().toLowerCase().contains(dto.getName().toLowerCase())) {
                        newP.add(d);
                    }
                  }

                }
            }
            return newP == null ?
                    new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                    ResponseEntity.ok(newP);
        }


            @GetMapping(value = "/findClientsDermatologist/{id}")
            public ResponseEntity<List<ReviewedClientsDTO>> findClientsD(@PathVariable Integer id) {
                List<ReviewedClientsDTO> reviewedClientsDTOS=dermatologistService.reviewedClientsDermatologist(id);
                return reviewedClientsDTOS == null ?
                        new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                        ResponseEntity.ok(reviewedClientsDTOS);
            }

            @GetMapping(value = "/findPharmacyDermatologist/{id}")
            public ResponseEntity<Set<Pharmacy>> findpharmacy(@PathVariable Integer id) {
                Set<Pharmacy> pharmacies=dermatologistService.pharmacies(id);
                return pharmacies == null ?
                        new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                        ResponseEntity.ok(pharmacies);
            }




    @GetMapping(value = "/findAll")
    public ResponseEntity<List<Dermatologist>> findAll() {
        List<Dermatologist> dermatologists=dermatologistService.findAll();
        for (Dermatologist d:dermatologists){
            System.out.println(d.getId());
            System.out.println(d.getPharmacies());


        }
        return dermatologists == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(dermatologists);
    }

    @GetMapping(value = "/findAllPatient/{id}")
    public ResponseEntity<Set<PatientDTO>> findAllPatients(@PathVariable Integer id) {
        /*List<Patient> patients=dermatologistService.findAllPatients(id);
        for(Patient p:patients){
            System.out.println("Usao u repozitorijum .Pacijent je :"+p.getName());
        }
        return patients == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(patients);

         */
        Set<PatientDTO>list=dermatologistService.findAllPatients(id);
        return list == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(list);

    }


    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<Dermatologist> findById(@PathVariable Integer id) {

        Dermatologist d= dermatologistService.findById(id);
        System.out.println("gfgg"+d.getName());
        return d == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(d);
    }
    @GetMapping("/delete/{idDerm}/{idPharm}")
    public ResponseEntity<String> deleteDermatologist(@PathVariable Integer idDerm,@PathVariable Integer idPharm) {
        Dermatologist dermatologist = dermatologistService.findById(idDerm);
        String answer = dermatologistService.delete(dermatologist,idPharm);
        return new ResponseEntity<>(answer, HttpStatus.ACCEPTED);
    }


    @GetMapping(value = "/getDermatologists/{id}")
    public ResponseEntity<List<Dermatologist>> findAll(@PathVariable Integer id) {
        List<Dermatologist> dermatologists=dermatologistService.findAll();
        ArrayList<Dermatologist> newDermatologists = new ArrayList<Dermatologist>();

        for (Dermatologist d:dermatologists){
            for(Pharmacy pharm:d.getPharmacies()){
                if(pharm.getIdPharm().equals(id)){
                    System.out.println("eee"+pharm.getIdPharm());
                    newDermatologists.add(d);
                    System.out.println("eee"+d.getName());
                    System.out.println("eee"+newDermatologists);

                }
            }


        }
        return newDermatologists == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(newDermatologists);
    }



    @GetMapping(value = "/findWorkTimeByIdUser/{id}")
    public ResponseEntity<WorkTime> findWorkTimeByIdUser(@PathVariable Integer id) {

        WorkTime d= workTimeService.findByUserId(id);
        return d == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(d);
    }
    //sutraaaaaaaa

    @GetMapping(value ="create/{name}/{surname}/{email}/{address}/{phoneNumber}/{city}/{country}/{idAdmina}")
    public ResponseEntity<String> addDrug(@PathVariable(value="name") String name,@PathVariable(value="surname") String surname,@PathVariable(value="email") String email,@PathVariable(value="address") String address,@PathVariable(value="phoneNumber") String phoneNumber,@PathVariable(value="city") String city,@PathVariable(value="country") String country,@PathVariable(value="idAdmina") Integer idAdmina) {

        Pharmacist p=null;
        Pharmacy pharm=null;
        Double grade=0.0;

        Set<WorkTime> workTime=null;
        Set<Examination> examinations=null;
        Set<Vacation> vacation=null;


        String password=null;
        PharmacyAdmin admin=pharmacyAdminService.findById(idAdmina);
        String proba="2011/11/11";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        /*
        localhost:8083/dermatologist/create/dsdfdd/sdsadd/asdsdd/aSDdd/ASDFdd/ASDddd/asdefrdddd/503/2017-11-11/11:15:45/12:15:45
         */



        Set<Pharmacy> pharmacies = null;
        Pharmacy pharmacy=admin.getPharmacy();//apoteka u kojoj radi admin i dodati derm





        pharmOfDerm.add(pharmacy);





        DermatologistDTO DTO=new DermatologistDTO(name,surname,email,password,address,phoneNumber,city,country,grade, tajm,examinations,vacation,pharmacy);


        Dermatologist d=dermatologistService.save(DTO);




        return new ResponseEntity<>("kreirano", HttpStatus.CREATED);
    }




    //uzmi unaprije zakazane preglede
    @GetMapping("/getFreeEx/{idStaff}")
    public  ResponseEntity<List<FreeExaminationsForRepresentationDTO>> getAllFreeExaminations(@PathVariable Integer idStaff) {

        List<Examination>examinations=examinationService.getExaminationsByIdStaffAndIdPharmacy(idStaff);
        List<FreeExaminationsForRepresentationDTO>freeEx=new ArrayList<>();
        for (Examination ex:examinations){
            System.out.println("imeee pacijenta "+ ex.getPatient().getName());

            System.out.println("imeee "+ ex.getPharmacy().getName());
            FreeExaminationsForRepresentationDTO freeE=new FreeExaminationsForRepresentationDTO(ex.getDate(),ex.getStartTime(),ex.getEndTime(),ex.getPrice(),ex.getPharmacy().getName(),ex.getPatient().getName(),ex.getPatient().getSurname(),ex.getIdExamination());
            freeEx.add(freeE);
        }
        return new ResponseEntity<>(freeEx, HttpStatus.ACCEPTED);
    }

    /*
    Dermatolog za korisnika za kojeg trenutno izvršava pregled bira jedan od
    unapred definisanih pregleda idPacijenta,i taj pregled nekako //dto sa id Pacijenta
     */


    @PostMapping("/updateFreeExx")
    ResponseEntity<String> updateFreeEx(@RequestBody ScheduleAnExaminationDTO scheduleAnExaminationDTO)
    {
        dermatologistService.updateFreeEx(scheduleAnExaminationDTO);
        return new ResponseEntity<>("ajdeee", HttpStatus.CREATED);

    }

    /*
    opcija da označi da se korisnik nije pojavio na zakazanom pregledu.
Ukoliko se korisnik ne pojavi na pregledu, dobija 1 penal.

     */

    @GetMapping("/updateFreeEx/{idEx}")
    ResponseEntity<String> patientNotAppearr(@PathVariable Integer idEx)
    {
        String answer="The patient received 1 penalty!";
        dermatologistService.patientNotAppear(idEx);
        return new ResponseEntity<>(answer, HttpStatus.CREATED);

    }

    // opcija da započne pregled
    //Dok pregled traje, dermatolog u slobodnoj formi unosi informacije o
    //pregledu.

    @PostMapping("/startExamination/{idPatient}/{report}")
    ResponseEntity<String> startExamination(@RequestBody Integer idPatient,@RequestBody String report)
    {

        return new ResponseEntity<>("ajdeee", HttpStatus.CREATED);

    }

    @PostMapping(value = "/saveDermatologist", consumes={"application/json"})
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Dermatologist> saveDermatologist(@RequestBody DermDTO dermDTO)
    {
        System.out.println("Usao " + dermDTO.getName());
        Dermatologist d = dermatologistService.save(dermDTO);
        return d == null ? new ResponseEntity("Account with this email aleray exists!", HttpStatus.BAD_REQUEST)
                : new ResponseEntity<>(d, HttpStatus.CREATED);
    }


    @PostMapping(value = "/createDermatologist")
    ResponseEntity<String> update(@RequestBody DermatologistForCreateDTO dermatologistForCreateDTO)
    {

        Dermatologist dermatologist= dermatologistService.create(dermatologistForCreateDTO);
        return new ResponseEntity<>("ajdeee", HttpStatus.CREATED);

    }

    @Autowired
    StaffRepository staffRepository;

    @Autowired
    UserRepository userRepository;


    /*@PostMapping("/del/{id}")
    ResponseEntity<String> del(@PathVariable Integer id  )
    {
        userRepository.delete(id);
        return new ResponseEntity<>("ajdeee", HttpStatus.CREATED);

    }
*/










}
