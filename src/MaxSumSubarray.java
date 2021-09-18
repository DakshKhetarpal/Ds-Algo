public class MaxSumSubarray {

    public static void main(String[] args){
        int[] arr={-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(findMaxSum(arr));
    }

    public static int findMaxSum(int[] arr){

        int currentSum=0,maxSum=0;
        int start=0,end=0;
        for(int i=0;i<arr.length;i++){
            currentSum=currentSum+arr[i];
            //end=i;
            if(currentSum<0){
                currentSum=0;
                start=i+1;
            }
            if(currentSum>maxSum){
                maxSum=currentSum;
                end=i;
            }
        }
        start=start+1;
        System.out.println("start"+start+" end"+end);
        return maxSum;
    }
}
