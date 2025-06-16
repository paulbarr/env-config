package com.acme.common;

import java.util.Hashtable;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.Cookie;

import com.ibm.websphere.security.WSSecurityHelper;

public class EnvConfig {

  private String adminApiEndpoint = "unknown";

  public static void saveCookie() throws Exception {
    Cookie ltpaCookie = WSSecurityHelper.getLTPACookieFromSSOToken();
    //Now save down the cookie to appropriate storage

  }

  private void setAdminApiEndpoint() {
    adminApiEndpoint = "http://theserver:1234/app-admin";
  }

  private void startWatcher() {
    ConfigWatcher watcher = new ConfigWatcher();
    watcher.start();
    try {
        Thread.sleep(9000); 
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    System.out.println("Stop the Thread");
    watcher.stop();
  }

  public EnvConfig() throws Exception {
    setAdminApiEndpoint();
    startWatcher();
  }
}
