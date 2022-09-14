package com.example.transaBuddy.domain.shipment;

import com.example.transaBuddy.transabuddy.order.OrderRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ShipmentMapper {
    @Mapping(target = "amount", source = "packageAmountInShipment")
    @Mapping(target = "description", source = "shipmentDescription")
   Shipment orderRequestToShipment(OrderRequest request);
}
