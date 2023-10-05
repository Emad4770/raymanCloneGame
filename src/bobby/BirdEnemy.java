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
public class BirdEnemy extends ScreenObject implements Runnable{
    
    int dx, dy, dxx;
    ScreenManager sm;
    Image be;
    boolean isRunning = true;

    public BirdEnemy(int x, int y, int w, int h, int xl, int xl2, int yl, int yl2,int dxx, int dx, int dy, ScreenManager sm) {
        super(x, y, w, h, xl, xl2, yl, yl2);
        
       this.dxx = dxx;
        this.dx = dx;
        this.dy = dy;
        this.sm = sm; 

        
        be = sm.parent.getImage(sm.parent.getCodeBase(), "fly.gif");
    }
    
    
    public void move(){
        
        xl -= dxx;
        xl2 -= dxx;
        x -= dxx;
    }

    @Override
    public void run() {
        
        while(isRunning && sm.parent.paused == false){
            
            if(x + dx + w  > xl2|| x  < xl) dx =- dx;
            
            if(y + dy + h > yl2 || y < yl) dy =- dy;
            
            x += dx;
            y += dy;
            
             
            try{
                Thread.sleep(5);
                
            }catch(Exception e){}
            
        } 
    }
    
    
     @Override
    public void draw(Graphics g) {
        
        g.drawImage(be, x, y, w, h, sm.parent);
        
       
    }
    
    
}
