#pharmacy
insert into pharmacy values (500,'Novi Sad',3.5,'opis 1','Jankovic 1');
insert into pharmacy values (501,'Nis',4.5,"opis 2","Jankovic 2");
insert into pharmacy values (502,'Valjevo',7.5,"opis 3","Jankovic 3");
insert into pharmacy values (503,'Kraljevo',8.3,"opis 4","Jankovic 4");
insert into pharmacy values (504,'Beograd',4.8,"opis 5","Jankovic 5");


#drug
insert into drug values (501,'sifra 1','tableta','TABLET','proizvodjac 1','probiotik',true);
insert into drug values (502,'sifra 2','kapsula','CAPSULE','proizvodjac 2','paracetamol',true);
insert into drug values (503,'sifra 3','tableta','TABLET','proizvodjac 3','andol',false);
insert into drug values (504,'sifra 4','kapsula','CAPSULE','proizvodjac 4','ampril',true);
insert into drug values (505,'sifra 5','prasak','INJECTION','proizvodjac 5','aspirin',false);
insert into drug values (506,'sifra 6','tableta','TABLET','proizvodjac 6','brufen',false);
insert into drug values (507,'sifra 7','sprej','GEL','proizvodjac 7','mometazonfuorat',true);
insert into drug values (508,'sifra 8','sprej','GEL','proizvodjac 8','andol',true);


#pharmacy_drugs
#id,kolicina,drug_id,pharmacy_id
insert into pharmacy_drugs values (509,5,508,501);
insert into pharmacy_drugs values (501,5,503,503);
insert into pharmacy_drugs values (502,8,504,501);
insert into pharmacy_drugs values (503,6,505,503);
insert into pharmacy_drugs values (504,9,506,504);
insert into pharmacy_drugs values (505,3,507,502);
insert into pharmacy_drugs values (506,5,503,500);
insert into pharmacy_drugs values (507,8,504,502);
insert into pharmacy_drugs values (508,8,507,501);



#drug_pricelist
#id,end,price,start,drug_id,pharmacy_id

insert into drug_pricelist values (501,'2021-08-12',100,'2021-02-27',503,503);
insert into drug_pricelist values (502,'2021-10-12',250,'2021-01-01',504,501);
insert into drug_pricelist values (503,'2021-06-11',300,'2020-06-11',505,503);
insert into drug_pricelist values (504,'2021-07-12',180,'2020-02-02',506,504);
insert into drug_pricelist values (505,'2021-12-01',300,'2020-04-07',507,502);
insert into drug_pricelist values (506,'2021-09-09',280,'2020-04-01',503,500);
insert into drug_pricelist values (507,'2021-11-01',300,'2020-07-07',504,502);
insert into drug_pricelist values (508,'2021-11-01',286,'2020-07-07',508,501);
insert into drug_pricelist values (509,'2021-11-01',300,'2020-07-07',507,501);

#specification
#id,contraindikacija,doza,struktura,code

insert into specification values (500,'iritacija sinusa',4,'sastav 1','sifra 1');
insert into specification values (501,'iritacija oka',6,'sastav 2','sifra 2');
insert into specification values (502,'nema',7,'sastav 3','sifra 3');
insert into specification values (503,'iritacija sinusa',2,'sastav 4','sifra 4');
insert into specification values (504,'nema',9,'sastav 5','sifra 5');

#ingredient

insert into ingredient values(500,'sastojak 1',504);
insert into ingredient values(501,'sastojak 1',500);
insert into ingredient values(502,'sastojak 1',503);
insert into ingredient values(503,'sastojak 1',502);
insert into ingredient values(504,'sastojak 1',501);

#user
#id_user,address,city,country,email,name,password,phone_number,surname,avg,loyality,penali,points,id faarmacije u kojoj farmaceut radi,id apoteke za farmaceuta apoteke
insert into users values (501,1,'Deletinara','Novi Sad','Srbija','kristinamucibabic321@gmail.com','Kristina','lozinka1','066589145','Mucibabic');
insert into users values (502,1,'Bulevar kneza Milosa','Novi Sad','Srbija','sara@gmail.com','Sara','lozinka2','066589111','Djuric');
insert into users values (503,1,'Bulevar oslobodjenja','Novi Sad','Srbija','vekim@gmail.com','Verica','lozinka3','066589335','Mucibabic');
insert into users values (504,1,'Cara Urosa','Novi Sad','Srbija','majam@gmail.com','Maja','lozinka4','066589335','Milenkovic');
insert into users values (505,1,'Bulevar cara Lazara','Novi Sad','Srbija','marija@gmail.com','Marija','lozinka5','066589935','Maric');
insert into users values (506,1,'Aleksa Santic','Novi Sad','Srbija','luka@gmail.com','Luka','lozinka6','066589011','Lukic');
insert into users values (507,1,'Apatinska','Novi Sad','Srbija','mika@gmail.com','Mika','lozinka7','066589331','Mikic');
insert into users values (508,1,'Backa','Novi Sad','Srbija','ana@gmail.com','Ana','lozinka8','066589371','Mikic');
insert into users values (509,1,'Cara Milosa','Novi Sad','Srbija','urosm@gmail.com','Uros','lozinka9','066589335','Milenkovic');
insert into users values (510,1,'Bulevar cara Lazara','Novi Sad','Srbija','luna@gmail.com','Luna','lozinka10','066589371','Mikic');
insert into users values (511,1,'Bulevar kneza Milosa','Novi Sad','Srbija','maki@gmail.com','Maki','lozinka11','066589111','Djuric');
insert into users values (333,1,'Bulevar kneza Milosa','Novi Sad','Srbija','sara@gmail.com','Sara','lozinka2','066589111','Djuric');
insert into users values (559,1,'Bulevar kneza Milosa','Novi Sad','Srbija','veki@gmail.com','Veki','pasword','066589111','V');
insert into users values (533,1,'Cara Milosa','Novi Sad','Srbija','ivanm@gmail.com','Ivan','lozinka9','066589335','Milenkovic');
insert into users values (512,1,'Gagarinova 3','Novi Sad','Srbija','majamilenkovic98@gmail.com','Dejan','$2a$10$sqes3IpPL4mBgAAmimisyOWj5DlqPRndrJFNFw9zWiJjyNa5ozKS6','066589371','Dekic');


