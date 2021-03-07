public class maximumProfitFromSaleWines {


    public static void main(String args[]){

        int[] input={2,3,5,1,4};
        int[][] dp=new int[5][5];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++)
                dp[i][j]=-1;
        }
        int i=0;
        int j=4;

        System.out.println(calculateMaxProfit(i,j,input,dp,1));
    }

    public static int calculateMaxProfit(int i,int j,int[] input,int[][] dp,int day){

        if(i>j)
            return 0;

        if(dp[i][j]!=-1)
            return dp[i][j];


        int option1=input[i]*day + calculateMaxProfit(i+1,j,input,dp,day+1);
        int option2=input[j]*day + calculateMaxProfit(i,j-1,input,dp,day+1);

        dp[i][j]=Math.max(option1,option2);
        return dp[i][j];
    }
}

// this is memoization approach
