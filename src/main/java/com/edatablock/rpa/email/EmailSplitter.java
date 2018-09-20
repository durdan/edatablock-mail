package com.edatablock.rpa.email;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.integration.annotation.Splitter;
import org.springframework.integration.file.FileHeaders;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;



@Component
public class EmailSplitter {

    private static final Log LOGGER = LogFactory.getLog(EmailSplitter.class);

    @Splitter
    public List<Message<?>> splitIntoMessages(final List<EmailFragment> emailFragments) {

        final List<Message<?>> messages = new ArrayList<Message<?>>();
        LOGGER.info("*****I am outside Splitter*****");
        for (EmailFragment emailFragment : emailFragments) {
            LOGGER.info("*****I am in Splitter*****");
            Message<?> message = MessageBuilder.withPayload(emailFragment.getData())
                    .setHeader(FileHeaders.FILENAME, emailFragment.getFilename())
                    .setHeader("directory", emailFragment.getDirectory())
                    .build();
            messages.add(message);
        }

        return messages;
    }

}
