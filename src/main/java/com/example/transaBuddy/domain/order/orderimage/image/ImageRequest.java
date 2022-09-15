package com.example.transaBuddy.domain.order.orderimage.image;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageRequest {
    private Integer orderId;
    private String base64;
    private String type;
}
