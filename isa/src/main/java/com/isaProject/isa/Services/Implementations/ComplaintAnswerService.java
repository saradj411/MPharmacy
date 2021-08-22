package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Model.Pharmacy.Complaint;
import com.isaProject.isa.Model.Pharmacy.ComplaintAnswer;
import com.isaProject.isa.Repositories.ComplaintAnswerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;

@Service
@Slf4j
public class ComplaintAnswerService{

    @Autowired
    ComplaintAnswerRepository complaintAnswerRepository;

    @Autowired
    ComplainService complainService;

    @Autowired
    ServiceForEmail serviceForEmail;

    public List<ComplaintAnswer> findAll() { return  complaintAnswerRepository.findAll(); }

    public ComplaintAnswer createAnswer(Integer id, String text) throws MessagingException {
        ComplaintAnswer complaintAnswer = new ComplaintAnswer();
        complaintAnswer.setTextAnswer(text);
        Complaint complaint = complainService.findById(id);
        complaint.setAnswered(true);
        complaintAnswer.setComplaint(complaint);
        complaintAnswerRepository.save(complaintAnswer);
        serviceForEmail.sendEmailAnswerComplain(text, complaint.getPatient());
        return  complaintAnswer;
    }




}
