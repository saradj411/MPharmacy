package com.isaProject.isa.Services.Implementations;


import com.isaProject.isa.Model.DTO.DrugDTO;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Drugs.DrugPricelist;
import com.isaProject.isa.Model.Drugs.PharmacyDrugs;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.PharmacyAdmin;
import com.isaProject.isa.Repositories.*;
import com.isaProject.isa.Services.IServices.IDrugService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


@Service
@Slf4j
public class DrugService implements IDrugService {

    @Autowired
    DrugRepository drugRepository;
    @Autowired
    PharmacyAdminRepository pharmacyAdminRepository;

    @Autowired
    PharmacyRepository pharmacyRepository;

    @Autowired
    DrugPricelistRepository drugPricelistRepository;
    @Autowired
    DrugPricelistService drugPricelistService;

    @Autowired
    PharmacyDrugsRepository pharmacyDrugsRepository;


    List<Drug> d=new List<Drug>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Drug> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(Drug drug) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Drug> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Drug> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Drug get(int index) {
            return null;
        }

        @Override
        public Drug set(int index, Drug element) {
            return null;
        }

        @Override
        public void add(int index, Drug element) {

        }

        @Override
        public Drug remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<Drug> listIterator() {
            return null;
        }

        @Override
        public ListIterator<Drug> listIterator(int index) {
            return null;
        }

        @Override
        public List<Drug> subList(int fromIndex, int toIndex) {
            return null;
        }
    };
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
        d=drugRepository.findOneByName(name);
        return d;
    }


    @Override
    public List<Drug> findAll() {

        return drugRepository.findAll();
    }

    @Override
    public Drug save(DrugDTO drug) {
        Drug d = new Drug();
        PharmacyDrugs pd = new PharmacyDrugs();
        d.setName(drug.getName());
        d.setCode(drug.getCode());
        d.setDrugType(drug.getDrugType());
        d.setFormat(drug.getFormat());
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
        d.setCode(drugDTO.getCode());
        d.setDrugType(drugDTO.getDrugType());
        d.setFormat(drugDTO.getFormat());
        d.setManufacturer(drugDTO.getManufacturer());
        d.setRecipeNeed(drugDTO.isRecipeNeed());
        return drugRepository.save(d);
    }
}
