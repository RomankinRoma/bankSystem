package kz.bank.bankingsystem.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class TransferDTO {

    private Long amount;

    private Long senderId;

    private Long receiverId;
}
