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
public class Background extends ScreenObject  {
    
    ScreenManager sm;
    
    Image j, j1, c, c1, c2, sl, sl1, e;
  //  int dx;
    
  //  int s = 0 ;
    int i;
    int st = 1;
//    int a = 9600;
    
    /// a == xl    s == xl2
    
    /// dx == yl
    
    

    public Background(int x, int y, int w, int h, int xl, int xl2, int yl, int yl2, ScreenManager sm) {
        super(x, y, w, h, xl, xl2, yl, yl2);
        this.sm = sm;
       
        j = sm.parent.getImage(sm.parent.getCodeBase(), "j1.png");
        j1 = sm.parent.getImage(sm.parent.getCodeBase(), "j2.png");
        
        c = sm.parent.getImage(sm.parent.getCodeBase(), "c1.png");
        c1 = sm.parent.getImage(sm.parent.getCodeBase(), "c2.png");
        c2 = sm.parent.getImage(sm.parent.getCodeBase(), "c3.png");
        
        sl = sm.parent.getImage(sm.parent.getCodeBase(), "sl1.png");
        sl1 = sm.parent.getImage(sm.parent.getCodeBase(), "sl2.png");
     //   sl2 = sm.parent.getImage(sm.parent.getCodeBase(), "sl3.png");
        
        e = sm.parent.getImage(sm.parent.getCodeBase(), "end2.png");
       
       
     
    }
    
    public void move(){
        
        x -= yl;
        xl -= yl;
        
        if(xl <= 0)
            yl = 0;
        
        if(x <= 0 && x >= -3200)
            xl2 = 0;
        
        else if(x < -3200 && x >= -7600)
            xl2 = 1;
        
        else if(x < -7600 && x >= -12800)
            xl2 = 2;
        
        if(xl % 1600 == 0 && sm.ended == false){
            sm.parent.time.add();
       //    sm.parent.showStatus("Level " + st);
        //    st ++;
        
        }
    }
    

    @Override
    public void draw(Graphics g) {
        
       g.drawImage(j, x, y, w, h, sm.parent);
       g.drawImage(j1,1600 + x, y, w, h, sm.parent);
       
       g.drawImage(c, 1600*2+ x, y, w, h, sm.parent);
       g.drawImage(c1, 1600*3+ x, y, w, h, sm.parent);
       g.drawImage(c2, 1600*4+x, y, w, h, sm.parent);
       
       g.drawImage(sl,1600*5+ x, y, w, h, sm.parent);
       g.drawImage(sl1,1600*6+ x, y, w, h, sm.parent);
       
       g.drawImage(e,1600*7+ x, y, w, h, sm.parent);
      
     
    }
    
}