#Authority_table
INSERT INTO authority values (1, 'ADMIN');
INSERT INTO authority values (2, 'PHARMACY_ADMIN');
INSERT INTO authority values (3, 'PHARMACIST');
INSERT INTO authority values (4, 'DERMATOLOGIST');
INSERT INTO authority values (5, 'PATIENT');
INSERT INTO authority values (6, 'SUPPLIER');

#user_authority
insert into user_authority values(501, 4);
insert into user_authority values(502, 3);
insert into user_authority values(503, 2);
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
insert into pharmacist values (502, 500);
insert into pharmacist values (506, 504);
insert into pharmacist values (511, 501);
insert into pharmacist values (333, 501);
insert into pharmacist values (559, 501);

#sys_admin
insert into sys_admin values (512);


#dermatologists_in_pharmacies
# id dermatologa, id apoteke
insert into dermatologists_in_pharmacies values(501,501);
insert into dermatologists_in_pharmacies values(504,501);
insert into dermatologists_in_pharmacies values(509,503);
insert into dermatologists_in_pharmacies values(533,501);

#pharmacy_admin
insert into pharmacy_admin values(503,501);

#alternative_drug
#id drug,id alternativni drug

insert into alternative_drug values(501,507);
insert into alternative_drug values(502,507);
insert into alternative_drug values(503,506);
insert into alternative_drug values(504,506);
insert into alternative_drug values(505,506);
insert into alternative_drug values(506,502);


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

#drug_reservation
#id,cancelled,datum rez,ispicked -da li je preuzet,pick_up_date -do kog,kolicina,id drug,id pattient,id pharmacy

insert into drug_reservation values(500,false,'2021-04-20',false,false,'2021-06-20',3,503,510,503);
insert into drug_reservation values(501,true,'2021-05-25',false,false,'2021-06-15',3,504,510,501);
insert into drug_reservation values(502,false,'2021-04-20',false,false,'2021-07-20',3,505,508,503);
insert into drug_reservation values(503,false,'2021-05-18',false,true,'2021-07-20',3,506,510,504);
insert into drug_reservation values(504,true,'2021-04-20',false,false,'2021-09-20',3,507,507,502);
insert into drug_reservation values(505,false,'2021-04-20',false,false,'2021-09-20',3,503,510,503);
insert into drug_reservation values(506,true,'2021-05-25',false,false,'2021-06-15',3,504,508,501);
insert into drug_reservation values(507,false,'2021-04-20',false,true,'2021-08-20',3,505,507,503);
insert into drug_reservation values(508,false,'2021-05-18',false,true,'2021-07-20',3,506,508,504);
insert into drug_reservation values(509,false,'2021-04-20',false,false,'2021-06-29',3,507,507,502);
insert into drug_reservation values(510,false,'2021-04-20',false,false,'2021-06-02',3,507,508,502);

#therapy
insert into therapy values(500,504);
insert into therapy values(501,501);
insert into therapy values(502,502);
insert into therapy values(503,503);
insert into therapy values(504,505);
insert into therapy values(505,506);

#work_timelimit
insert into work_time values(500,'2021-07-22','11:00:00','09:30:00',500,502);
insert into work_time values(501,'2021-07-22','11:00:00','09:30:00',504,506);

#examination

#id,date,endtime,isSheduled true znaci zakazan je vec,cijena,report-info o preg,starttime,status,tip,pacijent,idpharm,idstaf,idterapi

