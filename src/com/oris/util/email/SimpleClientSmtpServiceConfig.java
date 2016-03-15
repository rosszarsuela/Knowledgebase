package com.oris.util.email;


public class SimpleClientSmtpServiceConfig implements ServiceConfig {
	private static final long serialVersionUID = -1739122814308365404L;
	protected String protocol;
    protected String host;
    protected int port;
    protected String username;
    protected String password;
    protected boolean sslEnable;
    protected boolean reqsAuth;
    protected boolean startTls;

    public SimpleClientSmtpServiceConfig() {
    	/*this.protocol   = Config.getProperties("mail.protocol");
        this.host = Config.getProperties("mail.host");
        this.port = StrUtil.asInt(Config.getProperties("mail.port"));
        this.username = Config.getProperties("mail.username");
        this.password = Config.getProperties("mail.password");
        this.sslEnable = StrUtil.asBool(Config.getProperties("mail.sslEnable"), false);
        this.reqsAuth = StrUtil.asBool(Config.getProperties("mail.regAuth"), false);
        this.startTls = StrUtil.asBool(Config.getProperties("mail.starttls"), false);*/
    }

    public SimpleClientSmtpServiceConfig(String host, String username, String password) {
        this.host = host;
        this.username = username;
        this.password = password;
    }

    public SimpleClientSmtpServiceConfig(String protocol, String host, int port, String username, 
    		String password, boolean sslEnable, boolean reqsAuth, boolean startTls) {
        this.protocol = protocol;
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.sslEnable = sslEnable;
        this.reqsAuth = reqsAuth;
        this.startTls = startTls;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSslEnable() {
        return sslEnable;
    }

    public void setSslEnable(boolean sslEnable) {
        this.sslEnable = sslEnable;
    }

    public boolean isReqsAuth() {
        return reqsAuth;
    }

    public void setReqsAuth(boolean reqsAuth) {
        this.reqsAuth = reqsAuth;
    }
    
    public boolean isStartTls() {
		return startTls;
	}

	public void setStartTls(boolean startTls) {
		this.startTls = startTls;
	}

	@Override
    public String toString() {
        return "SimpleClientSmtpServiceConfig{"
            + "protocol='" + protocol + "'"
            + ", host='" + host + "'"
            + ", port=" + port
            + ", username='" + username + "'"
//            + ", password='" + password + "'"
            + ", sslEnable=" + sslEnable
            + ", reqsAuth=" + reqsAuth
            + "}";
    }
}