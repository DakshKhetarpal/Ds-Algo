package DP;

class CoinChangeDP {
    int min=Integer.MAX_VALUE;
    public static int coinChange(int[] coins, int amount) {
        Integer[] dp=new Integer[amount+1];
        dp[0]=0;
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<coins.length;j++){
                int remainingAmount=i-coins[j];
                if(remainingAmount<0){
                    //do nothing
                }else{
                    if(dp[remainingAmount]==-1){
                        dp[i]=-1;
                    }else{
                        int probableAns=1 + dp[remainingAmount];
                        if(dp[i]==null){
                            dp[i]=1 + dp[remainingAmount];
                        }
                        else if(probableAns<dp[i]){
                            dp[i]=probableAns;
                        }
                    }
                }
            }
            if(dp[i]==null) dp[i]=-1;
        }
        return dp[amount];
    }

    public static void main(String[] args){
        System.out.println(coinChange(new int[]{186,419,83,408},6249));
    }
}
