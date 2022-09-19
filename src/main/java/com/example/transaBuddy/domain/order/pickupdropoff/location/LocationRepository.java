package com.example.transaBuddy.domain.order.pickupdropoff.location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Integer> {


    @Query("select (count(l) > 0) from Location l where l.address = ?1 and l.district.id = ?2")
    boolean existsByAddressAndDistrictId(String address, Integer districtId);

    @Query("select l from Location l where l.address = ?1 and l.district.id = ?2")
    Location findByAddressAndDistrictId(String address, Integer districtId);
}