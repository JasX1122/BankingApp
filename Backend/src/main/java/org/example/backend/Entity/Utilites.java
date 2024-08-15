package org.example.backend.Entity;

import jakarta.validation.constraints.PastOrPresent;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDateTime;

@Document(collection = "Utilities")
public class Utilites {
    @Id
    private Integer UID;
    private UtilityType BillType;
    @FutureOrPresent
    private LocalDateTime DueDate;
    private UBStatus Status;
    @DocumentReference
    private Account AccountID;
    @PastOrPresent
    private LocalDateTime PaymentDate;

    public Integer getUID() {
        return UID;
    }

    public void setUID(Integer UID) {
        this.UID = UID;
    }

    public UtilityType getBillType() {
        return BillType;
    }

    public void setBillType(UtilityType billType) {
        BillType = billType;
    }

    public LocalDateTime getDueDate() {
        return DueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        DueDate = dueDate;
    }

    public UBStatus getStatus() {
        return Status;
    }

    public void setStatus(UBStatus status) {
        Status = status;
    }

    public Account getAccountID() {
        return AccountID;
    }

    public void setAccountID(Account accountID) {
        AccountID = accountID;
    }

    public LocalDateTime getPaymentDate() {
        return PaymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        PaymentDate = paymentDate;
    }
}
