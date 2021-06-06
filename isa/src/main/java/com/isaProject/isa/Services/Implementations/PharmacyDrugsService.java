package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Drugs.DrugPricelist;
import com.isaProject.isa.Model.Drugs.DrugReservation;
import com.isaProject.isa.Model.Drugs.PharmacyDrugs;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Repositories.*;
import com.isaProject.isa.Services.IServices.IPharmacyDrugsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class PharmacyDrugsService implements IPharmacyDrugsService {

    @Autowired
    private PharmacyDrugsRepository pharmacyDrugsRepository;

    @Autowired
    private PharmacyRepository pharmacyRepository;
    @Autowired
    private DrugRepository drugRepository;

    @Autowired
    DrugPricelistRepository drugPricelistRepository;

    @Autowired
    DrugReservationRepository drugReservationRepository;

    public List<PharmacyDrugs> findAll() {
        return pharmacyDrugsRepository.findAll();
    }

    public String check(Integer id,String name) {
        String answer="The drug is not available at the pharmacy";
        List<PharmacyDrugs> pharmacyDrugs= pharmacyDrugsRepository.findAll();
        for(PharmacyDrugs drug:pharmacyDrugs){
             if(drug.getDrug().getName().equals(name) && drug.getPharmacy().getIdPharm().equals(id)){
                  answer="The drug is available at the pharmacy";

             }
        }
        return  answer;
    }
    public Set<Drug> find(Integer id,String name) {
        Drug d=drugRepository.findOneByNameDrug(name);
        Set<Drug> drugs=d.getAlternativeDrugs();
        return  drugs;
    }


    @Override
    public String remove(Integer idPharm,Integer idDrug) {//izbrisi lijek iz te i te apoteke ako lijek nije rezervisan

        String message = "Drug is deleted";
        PharmacyDrugs pharmacyDrugs=pharmacyDrugsRepository.findByIdDrugAndIfPharm(idPharm,idDrug);


        Drug drug=drugRepository.findOneByIdDrug(idDrug);

        /*

        (ukoliko je lek rezervisan, a korisnik ga još nije preuzeo, lek se ne može
obrisati)
         */
        List<DrugReservation> drugReservation=drugReservationRepository.findAllByIdDrugAndIdPharm(idPharm,idDrug);

        List<DrugReservation>list2=new ArrayList<>();
        for (DrugReservation d:drugReservation){
            if (d.getPickedUp().equals(false)){
                list2.add(d);
            }
        }
        if (list2.size()==0){
             message = "Drug is deleted";
            pharmacyDrugsRepository.delete(pharmacyDrugs);


        }else {
             message = "Drug was not deleted because someone had reserved it  ";

        }

        return message;

    }

}
