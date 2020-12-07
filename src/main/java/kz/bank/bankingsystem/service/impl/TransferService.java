package kz.bank.bankingsystem.service.impl;

import kz.bank.bankingsystem.model.Transfer;
import kz.bank.bankingsystem.DTO.TransferDTO;
import kz.bank.bankingsystem.model.User;
import kz.bank.bankingsystem.model.UserTransfer;
import kz.bank.bankingsystem.repository.TransferRepo;
import kz.bank.bankingsystem.repository.UserRepo;
import kz.bank.bankingsystem.repository.UserTransferRepo;
import kz.bank.bankingsystem.service.ITransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import static java.lang.Integer.parseInt;

@Service
public class TransferService implements ITransferService {

    @Autowired
    private TransferRepo transferRepo;

    @Autowired
    private UserTransferRepo userTransferRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public Transfer createTranser(TransferDTO transferDTO) {
        Transfer transfer = new Transfer();
        User sender=userRepo.getById(transferDTO.getSenderId());
        User receiver=userRepo.getById(transferDTO.getReceiverId());
        BigInteger amount = sender.getAmount().subtract(BigInteger.valueOf(transferDTO.getAmount()));
        sender.setAmount(amount);
        amount=receiver.getAmount().add(BigInteger.valueOf(transferDTO.getAmount()));
        receiver.setAmount(amount);
        transfer.setDate(new Date());
        transfer.setAmount(transferDTO.getAmount());
        UserTransfer userTransfer = new UserTransfer();
        userTransfer.setReceiver(receiver);
        userTransfer.setSender(sender);
        userTransfer=userTransferRepo.save(userTransfer);
        transfer.setUserTransfer(userTransfer);
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
        return transferRepo.findAllByUserTransferSenderId(id);
    }

    @Override
    public List<Transfer> getAllTransfersByReceiverId(Long id) {
        return transferRepo.findAllByUserTransferReceiverId(id);
    }

    @Override
    public List<Transfer> getAllTransfersBySenderAndReceiverId(Long senderId, Long receiverId) {
        return transferRepo.findAllByUserTransferReceiverIdAndUserTransferSenderId(receiverId,senderId);
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
        return transferRepo.findAllByUserTransferReceiverIdAndDateEquals(id, parsedDate);
    }

    @Override
    public List<Transfer> getAllTransfersByAmount(Long amount,Long id) {
        return transferRepo.findAllByAmountAndUserTransferSenderId(amount,id);
    }
}
