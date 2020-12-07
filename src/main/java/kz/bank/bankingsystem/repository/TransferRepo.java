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
    List<Transfer> findAllByAmountAndUserTransferSenderId(Long amount,Long id);
    List<Transfer> findAllByUserTransferReceiverIdAndDateEquals(Long id,Date date);
    List<Transfer> findAllByUserTransferSenderId(Long id);
    List<Transfer> findAllByUserTransferReceiverId(Long id);
    List<Transfer> findAllByUserTransferReceiverIdAndUserTransferSenderId(Long receiverId,Long senderIde);
}
