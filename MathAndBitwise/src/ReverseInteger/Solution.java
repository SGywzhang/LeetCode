package ReverseInteger;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

class Solution {
    public static int reverse(int x) {
        long res = 0;
        while(x != 0){
            res = res * 10 + x % 10;
            x /= 10;
            if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE){
                return 0;
            }
        }
        return (int)res;
    }

    public static boolean isPalindrome(int x) {
        if(x < 0) return false;
        int temp = 0;
        while(x != 0){
            temp = temp * 10 + x % 10;
            x/=10;
        }

        System.out.println(temp);

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(reverse(121));
    }
}