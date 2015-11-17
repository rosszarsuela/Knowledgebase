package com.cocolife.util.email.template;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.oris.util.Config;
import com.oris.util.StrUtil;
import com.oris.util.email.template.EmailTemplate;

public class TestEmailTemplate extends EmailTemplate{
	private static final long serialVersionUID = -8060471015642887755L;

	public static final String REPLACE_NAME    = "ACCOUNT_NAME";
	
	protected String recipientName;

    private TestEmailTemplate() {
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    @Override
    public String fetchBody() {
        String body = getBody();
        body = StrUtil.replaceAll(body, REPLACE_NAME, StrUtil.asStr(getRecipientName()));

        return body;
    }

    @Override
    public String toString() {
        return super.toString() + " -> TestEmailTemplate{"
            + "recipientName='" + recipientName + "'"
            + "}";
    }

    @SuppressWarnings("static-access")
	public static TestEmailTemplate newTemplate(String toEmail, String recipientName) throws FileNotFoundException, IOException {
    	//DO NOT include this snippet (as well as the throws declaration) is development code. Propertied file is injected by SPRING
    	Config config = new Config();
    	Properties emailConfig = new Properties();
		
		emailConfig.load(new FileInputStream("C:/Users/debilitas/Documents/Project Oris/workspace/Oris/src/email.properties"));
		
		config.setProperties(emailConfig);
		//END
    	
    	TestEmailTemplate t = new TestEmailTemplate();
        t.setTo(new String[] { toEmail });
        t.setCc(null);
        t.setBcc(null);
        t.setFrom(config.getProperties("mail.username"));
        t.setSubject(config.getProperties("event.email.subject"));
        t.setHtmlFormat(true);
        t.setBody(config.getProperties("event.email.body"));

        t.setRecipientName(recipientName);
        t.setSenderName(config.getProperties("email.from.name"));
        return t;
    }
}
