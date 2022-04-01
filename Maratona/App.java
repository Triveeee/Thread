package Maratona;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame implements Runnable{
    
    private Corsia corsie[] = new Corsia[5];
    private boolean no_exit = true;

    public App(){
        this.setVisible(true);
        this.setSize(500 , 500);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(5 , 0));

        for(int i = 0 ; i < 5 ; i++){
            corsie[i] = new Corsia("Thread[" + i + "]");
            this.add(corsie[i]);
        }

    }
    /*
    public Corsia[] getCorsie(){
        return corsie;
        
    }
    */

    public static void main(String[] args) {
        /*
        App app = new App();
        Corsia corsie[] = app.getCorsie();
        Thread thread[] = new Thread[5];

        for(int i = 0 ; i < 5 ; i++){
            thread[i] = new Thread(corsie[i]);
            thread[i].start();
        }
        */
        Thread t1 = new Thread(new App());
        t1.start();

        
        
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while(no_exit)
            for(int i = 0 ; i < 5 ; i++){
                System.out.println(corsie[i].getOvalX());
                if(corsie[i].getOvalX() >= (500 - 70)){
                    no_exit = false;
                    if(no_exit == false){
                        JOptionPane.showMessageDialog(this, corsie[i].getNome() + " vinto");
                    }
                    break;
                }
            }
    }
}
