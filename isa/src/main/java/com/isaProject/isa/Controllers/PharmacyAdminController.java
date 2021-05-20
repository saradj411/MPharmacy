package com.isaProject.isa.Controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<List<User>> findAll() {
        List<Pharmacy> pa=pharmacyService.findAll();
        for(Pharmacy p:pa){

        }
        users =userService.findAll();


        for (User u :users){
            System.out.println(u.getName());


        }
        System.out.println("nestoo");
        return users == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(users);
    }

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<PharmacyAdmin> findById(@PathVariable Integer id) {

        PharmacyAdmin d=pharmacyAdminService.findById(id);
        return d == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(d);
    }


}
