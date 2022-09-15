package com.example.transaBuddy.domain.order;

import com.example.transaBuddy.transabuddy.order.OrderInfo;
import com.example.transaBuddy.transabuddy.order.OrderRequest;
import com.example.transaBuddy.transabuddy.order.OrderResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Optional;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface OrderMapper {

    @Mapping(source = "id", target = "orderId")
    @Mapping(source = "senderUser.id", target = "senderUserId")
    @Mapping(source = "courierUser.id", target = "courierUserId")
    @Mapping(source = "shipment.id", target = "shipmentId")
    OrderInfo orderToOrderInfo(Order order);

    List<OrderInfo> ordersToOrderInfos(List<Order> orders);

    @Mapping(target = "status", constant = "P")
    Order orderRequestToOrder(OrderRequest request);

    @Mapping(target = "orderId", source = "id")
    OrderResponse orderToOrderResponse(Order order);

    Order optionalOrderToOrder(Optional<Order> optionalOrder);
}
