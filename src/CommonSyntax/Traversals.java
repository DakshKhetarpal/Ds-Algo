package CommonSyntax;

import java.util.*;

public class Traversals {


    public static void main(String[] args){

        //Array
        int[] arr=new int[10];
        arr[0]=1;
        arr[1]=2;
        for(int i=0;i<arr.length;i++){
            System.out.println("Array print");
            System.out.println(arr[i]);
        }

        //String
        String str="Daksh";
        for(int i=0;i<str.length();i++){
            System.out.println("String print");
            System.out.println(str.charAt(i));
        }
        //to replace a character in string u need to convert string to char array and then back to string

        //List
        List<Integer> list=new ArrayList();
        list.add(1);
        list.add(2);
        System.out.println(list.size());
        for(int i=0;i<list.size();i++){
            System.out.println("List print");
            System.out.println(list.get(i));
        }

        //Map
        Map<Integer,String> map=new HashMap();
        map.put(1,"D");
        map.put(0,"A");
        for(Map.Entry entry:map.entrySet()){
            System.out.println("Map print");
            Integer key= (Integer) entry.getKey();
            String value=(String)entry.getValue();
            System.out.println(key+" "+value);
            //map.put(null,"as");
            //map.put(null,"sd");
        }

        //directly iterate through values in map
        for(String s:map.values()){
            System.out.println(s);
        }

        //Stack
        Stack<Integer> stack=new Stack<>();
        stack.push(1);
//        while(!stack.isEmpty()){
//            stack.pop();
//        }
        for(int element:stack){
            System.out.println("Stack print");
            System.out.println(element);
        }
        for(int i=0;i<stack.size();i++){
            System.out.println("Stack print");
            System.out.println(stack.pop());
        }

        //pop in stack does the same work as poll in queue
        //peek does the same work in both

        //queue
        Queue<Integer> queue=new LinkedList<>();
        queue.add(1);
        queue.add(2);
        for(int i=0;i< queue.size();i++){
            System.out.println("Queue print");
            System.out.println(queue.poll());
        }

        //Heap
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        //Comparator.reverseOrder also works
        maxHeap.add(1);
        maxHeap.add(100);
        maxHeap.add(20);
        maxHeap.add(70);

        //only seeing the max element
        System.out.println("Max element "+maxHeap.peek());

        //normal iteration : prints from max to low
        Iterator<Integer> iterator=maxHeap.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //seeing and removing the max element
        while(!maxHeap.isEmpty()){
            System.out.println("current max"+maxHeap.poll());
        }

        String s="AB";
        String d="AB";
        System.out.println(s.equalsIgnoreCase(d));

        List<Integer> listT=new ArrayList();
        listT.add(1);
        listT.add(2);
        System.out.println(list.subList(0,2));
    }
}
