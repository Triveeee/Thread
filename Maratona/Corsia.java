package Maratona;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Corsia extends JPanel implements Runnable {

    private String nome;
    private int lunghezza;
    private int x;
    private int y;
    private Thread t;

    public Corsia(String nome){
        this.nome = nome;
        lunghezza = 500;
        x = 0;
        y = 0;


        t = new Thread(this , nome);
        t.start();

    }

    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);
        g.fillOval(x, y, 50, 50);

    }
    public int getOvalX() {
        return(x);
    }

    public String getNome(){
        return(nome);
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println(lunghezza);
        while(x <= (this.lunghezza - 70)){
            try {

                x = x + 5;
                Thread.sleep(100);
                repaint();

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
    }
    
}