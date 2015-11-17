package com.oris.util;

import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import org.apache.commons.codec.binary.Base64;

import com.oris.mis.model.Users;

public class EncryptionUtil {
	
	private static final String UNICODE_FORMAT = "UTF8";
    public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
    public static final String ENCRYPTION_KEY = "CocolifeCocolifeCocolife";
    private KeySpec ks;
    private SecretKeyFactory skf;
    private Cipher cipher;
    byte[] arrayBytes;
    private String myEncryptionKey;
    private String myEncryptionScheme;
    SecretKey key;
    
    private static EncryptionUtil util;
    
    private EncryptionUtil(){
    	 try {
			myEncryptionKey = ENCRYPTION_KEY; 
			 myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
			 arrayBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
			 ks = new DESedeKeySpec(arrayBytes);
			 skf = SecretKeyFactory.getInstance(myEncryptionScheme);
			 cipher = Cipher.getInstance(myEncryptionScheme);
			 key = skf.generateSecret(ks);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public static synchronized EncryptionUtil getInstance() {
    	if(util == null) util = new EncryptionUtil();
    	return util;
    }
    
	public String encrypt(Users user, Integer count) {
		//username + number of forgotpasswords
		String unencryptedString = user.getUsername()/* + count.toString()*/;
		String encryptedString =  null;
        try {
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] plainText = unencryptedString.getBytes(UNICODE_FORMAT);
            byte[] encryptedText = cipher.doFinal(plainText);
            encryptedString = new String(Base64.encodeBase64URLSafe(encryptedText));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedString;
	}
	
	public String decrypt(String encryptedString) {
        String decryptedText = null;
        try {
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] encryptedText = Base64.decodeBase64(encryptedString);
            byte[] plainText = cipher.doFinal(encryptedText);
            decryptedText= new String(plainText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decryptedText;
    }
	
}
