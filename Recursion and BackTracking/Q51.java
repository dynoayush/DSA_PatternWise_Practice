// Print numbers from n to 1 (Decreasing Order)

public class Q51 {
    public static void recursive(int n){
        if(n == 1){
            System.out.println(n);
            return;
        }
        System.out.print(n + " ");
        recursive(n-1);
    }
    public static void main(String[] args) {
        int n = 10;
        recursive(n);
    }
}
