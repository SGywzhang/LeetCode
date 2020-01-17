package Queen8;

import java.util.ArrayList;
import java.util.List;

class Solution {

    int max;
    int[] arr;
    int count;
    List<List<String>> res = new ArrayList<>();
    public int totalNQueens(int n) {
        max = n;
        arr = new int[max];
        start(0);
        return count;
    }

    public List<List<String>> solveNQueens(int n) {
        max = n;
        arr = new int[max];
        start(0);
        return res;
    }

    public void start(int n){
        if(n == max){
            res.add(getTempRes());
            count++;
            return;
        }

        for(int i = 0; i < max; i++){
            arr[n] = i;
            if(check(n)){
                start(n+1);
            }
        }
    }

    public boolean check(int n){

        for(int i = 0; i < n; i++){
            if(arr[n] == arr[i] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])){
                return false;
            }
        }
        return true;
    }

    public List<String> getTempRes(){
        StringBuilder sb;
        List<String> res = new ArrayList<>();
        for(int a : arr){
            sb = new StringBuilder();
            for(int i = 0; i < max; i++){
                if(i==a){
                    sb.append("Q");
                }
                else{
                    sb.append(".");
                }
            }
            res.add(sb.toString());
        }
        return res;
    }
}
