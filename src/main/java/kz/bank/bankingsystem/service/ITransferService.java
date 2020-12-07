package kz.bank.bankingsystem.service;

import kz.bank.bankingsystem.model.Transfer;
import kz.bank.bankingsystem.DTO.TransferDTO;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;


public interface ITransferService {
    Transfer createTranser(TransferDTO transferDTO);
    void deleteTransfer(Transfer transfer);
    void deleteTransferById(Long id);
    List<Transfer> getAllTransfers();
    List<Transfer> getAllTransfersBySenderId(Long id);
    List<Transfer> getAllTransfersByReceiverId(Long id);
    List<Transfer> getAllTransfersBySenderAndReceiverId(Long senderId,Long receiverId);
    List<Transfer> getAllTransfersByDateAfter(String date) throws ParseException;
    List<Transfer> getAllTransfersByDateBefore(String date) throws ParseException;
    List<Transfer> getAllTransfersByDateAndReceiver(String date,Long id) throws ParseException;
    List<Transfer> getAllTransfersByAmount(Long amount,Long id);
}
