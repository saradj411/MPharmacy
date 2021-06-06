# MPharmacy

Internet softverske arhitekture

Autori:

Sara Djuric- Student 1

Kristina Mucibabic- Student 2

Verica Mucibabic-Student 3

Maja Milenkovic-Student 4




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


Pokretanje backenda:

Skinuti Intelij i instalirati ga: https://www.jetbrains.com/idea/download/#section=windows

File->Open-> izabrati folder isa (to nam je backend), desni klik na projekat->Open module settings->podesiti SDKs(mi smo koristili razlicite, jdk 1.8, jdk15..)

Add configuration-> + -> Application -> izabradi isti jdk, i kao Main class izabrati com.isaProject.isa.IsaApplication...

Maven install

Run

-port 8083



Baza:

Ne radi spring hibernate automatsko popunjavanje baze preko skripte scheme.sql, zbog toga je potrebno koristiti MySQL Workbench 8.0 CE, pokrenuti skriptu schema.sql za popunjavanje baze

username:root

password:root
