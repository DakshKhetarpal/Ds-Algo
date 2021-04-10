package Stack;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerToLeft {

    public static void main(String[] args){

        int[] arr={4,5,2,8,10};
        findNearestSmallerToLeft(arr,arr.length);
    }

    static void findNearestSmallerToLeft(int[] arr,int n){

        Stack<Integer> stack=new Stack<>();
        int answer[]=new int[n];

        for(int i=0;i<n;i++){

            //when peek of stack is greater than arr[i] that means peek element has no usage ahead
            while(!stack.isEmpty() && stack.peek()>=arr[i]){
                stack.pop();
            }

            //no element is smaller than arr[i] in the left
            if(stack.isEmpty())
                answer[i]=-1;
            // else if is important because stack can be empty
            else if(arr[i]>stack.peek())
                answer[i]=stack.peek();

            stack.push(arr[i]);
        }

        System.out.println("array "+ Arrays.toString(arr));

        System.out.println("answer "+ Arrays.toString(answer));


    }
}
