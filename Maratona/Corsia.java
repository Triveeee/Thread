package Maratona;

import java.awt.*;

import javax.swing.*;

public class Corsia extends JPanel implements Runnable {

    private String nome;
    private Color colore;
    private boolean no_exit;
    private int lunghezza;
    private int x;
    private int y;
    private Thread t;

    public Corsia(String nome){
        this.nome = nome;
        no_exit =  true;
        lunghezza = 500;
        colore = this.RandomColor();
        x = 0;
        y = 0;


        t = new Thread(this , nome);
        t.start();

    }

    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);
        g.setColor(colore);
        g.fillOval(x, y, 50, 50);

    }
    public int getOvalX() {
        return(x);
    }

    public String getNome(){
        return(nome);
    }
    public void stop(){
        no_exit = false;
    }
    public void AddX(){
        int incremento = (int) (Math.random() * 10 - 1) + 1;
        x = x + incremento;
    }

    public Color RandomColor(){
        int r = (int) (Math.random() * 255 - 1) + 1;
        int g = (int) (Math.random() * 255 - 1) + 1;
        int b = (int) (Math.random() * 255 - 1) + 1;

        return(new Color(r , g , b));
    }


    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println(lunghezza);
        while(no_exit){
            try {
                if(x >= (this.lunghezza - 60)){
                    no_exit = false;
                }
                AddX();
                Thread.sleep(100);
                repaint();

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
    }
    
}
