/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ann;

import java.text.DecimalFormat;

/**
 *
 * @author 1450
 */
public class OutputLayerEstimation {
    
    public double getOutputLayer(double hiddenval1, double hiddenval2,double target1, double target2)
    {
       
        
        
        double x1= hiddenval1*WeightKeeper.w5+hiddenval2*WeightKeeper.w6+WeightKeeper.b2;
        double x2= hiddenval1*WeightKeeper.w7+hiddenval2*WeightKeeper.w8+WeightKeeper.b2;
        
        
//         System.out.println("x1: "+x1);
//        System.out.println("x2: "+x2);
        
        
        double opvalue1=new SigmoidFunction().getActivationFunctionValue(x1);
            //   opvalue1=Double.parseDouble(new DecimalFormat("##.##").format(opvalue1));
               
        double opvalue2=new SigmoidFunction().getActivationFunctionValue(x2);
             //  opvalue2=Double.parseDouble(new DecimalFormat("##.##").format(opvalue2));
       
//        System.out.println("OuputValue1: "+opvalue1);
//        System.out.println("OuputValue2: "+opvalue2);

        
         double er1=Math.abs(target1-opvalue1);  
         double er2=Math.abs(target2-opvalue2);
        
//         
         double small=0.0;
//         
         if(er1>er2)
         {
             small=er2;
         }
         else
         {
             small=er1;
         }
//        
//       //  System.out.println("Smallest Error Probability is: "+small);
        return small;
    }
    
}
