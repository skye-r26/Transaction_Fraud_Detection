/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ann;

import java.lang.Math; 
import java.util.Random;

/**
 *
 * @author 2491
 */
public class RandomFunction {
    
    public double getRandomWeight()
    {
 double weight[] = {0.11, 0.25, 0.37, 0.49, 0.55, 0.68, 0.78, 0.84, 0.96};
          
        Random r = new Random();
        int Low = 0;
        int High = weight.length - 1;
        int index = r.nextInt(High - Low) + Low;

        double wt = weight[index];
       // System.out.println("Weight: "+wt);

        return (wt);
}
    
    
    
    
}
