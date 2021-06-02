package com.isaProject.isa.Services.Implementations;
import com.isaProject.isa.Model.Drugs.DrugOrder;
import com.isaProject.isa.Model.Drugs.Offer;
import com.isaProject.isa.Model.Users.Patient;
import com.isaProject.isa.Model.Users.RequestForVacation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class ServiceForEmail{


    @Autowired
    private JavaMailSender javaMailSender;


/*
    @Autowired
    public JavaMailSender javaMailSender;

*/




    @Autowired
    private Environment environment;


    //https://docs.spring.io/spring-framework/docs/3.0.0.M3/reference/html/ch26s03.html


    public void sendingAnEmailToAcceptTheOffer (DrugOrder order, Offer offer) throws MessagingException {
        // TODO Auto-generated method stub
        System.out.println("usao u funkc za slanje mejla "+offer.getSupplier().getEmail() );

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        String htmlMsg =
                "<p>Hello, the offer you made for pharmacy: "+ order.getPharmacyAdmin().getPharmacy().getName()+ " is accepted</p>" +
                        "<p>Thank You.We are looking forward to future business</p>";
        helper.setText(htmlMsg, true);
        helper.setTo(offer.getSupplier().getEmail());
        helper.setSubject("Rejected absence");
        helper.setFrom(environment.getProperty("spring.mail.username"));
        javaMailSender.send(mimeMessage);
        System.out.println("kraj funkc!");
    }


    public void sendingAnEmailToRejectTheOffer (DrugOrder order, Offer offer) throws MessagingException {
        // TODO Auto-generated method stub
        System.out.println("usao u funkc za slanje mejla "+offer.getSupplier().getEmail() );

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        String htmlMsg =
                "<p>Hello, the offer you made for pharmacy: "+ order.getPharmacyAdmin().getPharmacy().getName()+ " is rejected </p>";

        helper.setText(htmlMsg, true);
        helper.setTo(offer.getSupplier().getEmail());
        helper.setSubject("Rejected absence");
        helper.setFrom(environment.getProperty("spring.mail.username"));
        javaMailSender.send(mimeMessage);
        System.out.println("kraj funkc!");
    }


    public void sendingEmailsForActionAndPromotions (Patient patient,String pharmacyName,String text) throws MessagingException {
        // TODO Auto-generated method stub


        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        String htmlMsg =
                "<p>Hello,pharmacy "+pharmacyName+"has new action:"+text+"</p>";

        helper.setText(htmlMsg, true);
        helper.setTo(patient.getEmail());
        helper.setSubject("Rejected absence");///////////////////////ovo promijeni
        helper.setFrom(environment.getProperty("spring.mail.username"));
        javaMailSender.send(mimeMessage);
        System.out.println("kraj funkc!");
    }


    public void sendingEmailToAcceptRequestForVacation (RequestForVacation requestForVacation) throws MessagingException {
        // TODO Auto-generated method stub


        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        String htmlMsg =
                "<p>Hello "+requestForVacation.getStaff().getName() +", Your request for vacation is accept.</p>";

        helper.setText(htmlMsg, true);
        helper.setTo(requestForVacation.getStaff().getEmail());
        helper.setSubject("Rejected absence");///////////////////////ovo promijeni
        helper.setFrom(environment.getProperty("spring.mail.username"));
        javaMailSender.send(mimeMessage);
        System.out.println("kraj funkc!");
    }

    public void sendingEmailToRejectRequestForVacation (RequestForVacation requestForVacation,String text) throws MessagingException {
        // TODO Auto-generated method stub


        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        String htmlMsg =
                "<p>Hello "+requestForVacation.getStaff().getName() +", Your request for vacation is reject because "+text+" .</p>";

        helper.setText(htmlMsg, true);
        helper.setTo(requestForVacation.getStaff().getEmail());
        helper.setSubject("Rejected absence");///////////////////////ovo promijeni
        helper.setFrom(environment.getProperty("spring.mail.username"));
        javaMailSender.send(mimeMessage);
        System.out.println("kraj funkc!");
    }





    /*



    	<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-mail</artifactId>
		</dependency>



		spring.mail.host = smtp.gmail.com
spring.mail.username = kristinamucibabic321@gmail.com
spring.mail.password =
spring.mail.port=587
spring.mail.properties.mail.smtp.starttls.enable = true
spring.mail.properties.mail.smtp.starttls.required=true
spring.mail.properties.mail.smtp.auth=true



     */

/*

    @Autowired
    private Environment environment;
*/





    //https://docs.spring.io/spring-framework/docs/3.0.0.M3/reference/html/ch26s03.html
}
