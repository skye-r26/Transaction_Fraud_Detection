/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy;

import ecommercefrauddetection.FuzzyLogicClassificationFrame;
import java.util.ArrayList;

/**
 *
 * @author abhilash
 */
public class Fuzzyinit {
    
    
    public void initialize(ArrayList probabilitylist, ArrayList orgfrauddata)
    {
       
       ArrayList row1=(ArrayList) probabilitylist.get(0);
       ArrayList row2=(ArrayList) probabilitylist.get(probabilitylist.size()-1);
       
       double max=Double.parseDouble((String) row1.get(2));     
       double min=Double.parseDouble((String) row2.get(2));
        
       ArrayList crisp=new CrispValues().getFuzzyCripValue(min, max);
       
        System.out.println("Fuzzy Index: "+crisp);
        
        
        ArrayList vl = new ArrayList();
        ArrayList l = new ArrayList();
        ArrayList m = new ArrayList();
        ArrayList h = new ArrayList();
        ArrayList vh = new ArrayList();
        
        
        for (int i = 0; i <crisp.size(); i++) 
        {
            ArrayList row3=(ArrayList) crisp.get(i);
            
            double minv=(double) row3.get(0);
            double maxv=(double) row3.get(1);
            
            
        //    System.out.println("Min: "+minv);
         //   System.out.println("Max: "+maxv);
            
            for (int j = 0; j <probabilitylist.size(); j++) 
            {
                ArrayList row4=(ArrayList) probabilitylist.get(j);
                double annvalue=Double.parseDouble((String) row4.get(2));   
                
                
             //   System.out.println("Annvalue: "+annvalue);
                 if(i==0)
            {
                if(annvalue>=minv&&annvalue<=maxv)
                {
                    vl.add(row4);
                }
                
            }
                 if(i==1)
            {
                if(annvalue>minv&&annvalue<=maxv)
                {
                    l.add(row4);
                }
                
            }   
              
                  if(i==2)
            {
                if(annvalue>minv&&annvalue<=maxv)
                {
                    m.add(row4);
                }
                
            }  
               
                  if(i==3)
            {
                if(annvalue>minv&&annvalue<=maxv)
                {
                    h.add(row4);
                }
                
            }  
                
                  if(i==4)
            {
                if(annvalue>minv&&annvalue<=maxv)
                {
                    vh.add(row4);
                }
                
           }   
               
            }
            }

        
        System.out.println("\n");
      //  System.out.println("Very Low Probability Index");
        for (int i = 0; i <l.size(); i++) 
        {
            System.out.println(l.get(i));
        }
        
        String res1="";
         for(int i=0;i<vl.size();i++)
           {
               ArrayList t=(ArrayList) vl.get(i);
               String temp=t.toString();
                System.out.println(temp);
               res1=res1+"\n "+temp;
                //               System.out.println(temp);
           }
         FuzzyLogicClassificationFrame.res1=res1;
         
         String res2="";
         for(int i=0;i<l.size();i++)
           {
               ArrayList t=(ArrayList) l.get(i);
               String temp=t.toString();
                System.out.println(temp);
               res2=res2+"\n "+temp;
                //               System.out.println(temp);
           }
         FuzzyLogicClassificationFrame.res2=res2;
         
         String res3="";
         for(int i=0;i<m.size();i++)
           {
               ArrayList t=(ArrayList) m.get(i);
               String temp=t.toString();
                System.out.println(temp);
               res3=res3+"\n "+temp;
                //               System.out.println(temp);
           }
         FuzzyLogicClassificationFrame.res3=res3;
         
         String res4="";
         for(int i=0;i<h.size();i++)
           {
               ArrayList t=(ArrayList) h.get(i);
               String temp=t.toString();
                System.out.println(temp);
               res4=res4+"\n "+temp;
                //               System.out.println(temp);
           }
         FuzzyLogicClassificationFrame.res4=res4;
         
         
         String res5="";
         for(int i=0;i<vh.size();i++)
           {
               ArrayList t=(ArrayList) vh.get(i);
               String temp=t.toString();
                System.out.println(temp);
               res5=res5+"\n "+temp;
                //               System.out.println(temp);
           }
         FuzzyLogicClassificationFrame.res5=res5;
         
         
         int sum=vl.size()+l.size()+m.size()+h.size()+vh.size();
         
         int count=0;
         
         for (int i = 0; i <orgfrauddata.size(); i++) 
         {
            ArrayList row=(ArrayList) orgfrauddata.get(i);
           // int value=Integer.parseInt((String) row.get(row.size()-1));
           
           String str1=(String) row.get(1);
           String str2=(String) row.get(2);
            
            if(str1.equals(str2))
            {
                count++;
            }
        }
         
         System.out.println("\n");
         System.out.println("Actual Fraud Count in Given Data: "+count);
         System.out.println("Predicted Fraud Count in Given Data: "+sum);
         
    }
}
