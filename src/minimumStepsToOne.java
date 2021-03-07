public class minimumStepsToOne {
    // number can be subtracted by 1, divided by 2, divided by 3s

    public static void main(String[] args){
        int n=10;
        int arr[]=new int[n+1];
        arr[0]=0; // steps to reach 0 is 0
        arr[1]=0; // steps to reach 1 is 0
        for(int i=2;i<=10;i++){
            arr[i]=1+arr[i-1];

            if(i%2==0)
                arr[i]=Math.min(arr[i],1+arr[i/2]);

            if(i%3==0)
                arr[i]=Math.min(arr[i],1+arr[i/3]);

            System.out.println("minimum steps to "+i+" is "+arr[i]);
        }
    }
}

// this solution has been implemented using tabulation(bottom up) , for memoization(top down) see the dp notes
