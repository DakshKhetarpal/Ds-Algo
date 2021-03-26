package Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
this solution uses dfs approach
for detecting cycle in undirected graph we dont need to keep recursion stack for current dfs call because everything will lie in same
recursion stack if graph is undirected.
Also we have to check for parent node as well because we dont want to go back to parent node and recur for that.
 */
public class DetectCycleInUndirectedGraph {

    public static void main(String args[])
    {
        UndirectedGraph g1 = new UndirectedGraph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        if (g1.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");

}
}


class UndirectedGraph{

    private int v;
    private LinkedList<Integer> adj[];

    UndirectedGraph(int v){
        //dont forget to initialise the array with size
       this.v=v;
        adj = new LinkedList[v];
        for(int i=0;i<v;i++){
            adj[i]=new LinkedList<Integer>();
        }
    }

    public void addEdge(int from, int too){
        adj[from].add(too);
        adj[too].add(from);
    }

    Boolean isCyclic(){
        boolean visited[]=new boolean[v];

        // we have to recur for all the nodes because some nodes may be unconnected from starting node
        for(int node=0;node<v;node++){
            if(!visited[node]){
                //parent node will be -1 for starting node
                if(isCyclicMainFunction(node,visited,-1))
                    return true;
            }
        }
        return false;
    }

    boolean isCyclicMainFunction(int currentNode,boolean visited[],int parentNode){

        visited[currentNode]=true;
        LinkedList<Integer> connectedNodes=adj[currentNode];
            Iterator<Integer> i = connectedNodes.listIterator();
            //NOTE:u do this mistake again and again , here while will come not if
            while(i.hasNext()){
                int connectedNode=i.next();
                if(!visited[connectedNode]){
                    //current node becomes the parent node
                    if(isCyclicMainFunction(connectedNode,visited,currentNode))
                        return true;
                }
               //this is main step here , rest code is like dfs search only
               else if(connectedNode!=parentNode){
                    return true;
                }
            }
            return false;
    }
}
