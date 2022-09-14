package com.example.transaBuddy.domain.order.pickupdropoff.location;

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
