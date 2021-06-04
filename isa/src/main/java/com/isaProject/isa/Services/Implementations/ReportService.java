package com.isaProject.isa.Services.Implementations;


import com.isaProject.isa.Model.DTO.AnnualReportDTO;
import com.isaProject.isa.Model.DTO.ExaminationQuarterDTO;
import com.isaProject.isa.Model.DTO.MonthlyReportForExaminationDTO;
import com.isaProject.isa.Model.Examination.Examination;
import com.isaProject.isa.Model.Examination.ExaminationStatus;
import com.isaProject.isa.Model.Users.PharmacyAdmin;
import com.isaProject.isa.Repositories.ExaminationRepository;
import com.isaProject.isa.Repositories.PharmacyAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Component
public class ReportService {

    //mjesecni izvjestaj

    @Autowired
    ExaminationRepository examinationRepository;

    @Autowired
    PharmacyAdminRepository pharmacyAdminRepository;


    //graficki prikaz







    public ExaminationQuarterDTO examinationQuarter(Integer idAdmina,Integer year){
        List<MonthlyReportForExaminationDTO>jan=monthlyReport2(idAdmina,1,year);
        int januar=0;
        for (MonthlyReportForExaminationDTO m:jan){
            januar+=m.getNumberOfExamination();

        }


        List<MonthlyReportForExaminationDTO>feb=monthlyReport2(idAdmina,2,year);
        int februar=0;
        for (MonthlyReportForExaminationDTO m:feb){
            februar+=m.getNumberOfExamination();

        }


        List<MonthlyReportForExaminationDTO>mar=monthlyReport2(idAdmina,3,year);
        int mart=0;
        for (MonthlyReportForExaminationDTO m:mar){
            mart+=m.getNumberOfExamination();

        }


        List<MonthlyReportForExaminationDTO>apr=monthlyReport2(idAdmina,4,year);
        int april=0;
        for (MonthlyReportForExaminationDTO m:apr){
            april+=m.getNumberOfExamination();

        }

        List<MonthlyReportForExaminationDTO>maj=monthlyReport2(idAdmina,5,year);
        int majj=0;
        for (MonthlyReportForExaminationDTO m:maj){
            majj+=m.getNumberOfExamination();

        }

        List<MonthlyReportForExaminationDTO>jun=monthlyReport2(idAdmina,6,year);
        int junn=0;
        for (MonthlyReportForExaminationDTO m:jun){
            junn+=m.getNumberOfExamination();

        }


        List<MonthlyReportForExaminationDTO>jul=monthlyReport2(idAdmina,7,year);
        int jull=0;
        for (MonthlyReportForExaminationDTO m:jul){
            jull+=m.getNumberOfExamination();

        }


        List<MonthlyReportForExaminationDTO>aug=monthlyReport2(idAdmina,8,year);
        int augg=0;
        for (MonthlyReportForExaminationDTO m:aug){
            System.out.println("Aaaaaaaaaaa "+ m.getNumberOfExamination());
            System.out.println("Daaan je   "+m.getDay());
            augg+=m.getNumberOfExamination();

        }



        List<MonthlyReportForExaminationDTO>sep=monthlyReport2(idAdmina,9,year);
        int sepp=0;
        for (MonthlyReportForExaminationDTO m:sep){
            sepp+=m.getNumberOfExamination();

        }


        List<MonthlyReportForExaminationDTO>oct=monthlyReport2(idAdmina,10,year);
        int octt=0;
        for (MonthlyReportForExaminationDTO m:oct){
            octt+=m.getNumberOfExamination();

        }


        List<MonthlyReportForExaminationDTO>nov=monthlyReport2(idAdmina,11,year);
        int novv=0;
        for (MonthlyReportForExaminationDTO m:nov){
            novv+=m.getNumberOfExamination();

        }



        List<MonthlyReportForExaminationDTO>dec=monthlyReport2(idAdmina,12,year);
        int decc=0;
        for (MonthlyReportForExaminationDTO m:oct){
            decc+=m.getNumberOfExamination();

        }


        int first=0;
        int second=0;
        int third=0;
        first=januar+februar+mart+april;
        second=majj+junn+jull+augg;
        third=sepp+octt+novv+decc;

        ExaminationQuarterDTO examinationQuarterDTO=new ExaminationQuarterDTO(first,second,third);

        return examinationQuarterDTO;


    }





















