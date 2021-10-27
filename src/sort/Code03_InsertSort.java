package sort;

import sort.base.SortTestHelper;

/**
 * 插入排序
 * 时间复杂度O(n^2) 不稳定
 * 空间复杂度O(1)
 */
public class Code03_InsertSort {

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 目的是0~i上面有序，相当于新拿到一个扑克牌arr[i]，然后滑入已有的手牌
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                swap(arr, j, j - 1);
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
        SortTestHelper.test(Code03_InsertSort::insertSort);
    }
}
