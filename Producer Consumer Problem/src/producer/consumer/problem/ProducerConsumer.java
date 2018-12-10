/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producer.consumer.problem;

import java.util.Random;

/**
 *
 * @author belmin
 */
public class ProducerConsumer {

    private Random random = new Random();
    private boolean isProduced = false;
    private int value;
    
    public synchronized void produce() throws InterruptedException{
        if(isProduced) this.wait();
        value = random.nextInt(10);
        System.out.println("Produced: " + value);
        isProduced = true;
        this.notify();
    }
    public synchronized void consume() throws InterruptedException{
        if(!isProduced) this.wait();
        System.out.println("Consumed: " + value);
        isProduced = false;
        this.notify();
    }
}
