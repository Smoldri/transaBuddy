package com.example.transaBuddy.temp;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sender_user_id", nullable = false)
    private User senderUser;

    @Column(name = "receiver_phone_number", nullable = false)
    private String receiverPhoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courier_user_id")
    private User courierUser;

    @Column(name = "delivery_date", nullable = false)
    private LocalDate deliveryDate;

    @Column(name = "from_hour", nullable = false)
    private Integer fromHour;

    @Column(name = "to_hour", nullable = false)
    private Integer toHour;

    @Column(name = "comment", length = 500)
    private String comment;

    @Column(name = "status", nullable = false, length = 1)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "shipment_id", nullable = false)
    private Shipment shipment;

}