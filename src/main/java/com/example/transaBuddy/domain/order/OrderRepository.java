package com.example.transaBuddy.domain.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("select o from Order o where o.senderUser.id = ?1")
    List<Order> findOrdersBySenderId(Integer id);



    @Query("select o from Order o where o.courierUser.id = ?1")
    List<Order> findOrdersByCourierId(Integer courierId);

}