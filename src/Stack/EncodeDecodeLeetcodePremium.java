package Stack;

import java.util.Stack;

public class EncodeDecodeLeetcodePremium {

    /*
    * We make 2 stacks here. One is integer stack and other is string stack.
    * * */
    public static void main(String[] args){
        String str = "2[b2[ca3[pk]]]";
        Stack<Integer> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();

        for(int i=0; i<str.length(); i++) {
            Character character = str.charAt(i);
            int s=character - '0';
            // If it is a number then put into integer stack
            if(s<10){
                stack1.push(s);
            } else {
                // if it is a character then put it into string stack
                stack2.push(String.valueOf(character));
                if(character== ']') {
                    stack2.pop();
                    StringBuilder sb = new StringBuilder();
                    while (!stack2.isEmpty() && !stack2.peek().equals("[")) {
                        sb.append(stack2.peek());
                        stack2.pop();
                    }
                    stack2.pop();
                    StringBuilder sb2 = new StringBuilder();
                    int multiplier= stack1.pop();
                    System.out.println("multiplier is "+multiplier);
                    for(int j=0; j<multiplier; j++){
                        sb2.append(sb);
                        // you can not do sb.append(sb) because this will increase sb exponentially
                    }
                    stack2.push(sb2.toString());
                }
            }
        }

        // reverse all at last
        StringBuilder answer = new StringBuilder();
        System.out.println(answer.append(stack2.pop()).reverse());
    }
}
