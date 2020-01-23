package RotateImage;

class Solution {
    public void rotate(int[][] matrix) {
        int top  = 0;
        int bottom = matrix.length - 1;
        while(top < bottom){
            int[] temp = matrix[top];
            matrix[top] = matrix[bottom];
            matrix[bottom] = temp;
            top++;
            bottom--;
        }

        for(int i = 0; i< matrix.length; i++){
            for(int j = i + 1;  j < matrix[0].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}