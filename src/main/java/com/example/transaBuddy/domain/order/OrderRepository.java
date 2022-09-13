package com.example.transaBuddy.domain.order;

import com.example.transaBuddy.temp.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}