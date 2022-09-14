package com.example.transaBuddy.domain.shipment.shipmentPrice;

import com.example.transaBuddy.transabuddy.shipment.ShipmentPriceInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ShipmentPriceMapper {


    @Mapping(source = "id", target = "id")
    ShipmentPrice shipmentPriceToShipmentPriceInfo(ShipmentPrice shipmentPrice);
    List<ShipmentPriceInfo> shipmentPricesToShipmentPriceInfos(List<ShipmentPrice> shipmentPrices);

}