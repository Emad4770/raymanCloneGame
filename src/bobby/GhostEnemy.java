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
public class GhostEnemy extends ScreenObject implements Runnable{
    
    int dy;
    ScreenManager sm;
    Image gh;
    boolean isRunning = true;
   // int xl, x2l ,yl, y2l;

    public GhostEnemy(int x, int y, int w, int h, int xl, int xl2, int yl, int yl2, int dy, ScreenManager sm) {
        super(x, y, w, h, xl, xl2, yl, yl2);
        
    
      //  this.dx = dx;
        this.dy = dy;
        this.sm = sm; 
     
        
        gh = sm.parent.getImage(sm.parent.getCodeBase(), "ghost.png");
        
        
        
    }
    
    
    public void move(){
        
        x -= xl;
        if(sm.parent.bc.xl <= 0)
            xl = 0;
    }
    
    boolean p;
    
    public void moveup(){
        
        if(p == false)
            y -= dy;
        if(y == -h )
            p = true;
        if(p == true){
            
            y = sm.parent.getHeight();
            p = false;
            
        }
        
    }

    @Override
    public void run() {
        
        while(isRunning && sm.parent.paused == false){
            
            moveup();
             
            try{
                Thread.sleep(4);
                
            }catch(Exception e){}
            
        } 
    }
    
    
     @Override
    public void draw(Graphics g) {
        
        g.drawImage(gh, x, y, w, h, sm.parent);
        
        
       
    }
    
    
}
