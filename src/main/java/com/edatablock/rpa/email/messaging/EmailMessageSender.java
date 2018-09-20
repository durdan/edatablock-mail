package com.edatablock.rpa.email.messaging;

import com.edatablock.rpa.email.domain.EmailMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import static com.edatablock.rpa.email.config.ActiveMQConfig.MESSAGE_QUEUE;

@Component
public class EmailMessageSender {



    private static Logger log = LoggerFactory.getLogger(EmailMessageSender.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendQueue(EmailMessages emailmessage) {
        log.info("sending with convertAndSend() to queue <" + emailmessage + ">");
        jmsTemplate.convertAndSend(MESSAGE_QUEUE, emailmessage);
    }

}
