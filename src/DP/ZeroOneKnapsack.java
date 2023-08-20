package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ZeroOneKnapsack {
    static int maxV=Integer.MIN_VALUE;
    public static void main(String[] args){
        ArrayList<Integer> A= new ArrayList<Integer>(Arrays.asList(60, 50, 70,30));
        ArrayList<Integer> B= new ArrayList<Integer>(Arrays.asList(5, 3, 4,2));
        System.out.println(solveKnapsack(A,B,10,0,0,0));

        //solveKnapsack2(A,B,50,0,0,0);
        //System.out.println(maxV);

       // System.out.println(solveKnapsack3(A,B,50,0,0,0));

        Map<Map<Integer,Integer>,Integer> map=new HashMap<>();

        System.out.println(solveKnapsack4(A,B,110,0,0,0,map));
        System.out.println(solveKnapsackRecursionRightWay(A,B,110,A.size()));
        System.out.println(solveKnapsackMemoizationRightWay(A,B,7,A.size()));
        System.out.print(solveKnapsackBottomUpDPRightWay(A,B,7,A.size()));
    }

    //recursion 1
    public static int  solveKnapsack(ArrayList<Integer> A, ArrayList<Integer> B , int c , int existingValue , int existingWeight, int index){

        long start = System.currentTimeMillis();

        if(index==B.size() || existingWeight>=c){
            return existingValue;
        }

        int value=0;
        if(existingWeight + B.get(index) <= c){
            //including weight and value of it
            value=solveKnapsack(A,B,c,A.get(index)+existingValue,B.get(index)+existingWeight,index+1);
        }

        long end = System.currentTimeMillis();
        long elapsedTime = end - start;


        //excluding weight and value of it and finding max between 2
        return Math.max(value,solveKnapsack(A,B,c,existingValue,existingWeight,index+1));

    }

    //recursion 2
    public static void  solveKnapsack2(ArrayList<Integer> A, ArrayList<Integer> B , int c , int existingValue , int existingWeight, int index){

        if(index==B.size() || existingWeight>=c){
            if(existingValue>maxV) maxV=existingValue;
            return;
        }

        if(existingWeight + B.get(index) <= c) {
            solveKnapsack2(A, B, c, A.get(index) + existingValue, B.get(index) + existingWeight, index + 1);
        }
        solveKnapsack2(A,B,c,existingValue,existingWeight,index+1);
    }

    //recursion 3
    public static int  solveKnapsack3(ArrayList<Integer> A, ArrayList<Integer> B , int c , int existingValue , int existingWeight, int index){

        if(index==B.size() || existingWeight>=c){
            if(existingValue>maxV) maxV=existingValue;
            return maxV;
        }

        if(existingWeight + B.get(index) <= c) {
            solveKnapsack2(A, B, c, A.get(index) + existingValue, B.get(index) + existingWeight, index + 1);
        }
        solveKnapsack2(A,B,c,existingValue,existingWeight,index+1);

        return maxV;
    }

    //memoization with recursion 1
    public static int solveKnapsack4(ArrayList<Integer> A, ArrayList<Integer> B , int c , int existingValue , int existingWeight, int index , Map<Map<Integer,Integer>,Integer> map){

        long start = System.currentTimeMillis();


        if(index==B.size() || existingWeight>=c){
            return existingValue;
        }

        int value=0;

        Map<Integer,Integer> innerMap=new HashMap<>();
        innerMap.put(existingValue,existingWeight);
        if(map.get(innerMap)!=null){
            return map.get(innerMap);
        }

        if(existingWeight + B.get(index) <= c){
            value=solveKnapsack(A,B,c,A.get(index)+existingValue,B.get(index)+existingWeight,index+1);
        }

        int answer=Math.max(value,solveKnapsack(A,B,c,existingValue,existingWeight,index+1));
        map.put(innerMap,answer);

        long end = System.currentTimeMillis();
        long elapsedTime = end - start;

        return answer;
    }

    //knapsack
    //above ways are not incorrect , but this is how you should write the recursion code with base case first without thinking about recursion first.
    //going backwards here
    public static int  solveKnapsackRecursionRightWay(ArrayList<Integer> values, ArrayList<Integer> weights, int target , int numberOFItems){

        if(target==0 || numberOFItems==0){
            return 0;
        }

        int inclusive=0;
        if(target-weights.get(numberOFItems-1)>=0){
            inclusive=values.get(numberOFItems-1)+solveKnapsackRecursionRightWay(values,weights,target-weights.get(numberOFItems-1),numberOFItems-1);
        }

        int exlusive=solveKnapsackRecursionRightWay(values,weights,target,numberOFItems-1);

        return Math.max(inclusive,exlusive);
    }


    //memoization of above approach
    public static int  solveKnapsackMemoizationRightWay(ArrayList<Integer> values, ArrayList<Integer> weights, int target , int numberOFItems){

        if(target==0 || numberOFItems==0){
            return 0;
        }

        //we need target+1 columns only
        int[][] matrix=new int[numberOFItems][target+1];

        if(matrix[numberOFItems-1][target]!=0){
            return matrix[numberOFItems-1][target];
        }

        int inclusive=0;
        if(target-weights.get(numberOFItems-1)>=0){
            inclusive=values.get(numberOFItems-1)+solveKnapsackRecursionRightWay(values,weights,target-weights.get(numberOFItems-1),numberOFItems-1);
        }

        int exlusive=solveKnapsackRecursionRightWay(values,weights,target,numberOFItems-1);


        matrix[numberOFItems-1][target]=Math.max(inclusive,exlusive);
        return matrix[numberOFItems-1][target];
    }

    //DP solution - using bottom up dp - using 2d array
    public static int  solveKnapsackBottomUpDPRightWay(ArrayList<Integer> values, ArrayList<Integer> weights, int target , int numberOFItems){

        int[][] matrix=new int[numberOFItems][target+1];

        //first column traverse
        for(int i=0;i<matrix.length;i++){
            //target is 0 , so first column will be 0
            matrix[i][0]=0;
        }

        //first row traverse
        for(int j=0;j<matrix[0].length;j++){
            //if my first weight is less than j(0 to target+1) then value will be of that weight
            if(weights.get(0)<=j){
               matrix[0][j]=values.get(0);
            } else{
                matrix[0][j]=0;
            }
        }   

        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                int val=0;
                if(j-weights.get(i)>=0)
                //inclusive and exclusive max
                val=Math.max(values.get(i) + matrix[i-1][j-weights.get(i)],matrix[i-1][j]);
                else
                   val=matrix[i-1][j];
                matrix[i][j]=val;
            }
        }
        return matrix[numberOFItems-1][target];
    }

}
