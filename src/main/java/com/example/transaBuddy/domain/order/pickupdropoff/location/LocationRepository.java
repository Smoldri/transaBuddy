package com.example.transaBuddy.domain.order.pickupdropoff.location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Integer> {

    @Query("select l from Location l where upper(l.address) = upper(?1) and upper(l.district.id) = upper(?2)")
    boolean existsByAddressAndDistrictId(String address, Integer id);

    @Query("select l from Location l where l.district.id = ?1")
    List<Location> findLocationsByDistrictId(Integer districtId);
}