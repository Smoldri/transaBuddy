package com.example.transaBuddy.domain.order.orderimage.image;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/transabuddy")
public class ImageController {

    @Resource
    private ImageService imageService;

    @PostMapping("/image")
    @Operation(summary = "Add image to order")
    public void addPicture(@RequestBody ImageRequest request){
        imageService.addPictureToOrder(request);
    }

}
