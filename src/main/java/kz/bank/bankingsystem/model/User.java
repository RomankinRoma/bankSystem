package kz.bank.bankingsystem.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Data
@Entity
@Table(name = "account")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;

    private String fullname;

    private BigInteger amount;

    private String phoneNumber;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
}
