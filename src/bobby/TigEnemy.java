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
public class TigEnemy extends ScreenObject {
    
    Image e1,hole;
    ScreenManager sm;
    int dx;

    public TigEnemy(int x, int y, int w, int h, int xl, int xl2, int yl, int yl2, ScreenManager sm, int dx) {
        super(x, y, w, h, xl, xl2, yl, yl2);
        this.sm = sm;
        this.dx = dx;
        
        e1 = sm.parent.getImage(sm.parent.getCodeBase(), "e1.png");
        
    }
    
    
    public void move(){
        
        x -= dx;
      
       
    }
    
    

    @Override
    public void draw(Graphics g) {
       
        g.drawImage(e1, x, y, w, h, sm.parent);
       
    }
    
}
