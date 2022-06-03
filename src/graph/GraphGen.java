/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package graph;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author 1450
 */
public class GraphGen 
{
public void generateGraph(ArrayList mas)
{
     new GraphInit().initGraph();

    ArrayList from=new ArrayList();
     ArrayList to=new ArrayList();
      ArrayList master=new ArrayList();


     Neo4JDbInserter n1=new Neo4JDbInserter();
     for(int i=0;i<mas.size();i++)
     {
         ArrayList mm=new ArrayList();
         ArrayList aa=(ArrayList) mas.get(i);
        // System.out.println("------------------->"+aa.size());

         String a1=(String)aa.get(0);
         String a2=(String)aa.get(1);
         String a3=(String)aa.get(2);

         mm.add(a1);
         mm.add(a2);
         mm.add(a3);
         master.add(mm);

//         System.out.println("\n");
//
//         System.out.println("----"+mm );
         if(!from.contains(a1))
             from.add(a1);
         if(!to.contains(a2))
             to.add(a2);

         
       

        
     }
     n1.createDb(master,from,to);
         n1.shutDown();
         
       //  JOptionPane.showMessageDialog(null,"Graph is been created successfully ");
         
            }
}

