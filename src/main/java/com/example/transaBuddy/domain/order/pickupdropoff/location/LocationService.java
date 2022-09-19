package com.example.transaBuddy.domain.order.pickupdropoff.location;

import com.example.transaBuddy.domain.order.pickupdropoff.location.district.District;
import com.example.transaBuddy.domain.order.pickupdropoff.location.district.DistrictRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class LocationService {

    @Resource
    private LocationRepository locationRepository;
    @Resource
    private DistrictRepository districtRepository;

    public Location createAndAddLocation(String address, Integer districtId) {
        boolean existsByAddressAndDistrictId = locationRepository.existsByAddressAndDistrictId(address, districtId);
        if (existsByAddressAndDistrictId){
            return locationRepository.findByAddressAndDistrictId(address, districtId);
        } else {
            Location location = new Location();
            District district = districtRepository.findById(districtId).get();
            location.setAddress(address);
            location.setDistrict(district);
            return locationRepository.save(location);
        }
    }
}

