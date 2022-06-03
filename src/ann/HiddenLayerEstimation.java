/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ann;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author 1450
 */
public class HiddenLayerEstimation {
    
    
    public double getHiddenLayer(double attr1, double attr2,double target1, double target2)
    {
       
       double hv1=attr1*WeightKeeper.w1+attr2*WeightKeeper.w2+WeightKeeper.b1;
             // hv1=Double.parseDouble(new DecimalFormat("##.##").format(hv1));
       double hiddenval1=new SigmoidFunction().getActivationFunctionValue(hv1);
       
        
       
       double hv2=attr1*WeightKeeper.w3+attr2*WeightKeeper.w4+WeightKeeper.b1;
             // hv2=Double.parseDouble(new DecimalFormat("##.##").format(hv2));
       double hiddenval2=new SigmoidFunction().getActivationFunctionValue(hv2);
       
       
   //       System.out.println("HV1: "+hv1);
//       System.out.println("HV2: "+hv2);
 //       System.out.println("HiddenValue1: "+hiddenval1);
   //    System.out.println("HiddenValue2: "+hiddenval2);
//      
       
       
       double value=new OutputLayerEstimation().getOutputLayer(hiddenval1, hiddenval2, target1, target2);
//       
//       
//       
       return value;
    }
}
