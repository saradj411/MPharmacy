
insert into pharmacy values (501,'Novosadska 3',7,'Novi Sad',550,'Srbija','opis5','Jankovic',2, 21000, 'Street 2', 'Novi Sad');
insert into pharmacy values (502,'Gagarinova 10',8,'Novi Sad',600,'Srbija','opis5','Benu',2, 21000, 'Street 2', 'Novi Sad');
insert into pharmacy values (503,'Bore Stankovica 2',6,'Novi Sad',800,'Srbija','opis5','Zegin',2, 21000, 'Street 2', 'Novi Sad');
insert into pharmacy values (504,'Knez Mihajlova 23',9,'Novi Sad',1050,'Srbija','opis5','Srbotrade',2, 21000, 'Street 2', 'Novi Sad');
insert into pharmacy values (505,'Bore Petrovica 1',10,'Novi Sad',1500,'Srbija','opis5','DedaPharm',2, 21000, 'Street 2', 'Novi Sad');


#drug
insert into drug values (501,'sifra 1','tableta','TABLET',8,'proizvodjac 1','probiotik','nap1',10,true);
insert into drug values (502,'sifra 2','kapsula','CAPSULE',6,'proizvodjac 2','paracetamol','nap2',20,true);
insert into drug values (503,'sifra 3','tableta','TABLET',7,'proizvodjac 3','andol','nap1',10,false);
insert into drug values (504,'sifra 4','kapsula','CAPSULE',5,'proizvodjac 4','ampril','nap13',15,true);
insert into drug values (505,'sifra 5','prasak','INJECTION',8,'proizvodjac 5','aspirin','nap3',12,true);
insert into drug values (506,'sifra 6','tableta','TABLET',10,'proizvodjac 6','brufen','naa',22,false);
insert into drug values (507,'sifra 7','sprej','GEL',7,'proizvodjac 7','mometazonfuorat','nap1',10,true);
insert into drug values (508,'sifra 8','kapsula','CAPSULE',3,'proizvodjac 8','gentamicin','nap34',5,true);

insert into drug values (509,'sifra 9','kapsula','CAPSULE',3,'DOO Komerc','flonidan','aaam',8,true);
insert into drug values (510,'sifra 10','tableta','TABLET',6,'DOO Komerc','pressing','amaa',10,true);
#pharmacy_drugs
#id_quantity_idDrug_idPharmacy
    insert into pharmacy_drugs values (501,50,503,503);
    insert into pharmacy_drugs values (502,8,504,501);
    insert into pharmacy_drugs values (503,6,505,503); -- Aspirin imamo u svim apotekama
    insert into pharmacy_drugs values (504,90,506,504);
    insert into pharmacy_drugs values (505,3,507,502);
    insert into pharmacy_drugs values (506,5,503,501);
    insert into pharmacy_drugs values (507,8,504,502);
    insert into pharmacy_drugs values (508,8,507,501);
    insert into pharmacy_drugs values (520,6,506,501);
    insert into pharmacy_drugs values (511,30,508,502);
    insert into pharmacy_drugs values (512,15,508,504);
    insert into pharmacy_drugs values (514,12,507,504);
    insert into pharmacy_drugs values (515,40,501,501);
    insert into pharmacy_drugs values (516,3,501,503);
    insert into pharmacy_drugs values (517,30,502,503);
    insert into pharmacy_drugs values (518,22,502,504);
    insert into pharmacy_drugs values (519,21,503,504);
    insert into pharmacy_drugs values (534,60,505,504); -- Aspirin imamo u svim apotekama
    insert into pharmacy_drugs values (521,14,505,501);
    insert into pharmacy_drugs values (522,54,505,502);
    insert into pharmacy_drugs values (523,25,505,505);


    insert into pharmacy_drugs values (524,10,509,501); -- flonidan ima u svim
    insert into pharmacy_drugs values (530,11,509,502);
    insert into pharmacy_drugs values (531,13,509,503);
    insert into pharmacy_drugs values (532,45,509,504);
    insert into pharmacy_drugs values (533,34,509,505);

    insert into pharmacy_drugs values (525,10,510,505); -- PResing ima u svim
    insert into pharmacy_drugs values (526,16,510,504);
    insert into pharmacy_drugs values (527,190,510,503);
    insert into pharmacy_drugs values (528,34,510,502);
    insert into pharmacy_drugs values (529,7,510,501);

    insert into pharmacy_drugs values (1,1,507,503);




