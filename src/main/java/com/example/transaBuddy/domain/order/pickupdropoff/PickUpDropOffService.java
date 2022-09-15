package com.example.transaBuddy.domain.order.pickupdropoff;


import com.example.transaBuddy.domain.order.Order;
import com.example.transaBuddy.domain.order.pickupdropoff.location.Location;
import com.example.transaBuddy.transabuddy.order.OrderRequest;
import com.example.transaBuddy.domain.order.pickupdropoff.location.LocationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    public List<PickUpDropOff> findPickUpsAndDropOffsByLocationId(Integer locationId) {
        return pickUpDropOffRepository.findByLocationId(locationId);
        }


}
