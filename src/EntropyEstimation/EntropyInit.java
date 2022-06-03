/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EntropyEstimation;

import ecommercefrauddetection.EntropyClusterFrame;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author 1450
 */
public class EntropyInit {
    
    public ArrayList getEntropyValue(ArrayList linearcluster)
    {
        ArrayList gainestimation=new ArrayList();
        
        
                
        for (int i = 0; i <linearcluster.size(); i++) 
        {
            ArrayList temp=new ArrayList();
            ArrayList single=(ArrayList) linearcluster.get(i);
            int count=0;
            
            for (int j = 0; j <single.size(); j++) 
            {
                ArrayList row=(ArrayList) single.get(j);
                String signuptime=(String) row.get(1);
                String purtime=(String) row.get(2);
                
                if(signuptime.equals(purtime))
                {
                    count++;
                }
            }
             System.out.println("Count: "+count);
            int c=single.size();
            int a=count;
            int b=c-a;
            double gain=new GainEstimation().getSIGain(a, b, c);
                 //  gain=Double.parseDouble(new DecimalFormat("##.#").format(gain));
                   
                   temp.add(Integer.toString(i));
                   temp.add(Double.toString(gain));
                   gainestimation.add(temp);
            
        }
        
        ArrayList sorter=new Sorter().getSortedList(gainestimation);
        System.out.println("Gain Estimation: "+sorter);
        
        String res="";
         for(int i=0;i<sorter.size();i++)
           {
               ArrayList t=(ArrayList) sorter.get(i);
               String temp=t.toString();
               res=res+"\n "+temp;
                //               System.out.println(temp);
           }
         EntropyClusterFrame.res2=res;
         
        ArrayList topclusters=new ArrayList();
        
        for (int i = 0; i <sorter.size(); i++) 
        {
            ArrayList row=(ArrayList) sorter.get(i);
            
            double gainvalue= Double.parseDouble((String) row.get(1));
            
            if(gainvalue>0.5)
            {
               int index=Integer.parseInt((String) row.get(0));    
               topclusters.add(linearcluster.get(index)); 
            }
            
        }
        
        
        return topclusters;
        
    }
    
}
