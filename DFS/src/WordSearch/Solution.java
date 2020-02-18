package WordSearch;

class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(search(i,j,0,word,board)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(int i, int j, int index, String word, char[][] board){
        if(index == word.length()) return true;
        if(i < 0 || i > board.length - 1 ||
                j < 0 || j > board[0].length - 1 ||
                board[i][j] != word.charAt(index)){
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '*';
        boolean found = search(i + 1, j, index + 1, word, board) ||
                search(i - 1, j, index + 1, word, board) ||
                search(i, j + 1, index + 1, word, board) ||
                search(i, j - 1, index + 1, word, board);
        board[i][j] = temp;
        return found;
    }
}