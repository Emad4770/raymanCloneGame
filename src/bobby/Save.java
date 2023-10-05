/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bobby;

import java.io.*;


public class Save implements Serializable{
    
    ScreenManager sm;
    int i;
    
    
    
    public Save(ScreenManager sm) {
        this.sm = sm;
    }
    
    
    public void Save() 
    {
    
         try{
 
		FileOutputStream fo = new FileOutputStream("Save.ini");
		ObjectOutputStream output = new ObjectOutputStream(fo);   

                for (i = 0; i < sm.ol.size(); i++) {
                 output.writeInt(sm.ol.get(i).x);
                 output.writeInt(sm.ol.get(i).y);
                    output.writeInt(sm.ol.get(i).xl);
                    output.writeInt(sm.ol.get(i).xl2);
                    output.writeInt(sm.ol.get(i).yl);
                    output.writeInt(sm.ol.get(i).yl2);

             }
                /*
                output.writeInt(sm.parent.gh.dx);
                output.writeInt(sm.parent.gh1.dx);
                output.writeInt(sm.parent.gh2.dx);
                
                */
                output.writeInt(sm.parent.ss);
                output.writeBoolean(sm.parent.bob.done2);
                
                output.flush();
		output.close();
		System.out.println("Done Saving!");
 
	   }catch(Exception ex){
		   ex.printStackTrace();
                   System.out.println(i);
             }

}

    
    public void Load()
    {
         try{
 
		   FileInputStream fin = new FileInputStream("Save.ini");
		   ObjectInputStream input = new ObjectInputStream(fin);
                   
          for (int i = 0; i < sm.ol.size(); i++) {
                sm.ol.get(i).x = input.readInt();
                sm.ol.get(i).y = input.readInt();
                       sm.ol.get(i).xl = input.readInt();
                       sm.ol.get(i).xl2 = input.readInt();
                       sm.ol.get(i).yl = input.readInt();
                       sm.ol.get(i).yl2 = input.readInt();

          }
          
            sm.parent.ss = input.readInt() - 1;
            sm.parent.bob.done2 = input.readBoolean();
         /*   sm.parent.gh.dx = input.readInt();
            sm.parent.gh1.dx = input.readInt();
            sm.parent.gh2.dx = input.readInt();
          */  
            
		   input.close();
                   System.out.println("Done loading!");
                 //  System.out.println(sm.parent.ss);

		  
	   }catch(Exception ex){
               
		   ex.printStackTrace();
                   
		   
           }
    }
    
}
