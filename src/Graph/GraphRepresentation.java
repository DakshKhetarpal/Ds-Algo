package Graph;

import java.util.ArrayList;
import java.util.List;

// representing graph through adjacency list
public class GraphRepresentation {

    public static void main(String args[]){
        int vertices=5;
        //below capacity of arraylist is being set , not the size
        //https://stackoverflow.com/questions/8896758/initial-size-for-the-arraylist
        ArrayList adjacencyList=new ArrayList<ArrayList<Integer>>(vertices);

        // initialising each index with new arraylist
        //below loop will not run as size is 0
//        for(int i=0;i<adjacencyList.size();i++){
//            adjacencyList.add(new ArrayList<Integer>());
//        }

        // this loop will make arraylist size as 5
        for(int i=0;i<5;i++){
            adjacencyList.add(new ArrayList<Integer>());
        }

        addEdge(adjacencyList, 0, 1); //0->1,1->0
        addEdge(adjacencyList, 0, 4);
        addEdge(adjacencyList, 1, 2);
        addEdge(adjacencyList, 1, 3);
        addEdge(adjacencyList, 1, 4);
        addEdge(adjacencyList, 2, 3);
        addEdge(adjacencyList, 3, 4);

        printAdjacencyList(adjacencyList);
    }

    public static void printAdjacencyList(ArrayList<ArrayList<Integer>> list){
        for(int i=0;i<list.size();i++){
            System.out.println("list current index is "+i);
            for(int j=0;j<list.get(i).size();j++){
                System.out.print("->"+list.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> list,int from,int too){
        //adding both ways since it is a undirected graph
        list.get(from).add(too);
        list.get(too).add(from);
    }

}