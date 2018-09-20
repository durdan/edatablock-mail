package com.edatablock.rpa.email;

import com.edatablock.rpa.email.domain.EmailMessages;
import com.edatablock.rpa.email.messaging.EmailMessageSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
public class SpringJmsApplicationTest {

    @Autowired
    private EmailMessageSender sender;


    @Test
    public void testReceive() throws Exception {
        EmailMessages email= new EmailMessages();
        email.setEmailBody("test Body");
        email.setReceiveFrom("durgesh@email.com");

        sender.sendQueue(email);


    }
}
