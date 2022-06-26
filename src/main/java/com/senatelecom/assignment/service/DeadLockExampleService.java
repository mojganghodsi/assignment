package com.senatelecom.assignment.service;

import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is a demonstration of how NOT to write multi-threaded programs.
 * It is a program that purposely causes deadlock between two threads that
 * are both trying to acquire locks for the same two resources.
 * To avoid this sort of deadlock when locking multiple resources, all threads
 * should always acquire their locks in the same order.
 **/
@Service
public class DeadLockExampleService {

    Logger logger = Logger.getLogger(DeadLockExampleService.class.getName());

    public void runDeadlockExample(){
        final Object resource1 = "resource1";
        final Object resource2 = "resource2";
        Thread t1 = new Thread() {
            public void run() {
                //Lock resource 1
                synchronized(resource1){
                    logger.log( Level.INFO, "Thread 1: locked resource 1");
                    try{
                        Thread.sleep(50);
                    } catch (InterruptedException e) {}

                    synchronized(resource2){
                        logger.log( Level.INFO,"Thread 1: locked resource 2");
                    }
                }
            }
        };
        Thread t2 = new Thread(){
            public void run(){
                synchronized(resource2){
                    logger.log(Level.INFO,"Thread 2: locked resource 2");
                    try{
                        Thread.sleep(50);
                    } catch (InterruptedException e){}
                    synchronized(resource1){
                        logger.log(Level.INFO,"Thread 2: locked resource 1");
                    }
                }
            }
        };
        t1.start();
        t2.start();
    }
}
