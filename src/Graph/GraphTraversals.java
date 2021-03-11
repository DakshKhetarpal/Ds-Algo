package Graph;

import javax.print.attribute.IntegerSyntax;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class GraphTraversals {

    public static void main(String[] args){
        Graph graph=new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(1, 3);
        graph.addEdge(3, 3);

        // we are starting dfs traversal from node 2
        System.out.println("depth first traversal is"); // 2 0 1 3
        graph.dfs(2,4);
        System.out.println();
        //bfs traversal
        System.out.println("breadth first traversal is"); // 2 0 1 3
        graph.bfs(2,4);
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

    public void bfs(int node,int totalNodes){
        boolean[] visited=new boolean[totalNodes];
        bfsMainFunction(node,visited);
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

    /*
    bfs traversal is like breadth level order traversal in a tree, logic is also same.
    We maintain a visited array in graph but not in a tree traversal
     */
    public void bfsMainFunction(int node,boolean[] visited){
        visited[node]=true;
       // System.out.println(node+ " ");

        /* queue is an interface so we need a class which implements this interface
        public class LinkedList implements List,Deque {
         private Node first;
         private Node last;
         public E get(int index) {…}
         public boolean add(E e) {…}
        */
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            int currentElement=queue.poll();
            System.out.print(currentElement+" ");
            /*
            The poll() method of Queue Interface returns and removes the element at the front the container. It deletes the element in the container.
            The method does not throws an exception when the Queue is empty, it returns null instead.
             */
            ArrayList<Integer> attachedList=adjacencyList.get(currentElement);
            Iterator<Integer> i=attachedList.listIterator();
            while(i.hasNext()){
                int v=i.next();
                    if(!visited[v]){
                        queue.add(v);
                        visited[v]=true;
                    }
            }
        }
    }
}

//https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/

/*some key points : this is recursive function , we have to mark node as visited once we traverse it and then move forward in recursion*/
