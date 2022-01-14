package leetcode;

import java.util.Arrays;

/**
 * 合并两个有序数组
 * 数组 + 双指针 + 排序
 * @author yw
 */
public class LeetCode88 {

    //总结：
    // 时间复杂度：merge1、merge2、merge3、merge4为O(m+n)，merge为O(m+n)
    // 空间复杂度：merge1、merge2、merge3、merge4为O(m+n)，merge为O(1)

    //推荐写法：
    //如果空间复杂度可以为O(m+n)，可以考虑merge1、merge3；
    //如果空间复杂度为O(1)，那么只有merge

    //双指针法：i>=0 || j>=0，两个指针都从右向左遍历，这样每次比较就将较大的值放到nums1的最右边（nums1的后半部分可以直接覆盖），
    // 这样就可以做到不使用临时空间，而不覆盖nums1中的值（这个可以证明）。

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // [1,2,3,0,0,0]    [2,5,6]
        int i=m-1,j=n-1,k=m+n-1;
        int cur;
        while (i>=0 || j>=0) {
            if (i == -1) {
                cur = nums2[j--];
            } else if (j == -1) {
                cur = nums1[i--];
            } else if (nums1[i] >= nums2[j]) {
                cur = nums1[i--];
            } else {
                cur = nums2[j--];
            }
            nums1[k--] = cur;
        }
    }

    // merge3的另一种写法：同样不使用k变量计数，个人同样感觉不清楚

    public static void merge4(int[] nums1, int m, int[] nums2, int n) {
        // [1,2,3,0,0,0]    [2,5,6]
        int[] tmp = new int[m+n];
        int i=0,j=0;
        int cur;
        while (i< m || j<n) {
            if (i == m) {
                cur = nums2[j++];
            } else if (j == n) {
                cur = nums1[i++];
            } else if (nums1[i] <= nums2[j]) {
                cur = nums1[i++];
            } else {
                cur = nums2[j++];
            }
            tmp[i+j-1] = cur;
        }

        for (int k =0; k< m+n; k++) {
            nums1[k] = tmp[k];
        }
    }

    // 双指针法：i< m || j<n，只要两个数组有一个没结束就继续找较小的值（但要考虑一个数组结束的情况）

    public static void merge3(int[] nums1, int m, int[] nums2, int n) {
        // [1,2,3,0,0,0]    [2,5,6]
        int[] tmp = new int[m+n];
        int i=0,j=0,k=0;
        int cur;
        while (i< m || j<n) {
            if (i == m) {
                cur = nums2[j++];
            } else if (j == n) {
                cur = nums1[i++];
            } else if (nums1[i] <= nums2[j]) {
                cur = nums1[i++];
            } else {
                cur = nums2[j++];
            }
            tmp[k++] = cur;
        }

        for (k =0; k< m+n; k++) {
            nums1[k] = tmp[k];
        }
    }

    // merge1的另一种写法：不使用k变量计数，个人感觉更不清楚

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = new int[m+n];
        int i=0,j=0;
        while (i< m && j<n) {
            if (nums1[i] <= nums2[j]) {
                tmp[i+j] = nums1[i++];
            } else {
                tmp[i+j] = nums2[j++];
            }
        }

        while (j<n) {
            tmp[i+j] = nums2[j++];
        }

        while (i < m) {
            tmp[i+j] = nums1[i++];
        }

        for (int k =0; k< m+n; k++) {
            nums1[k] = tmp[k];
        }
    }

    // 双指针法：i<m && i<n，当两个数组都未结束时（不用考虑有一个数组结束的情况），否则将未结束数组直接放到临时数组的后边即可

    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = new int[m+n];
        int i=0,j=0,k=0;
        while (i< m && j<n) {
            if (nums1[i] <= nums2[j]) {
                tmp[k++] = nums1[i++];
            } else {
                tmp[k++] = nums2[j++];
            }
        }

        // 优化：可以去掉外层的if判断
        if (i == m) {
            while (j<n) {
                tmp[k++] = nums2[j++];
            }
        }

        // 优化：同理
        if (j == n) {
            while (i < m) {
                tmp[k++] = nums1[i++];
            }
        }

        for (k =0; k< m+n; k++) {
            nums1[k] = tmp[k];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1,3,nums2,3);
        System.out.println(Arrays.toString(nums1));
    }
}
