/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ecommercefrauddetection;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.UIManager;


public class Main {

    
    public static void main(String[] args) {
        // TODO code application logic here
         
        
          try { 
  
           
              Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
              DatasetReaderFrame mf = new DatasetReaderFrame();
              mf.setVisible(true);
              mf.setSize(d);
        } 
        catch (Exception e) { 
            System.out.println("Look and Feel not set"); 
        } 
    }
    
}
