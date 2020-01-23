package DiagonalTraverse;

class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return new int[]{};
        int n = matrix.length;
        int m = matrix[0].length;
        int[] res = new int[n * m];
        int i = 0;
        int j = 0;
        for(int k = 0; k < n * m; k++){
            res[k] = matrix[i][j];
            if((i + j) % 2 == 0){
                if(j == m -1){
                    i++;
                }
                else if(i == 0){
                    j++;
                }
                else{
                    i--;
                    j++;
                }
            }
            else{
                if(i == n -1){
                    j++;
                }
                else if(j == 0){
                    i++;
                }
                else{
                    j--;
                    i++;
                }
            }
        }
        return res;
    }
}