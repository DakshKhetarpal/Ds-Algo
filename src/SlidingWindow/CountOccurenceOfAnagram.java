//package SlidingWindow;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class CountOccurenceOfAnagram {
//    final static int MAX_CHAR = 256;
//
//    // Function to find if two strings are equal
//    static boolean isCountZero(int[] count)
//    {
//        for (int i = 0; i < MAX_CHAR; i++)
//            if (count[i] != 0)
//                return false;
//        return true;
//    }
//
//    static int countAnagrams(String text, String pattern)
//    {
//        int k = pattern.length();
//
//        int[] count = new int[MAX_CHAR];
//        Map mapOfLettersInWord=new HashMap<String,Integer>();
//
//        for (int i = 0; i < k; i++){
//            count[pattern.charAt(i)]++;
//            mapOfLettersInWord.put(pattern.charAt(i),count[pattern.charAt(i)]);
//        }
//
//        int i=0;
//        int j=0;
//        while(j<text.length()){
//
//            if(mapOfLettersInWord.get(text.charAt(j))!=null && count<1){
//                count[text.charAt(j)]--;
//            }
//
//            if(mapOfLettersInWord.get(text.charAt(j))==null){
//                count[text.charAt(j)]++;
//            }
//
//
//
//            if(i-j+1==k){
//
//            }
//
//
//            j++;
//        }
//
//        for (int i = 0; i < text.length(); i++) {
//
//            if(i-j+1)
//
//            // Add last character of current
//            // window
//            count[text.charAt(i)]++;
//
//            // Remove first character of previous
//            // window.
//            count[text.charAt(i - n)]--;
//
//            // If count array is 0, we found an
//            // anagram.
//            if (isCountZero(count))
//                res++;
//        }
//        return res;
//    }
//
//    // Driver code
//    public static void main(String args[])
//    {
//        String text = "fxrxxorfxdofr";
//        String word = "for";
//        System.out.print(countAnagrams(text, word));
//    }
//}
