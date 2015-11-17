package com.oris.util.email.template;

import com.oris.mis.model.Users;
import com.oris.util.Config;
import com.oris.util.StrUtil;

public class UserForgotPasswordTemplate extends EmailTemplate {

	private static final long serialVersionUID = 3256150413695721751L;
	private static final String NAME_OF_USER = "NAME_OF_USER";
	private static final String USER_NAME = "USER_NAME";
	private static final String ENCRYPTED_LINK = "ENCRYPTED_LINK";

	protected Users user;
	private String encryptedLink;
	
	public Users getUser(){return user;}
	public void setUser(Users user){this.user = user;}
	
	public String getEncryptedLink() {return encryptedLink;}
	public void setEncryptedLink(String encryptedLink) {this.encryptedLink = encryptedLink;}

	
	public static UserForgotPasswordTemplate newTemplate(Users user,String encryptedLink){
		UserForgotPasswordTemplate t = new UserForgotPasswordTemplate();
		
		t.setTo(new String[] { user.getEmail() });
		t.setCc(null);
		t.setBcc(null);
		t.setHtmlFormat(true);
		t.setFrom(Config.getProperties("email.from"));
		t.setSenderName(Config.getProperties("emai.from.name"));
		t.setSubject(Config.getProperties("email.forgot.subject"));
		t.setBody(Config.getProperties("email.forgot.body"));
		t.setUser(user);
		t.setEncryptedLink(encryptedLink);
		return t;
	}
	
	@Override
	public String fetchBody() {
		body = getBody();

		body = StrUtil.replaceAll(body, NAME_OF_USER, StrUtil.asStr(getUser().getCompleteName()));
		body = StrUtil.replaceAll(body, USER_NAME, StrUtil.asStr(getUser().getUsername()));
		body = StrUtil.replaceAll(body, ENCRYPTED_LINK, StrUtil.asStr(getEncryptedLink()));
		
		return body;
	}

	
	
}
