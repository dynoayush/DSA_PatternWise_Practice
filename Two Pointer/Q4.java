// Remove duplicate elements from a sorted array

public class Q4 {
    public static int removeDuplicates (int[] arr){
        if (arr.length == 0) return 0;
        int write = 0;
        for(int read = 1;read< arr.length;read++){
            if(arr[read]!= arr[write]){
                write++;
                arr[write] = arr[read];
            }
        }
        return write+1;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 4, 4};
        removeDuplicates(arr);
        int result = removeDuplicates(arr);
        for (int i = 0; i < result; i++) {
        System.out.print(arr[i] + " ");
    }
}
}