#altervnative_drugs
    insert into alternative_drug values (505,501);
    insert into alternative_drug values (503,501);
    insert into alternative_drug values (503,502);
    insert into alternative_drug values (503,507);
    insert into alternative_drug values (501,504);
    insert into alternative_drug values (501,507);
    insert into alternative_drug values (506,501);
    insert into alternative_drug values (506,504);

#drug_pricelist
    #id,end,price,start,drug_id,pharmacy_id

    insert into drug_pricelist values (501,'2021-08-12',100,'2021-02-27',503,503);
    insert into drug_pricelist values (502,'2021-10-12',250,'2021-01-01',504,501);
    insert into drug_pricelist values (503,'2021-06-11',300,'2020-06-11',505,503);
    insert into drug_pricelist values (504,'2021-07-12',180,'2020-02-02',506,504);
    insert into drug_pricelist values (505,'2021-12-01',300,'2020-04-07',507,502);
    insert into drug_pricelist values (506,'2021-09-09',280,'2020-04-01',503,501);
    insert into drug_pricelist values (507,'2021-11-01',300,'2020-07-07',504,502);
    insert into drug_pricelist values (532,'2021-11-01',286,'2020-07-07',506,501);
    insert into drug_pricelist values (509,'2021-11-01',300,'2020-07-07',507,501);
    insert into drug_pricelist values (510,'2021-11-01',500,'2020-08-01',508,502);
    insert into drug_pricelist values (511,'2021-11-01',300,'2020-08-11',508,504);
    insert into drug_pricelist values (512,'2021-11-01',260,'2020-08-20',507,504);
    insert into drug_pricelist values (513,'2021-09-01',650,'2020-07-07',501,501);
    insert into drug_pricelist values (514,'2021-12-01',301,'2020-08-03',501,503);
    insert into drug_pricelist values (515,'2021-08-12',240,'2020-06-01',502,503);
    insert into drug_pricelist values (516,'2021-11-10',100,'2020-08-17',502,504);
    insert into drug_pricelist values (517,'2021-12-12',256,'2020-08-22',503,504);

    insert into drug_pricelist values (533,'2021-12-12',256,'2020-08-10',507,503);
    insert into drug_pricelist values (518,'2021-12-12',500,'2020-09-01',505,501); -- Aspirin
    insert into drug_pricelist values (519,'2021-12-13',300,'2020-08-31',505,502);
    insert into drug_pricelist values (520,'2021-12-10',260,'2020-08-31',505,504);
    insert into drug_pricelist values (521,'2021-10-12',600,'2020-08-30',505,505);

    insert into drug_pricelist values (522,'2021-10-12',179,'2020-08-30',509,501); --flonidan
    insert into drug_pricelist values (524,'2021-10-05',200,'2020-09-01',509,502);
    insert into drug_pricelist values (523,'2021-10-21',366,'2020-09-02',509,503);
    insert into drug_pricelist values (525,'2021-10-10',574,'2020-08-23',509,504);
    insert into drug_pricelist values (526,'2021-11-15',566,'2020-08-31',509,505);

    insert into drug_pricelist values (527,'2021-09-30',544,'2020-08-31',510,505); -- presing
    insert into drug_pricelist values (528,'2021-09-19',73,'2020-08-31',510,504);
    insert into drug_pricelist values (529,'2021-10-12',199,'2020-09-01',510,503);
    insert into drug_pricelist values (530,'2021-11-30',344,'2020-08-20',510,502);
    insert into drug_pricelist values (531,'2021-12-12',266,'2020-08-26',510,501);




 #user
    #id_user,address,city,country,email,name,password,phone_number,surname,avg,loyality,penali,points,id faarmacije u kojoj farmaceut radi,id apoteke za farmaceuta apoteke
    insert into users values (501,1,'Deletinara','Novi Sad','Srbija','dermatologistpharmacy@gmail.com','Kristina','$2a$10$sqes3IpPL4mBgAAmimisyOWj5DlqPRndrJFNFw9zWiJjyNa5ozKS6','066589145','Mucibabic');
    insert into users values (502,1,'Bulevar kneza Milosa','Novi Sad','Srbija','sara@gmail.com','Sara','$2a$10$sqes3IpPL4mBgAAmimisyOWj5DlqPRndrJFNFw9zWiJjyNa5ozKS6','066589111','Djuric');
    insert into users values (503,1,'Bulevar oslobodjenja','Novi Sad','Srbija','vekim@gmail.com','Verica','$2a$10$sqes3IpPL4mBgAAmimisyOWj5DlqPRndrJFNFw9zWiJjyNa5ozKS6','066589335','Mucibabic');
    insert into users values (504,1,'Cara Urosa','Novi Sad','Srbija','majam@gmail.com','Maja','$2a$10$sqes3IpPL4mBgAAmimisyOWj5DlqPRndrJFNFw9zWiJjyNa5ozKS6','066589335','Milenkovic');
    insert into users values (505,1,'Bulevar cara Lazara','Novi Sad','Srbija','marija@gmail.com','Marija','$2a$10$sqes3IpPL4mBgAAmimisyOWj5DlqPRndrJFNFw9zWiJjyNa5ozKS6','066589935','Maric');
    insert into users values (506,1,'Aleksa Santic','Novi Sad','Srbija','luka@gmail.com','Luka','$2a$10$sqes3IpPL4mBgAAmimisyOWj5DlqPRndrJFNFw9zWiJjyNa5ozKS6','066589011','Lukic');
    insert into users values (507,1,'Apatinska','Novi Sad','Srbija','mika@gmail.com','Mika','$2a$10$sqes3IpPL4mBgAAmimisyOWj5DlqPRndrJFNFw9zWiJjyNa5ozKS6','066589331','Mikic');
    insert into users values (508,1,'Backa','Novi Sad','Srbija','patient0874@gmail.com','Ana','loz$2a$10$sqes3IpPL4mBgAAmimisyOWj5DlqPRndrJFNFw9zWiJjyNa5ozKS6inka8','066589371','Mikic');
    insert into users values (509,1,'Cara Milosa','Novi Sad','Srbija','urosm@gmail.com','Uros','$2a$10$sqes3IpPL4mBgAAmimisyOWj5DlqPRndrJFNFw9zWiJjyNa5ozKS6','066589335','Milenkovic');
    insert into users values (510,1,'Bulevar cara Lazara','Novi Sad','Srbija','luna@gmail.com','Luna','$2a$10$sqes3IpPL4mBgAAmimisyOWj5DlqPRndrJFNFw9zWiJjyNa5ozKS6','066589371','Mikic');
    insert into users values (511,1,'Bulevar kneza Milosa','Novi Sad','Srbija','maki@gmail.com','Maki','$2a$10$sqes3IpPL4mBgAAmimisyOWj5DlqPRndrJFNFw9zWiJjyNa5ozKS6','066589111','Djuric');
    insert into users values (333,1,'Bulevar kneza Milosa','Novi Sad','Srbija','pharmacistpharmacy33@gmail.com ','Sara','$2a$10$sqes3IpPL4mBgAAmimisyOWj5DlqPRndrJFNFw9zWiJjyNa5ozKS6','066589111','Djuric');
    insert into users values (559,1,'Bulevar kneza Milosa','Novi Sad','Srbija','veki@gmail.com','Veki','$2a$10$sqes3IpPL4mBgAAmimisyOWj5DlqPRndrJFNFw9zWiJjyNa5ozKS6','066589111','V');
    insert into users values (533,1,'Cara Milosa','Novi Sad','Srbija','ivanm@gmail.com','Ivan','$2a$10$sqes3IpPL4mBgAAmimisyOWj5DlqPRndrJFNFw9zWiJjyNa5ozKS6','066589335','Milenkovic');
    insert into users values (512,1,'Gagarinova 3','Novi Sad','Srbija','majamilenkovic98@gmail.com','Dejan','$2a$10$sqes3IpPL4mBgAAmimisyOWj5DlqPRndrJFNFw9zWiJjyNa5ozKS6','066589371','Dekic');
    insert into users values (123,1,'Deletinara','Novi Sad','Srbija','supplierpharmacy33@gmail.com','Ivana','$2a$10$sqes3IpPL4mBgAAmimisyOWj5DlqPRndrJFNFw9zWiJjyNa5ozKS6','066589145','Mucibabic');


 #Authority_table
    INSERT INTO authority values (1, 'ROLE_ADMIN');
    INSERT INTO authority values (2, 'ROLE_PHARMACY_ADMIN');
    INSERT INTO authority values (3, 'ROLE_PHARMACIST');
    INSERT INTO authority values (4, 'ROLE_DERMATOLOGIST');
    INSERT INTO authority values (5, 'ROLE_PATIENT');
    INSERT INTO authority values (6, 'ROLE_SUPPLIER');


