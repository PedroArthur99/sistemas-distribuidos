package com.usersservice.sd.client;

import com.usersservice.sd.model.UserModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "usermail", url = "localhost:8080/email")
public interface UserMailFeignClient {

    @PostMapping
    void sendEmail(@RequestBody UserModel userModel);
}
