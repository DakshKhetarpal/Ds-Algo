package LeetcodeQuestions;

public class CombinationsOfValidParenthesis {

    public static void findParanthesis(int countOfOpen,int countOfClose,StringBuilder str){

        if(countOfOpen==0 && countOfClose==0){
            System.out.println(str.toString());
            str=new StringBuilder();
            return;
        }

        if(countOfOpen>0){
            findParanthesis(countOfOpen-1,countOfClose,str.append("("));
        }
       else if(countOfClose>0){
            findParanthesis(countOfOpen,countOfClose-1,str.append(")"));
        }
    }

        public static void findParanthesis2(int countOfOpen,int countOfClose,String str){

            if(countOfOpen==0 && countOfClose==0 && str.charAt(0)=='(' && str.charAt(str.length()-1)==')'){
                System.out.println("S"+str.toString());

                return;
            }

            if(countOfOpen>0){
                //also note that first () will be formed after we go into this recursive call as str doesnt change here
                findParanthesis2(countOfOpen-1,countOfClose,str+"(");
            }
            //if there are more open paranthesis added already then only we can add close parenthesis
             if(countOfClose>0 && countOfOpen<countOfClose){
                findParanthesis2(countOfOpen,countOfClose-1,str+")");
            }
    }

    public static void main(String[] args){
        StringBuilder str=new StringBuilder();
        findParanthesis(2,2,str);
        findParanthesis2(3,3,"");

    }
}
