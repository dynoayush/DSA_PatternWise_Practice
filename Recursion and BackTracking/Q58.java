// Remove duplicates in a string

public class Q58 {
    public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean map[]){
        if(idx == str.length()){
            System.out.println(newStr);
            return;
        }

        char currChar = str.charAt(idx);
        if(map[currChar-'a'] == true){
            // Duplicate found
            removeDuplicates(str, idx+1, newStr, map);
        } 
        else{ 
            // New Character found 
            map[currChar-'a'] = true;
            removeDuplicates(str, idx+1, newStr.append(currChar), map);
        }
    }
    public static void main(String[] args) {
        String str = "appnnacollege";
        StringBuilder result = new StringBuilder("");
        boolean[] map = new boolean[26];
        removeDuplicates(str, 0, result, map);
    }
}
