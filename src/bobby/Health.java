/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bobby;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JOptionPane;

/**
 *
 * @author Emad47
 */
public class Health extends ScreenObject{
    
    
    ScreenManager sm;
    Image h1,h2,h3,h4,h5;
    boolean a = true;
    boolean canDie = true;
    long now, last;

    public Health(int x, int y, int w, int h, int xl, int xl2, int yl, int yl2, ScreenManager sm) {
        super(x, y, w, h, xl, xl2, yl, yl2);
        this.sm = sm;
        xl = 4;
        
        h1 = sm.parent.getImage(sm.parent.getCodeBase(), "h1.png");
        h2 = sm.parent.getImage(sm.parent.getCodeBase(), "h2.png");
        h3 = sm.parent.getImage(sm.parent.getCodeBase(), "h3.png");
        h4 = sm.parent.getImage(sm.parent.getCodeBase(), "h4.png");
        h5 = sm.parent.getImage(sm.parent.getCodeBase(), "h5.png");

    }
    
    
    public void dechealth(){
        
        now = System.currentTimeMillis();
        
    if( now - last > 2000){

        sm.parent.time.dectime();
        if(xl >= 0)
        xl --;
        
        if( xl < 0){
            JOptionPane.showMessageDialog(null, "Game Over", "You Lost!", JOptionPane.INFORMATION_MESSAGE);
        sm.parent.removeKeyListener(sm.parent);
        sm.removeSO(sm.parent.bob);
        System.exit(0);
        }
        
        last = now;
     }
        
}
    
    
        public void hcheat(){
            
            xl = 4;
            
        }
        
    

    @Override
    public void draw(Graphics g) {
        
        
        
        switch(xl){
            
            case 4:
                g.drawImage(h1, x, y, w, h, sm.parent);
                break;
            case 3:
                g.drawImage(h2, x, y, w, h, sm.parent);
                break;
            case 2:
                g.drawImage(h3, x, y, w, h, sm.parent);
                break;
            case 1:
                g.drawImage(h4, x, y, w, h, sm.parent);
                break;
            case 0:
                g.drawImage(h5, x, y, w, h, sm.parent);
                break;
                
                
        }
        
    }
    
    
}
