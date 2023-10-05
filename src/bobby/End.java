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
public class End extends ScreenObject{
    
    ScreenManager sm;
    Image end;
 //   int dx;

    public End(int x, int y, int w, int h, int xl, int xl2, int yl, int yl2, ScreenManager sm) {
        super(x, y, w, h, xl, xl2, yl, yl2);
        this.sm = sm;
      //  this.dx = dx;
        
       
    }
    
    
      
    public void move(){
        
        x -= xl;
        
        if(sm.parent.bc.xl <= 0)
            xl =0;
    }
    

    @Override
    public void draw(Graphics g) {
        
        g.setColor(Color.red);
        g.fillRect(x, y, w, h);
        
    }
    
}
