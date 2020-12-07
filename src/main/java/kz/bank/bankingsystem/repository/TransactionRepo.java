package kz.bank.bankingsystem.repository;

import kz.bank.bankingsystem.model.Transaction;
import kz.bank.bankingsystem.model.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction,Long> {
    Transaction getById(Long id);

    List<Transaction> getAllByPayerId(Long id);

    List<Transaction> getAllByTransactionTypeAndPayerId(TransactionType transactionType, Long payer_id);


}

