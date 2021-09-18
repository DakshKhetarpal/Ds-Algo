package LeetcodeQuestions;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {

        boolean[][] dp = new boolean[s.length()][s.length()];
        int len=0;
        String substring="";
        for(int gap=0;gap<s.length()-1;gap++){
            for(int i=0,j=0;j<dp.length;j++,i++){
                if(gap==0){
                    dp[i][j]=true;
                }

                if(gap==1){
                    if(s.charAt(i)==s.charAt(j))
                        dp[i][j]=true;
                    else
                        dp[i][j]=false;
                }

                if(gap>1){
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1])
                        dp[i][j]=true;
                    else
                        dp[i][j]=false;
                }

                if(dp[i][j]){
                    len=gap+1;
                    substring=s.substring(i,j+1);
                }

            }
        }

        return substring;
    }
}