#user_authority
    insert into user_authority values(501, 4);
    insert into user_authority values(502, 3);
    insert into user_authority values(503, 2);
    insert into user_authority values(123, 6);
    insert into user_authority values(504, 4);
    insert into user_authority values(505, 2);
    insert into user_authority values(506, 3);
    insert into user_authority values(507, 5);
    insert into user_authority values(508, 5);
    insert into user_authority values(509, 4);
    insert into user_authority values(510, 5);
    insert into user_authority values(511, 3);
    insert into user_authority values(512, 1);
    insert into user_authority values(333, 3);
    insert into user_authority values(559, 3);
    insert into user_authority values(533, 4);


 #staff
    insert into staff values (8, 501);
    insert into staff values (6.3, 504);
    insert into staff values (7, 509);
    insert into staff values (6.2, 533);

    insert into staff values (6.4, 502);
    insert into staff values (7.2, 506);
    insert into staff values (7.2, 511);
    insert into staff values (7.2, 333);
    insert into staff values (7.2, 559);

    #dermatolozi
    insert into dermatologist values (501);
    insert into dermatologist values (504);
    insert into dermatologist values (509);
    insert into dermatologist values (533);


 #patient
    #loyality_category, penalty, points, id
    insert into patient values ("GOLD",2, 10,507);
    insert into patient values ("SILVER",1, 8,508);
    insert into patient values ("BRONZE",0, 7,510);

    #pharmacist
    #id, pharmacist_pharmacy
    insert into pharmacist values (502, 503);
    insert into pharmacist values (506, 504);
    insert into pharmacist values (511, 501);
    insert into pharmacist values (333, 501);
    insert into pharmacist values (559, 501);

    #sys_admin
    insert into sys_admin values (512);

 #pharmacy_admin
    insert into pharmacy_admin values(503,501);

    #dermatologists_in_pharmacies
    # id dermatologa, id apoteke
    insert into dermatologists_in_pharmacies values(501,501);
    insert into dermatologists_in_pharmacies values(504,501);
    insert into dermatologists_in_pharmacies values(509,503);
    insert into dermatologists_in_pharmacies values(533,501);
    insert into dermatologists_in_pharmacies values(501,502);


