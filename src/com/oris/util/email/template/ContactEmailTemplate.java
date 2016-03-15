package com.oris.util.email.template;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.oris.mis.model.Client;
import com.oris.util.Config;
import com.oris.util.StrUtil;

public class ContactEmailTemplate extends ClientEmailTemplate{
	private static final long serialVersionUID = -8060471015642887755L;
	
	public static final String REPLACE_MESSAGE	 	 = "MESSAGE";
	public static final String REPLACE_NAME	         = "COMP_NAME";
	public static final String REPLACE_FIRST_NAME	 = "FIRST_NAME";
	public static final String REPLACE_MIDDLE_NAME   = "MIDDLE_NAME";
	public static final String REPLACE_LAST_NAME     = "LAST_NAME"; 
	public static final String REPLACE_EMAIL	     = "EMAIL";
	public static final String REPLACE_CONTACT_NO 	 = "CONTACT_NO";
	public static final String REPLACE_ALTE_NO 	     = "AL_CONTACT_NO";
	public static final String REPLACE_CLIENT_ID 	 = "CLIENT_ID";
		
	protected String recipientName;
	protected String firstName;
	protected String middleName;
	protected String lastName;
	protected String email;
	protected String contactNo;
	protected String alcontactNo;
	protected String message;
	protected Long clientId;
	
	
	public ContactEmailTemplate() {
		// TODO Auto-generated constructor stub
	}
	
	public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }
    
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getAlcontactNo() {
		return alcontactNo;
	}

	public void setAlcontactNo(String alcontactNo) {
		this.alcontactNo = alcontactNo;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	@Override
    public String fetchBody() {
    	String body = getBody();
    	body = StrUtil.replaceAll(body, REPLACE_NAME, StrUtil.asStr(getRecipientName()));
    	body = StrUtil.replaceAll(body, REPLACE_FIRST_NAME, StrUtil.asStr(getFirstName()));
    	body = StrUtil.replaceAll(body, REPLACE_MIDDLE_NAME, StrUtil.asStr(getMiddleName()));
    	body = StrUtil.replaceAll(body, REPLACE_LAST_NAME, StrUtil.asStr(getLastName()));
    	body = StrUtil.replaceAll(body, REPLACE_EMAIL, StrUtil.asStr(getEmail()));
    	body = StrUtil.replaceAll(body, REPLACE_CONTACT_NO, StrUtil.asStr(getContactNo()));
    	body = StrUtil.replaceAll(body, REPLACE_ALTE_NO, StrUtil.asStr(getAlcontactNo()));
    	body = StrUtil.replaceAll(body, REPLACE_MESSAGE, StrUtil.asStr(getMessage()));
    	body = StrUtil.replaceAll(body, REPLACE_CLIENT_ID, StrUtil.asStr(String.valueOf(getClientId())));
        return body;
    }
	
	public static ContactEmailTemplate newTemplate(String toEmail, Client c) throws FileNotFoundException, IOException {
		
//		 t.setRecipientName(p.getCompleteName());
//	        t.setEventName(p.getEvent().getName());
//	        t.setEventDesc(p.getEvent().getDescription());
		
		ContactEmailTemplate t = new ContactEmailTemplate();
        t.setTo(new String[] { c.getEmail() });
		t.setBcc(null);
        t.setFrom(Config.getProperties("mail.username"));
        t.setSubject(Config.getProperties("contact.email.subject"));
        t.setHtmlFormat(true);
        t.setBody(Config.getProperties("contact.email.body"));
        t.setFirstName(c.getfirstName());
        t.setMiddleName(c.getmiddleName());
        t.setLastName(c.getlastName());
        t.setEmail(c.getEmail());
        t.setContactNo(c.getContactNo());
        t.setAlcontactNo(c.getAlcontactNo());
        t.setMessage(c.getMessage());
        t.setRecipientName(c.getCompleteName());
        t.setSenderName(Config.getProperties("email.from.name"));
        return t;
	}

 }
