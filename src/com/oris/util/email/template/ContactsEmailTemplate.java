package com.oris.util.email.template;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.apache.commons.lang.StringUtils;

import com.oris.util.email.MailUtil;


public abstract class ContactsEmailTemplate implements MessageTemplate {
	private static final long serialVersionUID = 9004230446439743815L;

	protected String from;
	protected String too;
	
    protected String[] cc;
    protected String[] bcc;

    protected String toAsDelimStr;
    protected String ccAsDelimStr;
    protected String bccAsDelimStr;

    protected String subject;
    protected String body;
    protected boolean htmlFormat;

    protected String senderName;

    protected SimpleDateFormat excelFmtMMddyyyy = new SimpleDateFormat("MM/dd/yyyy");
    
	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	
    protected ContactsEmailTemplate() {
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
  
    public String getToo() {
		return too;
	}

	public void setToo(String too) {
		this.too = too;
	}

	public String[] getCc() {
        return cc;
    }

    public void setCc(String[] cc) {
        this.cc = cc;
    }

    public String[] getBcc() {
        return bcc;
    }

    public void setBcc(String[] bcc) {
        this.bcc = bcc;
    }

    public String getToAsDelimStr() {
        return toAsDelimStr;
    }

    public void setToAsDelimStr(String toAsDelimStr) {
        this.toAsDelimStr = toAsDelimStr;
    }

    public String getCcAsDelimStr() {
        return ccAsDelimStr;
    }

    public void setCcAsDelimStr(String ccAsDelimStr) {
        this.ccAsDelimStr = ccAsDelimStr;
    }

    public String getBccAsDelimStr() {
        return bccAsDelimStr;
    }

    public void setBccAsDelimStr(String bccAsDelimStr) {
        this.bccAsDelimStr = bccAsDelimStr;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isHtmlFormat() {
        return htmlFormat;
    }

    public void setHtmlFormat(boolean htmlFormat) {
        this.htmlFormat = htmlFormat;
    }
    
    public String[] fetchCc() {
        return fetchAddresses(getCc(), getCcAsDelimStr());
    }

    public String[] fetchBcc() {
        return fetchAddresses(getBcc(), getBccAsDelimStr());
    }

    public String fetchBody() {
        return getBody();
    }

    protected String[] fetchAddresses(String[] addressArr, String addressAsDelimStr) {
        if (addressArr != null && addressArr.length > 0) {
            return addressArr;
        } else if (addressAsDelimStr != null && StringUtils.isEmpty(addressAsDelimStr)) {
            return addressAsDelimStr.split(MailUtil.ADDRESS_DELIM);
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "AbstractEmailTemplate{"
            + "from='" + from + "'"
            + ", to=" + too + "'"
            + ", cc=" + (cc == null ? null : Arrays.asList(cc))
            + ", bcc=" + (bcc == null ? null : Arrays.asList(bcc))
            + ", ccAsDelimStr='" + ccAsDelimStr + "'"
            + ", bccAsDelimStr='" + bccAsDelimStr + "'"
            + ", subject='" + subject + "'"
            + ", body='" + body + "'"
            + ", htmlFormat=" + htmlFormat
            + "}";
    }
}