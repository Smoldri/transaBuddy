package com.example.transaBuddy.domain.order.pickupdropoff;

import com.example.transaBuddy.domain.order.Order;
import com.example.transaBuddy.domain.order.pickupdropoff.location.Location;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "pickup_dropoff")
public class PickUpDropOff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @Column(name = "type", nullable = false, length = 1)
    private String type;

}