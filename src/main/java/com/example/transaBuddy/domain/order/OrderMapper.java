package com.example.transaBuddy.domain.order;

import com.example.transaBuddy.temp.Order;
import com.example.transaBuddy.transabuddy.order.OrderInfo;
import com.example.transaBuddy.transabuddy.order.OrderRequest;
import com.example.transaBuddy.transabuddy.order.OrderResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "status", constant = "P")
    Order orderRequestToOrder(OrderRequest request);


    @Mapping(target = "orderId", source = "id")
    OrderResponse orderToOrderResponse(Order order);

    @Mapping(target = "orderId", source = "id")
    OrderResponse orderToOrderInfo(Order order);
    List<OrderInfo> orderToOrderInfos(List<Order> orders);
}
