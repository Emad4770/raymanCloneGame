/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bobby;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Emad47
 */

public abstract class ScreenObject {
    
    int x;
    int y;
    int w;
    int h;
    int xl; 
    int xl2;
    int yl; 
    int yl2;
   
    
    public ScreenObject(int x, int y, int w, int h, int xl, int xl2, int yl, int yl2){
        
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.xl = xl;
        this.xl2 = xl2;
        this.yl = yl;
        this.yl2 = yl2;
        
        
    }
    
    public abstract void draw(Graphics g);
    
}
