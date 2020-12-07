package kz.bank.bankingsystem.service.impl;

import kz.bank.bankingsystem.model.Transfer;
import kz.bank.bankingsystem.DTO.TransferDTO;
import kz.bank.bankingsystem.model.User;
import kz.bank.bankingsystem.repository.TransferRepo;
import kz.bank.bankingsystem.repository.UserRepo;
import kz.bank.bankingsystem.service.ITransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class TransferService implements ITransferService {

    @Autowired
    private TransferRepo transferRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public Transfer createTranser(TransferDTO transferDTO) {
        Transfer transfer=new Transfer();
        User sender=userRepo.getById(transferDTO.getSenderId());
        User receiver=userRepo.getById(transferDTO.getReceiverId());
        BigInteger amount = sender.getAmount().subtract(BigInteger.valueOf(transferDTO.getAmount()));
        sender.setAmount(amount);
        amount=receiver.getAmount().add(BigInteger.valueOf(transferDTO.getAmount()));
        receiver.setAmount(amount);
        transfer.setDate(new Date());
        transfer.setAmount(transferDTO.getAmount());
        transfer.setReceiver(sender);
        transfer.setSender(receiver);
        return transferRepo.save(transfer);
    }

    @Override
    public void deleteTransfer(Transfer transfer) {
        transferRepo.delete(transfer);
    }

    @Override
    public void deleteTransferById(Long id) {
        transferRepo.delete(transferRepo.getById(id));
    }

    @Override
    public List<Transfer> getAllTransfers() {
        return transferRepo.findAll();
    }

    @Override
    public List<Transfer> getAllTransfersBySenderId(Long id) {
        return transferRepo.findAllBySenderId(id);
    }

    @Override
    public List<Transfer> getAllTransfersByReceiverId(Long id) {
        return transferRepo.findAllByReceiverId(id);
    }

    @Override
    public List<Transfer> getAllTransfersBySenderAndReceiverId(Long senderId, Long receiverId) {
        return transferRepo.findAllByReceiverIdAndSenderId(receiverId,senderId);
    }

    @Override
    public List<Transfer> getAllTransfersByDateAfter(String date) throws ParseException {
        Date parsedDate=new SimpleDateFormat("dd.MM.yyyy").parse(date);

        return transferRepo.findAllByDateAfter(parsedDate);
    }

    @Override
    public List<Transfer> getAllTransfersByDateBefore(String date) throws ParseException {
        Date parsedDate=new SimpleDateFormat("dd.MM.yyyy").parse(date);
        return transferRepo.findAllByDateBefore(parsedDate);
    }

    @Override
    public List<Transfer> getAllTransfersByDateAndReceiver(String  date, Long id) throws ParseException {
        Date parsedDate=new SimpleDateFormat("dd.MM.yyyy").parse(date);
        return transferRepo.findAllByReceiverIdAndDateEquals(id, parsedDate);
    }

    @Override
    public List<Transfer> getAllTransfersByAmount(Long amount,Long id) {
        return transferRepo.findAllByAmountAndSenderId(amount,id);
    }
}