    public AnnualReportDTO annualReportDTO(Integer idAdmina,Integer year){
        AnnualReportDTO annualReportDTO =new AnnualReportDTO();
        List<MonthlyReportForExaminationDTO>jan=monthlyReport2(idAdmina,1,year);
        int januar=0;
        for (MonthlyReportForExaminationDTO m:jan){
            januar+=m.getNumberOfExamination();

        }
        annualReportDTO.setJan(januar);


        List<MonthlyReportForExaminationDTO>feb=monthlyReport2(idAdmina,2,year);
        int februar=0;
        for (MonthlyReportForExaminationDTO m:feb){
            februar+=m.getNumberOfExamination();

        }
        annualReportDTO.setFeb(februar);


        List<MonthlyReportForExaminationDTO>mar=monthlyReport2(idAdmina,3,year);
        int mart=0;
        for (MonthlyReportForExaminationDTO m:mar){
            mart+=m.getNumberOfExamination();

        }
        annualReportDTO.setMart(mart);


        List<MonthlyReportForExaminationDTO>apr=monthlyReport2(idAdmina,4,year);
        int april=0;
        for (MonthlyReportForExaminationDTO m:apr){
            april+=m.getNumberOfExamination();

        }
        annualReportDTO.setApr(april);

        List<MonthlyReportForExaminationDTO>maj=monthlyReport2(idAdmina,5,year);
        int majj=0;
        for (MonthlyReportForExaminationDTO m:maj){
            majj+=m.getNumberOfExamination();

        }
        annualReportDTO.setMaj(majj);

        List<MonthlyReportForExaminationDTO>jun=monthlyReport2(idAdmina,6,year);
        int junn=0;
        for (MonthlyReportForExaminationDTO m:jun){
            junn+=m.getNumberOfExamination();

        }
        annualReportDTO.setJun(junn);


        List<MonthlyReportForExaminationDTO>jul=monthlyReport2(idAdmina,7,year);
        int jull=0;
        for (MonthlyReportForExaminationDTO m:jul){
            jull+=m.getNumberOfExamination();

        }
        annualReportDTO.setJul(jull);


        List<MonthlyReportForExaminationDTO>aug=monthlyReport2(idAdmina,8,year);
        int augg=0;
        for (MonthlyReportForExaminationDTO m:aug){
            System.out.println("Aaaaaaaaaaa "+ m.getNumberOfExamination());
            System.out.println("Daaan je   "+m.getDay());
            augg+=m.getNumberOfExamination();

        }
        annualReportDTO.setAvg(augg);



        List<MonthlyReportForExaminationDTO>sep=monthlyReport2(idAdmina,9,year);
        int sepp=0;
        for (MonthlyReportForExaminationDTO m:sep){
            sepp+=m.getNumberOfExamination();

        }
        annualReportDTO.setSep(sepp);


        List<MonthlyReportForExaminationDTO>oct=monthlyReport2(idAdmina,10,year);
        int octt=0;
        for (MonthlyReportForExaminationDTO m:oct){
            octt+=m.getNumberOfExamination();

        }
        annualReportDTO.setOkt(octt);

        List<MonthlyReportForExaminationDTO>nov=monthlyReport2(idAdmina,11,year);
        int novv=0;
        for (MonthlyReportForExaminationDTO m:nov){
            novv+=m.getNumberOfExamination();

        }
        annualReportDTO.setNov(novv);


        List<MonthlyReportForExaminationDTO>dec=monthlyReport2(idAdmina,12,year);
        int decc=0;
        for (MonthlyReportForExaminationDTO m:oct){
            decc+=m.getNumberOfExamination();

        }
        annualReportDTO.setDec(decc);

        return annualReportDTO;


    }



