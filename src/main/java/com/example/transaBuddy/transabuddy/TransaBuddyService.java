package com.example.transaBuddy.transabuddy;

import com.example.transaBuddy.domain.order.OrderService;
import com.example.transaBuddy.transabuddy.order.OrderInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TransaBuddyService {

    @Resource
    private OrderService orderService;

    public List<OrderInfo> findOrdersByUserId(Integer userId) {
        return orderService.findOrdersByUserId(userId);
    }

    public List<OrderInfo> findActiveOrdersBySenderUserId(Integer userId) {
        return orderService.findAllActiveOrdersBySenderUserId(userId);
    }
    public List<OrderInfo> findActiveOrdersByCourierUserId(Integer userId) {
        return orderService.findAllActiveOrdersByCourierUserId(userId);
    }

    public OrderInfo findOrderByOrderId(Integer orderId) {
        return orderService.findOrderByOrderId(orderId);
    }

    public List<OrderInfo> findAllActiveOrders() {
        return orderService.findAllSenderActiveOrders();
    }

    public List<OrderInfo> findOrdersByDistrictAndStatus(Integer pickUpDistrictId, Integer dropOffDistrictId, String status) {
        return orderService.findOrdersByDistrictAndStatus(pickUpDistrictId, dropOffDistrictId, status);
    }
    public List<OrderInfo> findCompletedOrdersByCourierUserId(Integer courierUserId) {
        return orderService.findCompletedOrdersByCourierUserId(courierUserId);
    }

    public OrderInfo updateOrder(OrderInfo orderInfo, Integer fromHour, Integer toHour) {
        return orderService.updateOrder(orderInfo, fromHour, toHour);
    }
}
