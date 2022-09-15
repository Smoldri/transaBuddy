package com.example.transaBuddy.domain.order.orderimage.image;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;

@Service
public class ImageService {
    @Resource
    private ImageRepository imageRepository;


    public void addPictureToOrder(ImageRequest request) {
        Image image = new Image();
        System.out.println();
        byte[] base64AsByteArray = request.getBase64().getBytes(StandardCharsets.UTF_8);
        image.setBase64(base64AsByteArray);
        imageRepository.save(image);
        imageRepository.findById(image.getId());


    }
}
