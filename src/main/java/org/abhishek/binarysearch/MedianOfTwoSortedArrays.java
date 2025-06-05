package org.abhishek.binarysearch;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {


    public static double findMedianSortedArraysByBs(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        if (m > n) {
            return findMedianSortedArraysByBs(nums2, nums1);
        }

        int start = 0;
        int end = m;
        int leftPartition = (m + n + 1) >>> 1;

        while (start <= end) {

            int midM = (start + end) >>> 1;
            int midN = leftPartition - midM;


            int maxLeftM = midM == 0 ? Integer.MIN_VALUE : nums1[midM - 1];
            int maxLeftN = midN == 0 ? Integer.MIN_VALUE : nums2[midN - 1];
            int minRightM = midM == m ? Integer.MAX_VALUE : nums1[midM];
            int minRightN = midN == n ? Integer.MAX_VALUE : nums2[midN];

            if (maxLeftM <= minRightN && maxLeftN <= minRightM) {

                if ((m + n) % 2 == 0) {
                    return ((double) Math.max(maxLeftN, maxLeftM) + Math.min(minRightM, minRightN)) / 2.0;
                }
                return Math.max(maxLeftN, maxLeftM);
            } else if (maxLeftM > minRightN) {
                end = midM - 1;
            } else {
                start = midM + 1;
            }
        }
        return 0.0;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] num = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, num, 0, nums1.length);
        System.arraycopy(nums2, 0, num, nums1.length, nums2.length);

        int mid = (num.length - 1) / 2;
        Arrays.sort(num);
        if (num.length % 2 == 0) {
            return (num[mid] + num[mid + 1]) * 1.0 / 2.0;
        } else {
            return num[mid] * 1.0;
        }

    }


    public static void main(String[] args) {

        int[] nums1 = {3, 4};
        int[] nums2 = {1, 2};

        //System.out.println(findMedianSortedArrays(nums1, nums2));
        System.out.println(findMedianSortedArraysByBs(nums1, nums2));
    }

}
