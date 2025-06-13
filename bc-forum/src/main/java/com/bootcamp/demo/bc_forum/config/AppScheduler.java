package com.bootcamp.demo.bc_forum.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AppScheduler {
  // ! We have 1 thread only, no matter how many tasks you have. Start one task after another task completed.

  // ! 1 Thread ONLY: Start the next execution until the current task completed. 
  // @Scheduled(fixedRate = 5000)  // 5000ms = 5 seconds
  // public void sayHello() throws InterruptedException {
  //   System.out.println("Task A Start:" + System.currentTimeMillis());
  //   Thread.sleep(6000);
  //   System.out.println("Task A End:" + System.currentTimeMillis());
  // }
  
  // ! fixedDelay -> count the waiting thime after the task completed.
  // @Scheduled(fixedDelay = 3000)
  // public void sayGoodbye() throws InterruptedException {
  //   System.out.println("Task B Start:" + System.currentTimeMillis());
  //   Thread.sleep(4000);
  //   System.out.println("Task B End:" + System.currentTimeMillis());
  // } 

  // 0 -> second
  // 0 -> minute
  // 12, 18 -> 12pm and 6pm
  // * -> Day
  // * -> Month
  // MON-FRI -> all weekdays
  @Scheduled(cron = "0 0 12,18 * * MON-FRI", zone = "Asia/Hong_Kong")
  public void hellworld() {
    System.out.println("Hello World !!!");
  }
}
