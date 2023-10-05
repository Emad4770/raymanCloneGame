/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bobby;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emad47
 */
public class ScreenManager extends Thread {
    
    MyGame parent;
    ArrayList<ScreenObject> ol;
    ArrayList<ScreenObject> ol2;
    boolean isRunning = true, up = false;
    boolean onground = true;
    int tigh = 0, enh = 0, birdh = 0, ghh = 0, mvh = 0;
   
    
    
    public ScreenManager(MyGame parent){
        
        this.parent = parent;
        ol = new ArrayList<>();
        ol2 = new ArrayList<>();
        

    }
    
    
    
    public void addSO(ScreenObject so){
        
        ol.add(so);
        ol2.add(so);
    }
    
    
    public void removeSO(ScreenObject so){
        
        ol.remove(so);
        
    }
    
    
     public void draw(Graphics g){
        
        
        Image offImg;
        Graphics offG;
        
        offImg = parent.createImage(parent.getWidth(),parent.getHeight());
        offG = offImg.getGraphics();
        
        offG.setColor(Color.white);
        offG.fillRect(0, 0,parent.getWidth(), parent.getHeight());
        for (int i = 0; i <ol.size(); i++) {
             ol.get(i).draw(offG);
        }
        g.drawImage(offImg, 0, 0, parent);
        
    }
    
     
     
    
    public void run(){
        
        while(isRunning){
            
           checkConflict();
            parent.repaint();
            
            try {
              sleep(2);   
          }
          catch (InterruptedException ex) {
              Logger.getLogger(ScreenManager.class.getName()).log(Level.SEVERE, null, ex);
          }   
        }
    }
    
    
    
    
    public void stopManager(){
        
        isRunning = false;
    }
    
    
    
    
    public void checkConflict(){
        
        
        ArrayList<Character> chl= new ArrayList<Character>();
        ArrayList<BirdEnemy> brel= new ArrayList<BirdEnemy>();
        ArrayList<TigEnemy> tgl= new ArrayList<TigEnemy>();
        ArrayList<BasicEnemy> bal= new ArrayList<BasicEnemy>();
        ArrayList<Stone> hol= new ArrayList<Stone>();
        ArrayList<Health> htl= new ArrayList<Health>();
        ArrayList<Ground> mvl= new ArrayList<Ground>();
        ArrayList<End> ender= new ArrayList<End>();
        ArrayList<GhostEnemy> gl = new ArrayList<GhostEnemy>();
        
        
        Health hth = null;
        Countdown ct = null;
        
        
        for (int i = 0; i < ol.size(); i++) {
            
            ScreenObject so = ol.get(i);

            if(so instanceof Character) chl.add((Character)so);
            if(so instanceof BirdEnemy) brel.add((BirdEnemy)so);
            if(so instanceof BasicEnemy) bal.add((BasicEnemy)so);
            if(so instanceof Stone) hol.add((Stone)so);
            if(so instanceof TigEnemy) tgl.add((TigEnemy)so);
            if(so instanceof Ground) mvl.add((Ground)so);
            if(so instanceof End) ender.add((End)so);
            if(so instanceof GhostEnemy) gl.add((GhostEnemy)so);
            
            if(so instanceof Countdown) ct = (Countdown)so;
            
            if(so instanceof Health) hth = (Health)so;
            
      
           
        }
        
        //// Characte vs tig

          for (int i = 0; i < chl.size(); i++) {
            
            for (int j = 0; j < tgl.size(); j++) {
                
                Character bobc = chl.get(i);
                TigEnemy tig = tgl.get(j);
               
                if (bobc.x + 20 <= tig.x + tig.w && bobc.x + bobc.w >= tig.x
                        && bobc.y + bobc.h >= tig.y  ) {
                    
                 //   if(tigh < 2){
                    hth.dechealth();
                 //   tigh++;
                    bobc.x = (tig.x - 150);
                  //  ct.add();
                 //   }
                    
                   
                }
             
                
            }
        }
        
         //// Character vs bird
        
        for (int i = 0; i < brel.size(); i++) {
            
            for (int j = 0; j < chl.size(); j++) {
                
                BirdEnemy bird =brel.get(i);
                Character bobc = chl.get(j);
               
                

                if (bobc.x <= bird.x + bird.w && bobc.x + bobc.w >= bird.x
                        && bobc.y + bobc.h >= bird.y  && bobc.y < bird.y + bird.h ) {
                    
                    
                //    if(birdh < 2){
                   hth.dechealth();
                 //  birdh ++;
                 //  bobc.x = bird.xl;
                 //  bobc.y = bird.yl;
                //    }
                   
                 //   removeSO(bird);
                   
                   
                   
                 //   ct.add();

                }
                
            }
            
        } 
        
            
            ///// Character vs basic enemy
            
        for (int i = 0; i < chl.size(); i++) {
            
            for (int j = 0; j < bal.size(); j++) {
                
                
                Character bobc = chl.get(i);
                BasicEnemy be = bal.get(j);
               
                if (bobc.x <= be.x + be.w  && bobc.x + bobc.w >= be.x
                        && bobc.y + bobc.h >= be.y  ) {
                    
                 //   if(enh < 2){
                    hth.dechealth();
                //    enh ++;
                  //  bobc.x = be.x - bobc.w - 100;
                //    }
                    
                    
               //     bobc.x = be.x + be.w + 1; 
                    //bobc.y = 200;
                    
                  //  removeSO(be);
                  //  ct.add();
                    
                }
                 
            }
        }
        
        
        
        /// Moving level
        
        
          for (int i = 0; i < chl.size(); i++) {
            
            for (int j = 0; j < mvl.size(); j++) {
                
                Character bobc = chl.get(i);
                Ground mv = mvl.get(j);
                
                
                if (bobc.x <= mv.x + mv.w && bobc.x + bobc.w >= mv.x
                     && bobc.y + bobc.h >= mv.y  && bobc.y <= mv.y + mv.h) {
                    
                  bobc.y = mv.y - bobc.h  ;
                  bobc.jmpd = false;
                  
                   
                }
                else {
                    if(bobc.y >= parent.getHeight()){
                       
                       
                    hth.dechealth();
                  //  mvh ++;
                    bobc.x  = 100;
                    bobc.y = 400;
                    bobc.done2 = true;
                    ct.dectime();
                        
                    
                    
                    }
                    
                }
                
            }
        }
          
          
          //////Charcter vs ghost
          
          
          for (int i = 0; i < gl.size(); i++) {
            
            for (int j = 0; j < chl.size(); j++) {
                
                GhostEnemy gho =gl.get(i);
                Character bobc = chl.get(j);
               
                if (bobc.x <= gho.x + gho.w && bobc.x + bobc.w >= gho.x
                        && bobc.y + bobc.h >= gho.y  && bobc.y < gho.y + gho.h ) {
                    
                 //  if(ghh < 2){
                   hth.dechealth();
                 //  ghh ++;
                 //  }
                   bobc.x  = 100;
                   bobc.y = 300;
                 //  ct.add();
                }
                
            }
            
        }
          
          
          
          ///// endinig
              
        for (int i = 0; i < chl.size(); i++) {
            
            for (int j = 0; j < ender.size(); j++) {
                
                
                Character bobc = chl.get(i);
                End en = ender.get(j);
               
                if (bobc.x <= en.x + en.w  && bobc.x + bobc.w >= en.x
                        && bobc.y + bobc.h >= en.y && bobc.y <= en.y + en.h ) {
                    
                    ending();
                    
                }
                 
            }
        }
          
    }
    
    boolean ended = false;
    
    public void ending(){
        
        parent.gr[7].x = 0;
        parent.bc.x -= 1600;
        parent.bob.x = 100;
        parent.bob.y = 780 - parent.bob.h;
        removeSO(parent.lvlend);
        removeSO(parent.gh1);
        removeSO(parent.gh);
        removeSO(parent.gh2);
        for (int i = 0; i < 7; i++) {
            
             removeSO(parent.gr[i]);
        
            }

        parent.time.isRunning = false;
        parent.lvl3.stop();
        parent.end.loop();
        ended = true;
        
        
    } 
}
    
    

