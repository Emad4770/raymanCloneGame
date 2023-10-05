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
public class Character extends ScreenObject implements Runnable{

    public int dx, heli;
    ScreenManager sm;
    boolean k = false;
    Thread animator;
    Image r1, r2, l1, l2, f1, f2, fl1, fl2, ht;
     boolean r, l, jmpd;
     Background bc;
     //int a = 11850;
     int yp = 300 , yd  = 900;
             
     
     
    
    public Character(int x, int y, int w, int h, int xl, int xl2, int yl, int yl2, int dx, ScreenManager sm) {
        
        super(x, y, w, h, xl, xl2, yl, yl2);
        this.dx = dx;
        this.sm = sm;
       
        yd = sm.parent.getHeight();
       
        r1 = sm.parent.getImage(sm.parent.getCodeBase(), "r1.png");
        r2 = sm.parent.getImage(sm.parent.getCodeBase(), "r2.png");
        l1 = sm.parent.getImage(sm.parent.getCodeBase(), "l1.png");
        l2 = sm.parent.getImage(sm.parent.getCodeBase(), "l2.png");
        fl1 = sm.parent.getImage(sm.parent.getCodeBase(), "fl1.png");
        fl2 = sm.parent.getImage(sm.parent.getCodeBase(), "fl2.png");
        f1 = sm.parent.getImage(sm.parent.getCodeBase(), "f1.png");
        f2 = sm.parent.getImage(sm.parent.getCodeBase(), "f2.png");
      //  ht = sm.parent.getImage(sm.parent.getCodeBase(), "hited.png");
        
    }

    
    public void right(){
        
    
        if(x + w  <= sm.parent.getWidth()/2 || sm.parent.bc.xl <= 0 && x + w + dx <= sm.parent.getWidth())
            x += dx;
        
    }
    
    public void left(){
        
        if (x - dx > 0)
            x -= dx;
        
    }
    

    @Override
    public void draw(Graphics g) {
        
        
        if(sm.parent.s == 1 && k == false){
        
            animator = new Thread(this);
            animator.start();
            k = true;
        }
        
        heli = 1+ (int)(2* Math.random());
        
        
       
        switch(sm.parent.s1){
            
            
            case 1:
                
                if(r && jmpd == false)
                g.drawImage(r1, x, y, w, h, sm.parent);
                
                if(r == false && jmpd == false)
                   g.drawImage(r2, x, y, w, h, sm.parent);
                
                if(jmpd && heli == 1)
                    g.drawImage(f1, x, y, w, h, sm.parent);
                
                if(jmpd && heli == 2)
                    g.drawImage(f2, x, y, w, h, sm.parent);
                
                break;
         
            case 2:
                
                if(l && jmpd == false)
                g.drawImage(l1, x, y, w, h, sm.parent);
                
                if(l == false && jmpd == false)
                    g.drawImage(l2, x, y, w, h, sm.parent);
                
                if(jmpd && heli == 1)
                    g.drawImage(fl1, x, y, w, h, sm.parent);
                
                if(jmpd && heli == 2)
                    g.drawImage(fl2, x, y, w, h, sm.parent);
              
                
            break;
            
        }
        
    }
    

    @Override
    public void run() {
        
        
        while(done == false){
            
            cycle();
            
            try{
                
                Thread.sleep(5);
                 
            }catch(Exception e){}
            
        }
        
        
        while(done2){
           
            gravity();
            
            try{
                
                Thread.sleep(5);
                 
            }catch(Exception e){}
        
        }
        
        done = false;
        p = false;
        k = false;
        jmpd = false;
        done2 = false;
        gg = false;
        
    }    
    
