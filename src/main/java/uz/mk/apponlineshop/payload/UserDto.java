package uz.mk.apponlineshop.payload;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserDto {

    @NotNull(message = "The name mustn't be empty")
    private String name;

    @NotNull(message = "The phone number  mustn't be empty")
    private String phoneNumber;

    @NotNull(message = "The email  mustn't be empty")
    private String email;

    @NotNull(message = "The street mustn't be empty")
    private String street;


    @NotNull(message = "The homeNumber mustn't be empty")
    private String homeNumber;
}
