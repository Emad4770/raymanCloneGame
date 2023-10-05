/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bobby;

import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author Emad47
 */
public class BasicEnemy extends ScreenObject implements Runnable{
    
    ScreenManager sm;
    int dx;
    Image old, ma;
    boolean end = false, done = true;
    int type;
    int y2;

   

    public BasicEnemy(int x, int y, int w, int h, int xl, int xl2, int yl, int yl2, int dx, ScreenManager sm, int type) {
        super(x, y, w, h, xl, xl2, yl, yl2);
        
        this.dx = dx;
        this.sm = sm;
        this.type = type;
        
        ma = sm.parent.getImage(sm.parent.getCodeBase(), "mari.gif");
        old = sm.parent.getImage(sm.parent.getCodeBase(), "old.gif");
    }
    
    
    public void move(){
        
        xl -= dx;
        xl2 -= dx;
        x -= dx;
    }
    

    
    @Override
    public void draw(Graphics g) {
        
        if(type == 1)
        g.drawImage(old, x, y, w, h, sm.parent);
        
        if(type == 2)
            g.drawImage(ma, x, y, w, h, sm.parent);
        
        
        
        
    }

    @Override
    
    public void run() {
        
        
        
        while (sm.parent.paused == false && done){
            
            moving();
            
            try{
                
                Thread.sleep(17);
                
            }catch(Exception e){}
            
        }
        
       // done = false;
        end = false;
        
    }
    
    
    boolean p;
    
    public void moving(){
      
        /*
       
        if(end == false)
            x -= dx;
        if(x  <= xl2)
            end = true;
        if(end == true ){
            x = xl;
           // move();
            end = false;
        }
        */
        
        
       
       if(p == false)
            x --;
        if(x == xl)
            p = true;
        
        if(p == true && x <= xl2 )
            x ++;
        
        if(x == xl2 && p == true)
            p = false;
        
       
    }
    
}
