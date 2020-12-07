package kz.bank.bankingsystem.controller;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kz.bank.bankingsystem.model.Transaction;
import kz.bank.bankingsystem.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
@Tag(name = "Transaction Controller")
public class TransactionController {

    @Autowired
    private ITransactionService iTransactionService;

    @Operation(summary = "Create",description = "Make(Create) Transaction", tags = {"Transaction"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Успешно удалено"),
            @ApiResponse(responseCode = "500",description = "Внутренняя ошибка"),
    })
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return iTransactionService.createTransaction(transaction);
    }

    @Operation(description = "Delete Transaction", tags = {"Transaction"})
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Успешно удалено"),
        @ApiResponse(responseCode = "500",description = "Внутренняя ошибка"),
        @ApiResponse(responseCode = "404",description = "Платеж не найден")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTransaction(@PathVariable(name = "id") Long id) {
        iTransactionService.deleteTransaction(id);
    }


}
