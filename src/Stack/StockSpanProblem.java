package Stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/the-stock-span-problem/
 * note:this problem is similiar to nearest greater to left
 */
public class StockSpanProblem {
    public static void main(String[] args){
        int price[] = { 100, 80, 60, 70, 60, 75,85 };
        calculateStockSpan(price,price.length);
    }

    static void calculateStockSpan(int[] price,int n){

        Stack<Integer> stack=new Stack<>();
        int[] answer=new int[n];

        //pushing index 0
        stack.push(0);

        //answer for price[0] is 1 because there is no greater element to its left
        answer[0]=1;

        for(int i=1;i<n;i++){
            while(!stack.isEmpty() && price[i]>=price[stack.peek()]){
                stack.pop();
            }

            //if stack becomes empty pop krte krte or if stack was already empty
            if(stack.isEmpty()){
                answer[i]=1;
            } else if(price[stack.peek()]>price[i]){
                // this is nearest greater element to left of price[i]
                //eg: for 85 answer will be 85-100 i.e index 6-0
                answer[i]=i-stack.peek();
            }

            //we only have to push the index
            stack.push(i);
        }

        System.out.println("array is "+ Arrays.toString(price));
        System.out.println("answer is "+ Arrays.toString(answer));

    }
}
