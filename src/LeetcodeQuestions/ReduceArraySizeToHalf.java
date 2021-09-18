package LeetcodeQuestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReduceArraySizeToHalf {

    public static void main(String[] args){
        int[] arr={3,3,3,3,5,5,5,2,2,7};
        System.out.println(minSetSize(arr));
    }

    static int minSetSize(int[] arr) {
        Map<Integer,Integer> map=new HashMap();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        int[] frequencyOfEveryNumber = new int[map.size()];
        int i=0;
        for(int frequency:map.values()){
            frequencyOfEveryNumber[i]=frequency;
            i++;
        }
        Arrays.sort(frequencyOfEveryNumber);

        int half=arr.length/2;
        int removed=0;
        int ans=0;
        for(i=frequencyOfEveryNumber.length-1;i>=0;i--){
            if(removed<half){
                removed=frequencyOfEveryNumber[i]+removed;
                ans++;
            }else
                break;
        }
        return ans;
    }

}

