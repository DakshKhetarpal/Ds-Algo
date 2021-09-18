import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//https://leetcode.com/problems/longest-consecutive-sequence/
public class LongestSubsequence {


    public static void main(String[] args){
        LongestSubsequence longestSubsequence=new LongestSubsequence();
        int[] arr={1,0,-1};
        longestSubsequence.longestConsecutive(arr);
    }


    Map<Integer,Integer> map=new HashMap<>();
    public int longestConsecutive(int[] nums) {

        for(int i=0;i<nums.length;i++){
            map.put(nums[i],null);
            if(checkIfPreviousPresent(nums[i])){
                map.put(nums[i]-1,nums[i]);
            }
            if(checkIfNextPresent(nums[i])){
                map.put(nums[i],nums[i]+1);
            }
        }


        System.out.println("Map is "+map);

        int count=1;
        int maxCount=0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            count=1;
            Integer value=entry.getValue();
            if(value==null || value==-1){
                //ignore
            }
            while(value!=null){
                map.put(entry.getKey(),-1);    //so this key doesnt get computed again

                //new key is the current value
                int key=value;
                value=map.get(key);

                count++;
            }

            if(count>maxCount)
                maxCount=count;
        }

        System.out.println(maxCount);
        return 0;

    }

    boolean checkIfPreviousPresent(int currentNum){
        if(map.containsKey(currentNum-1)){
            return true;
        }
        return false;
    }

    boolean checkIfNextPresent(int currentNum){
        if(map.containsKey(currentNum+1)){
            return true;
        }
        return false;
    }
}