    public List<MonthlyReportForExaminationDTO> monthlyReport(Integer idAdmina, Integer month){

        LocalDate localDate=LocalDate.now();
        PharmacyAdmin pharmacyAdmin=pharmacyAdminRepository.findOneById(idAdmina);
       // Month month1=(Month) month;
        List<Examination>listaa=examinationRepository.findExaminationsByIdPharm(pharmacyAdmin.getPharmacy().getIdPharm());

        List<Examination>lista=new ArrayList<>();
        for (Examination ex:listaa){
            if (ex.getStatus().equals(ExaminationStatus.SCHEDULED)){
                lista.add(ex);

            }
        }


        LocalDate startCount=LocalDate.of(localDate.getYear(),month,1);
        int numberOfDays=startCount.getDayOfMonth();
        MonthlyReportForExaminationDTO dto=new MonthlyReportForExaminationDTO();
        int numberOfExaminationForDay1=0;
        int numberOfExaminationForDay2=0;
        int numberOfExaminationForDay3=0;
        int numberOfExaminationForDay4=0;
        int numberOfExaminationForDay5=0;
        int numberOfExaminationForDay6=0;
        int numberOfExaminationForDay7=0;
        int numberOfExaminationForDay8=0;
        int numberOfExaminationForDay9=0;
        int numberOfExaminationForDay10=0;
        int numberOfExaminationForDay11=0;
        int numberOfExaminationForDay12=0;
        int numberOfExaminationForDay13=0;
        int numberOfExaminationForDay14=0;
        int numberOfExaminationForDay15=0;
        int numberOfExaminationForDay16=0;
        int numberOfExaminationForDay17=0;
        int numberOfExaminationForDay18=0;
        int numberOfExaminationForDay19=0;
        int numberOfExaminationForDay20=0;
        int numberOfExaminationForDay21=0;
        int numberOfExaminationForDay22=0;
        int numberOfExaminationForDay23=0;
        int numberOfExaminationForDay24=0;
        int numberOfExaminationForDay25=0;
        int numberOfExaminationForDay26=0;
        int numberOfExaminationForDay27=0;
        int numberOfExaminationForDay28=0;
        int numberOfExaminationForDay29=0;
        int numberOfExaminationForDay30=0;
        int numberOfExaminationForDay31=0;

        String day1="1";
        String day2="2";
        String day3="3";
        String day4="4";
        String day5="5";
        String day6="6";
        String day7="7";
        String day8="8";
        String day9="9";
        String day10="10";
        String day11="11";
        String day12="12";
        String day13="13";
        String day14="14";
        String day15="15";
        String day16="16";
        String day17="17";
        String day18="18";
        String day19="19";
        String day20="20";
        String day21="21";
        String day22="22";
        String day23="23";
        String day24="24";
        String day25="25";
        String day26="26";
        String day27="27";
        String day28="28";
        String day29="29";
        String day30="30";
        String day31="31";




        System.out.println("Broj dana u mjesecu je ");

            for (Examination e:lista){
                if(e.getDate().getMonthValue()==month){
                    if (e.getDate().getDayOfMonth()==1){
                        numberOfExaminationForDay1+=1;

                    }
                    if (e.getDate().getDayOfMonth()==2){
                        numberOfExaminationForDay2+=1;

                    }
                    if (e.getDate().getDayOfMonth()==3){
                        numberOfExaminationForDay3+=1;

                    }
                    if (e.getDate().getDayOfMonth()==4){
                        numberOfExaminationForDay4+=1;

                    }
                    if (e.getDate().getDayOfMonth()==5){
                        numberOfExaminationForDay5+=1;

                    }
                    if (e.getDate().getDayOfMonth()==6){
                        numberOfExaminationForDay6+=1;

                    }
                    if (e.getDate().getDayOfMonth()==7){
                        numberOfExaminationForDay7+=1;

                    }
                    if (e.getDate().getDayOfMonth()==8){
                        numberOfExaminationForDay8+=1;

                    }
                    if (e.getDate().getDayOfMonth()==9){
                        numberOfExaminationForDay9+=1;

                    }
                    if (e.getDate().getDayOfMonth()==10){
                        numberOfExaminationForDay10+=1;

                    }
                    if (e.getDate().getDayOfMonth()==11){
                        numberOfExaminationForDay11+=1;

                    }
                    if (e.getDate().getDayOfMonth()==12){
                        numberOfExaminationForDay12+=1;

                    }
                    if (e.getDate().getDayOfMonth()==13){
                        numberOfExaminationForDay13+=1;

                    }
                    if (e.getDate().getDayOfMonth()==14){
                        numberOfExaminationForDay14+=1;

                    }
                    if (e.getDate().getDayOfMonth()==15){
                        numberOfExaminationForDay15+=1;

                    }
                    if (e.getDate().getDayOfMonth()==16){
                        numberOfExaminationForDay16+=1;

                    }
                    if (e.getDate().getDayOfMonth()==17){
                        numberOfExaminationForDay17+=1;

                    }
                    if (e.getDate().getDayOfMonth()==18){
                        numberOfExaminationForDay18+=1;

                    }
                    if (e.getDate().getDayOfMonth()==19){
                        numberOfExaminationForDay19+=1;

                    }
                    if (e.getDate().getDayOfMonth()==20){
                        numberOfExaminationForDay20+=1;

                    }
                    if (e.getDate().getDayOfMonth()==21){
                        numberOfExaminationForDay21+=1;

                    }
                    if (e.getDate().getDayOfMonth()==22){
                        numberOfExaminationForDay22+=1;

                    }
                    if (e.getDate().getDayOfMonth()==23){
                        numberOfExaminationForDay23+=1;

                    }
                    if (e.getDate().getDayOfMonth()==24){
                        numberOfExaminationForDay24+=1;

                    }
                    if (e.getDate().getDayOfMonth()==25){
                        numberOfExaminationForDay25+=1;

                    }
                    if (e.getDate().getDayOfMonth()==26){
                        numberOfExaminationForDay26+=25;

                    }
                    if (e.getDate().getDayOfMonth()==27){
                        numberOfExaminationForDay27+=25;

                    }
                    if (e.getDate().getDayOfMonth()==28){
                        numberOfExaminationForDay28+=25;

                    }
                    if (e.getDate().getDayOfMonth()==29){
                        numberOfExaminationForDay29+=25;

                    }
                    if (e.getDate().getDayOfMonth()==30){
                        numberOfExaminationForDay30+=25;

                    }
                    if (e.getDate().getDayOfMonth()==31){
                        numberOfExaminationForDay31+=25;

                    }



                }
            }
            List<MonthlyReportForExaminationDTO>dtoList=new ArrayList<>();
            MonthlyReportForExaminationDTO dto1=new MonthlyReportForExaminationDTO(day1,numberOfExaminationForDay1);
            MonthlyReportForExaminationDTO dto2=new MonthlyReportForExaminationDTO(day2,numberOfExaminationForDay2);
            MonthlyReportForExaminationDTO dto3=new MonthlyReportForExaminationDTO(day3,numberOfExaminationForDay3);
            MonthlyReportForExaminationDTO dto4=new MonthlyReportForExaminationDTO(day4,numberOfExaminationForDay4);
            MonthlyReportForExaminationDTO dto5=new MonthlyReportForExaminationDTO(day5,numberOfExaminationForDay5);
            MonthlyReportForExaminationDTO dto6=new MonthlyReportForExaminationDTO(day6,numberOfExaminationForDay6);
            MonthlyReportForExaminationDTO dto7=new MonthlyReportForExaminationDTO(day7,numberOfExaminationForDay7);
           MonthlyReportForExaminationDTO dto8=new MonthlyReportForExaminationDTO(day8,numberOfExaminationForDay8);
            MonthlyReportForExaminationDTO dto9=new MonthlyReportForExaminationDTO(day9,numberOfExaminationForDay9);
            MonthlyReportForExaminationDTO dto10=new MonthlyReportForExaminationDTO(day10,numberOfExaminationForDay10);
           MonthlyReportForExaminationDTO dto11=new MonthlyReportForExaminationDTO(day11,numberOfExaminationForDay11);
           MonthlyReportForExaminationDTO dto12=new MonthlyReportForExaminationDTO(day12,numberOfExaminationForDay12);
           MonthlyReportForExaminationDTO dto13=new MonthlyReportForExaminationDTO(day13,numberOfExaminationForDay13);
           MonthlyReportForExaminationDTO dto14=new MonthlyReportForExaminationDTO(day14,numberOfExaminationForDay14);
           MonthlyReportForExaminationDTO dto15=new MonthlyReportForExaminationDTO(day15,numberOfExaminationForDay15);
           MonthlyReportForExaminationDTO dto16=new MonthlyReportForExaminationDTO(day16,numberOfExaminationForDay16);
           MonthlyReportForExaminationDTO dto17=new MonthlyReportForExaminationDTO(day17,numberOfExaminationForDay17);
          MonthlyReportForExaminationDTO dto18=new MonthlyReportForExaminationDTO(day18,numberOfExaminationForDay18);
        MonthlyReportForExaminationDTO dto19=new MonthlyReportForExaminationDTO(day19,numberOfExaminationForDay19);
        MonthlyReportForExaminationDTO dto20=new MonthlyReportForExaminationDTO(day20,numberOfExaminationForDay20);
        MonthlyReportForExaminationDTO dto21=new MonthlyReportForExaminationDTO(day21,numberOfExaminationForDay21);
        MonthlyReportForExaminationDTO dto22=new MonthlyReportForExaminationDTO(day22,numberOfExaminationForDay22);
        MonthlyReportForExaminationDTO dto23=new MonthlyReportForExaminationDTO(day23,numberOfExaminationForDay23);
        MonthlyReportForExaminationDTO dto24=new MonthlyReportForExaminationDTO(day24,numberOfExaminationForDay24);
        MonthlyReportForExaminationDTO dto25=new MonthlyReportForExaminationDTO(day25,numberOfExaminationForDay25);
        MonthlyReportForExaminationDTO dto26=new MonthlyReportForExaminationDTO(day26,numberOfExaminationForDay26);
        MonthlyReportForExaminationDTO dto27=new MonthlyReportForExaminationDTO(day27,numberOfExaminationForDay27);
        MonthlyReportForExaminationDTO dto28=new MonthlyReportForExaminationDTO(day28,numberOfExaminationForDay28);
        MonthlyReportForExaminationDTO dto29=new MonthlyReportForExaminationDTO(day29,numberOfExaminationForDay29);
        MonthlyReportForExaminationDTO dto30=new MonthlyReportForExaminationDTO(day30,numberOfExaminationForDay30);
        MonthlyReportForExaminationDTO dto31=new MonthlyReportForExaminationDTO(day31,numberOfExaminationForDay31);

        dtoList.add(dto1);
        dtoList.add(dto2);
        dtoList.add(dto3);
        dtoList.add(dto4);
        dtoList.add(dto5);
        dtoList.add(dto6);
        dtoList.add(dto7);
        dtoList.add(dto8);
        dtoList.add(dto9);
        dtoList.add(dto10);
        dtoList.add(dto11);
        dtoList.add(dto12);
        dtoList.add(dto13);
        dtoList.add(dto14);
        dtoList.add(dto15);
        dtoList.add(dto16);
        dtoList.add(dto17);
        dtoList.add(dto18);
        dtoList.add(dto19);
        dtoList.add(dto20);
        dtoList.add(dto21);
        dtoList.add(dto22);
        dtoList.add(dto23);
        dtoList.add(dto24);
        dtoList.add(dto25);
        dtoList.add(dto26);
        dtoList.add(dto27);
        dtoList.add(dto28);
        dtoList.add(dto29);
        dtoList.add(dto30);
        dtoList.add(dto31);

        return dtoList;








    }










