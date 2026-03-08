// Duplicate Zeros [LC - 1089]

public class Q38 {
    public void duplicateZeros(int[] arr) {
        int countZero = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == 0){
                countZero++;
            }
        }
        int n = arr.length;
        int i = n - 1;
        int j = n - 1 + countZero;

        while(i>=0){
            if(j<n){
                arr[j] = arr[i];
            }
            if(arr[i] == 0){
                j--;
                if(j<n){
                    arr[j] = 0;
                }
            }
            i--;
            j--;
        }
    }
    public static void main(String[] args) {
        Q38 sol = new Q38();
        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
        sol.duplicateZeros(arr);
        for(int ans:arr){
            System.out.print(ans + " ");
        }

    } 
}
