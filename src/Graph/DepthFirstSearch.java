package Graph;

import java.util.ArrayList;
import java.util.Iterator;

public class DepthFirstSearch {

    public static void main(String[] args){
        Graph graph=new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(1, 3);
        graph.addEdge(3, 3);

        graph.dfs(2,4);
    }
}

class Graph{
    ArrayList<ArrayList<Integer>> adjacencyList=new ArrayList<>();

    // initialising every index with new arraylist
    Graph(int size){
        for(int i=0;i<size;i++){
            adjacencyList.add(new ArrayList<Integer>());
        }

    }

    public void addEdge(int from,int too){
        // directed graph , therefore adding only one side
        adjacencyList.get(from).add(too);
    }


    public void dfs(int node,int totalNodes){
        boolean[] visited=new boolean[totalNodes];
        dfsMainFunction(node ,visited);
    }

    public void dfsMainFunction(int node,boolean[] visited){
        visited[node]=true;
        System.out.print(node + " ");

        ArrayList<Integer> attachedList=adjacencyList.get(node);
        Iterator<Integer> i=attachedList.listIterator();
        while(i.hasNext()){
            int vertex=i.next();
            if(!visited[vertex]){
                dfsMainFunction(vertex,visited);
            }
        }
    }
}

//https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