--specification
--id_spec, contraindications, ingredients, recommended_dose, structure, drug_code
insert into specification values (500,'iritacija sinusa','sastojak 1, sastojak 2',4,'sastav 1','sifra 1');
insert into specification values (501,'iritacija oka','sastojak 1',6,'sastav 2','sifra 2');
insert into specification values (502,'nema','sastojak 3, sastojak 2',7,'sastav 3','sifra 3');
insert into specification values (503,'iritacija sinusa','sastojak 13',2,'sastav 4','sifra 4');
insert into specification values (504,'nema','sastojak 4',9,'sastav 5','sifra 5');

insert into specification values (505,'Lose po dijabeticare.','sastojak 4',9,'sastav 1','sifra 6');
insert into specification values (506,'nema','sastojak 4',9,'sastav 2','sifra 7');
insert into specification values (507,'Ne znamo.','sastojak 4',9,'sastav 32','sifra 8');
insert into specification values (508,'Moguce povracanje','sastojak 4',9,'sastav 43','sifra 9');
insert into specification values (509,'Prekomerno spavanje.','sastojak 4',1,'sastav 25','sifra 10');



#ingredient
insert into ingredient values(500,'sastojak 1',504);
insert into ingredient values(501,'sastojak 1',500);
insert into ingredient values(502,'sastojak 1',503);
insert into ingredient values(503,'sastojak 1',502);
insert into ingredient values(504,'sastojak 1',501);

#supplier
insert into supplier value(123);


#allergies
#id patient,id drug
insert into allergies values(507,502);
insert into allergies values(507,501);
insert into allergies values(510,503);
insert into allergies values(510,502);
insert into allergies values(508,502);
insert into allergies values(508,504);


