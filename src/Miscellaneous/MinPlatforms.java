package Miscellaneous;

import java.util.Arrays;

//https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/

/**
 * both arrays are sorted and then minimum of these two arrays is found and conditions applied accordingly.
 */
public class MinPlatforms {

    static int findPlatform(int arr[],int dep[],int n){

        Arrays.sort(arr);
        Arrays.sort(dep);
        int maxPlatform=0;
        int platformsNeededCurrently=0;
        int j=0,i=0;
        while(i<n && j<n){

            if(j==n && i<n){
                platformsNeededCurrently++;
                i++;
            }
            else if(i==n && j<n){
                platformsNeededCurrently--;
                j++;
            }
            else if(arr[i]<=dep[j]) {
                platformsNeededCurrently++;
                i++;
            }else if(arr[i]>dep[j]){
                platformsNeededCurrently--;
                j++;
            }

            if(maxPlatform<platformsNeededCurrently)
                maxPlatform=platformsNeededCurrently;
        }

        return maxPlatform;
    }


    public static void main(String[] args)
    {
        int arr[] = { 900, 940};
        int dep[] = { 910, 1200};
        int n = arr.length;
        System.out.println("Minimum Number of Platforms Required = "
                + findPlatform(arr, dep, n));
    }
}
