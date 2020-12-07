package kz.bank.bankingsystem.service.impl;

import kz.bank.bankingsystem.model.Transaction;
import kz.bank.bankingsystem.model.TransactionType;
import kz.bank.bankingsystem.repository.TransactionRepo;
import kz.bank.bankingsystem.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService implements ITransactionService {

    @Autowired
    private TransactionRepo transactionRepo;

    @Override
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepo.save(transaction);
    }

    @Override
    public void deleteTransaction(Long id) {
        transactionRepo.delete(getById(id));
    }

    @Override
    public List<Transaction> getTransactionsByType(TransactionType transactionType, Long id) {
        return transactionRepo.getAllByTransactionTypeAndPayerId(transactionType,id);
    }

    @Override
    public Transaction getById(Long id) {
        return transactionRepo.getById(id);
    }

    @Override
    public List<Transaction> getUserTransactions(Long id) {
        return transactionRepo.getAllByPayerId(id);
    }
}