#drug_order
#id order,processed,kolicina,timelimit,admin
insert into drug_order values(500,true,5,'2021-08-12',503);
insert into drug_order values(501,false,4,'2021-09-20',503);
insert into drug_order values(502,false,8,'2021-11-20',503);
insert into drug_order values(503,true,2,'2021-12-20',503);
insert into drug_order values(504,true,4,'2021-10-20',503);
insert into drug_order values(505,true,20,'2021-05-20',503);





#drug_reservation

insert into drug_reservation values(500,false,'2021-04-20',false,false,'2021-06-20',3,503,510,503);
insert into drug_reservation values(501,true,'2021-05-25',false,false,'2021-06-15',3,504,510,501);
insert into drug_reservation values(502,false,'2021-04-20',false,true,'2021-07-20',3,505,508,503);
insert into drug_reservation values(503,false,'2021-05-18',true,false,'2021-07-20',3,506,510,504);
insert into drug_reservation values(504,true,'2021-04-20',false,true,'2021-09-20',3,507,507,502);
insert into drug_reservation values(505,false,'2021-04-20',false,false,'2021-09-20',3,503,510,503);
insert into drug_reservation values(506,true,'2021-05-25',false,true,'2021-06-15',3,504,508,501);
insert into drug_reservation values(507,false,'2021-04-20',true,false,'2021-08-20',3,505,507,503);
insert into drug_reservation values(508,false,'2021-05-18',true,true,'2021-07-20',3,506,508,504);
insert into drug_reservation values(509,false,'2021-04-20',false,false,'2021-05-24',3,507,507,502);
insert into drug_reservation values(510,false,'2021-04-20',false,true,'2021-05-24',3,507,508,502);
insert into drug_reservation values(511,true,'2021-01-25',false,false,'2021-01-15',3,504,510,501);
insert into drug_reservation values(512,true,'2021-02-25',false,true,'2021-02-16',3,504,510,501);

insert into drug_reservation values(513,true,'2021-03-25',false,true,'2021-03-17',3,504,510,501);
insert into drug_reservation values(514,true,'2021-04-25',false,false,'2021-04-18',3,504,510,501);




#therapy
insert into therapy values(500,3,504);
insert into therapy values(501,5,501);
insert into therapy values(502,8,502);
insert into therapy values(503,9,503);
insert into therapy values(504,4,505);
insert into therapy values(505,7,506);


insert into action_patient_pharmacy values(507,501);
insert into action_patient_pharmacy values(507,503);
insert into action_patient_pharmacy values(507,504);
insert into action_patient_pharmacy values(508,501);
insert into action_patient_pharmacy values(508,504);
insert into action_patient_pharmacy values(510,502);
insert into action_patient_pharmacy values(510,501);

insert into erecipe values(500,"12345",'2021-05-24','Ana',"NEW",'Mikic',508,501,511);
insert into erecipe values(501,"12346",'2021-05-22','Ana',"NEW",'Mikic',508,501,511);


insert into erecipe_drug values(500,"sifra 1",'probiotik',7,501);
insert into erecipe_drug values(501,"sifra 2",'paracetamol',8,501);
insert into erecipe_drug values(502,"sifra 1",'probiotik',9,501);
insert into erecipe_drug values(503,"sifra 2",'paracetamol',11,501);


insert into erecipe_e_recipe_drug values(500,501);
insert into erecipe_e_recipe_drug values(500,500);
insert into erecipe_e_recipe_drug values(501,502);
insert into erecipe_e_recipe_drug values(501,503);


insert into order_item values (1, 10, 502, 500);
insert into order_item values (2, 10, 503, 500);
insert into order_item values (3, 5, 506, 502);
insert into order_item values (5, 100, 504, 503);
insert into order_item values  (6, 20, 504, 505);
insert into order_item values  (7, 10, 501, 505);
insert into order_item values (500,5,501,500);
insert into order_item values (501,3,502,500);
insert into order_item values (503,6,503,502);
insert into order_item values (504,7,503,503);
insert into order_item values (505,5,505,504);
insert into order_item values (506,5,506,505);
insert into order_item values (507,5,506,503);
insert into order_item values (509,5,501,501);
insert into order_item values (510,5,505,501);
insert into order_item values (511,5,504,501);





#request_for_vacation
insert into request_for_vacation values(600,false,'opiz','2021-06-20',true,'2020-06-20',501,502);

