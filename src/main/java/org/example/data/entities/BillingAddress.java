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
public class BillingAddress extends Audit implements Serializable {

    private static final Long serialVersionUID = 105l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billingAddressId;

    @NotEmpty
    private String city;

    @NotEmpty
    private String zipCode;

    @OneToOne(mappedBy = "billingAddress")
    private Customer customer;
}