    boolean p = false;
    boolean done = true;
    boolean done2 = false;
    
    
    public void cycle(){
        
        jmpd = true;
        
        
        if(p == false )
            y --;
        if(y <= yp)
            p = true;
        
      /*  if (x <= sm.parent.gr[5].x + sm.parent.gr[5].w && x + w >= sm.parent.gr[5].x && y + h >= sm.parent.gr[5].y 
                && y <= sm.parent.gr[5].y){
            done = true;
            y = sm.parent.gr[5].y - h + 10;
            
        } */
        
        if(p == true && y >= yp){
            y ++;
            jmpd = true;
       }
        
            
        if((x <= sm.parent.gr[0].x + sm.parent.gr[0].w && x + w >= sm.parent.gr[0].x && y + h >= sm.parent.gr[0].y 
                && y <= sm.parent.gr[0].y + sm.parent.gr[0].h)
                
                || (x <= sm.parent.gr[1].x + sm.parent.gr[1].w && x + w >= sm.parent.gr[1].x && y + h >= sm.parent.gr[1].y 
                && y <= sm.parent.gr[1].y + sm.parent.gr[1].h) 
                
                || (x <= sm.parent.gr[2].x + sm.parent.gr[2].w && x + w >= sm.parent.gr[2].x && y + h >= sm.parent.gr[2].y 
                && y <= sm.parent.gr[2].y + sm.parent.gr[2].h)
                
                || (x <= sm.parent.gr[3].x + sm.parent.gr[3].w && x + w >= sm.parent.gr[3].x && y + h >= sm.parent.gr[3].y 
                && y <= sm.parent.gr[3].y + sm.parent.gr[3].h)
                
                || (x <= sm.parent.gr[4].x + sm.parent.gr[4].w && x + w >= sm.parent.gr[4].x && y + h >= sm.parent.gr[4].y 
                && y <= sm.parent.gr[4].y + sm.parent.gr[4].h)
                
                || (x <= sm.parent.gr[5].x + sm.parent.gr[5].w && x + w >= sm.parent.gr[5].x && y + h >= sm.parent.gr[5].y 
                && y <= sm.parent.gr[5].y + sm.parent.gr[5].h)
                
                || (x <= sm.parent.gr[6].x + sm.parent.gr[6].w && x + w >= sm.parent.gr[6].x && y + h >= sm.parent.gr[6].y 
                && y <= sm.parent.gr[6].y + sm.parent.gr[6].h)
                
                || (x <= sm.parent.gr[7].x + sm.parent.gr[7].w && x + w >= sm.parent.gr[7].x && y + h >= sm.parent.gr[7].y 
                && y <= sm.parent.gr[7].y + sm.parent.gr[7].h)
                
               
                
                ){
            done = true;
            done2 = true;
            jmpd = false;
            yp = y - 250;
            
       
        }
        
    }
    
    boolean gg ;
    
    public void gravity(){
        
        
         if( !(x <= sm.parent.gr[0].x + sm.parent.gr[0].w && x + w >= sm.parent.gr[0].x && y + h >= sm.parent.gr[0].y 
                 && y <= sm.parent.gr[0].y + sm.parent.gr[0].h)
                
                 && !(x <= sm.parent.gr[1].x + sm.parent.gr[1].w && x + w >= sm.parent.gr[1].x && y + h >= sm.parent.gr[1].y 
                 && y <= sm.parent.gr[1].y + sm.parent.gr[1].h) 
                 
                && !(x <= sm.parent.gr[2].x + sm.parent.gr[2].w && x + w >= sm.parent.gr[2].x && y + h >= sm.parent.gr[2].y 
                 && y <= sm.parent.gr[2].y + sm.parent.gr[2].h)
                 
                && !(x <= sm.parent.gr[3].x + sm.parent.gr[3].w && x + w >= sm.parent.gr[3].x && y + h >= sm.parent.gr[3].y 
                && y <= sm.parent.gr[3].y + sm.parent.gr[3].h)
                 
                 && !(x <= sm.parent.gr[4].x + sm.parent.gr[4].w && x + w >= sm.parent.gr[4].x && y + h >= sm.parent.gr[4].y 
                && y <= sm.parent.gr[4].y + sm.parent.gr[4].h)
                 
                && !(x <= sm.parent.gr[5].x + sm.parent.gr[5].w && x + w >= sm.parent.gr[5].x && y + h >= sm.parent.gr[5].y 
                && y <= sm.parent.gr[5].y + sm.parent.gr[5].h)
                 
                 && !(x <= sm.parent.gr[6].x + sm.parent.gr[6].w && x + w >= sm.parent.gr[6].x && y + h >= sm.parent.gr[6].y 
                && y <= sm.parent.gr[6].y + sm.parent.gr[6].h)
                 
                 && !(x <= sm.parent.gr[7].x + sm.parent.gr[7].w && x + w >= sm.parent.gr[7].x && y + h >= sm.parent.gr[7].y 
                && y <= sm.parent.gr[7].y + sm.parent.gr[7].h)
                 
                && y <= yd ){
            
            jmpd = true;
          //  if(sm.mvh < 2){
            y++;
          //  }
            done = false;
            gg = true;
          
        }
         else gg = false;
         
         if((x <= sm.parent.gr[5].x + sm.parent.gr[5].w && x + w >= sm.parent.gr[5].x && y <= sm.parent.gr[5].y + sm.parent.gr[5].h)
                || ( x <= sm.parent.gr[3].x + sm.parent.gr[3].w && x + w >= sm.parent.gr[3].x && y <= sm.parent.gr[3].y + sm.parent.gr[3].h)
                 )
             jmpd = false;
         
    }
   
}
    
           
    

