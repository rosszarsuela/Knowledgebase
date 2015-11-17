package com.oris.email.template;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.oris.mis.model.Users;
import com.oris.util.Config;
import com.oris.util.StrUtil;
import com.oris.util.email.template.EmailTemplate;

@SuppressWarnings("serial")
public class UserRegistrationEmailTemplate extends EmailTemplate {

	private Users user;

	public static final String USER_FNAME = "FIRST_NAME";
	public static final String USER_USERNAME = "USER_USERNAME";
	public static final String USER_PASSWORD = "USER_PASSWORD";
	
	@Override
	public String fetchBody(){
		String body = getBody();
        body = StrUtil.replaceAll(body, USER_FNAME, StrUtil.asStr(getUser().getFirstName()));
        body = StrUtil.replaceAll(body, USER_USERNAME, StrUtil.asStr(getUser().getUsername()));
        body = StrUtil.replaceAll(body, USER_PASSWORD, getUser().getConfirmPassword());
        return body;
	}
	
	public static UserRegistrationEmailTemplate newTemplate(String toEmail, Users user) throws FileNotFoundException, IOException{
		
		UserRegistrationEmailTemplate t = new UserRegistrationEmailTemplate();
		t.setUser(user);
		t.setTo(new String[] { toEmail });
        t.setCc(null);
        t.setBcc(null);
        t.setFrom(Config.getProperties("email.from"));
        t.setSubject(Config.getProperties("guarantee_letter.email.subject"));
        t.setHtmlFormat(true);
        t.setBody(Config.getProperties("test.email.body"));
        t.setSenderName(Config.getProperties("email.from.name"));
        
		return t;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
}
