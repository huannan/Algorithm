package class01;

import class01.base.SortTestHelper;

/**
 * 选择排序
 * 时间复杂度O(n^2) 稳定
 * 空间复杂度O(1)
 */
public class Code01_SelectionSort {

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // i~N-1上面找最小值，然后放到i位置上
        // 0~N-1 N次
        // 1~N-1 N-1次
        // 2~N-1 N-2次
        // ...
        // 等差数列求和，所以时间复杂度是O(n^2)
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        SortTestHelper.test(Code01_SelectionSort::selectionSort);
    }
}
