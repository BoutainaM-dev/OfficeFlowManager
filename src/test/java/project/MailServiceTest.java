package project;

import gestion.service.MailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootTest // This annotation loads the Spring context for testing
public class MailServiceTest {
	
    @Autowired
    private MailService mailService;

    @Autowired
    private JavaMailSender javaMailSender;

    @Test // This annotation marks this method as a JUnit test
    public void testSendEmail() {
        // Define email parameters
        String to = "mst.betty2003@gmail.com";
        String subject = "Test Email";
        String text = "This is a test email sent from the MailService.";

        // Send the email
        mailService.sendEmail(to, subject, text);
    }
}
