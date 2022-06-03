/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package graph;

import java.util.ArrayList;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;


public class GraphInit {
 public static  String DB_PATH = "D:/neo4j-community-2.2.3/data/graph.db";
 public static GraphDatabaseService graphDb;
     public static ArrayList temp = new ArrayList();
 
 public void initGraph()
 {
     
       graphDb = new GraphDatabaseFactory().newEmbeddedDatabase(GraphInit.DB_PATH);
 }
}
