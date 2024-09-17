package africa.semicolon.com.quagga.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {
    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl sendEmail = new JavaMailSenderImpl();
        sendEmail.setHost("smtp.gmail.com");
        sendEmail.setPort(587);
        sendEmail.setUsername("sulaimabaliqis@gmail.com");
        sendEmail.setPassword("tuii smve cvti apin");

        Properties props = sendEmail.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return sendEmail;
    }

}
