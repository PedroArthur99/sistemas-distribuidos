package sd.userproducer.controller.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class UserDTO {

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;
}
