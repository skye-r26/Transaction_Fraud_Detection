/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package linearclusters;

import java.util.ArrayList;

/**
 *
 * @author 1450
 */
public class LinearInit {
    
    public ArrayList getLinearCluster(ArrayList preprocessdata)
    {
         int size=preprocessdata.size();
         ArrayList index=new ClusterIndexFormation().getClusterIndexing(size, 5);
         System.out.println("Index: "+index);
         
         
         ArrayList linearcluster=new ArrayList();
         
        
         for (int i = 0; i <index.size(); i++) 
         {
          
             ArrayList row=(ArrayList) index.get(i);
             ArrayList temp=new ArrayList();
             
             
             int min=(int) row.get(0);
             int max=(int) row.get(1);;
             for (int j = min; j <=max; j++) 
             {
                  temp.add(preprocessdata.get(j));
             }
             
             linearcluster.add(temp);
         }
         
         return linearcluster;
         
    }
    
}
