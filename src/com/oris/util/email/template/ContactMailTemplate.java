package com.oris.util.email.template;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.activation.DataSource;
import javax.mail.util.ByteArrayDataSource;

import org.apache.commons.lang.StringUtils;

import com.oris.mis.model.Client;
import com.oris.mis.model.Participants;
import com.oris.util.Config;
import com.oris.util.DateUtility;
import com.oris.util.StrUtil;

public class ContactMailTemplate extends EmailTemplate{
	private static final long serialVersionUID = -8060471015642887755L;

	public static final String REPLACE_NAME    		 = "FIRST_NAME";
/*	public static final String REPLACE_EVENT_NAME    = "EVENT_NAME";
	public static final String REPLACE_EVENT_DESC    = "EVENT_DESCRIPTION"; */
/*	public static final String REPLACE_DATE_FROM 	 = "DATE_FROM";
	public static final String REPLACE_DATE_TO 		 = "DATE_TO";
	public static final String REPLACE_EVENT_ID 	 = "EVENT_ID";
	public static final String REPLACE_PARTICIPANT_ID = "PARTICIPANT_ID";*/
		
	protected String recipientName;
/*	protected String eventName;
	protected String eventDesc;
	protected String dateFrom;
	protected String dateTo;
	protected Long eventId;
	protected Long participantId;*/
	
	public ContactMailTemplate() {
		// TODO Auto-generated constructor stub
	}
	/*
	public String getEvent() {
		return eventDesc;
	}

	public String getEventDesc() {
		return eventDesc;
	}
	
	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
*/
	public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }
        
  /*  public String getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	public String getDateTo() {
		return dateTo;
	}

	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}
	
	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public Long getParticipantId() {
		return participantId;
	}

	public void setParticipantId(Long participantId) {
		this.participantId = participantId;
	}
*/
	@Override
    public String fetchBody() {
    	String body = getBody();
    	body = StrUtil.replaceAll(body, REPLACE_NAME, StrUtil.asStr(getRecipientName()));
/*        body = StrUtil.replaceAll(body, REPLACE_EVENT_NAME, StrUtil.asStr(getEventName()));
        body = StrUtil.replaceAll(body, REPLACE_EVENT_DESC, StrUtil.asStr(getEventDesc()));
        body = StrUtil.replaceAll(body, REPLACE_DATE_FROM, StrUtil.asStr(getDateFrom()));
        body = StrUtil.replaceAll(body, REPLACE_DATE_TO, StrUtil.asStr(getDateTo()));
        body = StrUtil.replaceAll(body, REPLACE_EVENT_ID, StrUtil.asStr(String.valueOf(getEventId())));
        body = StrUtil.replaceAll(body, REPLACE_PARTICIPANT_ID, StrUtil.asStr(String.valueOf(getParticipantId())));*/
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
	
	public static ContactMailTemplate newTemplate(String toEmail, Client ci) throws FileNotFoundException, IOException {
		
		ContactMailTemplate t = new ContactMailTemplate();
        t.setTo(new String[] { ci.getEmail() });
        t.setCc(null);
        t.setBcc(null);
        t.setFrom(Config.getProperties("mail.username"));
        t.setSubject(Config.getProperties("event.email.subject"));
        t.setHtmlFormat(true);
        
      /*  if(StringUtils.isEmpty(p.getContentType())) {
        	t.setBody(Config.getProperties("event.email.body"));
        } else {
        	byte[] depositSlip = new byte[(int) p.getPicture().length];
        	t.setPicture(p.getPicture());
        	DataSource dataSource = new ByteArrayDataSource(depositSlip, p.getContentType());
        	t.setDataSource(dataSource);
        	t.setBody(Config.getProperties("event.payment.email.body"));
        }*/
        
        t.setRecipientName(ci.getCompleteName());
   /*     t.setEventName(p.getEvent().getName());
        t.setEventDesc(p.getEvent().getDescription());
        t.setDateFrom(DateUtility.convertDateToStr(p.getEvent().getDateFrom()));
        t.setDateTo(DateUtility.convertDateToStr(p.getEvent().getDateTo()));
        t.setParticipantId(p.getId());
        t.setEventId(p.getEvent().getId());*/
        t.setSenderName(Config.getProperties("email.from.name"));
        return t;
	}
 }

/*public class ContactMailTemplate extends EmailTemplate{
	private static final long serialVersionUID = -8060471015642887755L;

	public static final String REPLACE_NAME      		 = "email.from.name";
	public static final String REPLACE_NAME1    		 = "FIRST_NAME";
	public static final String REPLACE_NAME2    		 = "MIDDLE_NAME";
	public static final String REPLACE_NAME3    		 = "LAST_NAME";
	public static final String REPLACE_EMAIL    		 = "EMAIL";
	public static final String REPLACE_CON    			 = "CONTACT_NO";
	public static final String REPLACE_ALTER    		 = "ALTER_NO";
	public static final String REPLACE_MESS   		 	 = "MESSAGE";
	public static final String REPLACE_DATE_FROM 	 = "DATE_FROM";
	
	protected String recipientName;
	protected String firstName;
	protected String middleName;
	protected String lastName;
	protected String email;
	private Integer contactno;
	private Integer alcontactno;
	protected String message;
	private Date createdDate;
	
	public ContactMailTemplate() {
		// TODO Auto-generated constructor stub
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

	public Integer getContactno() {
		return contactno;
	}

	public void setContactno(Integer contactno) {
		this.contactno = contactno;
	}

	public Integer getAlcontactno() {
		return alcontactno;
	}

	public void setAlcontactno(Integer alcontactno) {
		this.alcontactno = alcontactno;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
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
    	body = StrUtil.replaceAll(body, REPLACE_NAME1, StrUtil.asStr(getFirstName()));
    	body = StrUtil.replaceAll(body, REPLACE_NAME2, StrUtil.asStr(getMiddleName()));
    	body = StrUtil.replaceAll(body, REPLACE_NAME3, StrUtil.asStr(getLastName()));
    	body = StrUtil.replaceAll(body, REPLACE_EMAIL, StrUtil.asStr(getEmail()));
    	body = StrUtil.replaceAll(body, REPLACE_CON, StrUtil.asStr(getContactno()));
    	body = StrUtil.replaceAll(body, REPLACE_ALTER, StrUtil.asStr(getAlcontactno()));
    	body = StrUtil.replaceAll(body, REPLACE_MESS, StrUtil.asStr(getMessage()));
    	body = StrUtil.replaceAll(body, REPLACE_DATE_FROM, StrUtil.asStr(getCreatedDate()));
        
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
	
	public static ContactMailTemplate newTemplate(String toEmail, Client ci) throws FileNotFoundException, IOException {
		
		ContactMailTemplate t = new ContactMailTemplate();
        t.setTo(new String[] { ci.getEmail() });
		t.setEmailTo(Config.getProperties("contact.email.to"));
        t.setCc(null);
        t.setBcc(null);
        t.setFromCi(new String[] { ci.getEmail() });
        t.setFrom(Config.getProperties("mail.username"));
        t.setSubject(Config.getProperties("contact.email.subject"));
        t.setHtmlFormat(true);
        
             
        t.setRecipientName(Config.getProperties("email.from.name"));
        t.setDateFrom(DateUtility.convertDateToStr(ci.getCreatedDate()));
        t.setSenderName(ci.getCompleteName());
        return t;
	}*/

