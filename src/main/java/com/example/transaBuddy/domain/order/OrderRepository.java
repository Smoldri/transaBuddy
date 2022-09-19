package com.example.transaBuddy.domain.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("select (count(o) > 0) from Order o where o.deliveryDate >= ?1 and o.deliveryDate <= ?2")
    boolean existsByDates(LocalDate startDate, LocalDate endDate);

    @Query("select o from Order o where o.deliveryDate >= ?1 and o.deliveryDate <= ?2")
    List<Order> findOrderByStartDateAndEndDate(LocalDate startDate, LocalDate endDate);

    @Query("select o from Order o where o.senderUser.id = ?1 or o.courierUser.id = ?2")
    List<Order> findOrdersByUserId(Integer id, Integer id1);

    @Query("select o from Order o where o.deliveryDate >= ?1 and o.deliveryDate <= ?2")
    List<Order> findOrderByStartDateOrEndDate(LocalDate deliveryDate, LocalDate deliveryDate1);

    @Query("select o from Order o where o.status = ?1 or o.status = ?2 or o.status = ?3")
    List<Order> findAllActiveOrders(String status, String status1, String status2);



}