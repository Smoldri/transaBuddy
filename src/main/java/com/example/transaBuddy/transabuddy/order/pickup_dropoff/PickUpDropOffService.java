package com.example.transaBuddy.transabuddy.order.pickup_dropoff;


import com.example.transaBuddy.temp.Order;
import com.example.transaBuddy.temp.PickUpDropOff;
import com.example.transaBuddy.transabuddy.order.OrderRequest;
import com.example.transaBuddy.transabuddy.order.pickup_dropoff.location.LocationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PickUpDropOffService {


    @Resource
    private LocationService locationService;
    @Resource
    private PickUpDropOffRepository pickUpDropOffRepository;



    public PickUpDropOff createAndAddPickUp(OrderRequest request, Order order) {
        PickUpDropOff pickUp = new PickUpDropOff();
        pickUp.setOrder(order);
        pickUp.setLocation(locationService.createAndAddPickUpLocation(request));
        pickUp.setType("P");
        return pickUpDropOffRepository.save(pickUp);
    }
        public PickUpDropOff createAndAddDropOff(OrderRequest request, Order order) {
        PickUpDropOff dropOff = new PickUpDropOff();
        dropOff.setOrder(order);
        dropOff.setLocation(locationService.createAndAddDropOffLocation(request));
        dropOff.setType("D");
        pickUpDropOffRepository.save(dropOff);
        return pickUpDropOffRepository.save(dropOff);
    }
}
