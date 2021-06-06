package com.isaProject.isa.Repositories;

import com.isaProject.isa.Model.Drugs.DrugOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface DrugOrderRepository extends JpaRepository<DrugOrder, Integer> {
    DrugOrder findOnByidOrder(Integer id);
}
