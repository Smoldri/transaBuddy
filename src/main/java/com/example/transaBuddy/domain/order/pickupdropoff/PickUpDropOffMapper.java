package com.example.transaBuddy.domain.order.pickupdropoff;

import com.example.transaBuddy.transabuddy.pickupdropoff.PickUpDropOffInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PickUpDropOffMapper {

    @Mapping(source = "id", target = "pickUpDropOffId")
    @Mapping(source = "order.id", target = "orderId")
    @Mapping(source = "location.id", target = "locationId")
    PickUpDropOffInfo pickUpDropOffToPickUpDropOffInfo(PickUpDropOff pickUpDropOff);

    List<PickUpDropOffInfo> pickUpDropOffToPickUpDropOffInfo(List<PickUpDropOff> pickUpDropOff);
}
