package com.usersservice.sd.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.usersservice.sd.client.UserMailFeignClient;
import com.usersservice.sd.model.UserModel;
import com.usersservice.sd.repository.UserRepository;
import io.awspring.cloud.messaging.listener.SqsMessageDeletionPolicy;
import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserListener {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMailFeignClient userMailFeignClient;

    @SqsListener(value = "${cloud.aws.queue.sqs-create-user}", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void listenMessage(UserModel model) {
        this.userRepository.save(model);
        this.userMailFeignClient.sendEmail(model);
    }
}
