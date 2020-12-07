package kz.bank.bankingsystem.service;

import kz.bank.bankingsystem.model.Transaction;
import kz.bank.bankingsystem.model.TransactionType;

import java.util.List;

public interface ITransactionService {
    Transaction createTransaction(Transaction transaction);

    void deleteTransaction(Long id);

    List<Transaction> getTransactionsByType(TransactionType transactionType,Long id);

    Transaction getById(Long id);

    List<Transaction> getUserTransactions(Long id);
}
