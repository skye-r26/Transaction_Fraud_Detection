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
public class ClusterIndexFormation {
    
    public ArrayList getClusterIndexing(int size, int n)
    {
        ArrayList  index=new ArrayList();
        
        int div=size/n;
        System.out.println("Divisions are "+div);
        
       int begin=0,end=0;
        
       
       
        for (int i = 1; i <= n; i++)
        {
             ArrayList <Integer> range=new ArrayList<Integer>();
            if(i==1)
            {
                range.add(begin);
                end=begin+div-1;
                range.add(end);
                index.add(range);
               begin=end+1;
            }
            
            else if(i==n)
            {
                 range.add(begin);
                 range.add(size-1);
                 index.add(range);
                
            }
            else
            {
                range.add(begin);
                end=begin+div-1;
                range.add(end);
                 index.add(range);
               begin=end+1;
                
                
            }
            
            
        }
        
        
        return index;
        
    }
    
}
