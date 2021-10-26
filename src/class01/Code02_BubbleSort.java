package class01;

import class01.base.SortTestHelper;

/**
 * 冒泡排序
 * 时间复杂度O(n^2) 稳定
 * 空间复杂度O(1)
 */
public class Code02_BubbleSort {

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 0~N-1 完成一轮冒泡，共比较N-1次
        // 0~N-2 完成一轮冒泡，共比较N-2次
        // ...
        // 等差数列求和，所以时间复杂度是O(n^2)
        for (int e = arr.length - 1; e > 0; e--) {
            for (int i = 0; i < e; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        // 确保i和j是独立的内存空间，否则都会被抹成0
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        SortTestHelper.test(Code02_BubbleSort::bubbleSort);
    }
}
