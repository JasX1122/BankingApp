package org.example.backend.Entity;

import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jdk.jfr.BooleanFlag;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
@Setter
@Getter
@Document(collection = "Transactions")
public class Transaction {
    @Id
    private String transactionID;
    @Positive
    private Double amount;
    private TransactionType tXType;
    @PastOrPresent
    private LocalDateTime TransactionDate;
    private String transactionDescription;
    @BooleanFlag
    private TransactionStatus tXStatus;
    private String accountId;


}
