package Recursion;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.HashMap;
import java.util.Map;

public class DecodeVariations {

    static Map<Integer,Character> map = new HashMap();
    static int count;
    static{
        for(int i=0;i<26;i++){
            char c= (char) (65+i);
            map.put(i+1,c);
        }
    }

    public static void decodeVariations(String str,String ans){
        if(str.length()==0){
            count++;
            System.out.println(ans);
            return;
        }

        //taking 1 element
        int mappingInteger=Integer.valueOf(str.substring(0,1));
        Character c=map.get(mappingInteger);
        //reducing input by 1S
        decodeVariations(str.substring(1),ans+c);

        //taking two elements at a time
        if(str.length()>=2){
            mappingInteger=Integer.valueOf(str.substring(0,2));
            c=map.get(mappingInteger);
            if(c!=null){
                //reducing input by 2
                decodeVariations(str.substring(2),ans+c);
            }
        }
    }

    public static void main(String[] args){

        char a= 65;
        decodeVariations("1262","");
        System.out.println(count);
    }
}
