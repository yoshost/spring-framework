package com.yma.jpasample.ambedded;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "orders")
public class Order {

    //Composition
    @EmbeddedId
    private OrderID orderID;

    @Embedded
    private Address address;

    private String orderDetails;
}
