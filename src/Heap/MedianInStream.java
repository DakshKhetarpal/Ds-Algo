package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *For question reference : https://www.baeldung.com/java-stream-integers-median-using-heap
 *
 * Approach:we will use max heap and min heap
 * we will store smaller elements in max heap
 * and larger in min heap
 * Size difference between max and min will not exceed greater than 1
 * If it exceeds we will rebalance our heaps by transferring more elements from one heap to another
 * when size of both heaps is same then median is (maxHeap.peek()+minHeap.peek())/2
 * when its not same then
 * if(maxHeap.size()>minHeap.size())
 *                  System.out.println("median for elements in arr"+maxHeap.peek());
 *                 if(minHeap.size()> maxHeap.size())
 *                     System.out.println("median for elements in arr"+minHeap.peek());
 */
public class MedianInStream {

    public static void main(String[] args){
        int arr[]={5,15,3,2,1,9};
        findMedian(arr);

    }

    public static void findMedian(int[] arr){
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Comparator.reverseOrder());

        if(arr[0]<arr[1]){
            maxHeap.add(arr[0]);
            minHeap.add(arr[1]);
        }else{
            maxHeap.add(arr[1]);
            minHeap.add(arr[0]);
        }
        for(int i=2;i<arr.length;i++){
            if(arr[i]<maxHeap.peek()){
                maxHeap.add(arr[i]);
                if(maxHeap.size()-minHeap.size()>1){
                    //need to rebalance
                    minHeap.add(maxHeap.poll());
                }
            }
            else if(arr[i]>maxHeap.peek()){
                minHeap.add(arr[i]);
                if(minHeap.size()-maxHeap.size()>1){
                    //need to rebalance
                    maxHeap.add(minHeap.poll());
                }
            }

            if(maxHeap.size()==minHeap.size()){
                printArr(arr,0,i);
                System.out.println("median for elements in arr"+(maxHeap.peek()+minHeap.peek())/2);
            }else{
                printArr(arr,0,i);
                if(maxHeap.size()>minHeap.size())
                 System.out.println("median for elements in arr"+maxHeap.peek());
                if(minHeap.size()> maxHeap.size())
                    System.out.println("median for elements in arr"+minHeap.peek());
            }


        }

    }

    static void printArr(int[] arr,int start, int end){
        for(int i=start;i<=end;i++){
            System.out.print(arr[i]+" ");
        }
    }


}
