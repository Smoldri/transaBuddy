package com.example.transaBuddy.domain.order.orderimage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderImageRepository extends JpaRepository<OrderImage, Integer> {
    @Query("select o from OrderImage o where o.order.id = ?1 and o.type = ?2")
    List<OrderImage> findImagesByOrderIdAndType(Integer id, String type);

}