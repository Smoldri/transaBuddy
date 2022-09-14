package com.example.transaBuddy.domain.order.pickupdropoff.location;

import com.example.transaBuddy.domain.order.pickupdropoff.location.district.District;
import com.example.transaBuddy.transabuddy.order.OrderRequest;
import com.example.transaBuddy.domain.order.pickupdropoff.location.district.DistrictRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LocationService {

    @Resource
    private LocationMapper locationMapper;
    @Resource
    private LocationRepository locationRepository;
    @Resource
    private DistrictRepository districtRepository;

    public Location createAndAddPickUpLocation(OrderRequest request) {
        Location location = locationMapper.orderRequestToPickUpLocation(request);
        District district = districtRepository.getDistrictById(request.getPickUpDistrict());
        location.setDistrict(district);
         return locationRepository.save(location);
    }
    public Location createAndAddDropOffLocation(OrderRequest request) {
        Location location = locationMapper.orderRequestToDropOffLocation(request);
        District district = districtRepository.getDistrictById(request.getDropOffDistrictId());
        location.setDistrict(district);
        return locationRepository.save(location);
    }



}
