package kz.bank.bankingsystem.service.impl;

import kz.bank.bankingsystem.DTO.TransactionDTO;
import kz.bank.bankingsystem.model.Transaction;
import kz.bank.bankingsystem.model.TransactionType;
import kz.bank.bankingsystem.repository.TransactionRepo;
import kz.bank.bankingsystem.repository.UserRepo;
import kz.bank.bankingsystem.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService implements ITransactionService {

    @Autowired
    private TransactionRepo transactionRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public Transaction createTransaction(TransactionDTO transactionDTO) {
        Transaction transaction=new Transaction();
        transaction.setPayer(userRepo.getById(transactionDTO.getPayerId()));
        transaction.setAmount(transactionDTO.getAmount());
        transaction.setValue(transactionDTO.getValue());
        transaction.setCommission(transactionDTO.getCommission());
        transaction.setTransactionType(TransactionType.valueOf(transactionDTO.getType()));
        return transactionRepo.save(transaction);
    }

    @Override
    public void deleteTransaction(Long id) {
        transactionRepo.delete(getById(id));
    }

    @Override
    public List<Transaction> getTransactionsByType(String transactionType, Long id) {
        return transactionRepo.getAllByTransactionTypeAndPayerId(TransactionType.valueOf(transactionType),id);
    }

    @Override
    public Transaction getById(Long id) {
        return transactionRepo.getById(id);
    }

    @Override
    public List<Transaction> getUserTransactions(Long id) {
        return transactionRepo.getAllByPayerId(id);
    }

    @Override
    public List<Transaction> getUserTransactionsByAmount(Long id, Long amount) {
        return transactionRepo.getAllByAmountAndPayerId(amount,id);
    }
}
