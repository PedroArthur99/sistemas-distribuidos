package sd.userproducer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sd.userproducer.controller.dto.UserDTO;
import sd.userproducer.service.UserProducerService;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@AllArgsConstructor(onConstructor_ = @Autowired)
@FieldDefaults(level = AccessLevel.PRIVATE)
@CrossOrigin()
public class UserController {

    UserProducerService service;

    @PostMapping
    public void createUser(@RequestBody @Valid UserDTO userDTO) throws JsonProcessingException {
        this.service.send(new ObjectMapper().writeValueAsString(userDTO));
    }
}
