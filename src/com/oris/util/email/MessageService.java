package com.oris.util.email;

import com.oris.util.email.template.MessageTemplate;

public interface MessageService {

    public void setConfig(ServiceConfig config);

    public ServiceConfig getConfig();

    public void sendMessage(MessageTemplate msg) throws MessageServiceException;
}