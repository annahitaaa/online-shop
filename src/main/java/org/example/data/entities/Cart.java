package org.example.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart extends Audit implements Serializable {

    private static final Long serialVersionUID = 101l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @OneToOne
    @JoinColumn(name="customerId")
    @JsonIgnore
    private Customer customer;

    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItems;

    private double grandTotal;

}
