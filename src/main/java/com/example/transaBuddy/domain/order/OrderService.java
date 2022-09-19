package com.example.transaBuddy.domain.order;

import com.example.transaBuddy.domain.order.pickupdropoff.PickUpDropOff;
import com.example.transaBuddy.domain.order.pickupdropoff.PickUpDropOffRepository;
import com.example.transaBuddy.domain.order.pickupdropoff.PickUpDropOffService;
import com.example.transaBuddy.domain.user.UserRepository;
import com.example.transaBuddy.domain.user.UserService;
import com.example.transaBuddy.domain.shipment.Shipment;
import com.example.transaBuddy.domain.shipment.ShipmentService;
import com.example.transaBuddy.domain.user.User;

import com.example.transaBuddy.transabuddy.order.OrderInfo;
import com.example.transaBuddy.transabuddy.order.OrderRequest;
import com.example.transaBuddy.transabuddy.order.OrderResponse;
import com.example.transaBuddy.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class OrderService {
    @Resource
    private OrderRepository orderRepository;
    @Resource
    private ShipmentService shipmentService;
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private UserService userService;
    @Resource
    private PickUpDropOffService pickUpDropOffService;

    @Resource
    private UserRepository userRepository;

    @Resource
    private PickUpDropOffRepository pickUpDropOffRepository;

    public OrderResponse addNewOrder(OrderRequest request) {
        Shipment shipment = shipmentService.createAndAddShipment(request);
        Order order = orderMapper.orderRequestToOrder(request);
        User user = userService.getUserByUserId(request.getSenderUserId());
        order.setShipment(shipment);
        order.setSenderUser(user);
        orderRepository.save(order);
        pickUpDropOffService.createAndAddPickUp(request, order);
        pickUpDropOffService.createAndAddDropOff(request, order);
        return orderMapper.orderToOrderResponse(order);
    }

    public List<OrderInfo> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orderMapper.ordersToOrderInfos(orders);
    }

    public List<OrderInfo> findOrdersByUserId(Integer userId) {
        List<Order> orders = orderRepository.findOrdersByUserId(userId, userId);
        ValidationService.validateOrdersExist(orders);
        return orderMapper.ordersToOrderInfos(orders);
    }

    public List<OrderInfo> findAllOrdersByDates(LocalDate startDate, LocalDate endDate) {
//        if (endDate.equals(null)) {
//            return  orderMapper.ordersToOrderInfos(orderRepository.findAllOrdersFromStartDate(startDate));
//        } else if (startDate.equals(null)){
//            return  orderMapper.ordersToOrderInfos(orderRepository.findAllOrdersToEndDate(endDate));
//        } else {
        return orderMapper.ordersToOrderInfos(orderRepository.findOrdersByDates(startDate, endDate));
//        }
    }

    public void acceptOrder(Integer orderId, Integer courierId) {
        Order order = orderRepository.findById(orderId).get();
        order.setCourierUser(userRepository.getUserByUserId(courierId));
        order.setStatus("A"); //ACCEPTED
        orderRepository.save(order);
    }

    public void rejectOrder(Integer orderId) {
        Order order = orderRepository.findById(orderId).get();
        order.setCourierUser(null);
        order.setStatus("N"); // NEW
        orderRepository.save(order);
    }

    public List<OrderInfo> findUserOrdersByStatus(Integer userId, String status) {
        List<OrderInfo> orderInfos = findOrdersByUserId(userId);
        List<OrderInfo> statusOrderInfos = orderInfos.stream().
                filter(orderInfo -> orderInfo.getStatus().contains(status)).collect(Collectors.toList());
        ValidationService.validateStatusOrdersExist(statusOrderInfos, status);
        return statusOrderInfos;
    }

    public void confirmOrderPickUp(Integer orderId) {
        Order order = orderRepository.findById(orderId).get();
        order.setStatus("P"); // PICKED UP
        orderRepository.save(order);
    }

    public void confirmOrderDelivery(Integer orderId) {
        Order order = orderRepository.findById(orderId).get();
        order.setStatus("C"); // COMPLETED
        orderRepository.save(order);
    }

    public void deleteOrder(Integer orderId) {
        Order order = orderRepository.findById(orderId).get();
        order.setCourierUser(null);
        order.setStatus("D"); // DELETED
        orderRepository.save(order);
    }

    public List<OrderInfo> findAllOrdersByDistrictAndPickUpDropOffType(Integer districtId, String pickUpDropOffType) {
        List<PickUpDropOff> pickUpsDropOffs = pickUpDropOffRepository.findByDistrictIdAndType(districtId, pickUpDropOffType);
        List<Order> orders = new ArrayList<>();
        for (PickUpDropOff pickUpDropOff : pickUpsDropOffs) {
            orders.add(pickUpDropOff.getOrder());
        }
        return orderMapper.ordersToOrderInfos(orders);
    }

    public List<OrderInfo> findAllOrdersByPickUpAndOrDropOffDistrict(Integer pickUpDistrictId, Integer dropOffDistrictId) {
        List<Order> orders = new ArrayList<>();
        if (pickUpDistrictId > 0 && dropOffDistrictId > 0) {
            List<PickUpDropOff> pickUps = pickUpDropOffRepository.findByDistrictIdAndType(pickUpDistrictId, "P");
            List<PickUpDropOff> dropOffs = pickUpDropOffRepository.findByDistrictIdAndType(dropOffDistrictId, "D");
            for (PickUpDropOff pickUp : pickUps) {
                for (PickUpDropOff dropOff : dropOffs) {
                    if (dropOff.getOrder().equals(pickUp.getOrder())) {
                        orders.add(pickUp.getOrder());
                    }
                }
            }
        } else if (pickUpDistrictId > 0 && dropOffDistrictId < 1 ) {
            List<PickUpDropOff> pickUps = pickUpDropOffRepository.findByDistrictIdAndType(pickUpDistrictId, "P");
            for (PickUpDropOff pickUp : pickUps) {
                orders.add(pickUp.getOrder());
            }
            return orderMapper.ordersToOrderInfos(orders);
        } else if (pickUpDistrictId < 1 && dropOffDistrictId > 0) {
            List<PickUpDropOff> dropOffs = pickUpDropOffRepository.findByDistrictIdAndType(dropOffDistrictId, "D");
            for (PickUpDropOff dropOff : dropOffs) {
                orders.add(dropOff.getOrder());
            }
        }
        return orderMapper.ordersToOrderInfos(orders);
    }

    public List<OrderInfo> findOrdersByDistrictAndStatus(Integer pickUpDistrictId, Integer dropOffDistrictId, String status) {
        List<OrderInfo> orderInfos = findAllOrdersByPickUpAndOrDropOffDistrict(pickUpDistrictId, dropOffDistrictId);
        List<OrderInfo> orderInfosByStatus = new ArrayList<>();
        for(OrderInfo orderInfo : orderInfos){
            if (orderInfo.getStatus().equals(status)){
                orderInfosByStatus.add(orderInfo);
            }
        }
        return orderInfosByStatus;
    }
}


