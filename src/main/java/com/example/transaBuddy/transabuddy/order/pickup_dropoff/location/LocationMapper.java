package com.example.transaBuddy.transabuddy.order.pickup_dropoff.location;

import com.example.transaBuddy.temp.Location;
import com.example.transaBuddy.transabuddy.order.OrderRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface LocationMapper {

    @Mapping(target = "address", source = "pickUpAddress")
    Location orderRequestToPickUpLocation(OrderRequest request);

    @Mapping(target = "address", source = "dropOffAddress")
    Location orderRequestToDropOffLocation(OrderRequest request);
}
