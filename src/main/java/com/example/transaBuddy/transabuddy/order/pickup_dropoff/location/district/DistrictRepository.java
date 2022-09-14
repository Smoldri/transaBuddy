package com.example.transaBuddy.transabuddy.order.pickup_dropoff.location.district;

import com.example.transaBuddy.temp.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DistrictRepository extends JpaRepository<District, Integer> {
    @Query("select d from District d where d.id = ?1")
    District getDistrictById(Integer id);


}