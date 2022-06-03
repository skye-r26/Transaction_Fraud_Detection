/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ann;

/**
 *
 * @author 2491
 */
public class SigmoidFunction {
    
   public double getActivationFunctionValue(double x)
   {
       
       double sigmoidval=1/(1+Math.exp(-x));
           
       return sigmoidval; 
       
       
       
       
       
       
       
       
       
   }
    
}
