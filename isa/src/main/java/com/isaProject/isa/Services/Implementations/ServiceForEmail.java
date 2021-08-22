package com.isaProject.isa.Services.Implementations;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.isaProject.isa.Model.DTO.ExaminationDTO;
import com.isaProject.isa.Model.Drugs.DrugOrder;
import com.isaProject.isa.Model.Drugs.ERecipe;
import com.isaProject.isa.Model.Drugs.ERecipeDrug;
import com.isaProject.isa.Model.Drugs.Offer;
import com.isaProject.isa.Model.Examination.Examination;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Patient;

import com.isaProject.isa.Model.Users.RequestForVacation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.imageio.ImageIO;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.util.ByteArrayDataSource;
import javax.swing.text.Document;
import java.awt.*;
import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Component
public class ServiceForEmail{
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private PatientService patientService;

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


    public void sendingMailToPatientForExamination(Examination ex,Patient patient) throws MessagingException {
        // TODO Auto-generated method stub
        System.out.println("usao u funkc za slanje mejla "+patient.getEmail());

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        String htmlMsg =
                "<p>You have successfully scheduled an examination!" +
                        ex.getDate()+" "+ex.getStartTime()+"-"+ex.getEndTime()+"</p>";

        helper.setText(htmlMsg, true);
        helper.setTo(patient.getEmail());
        helper.setSubject("Schedule examination");
        helper.setFrom(environment.getProperty("spring.mail.username"));
        javaMailSender.send(mimeMessage);
        System.out.println("kraj funkc!");
    }

    public void sendingMailToPatientForReservattion(Integer idReservation,Patient patient) throws MessagingException {
        // TODO Auto-generated method stub
        System.out.println("usao u funkc za slanje mejla "+patient.getEmail());

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        String htmlMsg =
                "<p>You have successfully reserve an drug!" +"Unique number of Reservation:"
                        +idReservation+"</p>";

        helper.setText(htmlMsg, true);
        helper.setTo(patient.getEmail());
        helper.setSubject("Reserve drug");
        helper.setFrom(environment.getProperty("spring.mail.username"));
        javaMailSender.send(mimeMessage);
        System.out.println("kraj funkc!");
    }
/*
    public void sendEmailForPasswordChange(String email, String password) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        String htmlMsg =
                "<p><b> Welcome! " + email  + " </b> You are the one of admin of the pharmacy system.</p><br>"
                        + " <p>Your password for login: " + password + "."
                        + "<p>Please login to page: </p>"
                        + "<a> http://localhost:3000/login </a>";

        helper.setText(htmlMsg, true);
        helper.setTo(email);
        helper.setSubject("M-PHARMACY ADMIN");
        helper.setFrom(environment.getProperty("spring.mail.username"));
        javaMailSender.send(mimeMessage);
        System.out.println("kraj funkc!");


    }

*/


