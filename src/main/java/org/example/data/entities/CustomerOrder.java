package org.example.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
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
