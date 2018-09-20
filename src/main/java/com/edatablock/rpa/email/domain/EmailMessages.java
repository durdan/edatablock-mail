package com.edatablock.rpa.email.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A EmailMessages.
 */

public class EmailMessages implements Serializable {

    private static final long serialVersionUID = 1L;


    private String messageId;

    private String emailSubject;


    private String emailBody;

    private String status;

    private String receiveFrom;


    private Instant receivedTime;


    private Integer numberOfAttachments;

    private String attachments;




    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailBody() {
        return emailBody;
    }

    public void setEmailBody(String emailBody) {
        this.emailBody = emailBody;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReceiveFrom() {
        return receiveFrom;
    }

    public void setReceiveFrom(String receiveFrom) {
        this.receiveFrom = receiveFrom;
    }

    public Instant getReceivedTime() {
        return receivedTime;
    }

    public void setReceivedTime(Instant receivedTime) {
        this.receivedTime = receivedTime;
    }

    public Integer getNumberOfAttachments() {
        return numberOfAttachments;
    }

    public void setNumberOfAttachments(Integer numberOfAttachments) {
        this.numberOfAttachments = numberOfAttachments;
    }

    public String getAttachments() {
        return attachments;
    }

    public void setAttachments(String attachments) {
        this.attachments = attachments;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmailMessages)) return false;
        EmailMessages that = (EmailMessages) o;
        return Objects.equals(getMessageId(), that.getMessageId()) &&
                Objects.equals(getEmailSubject(), that.getEmailSubject()) &&
                Objects.equals(getEmailBody(), that.getEmailBody()) &&
                Objects.equals(getStatus(), that.getStatus()) &&
                Objects.equals(getReceiveFrom(), that.getReceiveFrom()) &&
                Objects.equals(getReceivedTime(), that.getReceivedTime()) &&
                Objects.equals(getNumberOfAttachments(), that.getNumberOfAttachments()) &&
                Objects.equals(getAttachments(), that.getAttachments());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getMessageId(), getEmailSubject(), getEmailBody(), getStatus(), getReceiveFrom(), getReceivedTime(), getNumberOfAttachments(), getAttachments());
    }

}
