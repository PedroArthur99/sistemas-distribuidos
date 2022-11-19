package sdusers.mailservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import sdusers.mailservice.controller.dto.UserDTO;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
public class MailSenderService {

    @Value("mail.username")
    String username;

    @Value("mail.password")
    String password;

    String host = "smtp.gmail.com";

    public void sendMail(UserDTO userDTO) {
        Properties prop = new Properties();
        prop.put("mail.smtp.host", this.host);
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("pedro15cg66@gmail.com", "bqdvxovqzjwwtmsb");
            }
        });

        session.setDebug(true);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(this.username));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(userDTO.getEmail()));
            message.setSubject("Aviso de cadastro de email");
            message.setText("Olá, " + userDTO.getName() + ". Passando pra informar que seu email já está cadastrado na nossa base");

            System.out.println("sending...");
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }


    }
}
