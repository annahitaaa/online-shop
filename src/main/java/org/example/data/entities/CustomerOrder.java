package org.example.data.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerOrder extends Audit implements Serializable {
    private static final Long serialVersionUID = 108l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerOrderId;

    @OneToOne
    @JoinColumn(name="cartId")
    private Cart cart;

    @OneToOne
    @JoinColumn(name = "cutomerId")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "shippingAddressID")
    private ShippingAddress shippingAddress;

    @OneToOne
    @JoinColumn(name="billingAddressID")
    private BillingAddress billingAddress;

}
