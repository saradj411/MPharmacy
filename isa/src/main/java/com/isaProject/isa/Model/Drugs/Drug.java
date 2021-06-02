package com.isaProject.isa.Model.Drugs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Drug implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idDrug;
    @Column
    private String name;
    //sifra
    @Column
    private String code;
    //rezim izdavanja(na recept, bez recepta)
    @Column
    private boolean recipeNeed;
    //vrsta
    @Column
    private String drugType;
    //oblik lijeka
    @Column
    @Enumerated(EnumType.STRING)
    private DrugFormat format;
    //proizvodjac
    @Column
    private String manufacturer;

    //@Cascade(org.hibernate.annotations.CascadeType.DELETE)
/*
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable( name = "alternativeDrug", joinColumns = @JoinColumn(name="idDrug",referencedColumnName="idDrug"), inverseJoinColumns = @JoinColumn(name = "idAlternativeDrug", referencedColumnName = "idDrug"))
*/

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable( name = "alternativeDrug", joinColumns = @JoinColumn(name="idDrug", nullable = true,referencedColumnName="idDrug"), inverseJoinColumns = @JoinColumn(name = "idAlternativeDrug", referencedColumnName = "idDrug"))
    private Set<Drug> alternativeDrugs = new HashSet<Drug>();

    public Drug() {
    }

    public Drug(Integer idDrug, String name, String code, boolean recipeNeed, String drugType, DrugFormat format, String manufacturer
            //, Set<Drug> alternativeDrugs
    ) {
        this.idDrug = idDrug;
        this.name = name;
        this.code = code;
        this.recipeNeed = recipeNeed;
        this.drugType = drugType;
        this.format = format;
        this.manufacturer = manufacturer;
       // this.alternativeDrugs = alternativeDrugs;
    }

    public Integer getIdDrug() {
        return idDrug;
    }

    public void setIdDrug(Integer idDrug) {
        this.idDrug = idDrug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isRecipeNeed() {
        return recipeNeed;
    }

    public void setRecipeNeed(boolean recipeNeed) {
        this.recipeNeed = recipeNeed;
    }

    public String getDrugType() {
        return drugType;
    }

    public void setDrugType(String drugType) {
        this.drugType = drugType;
    }

    public DrugFormat getFormat() {
        return format;
    }

    public void setFormat(DrugFormat format) {
        this.format = format;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Set<Drug> getAlternativeDrugs() {
        return alternativeDrugs;
    }

    public void setAlternativeDrugs(Set<Drug> alternativeDrugs) {
        this.alternativeDrugs = alternativeDrugs;
    }
//rezervisani lijekovi


    /*

    ----popunjavaju šifarnik lekova.
     lijekovi, rezervacija lijeka, sifarnik lijekova

-listu lekova koje je rezervisao - otkazivanje rezervacije leka je moguće najkasnije 24 sata ranije,

--Prilikom pretrage rezervacija, prikazuju se samo one koje su napravljene u istoj apoteci u
kojoj je farmaceut zaposlen



---Za svaku stavku rezultata prikazani su naziv, tip i ocena.
Potrebno je prikazati listu apoteka u kojoj je lek dostupan,
kao i cena leka u svakoj od apoteka.
 Takođe za svaku stavku postoji opcija koje prikazuje specifikaciju leka

 istu lekova koje je rezervisao - otkazivanje rezervacije leka je moguće najkasnije 24 sata ranije,

 3.19. Postupak rezervacije leka
Korisnik pretragom pronalazi lek i bira iz koje apoteke rezerviše lek. Prilikom
rezervacije, bira do kog datuma će preuzeti lek.
Svaka potvrda koja se šalje korisniku na mail sadrži jedinstveni broj rezervacije.




*/
}
