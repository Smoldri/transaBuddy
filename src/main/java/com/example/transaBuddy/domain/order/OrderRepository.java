package com.example.transaBuddy.domain.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("select o from Order o where o.senderUser.id = ?1")
    List<Order> findOrdersBySenderId(Integer id);

    @Query("select o from Order o where o.courierUser.id = ?1")
    List<Order> findOrdersByCourierId(Integer courierId);

    @Query("select o from Order o where o.deliveryDate >= ?1 and o.deliveryDate <= ?2")
    List<Order> findOrdersByDates(LocalDate startDate, LocalDate endDate);

    @Query("select o from Order o where o.deliveryDate >= ?1")
    List<Order> findAllOrdersFromStartDate(LocalDate deliveryDate);

    @Query("select o from Order o where o.deliveryDate <= ?1")
    List<Order> findAllOrdersToEndDate(LocalDate endDate);







    @Query("select o from Order o where o.senderUser.id = ?1 or o.courierUser.id = ?2")
    List<Order> findOrdersByUserId(Integer id, Integer id1);
}