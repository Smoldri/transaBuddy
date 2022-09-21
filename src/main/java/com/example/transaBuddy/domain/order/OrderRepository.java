package com.example.transaBuddy.domain.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("select (count(o) > 0) from Order o where o.deliveryDate >= ?1 and o.deliveryDate <= ?2")
    boolean existsByDates(LocalDate startDate, LocalDate endDate);

    @Query("select o from Order o where o.deliveryDate >= ?1 and o.deliveryDate <= ?2 order by o.deliveryDate DESC")
    List<Order> findOrderByStartDateAndEndDate(LocalDate deliveryDate, LocalDate deliveryDate1);

    @Query("select o from Order o where o.senderUser.id = ?1 or o.courierUser.id = ?2")
    List<Order> findOrdersByUserId(Integer senderUserId, Integer courierUserId);


    @Query("select o from Order o where o.deliveryDate >= ?1 or o.deliveryDate <= ?2 order by o.deliveryDate DESC")
    List<Order> findOrderByStartDateOrEndDate(LocalDate deliveryDate, LocalDate deliveryDate1);

    @Query("select o from Order o where o.status = ?1 or o.status = ?2 or o.status = ?3 order by o.deliveryDate DESC")
    List<Order> findAllActiveOrders(String status, String status1, String status2);

    @Query("select o from Order o where o.status = ?1 or o.status = ?2 order by o.status")
    List<Order> findAllCourierActiveOrders(String status, String status1);

    @Query("select o from Order o where o.courierUser.id = ?1 and o.status = ?2 order by o.deliveryDate")
    List<Order> findOrdersByUserIdAndStatus(Integer id, String status);

    @Query("select o from Order o where o.senderUser.id = ?1")
    List<Order> findSenderOrdersByUserId(Integer id);



}