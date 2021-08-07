package com.isaProject.isa.Services.Implementations;


import com.isaProject.isa.Model.DTO.*;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Drugs.DrugPricelist;
import com.isaProject.isa.Model.Drugs.PharmacyDrugs;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Dermatologist;
import com.isaProject.isa.Model.Users.Staff;
import com.isaProject.isa.Model.Users.WorkTime;
import com.isaProject.isa.Repositories.*;
import com.isaProject.isa.Services.IServices.IDrugService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@Slf4j
public class DrugService implements IDrugService {

    @Autowired
    private DrugRepository drugRepository;
    @Autowired
    private PharmacyAdminRepository pharmacyAdminRepository;

    @Autowired
    private PharmacyRepository pharmacyRepository;

    @Autowired
    private DrugPricelistRepository drugPricelistRepository;
    @Autowired
    private DrugPricelistService drugPricelistService;

    @Autowired
    private PharmacyDrugsRepository pharmacyDrugsRepository;

    @Override
    public Drug save(DrugDTO drug) {
        Drug d = new Drug();
        PharmacyDrugs pd = new PharmacyDrugs();
        d.setName(drug.getName());
        d.setCode(drug.Code());
        d.setDrugType(drug.getDrugType());
        d.setFormat(drug.Format());
        d.setManufacturer(drug.getManufacturer());
//        d.setRecipeNeed(true);
        pd.setQuantity(drug.getQuantity());
        pd.setPharmacy(drug.getPharmacy());
        Drug novi = drugRepository.save(d);
        pd.setDrug(novi);
        pharmacyDrugsRepository.save(pd);
        return novi;
    }
    @Override
    public Drug create(DrugNewDTO drugNewDTO){
        Drug drug=new Drug();
        PharmacyDrugs pd = new PharmacyDrugs();
        drug.setDrugType(drugNewDTO.getDrugType());
        drug.setManufacturer(drugNewDTO.getManufacturer());
        drug.setFormat(drugNewDTO.getFormat());
        drug.setCode(drugNewDTO.getPassword());
        drug.setName(drugNewDTO.getName());
        pd.setQuantity(drugNewDTO.getQuantity());
        pd.setPharmacy(pharmacyRepository.getOne(drugNewDTO.getIdPharm()));
        Drug novi = drugRepository.save(drug);
        pd.setDrug(novi);
        pharmacyDrugsRepository.save(pd);

        return novi;

    }
    @Override
    public Boolean remove(Drug medication, Integer idPharm) {//izbrisi lijek iz te i te apoteke ako lijek nije rezervisan


        Pharmacy pharmacy=pharmacyRepository.findOneByIdPharm(idPharm);
      //  System.out.println("admin jeeeeee "+pharmacyAdmin.getPharmacy().getIdPharm());//503
      //  Pharmacy pharmacy=pharmacyAdmin.getPharmacy();//da iz apoteke iizbrisem lijek
        System.out.println("pharmacyy jeee "+pharmacy.getIdPharm());//504
        for (Drug drug : drugRepository.findAll()) {
            if (drug.getIdDrug() == medication.getIdDrug()){
                DrugPricelist drugPricelist= drugPricelistService.findByIdDrugAndIdPharmacy(medication.getIdDrug(),pharmacy.getIdPharm());
                System.out.println("drugPricelest list id jeee "+drugPricelist.getPharmacy().getIdPharm());//501

                drugPricelistRepository.delete(drugPricelist);
                System.out.println("id prielist jeeeee"+drugPricelist.getIdPricelist());
                return true;


            }
        }
        return false;
    }

    @Override
    public Drug findById(Integer id) {
        Drug drugg = drugRepository.findOneByIdDrug(id);
        return drugg;
    }
    @Override
    public List<Drug> findByName(String name) {
        //veki skontalaaa
        return  drugRepository.findOneByName(name);


    }





    @Override
    public List<Drug> findAll() {

        return drugRepository.findAll();
    }

    public List<AlternativeDrugDTO> alternativeDrugs()
    {
        List<AlternativeDrugDTO> alterList = new ArrayList<AlternativeDrugDTO>();
        for (Drug d: findAll()) {
            AlternativeDrugDTO a = new AlternativeDrugDTO(d.getIdDrug(), d.getName());
            alterList.add(a);
        }

        return  alterList;
    }

    @Override
    public void update(Drug drug) {
        Drug d = drugRepository.getOne(drug.getIdDrug());
        d.setName(drug.getName());
        d.setCode(drug.getCode());
        d.setDrugType(drug.getDrugType());
        d.setFormat(drug.getFormat());
        d.setManufacturer(drug.getManufacturer());
        d.setRecipeNeed(drug.isRecipeNeed());

        drugRepository.save(d);

    }

    @Override
    public Drug saveForShifarnik(DrugDTO drugDTO) {
        Drug d = new Drug();
        d.setName(drugDTO.getName());
        d.setCode(drugDTO.Code());
        d.setDrugType(drugDTO.getDrugType());
        d.setFormat(drugDTO.Format());
        d.setManufacturer(drugDTO.getManufacturer());
        d.setRecipeNeed(drugDTO.isRecipeNeed());
        d.setPoints(drugDTO.getPoints());
        Set<Drug>alternative = new HashSet<Drug>();
        for (Integer id : drugDTO.getAlternativeDrugs()) {
            Drug drug = findById(id);
            alternative.add(drug);
        }
        d.setAlternativeDrugs(alternative);
        d.setGrade(drugDTO.getGrade());
        d.setNapomene(drugDTO.getNapomene());

        return drugRepository.save(d);
    }

    public List<ShowDrugsDTO> returnInfoDrugs()
    {
        List<ShowDrugsDTO> showDrugsList = new ArrayList<ShowDrugsDTO>();


        for (Drug drug : findAll()) {
            List<PharmaciesAndPriceDTO> pharmaciesAndPrice = new ArrayList<PharmaciesAndPriceDTO>();
            for (DrugPricelist drugPricelist : drugPricelistService.findAll())
            {
                if(drug.getIdDrug() == drugPricelist.getDrug().getIdDrug())
                {
                    PharmaciesAndPriceDTO pa = new PharmaciesAndPriceDTO(
                      drugPricelist.getPharmacy().getName(),
                      drugPricelist.getPharmacy().getAddress(),
                      drugPricelist.getPharmacy().getCity(),
                      drugPricelist.getPrice()
                    );
                    pharmaciesAndPrice.add(pa);
                }

            }

            ShowDrugsDTO showDrug = new ShowDrugsDTO(
                    drug.getName(),
                    drug.getDrugType(),
                    drug.getGrade(),
                    pharmaciesAndPrice);
            showDrugsList.add(showDrug);
        }

        System.out.println(showDrugsList);
        return  showDrugsList;
    }


}
