package com.example.transaBuddy.domain.order.orderimage;

import com.example.transaBuddy.domain.order.Order;
import com.example.transaBuddy.domain.order.OrderRepository;
import com.example.transaBuddy.domain.order.orderimage.image.Image;
import com.example.transaBuddy.domain.order.orderimage.image.ImageRequest;
import com.example.transaBuddy.transabuddy.order.OrderInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class OrderImageService {
    @Resource
    private OrderRepository orderRepository;
    @Resource
    private OrderImageRepository orderImageRepository;
    @Resource
    private OrderImageMapper orderImageMapper;

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

    public List<OrderImageInfo> getImagesByOrderIdAndType(Integer orderId, String type) {
        List<OrderImage> orderImages = orderImageRepository.findImagesByOrderIdAndType(orderId, type);

        return byteImageInfosToBase64(orderImages);
    }

    private List<OrderImageInfo> byteImageInfosToBase64(List<OrderImage> orderImages) {
        List<OrderImageInfo> orderImageInfos = new ArrayList<>();
        for (OrderImage orderImage : orderImages) {
            Integer index = 0;
            byte[] base64AsByteArray = orderImage.getImage().getBase64();
            String string = new String(base64AsByteArray);
            OrderImageInfo orderImageInfo = new OrderImageInfo(string);
            orderImageInfos.add(index, orderImageInfo);

        }
        return orderImageInfos;
    }
}
