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
public class Stone extends ScreenObject{

    int dx;
    Image wood, stone;
    ScreenManager sm;
    int type;
    
    public Stone(int x, int y, int w, int h, int xl, int xl2, int yl, int yl2, ScreenManager sm, int dx, int type) {
        super(x, y, w, h, xl, xl2, yl, yl2);
        this.dx = dx;
        this.sm = sm;
        this.type = type;
        
        stone = sm.parent.getImage(sm.parent.getCodeBase(), "stone.png");
    }
    
    
     
    public void move(){
        
        x -= dx;
         
    }
    
   
    

    @Override
    public void draw(Graphics g) {

            g.drawImage(stone, x, y, w, h, sm.parent);
    }
    
}
