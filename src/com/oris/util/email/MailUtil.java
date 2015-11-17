package com.oris.util.email;

import java.io.UnsupportedEncodingException;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public final class MailUtil {
	private static Logger log = Logger.getLogger(MailUtil.class);
    public static final String ADDRESS_DELIM = "[;,][\\s]*";
                                                          
    public static final String MULTIPART_TYPE_ALTERNATIVE = "alternative";
    public static final String MULTIPART_TYPE_MIXED = "mixed";
    public static final String TEXT_HTML = "text/html;charset=\"UTF-8\"";
    public static final String TEXT_PLAIN = "text/plain;charset=\"UTF-8\"";
    
    private MailUtil() {
    }

    public static String genMsgId(Object o) {
        return "evc-" + System.currentTimeMillis();
    }

    public static InternetAddress toInetAddress(String str) {
        InternetAddress address = null;
        if (!StringUtils.isEmpty(str)) {
            try {
                address = new InternetAddress(str);
            } catch (AddressException e) {

            	log.warn("Failed to convert String to InternetAddress: " + str, e);
                address = null;
            }
        }
        return address;
    }
    
    public static InternetAddress toInetAddress(String str, String personalName) {
        InternetAddress address = null;
        if (!StringUtils.isEmpty(str)) {
            try {
                address = new InternetAddress(str, personalName);
            }  catch (UnsupportedEncodingException e) {
            	log.warn("Failed to convert String to InternetAddress: " + str, e);
                 address = null;
			}
        }
        return address;
    }

    public static InternetAddress[] toInetAddresses(String[] strs) {
        if (strs == null) {
            return new InternetAddress[0];
        }

        InternetAddress[] inetAddresses = new InternetAddress[strs.length];
        for (int i = 0; i < strs.length; i++) {
            inetAddresses[i] = toInetAddress(strs[i]);
        }
        return inetAddresses;
    }

    public static InternetAddress[] toInetAddresses(String str) {
        if (str == null) {
            return new InternetAddress[0];
        }
        
        return toInetAddresses(str.split(ADDRESS_DELIM));
    }
}