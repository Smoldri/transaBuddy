package com.example.transaBuddy.domain.order.pickupdropoff;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PickUpDropOffRepository extends JpaRepository<PickUpDropOff, Integer> {
    @Query("select p from PickUpDropOff p where p.location.id = ?1")
    PickUpDropOff findByLocationId(Integer id);

    @Query("select p from PickUpDropOff p where p.type = ?1")
    List<PickUpDropOff> findByType(String type);

    @Query("select p from PickUpDropOff p where p.location.district.id = ?1 and p.type = ?2")
    List<PickUpDropOff> findByDistrictIdAndType(Integer id, String type);




}