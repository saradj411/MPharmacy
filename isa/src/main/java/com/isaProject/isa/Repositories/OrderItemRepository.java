package com.isaProject.isa.Repositories;

import com.isaProject.isa.Model.Drugs.DrugPricelist;
import com.isaProject.isa.Model.Drugs.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
    @Query("select ex from OrderItem  ex where ex.drugOrder.idOrder = ?1")
    List<OrderItem> findOrderItemByidOrder(Integer idOrder);

}
