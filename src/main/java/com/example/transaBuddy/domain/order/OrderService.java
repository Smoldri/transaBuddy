package com.example.transaBuddy.domain.order;

import com.example.transaBuddy.domain.order.pickupdropoff.PickUpDropOff;
import com.example.transaBuddy.domain.order.pickupdropoff.location.Location;
import com.example.transaBuddy.domain.order.pickupdropoff.location.LocationService;
import com.example.transaBuddy.domain.user.UserService;
import com.example.transaBuddy.domain.shipment.Shipment;
import com.example.transaBuddy.domain.user.User;
import com.example.transaBuddy.transabuddy.order.OrderInfo;
import com.example.transaBuddy.transabuddy.order.OrderRequest;
import com.example.transaBuddy.transabuddy.order.OrderResponse;
import com.example.transaBuddy.domain.order.pickupdropoff.PickUpDropOffService;
import com.example.transaBuddy.domain.shipment.ShipmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


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
    private LocationService locationService;

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
        List  <Order> orders =  orderRepository.findAll();
        return orderMapper.ordersToOrderInfos(orders);
    }

    public List<OrderInfo> findOrdersBySenderId(Integer senderId) {
        List<Order> orders = orderRepository.findOrdersBySenderId(senderId);
        return orderMapper.ordersToOrderInfos(orders);
    }

    public List<OrderInfo> findOrdersByCourierId(Integer courierId) {
        List<Order> orders = orderRepository.findOrdersByCourierId(courierId);
        return orderMapper.ordersToOrderInfos(orders);
    }

    public OrderInfo findOrderByOrderId(Integer orderId){
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        Order order = orderMapper.optionalOrderToOrder(optionalOrder);
        return orderMapper.orderToOrderInfo(order);

    }

    public List<OrderInfo> findAllOrdersByDate(LocalDate date) {
        List<Order> orders = orderRepository.findOrdersByDate(date);
        return orderMapper.ordersToOrderInfos(orders);
    }

    public List<OrderInfo> findAllOrdersByDistricts(Integer pickUpDistrictId, Integer dropOffDistrictId) {
        List<Location> pickUpLocations = locationService.findLocationsByDistrictId(pickUpDistrictId);
        List<Location> dropOffLocations = locationService.findLocationsByDistrictId(dropOffDistrictId);
        List<PickUpDropOff> pickUps = pickUpDropOffService.findPickUpsAndDropOffsByLocationId(List<>)
                List<PickUpDropOff> dropOffs =



    }
}
