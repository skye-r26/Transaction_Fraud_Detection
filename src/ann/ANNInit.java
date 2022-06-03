/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ann;

import java.util.ArrayList;

/**
 *
 * @author 1450
 */
public class ANNInit {
    
    public ArrayList getANNResult(ArrayList prelist)
    {
      
         WeightKeeper.b1=new RandomFunction().getRandomWeight();
         WeightKeeper.b2=new RandomFunction().getRandomWeight();
         
         WeightKeeper.w1=new RandomFunction().getRandomWeight();
         WeightKeeper.w2=new RandomFunction().getRandomWeight();
         
         WeightKeeper.w3=new RandomFunction().getRandomWeight();
         WeightKeeper.w4=new RandomFunction().getRandomWeight();
         WeightKeeper.w5=new RandomFunction().getRandomWeight();
         WeightKeeper.w6=new RandomFunction().getRandomWeight();
         
         WeightKeeper.w7=new RandomFunction().getRandomWeight();
         WeightKeeper.w8=new RandomFunction().getRandomWeight();
         
      
         
         ArrayList annprobabilitylist=new ArrayList();
        
         for (int i = 0; i <prelist.size(); i++) 
         {
             ArrayList temp=new ArrayList();
             ArrayList row=(ArrayList) prelist.get(i);
             double attr1=Double.parseDouble((String) row.get(0));
             double attr2=Double.parseDouble((String) row.get(1));
           
             
             double target1=attr1;
             double target2=attr2;
             
             
             
             double probability=new HiddenLayerEstimation().getHiddenLayer(attr1, attr2, target1, target2);
             temp.add(row.get(0));
             temp.add(row.get(1));
             temp.add(Double.toString(probability));
             annprobabilitylist.add(temp);
            
         }
         
         ArrayList sortedannprobabilitylist= new Sorter().getSortedList(annprobabilitylist);
         
         return sortedannprobabilitylist;
    }
    
    
}
