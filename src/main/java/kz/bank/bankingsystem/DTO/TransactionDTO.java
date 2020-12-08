package kz.bank.bankingsystem.DTO;

import lombok.Data;

@Data
public class TransactionDTO {
    private Long payerId;

    private Long amount;

    private String type;

    private String value;

    private Long commission;
}