insert into examination values(500,false,'2021-06-20','09:00:00',true,600,'info1','08:00:00','CREATED','DERMATOLOGIST_EXAMINATION',null,501,501,500);
insert into examination values(501,false,'2021-07-22','11:00:00',false,880,'info2','09:30:00','CREATED','DERMATOLOGIST_EXAMINATION',null,501,504,504);
insert into examination values(503,false,'2021-07-22','11:00:00',false,880,'info2','09:30:00','CREATED','PHARMACIST_EXAMINATION',null,500,502,504);
insert into examination values(504,false,'2021-07-22','11:00:00',true,880,'info2','09:30:00','CREATED','PHARMACIST_EXAMINATION',null,504,506,502);//--------------------
insert into examination values(505,false,'2021-07-22','11:00:00',true,880,'info2','09:30:00','CREATED','DERMATOLOGIST_EXAMINATION',null,501,501,null);
insert into examination values(506,false,'2021-07-22','11:00:00',false,1000,'info2','09:30:00','CREATED','PHARMACIST_EXAMINATION',null,501,511,501);//--------------------

insert into examination values(502,false,'2021-06-20','2021-06-20 09:00:00',true,600,'info1','2021-06-20 08:00:00','SCHEDULED','DERMATOLOGIST_EXAMINATION',508,501,501,null);
insert into examination values(507,false,'2021-07-23','2021-07-23 11:00:00',true,880,'info2','2021-07-23 09:30:00','SCHEDULED','DERMATOLOGIST_EXAMINATION',508,501,504,null);//--------------------

insert into examination values(508,false,'2021-08-29','11:00:00',false,1030,'info2','09:30:00','CREATED','PHARMACIST_EXAMINATION',null,500,559,null);
insert into examination values(509,false,'2021-08-27','12:00:00',false,1050,'info2','10:30:00','CREATED','PHARMACIST_EXAMINATION',null,501,511,null);

insert into examination values(510,false,'2021-08-29','11:00:00',false,1030,'info2','09:30:00','CREATED','DERMATOLOGIST_EXAMINATION',null,500,501,null);
insert into examination values(511,false,'2021-08-27','12:00:00',false,1050,'info2','10:30:00','CREATED','DERMATOLOGIST_EXAMINATION',null,501,504,null);

insert into examination values(533,false,'2021-04-20','09:00:00',true,6432,'info1','08:00:00','FINISHED','DERMATOLOGIST_EXAMINATION',510,501,501,500);
insert into examination values(534,false,'2021-04-22','11:00:00',true,20943,'info2','09:30:00','FINISHED','DERMATOLOGIST_EXAMINATION',508,501,504,504);
insert into examination values(535,false,'2021-03-22','11:00:00',true,423432,'info2','09:30:00','FINISHED','PHARMACIST_EXAMINATION',508,500,502,504);
insert into examination values(536,false,'2021-01-22','11:00:00',true,233432,'info2','09:30:00','FINISHED','PHARMACIST_EXAMINATION',507,504,506,502);//--------------------
insert into examination values(537,false,'2021-03-21','11:00:00',true,8899,'info2','09:30:00','FINISHED','DERMATOLOGIST_EXAMINATION',508,501,501,501);
insert into examination values(538,false,'2021-03-25','11:00:00',true,10443,'info2','09:30:00','FINISHED','PHARMACIST_EXAMINATION',510,501,511,501);//--------------------

insert into examination values(539,false,'2021-03-20','09:00:00',true,6945,'info1','08:00:00','FINISHED','DERMATOLOGIST_EXAMINATION',510,501,501,505);
insert into examination values(540,false,'2021-01-23','11:00:00',true,8660,'info2','09:30:00','FINISHED','DERMATOLOGIST_EXAMINATION',507,501,504,501);//--------------------

insert into examination values(541,false,'2021-03-29','11:00:00',true,1333,'info2','09:30:00','FINISHED','PHARMACIST_EXAMINATION',508,500,559,500);
insert into examination values(542,false,'2021-04-27','12:00:00',true,1555,'info2','10:30:00','FINISHED','PHARMACIST_EXAMINATION',507,501,511,500);



insert into action_patient_pharmacy values(507,501);
insert into action_patient_pharmacy values(507,503);
insert into action_patient_pharmacy values(507,504);
insert into action_patient_pharmacy values(508,501);
insert into action_patient_pharmacy values(508,504);
insert into action_patient_pharmacy values(510,502);
insert into action_patient_pharmacy values(510,501);
insert into action_patient_pharmacy values(510,500);

insert into erecipe values(500,"12345",'2021-05-24','Ana',"NEW",'Mikic',508,500);//--------------------
insert into erecipe values(501,"12346",'2021-05-22','Ana',"NEW",'Mikic',508,500);//--------------------

insert into erecipe_drug values(500,"sifra 1",'probiotik',7,501);//--------------------
insert into erecipe_drug values(501,"sifra 2",'paracetamol',8,501);//--------------------
insert into erecipe_drug values(502,"sifra 1",'probiotik',9,501);//--------------------
insert into erecipe_drug values(503,"sifra 2",'paracetamol',11,501);//--------------------


insert into erecipe_e_recipe_drug values(500,501);
insert into erecipe_e_recipe_drug values(500,500);
insert into erecipe_e_recipe_drug values(501,502);
insert into erecipe_e_recipe_drug values(501,503);















