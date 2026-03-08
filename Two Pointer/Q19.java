// Container with Most Water [LC - 11]

public class Q19 {
    public int maxArea(int[] height){
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while(left<right){
            int width = right - left;
            int h = Math.min(height[left], height[right]);
            int Area = width * h;
            maxArea = Math.max(maxArea, Area);

            if(height[left]< height[right]){
                left++;
            } 
            else{
                right--;
            }
        }
        return maxArea;
    }
    public static void main(String[] args) {
        Q19 sol = new Q19();
        int[] height = {1,8,6,2,5,4,8,3,7};
        int result = sol.maxArea(height);
        System.out.println(result);
    }
}
