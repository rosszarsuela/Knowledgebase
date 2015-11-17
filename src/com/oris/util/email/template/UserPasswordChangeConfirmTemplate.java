package com.oris.util.email.template;

import com.oris.mis.model.Users;
import com.oris.util.Config;
import com.oris.util.StrUtil;

public class UserPasswordChangeConfirmTemplate extends EmailTemplate {

	private static final long serialVersionUID = 7931219319699349934L;
	private static final String NAME_OF_USER = "NAME_OF_USER";
	private static final String USER_NAME = "USER_NAME";
	
	protected Users user;
	
	public Users getUser(){return user;}
	public void setUser(Users user){this.user = user;}
	
	public static UserPasswordChangeConfirmTemplate newTemplate(Users user){
		UserPasswordChangeConfirmTemplate t = new UserPasswordChangeConfirmTemplate();
		t.setTo(new String[] { user.getEmail() });
		t.setCc(null);
		t.setBcc(null);
		t.setHtmlFormat(true);
		t.setFrom(Config.getProperties("email.from"));
		t.setSenderName(Config.getProperties("emai.from.name"));
		t.setSubject(Config.getProperties("email.passwordChange.subject"));
		t.setBody(Config.getProperties("email.passwordChange.body"));
		t.setUser(user);
		return t;
	}
	
	@Override
	public String fetchBody() {
		body = getBody();

		body = StrUtil.replaceAll(body, NAME_OF_USER, StrUtil.asStr(getUser().getCompleteName()));
		body = StrUtil.replaceAll(body, USER_NAME, StrUtil.asStr(getUser().getUsername()));
		return body;
	}
	
}
