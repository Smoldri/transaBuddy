package com.example.transaBuddy.domain.order;

import com.example.transaBuddy.temp.Order;
import com.example.transaBuddy.transabuddy.order.OrderRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "status", constant = "P")
    Order orderRequestToOrder(OrderRequest request);
}
