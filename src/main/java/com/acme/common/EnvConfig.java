package com.acme.common;

import java.util.Hashtable;

import javax.naming.InitialContext;

public class EnvConfig {

  private String adminApiEndpoint = "unknown";

  public static InitialContext setInitialContextProps() throws Exception {

    Hashtable ht = new Hashtable();

    InitialContext ctx = new InitialContext(ht);
    String name = ctx.getNameInNamespace();
    System.out.println("***** NAME: " + name);
    return ctx;
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
    setInitialContextProps();
    startWatcher();
  }
}
