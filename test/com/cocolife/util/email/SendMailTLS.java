package com.cocolife.util.email;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.cocolife.util.email.template.TestEmailTemplate;
import com.oris.util.Config;
import com.oris.util.email.MessageService;
import com.oris.util.email.SimpleSmtpMessageService;
import com.oris.util.email.SimpleSmtpServiceConfig;
import com.oris.util.email.template.MessageTemplate;
 
public class SendMailTLS {
	static Config config = new Config();
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		Properties emailConfig = new Properties();
		
		emailConfig.load(new FileInputStream("C:/Users/debilitas/Documents/Project Oris/workspace/Oris/src/email.properties"));
		
		config.setProperties(emailConfig);
 
		
		SimpleSmtpServiceConfig smtpConfig = new SimpleSmtpServiceConfig("smtp", "smtp.gmail.com", 587, "devism41l@gmail.com","testingprotocol", false, true, true);
		MessageService mailService = new SimpleSmtpMessageService();
		mailService.setConfig(smtpConfig);
		
		MessageTemplate template = null;
		
		String email[] = config.getProperties("event.email.to").split(",");
		
		for(String toEmail : email) {
			template = TestEmailTemplate.newTemplate(toEmail, toEmail);
			mailService.sendMessage(template);
		}
	}
}