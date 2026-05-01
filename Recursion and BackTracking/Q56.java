// First Occurance

public class Q56 {
    public static int firstoccur(int[] arr, int i, int key){
        if(i == arr.length){
            return -1;
        }
        if(arr[i] == key){
            return i;
        }
        return firstoccur(arr, i+1, key);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,4,5,9,8};
        System.out.println(firstoccur(arr, 0, 10));
    }
}
