package com.oris.util.email.template;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.oris.mis.model.Client;
import com.oris.util.Config;
import com.oris.util.StrUtil;

public class ContactEmailTemplate extends ContactsEmailTemplate{
	private static final long serialVersionUID = -8060471015642887755L;

	/*public static final String REPLACE_COMPLETE   		 = "COMPLETE";*/
	public static final String REPLACE_NAME1   		 = "FIRST_NAME";
	public static final String REPLACE_NAME2   		 = "MIDDLE_NAME";
	public static final String REPLACE_NAME3   		 = "LAST_NAME";
	public static final String REPLACE_MESSAGE    		 = "MESSAGE";
	public static final String REPLACE_EMAIL    		 = "EMAIL"; 
	public static final String REPLACE_CLIENT_ID 		 = "CLIENT_ID";
		
	/*protected String complete;*/
	protected String message;
	protected String firstName;
	protected String middleName;
	protected String lastName;
	protected String email;
	protected Long clientId;
	
	public ContactEmailTemplate() {
		// TODO Auto-generated constructor stub
	}
	
	/*public String getComplete() {
		return complete;
	}

	public void setComplete(String complete) {
		this.complete = complete;
	}*/
	
	public String getMessage() {
		return message;
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

	public void setMessage(String message) {
		this.message = message;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
    	/*body = StrUtil.replaceAll(body, REPLACE_COMPLETE, StrUtil.asStr(getComplete()));*/
    	body = StrUtil.replaceAll(body, REPLACE_NAME1, StrUtil.asStr(getFirstName()));
    	body = StrUtil.replaceAll(body, REPLACE_NAME2, StrUtil.asStr(getMiddleName()));
    	body = StrUtil.replaceAll(body, REPLACE_NAME3, StrUtil.asStr(getLastName()));
    	body = StrUtil.replaceAll(body, REPLACE_MESSAGE, StrUtil.asStr(getMessage()));
        body = StrUtil.replaceAll(body, REPLACE_EMAIL, StrUtil.asStr(getEmail()));
        body = StrUtil.replaceAll(body, REPLACE_CLIENT_ID, StrUtil.asStr(String.valueOf(getClientId())));
      
//        String body = getBody();
//        body = StrUtil.replaceAll(body, REPLACE_NAME, StrUtil.asStr(getParticipant().getCompleteName()));
//        body = StrUtil.replaceAll(body, REPLACE_EVENT_NAME, StrUtil.asStr(getParticipant().getEvent()));
//        body = StrUtil.replaceAll(body, REPLACE_EVENT_DESC, StrUtil.asStr(getParticipant().getEvent()));
        

        return body;
    }

//    @Override
//    public String toString() {
//        return super.toString() + " -> EventEmailTemplate{"
//            + "recipientName='" + recipientName + "eventName='" + eventName + "eventDesc='" + eventDesc + "'"
//            + "}";
//    }

    
//	public static EventMailTemplate newTemplate(Participants p) throws FileNotFoundException, IOException {
//    	
//    	EventMailTemplate t = new EventMailTemplate();
//        t.setTo(new String[] { p.getEmail() });
//        t.setCc(null);
//        t.setBcc(null);
//        t.setFrom(Config.getProperties("mail.username"));
//        t.setSubject(Config.getProperties("event.email.subject"));
//        t.setHtmlFormat(true);
//        t.setBody(Config.getProperties("event.email.body"));
//        t.setRecipientName(p.getLastName());
//        t.setSenderName(Config.getProperties("email.from.name"));
//        return t;
//    }
	
	public static ContactEmailTemplate newTemplate(String toEmail, Client ci) throws FileNotFoundException, IOException {
		
		ContactEmailTemplate t = new ContactEmailTemplate();
        /*t.setTo(new String[] { ci.getEmail() });*/
		t.setToo(Config.getProperties("email.from"));
        t.setCc(new String[] { ci.getEmail() });
        t.setFrom(Config.getProperties("mail.username"));
        t.setSubject(Config.getProperties("contact.email.subject"));
        t.setHtmlFormat(true);
        t.setBody(Config.getProperties("contact.email.body"));
        t.setMessage(ci.getMessage());
        t.setFirstName(ci.getfirstName());
        t.setMiddleName(ci.getmiddleName());
        t.setLastName(ci.getlastName());
        t.setEmail(ci.getEmail());
        t.setClientId(ci.getId());
        t.setSenderName(Config.getProperties("email.from.name"));
        return t;
	}
 }
