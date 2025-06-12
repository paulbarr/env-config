package com.acme.common;

public class EnvConfig {

  private String adminApiEndpoint = "unknown";

  public static String configureEnvDiscovery() {

    String serverEnv = "";

    serverEnv += com.ibm.websphere.runtime.ServerName.getDisplayName();
    serverEnv += com.ibm.websphere.runtime.ServerName.getFullName();

    return serverEnv;
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

  public EnvConfig() {
    setAdminApiEndpoint();
    configureEnvDiscovery();
    startWatcher();
  }
}
