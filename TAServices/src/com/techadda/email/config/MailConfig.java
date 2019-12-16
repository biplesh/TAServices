package com.techadda.email.config;


import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@ComponentScan
@Configuration

public class MailConfig {
 
    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        //mailSender.setHost("10.50.0.183");
        mailSender.setPort(587);
        //mailSender.setPort(25);
 
        mailSender.setUsername("ordinateurcleaner@gmail.com");
        mailSender.setPassword("Stream95");
        /*mailSender.setUsername("info@itstechadda.co.in");
        mailSender.setPassword("26#Jul2019");*/
        mailSender.setDefaultEncoding("UTF-8");
 
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
 
        return mailSender;
    }

}
