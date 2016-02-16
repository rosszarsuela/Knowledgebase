package com.oris.util.email.template;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import javax.activation.DataSource;

import org.apache.commons.lang.StringUtils;

import com.oris.mis.model.Client;
import com.oris.util.email.MailUtil;


public abstract class ClientEmailTemplate implements MessageTemplate {
	private static final long serialVersionUID = 9004230446439743815L;

	protected String from;

    protected String[] to;
    protected String[] cc;
    protected String[] bcc;

    protected String toAsDelimStr;
    protected String ccAsDelimStr;
    protected String bccAsDelimStr;

    protected String replyTo;
    protected String subject;
    protected String body;
    protected boolean htmlFormat;

    private DataSource dataSource;
    protected File[] attachments;
    protected String[] attachmentsPath;
    protected String attachmentsPathAsDelimStr;
    private byte[] picture;

    protected String senderName;

    protected SimpleDateFormat excelFmtMMddyyyy = new SimpleDateFormat("MM/dd/yyyy");
    
	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	
    protected ClientEmailTemplate() {
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String[] getTo() {
        return to;
    }

    public void setTo(String[] to) {
        this.to = to;
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

    public String getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(String replyTo) {
        this.replyTo = replyTo;
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
    
    public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

    public File[] getAttachments() {
        return attachments;
    }

    public void setAttachments(File[] attachments) {
        this.attachments = attachments;
    }

    public String[] getAttachmentsPath() {
        return attachmentsPath;
    }

    public void setAttachmentsPath(String[] attachmentsPath) {
        this.attachmentsPath = attachmentsPath;
    }

    public String getAttachmentsPathAsDelimStr() {
        return attachmentsPathAsDelimStr;
    }

    public void setAttachmentsPathAsDelimStr(String attachmentsPathAsDelimStr) {
        this.attachmentsPathAsDelimStr = attachmentsPathAsDelimStr;
    }

    public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public String[] fetchTo() {
        return fetchAddresses(getTo(), getToAsDelimStr());
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
            + ", to=" + (to == null ? null : Arrays.asList(to))
            + ", cc=" + (cc == null ? null : Arrays.asList(cc))
            + ", bcc=" + (bcc == null ? null : Arrays.asList(bcc))
            + ", toAsDelimStr='" + toAsDelimStr + "'"
            + ", ccAsDelimStr='" + ccAsDelimStr + "'"
            + ", bccAsDelimStr='" + bccAsDelimStr + "'"
            + ", replyTo='" + replyTo + "'"
            + ", subject='" + subject + "'"
            + ", body='" + body + "'"
            + ", htmlFormat=" + htmlFormat
            + ", attachments=" + (attachments == null ? null : Arrays.asList(attachments))
            + ", attachmentsPath=" + (attachmentsPath == null ? null : Arrays.asList(attachmentsPath))
            + ", attachmentsPathAsDelimStr='" + attachmentsPathAsDelimStr + "'"
            + "}";
    }

	
}