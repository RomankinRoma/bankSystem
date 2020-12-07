package kz.bank.bankingsystem.repository;

import kz.bank.bankingsystem.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransferRepo extends JpaRepository<Transfer,Long> {
    Transfer getById(Long id);
    List<Transfer> findAllByDateAfter(Date date);
    List<Transfer> findAllByDateBefore(Date date);
    List<Transfer> findAllByAmountAndSenderId(Long amount,Long id);
    List<Transfer> findAllByReceiverIdAndDateEquals(Long id,Date date);
    List<Transfer> findAllBySenderId(Long id);
    List<Transfer> findAllByReceiverId(Long id);
    List<Transfer> findAllByReceiverIdAndSenderId(Long receiverId,Long senderIde);
}
