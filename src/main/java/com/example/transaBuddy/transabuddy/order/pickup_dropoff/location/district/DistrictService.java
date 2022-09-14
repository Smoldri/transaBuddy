package com.example.transaBuddy.transabuddy.order.pickup_dropoff.location.district;


import com.example.transaBuddy.temp.District;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DistrictService {

    @Resource
    private DistrictRepository districtRepository;

    public District getDistrictById(Integer districtId) {
        return districtRepository.getDistrictById(districtId);
    }
}
