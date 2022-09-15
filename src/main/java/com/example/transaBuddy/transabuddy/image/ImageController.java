package com.example.transaBuddy.transabuddy.image;

import com.example.transaBuddy.domain.order.image.ImageService;
import com.example.transaBuddy.transabuddy.image.orderimage.OrderImageInfo;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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


    @GetMapping("/image")
    @Operation(summary = "Get images by order Id")
    public List<OrderImageInfo> getImagesByOrderIdAndType(Integer orderId, String type){
        return imageService.getImagesByOrderIdAndType(orderId, type);
    }

}
