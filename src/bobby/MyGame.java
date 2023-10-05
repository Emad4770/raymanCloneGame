/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bobby;

import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import javax.swing.JApplet;
import javax.swing.JOptionPane;

/**
 *
 * @author Emad47
 */
public class MyGame extends JApplet implements KeyListener, Serializable{

    ScreenManager sm;
    Character bob;
    boolean jumping = false, rpress, lpress,sp;
    int s = 0 , s1 = 1;
    Background bc;
    long last;
    long now;
    TigEnemy en, en1, en2, en3, en4, en5;
    Stone w1;
    BirdEnemy be, be1;
    BasicEnemy bce, bce2, bce3, bce4;
    Health ht;
    GhostEnemy gh, gh1, gh2;
    End lvlend;
    Ground gr[] = new Ground[8];
    int y1;
    AudioClip lvl1, lvl2, lvl3, end, men;
    boolean a = true;
    int up = 0;
    Save bs;
    Countdown time;
    Image m ;

    
    
    
    public void init(){
        
        setSize(1600, 900);
        
        m = getImage(getCodeBase(), "menu.png");
        
        sm = new ScreenManager(this);
     
        bs = new Save(sm);
        
         
        
                
        ///ground
        
        gr[0] = new Ground(0, 710,4120, 5, 8, 0, 0, 0, sm, 0);
        sm.addSO(gr[0]);
        
        gr[1] = new Ground(4490, 720, 1630, 5, 8, 0, 0, 0, sm, 0);
        sm.addSO(gr[1]);
        
        gr[2] = new Ground(6550, 720, 2150, 5, 8, 0, 0, 0, sm, 0);
        sm.addSO(gr[2]);
        
        gr[4] = new Ground(9720, 550, 100, 5, 8, 0, 0, 0, sm, 0);
        sm.addSO(gr[4]);
        
        gr[6] = new Ground(10790, 400, 450, 5, 8, 0, 0, 0, sm, 0);
        sm.addSO(gr[6]);

        gr[7] = new Ground(11200,780, 1600, 5, 8, 0, 0, 0, sm, 0);
        sm.addSO(gr[7]);
        
        
        
         /// ender
        lvlend = new End(11150, 200, 50, 150, 8, 0, 0, 0, sm);
        sm.addSO(lvlend);
        
        
               
       /// background
        bc = new Background(0, 0, getWidth(), getHeight(), 9600, 0, 8, 0, sm);
        sm.addSO(bc);
        
        
        
        /// charcter
        bob = new Character(85, 600 , 100, 185,0, 0, 0, 0,8 , sm);
        sm.addSO(bob);
        
       
        /// tig enemy
        en = new TigEnemy(400, 610, 90, 100, 0, 0, 0, 0, sm, 8);
        sm.addSO(en);
          
        en1 = new TigEnemy(1800, 610, 90, 100,0, 0, 0, 0, sm, 8);
        sm.addSO(en1);
        
        en2 = new TigEnemy(1910, 610, 90, 100,0, 0, 0, 0, sm, 8);
        sm.addSO(en2);
       
        en3 = new TigEnemy(5000, 610, 90, 100,0, 0, 0, 0, sm, 8);
        sm.addSO(en3);
        
        en4 = new TigEnemy(3600, 610, 90, 100,0, 0, 0, 0, sm, 8);
        sm.addSO(en4);
        
        en5 = new TigEnemy(8650, 670, 90, 100,0, 0, 0, 0, sm, 8);
        sm.addSO(en5);
            
        
        
        
        /// bird enemy
        be = new BirdEnemy(3900, 200, 150, 150, 3800, 4800, 20, 410, 8 ,1, 1,  sm);
        Thread t = new Thread(be);
        t.start();
        sm.addSO(be);
        
        be1 = new BirdEnemy(6300, 200, 150, 150,5900, 6800, 20, 410, 8 ,1, 1, sm);
        Thread b = new Thread(be1);
        b.start();
        sm.addSO(be1);
        
        
        
        ///ghost
        
        gh = new GhostEnemy(9550, 900, 100, 200, 8, 0, 0, 0, 1, sm);
        Thread ght = new Thread(gh);
        ght.start();
        sm.addSO(gh);
        
        gh1 = new GhostEnemy(10000, 450, 100, 200,8, 0, 0, 0, 1, sm);
        Thread ght1 = new Thread(gh1);
        ght1.start();
        sm.addSO(gh1);
        
        
        gh2 = new GhostEnemy(10610, 100, 100, 200,8, 0, 0, 0, 1, sm);
        Thread ght2 = new Thread(gh2);
        ght2.start();
        sm.addSO(gh2);
        
        
        /// basic enemy
        
        
        bce = new BasicEnemy(820, 570, 125, 165, 800, 1200, 0, 0, 8,sm, 1);
        Thread t2 = new Thread(bce);
        t2.start();
        sm.addSO(bce);
        
        bce2 = new BasicEnemy(2500, 570, 125, 165, 2300, 2900, 0, 0, 8,sm, 1);
        Thread t1 = new Thread(bce2);
        t1.start();
        sm.addSO(bce2);
        
        bce3 = new BasicEnemy(5600, 570, 125, 165, 5400, 5850, 0, 0, 8,sm, 2);
        sm.addSO(bce3);
        Thread t3 = new Thread(bce3);
        t3.start();

        bce4 = new BasicEnemy(6900, 570, 125, 165, 6800, 7300, 0, 0, 8, sm, 2);
        sm.addSO(bce4);
        Thread t4 = new Thread(bce4);
        t4.start();
        
        
        
          ///wood

        w1 = new Stone(7940, 0, 150, 1000,0, 0, 0, 0, sm, 8, 2);
        sm.addSO(w1);
        
        
        ///moving ground
        
        gr[3] = new Ground(9000, 500, 400, 100, 8, 0,420, 600, sm,  1);
        sm.addSO(gr[3]);
        
        gr[5] = new Ground(10150, 460, 400, 100, 8, 0,450, 700, sm, 1);
        sm.addSO(gr[5]);
        
       
        
        /// health
        ht = new Health(60, 800, 65, 65,4, 0, 0, 0, sm);
        sm.addSO(ht);
        
        
        //// timer
        
        time = new Countdown(50, 100, 0, 800, 3000, 0, 0, 0, sm);
        sm.addSO(time);
        
        
        /// sound
        
        lvl1 = sm.parent.getAudioClip(sm.parent.getCodeBase(), "lvl1.wav");
        lvl2 = sm.parent.getAudioClip(sm.parent.getCodeBase(), "lvl2.wav");
        lvl3 = sm.parent.getAudioClip(sm.parent.getCodeBase(), "lvl3.wav");
        end = sm.parent.getAudioClip(sm.parent.getCodeBase(), "end.wav");
        men = sm.parent.getAudioClip(sm.parent.getCodeBase(), "menu.wav");
        
        
        this.addKeyListener(this);
        
        setFocusable(true);
        requestFocus();
        
    }
    
    
    
    
    int ss = 0;
    int i = 1;
    
    
    public void paint(Graphics g){
        
       sm.draw(g);
 
        if(bc.xl2 == 0 && ss == 0){
          lvl1.loop();
          lvl2.stop();
          lvl3.stop();
          ss = 1;
        }
        
        if(bc.xl2 == 1 && ss == 1){
            lvl1.stop();
            lvl3.stop();
            lvl2.loop();
            ss = 2; 
        }
        
        if(bc.xl2 == 2 && ss == 2){
            lvl2.stop();
            lvl1.stop();
            lvl3.loop();
            ss = 3; 
        }
        
        if(bc.x <= 0  && bc.x >= -1600 )
           sm.parent.showStatus("Level 1");
        
        if(bc.x <= -1600  && bc.x >= -1600 * 2)
            showStatus("Level 2");
        
        if(bc.x <= -1600 * 2  && bc.x >= -1600 * 3)
            showStatus("Level 3");
        
        if(bc.x <= -1600 * 3 && bc.x >= -1600 * 4)
            showStatus("Level 4");
        
        if(bc.x <= -1600 * 4 && bc.x >= -1600 * 5)
            showStatus("Level 5");
        
        if(bc.x <= -1600 * 5 && bc.x >= -1600 * 6)
            showStatus("Level 6");
        
        if(bc.x <= -1600 * 6 && bc.x >= -1600 * 7)
            showStatus("Level 7");
        
        if(bc.x <= -1600 * 7 && bc.x >= -1600 * 8)
        showStatus("Congratulations");
        
        
        if (up == 1)
            this.removeKeyListener(this);
        
        
       
        
    }
    
