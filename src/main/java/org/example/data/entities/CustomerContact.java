package org.example.data.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerContact extends Audit implements Serializable {
    private static final Long serialVersionUID = 109l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerContactId;

    @Lob
    private String contactInfo;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @OneToOne
    @JoinColumn(name="customerId")
    private Customer customer;




}
