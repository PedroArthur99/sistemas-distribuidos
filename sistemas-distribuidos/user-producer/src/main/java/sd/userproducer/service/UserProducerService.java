package sd.userproducer.service;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import io.awspring.cloud.messaging.core.QueueMessageChannel;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserProducerService {

    String queueUrl;

    AmazonSQSAsync amazonSqs;

    public UserProducerService(@Autowired AmazonSQSAsync amazonSQSAsync,
                                    @Value("${cloud.aws.queue.sqs-create-user}") String queueUrl) {
        this.queueUrl = queueUrl;
        this.amazonSqs = amazonSQSAsync;
    }

    public void send(String messagePayload) {
        MessageChannel messageChannel = new QueueMessageChannel(amazonSqs, queueUrl);

        Message<String> message = MessageBuilder.withPayload(messagePayload).setHeader("sender", "platform-sso")
                .setHeaderIfAbsent("country", "AE").build();

        long waitTimeoutMillis = 5000;
        messageChannel.send(message, waitTimeoutMillis);
    }
}
