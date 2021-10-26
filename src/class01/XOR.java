package class01;

import base.Logger;

/**
 * 异或运算
 * 可以理解为无进位相加
 * 0^N=N N^N=0
 * 满足交换律和结合律
 */
public class XOR {

    /**
     * 不开辟额外空间交换两个独立内存的变量
     * 两者可以相等，但是不能是指向同一块内存
     */
    public static void swap() {
        int a = 1;
        int b = 2;
        a = a ^ b; // a=1^2     b=2
        b = a ^ b; // a=1^2     b=1^2^2=1
        a = a ^ b; // a=1^2^1=2 b=1
        Logger.d("a=%d, b=%d", a, b);
    }

    /**
     * 一个数组中有两种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这种数
     * 利用异或的性质
     */
    public static void xor1() {
        int[] arr = {1, 3, 2, 1, 2, 3, 3, 1, 2, 1, 2};
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor = eor ^ arr[i];
        }
        Logger.d("result=%d", eor);
    }

    /**
     * 一个数组中有两种数出现了奇数次，其他数都出现了偶数次，分别找出出现奇数次的数
     */
    public static void xor2() {
        int[] arr = {1, 3, 2, 1, 2, 3, 3, 1, 2, 1, 2, 5, 5, 5};
        // 先找出两种出现奇数次的异或a^b
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor = eor ^ arr[i];
        }
        // 由于a!=b，所以eor!=0，eor至少有一位不等于0
        // 根据最右边一位是否等于0进行分组，就可以求出a或者b
        int eor1 = 0;
        int rightOne = eor & (~eor + 1);
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) != 0) {
                eor1 = eor1 ^ arr[i];
            }
        }
        Logger.d("a=%d, b=%d", eor1, eor ^ eor1);
    }

    public static void main(String[] args) {
        swap();
        xor1();
        xor2();
    }
}
