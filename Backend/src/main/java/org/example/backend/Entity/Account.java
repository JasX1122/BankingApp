package org.example.backend.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter
@Setter
@Document(collection = "Accounts")
public class Account {

    @Id
    private String id;
    @Size(min = 6, max = 6)
    private Integer accountNumber;
    @NotEmpty
    private String accountType;
    @Positive
    private Double balance;
    @NotEmpty
    private String clientID;



    public String toString(){
        return accountNumber + " " + accountType + " " + balance+ " " + clientID;
    }
}
