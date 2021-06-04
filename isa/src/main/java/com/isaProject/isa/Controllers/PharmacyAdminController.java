package com.isaProject.isa.Controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.isaProject.isa.Model.DTO.DefiningFreeTermsWithDermatologist;
import com.isaProject.isa.Model.DTO.PharmacyAdminDTO;
import com.isaProject.isa.Model.Drugs.Ingredient;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.PharmacyAdmin;
import com.isaProject.isa.Model.Users.User;
import com.isaProject.isa.Services.Implementations.PharmacyAdminService;
import com.isaProject.isa.Services.Implementations.PharmacyService;
import com.isaProject.isa.Services.Implementations.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin
@RequestMapping(value="/adminstrator")
@Slf4j
public class PharmacyAdminController {

    @Autowired
    private PharmacyAdminService pharmacyAdminService;


    @Autowired
    private PharmacyService pharmacyService;

    private List<User> admin=new List<User>() {
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
        public Iterator<User> iterator() {
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
        public boolean add(User user) {
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
        public boolean addAll(Collection<? extends User> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends User> c) {
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
        public User get(int index) {
            return null;
        }

        @Override
        public User set(int index, User element) {
            return null;
        }

        @Override
        public void add(int index, User element) {

        }

        @Override
        public User remove(int index) {
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
        public ListIterator<User> listIterator() {
            return null;
        }

        @Override
        public ListIterator<User> listIterator(int index) {
            return null;
        }

        @Override
        public List<User> subList(int fromIndex, int toIndex) {
            return null;
        }
    };


    private List<User> users=new List<User>() {
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
        public Iterator<User> iterator() {
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
        public boolean add(User user) {
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
        public boolean addAll(Collection<? extends User> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends User> c) {
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
        public User get(int index) {
            return null;
        }

        @Override
        public User set(int index, User element) {
            return null;
        }

        @Override
        public void add(int index, User element) {

        }

        @Override
        public User remove(int index) {
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
        public ListIterator<User> listIterator() {
            return null;
        }

        @Override
        public ListIterator<User> listIterator(int index) {
            return null;
        }

        @Override
        public List<User> subList(int fromIndex, int toIndex) {
            return null;
        }
    };


    @Autowired
    private UserService userService;

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<PharmacyAdmin>> findAll() {
        List<PharmacyAdmin> userss= pharmacyAdminService.findAll();
        for (PharmacyAdmin u:userss){
            u.getPharmacy();
            u.getDrugOrder();
        }

        System.out.println("nestoo");
        return users == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(userss);
    }
    @GetMapping(value = "/findPharm/{id}")
    public ResponseEntity<Pharmacy> getPharm(@PathVariable Integer id) {

        PharmacyAdmin pharmacyAdmin = pharmacyAdminService.findById(id);
        System.out.println("ajde "+pharmacyAdmin.getPharmacy().getName());
        return pharmacyAdmin.getPharmacy() == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(pharmacyAdmin.getPharmacy());
    }

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<PharmacyAdmin> findById(@PathVariable Integer id) {

        PharmacyAdmin d=pharmacyAdminService.findById(id);
        return d == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(d);
    }

    //MediaType.APPLICATION_JSON)
    @PostMapping(value = "/updateAdmin",consumes={"application/json"})
    ResponseEntity<String> update(@RequestBody PharmacyAdmin pharmacyAdmin)
    {
        pharmacyAdminService.update(pharmacyAdmin);
        return new ResponseEntity<>("ajdeee", HttpStatus.CREATED);

    }

    @PostMapping(value = "/definingFreeTermsWithDermatologist",consumes={"application/json"})
    ResponseEntity<String> definingFreeTermsWithDermatologist(@RequestBody DefiningFreeTermsWithDermatologist definingFreeTermsWithDermatologist)
    {
        pharmacyAdminService.definingFreeTermsWithDermatologist(definingFreeTermsWithDermatologist);
        return new ResponseEntity<>("ajdeee", HttpStatus.CREATED);

    }

        /*

    Svaki dermatolog ima radno vreme za svaku apoteku posebno. Administrator
apoteke definiše preglede kod dermatologa u terminu kada je dermatolog u
apoteci. Za svaki pregled potrebno je definisati datum i vreme početka pregleda,
trajanje pregleda i cenu. U radnom kalendaru dermatologa nalaze se pregledi
koji su unapred definisani.


     */

    @PostMapping(value = "/savePharmacyAdmin", consumes={"application/json"})
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<PharmacyAdmin> update(@RequestBody PharmacyAdminDTO pharmacyAdminDTO)
    {
        PharmacyAdmin pharmAdmin = pharmacyAdminService.save(pharmacyAdminDTO);
        return pharmAdmin != null ? new ResponseEntity<>(pharmAdmin, HttpStatus.CREATED)
        : new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }




}
