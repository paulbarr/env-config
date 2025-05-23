package com.acme.common;

public class ConfigWatcher extends Thread {
  @Override
  public void run() {
      while(true) {
          // keep doing what this thread should do.
          System.out.println("Thread is Running");

          try {
              Thread.sleep(3000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
  }
}

// public class ConfigWatcher extends Thread {
//     private volatile boolean stop = false;

//     public void setStop(boolean stop) {
//         this.stop = stop;
//     }

//     public boolean getStop() {
//         return this.stop;
//     }
    
//     @Override
//     public void run() {
//         while(!stop) {
//             // keep doing what this thread should do.
//             System.out.println("Thread is Running");
  
//             try {
//                 Thread.sleep(3000);
//             } catch (InterruptedException e) {
//                 e.printStackTrace();
//             }
//         }
//     }
// }
