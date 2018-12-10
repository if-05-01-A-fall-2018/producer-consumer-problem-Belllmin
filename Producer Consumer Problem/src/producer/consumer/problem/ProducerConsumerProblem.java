/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producer.consumer.problem;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author belmin
 */
public class ProducerConsumerProblem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ProducerConsumer pc = new ProducerConsumer();
        Thread p = new Thread(new Runnable() {
           
            @Override
            public void run(){
                for (int i = 0; i < 10; i++) {
                    try {
                        pc.produce();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ProducerConsumerProblem.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try{
                        Thread.sleep(3000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ProducerConsumerProblem.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        
        Thread c = new Thread(new Runnable() {
           
            @Override
            public void run(){
                for (int i = 0; i < 10; i++) {
                    try {
                        pc.consume();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ProducerConsumerProblem.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try{
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ProducerConsumerProblem.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        
        p.start();
        c.start();
    }
}
