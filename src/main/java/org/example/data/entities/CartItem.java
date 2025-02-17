package org.example.data.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItem extends Audit implements Serializable {
    private static final Long serialVersionUID = 107l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartItemId;

    @ManyToOne
    @JoinColumn(name="cartId")
    private Cart cart;


    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;


    private double totalPrice;
    private int quantity;



}
