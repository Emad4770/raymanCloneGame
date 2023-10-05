/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bobby;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.Timer;

/**
 *
 * @author Emad47
 */
public class Countdown extends ScreenObject implements Runnable{

  //  int t = 3000;
    ScreenManager sm;
    boolean isRunning = true;

  /// xl == t
    
    public Countdown(int x, int y, int w, int h, int xl, int xl2, int yl, int yl2, ScreenManager sm) {
        super(x, y, w, h, xl, xl2, yl, yl2);
        this.sm = sm;
        Thread t = new Thread(this);
        t.start();

    }

    public void dectime(){
        
        xl -= 1000;
        
    }
    
    public void add(){
        xl += 1000;
    }
    
    
    @Override
    public void draw(Graphics g) {
        
        
        g.setColor(Color.YELLOW);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 25)); 
        g.drawString("Timer = " + xl, x, y);
        
     //  t-= 0.4;
        
       
      //  t -= (int)System.currentTimeMillis()/1000000000;
     //   if(t == 0)
        //    t = 1000;
        
         if(sm.parent.paused)
            g.drawImage(sm.parent.m, 0, 0, sm.parent.getWidth(), sm.parent.getHeight(), sm.parent);
        
    }

    @Override
    public void run() {
       
        if(xl <= 0){
            xl = 1000;
            sm.parent.ht.dechealth();
        }
        while(isRunning && sm.parent.paused == false){
            
            if(xl <= 0){
            xl = 1000;
            sm.parent.ht.dechealth();
        }
            
            
            xl -= 10;
            
            try{
                
                Thread.sleep(250);
                
            }catch(Exception e){}
            
            
            
        }
       
    }
    
}
