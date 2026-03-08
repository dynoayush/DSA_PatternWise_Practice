// Largest element in the array

public class Q1 {
    public static int findLargest(int[] arr) {
        int max = arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
        int[] arr = {3, 7, 2, 9, 1};
        int result = findLargest(arr);
        System.out.println("Largest element: " + result);
    }
}