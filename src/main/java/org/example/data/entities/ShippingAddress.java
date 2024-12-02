package org.example.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShippingAddress extends Audit implements Serializable {
    private static final Long serialVersionUID = 106l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shippingAddressId;

    @NotEmpty
    private String city;

    @NotEmpty
    private String zipCode;

    @OneToOne(mappedBy = "shippingAddress")
    private Customer customer;
}
