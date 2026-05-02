// Binary String Problem

public class Q59 {
    public static void printBinStrings(int n, int lastPlace, String str){
        // Base Case
        if(n == 0){
            System.out.println(str);
            return;
        } 
        // If the nth or 1st digit is zero then next digits could be zero or 1
        if(lastPlace == 0){
            printBinStrings(n-1, 0, str+"0");
            printBinStrings(n-1, 1, str+"1");
        } 
        // If the nth or 1st digit is one then next digits could be zero only
        else{
            printBinStrings(n-1, 0, str+"0");
        }
    }
    public static void main(String[] args) {
        printBinStrings(3, 0, "");
    }
}
