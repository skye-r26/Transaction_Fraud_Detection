/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntropyEstimation;
import java.lang.Math;
import java.text.DecimalFormat;



/**
 *
 * @author welcome
 */
public class GainEstimation {
    
    
    public double  getSIGain(int a, int b, int c)
    {
       double gain=0.0;
                
       if(a==c)
       {
           gain=1.0;
       } 
       
       else if(b==c)
       {
           gain=0.0;
       }
       
       
       else if(a==b)
       {
           gain=0.5;
       }
       else
       {
       
       
        double x=(double) a/c;
        double y=(double) b/c;
        
        
        
        double x1=Math.log(x)/Math.log(2);
        double y1=Math.log(y)/Math.log(2);
        
        
        
        double info= -(x*x1)-(y*y1);
        
        info=Math.abs(info);
        
        
        if(b>a)
        {
            info=1-info;
        }
        DecimalFormat df = new DecimalFormat("0.00##");
        String result = df.format(info);
        gain=Double.parseDouble(result);
        
       }
                      
//        System.out.println(gain);
        
        return gain;
    }
    
    
}
