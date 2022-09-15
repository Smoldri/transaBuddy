package com.example.transaBuddy.domain.order.orderimage;

import com.example.transaBuddy.domain.order.Order;
import com.example.transaBuddy.domain.order.OrderMapper;
import com.example.transaBuddy.domain.order.OrderRepository;
import com.example.transaBuddy.domain.order.orderimage.image.Image;
import com.example.transaBuddy.domain.order.orderimage.image.ImageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class OrderImageService {
    @Resource
    private OrderRepository orderRepository;
    @Resource
    private OrderImageRepository orderImageRepository;

    public void addSenderPictureToOrder(ImageRequest request, Image image) {
        OrderImage orderImage = new OrderImage();
        orderImage.setType("S");
        orderImage.setImage(image);
        Order order = orderRepository.getReferenceById(request.getOrderId());
        orderImage.setOrder(order);

        orderImageRepository.save(orderImage);

    }
}