    public void start(){
        
        sm.start();
        
    }
    
    
    public void stop(){
        
        sm.stopManager();
    }
    
    
    @Override
    public void keyTyped(KeyEvent e) {
       
        if(sp && rpress)
            bob.right();
        
      
         if(sp && lpress)
            bob.left();
         
       
    }

    
    boolean paused = false;
    
    @Override
    public void keyPressed(KeyEvent e) {
        
        switch(e.getKeyCode()){
            
            
            case KeyEvent.VK_ESCAPE:
            {
                
                paused ^= true;
                if(paused == false){
                    
                    ss --;
                    
                    men.stop();
                    
                    if(sm.ended){
                       end.loop();
                       lvl3.stop();
                       ss = 5;
                    }
                    
                    /// basic enemy
                    Thread t = new Thread(bce);
                    t.start();              
                    Thread t1 = new Thread(bce2);
                    t1.start();
                    Thread t2 = new Thread(bce3);
                    t2.start();
                    Thread t3 = new Thread(bce4);
                    t3.start();
                    
                    ///bird
                    Thread b = new Thread(be);
                    b.start();
                    Thread b1 = new Thread(be1);
                    b1.start();
                    
                    /// ghost
                    Thread g = new Thread(gh);
                    g.start();
                    Thread g1 = new Thread(gh1);
                    g1.start();
                    Thread g2 = new Thread(gh2);
                    g2.start();
                    
                    /// moving level
                    
                    Thread m = new Thread(gr[3]);
                    m.start();
                    Thread m1 = new Thread(gr[5]);
                    m1.start();
                    
                    /// time
                    Thread ti = new Thread(time);
                    ti.start();
                    
                    /// character
                  //  if( bob.k == false){
                 //   Thread ch = new Thread(bob);
                 //   ch.start();
                 //   bob.k = true;
                    
                 //   }
                    
                    
                    bce.old = getImage(getCodeBase(), "old.gif");
                    bce2.old = getImage(getCodeBase(), "old.gif");
                    bce3.ma = getImage(getCodeBase(), "mari.gif");
                    bce4.ma = getImage(getCodeBase(), "mari.gif");
                    be.be = getImage(getCodeBase(), "fly.gif");
                    be1.be = getImage(getCodeBase(), "fly.gif");
                    
                    
                    
                }
                
                else{
                    
                    lvl1.stop();
                    lvl2.stop();
                    lvl3.stop();
                    men.loop();
                    end.stop();
                    bce.old = getImage(getCodeBase(), "old2.png");
                    bce2.old = getImage(getCodeBase(), "old2.png");
                    bce3.ma = getImage(getCodeBase(), "mari2.png");
                    bce4.ma = getImage(getCodeBase(), "mari2.png");
                    be.be = getImage(getCodeBase(), "fly2.png");
                    be1.be = getImage(getCodeBase(), "fly2.png");
                   
                    
                }
                
                
                
            }
            break;
            
            
            
            case KeyEvent.VK_RIGHT:
            {
                if(paused == false){
                rpress = true;
                
                 if(bob.x + bob.w + bob.dx >= getWidth()/2){
                     
                bc.move();
                
                ///tig
                
                en.move();
                en1.move();
                en2.move();
                en3.move();
                en4.move();
                en5.move();
                
                ///wood
                w1.move();
            
                
                ///bird
                be.move();
                be1.move();
                
                
                
                ///basic enemy
                bce.move();
                bce2.move();
                bce3.move();
                bce4.move();
                
                
                ///ghost
                
                gh.move();
                gh1.move();
                gh2.move();
                
                
                // ground
                gr[0].move();
                gr[1].move();
                gr[2].move();
                gr[3].move();
                gr[4].move();
                gr[5].move();
                gr[6].move();
                gr[7].move();
                
                
                
                lvlend.move();
                
                 }
                
                bob.right();
                s1 = 1;
                
                now = System.currentTimeMillis();
                
                if( now - last > 150){
                bob.r ^= true;
                   last = now;
                }
                
                }
            }
                break;
                
            case KeyEvent.VK_LEFT:
            {
                if(paused == false){
                
                
                lpress = true;
                
                bob.left();
                s1 = 2;
                
                now = System.currentTimeMillis();
                
                if(now - last > 150){
                bob.l ^= true;
                last = now;
                }
                
                }
            }
                break;
            
            case KeyEvent.VK_SPACE:
                if(paused == false){
                
                if(bob.gg == false)
            {
                
              s = 1;
             sp = true; 
             bob.done2 = false;
             y1 = bob.y;
             
           //  sm.ending();
            }
            }
                break;
                
            case KeyEvent.VK_UP:
                
                if(paused == false){
                
                if(sm.ended && up == 0)
                {
                    if(bob.x >= 600 && bob.x <= 1000){
                        bob.x = 680;
                        gr[7].y -= 20;
                        bob.w += 100;
                        bob.h += 100;
                        bob.r1 = getImage(getCodeBase(), "er.png");
                        bob.r2 = bob.l1 = bob.l2 = bob.r1;
                        up = 1;
                        this.removeKeyListener(this);
                        showStatus("Congratulations");
                 
                        JOptionPane.showMessageDialog(null,"You Won The Game !!", "Congratulations",JOptionPane.INFORMATION_MESSAGE);
                        
                        System.exit(0);
                        end.stop();
                       
                    }
                }
                }
                
                break;
        }
        
        if(paused == false){
        
        /// save & load
        
        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S)
        {
            if(sm.ended == false)
            bs.Save();
            
        }
        
        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_L)
        {
            if(sm.ended == false)
            bs.Load();
         
        }        
        
        //// health cheat
        
        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_H){
            
            ht.hcheat();
            
        }
        
        //// restart
         
        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_R){
            
            sm.stopManager();
            sm.isRunning = false;
            sm = null;    
            init();
            sm.start();
           
        }
        }
            
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
                switch(e.getKeyCode()){
                    
                    case KeyEvent.VK_SPACE:
                    {
                     s = 0;
                     sp =false;   
                     
                     
                     
                    }
                        break;
                        
                        
                    case KeyEvent.VK_RIGHT:
                        rpress = false;
                        break;
                        
                    case KeyEvent.VK_LEFT:
                        lpress =false;
                        break;
                        
                        
                }
    }
}

