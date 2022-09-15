package com.example.transaBuddy.domain.order.image;

import com.example.transaBuddy.transabuddy.image.OrderImageInfo;
import com.example.transaBuddy.domain.order.image.imageorder.OrderImageService;
import com.example.transaBuddy.transabuddy.image.ImageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class ImageService {
    @Resource
    private ImageRepository imageRepository;
    @Resource
    private OrderImageService orderImageService;


    public void addPictureToOrder(ImageRequest request) {
        Image image = new Image();
        System.out.println();
        byte[] base64AsByteArray = request.getBase64().getBytes(StandardCharsets.UTF_8);
        image.setBase64(base64AsByteArray);
        imageRepository.save(image);
        imageRepository.findById(image.getId());
        orderImageService.addPictureToOrder(request, image);

    }

    public List<OrderImageInfo> getImagesByOrderIdAndType(Integer orderId, String type) {
        return orderImageService.getImagesByOrderIdAndType(orderId, type);
    }
}
