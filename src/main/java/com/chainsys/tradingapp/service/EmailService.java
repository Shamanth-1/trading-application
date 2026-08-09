package com.chainsys.tradingapp.service;

import java.io.IOException;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

 
  
    private JavaMailSender mailSender;
    @Autowired
    public EmailService(JavaMailSender mailSender) {
    	this.mailSender=mailSender;
    }
  
    public void sendWelcomeEmail(String toEmail, String subject) throws MessagingException, IOException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        helper.setTo(toEmail);
        helper.setSubject(subject);
        helper.setFrom("raagaudioaudition@gmail.com");

        // Read HTML content from file
        String htmlContent = """
        		<html>
        		<body>

        		<h1>Welcome to ChainTrade!</h1>

        		<p>Your account has been successfully created.</p>

        		<p>Thank you for joining our trading platform.</p>

        		</body>
        		</html>
        		""";

        helper.setText(htmlContent, true);

      

        mailSender.send(message);
    }
    public void sendOrderConfirmation(String to, String username, String productName,String type, int quantity) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        String htmlContent = "<html><body>" +
                "<h1>Hello, " + username + "!</h1>" +
                "<p>Your "+type +" order for " + quantity + " units of " + productName + " has been successfully processed.</p>" +
                "<p>Thank you for trading with us.</p>" +
                "</body></html>";

        helper.setTo(to);
        helper.setSubject("Order Confirmation");
        helper.setText(htmlContent, true);

        mailSender.send(message);
    }
}
