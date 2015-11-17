package com.oris.util.email;
import java.io.IOException;

public class MessageServiceException extends IOException {
	private static final long serialVersionUID = 5467169229464901043L;
	protected Object target;

    public MessageServiceException(Object target) {
        this.target = target;
    }

    public MessageServiceException(String message, Object target) {
        super(message);
        this.target = target;
    }

    public MessageServiceException(String message, Throwable cause, Object target) {
        super(message, cause);
        this.target = target;
    }

    public MessageServiceException(Throwable cause, Object target) {
        super(cause);
        this.target = target;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "MessageServiceException{" +
               "target='" + target + "'" +
               "}";
    }
}