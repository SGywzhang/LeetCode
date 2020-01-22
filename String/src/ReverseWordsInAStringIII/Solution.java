package ReverseWordsInAStringIII;

class Solution {
    public String reverseWords(String s) {

        String[] strArr = s.split(" ");

        StringBuilder sb = new StringBuilder();

        for(String ss : strArr){

            sb.append(helper(ss));
            sb.append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    public String helper(String s){

        char[] ch = s.toCharArray();

        char temp = ' ';

        for(int i = 0; i< ch.length/2; i++){

            temp = ch[i];

            ch[i] = ch[ch.length - 1 - i];

            ch[ch.length - 1 - i] = temp;
        }

        return String.valueOf(ch);
    }
}