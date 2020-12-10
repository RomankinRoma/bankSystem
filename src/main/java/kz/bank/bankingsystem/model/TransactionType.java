package kz.bank.bankingsystem.model;

import lombok.ToString;

@ToString
public enum TransactionType {
    ONAY,
    UTIL,
    ESP,
    FINE,
    TAX,
    PHONE
}
