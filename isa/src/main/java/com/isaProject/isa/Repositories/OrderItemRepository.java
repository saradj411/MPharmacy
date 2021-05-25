package com.isaProject.isa.Repositories;

import com.isaProject.isa.Model.Drugs.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}
