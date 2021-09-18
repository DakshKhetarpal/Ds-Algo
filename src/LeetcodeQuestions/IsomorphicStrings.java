package LeetcodeQuestions;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/isomorphic-strings/
public class IsomorphicStrings {

    public static boolean isIsomorphic(String s, String t) {

        if(s==null || t==null)
            return false;

        if(s.length()!=t.length())
            return false;

        char[] s1=s.toCharArray();
        char[] t1=t.toCharArray();

        Map<Character,Character> map=new HashMap<>();
        Map<Character,Character> mapValues=new HashMap<>();

        for(int i=0;i<s1.length;i++){
            if(map.containsKey(s1[i])){
                s1[i]=map.get(s.charAt(i));
            } else if(s1[i]==t1[i]){
                if(!mapValues.containsKey(t.charAt(i))){
                    map.put(s.charAt(i),t.charAt(i));
                    mapValues.put(t.charAt(i),s.charAt(i));
                }else{
                    s1[i]=mapValues.get(t.charAt(i));
                }
            } else if(s1[i]!=t1[i]){
                if(!mapValues.containsKey(t.charAt(i))){
                    map.put(s.charAt(i),t.charAt(i));
                    mapValues.put(t.charAt(i),s.charAt(i));
                    s1[i]=t1[i];
                }
            }
        }

        s=String.valueOf(s1);
        t=String.valueOf(t1);

        if(s.equals(t))
            return true;
        else
            return false;
    }

    public static void main(String[] args){
        String s="egg";
        s.replace('e','t');
        isIsomorphic("egcd","adfd");
    }

}
