package kz.bank.bankingsystem.controller;

import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kz.bank.bankingsystem.DTO.TransactionDTO;
import kz.bank.bankingsystem.model.Transaction;
import kz.bank.bankingsystem.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@Tag(name = "Transaction Controller")
public class TransactionController {

    @Autowired
    private ITransactionService iTransactionService;

    @Operation(summary = "Make(Create) Transaction", tags = {"Transaction"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Успешно удалено"),
            @ApiResponse(responseCode = "500",description = "Внутренняя ошибка"),
    })
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Transaction createTransaction(@RequestBody TransactionDTO transaction) {
        return iTransactionService.createTransaction(transaction);
    }

    @Operation(summary = "Delete Transaction", tags = {"Transaction"})
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Успешно удалено"),
        @ApiResponse(responseCode = "500",description = "Внутренняя ошибка"),
        @ApiResponse(responseCode = "404",description = "Платеж не найден")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTransaction(@PathVariable(name = "id") Long id) {
        iTransactionService.deleteTransaction(id);
    }

    @Operation(summary = "Get User Transactions", tags = {"Transaction"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Платежи найдены"),
            @ApiResponse(responseCode = "500",description = "Внутренняя ошибка"),
            @ApiResponse(responseCode = "404",description = "Платежи не найдены")
    })
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<Transaction> getAllUserTransactions(@RequestParam Long id){
        return iTransactionService.getUserTransactions(id);
    }

    @Operation(summary = "Get User Transactions By Transaction Amount", tags = {"Transaction"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Платежи найдены"),
            @ApiResponse(responseCode = "500",description = "Внутренняя ошибка"),
            @ApiResponse(responseCode = "404",description = "Платежи не найдены")
    })
    @RequestMapping(value = "/all/amount",method = RequestMethod.GET)
    public List<Transaction> getAllUserTransactionByAmount(@RequestParam Long id,@RequestParam Long amount){
        return iTransactionService.getUserTransactionsByAmount(id,amount);
    }

    @Operation(summary = "Get User Transaction", tags = {"Transaction"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Платеж найден"),
            @ApiResponse(responseCode = "500",description = "Внутренняя ошибка"),
            @ApiResponse(responseCode = "404",description = "Платеж не найден")
    })
    @RequestMapping(value = "/all/{id}",method = RequestMethod.GET)
    public Transaction getTransaction(@PathVariable(name = "id") Long id){
        return iTransactionService.getById(id);
    }

    @Operation(summary = "Get User Transactions By Transaction Amount", tags = {"Transaction"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Платежи найдены"),
            @ApiResponse(responseCode = "500",description = "Внутренняя ошибка"),
            @ApiResponse(responseCode = "404",description = "Платежи не найдены")
    })
    @RequestMapping(value = "/all/type",method = RequestMethod.GET)
    public List<Transaction> getAllUserTransactionByType(@RequestParam Long id,@RequestParam String type){
        return iTransactionService.getTransactionsByType(type,id);
    }

}
