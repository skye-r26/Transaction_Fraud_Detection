package graph;

import java.util.ArrayList;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

public class Neo4JDbInserter {

    
    String relation_types = "";
    String myString;
   
    Node from_node, to_node, mynode;
    Relationship conversation;

    private static enum RelTypes implements RelationshipType {

        purchase_value, to
    }

    void createDb(ArrayList params, ArrayList fr, ArrayList tt) {

       
        ArrayList all_node = new ArrayList();//FindAllNodesOfGraph().find(GraphInit.graphDb);

//        System.out.println("all nodes are : " + all_node);
//        System.out.println(" From : " + fr);
//        System.out.println(" To   : " + tt);

        Transaction tx =GraphInit.graphDb.beginTx();
        try {

            //System.out.println("temp nodes " + FindAllNodesOfGraph.temp);

         
            for (int i = 0; i < fr.size(); i++)
            {
                String f = (String) fr.get(i);

                for (int j = 0; j < tt.size(); j++) {
                    String t = (String) tt.get(j);

//                    System.out.println(f + " - > " + t);
                    if (!f.equals(t)) 
                    {
                        String c = "";
                        for (int k = 0; k < params.size(); k++)
                        {
                            ArrayList temp = (ArrayList) params.get(k);
                            String t1 = (String) temp.get(0);
                            String t2 = (String) temp.get(1);
                            String cv = (String) temp.get(2);
                        //    System.out.println("  temp  " + temp);
                            if (f.equals(t1) && t.equals(t2)) {
                                c = cv;
                                break;
                            }

                        }

                        if(!c.isEmpty())
                        {
                              Node fromnode = null, tonode = null;


                              
                        if (!GraphInit.temp.contains(f) || !GraphInit.temp.contains(t))
                        {
                            if (!GraphInit.temp.contains(f))
                            {

//                                System.out.println("From node created");
                                GraphInit.temp.add(f);
                                fromnode = GraphInit.graphDb.createNode();
                                fromnode.setProperty("name", f);
                                ArrayList tr = new ArrayList();
                                tr.add(f);
                                tr.add(fromnode);
                                all_node.add(tr);
                            }
                            if (!GraphInit.temp.contains(t)) 
                            {
//                                System.out.println("To node created");
                                GraphInit.temp.add(t);
                                tonode = GraphInit.graphDb.createNode();
                                tonode.setProperty("name", t);

                                ArrayList tr = new ArrayList();
                                tr.add(t);
                                tr.add(tonode);
                                all_node.add(tr);
                            }

                        }




                        fromnode = getNodeFromName(all_node, f);
                        tonode = getNodeFromName(all_node, t);

//                        System.out.println(fromnode + "    ===== >>>>  " + tonode);


                        if(!fromnode.equals(tonode))
                        {
                        conversation = fromnode.createRelationshipTo(tonode, RelTypes.purchase_value);
                        conversation.setProperty("relationship-type", c);
                        }
                        }
                      
                        



                    }


                }
            }
            tx.success();




        } finally {
            tx.finish();
        }
    }

    public Node getNodeFromName(ArrayList all_nodes, String nodename) {
        Node required = null;

        for (int i = 0; i < all_nodes.size(); i++) {
            ArrayList temp = (ArrayList) all_nodes.get(i);
            String nm = (String) temp.get(0);
            if (nm.equals(nodename)) {
                required = (Node) temp.get(1);
                break;
            }
        }

        return required;
    }

    void removeData() {
        Transaction tx = GraphInit.graphDb.beginTx();
        try {
            // myFirstNode.getSingleRelationship( RelTypes.leaftypeshape, Direction.OUTGOING ).delete();
            //  System.out.println("Removing nodes...");
//            myFirstNode.delete();
//            mySecondNode.delete();
//            myThirdNode.delete();
//            tx.success();
        } finally {
            tx.finish();
        }
    }

    void shutDown() {
        GraphInit.graphDb.shutdown();
//        System.out.println("graphDB shut down.");
    }
}
