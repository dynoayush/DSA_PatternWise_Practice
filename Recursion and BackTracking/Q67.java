// Letter Combinations of a Phone Number [LC - 17]

import java.util.*;

public class Q67 {
    List<String> result =  new ArrayList<>();
    public List<String> letterCombinations(String digits) {

        if(digits.length() == 0){
            return new ArrayList<>();
        }

        Map<Character, String> mp = new HashMap<>();

        mp.put('2', "abc");
        mp.put('3', "def");
        mp.put('4', "ghi");
        mp.put('5', "jkl");
        mp.put('6', "mno");
        mp.put('7', "pqrs");
        mp.put('8', "tuv");
        mp.put('9', "wxyz");

        String temp = "";
        solve(0,digits, temp, mp);
        return result;
    }

    private void solve(int index, String digits, String temp, Map<Character, String> mp){
        if(index == digits.length()){
            result.add(temp);
            return;
        }

        char ch = digits.charAt(index);
        String str = mp.get(ch);

        for(int i = 0; i < str.length();i++){
            String newTemp = temp + str.charAt(i);
            solve(index + 1, digits, newTemp, mp);
        }
    }

     public static void main(String[] args) {

        Q67 obj = new Q67();
        String digits = "23";
        List<String> ans = obj.letterCombinations(digits);
        System.out.println(ans);
    }
}
