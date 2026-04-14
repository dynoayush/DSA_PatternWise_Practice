// Print numbers from n to 1 (increasing order)

public class Q52 {
    public static void increcursive(int n){
        if(n==1){
            System.out.print(n+" ");
            return;
        }
        increcursive(n-1);
        System.out.print(n+" ");
    }
    public static void main(String[] args) {
        int n = 5;
        increcursive(n);
    }
}
