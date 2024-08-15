package org.example.backend.Entity;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Size;
@Getter
@Setter
@Document(collection = "Clients")
public class Client {

    @Id
    private String id;  // Changed to camelCase

    @NotEmpty(message = "Required")
    private String firstName;  // Changed to camelCase

    @NotEmpty(message = "Required")
    private String lastName;  // Changed to camelCase

    @Min(18)
    @NotNull(message = "Required Over 18-Years")
    private Integer age;  // Changed to camelCase

    @NotEmpty(message = "Required")
    private String address;  // Changed to camelCase

    @NotEmpty(message = "Required")
    private String city;  // Changed to camelCase

    @Size(min = 6, max = 6)
    @NotEmpty(message = "Required")
    private String zip;  // Changed to camelCase

    @NotEmpty(message = "Required")
    private String country;  // Changed to camelCase

    @Size(min = 10, max = 10)
    @NotEmpty(message = "Required")
    private String phone;  // Changed to camelCase

    @NotEmpty(message = "Mandatory")
    private String accountType;  // Changed to camelCase

    @NotEmpty(message = "Required")
    private String email;  // Changed to camelCase

    @Size(min = 8, max = 20, message = "Must be Minimum 8 & Maximum 20 Characters")
    @NotEmpty(message = "Required")
    private String password;
    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                ", country='" + country + '\'' +
                ", phone='" + phone + '\'' +
                ", accountType='" + accountType + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'';
                };
}