insert into request_for_vacation values(601,false,'opiz','2021-06-20',true,'2020-06-20',501,502);

insert into request_for_vacation values(602,false,'opiz','2021-06-20',true,'2020-06-20',501,502);

insert into request_for_vacation values(604,false,'opiz','2021-06-20',false,'2020-06-20',502,501);

insert into request_for_vacation values(605,false,'opiz','2021-06-20',false,'2020-06-20',502,504);

insert into request_for_vacation values(606,false,'opiz','2021-06-20',true,'2020-06-20',502,533);



#offers
insert into offer values (500,'2021-07-22','ON_HOLD',550,500,123);
insert into offer values (501,'2021-08-22','ON_HOLD',860,501,123);
insert into offer values (502,'2021-09-22','CONFIRMED',502,502,123);
insert into offer values (504,'2021-08-22','ON_HOLD',250,503,123);
insert into offer values (505,'2021-09-22','CONFIRMED',252,504,123);
insert into offer values (506,'2021-09-22','CONFIRMED',252,505,123);
insert into offer values (509,'2021-07-22','ON_HOLD',123,500,123);
insert into offer values (511,'2021-08-22','ON_HOLD',569,501,123);
insert into offer values (512,'2021-09-22','ON_HOLD',256,502,123);
insert into offer values (514,'2021-08-22','ON_HOLD',250,503,123);
insert into offer values (515,'2021-09-22','ON_HOLD',356,504,123);
insert into offer values (516,'2021-09-22','ON_HOLD',252,505,123);



    #work_timelimit
	#dermatolog 501
    insert into work_time values(501,'2021-07-22','15:00:00','06:30:00',501,501);
       insert into work_time values(502,'2021-07-23','15:00:00','06:30:00',501,501);
       insert into work_time values(504,'2021-07-24','15:00:00','06:30:00',501,501);
       insert into work_time values(503,'2021-07-22','20:00:00','15:30:00',502,501);
       insert into work_time values(505,'2021-07-23','20:00:00','15:30:00',502,501);
       insert into work_time values(598,'2021-07-24','20:00:00','15:30:00',502,501);
       
        insert into work_time values(551,'2021-07-25','19:00:00','06:30:00',501,501);
       insert into work_time values(552,'2021-07-26','19:00:00','06:30:00',501,501);
       insert into work_time values(554,'2021-07-27','19:00:00','06:30:00',501,501);
       
        insert into work_time values(555,'2021-07-28','19:00:00','06:30:00',501,501);
       insert into work_time values(556,'2021-07-29','19:00:00','06:30:00',501,501);
       insert into work_time values(553,'2021-07-30','19:00:00','06:30:00',501,501);




#work_timelimit
#dermatolog 504
insert into work_time values(506,'2021-07-22','19:00:00','06:30:00',501,504);
insert into work_time values(507,'2021-07-23','19:00:00','06:30:00',501,504);
insert into work_time values(508,'2021-07-24','19:00:00','06:30:00',501,504);
insert into work_time values(509,'2021-07-25','19:00:00','06:30:00',501,504);

#work_timelimit
insert into work_time values(566,'2021-07-26','19:00:00','06:30:00',501,504);
insert into work_time values(567,'2021-07-27','19:00:00','06:30:00',501,504);
insert into work_time values(568,'2021-07-28','19:00:00','06:30:00',501,504);
insert into work_time values(569,'2021-07-29','19:00:00','06:30:00',501,504);





#work_timelimit
#farmaceut 502
insert into work_time values(540,'2021-07-22','19:00:00','06:30:00',503,502);
insert into work_time values(541,'2021-07-23','19:00:00','06:30:00',503,502);
insert into work_time values(542,'2021-07-24','19:00:00','06:30:00',503,502);
insert into work_time values(543,'2021-07-25','19:00:00','06:30:00',503,502);

#work_timelimit
insert into work_time values(544,'2021-07-26','19:00:00','06:30:00',503,502);
insert into work_time values(545,'2021-07-28','19:00:00','06:30:00',503,502);
insert into work_time values(546,'2021-07-28','19:00:00','06:30:00',503,502);
insert into work_time values(547,'2021-07-29','19:00:00','06:30:00',503,502);

