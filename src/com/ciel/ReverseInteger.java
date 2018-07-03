package com.ciel;

class Solution {
    public int reverse(int x) {
        /*
        *参考：https://blog.csdn.net/yxb09501bin/article/details/53202263
        *利用求余法一步一步反转整数
        *这里要注意对溢出的判断，如123456789反转987654321，溢出
        */
        
        long result = 0; // 利用long定义result，防止发生溢出
        
        // step1. 正负号最后判断，先取绝对值
        int tmp = Math.abs(x);
        // step2. 求余，步步反转
        while (tmp > 0) {
            result = result * 10 + tmp % 10;
            
            // 判断result是否超过最大值
            if(result > Integer.MAX_VALUE)
                return 0;
            
            tmp = tmp / 10;
        }
        // step3. 判断正负，并注意返回int型
        return (int)(x>=0 ? result : -result);
    }
}