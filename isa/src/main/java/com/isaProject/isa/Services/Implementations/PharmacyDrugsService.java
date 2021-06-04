package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Drugs.DrugPricelist;
import com.isaProject.isa.Model.Drugs.PharmacyDrugs;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Repositories.DrugPricelistRepository;
import com.isaProject.isa.Repositories.DrugRepository;
import com.isaProject.isa.Repositories.PharmacyDrugsRepository;
import com.isaProject.isa.Repositories.PharmacyRepository;
import com.isaProject.isa.Services.IServices.IPharmacyDrugsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Boolean remove(Integer idPharm,Integer idDrug) {//izbrisi lijek iz te i te apoteke ako lijek nije rezervisan

               String message = "Pharmacist is not  deleted";
    //    for (Drug drug : drugRepository.findAll()) {
            //if (drug.getIdDrug().equals(idDrug)){
                PharmacyDrugs drugPricelist=pharmacyDrugsRepository.findByIdDrugAndIfPharm(idPharm,idDrug);
                System.out.println("naslo    "+ drugPricelist.getDrug().getName());


                List<DrugPricelist> drugPricelist1=drugPricelistRepository.findAll();
                DrugPricelist found=drugPricelistRepository.findAllDrugsByIdDrugAndIdPharmacy(idPharm,idDrug);
               // System.out.println("Pronaslo iz cjenovnika "+found.getDrug().getIdDrug());

                if(found==null){
                    System.out.println("Ne postoji cijena za ovaj lijek u bazi");
                }else {
                    drugPricelistRepository.delete(found);
                }

                pharmacyDrugsRepository.delete(drugPricelist);

               // System.out.println("proslo find all  ");
                /*
                for (DrugPricelist d:drugPricelist1){
                    if (d.getDrug().getIdDrug().equals(idDrug) && d.getPharmacy().getIdPharm().equals(idPharm)){
                        System.out.println("Naslo 2  "+ d.getDrug().getName());
                        drugPricelistRepository.delete(d);

                    }else {
                        System.out.println("Ne postoji cijena za ovaj lijek u bazi");
                    }
                }
                */



                return true;

           // }
       // }
       // return false;
    }

    @Override
    public List<PharmacyDrugs> findByName(String name) {
        return pharmacyDrugsRepository.findByName(name);
    }

    @Override
    public PharmacyDrugs findById(Integer id) {
        return pharmacyDrugsRepository.findOneById(id);
    }

}
