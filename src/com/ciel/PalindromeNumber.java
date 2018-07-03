class Solution {
    public boolean isPalindrome(int x) {
        /*
        * 参考：https://leetcode-cn.com/articles/palindrome-number/
        * 我们如何知道反转数字的位数已经达到原始数字位数的一半？
        * 我们将原始数字除以 10，然后给反转后的数字乘上 10，所以，当原始数字小于反转后的数字时，就意味着我们已经处理了一半位数的数字。
        */
        
        // 1. 负数必然不是回文数
    	// 2. 如果数字的最后一位是 0，为了使该数字为回文，则其第一位数字也应该是 0.只有 0 满足这一属性
        if(x < 0 || (x % 10 == 0 && x != 0))
            return false;
        
        int reverse = 0;
        // 判断是否反转了一半的数字：当原始数字小于反转后的数字时，就意味着我们已经处理了一半位数的数字
        while(x > reverse){
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        
        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return reverse == x || x == reverse / 10;
    }
}