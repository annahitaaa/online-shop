package org.example.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
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
    @JoinColumn(name="cutomerId")
    private Customer customer;




}
