package com.isaProject.isa.Repositories;

import com.isaProject.isa.Model.Pharmacy.ComplaintAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintAnswerRepository extends JpaRepository<ComplaintAnswer,Integer> {

}
