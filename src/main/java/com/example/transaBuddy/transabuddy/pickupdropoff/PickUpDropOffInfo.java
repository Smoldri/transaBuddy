package com.example.transaBuddy.transabuddy.pickupdropoff;

import lombok.Data;

import java.io.Serializable;

@Data
public class PickUpDropOffInfo implements Serializable {
    private Integer pickUpDropOffId;
    private Integer orderId;
    private Integer locationId;
    private String type;

}
