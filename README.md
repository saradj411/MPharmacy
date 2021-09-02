# MPharmacy

Internet softverske arhitekture
*DODATNO UPUTSVO OD STUDENTA 4 JE SKROZ DOLE*

Autori:

Sara Djuric- Student 1

Kristina Mucibabic- Student 2

Verica Mucibabic-Student 3

Maja Milenkovic-Student 4


Mejlovi korisnika:

Patient id 508: patient0874@gmail.com (lozinka: patient98)

Dermatolog id 501:  dermatologistpharmacy@gmail.com (lozinka: dermatologist*1)

Pharmacist id 333: pharmacistpharmacy33@gmail.com  (lozinka:  pharmacist*1)

Supplier id 123: supplierpharmacy33@gmail.com (lozinka :supplier*1)



Tehnologije:

Backend: Java + Spring Boot

Frontend: Vue.js + Axios

RDBMS: MySQL



Instalacija za front:

-NodeJS 

-VueJS

Pratile smo sljedeci snimak za instalaciju https://www.youtube.com/watch?v=Wy9q22isx3U (od 7:20 minuta)


Pokretanje frontenda:

-pozicionirati se na frontend-isa folder u CommandWindow konzoli

-npm install

-npm run serve

-port 3000(ako je potrebno promijeniti port, to se moze uraditi u frontend-isa/vue.config.js)

-ako je u frontend aplikaciji potrebno promijeniti port backend apliakcije, moze u frontend-isa/src/main.js

Instalacija za backend:

Skinuti Intelij i instalirati ga: https://www.jetbrains.com/idea/download/#section=windows

Pokretanje backenda:

File->Open-> izabrati folder isa (to nam je backend), desni klik na projekat->Open module settings->podesiti SDKs(mi smo koristili razlicite, jdk 1.8, jdk15..)

Add configuration-> + -> Application -> izabradi isti jdk, i kao Main class izabrati com.isaProject.isa.IsaApplication...

Maven install

Run

-port 8083



Baza:

Ne radi spring hibernate automatsko popunjavanje baze preko skripte scheme.sql, zbog toga je potrebno koristiti MySQL Workbench 8.0 CE, pokrenuti skriptu schema.sql za popunjavanje baze

username:root

password:root

Dodatne napomene:
1. Potrebno je iskljuciti avast radi testiranja jer blokira slanje email-ova.
2. https://myaccount.google.com/lesssecureapps?pli=1&rapt=AEjHL4MsInjIYwcSZC-USbz9it79qaL-rdDHdgfF7ZTA-cW2utOfhBDNmfs-JqI2XFEgC8QTiInfGX_hAQH0OQ6awC-GBVMUjQ stavite da bude ukljuceno za email na koji se salje bilo kakva poruka.
3. Svakom korisniku u bazi sistema se pristupa sa lozinkom 123