#work_timelimit
#farmaceut 506
insert into work_time values(570,'2021-07-22','19:00:00','06:30:00',504,506);
insert into work_time values(571,'2021-07-23','19:00:00','06:30:00',504,506);
insert into work_time values(572,'2021-07-24','19:00:00','06:30:00',504,506);
insert into work_time values(573,'2021-07-25','19:00:00','06:30:00',504,506);

#work_timelimit
insert into work_time values(574,'2021-07-26','19:00:00','06:30:00',504,506);
insert into work_time values(575,'2021-07-28','19:00:00','06:30:00',504,506);
insert into work_time values(576,'2021-07-28','19:00:00','06:30:00',504,506);
insert into work_time values(577,'2021-07-29','19:00:00','06:30:00',504,506);

insert into examination values(550,false,'2020-05-20','09:00:00',true,null,600,'info1','08:00:00','FINISHED','DERMATOLOGIST_EXAMINATION',508,501,501,null);

insert into examination values(551,false,'2020-05-23','11:00:00',true,null,880,'info2','09:30:00','FINISHED','DERMATOLOGIST_EXAMINATION',508,501,504,501);
insert into examination values(553,false,'2020-01-20','09:00:00',true,null,600,'info1','08:00:00','FINISHED','DERMATOLOGIST_EXAMINATION',507,501,501,null);
insert into examination values(554,false,'2020-02-23','11:00:00',true,null,880,'info2','09:30:00','FINISHED','DERMATOLOGIST_EXAMINATION',507,501,504,502);

insert into examination values(555,false,'2020-03-27','12:00:00',true,null,1050,'info2','10:30:00','FINISHED','PHARMACIST_EXAMINATION',508,501,511,null);
insert into examination values(559,false,'2020-03-26','12:00:00',true,null,1050,'info2','10:30:00','FINISHED','PHARMACIST_EXAMINATION',507,501,511,503);
insert into examination values(556,false,'2020-08-29','11:00:00',true,null,1030,'info2','09:30:00','FINISHED','DERMATOLOGIST_EXAMINATION',510,501,501,null);
insert into examination values(557,false,'2020-08-27','12:00:00',true,null,1050,'info2','10:30:00','FINISHED','DERMATOLOGIST_EXAMINATION',510,501,504,504);
insert into examination values(500,false,'2021-07-23','09:00:00',false,null,600,'info1','08:00:00','CREATED','DERMATOLOGIST_EXAMINATION',null,501,501,null);
insert into examination values(505,false,'2021-07-22','11:00:00',false,null,880,'info2','09:30:00','CREATED','DERMATOLOGIST_EXAMINATION',null,501,501,null);
insert into examination values(510,false,'2021-07-29','11:00:00',false,null,1030,'info2','09:30:00','CREATED','DERMATOLOGIST_EXAMINATION',null,501,501,null);
insert into examination values(511,false,'2021-07-27','12:00:00',false,null,1050,'info2','10:30:00','CREATED','DERMATOLOGIST_EXAMINATION',null,501,504,null);
insert into examination values(501,false,'2021-07-22','11:00:00',false,null,880,'info2','09:30:00','CREATED','DERMATOLOGIST_EXAMINATION',null,501,504,null);
insert into examination values(506,false,'2021-07-22','11:00:00',false,null,1000,'info2','09:30:00','CREATED','PHARMACIST_EXAMINATION',null,501,511,null);
insert into examination values(509,false,'2021-08-27','12:00:00',false,null,1050,'info2','10:30:00','CREATED','PHARMACIST_EXAMINATION',null,501,511,null);
insert into examination values(508,false,'2021-07-23','11:00:00',false,null,1000,'info2','09:30:00','CREATED','PHARMACIST_EXAMINATION',null,501,511,null);
insert into examination values(542,false,'2021-08-28','12:00:00',false,null,1050,'info2','10:30:00','CREATED','PHARMACIST_EXAMINATION',null,501,511,null);
insert into examination values(503,false,'2021-07-22','11:00:00',false,null,880,'info2','09:30:00','CREATED','PHARMACIST_EXAMINATION',null,503,502,null);
insert into examination values(1,false,'2021-07-22','11:00:00',false,null,880,'info2','09:30:00','CREATED','PHARMACIST_EXAMINATION',null,504,506,null);

insert into loyality_program value(1, '2021-09-01',1,10,15,20,10,20,30)
