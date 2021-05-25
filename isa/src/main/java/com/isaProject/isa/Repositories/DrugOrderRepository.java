package com.isaProject.isa.Repositories;

import com.isaProject.isa.Model.Drugs.DrugOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugOrderRepository extends JpaRepository<DrugOrder, Integer> {
}
