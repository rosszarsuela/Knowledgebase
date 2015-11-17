package com.cocolife.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.oris.mis.model.Users;
import com.oris.util.EncryptionUtil;

public class ForgotPasswordUtilTest {

	EncryptionUtil fp = EncryptionUtil.getInstance();
	Users user;
	Integer forgotPassCount = 1;
	String encrypted = "BLOAyzk-z5o";
	
	@Test
	public void shouldEncrypt() throws Exception{
		user = new Users();
		user.setUsername("jobo");
		assertEquals(encrypted,fp.encrypt(user,forgotPassCount));
	}
	
	@Test
	public void shouldDecrypt() throws Exception{
		user = new Users();
		user.setUsername("jobo");
		assertEquals("jobo"+forgotPassCount,fp.decrypt(encrypted));
	}
	
	
}
