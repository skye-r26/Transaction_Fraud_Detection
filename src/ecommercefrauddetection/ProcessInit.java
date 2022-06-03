/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ecommercefrauddetection;

import EntropyEstimation.EntropyInit;
import static ecommercefrauddetection.DatasetReaderFrame.org;
import graph.Perfectgraph;
import ann.ANNInit;
import fuzzy.Fuzzyinit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import linearclusters.ClusterIndexFormation;
import linearclusters.LinearInit;


/**
 *
 * @author 1450
 */
public class ProcessInit {
    
     public void initProcess(ArrayList orgdata)
    {
        
        
         System.out.println("ORIGINAL DATA =============================================");
        
        for(int i=0;i<orgdata.size();i++)
        {
            ArrayList row=(ArrayList) orgdata.get(i);
            System.out.println(row);
           
        }
        
          String res1="";
         for(int i=0;i<orgdata.size();i++)
           {
               ArrayList t=(ArrayList) orgdata.get(i);
               String temp=t.toString();
               res1=res1+"\n "+temp;
                //               System.out.println(temp);
           }
            DatasetDisplayFrame.res1=res1;
            
            
             ArrayList preprocessdata=new ArrayList();
         for(int i=0;i<orgdata.size();i++)
         {
             ArrayList temp=new ArrayList();
             ArrayList row=(ArrayList) orgdata.get(i);
             String str1=(String) row.get(0);
             String str2=(String) row.get(1);
             String str3=(String) row.get(2);
             String str4=(String) row.get(3);
             String str5=(String) row.get(4);
             String str6=(String) row.get(7);
             String str7=(String) row.get(8);
             String str8=(String) row.get(9);
             
             temp.add(str1);
             temp.add(str2);
             temp.add(str3);
             temp.add(str4);
             temp.add(str5);
             temp.add(str6);
             temp.add(str7);
             temp.add(str8);
             
             preprocessdata.add(temp);
             
         }
         
         System.out.println("\n");
          System.out.println("Preprocess DATA =======================================================");
         for(int i=0;i<preprocessdata.size();i++)
        {
            ArrayList row=(ArrayList) preprocessdata.get(i);
            System.out.println(row);
           
        }
          
        
         String res2="";
         for(int i=0;i<preprocessdata.size();i++)
           {
               ArrayList t=(ArrayList) preprocessdata.get(i);
               String temp=t.toString();
               res2=res2+"\n "+temp;
                //               System.out.println(temp);
           }
         PreprocessingFrame.res1=res2;
         
         ArrayList featurelist1=new ArrayList();
         ArrayList featurelist2=new ArrayList();
         ArrayList featurelist3=new ArrayList();
         
         for (int i = 0; i <preprocessdata.size(); i++) 
         {
            ArrayList row=(ArrayList) preprocessdata.get(i);
            
            String flist1=(String) row.get(1);
            String flist2=(String) row.get(2);
            String flist3=(String) row.get(3);
            
            featurelist1.add(flist1);
            featurelist2.add(flist2);
            featurelist3.add(flist3);
        }
         
         System.out.println("\n");
         System.out.println("Features List =======================================================");
          
         System.out.println("Featurelist1: "+featurelist1);
         System.out.println("Featurelist2: "+featurelist2);
         System.out.println("Featurelist3: "+featurelist3);
         
         
         String res3="";
         for(int i=0;i<featurelist1.size();i++)
           {
               
                String str1=(String) featurelist1.get(i);
                String str2=(String) featurelist2.get(i);
                String str3=(String) featurelist3.get(i);
                
                String finallist=str1+"    "+str2+"   "+str3;
                res3=res3+"\n "+finallist; 
                

                                            
           }
         FeatureListFrame.res1=res3;
         
          System.out.println("\n");
         System.out.println("Linear Clusters===============================================================");
         
        ArrayList linearcluster=new LinearInit().getLinearCluster(preprocessdata);

       
         for(int i=0;i<linearcluster.size();i++)
        {
            System.out.println("CLUSTER NO "+(i+1));
            ArrayList t=(ArrayList) linearcluster.get(i);
            
            for(int j=0;j<t.size();j++)
            {
                ArrayList t1=(ArrayList) t.get(j);
                System.out.println(t1);
            }
                        
                    System.out.println();     
        }
         
          String res4="";
         for(int i=0;i<linearcluster.size();i++)
           {
              res4=res4+" LINEAR CLUSTER NO "+(i+1)+"\n";
               String s1="";
               
               ArrayList t=(ArrayList) linearcluster.get(i);
               for(int j=0;j<t.size();j++)
               {
                 ArrayList t1=(ArrayList) t.get(j);
                 String s2=t1.toString();
                  s1=s1+"\n"+s2;
               
                   
               }
               
               res4=res4+"\n"+s1;
               res4=res4+"\n\n-------------------------------------------------------------------------------------------------------------------------\n\n";
               
                //               System.out.println(temp);
           }
         LinearClusterFrame.res1=res4;
         
         
          System.out.println("\n");
         System.out.println("Entropy Estimation Cluster========================================================================");
           
         ArrayList topclusters=new EntropyInit().getEntropyValue(linearcluster);
      
           
           String res5="";
         for(int i=0;i<topclusters.size();i++)
           {
              res5=res5+" ENTROPY CLUSTER NO "+(i+1)+"\n";
               String s1="";
               
               ArrayList t=(ArrayList) topclusters.get(i);
               for(int j=0;j<t.size();j++)
               {
                 ArrayList t1=(ArrayList) t.get(j);
                 String s2=t1.toString();
                  s1=s1+"\n"+s2;
               
                   
               }
               
               res5=res5+"\n"+s1;
               res5=res5+"\n\n-------------------------------------------------------------------------------------------------------------------------\n\n";
               
                //               System.out.println(temp);
           }
         EntropyClusterFrame.res1=res5;
         
         ArrayList purchasevalue=new ArrayList();
         
         for (int i = 0; i <topclusters.size(); i++) 
         {
             ArrayList temp=new ArrayList();
            ArrayList single=(ArrayList) topclusters.get(i);
            int count=0;
            
            for (int j = 0; j <single.size(); j++) 
            {
                ArrayList row=(ArrayList) single.get(j);
                String signuptime=(String) row.get(1);
                String purtime=(String) row.get(2);
                
                if(signuptime.equals(purtime))
                {
                    purchasevalue.add(row.get(3));
                }
            }
            
         }
         
         
         System.out.println("Purchase Value: "+purchasevalue);
         
         HashSet hs=new HashSet();
         hs.addAll(purchasevalue);
         ArrayList duplicateremove=new ArrayList();
         duplicateremove.addAll(hs);
         
         ArrayList singleinputlist=new ArrayList();
         for (int i = 0; i <topclusters.size(); i++) 
         {
             ArrayList single=(ArrayList) topclusters.get(i);
             
             for (int j = 0; j <single.size(); j++) 
             {
                 ArrayList row=(ArrayList) single.get(j);
                 singleinputlist.add(row);
             }
            
         }
         
         ArrayList graphobject=new ArrayList();
         ArrayList frequentitem=new ArrayList();
         
         for (int i = 0; i <duplicateremove.size(); i++) 
         {
             
             int val1=Integer.parseInt((String) duplicateremove.get(i));
             
             for (int j = 0; j <singleinputlist.size(); j++) 
             {
                 ArrayList temp=new ArrayList();
                 ArrayList temp1=new ArrayList();
                 
                 ArrayList row=(ArrayList) singleinputlist.get(j);
                 
                 String userid=(String) row.get(0);
                 String signtime=(String) row.get(1);
                 String purtime=(String) row.get(2);
                 int val2=Integer.parseInt((String) row.get(3));
                 
                 if(signtime.equals(purtime))
                 {
                     if(val1==val2)
                     {
                         
                         temp.add(userid);
                         temp.add(Integer.toString(val1));
                         temp.add("purchase value");
                         
                         temp1.add(userid);
                         temp1.add(Integer.toString(val1));
                     }
                 }
                 
                 if(temp.size()!=0)
                 graphobject.add(temp);
                 if(temp1.size()!=0  )
                 frequentitem.add(temp1);
             }
             
             
         }
       
         String res6="";
         for(int i=0;i<frequentitem.size();i++)
           {
               ArrayList t=(ArrayList) frequentitem.get(i);
               String temp=t.toString();
                System.out.println(temp);
               res6=res6+"\n "+temp;
                //               System.out.println(temp);
           }
         FrequentItemFrame.res1=res6;
         
         System.out.println();
         System.out.println("Frequent Item _----------------");
         for (int i = 0; i <frequentitem.size(); i++)
         {
            ArrayList row=(ArrayList) frequentitem.get(i);
             System.out.println(row);
        }
        
//          System.out.println("\n");
//         System.out.println("Graph Objectr========================================================================");
//         
//         for (int i = 0; i <graphobject.size(); i++) 
//         {
//             System.out.println(graphobject.get(i));
//        }
        
         
         new Perfectgraph().getGraph(graphobject);
         
        
         
         ArrayList probabilitylist =new ANNInit().getANNResult(frequentitem);
         
        
         
          System.out.println("ANN Probability List********************************************************************");
         
         for (int i = 0; i <probabilitylist.size(); i++) 
         {
             System.out.println(probabilitylist.get(i));
         }
         
         
         String res7="";
         for(int i=0;i<probabilitylist.size();i++)
           {
               ArrayList t=(ArrayList) probabilitylist.get(i);
               String temp=t.toString();
                System.out.println(temp);
               res7=res7+"\n "+temp;
                //               System.out.println(temp);
           }
         ANNProbabilityListFrame.res=res7;
         
                  
         new Fuzzyinit().initialize(probabilitylist,orgdata);
      }
    
}
