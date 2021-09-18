package Stack;

import java.util.Arrays;
import java.util.Stack;

public class MaximumAreaHistogram {

    public static void main(String[] args){
        int[] histogramBars={6,2,4,3,4,1,6};
        calculateMaxAreaHistogram(histogramBars,histogramBars.length);
    }

    static void calculateMaxAreaHistogram(int[] histogramBars,int n){
        int[] nearestSmallerToRight=new int[n];
        int[] nearestSmallerToLeft=new int[n];
        int[] areaWidthForEachBar=new int[n];

        Stack<Integer> stack=new Stack<Integer>();

        //finding nearest smaller to right
        for(int i=n-1;i>=0;i--){

            //next smaller to right is index 7 , for easier calculation
            if(i==n-1){
                nearestSmallerToRight[i]=n;
                continue;
            }

            while(!stack.isEmpty() && histogramBars[i]<=histogramBars[stack.peek()])
                stack.pop();

            //nearest smaller to right will be index n that is value 0
            if(stack.isEmpty())
                nearestSmallerToRight[i]=n;
            else if(histogramBars[i]>histogramBars[stack.peek()])
                nearestSmallerToRight[i]=stack.peek();

            //putting current index in stack
            stack.push(i);
        }

        //clearing the stack for finding next smaller to left
        stack.clear();

        //finding nearest smaller to left
        for(int i=0;i<n;i++){

            //nearest smaller to left for first element will be index -1 for later calculations
            if(i==0){
                nearestSmallerToLeft[i]=-1;
            }

            while(!stack.isEmpty() && histogramBars[i]<=histogramBars[stack.peek()])
                stack.pop();

            //no smaller exists for this element and hence its smaller to left will be -1
            if(stack.isEmpty())
                nearestSmallerToLeft[i]=-1;

            else if(histogramBars[i]>histogramBars[stack.peek()])
                nearestSmallerToLeft[i]=stack.peek();

            stack.push(i);
        }

        int maxArea=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            areaWidthForEachBar[i]=nearestSmallerToRight[i]-nearestSmallerToLeft[i]-1;
            int areaWithCurrentBarsHeight=areaWidthForEachBar[i]*histogramBars[i];
            if(areaWithCurrentBarsHeight>maxArea)
                maxArea=areaWithCurrentBarsHeight;
        }


        System.out.println("histogram is "+Arrays.toString(histogramBars));
        System.out.println("nearestSmallerToRight indexes "+Arrays.toString(nearestSmallerToRight));
        System.out.println("nearestSmallerToLeft indexes "+Arrays.toString(nearestSmallerToLeft));
        System.out.println("areaWidthForEachBar is "+Arrays.toString(areaWidthForEachBar));
        System.out.println("maxArea is "+maxArea);


    }

}

