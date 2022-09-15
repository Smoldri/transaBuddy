package com.example.transaBuddy.domain.order.orderimage;

import com.example.transaBuddy.domain.order.Order;
import com.example.transaBuddy.domain.order.OrderRepository;
import com.example.transaBuddy.domain.order.orderimage.image.Image;
import com.example.transaBuddy.domain.order.orderimage.image.ImageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Service
public class OrderImageService {
    @Resource
    private OrderRepository orderRepository;
    @Resource
    private OrderImageRepository orderImageRepository;

    public void addPictureToOrder(ImageRequest request, Image image) {
        OrderImage orderImage = new OrderImage();
        orderImage.setImage(image);
        Order order = orderRepository.getReferenceById(request.getOrderId());
        orderImage.setOrder(order);

        if(Objects.equals(request.getType(), "S")){
            orderImage.setType("S");
        } else if (Objects.equals(request.getType(), "D")) {
            orderImage.setType("D");
        } else {
            orderImage.setType("P");
        }

        orderImageRepository.save(orderImage);

    }
}
