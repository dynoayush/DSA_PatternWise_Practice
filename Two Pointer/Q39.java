// Valid Palindrome - II [LC - 680]

public class Q39{
    public boolean validPalindromeII(String s){
        int left = 0;
        int right = s.length() - 1;

        while(left<right){
            if(s.charAt(left) != s.charAt(right)){
                return isPalindrome(s,left+1,right) || isPalindrome(s,left,right-1);
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int left,int right){
        while(left<right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
        Q39 sol = new Q39();
        String s1 = "abca";
        System.out.println(sol.validPalindromeII(s1));
    }
}