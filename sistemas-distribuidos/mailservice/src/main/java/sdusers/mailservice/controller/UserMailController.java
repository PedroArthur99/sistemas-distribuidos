package sdusers.mailservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sdusers.mailservice.controller.dto.UserDTO;
import sdusers.mailservice.service.MailSenderService;

@RestController
@RequestMapping("/email")
public class UserMailController {

    @Autowired
    private MailSenderService mailSenderService;

    @PostMapping
    public void sendEmail(@RequestBody UserDTO userDTO) {
        this.mailSenderService.sendMail(userDTO);
    }
}
