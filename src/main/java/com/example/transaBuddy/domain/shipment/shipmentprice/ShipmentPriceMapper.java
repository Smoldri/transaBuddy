package com.example.transaBuddy.domain.shipment.shipmentprice;

import com.example.transaBuddy.transabuddy.shipment.ShipmentPriceInfo;
import com.example.transaBuddy.transabuddy.shipment.ShipmentPriceRequest;
import com.example.transaBuddy.transabuddy.shipment.ShipmentPriceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ShipmentPriceMapper {


    @Mapping(source = "id", target = "id")
    ShipmentPrice shipmentPriceToShipmentPriceInfo(ShipmentPrice shipmentPrice);
    List<ShipmentPriceInfo> shipmentPricesToShipmentPriceInfos(List<ShipmentPrice> shipmentPrices);

    ShipmentPrice shipmentPriceRequestToShipmentPrice(ShipmentPriceRequest request);

    @Mapping(source = "id", target = "shipmentPriceId")
    ShipmentPriceResponse shipmentPriceToShipmentPriceResponse(ShipmentPrice shipmentPrice);

}