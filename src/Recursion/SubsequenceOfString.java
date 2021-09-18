package Recursion;

//in this question we will pass the answer in every recursive call because we have to print all the cases, there is no one solution and answer till here is essential for other answers as well
public class SubsequenceOfString {

    static void printSubsequence(String str,String answerTillHere){

        //when whole string is traversed and str becomes empty
        if(str.length()==0){
            System.out.println(answerTillHere);
            return;
        }

        //include first character
        printSubsequence(str.substring(1),str.charAt(0)+answerTillHere);
        //dont include first character
        printSubsequence(str.substring(1),answerTillHere);
    }

    public static void main(String[] args){
        String s="ABC";
        printSubsequence(s,"");
    }
    //Time complexity : 2^n
}

