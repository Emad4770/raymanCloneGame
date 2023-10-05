/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bobby;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author Emad47
 */
public class Ground extends ScreenObject implements Runnable{
    
    ScreenManager sm;
  //  int dx;
    boolean  done = true;
    int type;
    Image m;
    
    /// dx == xl

    public Ground(int x, int y, int w, int h, int xl, int xl2, int yl, int yl2, ScreenManager sm, int type) {
        super(x, y, w, h, xl, xl2, yl, yl2);
        this.sm = sm;
      //  this.dx = dx;
        this.type = type;

        
        m = sm.parent.getImage(sm.parent.getCodeBase(), "lvl.png");
        
        Thread t = new Thread(this);
        t.start();
    }

    
    public void move(){
        
        x -= xl;
        if(sm.parent.bc.xl <= 0)
            xl =0;
       
        
    }
    
    
    
    @Override
    public void draw(Graphics g) {
        
        if(type == 0){
        
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x, y, w, h);
        }
        
        if(type == 1)
            g.drawImage(m, x, y, w, h, sm.parent);
        
        
        
    }

    @Override
    public void run() {
       
        while(done == true && sm.parent.paused == false){
            
          movelevel();
          
            
            try{
                
                Thread.sleep(25);
                
            }catch(Exception e){}
            
        }
        
        
        
    }
    
    boolean p = false;
    
    public void movelevel(){
        
        if(type == 1){
        
       if(p == false)
            y --;
        if(y == yl)
            p = true;
        
        if(p == true && y >= yl )
            y ++;
        
        if(y == yl2 && p == true)
            p = false;
        
        }
        
    }
    
    
   
    
}
