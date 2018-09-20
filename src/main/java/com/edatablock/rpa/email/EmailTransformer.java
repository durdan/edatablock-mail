package com.edatablock.rpa.email;

import com.edatablock.rpa.email.domain.EmailMessages;
import com.edatablock.rpa.email.messaging.EmailMessageSender;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.Transformer;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



@Component
public class EmailTransformer {

    private static final Log LOGGER = LogFactory.getLog(EmailTransformer.class);

    @Autowired
    private EmailMessageSender recievedMessage;

    @Transformer
    public List<EmailFragment> transformit(javax.mail.Message mailMessage) {
        LOGGER.info(String.format("*********Email contains %s fragments.*******","Test&&&"));
        final List<EmailFragment> emailFragments = new ArrayList<EmailFragment>();

        EmailParserUtils.handleMessage(null, mailMessage, emailFragments);
        List<String> attachments =null;
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(String.format("*********Email contains %s fragments.*******", emailFragments.size()));
        }
        if(!emailFragments.isEmpty()){
            attachments=setAttachment(emailFragments,attachments);
            if(!attachments.isEmpty()){
                LOGGER.info(String.format("*********Attempt to Send to the queue *******"));
                EmailMessages emailMessages= new EmailMessages();

                try {
                    emailMessages.setMessageId(mailMessage.getHeader("Message-ID")[0]);
                    emailMessages.setEmailSubject(mailMessage.getSubject());
                    emailMessages.setReceiveFrom(mailMessage.getFrom()[0].toString());
                    emailMessages.setReceivedTime(mailMessage.getReceivedDate().toInstant());
                    emailMessages.setNumberOfAttachments(attachments.size());
                    Iterator attachmentItr=attachments.iterator();
                    StringBuilder attachmentNames=new StringBuilder();
                    while(attachmentItr.hasNext()){
                        if(attachmentNames.length()>0)
                        {
                            attachmentNames.append(",");
                        }
                        attachmentNames.append(attachmentItr.next());
                    }

                    emailMessages.setAttachments(attachmentNames.toString());
                } catch (MessagingException e) {
                    e.printStackTrace();
                }

                LOGGER.info(String.format("*********Message ******"+emailMessages));
                recievedMessage.sendQueue(emailMessages);
                //receivedEmail/receivedFrom+messageID/content
            }else
            LOGGER.info(String.format("*********Failed to Send to the queue *******"));
        }

        return emailFragments;
    }

    public List<String> setAttachment(List<EmailFragment> emailFragments,List<String> attachments){

        Iterator emailPartsItr= emailFragments.iterator();
        attachments=new ArrayList<>();

//        boolean hasAttachment =false;

        while(emailPartsItr.hasNext()){

            EmailFragment emailFragment= (EmailFragment) emailPartsItr.next();
            if(emailFragment.isHasAttachment()){
//                hasAttachment=true;
                attachments.add(emailFragment.getFilename());
                LOGGER.info(">>>>>>>"+emailFragment.getFilename());

            }

            System.out.println("$$$$$$$$$$$$$$$$$$Inside the attachment check ----");
        }

        return attachments;
    }

}
