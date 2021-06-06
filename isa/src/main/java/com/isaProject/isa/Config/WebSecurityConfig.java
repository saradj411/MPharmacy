package com.isaProject.isa.Config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.isaProject.isa.Config.Utils.Auth.RestAuthenticationEntryPoint;
import com.isaProject.isa.Config.Utils.Auth.TokenAuthenticationFilter;
import com.isaProject.isa.Config.Utils.TokenUtils;
import com.isaProject.isa.Services.Implementations.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Servis koji se koristi za citanje podataka o korisnicima aplikacije
    @Autowired
    private CustomUserDetailsService jwtUserDetailsService;

    // Handler za vracanje 401 kada klijent sa neodogovarajucim korisnickim imenom i lozinkom pokusa da pristupi resursu
    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    // Registrujemo authentication manager koji ce da uradi autentifikaciju korisnika za nas
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    // Definisemo uputstvo za authentication managera koji servis da koristi da izvuce podatke o korisniku koji zeli da se autentifikuje,
    //kao i kroz koji enkoder da provuce lozinku koju je dobio od klijenta u zahtevu da bi adekvatan hash koji dobije kao rezultat bcrypt algoritma uporedio sa onim koji se nalazi u bazi (posto se u bazi ne cuva plain lozinka)
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
    }

    // Injektujemo implementaciju iz TokenUtils klase kako bismo mogli da koristimo njene metode za rad sa JWT u TokenAuthenticationFilteru
    @Autowired
    private TokenUtils tokenUtils;

    // Definisemo prava pristupa odredjenim URL-ovima
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // komunikacija izmedju klijenta i servera je stateless posto je u pitanju REST aplikacija
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

                // sve neautentifikovane zahteve obradi uniformno i posalji 401 gresku
                .exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint).and()

                // svim korisnicima dopusti da pristupe putanjama /auth/**, (/h2-console/** ako se koristi H2 baza) i /api/foo
                .authorizeRequests().antMatchers("/h2-console/**")
                .permitAll().antMatchers("/api/foo")
                .permitAll().antMatchers("/pharmacy/findAll")

                .permitAll().antMatchers("/drugPricelist/findAll")
                .permitAll().antMatchers("/pharmacy/findByCity/{city}")
                .permitAll().antMatchers("/pharmacy/findByName/{name}")

                .permitAll().antMatchers("/reservation/findCanceledById/{id}")
                .permitAll().antMatchers("/reservation/findPickedById/{id}")
                .permitAll().antMatchers("/patient/findSheduledDermatologistExamination/{id}")
                .permitAll().antMatchers("/patient/findFinishedDermatologistExamination/{id}")
                .permitAll().antMatchers("/patient/findDermatologistForGrade/{id}")
                .permitAll().antMatchers("/reservation/findById/{id}")
                .permitAll().antMatchers("/patient/findSheduledPharmacistExamination/{id}")

                .permitAll().antMatchers("/grade/findDermatologistForGrade/{id}")
                .permitAll().antMatchers("/grade/findPharmacistForGrade/{id}")
                .permitAll().antMatchers("/grade/findPharmaciesForGrade/{id}")
                .permitAll().antMatchers("/grade/findDrugsForGrade/{id}")
                .permitAll().antMatchers("/grade/grade/{idPatient}/{grade}/{idDerm}")
                .permitAll().antMatchers("/grade/gradePharmacist/{idPatient}/{grade}/{idDerm}")
                .permitAll().antMatchers("/grade/gradePharmacy/{idPatient}/{grade}/{idDerm}")
                .permitAll().antMatchers("/grade/gradeDrug/{idPatient}/{grade}/{idDerm}")

                .permitAll().antMatchers("/patient/findFinishedPharmacistExamination/{id}")
                .permitAll().antMatchers("/reservation/checkReservations")

                .permitAll().antMatchers("/requestVacation/acceptOrRefuseRequest/{requestForVacationId}/{text}")

                .permitAll().antMatchers("/requestVacation/getRequestById/{id}")


                .permitAll().antMatchers("/requestVacation/acceptRequest/{id}")






                .permitAll().antMatchers("/adminstrator/findPharm/{id}")
                .permitAll().antMatchers("/adminstrator/findById/{id}")
                .permitAll().antMatchers("/pharmacist/updatePharmacist")
                .permitAll().antMatchers("/pharmacist/findById/{id}")
                .permitAll().antMatchers("/adminstrator/updateAdmin")
                .permitAll().antMatchers("/dermatologist/getDermatologists/{id}")
                .permitAll().antMatchers("/drug/findById/{id}")
                .permitAll().antMatchers("/drug/updateDrug")
                .permitAll().antMatchers("/drugPricelist/getDrugsPharmacy/{id}")
                .permitAll().antMatchers("/drug/create")
                .permitAll().antMatchers("/requestVacation/findAll/{idAdmina}")
                .permitAll().antMatchers("/requestVacation/acceptOrRefuseRequest/{requestForVacationId}/{text}")

                .permitAll().antMatchers("/drugOrder/create")

                .permitAll().antMatchers("/dermatologist/updateDermatologist")

                .permitAll().antMatchers("/dermatologist/findById/{id}")

                .permitAll().antMatchers("/dermatologist/findAllPatient/{id}")

                .permitAll().antMatchers("/pharmacist/getFreeEx/{idStaff}")

                .permitAll().antMatchers("/requestVacation/findAll/{idAdmina}")

                .permitAll().antMatchers("/examination/findPatientById/{id}")

                .permitAll().antMatchers("/examination/findPharmacy/{id}")
                .permitAll().antMatchers("/specification/getIngredients/{name}")
                .permitAll().antMatchers("/specification/getSpec/{name}")

                .permitAll().antMatchers("/examination/createDermatologistEx")

                .permitAll().antMatchers("/pharmacist/findClientsPharmacist/{id}")


                .permitAll().antMatchers("/examination/createPharmacistEx")

                .permitAll().antMatchers("/examination/createPharmacists")
                .permitAll().antMatchers("/examination/createDermatologist")

                .permitAll().antMatchers("/patient/findAll")


                .permitAll().antMatchers("/dermatologist/findClientsDermatologist/{id}")
                .permitAll().antMatchers("/dermatologist/findPharmacyDermatologist/{id}")


                .permitAll().antMatchers("/pharmacyDrugs/findDrugsByIdPharm/{id}/{name}")

                .permitAll().antMatchers("/pharmacyDrugs/findAlternative/{idPharm}/{id}/{name}")
                .permitAll().antMatchers("/patient/checkAllergy/{id}/{name}")
                .permitAll().antMatchers("/pharmacyDrugs/checkAvalibility/{id}/{name}")


                .permitAll().antMatchers("/dermatologist/updateFreeEx/{idEx}")

                .permitAll().antMatchers("/pharmacist/updateFreeEx/{idEx}")

                .permitAll().antMatchers("/pharmacy/findByName/{name}")
                .permitAll().antMatchers("/pharmacy/findOneByName/{name}")
                .permitAll().antMatchers("/pharmacist/createPharmacist")
                .permitAll().antMatchers("/dermatologist/createDermatologist")
                .permitAll().antMatchers("/pharmacist/findOneById/{id}")







                .permitAll().antMatchers("/examination/findExamination/{id}")
                .permitAll().antMatchers("/examination/finished/{id}")


                .permitAll().antMatchers("/examination/findStaff/{id}")
                .permitAll().antMatchers("/patient/findAllergyById/{id}")
                .permitAll().antMatchers("/patient/findAllergyById/{id}/{name}")
                .permitAll().antMatchers("/examination/finishedPharmacist/{id}")


                .permitAll().antMatchers("/pharmacyDrugs/findDrugsByIdPharm/{id}/{name}")



                .permitAll().antMatchers("/requestVacation/create")
                .permitAll().antMatchers("/requestVacation/createPharmacist")


                .permitAll().antMatchers("/pharmacist/getPharmacist/{id}")
                .permitAll().antMatchers("/pharmacy/findById/{id}")
                .permitAll().antMatchers("/pharmacy/getDrugsPharmacy/{id}")
                .permitAll().antMatchers("/patient/findAll/")
                .permitAll().antMatchers("/dermatologist/getFreeEx/{id}")
                .permitAll().antMatchers("/patient/searchUser/")
                .permitAll().antMatchers("/pharmacist/searchPharmacistName/{id}")
                .permitAll().antMatchers("/dermatologist/searchDermatologistName/{id}")
                .permitAll().antMatchers("/pharmacist/delete/{id}")
                .permitAll().antMatchers("/reports/monthlyReport/{idAdmina}")

                .permitAll().antMatchers("/reports/monthlyReportDrugs/{idAdmina}")


                .permitAll().antMatchers("/reports/annualReport/{idAdmina}")
                .permitAll().antMatchers("/reports/examinationQuarter/{idAdmina}")
                .permitAll().antMatchers("/reports/annualReportDrug/{idAdmina}")
                .permitAll().antMatchers("/reports/drugQuarter/{idAdmina}")

                .permitAll().antMatchers("/reports/incomeReport/{idAdmina}")






                .permitAll().antMatchers("/patient/findActionPharmacy/{id}")
                .permitAll().antMatchers("/patient/findERecipe/{id}")
                .permitAll().antMatchers("/patient/findById/{id}")
                .permitAll().antMatchers("/drug/findAll")
                .permitAll().antMatchers("/patient/updatePatient")
                .permitAll().antMatchers("/patient/findById/{id}")
                .permitAll().antMatchers("/patient/addAllergy/{id}/{idPatient}")
                .permitAll().antMatchers("/user/updatePenality")
                .permitAll().antMatchers("/examination/findCreatedPharmacistExamination")

                .permitAll().antMatchers("/examination/patientScheduledDermatologistExamination/{id}/{idExamination}")
                .permitAll().antMatchers("/examination/patientScheduledPharmacistExamination")
                .permitAll().antMatchers("/reservation/getBool/{id}")
                .permitAll().antMatchers("/examination/getBool/{id}")
                .permitAll().antMatchers("/reservation/canceling/{id}")

                .permitAll().antMatchers("/examination/patientCanceling/{id}")
                .permitAll().antMatchers("/erecipe/findByIdPatient/{id}")

                .permitAll().antMatchers("/drugPricelist/searchDrugName/{id}")
                .permitAll().antMatchers("/patient/findOneById/{id}")
                .permitAll().antMatchers("/examination/patientCancelingPharmacistExamination")




                .permitAll()
                .antMatchers("/pharmacy/findAll").permitAll()
                .antMatchers("/pharmacyDrugs/getAll").permitAll()
                .antMatchers("/pharmacyDrugs/getAllByName/{name}").permitAll()
                .antMatchers("/pharmacyDrugs/getById/{id}").permitAll()
                .antMatchers("/drugPricelist/findAll").permitAll()
                .antMatchers("/pharmacy/findByCity/{city}").permitAll()
                .antMatchers("/pharmacy/findByName/{name}").permitAll()
                .antMatchers("/reservation/create").permitAll()

                .antMatchers("/pharmacy/sortByGradeDescending").permitAll()
                .antMatchers("/examination/sortByGradeDescending").permitAll()
                .antMatchers("/examination/sortByPriceAscending").permitAll()
                .antMatchers("/examination/sortByPriceDescending").permitAll()
                .antMatchers("/pharmacy/sortByGradeAscending").permitAll()
                .antMatchers("/examination/sortByGradeAscending").permitAll()
                .antMatchers("/pharmacy/sortByNameDescending").permitAll()
                .antMatchers("/pharmacy/sortByNameAscending").permitAll()
                .antMatchers("/erecipe/sortByDateAscending/{id}").permitAll()
                .antMatchers("/erecipe/sortByDateDescending/{id}").permitAll()
                .antMatchers("/examination/sortFinishedDEByPriceDesc/{id}").permitAll()
                .antMatchers("/examination/sortFinishedDEByDateDesc/{id}").permitAll()
                .antMatchers("/examination/sortFinishedDEByPriceAsc/{id}").permitAll()
                .antMatchers("/examination/sortFinishedDEByDateAsc/{id}").permitAll()

                //Ovo je dostupno svim korisnicima! Sve ostalo treba da ima pravo pristupa!
                .antMatchers("/user/savePatient").permitAll()
                .antMatchers("/user/loggedUser").permitAll()
                .antMatchers("/user/login").permitAll()
                .antMatchers("/workTime/findAll").permitAll()
                .antMatchers("/workTime/findAllByDate").permitAll()
                .antMatchers("/workTime/findAllByDate/{date}/{time}").permitAll()
                .antMatchers("/workTime/findFreeStaffByPharmacy").permitAll()

                .antMatchers("/drugOrder/**").permitAll()
                //ove zakomentarisati jer imau AUtorizaciju
                .antMatchers("/adminstrator/findAll").permitAll()
                .antMatchers("/offer/**").permitAll()
                .antMatchers("/user/findByEmail/**").permitAll()
                .antMatchers("/user/changePassword").permitAll()

                //.antMatchers("/adminstrator/savePharmacyAdmin").permitAll()
                /*.antMatchers("/user/saveSupplier")
                .permitAll().antMatchers("/user/findAll")
                .permitAll().antMatchers("/drug/**")
                .permitAll()antMatchers("/specification/**")


                .permitAll()*/

                // za svaki drugi zahtev korisnik mora biti autentifikovan
                .anyRequest().authenticated().and()
                // za development svrhe ukljuci konfiguraciju za CORS iz WebConfig klase
                .cors().and()

                // umetni custom filter TokenAuthenticationFilter kako bi se vrsila provera JWT tokena umesto cistih korisnickog imena i lozinke (koje radi BasicAuthenticationFilter)
                .addFilterBefore(new TokenAuthenticationFilter(tokenUtils, jwtUserDetailsService),
                        BasicAuthenticationFilter.class);
        // zbog jednostavnosti primera
        http.csrf().disable();
    }

    // Generalna bezbednost aplikacije
    @Override
    public void configure(WebSecurity web) throws Exception {
        // TokenAuthenticationFilter ce ignorisati sve ispod navedene putanje
        web.ignoring().antMatchers(HttpMethod.POST, "/user/login");
        web.ignoring().antMatchers(HttpMethod.GET, "/", "/webjars/**", "/*.html", "/favicon.ico", "/**/*.html",
                "/**/*.css", "/**/*.js");
    }

}