    public void sendingAnEmailToInformPatientAboutExamination (ExaminationDTO examinationDTO) throws MessagingException {

       // System.out.println("usao u funkc za slanje mejla "+offer.getSupplier().getEmail() );
        Patient patient=patientService.findById(examinationDTO.getIdPatient());

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        String htmlMsg =
                "<p>Hello,you have an appointment at the pharmacy  "+ examinationDTO.getName()+ " Date of examination :"+examinationDTO.getDate()+" .Start date "+examinationDTO.getStart()+" </p>";

        helper.setText(htmlMsg, true);
        helper.setTo(patient.getEmail());
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


    public void sendingEmailToInformPatient (Patient patient) throws MessagingException {
        // TODO Auto-generated method stub


        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        String htmlMsg =
                "<p>Hello ,  Patient successfully took the drug</p>";

        helper.setText(htmlMsg, true);
        helper.setTo(patient.getEmail());
        helper.setSubject("Rejected absence");///////////////////////ovo promijeni
        helper.setFrom(environment.getProperty("spring.mail.username"));
        javaMailSender.send(mimeMessage);
        System.out.println("kraj funkc!");
    }

    public void sendERecepieToPatient(ERecipe eRecipe) throws MessagingException, IOException, WriterException {
        String fileName = eRecipe.getName() + "_" +eRecipe.getSurname() + "_" + eRecipe.getDateOfIssue() +"_" + eRecipe.getIdRecipe();
        String QR_CODE_IMAGE_PATH = "./qrCodes/" + fileName +".png";
        createqrCodeForEReceie(eRecipe);

        Properties props = new Properties();
        //props.setProperty("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        //props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session mailSession = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("blackcetkica@gmail.com", "maja.maja98");
                    }
                });
        mailSession.setDebug(true);
        Transport transport = mailSession.getTransport();

        MimeMessage message = new MimeMessage(mailSession);
        message.setSubject("eRecepie QR CODE");
        message.setFrom(new InternetAddress("me@sender.com"));
        message.addRecipient(Message.RecipientType.TO,
                new InternetAddress(eRecipe.getPatient().getEmail()));

        MimeMultipart multipart = new MimeMultipart("alternative");

        BodyPart messageBodyPart = new MimeBodyPart();
        String htmlText = "<H1>Please, download this pictur than upload to yout profile page qrCode eRecpeti.</H1><img src=\"cid:image\">";
        messageBodyPart.setContent(htmlText, "text/html");

        multipart.addBodyPart(messageBodyPart);

        messageBodyPart = new MimeBodyPart();
        DataSource fds = new FileDataSource
                (QR_CODE_IMAGE_PATH);
        messageBodyPart.setDataHandler(new DataHandler(fds));
        messageBodyPart.setHeader("Content-ID","<image>");

        multipart.addBodyPart(messageBodyPart);

        message.setContent(multipart);

        transport.connect();
        transport.sendMessage(message,
                message.getRecipients(Message.RecipientType.TO));
        transport.close();



    }

    private void createqrCodeForEReceie(ERecipe eRecipe) throws IOException, WriterException {
        String fileName = eRecipe.getName() + "_" +eRecipe.getSurname() + "_" + eRecipe.getDateOfIssue() +"_"+eRecipe.getIdRecipe();
        String QR_CODE_IMAGE_PATH = "./qrCodes/" + fileName +".png";
        generateQRCodeImage(eRecipe, QR_CODE_IMAGE_PATH);



    }

    public static void generateQRCodeImage(ERecipe eRecipe, String filePath)
            throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(eRecipe.toString(), BarcodeFormat.QR_CODE, 400, 400);

        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }

    //Cita sa qrCoda
    public byte[] getQRCodeImage() throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode("EJ TII ", BarcodeFormat.QR_CODE, 400, 400);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
        byte[] pngData = pngOutputStream.toByteArray();
        return pngData;
    }

    public void emailForSubscribe(Pharmacy pharmacy, String email) throws MessagingException, IOException, WriterException {
        /*String fileName = eRecipe.getName() + "_" +eRecipe.getSurname() + "_" + eRecipe.getDateOfIssue() +"_" + eRecipe.getIdRecipe();
        String QR_CODE_IMAGE_PATH = "./qrCodes/" + fileName +".png";
        createqrCodeForEReceie(eRecipe);*/

        Properties props = new Properties();
        //props.setProperty("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        //props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session mailSession = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("blackcetkica@gmail.com", "maja.maja98");
                    }
                });
        mailSession.setDebug(true);
        Transport transport = mailSession.getTransport();

        MimeMessage message = new MimeMessage(mailSession);
        message.setSubject("Info from " + pharmacy.getName());
        message.setFrom(new InternetAddress("me@sender.com"));
        message.addRecipient(Message.RecipientType.TO,
                new InternetAddress(email));

        MimeMultipart multipart = new MimeMultipart("alternative");

        BodyPart messageBodyPart = new MimeBodyPart();
        String htmlText = "<H1>You are now subscribe our pharmacy. We will send you our new action & benefits.</H1>" +
                "<p>Name: "+ pharmacy.getName() + "</p>" +
                "<p>Address:"+ pharmacy.getAddress()+","+pharmacy.getCity() +".</p>";
        messageBodyPart.setContent(htmlText, "text/html");

        multipart.addBodyPart(messageBodyPart);


        message.setContent(multipart);

        transport.connect();
        transport.sendMessage(message,
                message.getRecipients(Message.RecipientType.TO));
        transport.close();



    }

    public void emailForUnsubscribe(Pharmacy pharmacy, String email) throws MessagingException, IOException, WriterException {
        /*String fileName = eRecipe.getName() + "_" +eRecipe.getSurname() + "_" + eRecipe.getDateOfIssue() +"_" + eRecipe.getIdRecipe();
        String QR_CODE_IMAGE_PATH = "./qrCodes/" + fileName +".png";
        createqrCodeForEReceie(eRecipe);*/

        Properties props = new Properties();
        //props.setProperty("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        //props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session mailSession = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("blackcetkica@gmail.com", "maja.maja98");
                    }
                });
        mailSession.setDebug(true);
        Transport transport = mailSession.getTransport();

        MimeMessage message = new MimeMessage(mailSession);
        message.setSubject("Info from " + pharmacy.getName());
        message.setFrom(new InternetAddress("me@sender.com"));
        message.addRecipient(Message.RecipientType.TO,
                new InternetAddress(email));

        MimeMultipart multipart = new MimeMultipart("alternative");

        BodyPart messageBodyPart = new MimeBodyPart();
        String htmlText = "<H1>You are now unsubscribe from our pharmacy. You will no longer get our notification..</H1>" +
                "<p>Name: "+ pharmacy.getName() + "</p>" +
                "<p>Address:"+ pharmacy.getAddress()+","+pharmacy.getCity() +".</p>";
        messageBodyPart.setContent(htmlText, "text/html");

        multipart.addBodyPart(messageBodyPart);


        message.setContent(multipart);

        transport.connect();
        transport.sendMessage(message,
                message.getRecipients(Message.RecipientType.TO));
        transport.close();



    }

    public void sendVerification(String email) throws MessagingException {

        Properties props = new Properties();
        //props.setProperty("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        //props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session mailSession = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("blackcetkica@gmail.com", "maja.maja98");
                    }
                });
        mailSession.setDebug(true);
        Transport transport = mailSession.getTransport();

        MimeMessage message = new MimeMessage(mailSession);
        message.setSubject("Verify your email");
        message.setFrom(new InternetAddress("me@sender.com"));
        message.addRecipient(Message.RecipientType.TO,
                new InternetAddress(email));

        MimeMultipart multipart = new MimeMultipart("alternative");

        BodyPart messageBodyPart = new MimeBodyPart();
        String htmlText = "<H1> Welcome to our pharmacy comunity.. we are glade to have you.</H1>" +
                "<p> You can now se what we have in offer, schedule your examination and so more.. </p>" +
                "<a href='http://localhost:3000/login'>Click on this to go to your account. </a>" +
                "<p> You are welcome here. </p>";

        messageBodyPart.setContent(htmlText, "text/html");

        multipart.addBodyPart(messageBodyPart);


        message.setContent(multipart);

        transport.connect();
        transport.sendMessage(message,
                message.getRecipients(Message.RecipientType.TO));
        transport.close();



    }

    public void sendEmailAnswerComplain(String text, Patient patient) throws MessagingException {
      Properties props = new Properties();
        //props.setProperty("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        //props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session mailSession = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("blackcetkica@gmail.com", "maja.maja98");
                    }
                });
        mailSession.setDebug(true);
        Transport transport = mailSession.getTransport();

        MimeMessage message = new MimeMessage(mailSession);
        message.setSubject("Complain answer:");
        message.setFrom(new InternetAddress("me@sender.com"));
        message.addRecipient(Message.RecipientType.TO,
                new InternetAddress(patient.getEmail()));

        MimeMultipart multipart = new MimeMultipart("alternative");

        BodyPart messageBodyPart = new MimeBodyPart();
        String htmlText = "<H4> Dear " +patient.getName() +" " + patient.getSurname() +",</H4>" +
                "<p>" + text + "</p>" +
                "<p> System admin. </p>";

        messageBodyPart.setContent(htmlText, "text/html");

        multipart.addBodyPart(messageBodyPart);


        message.setContent(multipart);

        transport.connect();
        transport.sendMessage(message,
                message.getRecipients(Message.RecipientType.TO));
        transport.close();



    }

    public void sendERecepieVerification(Patient patient, Pharmacy pharmacy) throws MessagingException {
        Properties props = new Properties();
        //props.setProperty("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        //props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session mailSession = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("blackcetkica@gmail.com", "maja.maja98");
                    }
                });
        mailSession.setDebug(true);
        Transport transport = mailSession.getTransport();

        MimeMessage message = new MimeMessage(mailSession);
        message.setSubject("eRecepie approved");
        message.setFrom(new InternetAddress("me@sender.com"));
        message.addRecipient(Message.RecipientType.TO,
                new InternetAddress(patient.getEmail()));

        MimeMultipart multipart = new MimeMultipart("alternative");

        BodyPart messageBodyPart = new MimeBodyPart();
        String htmlText = "<H4> Dear " +patient.getName() +" " + patient.getSurname() +",</H4>" +
                "<p>You successeffuly buy drugs in " + pharmacy.getName() + ". </p>" +
                "<p> System admin. </p>";

        messageBodyPart.setContent(htmlText, "text/html");

        multipart.addBodyPart(messageBodyPart);


        message.setContent(multipart);

        transport.connect();
        transport.sendMessage(message,
                message.getRecipients(Message.RecipientType.TO));
        transport.close();


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
