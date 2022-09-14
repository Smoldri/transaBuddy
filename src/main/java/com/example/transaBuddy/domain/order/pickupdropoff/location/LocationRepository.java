package com.example.transaBuddy.domain.order.pickupdropoff.location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LocationRepository extends JpaRepository<Location, Integer> {
    @Query("select l from Location l where l.id = ?1")
    Location findLocationById(Integer id);


}