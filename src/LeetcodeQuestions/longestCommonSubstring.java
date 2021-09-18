package LeetcodeQuestions;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Arrays;

public class longestCommonSubstring {

    public static int findLengthOFLCS(int[] nums1,int[] nums2){

        if(nums1==null || nums2==null){
            return 0;
        }

        if(nums1.length==0 || nums2.length==0){
            return 0;
        }

        int[][] matrix=new int[nums1.length][nums2.length];

        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(nums1[i] == nums2[j]){
                    if(i!=0 && j!=0){
                        matrix[i][j]=matrix[i-1][j-1]+1;
                    }else{
                        matrix[i][j]=1;
                    }
                    if(matrix[i][j]>max)
                        max=matrix[i][j];
                }
            }
        }

    return max;
    }

    public static void main(String[] args) {
        int[] nums1={8,2,1,4,7};
        int[] nums2={1,2,8,2,1};
        System.out.println(findLengthOFLCS(nums1,nums2));
    }
}