    public List<MonthlyReportForExaminationDTO> monthlyReport2(Integer idAdmina, Integer month,Integer year){

        LocalDate localDate=LocalDate.now();
        PharmacyAdmin pharmacyAdmin=pharmacyAdminRepository.findOneById(idAdmina);
        // Month month1=(Month) month;
        List<Examination>listaa=examinationRepository.findExaminationsByIdPharm(pharmacyAdmin.getPharmacy().getIdPharm());

        List<Examination>lista=new ArrayList<>();
        for (Examination ex:listaa){
            if (ex.getStatus().equals(ExaminationStatus.SCHEDULED)){
                lista.add(ex);

            }
        }
        LocalDate startCount=LocalDate.of(localDate.getYear(),month,1);
        int numberOfDays=startCount.getDayOfMonth();
        MonthlyReportForExaminationDTO dto=new MonthlyReportForExaminationDTO();
        int numberOfExaminationForDay1=0;
        int numberOfExaminationForDay2=0;
        int numberOfExaminationForDay3=0;
        int numberOfExaminationForDay4=0;
        int numberOfExaminationForDay5=0;
        int numberOfExaminationForDay6=0;
        int numberOfExaminationForDay7=0;
        int numberOfExaminationForDay8=0;
        int numberOfExaminationForDay9=0;
        int numberOfExaminationForDay10=0;
        int numberOfExaminationForDay11=0;
        int numberOfExaminationForDay12=0;
        int numberOfExaminationForDay13=0;
        int numberOfExaminationForDay14=0;
        int numberOfExaminationForDay15=0;
        int numberOfExaminationForDay16=0;
        int numberOfExaminationForDay17=0;
        int numberOfExaminationForDay18=0;
        int numberOfExaminationForDay19=0;
        int numberOfExaminationForDay20=0;
        int numberOfExaminationForDay21=0;
        int numberOfExaminationForDay22=0;
        int numberOfExaminationForDay23=0;
        int numberOfExaminationForDay24=0;
        int numberOfExaminationForDay25=0;
        int numberOfExaminationForDay26=0;
        int numberOfExaminationForDay27=0;
        int numberOfExaminationForDay28=0;
        int numberOfExaminationForDay29=0;
        int numberOfExaminationForDay30=0;
        int numberOfExaminationForDay31=0;

        String day1="1";
        String day2="2";
        String day3="3";
        String day4="4";
        String day5="5";
        String day6="6";
        String day7="7";
        String day8="8";
        String day9="9";
        String day10="10";
        String day11="11";
        String day12="12";
        String day13="13";
        String day14="14";
        String day15="15";
        String day16="16";
        String day17="17";
        String day18="18";
        String day19="19";
        String day20="20";
        String day21="21";
        String day22="22";
        String day23="23";
        String day24="24";
        String day25="25";
        String day26="26";
        String day27="27";
        String day28="28";
        String day29="29";
        String day30="30";
        String day31="31";




        System.out.println("Broj dana u mjesecu je ");

        for (Examination e:lista){
            if(e.getDate().getMonthValue()==month ){
                if (e.getDate().getDayOfMonth()==1 && e.getDate().getYear()==year){
                    numberOfExaminationForDay1+=1;

                }
                if (e.getDate().getDayOfMonth()==2 && e.getDate().getYear()==year){
                    numberOfExaminationForDay2+=1;

                }
                if (e.getDate().getDayOfMonth()==3 && e.getDate().getYear()==year){
                    numberOfExaminationForDay3+=1;

                }
                if (e.getDate().getDayOfMonth()==4 && e.getDate().getYear()==year){
                    numberOfExaminationForDay4+=1;

                }
                if (e.getDate().getDayOfMonth()==5 && e.getDate().getYear()==year){
                    numberOfExaminationForDay5+=1;

                }
                if (e.getDate().getDayOfMonth()==6 && e.getDate().getYear()==year){
                    numberOfExaminationForDay6+=1;

                }
                if (e.getDate().getDayOfMonth()==7 && e.getDate().getYear()==year){
                    numberOfExaminationForDay7+=1;

                }
                if (e.getDate().getDayOfMonth()==8 && e.getDate().getYear()==year){
                    numberOfExaminationForDay8+=1;

                }
                if (e.getDate().getDayOfMonth()==9 && e.getDate().getYear()==year){
                    numberOfExaminationForDay9+=1;

                }
                if (e.getDate().getDayOfMonth()==10 && e.getDate().getYear()==year){
                    numberOfExaminationForDay10+=1;

                }
                if (e.getDate().getDayOfMonth()==11 && e.getDate().getYear()==year){
                    numberOfExaminationForDay11+=1;

                }
                if (e.getDate().getDayOfMonth()==12 && e.getDate().getYear()==year){
                    numberOfExaminationForDay12+=1;

                }
                if (e.getDate().getDayOfMonth()==13 && e.getDate().getYear()==year){
                    numberOfExaminationForDay13+=1;

                }
                if (e.getDate().getDayOfMonth()==14 && e.getDate().getYear()==year){
                    numberOfExaminationForDay14+=1;

                }
                if (e.getDate().getDayOfMonth()==15 && e.getDate().getYear()==year){
                    numberOfExaminationForDay15+=1;

                }
                if (e.getDate().getDayOfMonth()==16 && e.getDate().getYear()==year){
                    numberOfExaminationForDay16+=1;

                }
                if (e.getDate().getDayOfMonth()==17 && e.getDate().getYear()==year){
                    numberOfExaminationForDay17+=1;

                }
                if (e.getDate().getDayOfMonth()==18 && e.getDate().getYear()==year){
                    numberOfExaminationForDay18+=1;

                }
                if (e.getDate().getDayOfMonth()==19 && e.getDate().getYear()==year){
                    numberOfExaminationForDay19+=1;

                }
                if (e.getDate().getDayOfMonth()==20 && e.getDate().getYear()==year){
                    numberOfExaminationForDay20+=1;

                }
                if (e.getDate().getDayOfMonth()==21 && e.getDate().getYear()==year){
                    numberOfExaminationForDay21+=1;

                }
                if (e.getDate().getDayOfMonth()==22 && e.getDate().getYear()==year){
                    numberOfExaminationForDay22+=1;

                }
                if (e.getDate().getDayOfMonth()==23 && e.getDate().getYear()==year){
                    numberOfExaminationForDay23+=1;

                }
                if (e.getDate().getDayOfMonth()==24 && e.getDate().getYear()==year){
                    numberOfExaminationForDay24+=1;

                }
                if (e.getDate().getDayOfMonth()==25 && e.getDate().getYear()==year){
                    numberOfExaminationForDay25+=1;

                }
                if (e.getDate().getDayOfMonth()==26 && e.getDate().getYear()==year){
                    numberOfExaminationForDay26+=25;

                }
                if (e.getDate().getDayOfMonth()==27 && e.getDate().getYear()==year){
                    numberOfExaminationForDay27+=25;

                }
                if (e.getDate().getDayOfMonth()==28 && e.getDate().getYear()==year){
                    numberOfExaminationForDay28+=25;

                }
                if (e.getDate().getDayOfMonth()==29 && e.getDate().getYear()==year){
                    numberOfExaminationForDay29+=25;

                }
                if (e.getDate().getDayOfMonth()==30 && e.getDate().getYear()==year){
                    numberOfExaminationForDay30+=25;

                }
                if (e.getDate().getDayOfMonth()==31 && e.getDate().getYear()==year){
                    numberOfExaminationForDay31+=25;

                }



            }
        }
        List<MonthlyReportForExaminationDTO>dtoList=new ArrayList<>();
        MonthlyReportForExaminationDTO dto1=new MonthlyReportForExaminationDTO(day1,numberOfExaminationForDay1);
        MonthlyReportForExaminationDTO dto2=new MonthlyReportForExaminationDTO(day2,numberOfExaminationForDay2);
        MonthlyReportForExaminationDTO dto3=new MonthlyReportForExaminationDTO(day3,numberOfExaminationForDay3);
        MonthlyReportForExaminationDTO dto4=new MonthlyReportForExaminationDTO(day4,numberOfExaminationForDay4);
        MonthlyReportForExaminationDTO dto5=new MonthlyReportForExaminationDTO(day5,numberOfExaminationForDay5);
        MonthlyReportForExaminationDTO dto6=new MonthlyReportForExaminationDTO(day6,numberOfExaminationForDay6);
        MonthlyReportForExaminationDTO dto7=new MonthlyReportForExaminationDTO(day7,numberOfExaminationForDay7);
        MonthlyReportForExaminationDTO dto8=new MonthlyReportForExaminationDTO(day8,numberOfExaminationForDay8);
        MonthlyReportForExaminationDTO dto9=new MonthlyReportForExaminationDTO(day9,numberOfExaminationForDay9);
        MonthlyReportForExaminationDTO dto10=new MonthlyReportForExaminationDTO(day10,numberOfExaminationForDay10);
        MonthlyReportForExaminationDTO dto11=new MonthlyReportForExaminationDTO(day11,numberOfExaminationForDay11);
        MonthlyReportForExaminationDTO dto12=new MonthlyReportForExaminationDTO(day12,numberOfExaminationForDay12);
        MonthlyReportForExaminationDTO dto13=new MonthlyReportForExaminationDTO(day13,numberOfExaminationForDay13);
        MonthlyReportForExaminationDTO dto14=new MonthlyReportForExaminationDTO(day14,numberOfExaminationForDay14);
        MonthlyReportForExaminationDTO dto15=new MonthlyReportForExaminationDTO(day15,numberOfExaminationForDay15);
        MonthlyReportForExaminationDTO dto16=new MonthlyReportForExaminationDTO(day16,numberOfExaminationForDay16);
        MonthlyReportForExaminationDTO dto17=new MonthlyReportForExaminationDTO(day17,numberOfExaminationForDay17);
        MonthlyReportForExaminationDTO dto18=new MonthlyReportForExaminationDTO(day18,numberOfExaminationForDay18);
        MonthlyReportForExaminationDTO dto19=new MonthlyReportForExaminationDTO(day19,numberOfExaminationForDay19);
        MonthlyReportForExaminationDTO dto20=new MonthlyReportForExaminationDTO(day20,numberOfExaminationForDay20);
        MonthlyReportForExaminationDTO dto21=new MonthlyReportForExaminationDTO(day21,numberOfExaminationForDay21);
        MonthlyReportForExaminationDTO dto22=new MonthlyReportForExaminationDTO(day22,numberOfExaminationForDay22);
        MonthlyReportForExaminationDTO dto23=new MonthlyReportForExaminationDTO(day23,numberOfExaminationForDay23);
        MonthlyReportForExaminationDTO dto24=new MonthlyReportForExaminationDTO(day24,numberOfExaminationForDay24);
        MonthlyReportForExaminationDTO dto25=new MonthlyReportForExaminationDTO(day25,numberOfExaminationForDay25);
        MonthlyReportForExaminationDTO dto26=new MonthlyReportForExaminationDTO(day26,numberOfExaminationForDay26);
        MonthlyReportForExaminationDTO dto27=new MonthlyReportForExaminationDTO(day27,numberOfExaminationForDay27);
        MonthlyReportForExaminationDTO dto28=new MonthlyReportForExaminationDTO(day28,numberOfExaminationForDay28);
        MonthlyReportForExaminationDTO dto29=new MonthlyReportForExaminationDTO(day29,numberOfExaminationForDay29);
        MonthlyReportForExaminationDTO dto30=new MonthlyReportForExaminationDTO(day30,numberOfExaminationForDay30);
        MonthlyReportForExaminationDTO dto31=new MonthlyReportForExaminationDTO(day31,numberOfExaminationForDay31);

        dtoList.add(dto1);
        dtoList.add(dto2);
        dtoList.add(dto3);
        dtoList.add(dto4);
        dtoList.add(dto5);
        dtoList.add(dto6);
        dtoList.add(dto7);
        dtoList.add(dto8);
        dtoList.add(dto9);
        dtoList.add(dto10);
        dtoList.add(dto11);
        dtoList.add(dto12);
        dtoList.add(dto13);
        dtoList.add(dto14);
        dtoList.add(dto15);
        dtoList.add(dto16);
        dtoList.add(dto17);
        dtoList.add(dto18);
        dtoList.add(dto19);
        dtoList.add(dto20);
        dtoList.add(dto21);
        dtoList.add(dto22);
        dtoList.add(dto23);
        dtoList.add(dto24);
        dtoList.add(dto25);
        dtoList.add(dto26);
        dtoList.add(dto27);
        dtoList.add(dto28);
        dtoList.add(dto29);
        dtoList.add(dto30);
        dtoList.add(dto31);

        return dtoList;








    }

    






}
