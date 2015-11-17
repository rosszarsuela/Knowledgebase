package com.cocolife.scheduler;

import java.util.List;
import java.util.TimerTask;

public class CheckEmailAddresses extends TimerTask {

  private List<String> emailAddresses;
  
  public void setEmailAddresses(List emailAddresses) {
    this.emailAddresses = emailAddresses;
  }
  
  public void run() {
    // iterate over all email addresses and archive them
  }
}