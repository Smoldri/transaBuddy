package com.example.transaBuddy.domain.order;

import com.example.transaBuddy.domain.contact.Contact;
import com.example.transaBuddy.domain.order.pickupdropoff.PickUpDropOffRepository;
import com.example.transaBuddy.transabuddy.order.OrderInfo;
import com.example.transaBuddy.transabuddy.order.OrderRequest;
import com.example.transaBuddy.transabuddy.order.OrderResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import javax.annotation.Resource;
import java.util.List;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface OrderMapper {

    @Mapping(source = "id", target = "orderId")
    @Mapping(source = "senderUser.id", target = "senderUserId")
    @Mapping(source = "courierUser.id", target = "courierUserId")
    @Mapping(source = "shipment.id", target = "shipmentId")
    @Mapping(source = "senderUser.contact", target = "senderName", qualifiedByName = "senderFullName")
    @Mapping(source = "senderUser.contact.phoneNumber", target = "senderPhoneNumber")
    @Mapping(source = "shipment.shipmentPrice.type", target = "priceCategory")
    @Mapping(source = "shipment.amount", target = "packageAmount")
    @Mapping(source = "shipment.description", target = "shipmentDescription")
    @Mapping(source = "order", target = "timeFrame", qualifiedByName = "timeFrame")
    OrderInfo orderToOrderInfo(Order order);

    @Named("senderFullName")
    static String senderFullName(Contact contact) {
        return contact.getFirstName() + " " + contact.getLastName();
    }
    @Named("timeFrame")
    static String timeFrame (Order order) {
        return String.valueOf(order. getFromHour()) + ":00 - " + String.valueOf(order.getToHour()) + ":00 ";
    }

    List<OrderInfo> ordersToOrderInfos(List<Order> orders);

    @Mapping(target = "status", constant = "N")
    Order orderRequestToOrder(OrderRequest request);

    @Mapping(target = "orderId", source = "id")
    OrderResponse orderToOrderResponse(Order order);


}
