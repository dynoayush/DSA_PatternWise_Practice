// First Bad Version [LC - 278]

class VersionControl {
    int firstBad = 6;   
    
    boolean isBadVersion(int version) {
        if (version >= firstBad) {
            return true;
        } 
        else {
            return false;
        }
    }
}

public class Q43 extends VersionControl {

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                right = mid - 1;      
            } else {
                left = mid + 1;   
            }
        }

        return left;
    }

    public static void main(String[] args) {
        Q43 obj = new Q43();
        int n = 7;

        System.out.println("First bad version: " + obj.firstBadVersion(n));
    }
}