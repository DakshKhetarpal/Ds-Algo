import java.util.Stack;

public class RemoveDuplicates {

    public static void main(String[] args){
        String s="acaaabbbacdddd";
        String str=remove(s);
        System.out.println(str);
    }

    public static String remove(String s){

        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            Character c=s.charAt(i);
            if(!stack.isEmpty()){
                if(stack.peek()==c){
                    if(i<s.length()-1 && s.charAt(i+1)!=c){
                        stack.pop();
                    }
                    else{
                            stack.pop();
                            if(i!=s.length()-1)
                             stack.push(c);
                        }
                    }else{
                    stack.push(c);
                }
                }else{
                    stack.push(c);
                }
            }
        System.out.println(stack);
        String str="";
//        for(int i=0;i<stack.size();i++){
//            str=str+stack.peek();
//            stack.pop();
//        }

 //       String str="";
        String short_String="";
        while (!stack.isEmpty())
        {
            short_String = stack.peek() +
                    short_String;
            stack.pop();
        }
        return short_String;
    }
}
