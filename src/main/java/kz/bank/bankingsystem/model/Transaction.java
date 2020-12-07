package kz.bank.bankingsystem.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private Date createdDate;

    @ManyToOne
    private User payer;

    private Long amount;

    private Long commission;

    private TransactionType transactionType;

    private String value;
}
