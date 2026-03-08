// Move Zeros (LC: 283)

public class Q6 {
    // This would return the number of non-zero elements
    public static void moveZeros(int[] arr){
        int write = 0 ;
        for(int read=0;read<arr.length;read++){
            if(arr[read]!=0){
                arr[write] = arr[read];
                write++;
            }
        }
        // This would move zeros to the end
        for(int i = write;i<arr.length;i++){
            arr[i]=0;
        }
    }
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        moveZeros(arr);
        for (int i = 0; i < arr.length; i++) {
        System.out.print(arr[i] + " ");
    }
}
}
