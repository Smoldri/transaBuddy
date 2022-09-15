package com.example.transaBuddy.domain.order.pickupdropoff;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PickUpDropOffRepository extends JpaRepository<PickUpDropOff, Integer> {
    @Query("select p from PickUpDropOff p where p.location.id = ?1")
    List<PickUpDropOff> findByLocationId(Integer id);




}