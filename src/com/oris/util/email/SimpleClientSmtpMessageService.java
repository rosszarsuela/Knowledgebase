package com.oris.util.email;

import java.util.Date;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oris.util.CollectionsUtil;
import com.oris.util.email.template.ContactsEmailTemplate;
import com.oris.util.email.template.MessageTemplate;

/**
 * 
 * @author Ross Zarsuela
 *
 */

public class SimpleClientSmtpMessageService implements MessageService {

    protected SimpleClientSmtpServiceConfig config;
    
    public static final String SENDER_NAME = "Oris Dental";

    private final transient Logger log = LoggerFactory.getLogger(SimpleClientSmtpMessageService.class);

    public SimpleClientSmtpMessageService() {
        this(new SimpleClientSmtpServiceConfig());
    }


    public SimpleClientSmtpMessageService(SimpleClientSmtpServiceConfig config) {
        setConfig(config);
    }

    public void setConfig(ServiceConfig config) {
        if (!(config instanceof SimpleClientSmtpServiceConfig)) {
            throw new IllegalArgumentException("Parameter config must be of type: " + SimpleClientSmtpServiceConfig.class);
        }
        this.config = (SimpleClientSmtpServiceConfig) config;
    }

    public ServiceConfig getConfig() {
        return config;
    }

	public void sendMessage(MessageTemplate msg) throws MessageServiceException {
    	log.debug("Sending email");
        if (msg == null) {
            log.warn("Cannot send a null email message template.");
            return;
        }

        if (!(msg instanceof ContactsEmailTemplate)) {
            throw new IllegalArgumentException("Message template must be an instance of EmailTemplate. Found: " + msg.getClass());
        }

        ContactsEmailTemplate emailMsg = (ContactsEmailTemplate) msg;

        StopWatch stopWatch = null;
        if (log.isDebugEnabled()) {
            stopWatch = new StopWatch();
            stopWatch.start();
            log.debug("Trying to send an email message: msg=" + msg + "; stopWatch: " + stopWatch.getTime());
        }

        try {
            Session mailSession = Session.getDefaultInstance(toMailProps((SimpleClientSmtpServiceConfig) getConfig()),null);
            Transport transport = mailSession.getTransport();
            
            MimeMessage mimeMsg = toMimeMessage(new MimeMessage(mailSession), emailMsg);

            if (log.isDebugEnabled()) {
                log.debug("mineMessage.from=" + CollectionsUtil.toDelimString(mimeMsg.getFrom(), "; "));
                log.debug("mineMessage.recipients=" + CollectionsUtil.toDelimString(mimeMsg.getAllRecipients(), "; "));
                log.debug("mineMessage.sender=" + mimeMsg.getSender());
                log.debug("mineMessage.sentDate=" + mimeMsg.getSentDate());
                log.debug("mineMessage.subject=" + mimeMsg.getSubject());
            }
            
            transport.connect(mailSession.getProperty("mail.smtp.user"), mailSession.getProperty("mail.smtp.password"));
            transport.sendMessage(mimeMsg, mimeMsg.getRecipients(Message.RecipientType.TO));
            transport.close();
            if (log.isDebugEnabled() && stopWatch != null) {
                stopWatch.stop();
                log.debug("Finish sending email message: msg=" + msg + "; stopWatch: " + stopWatch.getTime());
            }
        } catch (Exception e) {
            log.warn("Failed to send email mesasge. emailTemplate" + msg, e);
            throw new MessageServiceException("Failed to send email message", e, emailMsg.getCc());
        }
    }

    protected Properties toMailProps(SimpleClientSmtpServiceConfig config) {
        if (log.isDebugEnabled()) {
            log.debug("Using SimpleClientSmtpServiceConfig: " + config);
        }

        String protocol = config.getProtocol();

        Properties p = new Properties();
        p.setProperty("mail.transport.protocol", protocol);
        p.setProperty("mail." + protocol + ".host", config.getHost());
        p.setProperty("mail." + protocol + ".port", String.valueOf(config.getPort()));

        if (config.isReqsAuth()) {
            p.setProperty("mail." + protocol + ".auth", "true");
            p.setProperty("mail." + protocol + ".user", config.getUsername());
            p.setProperty("mail." + protocol + ".password", config.getPassword());
        }

        if (config.isSslEnable()) {
            p.setProperty("mail." + protocol + ".socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            p.setProperty("mail." + protocol + ".socketFactory.fallback", "false");
            p.setProperty("mail." + protocol + ".socketFactory.port", String.valueOf(config.getPort()));
        }
        
        if(config.isStartTls()) {
        	p.setProperty("mail." + protocol + ".starttls.enable", String.valueOf(config.isStartTls()));
        }

        return p;
    }

    protected MimeMessage toMimeMessage(MimeMessage msg, ContactsEmailTemplate msgTemplate) {
        try {
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.setHeader("Message-ID", MailUtil.genMsgId(null));
            msg.setSentDate(new Date());
            
            String senderName = StringUtils.isNotEmpty(msgTemplate.getSenderName()) ? msgTemplate.getSenderName() : SENDER_NAME;
           
            msg.setFrom(MailUtil.toInetAddress(msgTemplate.getFrom(), senderName));
            
            msg.setSender(MailUtil.toInetAddress(msgTemplate.getFrom()));
            msg.setRecipients(Message.RecipientType.CC, MailUtil.toInetAddresses(msgTemplate.fetchCc()));
            msg.setRecipients(Message.RecipientType.BCC, MailUtil.toInetAddresses(msgTemplate.fetchBcc()));
            msg.setSubject(msgTemplate.getSubject());
            
            Multipart mp = new MimeMultipart();
            
            BodyPart msgBody = new MimeBodyPart();
            msgBody.setText(msgTemplate.fetchBody());
            
//            if (msgTemplate.isHtmlFormat()) {
//            	msgBody.setContent(msgTemplate.fetchBody(), MailUtil.TEXT_HTML);
//            } else {
//            	msgBody.setContent(msgTemplate.fetchBody(), MailUtil.TEXT_PLAIN);
//            }            
            mp.addBodyPart(msgBody);
            
            msgBody = new MimeBodyPart();
            
//            String filename = "C:\\sample.jpg";
//            DataSource source = new FileDataSource(filename);
//            msgBody.setDataHandler(new DataHandler(source));
 /*           msgBody.setDataHandler(new DataHandler(msgTemplate.getDataSource()));
            msgBody.setFileName("deposit.jpg");
            msgBody.setHeader("Content-ID", "image_id");*/
            mp.addBodyPart(msgBody);
            msg.setContent(mp);
            msg.saveChanges();
            
            return msg;

        } catch (MessagingException e) {
            log.warn("Failed to create mime message from email template. emailTemplate" + msgTemplate, e);
            return null;
        }
    }
}
