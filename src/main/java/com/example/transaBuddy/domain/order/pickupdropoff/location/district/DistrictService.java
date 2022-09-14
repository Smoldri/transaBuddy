package com.example.transaBuddy.domain.order.pickupdropoff.location.district;


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
