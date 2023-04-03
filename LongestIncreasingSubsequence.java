package SIMPLILEARN.assignmentsSelflearningVideo.findingLongestIncreasingSubsequence;

import java.util.Arrays;
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 0, 6, 2, 3};
        int[] lis = longestIncreasingSubsequence(nums);
        System.out.println("Longest increasing subsequence: " + Arrays.toString(lis));
    }

        public static int[] longestIncreasingSubsequence(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            int[] pre = new int[n];
            int len = 0;
            int end = 0;
            for (int i = 0; i < n; i++) {
                int j = Arrays.binarySearch(dp, 0, len, nums[i]);
                if (j < 0) {
                    j = -(j + 1);
                }
                dp[j] = nums[i];
                pre[i] = j > 0 ? pre[j - 1] : -1;
                if (j == len) {
                    len++;
                    end = i;
                }
            }
            int[] lis = new int[len];
            for (int i = end; i >= 0; i = pre[i]) {
                lis[--len] = nums[i];
            }
            return lis;
        }

    }

