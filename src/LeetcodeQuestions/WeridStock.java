package LeetcodeQuestions;

import java.util.*;

public class WeridStock {

    private static int getMinNumOfDays(int n, int m) {
        Map<Integer, Boolean> map = new HashMap<>();
        Queue q = new LinkedList<>();
        q.add(new Pair(n, 0));
        while(!q.isEmpty()) {
            Pair poppedPair = (Pair) q.poll();
            int poppedVal = poppedPair.val;
            if(poppedVal == m) {
                return poppedPair.days;
            }
            if(!map.containsKey(poppedVal)) {
                q.add(new Pair(poppedVal * 2, poppedPair.days + 1));
                q.add(new Pair(poppedVal - 1, poppedPair.days + 1));
                map.put(poppedVal, true);
            }
        }
// Usually we never reach here.
        return -1;
    }

    public  static  void main(String[] args){
        System.out.println( getMinNumOfDays(3,4));
    }
}

class Pair {
    int val;
    int days;

    Pair(int v, int d) {
        this.val = v;
        this.days = d;
    }
}
