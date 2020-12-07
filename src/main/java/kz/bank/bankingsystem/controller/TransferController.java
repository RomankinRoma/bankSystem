package kz.bank.bankingsystem.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kz.bank.bankingsystem.model.Transfer;
import kz.bank.bankingsystem.DTO.TransferDTO;
import kz.bank.bankingsystem.service.ITransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/transfers")
@Api(value = "TransferController",description = "REST API for Transfer", tags = { "Transfer" })
public class TransferController {

    @Autowired
    private ITransferService transferService;

    @ApiOperation(value="Get All Transfers", tags = { "Transfer" })
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Transfer> getAllTransfers() {
        return transferService.getAllTransfers();
    }


    @ApiOperation(value="Make(Create) Transfer", tags = { "Transfer" })
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Transfer createTransfer(@RequestBody TransferDTO transfer) {
        return transferService.createTranser(transfer);
    }

    @ApiOperation(value="Get User Transfers", tags = { "Transfer" })
    @RequestMapping(value = "/get/sender", method = RequestMethod.GET)
    public List<Transfer> getBySenderId(@RequestParam Long senderId) {
        return transferService.getAllTransfersBySenderId(senderId);
    }
    @ApiOperation(value="Get All User by Receiver", tags = { "Transfer" })
    @RequestMapping(value = "/get/receiver", method = RequestMethod.GET)
    public List<Transfer> getByReceiverId(@RequestParam Long receiverId) {
        return transferService.getAllTransfersByReceiverId(receiverId);
    }

    @ApiOperation(value="Get All User Transfers to Receiver", tags = { "Transfer" })
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<Transfer> getByReceiverAndSenderId(@RequestParam Long senderId, @RequestParam Long receiverId) {
        return transferService.getAllTransfersBySenderAndReceiverId(senderId, receiverId);
    }

    @ApiOperation(value="Get All User Transfers By Amount", tags = { "Transfer" })
    @RequestMapping(value = "/get/amount", method = RequestMethod.GET)
    public List<Transfer> getByAmount(@RequestParam Long amount,Long senderId) {
        return transferService.getAllTransfersByAmount(amount,senderId);
    }

    @ApiOperation(value="Get All User Transfers By Date", tags = { "Transfer" })
    @RequestMapping(value = "/get/dateAfter", method = RequestMethod.GET)
    public List<Transfer> getByDateAfter(@RequestParam String date) throws ParseException {
        return transferService.getAllTransfersByDateAfter(date);
    }

    @ApiOperation(value="Get All User Transfers By Date", tags = { "Transfer" })
    @RequestMapping(value = "/get/dateBefore", method = RequestMethod.GET)
    public List<Transfer> getByDateBefore(@RequestParam String date) throws ParseException {
        return transferService.getAllTransfersByDateBefore(date);
    }

    @ApiOperation(value="Get All User Transfers By Date And Receiver", tags = { "Transfer" })
    @RequestMapping(value = "/get/receiverAndDate",method = RequestMethod.GET)
    public List<Transfer> getByReceiverAndDate(@RequestParam String date,@RequestParam Long receiverId) throws ParseException {
        return transferService.getAllTransfersByDateAndReceiver(date,receiverId);
    }

    @ApiOperation(value="Delete Transfer", tags = { "Transfer" })
    @RequestMapping(value = "/all/{id}", method = RequestMethod.DELETE)
    public void deleteTransfer(@PathVariable(name = "id") Long id) {
        transferService.deleteTransferById(id);
    }

}
