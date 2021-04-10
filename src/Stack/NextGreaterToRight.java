package Stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/next-greater-element-in-same-order-as-input/
 * Read study notes also
 * TC:n
 * SC:n
 */
public class NextGreaterToRight {

    public static void main(String[] args){
        int[] arr={1,3,0,0,1,2,4};
        printNextGreaterElementInRight(arr,arr.length);
    }

    public static void printNextGreaterElementInRight(int[] arr,int n){
        Stack<Integer> stack=new Stack<>() ;
        int answer[] = new int[n];

        //will traverse in reverse order as we want to fill stack in reverse order
        for(int i=n-1;i>=0;i--){

            System.out.println("i"+i);

            //s.top will not be answer for the incoming elements of stack , pop tb tk krege jb tk stack empty na ho jae (also maine pehele if lgaya tha yaha pr while lgana tha yaha)
            while(!stack.isEmpty() && arr[i]>=stack.peek())
                stack.pop();

            if(stack.isEmpty())
                answer[i]=-1;

            //next greater in right for arr[i] is current top element of stack
            else if(arr[i]<stack.peek())
                answer[i]=stack.peek();

            //because this element can be next greater in right for incoming elements
            stack.push(arr[i]);
        }

        System.out.println("array "+Arrays.toString(arr));
        System.out.println("answer "+Arrays.toString(answer));
    }


}
