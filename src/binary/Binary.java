package binary;

import base.Logger;

/**
 * 二分法
 * 时间复杂度O((logn)) 实质上就是砍半多少次的问题
 * 空间复杂度O(1)
 */
public class Binary {

    /**
     * 有序数组二分查找
     */
    public static boolean binarySearch(int[] arr, int num) {
        if (null == arr || arr.length == 0) {
            return false;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (arr[middle] == num) {
                return true;
            } else if (arr[middle] > num) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return false;
    }

    /**
     * 有序数组中寻找大于等于目标值最左侧位置
     */
    public static int binarySearchLeft(int[] arr, int num) {
        if (null == arr) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        int index = -1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (arr[middle] >= num) {
                index = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return index;
    }

    /**
     * 无序数组中查找局部最小
     * 给定一任意相邻元素不重复的无序数组，找到其中任意一个局部最小值
     * 注：局部最小值的定义为该位置的元素小于其左右两个元素，对于首元素，只需小于后一个，尾元素小于前一个即可
     */
    public static int binarySearchMiddle(int[] arr) {
        if (null == arr || arr.length < 2) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        if (arr[left] < arr[left + 1]) {
            return left;
        }
        if (arr[right] < arr[right - 1]) {
            return right;
        }
        while (left <= right) {
            int middle = (left + right) / 2;
            if (arr[middle] < arr[middle - 1] && arr[middle] < arr[middle + 1]) {
                return middle;
            } else if (arr[middle] < arr[middle - 1]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Logger.d("binarySearch result=%s", binarySearch(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 8, 9, 10}, 2));
        Logger.d("binarySearchLeft result=%d", binarySearchLeft(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 8, 8, 9, 10}, 8));
        Logger.d("binarySearchMiddle result=%d", binarySearchMiddle(new int[]{10, 9, 2, 1, 3, 7, 8, 9, 10}));
    }
}
