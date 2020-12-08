package kz.bank.bankingsystem.repository;

import kz.bank.bankingsystem.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransferRepo extends JpaRepository<Transfer,Long> {
    Transfer getById(Long id);
    List<Transfer> findAllByDateAfterAndSenderId(Date date,Long senderId);
    List<Transfer> findAllByDateBeforeAndSenderId(Date date, Long senderId);
    List<Transfer> findAllByAmountAndSenderId(Long amount,Long id);
    List<Transfer> findAllByReceiverIdAndDateEqualsAndSenderId(Long id,Date date,Long senderId  );
    List<Transfer> findAllBySenderId(Long id);
    List<Transfer> findAllByReceiverId(Long id);
    List<Transfer> findAllByReceiverIdAndSenderId(Long receiverId,Long senderIde);
}
