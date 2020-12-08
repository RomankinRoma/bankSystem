package kz.bank.bankingsystem.service;

import kz.bank.bankingsystem.DTO.TransactionDTO;
import kz.bank.bankingsystem.model.Transaction;
import kz.bank.bankingsystem.model.TransactionType;

import java.util.List;

public interface ITransactionService {
    Transaction createTransaction(TransactionDTO transactionDTO);

    void deleteTransaction(Long id);

    List<Transaction> getTransactionsByType(String transactionType,Long id);

    Transaction getById(Long id);

    List<Transaction> getUserTransactions(Long id);

    List<Transaction> getUserTransactionsByAmount(Long id,Long amount);
}
