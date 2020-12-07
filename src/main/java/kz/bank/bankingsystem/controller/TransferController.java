package kz.bank.bankingsystem.controller;

import io.swagger.annotations.Api;
import kz.bank.bankingsystem.model.Transfer;
import kz.bank.bankingsystem.DTO.TransferDTO;
import kz.bank.bankingsystem.service.ITransferService;
import kz.bank.bankingsystem.service.impl.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/transfers")
public class TransferController {

    @Autowired
    ITransferService transferService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Transfer> getAllTransfers() {
        return transferService.getAllTransfers();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Transfer createTransfer(@RequestBody TransferDTO transfer) {
        return transferService.createTranser(transfer);
    }

    @RequestMapping(value = "/get/sender", method = RequestMethod.GET)
    public List<Transfer> getBySenderId(@RequestParam Long senderId) {
        return transferService.getAllTransfersBySenderId(senderId);
    }

    @RequestMapping(value = "/get/receiver", method = RequestMethod.GET)
    public List<Transfer> getByReceiverId(@RequestParam Long receiverId) {
        return transferService.getAllTransfersByReceiverId(receiverId);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<Transfer> getByReceiverAndSenderId(@RequestParam Long senderId, @RequestParam Long receiverId) {
        return transferService.getAllTransfersBySenderAndReceiverId(senderId, receiverId);
    }

    @RequestMapping(value = "/get/amount", method = RequestMethod.GET)
    public List<Transfer> getByAmount(@RequestParam Long amount,Long senderId) {
        return transferService.getAllTransfersByAmount(amount,senderId);
    }

    @RequestMapping(value = "/get/dateAfter", method = RequestMethod.GET)
    public List<Transfer> getByDateAfter(@RequestParam String date) throws ParseException {
        return transferService.getAllTransfersByDateAfter(date);
    }

    @RequestMapping(value = "/get/dateBefore", method = RequestMethod.GET)
    public List<Transfer> getByDateBefore(@RequestParam String date) throws ParseException {
        return transferService.getAllTransfersByDateBefore(date);
    }

    @RequestMapping(value = "/get/receiverAndDate",method = RequestMethod.GET)
    public List<Transfer> getByReceiverAndDate(@RequestParam String date,@RequestParam Long receiverId) throws ParseException {
        return transferService.getAllTransfersByDateAndReceiver(date,receiverId);
    }

    @RequestMapping(value = "/all/{id}", method = RequestMethod.DELETE)
    public void deleteTransfer(@PathVariable(name = "id") Long id) {
        transferService.deleteTransferById(id);
    }

}
