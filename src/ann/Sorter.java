/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ann;
import java.util.ArrayList;

/**
 *
 * @author welcome
 */
public class Sorter {
    
    
    public ArrayList getSortedList(ArrayList sorter)
    {
        
       // ArrayList sorter=DataKeeper.gainl;
        
             
        
           for(int i=0;i<sorter.size()-1;i++)
           {
               
               for(int j=i+1;j<sorter.size();j++)
               {
                   
                   ArrayList temp1=(ArrayList) sorter.get(i);
                   String str1=(String) temp1.get(temp1.size()-1);
                   double x1=Double.parseDouble(str1);
                   
                   
                   ArrayList temp2=(ArrayList) sorter.get(j);
                   String str2=(String) temp2.get(temp2.size()-1);
                   double x2=Double.parseDouble(str2);
                   
                   
                   if(x1<=x2)
                   {
                       sorter.set(i, temp2);
                       sorter.set(j, temp1);
                   }
               }
               
           }
           
       //    System.out.println(sorter);
         //  DataKeeper.gainl=sorter;
           
           return sorter;

    }
    
}
